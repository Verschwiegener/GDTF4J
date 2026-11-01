package de.verschwiegener.gdtf.model;

/**
 * Color as GDTF stores it: CIE 1931 chromaticity {@code x}, {@code y} and luminance {@code Y} (0 to 100)
 */
public record CieColor(double x, double y, double luminance) {

	/**
	 * D65 white, the default of GDTF
	 */
	public static final CieColor WHITE = new CieColor(0.3127, 0.3290, 100);

	public CieColor {
		if (!Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(luminance))
			throw new IllegalArgumentException("Color values must be finite");
	}

	/**
	 * @param text {@code "x,y,Y"} as in the file
	 * @return null if the text is missing or blank
	 * @throws IllegalArgumentException if the text is no color
	 */
	public static CieColor parse(String text) {
		if (text == null || text.isBlank())
			return null;
		String[] parts = text.split(",");
		if (parts.length != 3)
			throw new IllegalArgumentException("Invalid color: " + text);
		try {
			return new CieColor(Double.parseDouble(parts[0].strip()), Double.parseDouble(parts[1].strip()),
					Double.parseDouble(parts[2].strip()));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid color: " + text, e);
		}
	}

	/**
	 * @return The color as CIE XYZ, {@code {X, Y, Z}} with Y from 0 to 100. Always finite and not negative:
	 *         chromaticities outside the valid range (y near 0, x + y above 1) are clamped, a color with y near
	 *         0 is black.
	 */
	public double[] toXyz() {
		if (y < 1e-6)
			return new double[] { 0, 0, 0 };
		double scale = Math.max(0, luminance) / y;
		return new double[] { Math.max(0, x * scale), Math.max(0, luminance), Math.max(0, (1 - x - y) * scale) };
	}

}
