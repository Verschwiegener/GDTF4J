package de.verschwiegener.gdtf.model;

/**
 * Converts GDTF DMX values like {@code "128/1"} into a plain number in the resolution of a channel.
 * <p>
 * A GDTF value names its own byte count, independent of the channel: {@code "255/1"} on a 16 bit channel is
 * 65535. By default the conversion uses byte mirroring (the bytes of the value repeat), the suffix {@code s}
 * selects byte shifting ({@code "255/1s"} on a 16 bit channel is 65280). Values with more bytes than the channel
 * are shifted down.
 */
public final class DmxValue {

	/**
	 * Maximum resolution of a DMX channel in bytes
	 */
	public static final int MAX_BYTES = 4;

	private DmxValue() {
	}

	/**
	 * @param bytes Resolution of the channel, 1 to 4
	 * @return Highest value of a channel with this resolution, e.g. 65535 for 2 bytes
	 */
	public static long max(int bytes) {
		checkBytes(bytes);
		return (1L << (8 * bytes)) - 1;
	}

	/**
	 * @param text  Value as written in the file, e.g. {@code "128/1"}, {@code "32768/2"} or {@code "255/1s"}. A
	 *              plain number is taken as value in the resolution of the channel.
	 * @param bytes Resolution of the channel, 1 to 4
	 * @return The value in the resolution of the channel
	 * @throws IllegalArgumentException if the text is not a DMX value
	 */
	public static long parse(String text, int bytes) {
		checkBytes(bytes);
		if (text == null || text.isBlank())
			throw new IllegalArgumentException("Empty DMX value");
		String value = text.strip();
		int slash = value.indexOf('/');
		try {
			if (slash < 0)
				return clamp(Long.parseLong(value), bytes);
			long number = Long.parseLong(value.substring(0, slash).strip());
			String count = value.substring(slash + 1).strip();
			boolean shift = count.endsWith("s") || count.endsWith("S");
			if (shift)
				count = count.substring(0, count.length() - 1);
			int valueBytes = Integer.parseInt(count);
			if (valueBytes < 1 || valueBytes > MAX_BYTES)
				throw new IllegalArgumentException("Byte count of DMX value " + text + " must be 1 to " + MAX_BYTES);
			return convert(clamp(number, valueBytes), valueBytes, bytes, shift);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid DMX value: " + text, e);
		}
	}

	/**
	 * @return null for the special value {@code "None"} or a missing value, the parsed value otherwise
	 */
	public static Long parseOptional(String text, int bytes) {
		if (text == null || text.isBlank() || text.strip().equalsIgnoreCase("None"))
			return null;
		return parse(text, bytes);
	}

	/**
	 * @return The number of bytes the value is written with, e.g. 2 for {@code "32768/2"}, 1 for plain numbers
	 */
	public static int byteCount(String text) {
		if (text == null)
			return 1;
		int slash = text.indexOf('/');
		if (slash < 0)
			return 1;
		String count = text.substring(slash + 1).strip().replaceAll("[sS]$", "");
		try {
			return Math.max(1, Math.min(MAX_BYTES, Integer.parseInt(count)));
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	private static long convert(long value, int from, int to, boolean shift) {
		if (from == to)
			return value;
		if (from > to)
			return value >>> (8 * (from - to));
		if (shift)
			return value << (8 * (to - from));
		// mirroring: the bytes of the value repeat, 0xAB as 2 bytes is 0xABAB
		long result = 0;
		for (int i = 0; i < to; i++) {
			int sourceByte = i % from;
			long b = (value >>> (8 * (from - 1 - sourceByte))) & 0xff;
			result = (result << 8) | b;
		}
		return result;
	}

	private static long clamp(long value, int bytes) {
		return Math.max(0, Math.min(max(bytes), value));
	}

	private static void checkBytes(int bytes) {
		if (bytes < 1 || bytes > MAX_BYTES)
			throw new IllegalArgumentException("Channel resolution must be 1 to " + MAX_BYTES + " bytes but was " + bytes);
	}

}
