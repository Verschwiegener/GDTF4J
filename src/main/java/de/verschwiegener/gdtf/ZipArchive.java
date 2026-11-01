package de.verschwiegener.gdtf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * A zip archive in memory, read through its central directory. Unlike {@link java.util.zip.ZipInputStream} this
 * also handles stored entries with a data descriptor, which some GDTF exporters write, and knows all sizes before
 * unpacking.
 * <p>
 * Entries are only unpacked when they are read, so large 3D models nobody asks for cost nothing. Immutable and
 * thread safe.
 */
final class ZipArchive {

	private static final int LOCAL_HEADER = 0x04034b50;
	private static final int CENTRAL_HEADER = 0x02014b50;
	private static final int END_OF_CENTRAL_DIRECTORY = 0x06054b50;
	private static final int STORED = 0;
	private static final int DEFLATED = 8;
	private static final Charset CP437 = Charset.isSupported("IBM437") ? Charset.forName("IBM437")
			: StandardCharsets.ISO_8859_1;

	/**
	 * Position of an entry's data in the archive, already checked against the archive bounds
	 */
	private record Entry(int method, int dataStart, int compressedSize, int size) {
	}

	private final byte[] zip;
	private final Map<String, Entry> entries;

	private ZipArchive(byte[] zip, Map<String, Entry> entries) {
		this.zip = zip;
		this.entries = entries;
	}

	/**
	 * Reads the directory and checks all entries, without unpacking them
	 *
	 * @param zip     The archive, must not be changed afterwards
	 * @param maxSize Maximum sum of the unpacked sizes
	 * @throws GdtfException if the data is no zip archive or uses features that are not supported (ZIP64,
	 *                       encryption, other compression methods)
	 */
	static ZipArchive open(byte[] zip, long maxSize) throws GdtfException {
		try {
			return new ZipArchive(zip, readDirectory(zip, maxSize));
		} catch (IndexOutOfBoundsException | NegativeArraySizeException e) {
			// a broken or crafted archive must never look like an internal error
			throw new GdtfException("Broken zip archive: " + e.getMessage(), e);
		}
	}

	/**
	 * @return Paths of all files, directories are left out
	 */
	Set<String> names() {
		return Collections.unmodifiableSet(entries.keySet());
	}

	boolean contains(String name) {
		return entries.containsKey(name);
	}

	/**
	 * @return The unpacked content, a new array on every call
	 * @throws NoSuchFileException if there is no such entry
	 * @throws GdtfException       if the entry is broken
	 */
	byte[] read(String name) throws NoSuchFileException, GdtfException {
		Entry entry = entries.get(name);
		if (entry == null)
			throw new NoSuchFileException(name);
		if (entry.method() == STORED) {
			byte[] data = new byte[entry.size()];
			System.arraycopy(zip, entry.dataStart(), data, 0, entry.size());
			return data;
		}
		return inflate(entry, name);
	}

	private static Map<String, Entry> readDirectory(byte[] zip, long maxSize) throws GdtfException {
		ByteBuffer buffer = ByteBuffer.wrap(zip).order(ByteOrder.LITTLE_ENDIAN);
		int end = findEndOfCentralDirectory(buffer);
		int count = Short.toUnsignedInt(buffer.getShort(end + 10));
		long directoryOffset = Integer.toUnsignedLong(buffer.getInt(end + 16));
		if (count == 0xffff || directoryOffset == 0xffffffffL)
			throw new GdtfException("ZIP64 archives are not supported");
		check(directoryOffset < zip.length, "Broken zip directory offset");

		Map<String, Entry> entries = new LinkedHashMap<>();
		long total = 0;
		int position = (int) directoryOffset;
		for (int i = 0; i < count; i++) {
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
			String name = normalize(name(zip, position + 46, nameLength, (flags & 0x800) != 0));
			position += 46 + nameLength + extraLength + commentLength;

			if (name.endsWith("/"))
				continue;
			if ((flags & 1) != 0)
				throw new GdtfException("Encrypted zip entry " + name + " is not supported");
			if (compressedSize == 0xffffffffL || size == 0xffffffffL || localOffset == 0xffffffffL)
				throw new GdtfException("ZIP64 archives are not supported");
			if (method != STORED && method != DEFLATED)
				throw new GdtfException("Zip entry " + name + " uses unsupported compression " + method);
			check(method != STORED || compressedSize == size, "Broken zip entry " + name);
			total += size;
			if (total > maxSize)
				throw new GdtfException("Archive is larger than " + maxSize + " bytes unpacked");

			check(localOffset + 30 <= zip.length && buffer.getInt((int) localOffset) == LOCAL_HEADER,
					"Broken zip entry " + name);
			int localNameLength = Short.toUnsignedInt(buffer.getShort((int) localOffset + 26));
			int localExtraLength = Short.toUnsignedInt(buffer.getShort((int) localOffset + 28));
			long dataStart = localOffset + 30 + localNameLength + localExtraLength;
			check(dataStart + compressedSize <= zip.length, "Zip entry " + name + " is truncated");
			entries.put(name, new Entry(method, (int) dataStart, (int) compressedSize, (int) size));
		}
		return entries;
	}

	/**
	 * Archives from Windows may use backslashes or start with "./"
	 */
	private static String normalize(String name) {
		String path = name.replace('\\', '/');
		while (path.startsWith("./") || path.startsWith("/"))
			path = path.substring(path.startsWith("./") ? 2 : 1);
		return path;
	}

	/**
	 * Names are UTF-8 if flag bit 11 is set. Without it the format says CP437, but many tools write UTF-8
	 * anyway, so UTF-8 is tried first and CP437 only used if the bytes are no valid UTF-8.
	 */
	private static String name(byte[] zip, int start, int length, boolean utf8) {
		if (utf8)
			return new String(zip, start, length, StandardCharsets.UTF_8);
		try {
			return StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT)
					.onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(zip, start, length))
					.toString();
		} catch (CharacterCodingException e) {
			return new String(zip, start, length, CP437);
		}
	}

	private byte[] inflate(Entry entry, String name) throws GdtfException {
		Inflater inflater = new Inflater(true);
		try {
			inflater.setInput(zip, entry.dataStart(), entry.compressedSize());
			byte[] data = new byte[entry.size()];
			int read = 0;
			while (read < data.length) {
				int n = inflater.inflate(data, read, data.length - read);
				if (n == 0 && (inflater.finished() || inflater.needsInput() || inflater.needsDictionary()))
					break;
				read += n;
			}
			check(read == data.length, "Zip entry " + name + " is broken");
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
