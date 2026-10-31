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
	 * @return The color as CIE XYZ, {@code {X, Y, Z}} with Y from 0 to 100
	 */
	public double[] toXyz() {
		if (y == 0)
			return new double[] { 0, 0, 0 };
		return new double[] { x * luminance / y, luminance, (1 - x - y) * luminance / y };
	}

}
