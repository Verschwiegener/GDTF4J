package de.verschwiegener.gdtf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Reads a zip archive from memory through its central directory. Unlike {@link java.util.zip.ZipInputStream}
 * this also handles stored entries with a data descriptor, which some GDTF exporters write, and knows all sizes
 * before unpacking.
 */
final class ZipArchive {

	private static final int LOCAL_HEADER = 0x04034b50;
	private static final int CENTRAL_HEADER = 0x02014b50;
	private static final int END_OF_CENTRAL_DIRECTORY = 0x06054b50;
	private static final int STORED = 0;
	private static final int DEFLATED = 8;

	private ZipArchive() {
	}

	/**
	 * @param maxSize Maximum sum of the unpacked sizes
	 * @return Content of all files by their path, directories are left out
	 * @throws GdtfException if the data is no zip archive or uses features that are not supported (ZIP64,
	 *                       encryption, other compression methods)
	 */
	static Map<String, byte[]> read(byte[] zip, long maxSize) throws GdtfException {
		ByteBuffer buffer = ByteBuffer.wrap(zip).order(ByteOrder.LITTLE_ENDIAN);
		int end = findEndOfCentralDirectory(buffer);
		int entries = Short.toUnsignedInt(buffer.getShort(end + 10));
		long directoryOffset = Integer.toUnsignedLong(buffer.getInt(end + 16));
		if (entries == 0xffff || directoryOffset == 0xffffffffL)
			throw new GdtfException("ZIP64 archives are not supported");

		Map<String, byte[]> files = new LinkedHashMap<>();
		long total = 0;
		int position = (int) directoryOffset;
		for (int i = 0; i < entries; i++) {
			check(position + 46 <= zip.length && buffer.getInt(position) == CENTRAL_HEADER, "Broken zip directory");
			int flags = Short.toUnsignedInt(buffer.getShort(position + 8));
			int method = Short.toUnsignedInt(buffer.getShort(position + 10));
			long compressedSize = Integer.toUnsignedLong(buffer.getInt(position + 20));
			long size = Integer.toUnsignedLong(buffer.getInt(position + 24));
			int nameLength = Short.toUnsignedInt(buffer.getShort(position + 28));
			int extraLength = Short.toUnsignedInt(buffer.getShort(position + 30));
			int commentLength = Short.toUnsignedInt(buffer.getShort(position + 32));
			long localOffset = Integer.toUnsignedLong(buffer.getInt(position + 42));
			check(position + 46 + nameLength <= zip.length, "Broken zip directory");
			String name = new String(zip, position + 46, nameLength, StandardCharsets.UTF_8);
			position += 46 + nameLength + extraLength + commentLength;

			if (name.endsWith("/"))
				continue;
			if ((flags & 1) != 0)
				throw new GdtfException("Encrypted zip entry " + name + " is not supported");
			if (compressedSize == 0xffffffffL || size == 0xffffffffL || localOffset == 0xffffffffL)
				throw new GdtfException("ZIP64 archives are not supported");
			total += size;
			if (total > maxSize)
				throw new GdtfException("Archive is larger than " + maxSize + " bytes unpacked");

			check(localOffset + 30 <= zip.length && buffer.getInt((int) localOffset) == LOCAL_HEADER,
					"Broken zip entry " + name);
			int localNameLength = Short.toUnsignedInt(buffer.getShort((int) localOffset + 26));
			int localExtraLength = Short.toUnsignedInt(buffer.getShort((int) localOffset + 28));
			long dataStart = localOffset + 30 + localNameLength + localExtraLength;
			check(dataStart + compressedSize <= zip.length, "Zip entry " + name + " is truncated");

			files.put(name, switch (method) {
			case STORED -> {
				check(compressedSize == size, "Broken zip entry " + name);
				byte[] data = new byte[(int) size];
				System.arraycopy(zip, (int) dataStart, data, 0, (int) size);
				yield data;
			}
			case DEFLATED -> inflate(zip, (int) dataStart, (int) compressedSize, (int) size, name);
			default -> throw new GdtfException("Zip entry " + name + " uses unsupported compression " + method);
			});
		}
		return files;
	}

	private static byte[] inflate(byte[] zip, int start, int length, int size, String name) throws GdtfException {
		Inflater inflater = new Inflater(true);
		try {
			inflater.setInput(zip, start, length);
			byte[] data = new byte[size];
			int read = 0;
			while (read < size) {
				int n = inflater.inflate(data, read, size - read);
				if (n == 0 && (inflater.finished() || inflater.needsInput() || inflater.needsDictionary()))
					break;
				read += n;
			}
			check(read == size, "Zip entry " + name + " is broken");
			return data;
		} catch (DataFormatException e) {
			throw new GdtfException("Zip entry " + name + " is broken: " + e.getMessage(), e);
		} finally {
			inflater.end();
		}
	}

	private static int findEndOfCentralDirectory(ByteBuffer buffer) throws GdtfException {
		int last = buffer.limit() - 22;
		int first = Math.max(0, last - 0xffff);
		for (int position = last; position >= first; position--) {
			if (buffer.getInt(position) == END_OF_CENTRAL_DIRECTORY)
				return position;
		}
		throw new GdtfException("Not a zip archive");
	}

	private static void check(boolean condition, String message) throws GdtfException {
		if (!condition)
			throw new GdtfException(message);
	}

}
