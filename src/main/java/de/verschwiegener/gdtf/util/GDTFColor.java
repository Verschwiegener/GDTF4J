package de.verschwiegener.gdtf.util;

import java.text.DecimalFormat;

/**
 * MVRColor utility for Converting between different Formats
 * 
 * @author julius
 *
 */
public class GDTFColor {

	private double X;

	private double Y;

	private double Z;

	/**
	 * Pure White Color
	 */
	public GDTFColor() {
		double x = 0.31273;
		double y = 0.32902;
		double fY = 100;

		X = x * (fY / y);
		Y = fY;
		Z = (1 - x - y) * (fY / y);
	}
	/**
	 * Loads CIE 1931 XYZ Color Coordinates
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public GDTFColor(double x, double y, double z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}

	/**
	 * Converts xyY to XYZ Color Coordinates
	 */
	public static GDTFColor convertxyYToXYZ(double x, double y, double Y) {
		return new GDTFColor(x * (Y / y), Y, (1 - x - y) * (Y / y));
	}
	
	/**
	 * Converts RGB[0-1] to XYZ Color Coordinates
	 * @param r
	 * @param g
	 * @param b
	 * @return
	 */
	public static GDTFColor convertRGBToXYZ(double r, double g, double b) {
		double fr = normalizeRGBtoXYZ(r);
		double fg = normalizeRGBtoXYZ(g);
		double fb = normalizeRGBtoXYZ(b);
		
		float x = (float) (fr * 0.4124 + fg * 0.3576 + fb * 0.1805);
		float y = (float) (fr * 0.2126 + fg * 0.7152 + fb * 0.0722);
		float z = (float) (fr * 0.0193 + fg * 0.1192 + fb * 0.9505);
		
		return new GDTFColor(x, y, z);
	}
	
	/**
	 * Parses MVR Color String
	 * @param xyY
	 * @return
	 */
	public static GDTFColor fromGDTF(String xyY) {
		if (xyY.isBlank())
			return null;
		String[] xyYParts = xyY.split(",");

		float x = Float.parseFloat(xyYParts[0]);
		float y = Float.parseFloat(xyYParts[1]);
		float Y = Float.parseFloat(xyYParts[2]);

		return convertxyYToXYZ(x, y, Y);
	}

	/**
	 * Returns Color in RGB[0-1] representation
	 * 
	 * @return float[] {red, green, blue}
	 */
	public double[] toRGB() {
		/**
		 * Math from https://www.easyrgb.com/en/math.php -> XYZ -> Standard-RGB
		 */
		double x = X / 100;
		double y = Y / 100;
		double z = Z / 100;

		double r = x * 3.2406 + y * -1.5372 + z * -0.4986;
		double g = x * -0.9689 + y * 1.8758 + z * 0.0415;
		double b = x * 0.0557 + y * -0.2040 + z * 1.0570;

		r = normalizeXYZtoRGB(r);
		g = normalizeXYZtoRGB(g);
		b = normalizeXYZtoRGB(b);

		return new double[] { (r < 0) ? 0 : (r > 1) ? 1 : r, (g < 0) ? 0 : (g > 1) ? 1 : g, (b < 0) ? 0 : (b > 1) ? 1 : b };
	}

	/**
	 * Returns Color in CMY[0-1] representation
	 * 
	 * @return
	 */
	public double[] toCMY() {
		double[] rgb = toRGB();
		return new double[] { 1 - rgb[0], 1 - rgb[1], 1 - rgb[2] };
	}

	/**
	 * Method used to convert XYZ to Standard RGB
	 * https://www.easyrgb.com/en/math.php -> XYZ -> Standard-RGB
	 * 
	 * @param value
	 * @return
	 */
	private double normalizeXYZtoRGB(double value) {
		if (value > 0.0031308) {
			value = 1.055 * (Math.pow(value, (1 / 2.4))) - 0.055;
		} else {
			value = 12.92 * value;
		}
		return value;
	}
	
	/**
	 * Method used to Convert Standard RGB to XYZ
	 * https://www.easyrgb.com/en/math.php -> Standard-RGB -> XYZ
	 * @param value
	 * @return
	 */
	private static double normalizeRGBtoXYZ(double value) {
		if ( value > 0.04045 ) {
			value = Math.pow(((value + 0.055) / 1.055), 2.4);
		}else {
			value = value / 12.92;
		}
		return value * 100;
	}

	public double[] toxyY() {
		// http://www.brucelindbloom.com/
		double x = X / (X + Y + Z);
		double y = Y / (X + Y + Z);

		return new double[] { x, y, Y };
	}
	/**
	 * Returns Color in MVR String Format
	 * 
	 * @return
	 */
	public String toGDTF() {
		double[] xyY = toxyY();
		DecimalFormat decimalFormat = new DecimalFormat("0.000000");
		return decimalFormat.format(xyY[0]) + "," + decimalFormat.format(xyY[1]) + "," + decimalFormat.format(xyY[2]);
	}

	@Override
	public String toString() {
		return "X: " + X + " Y: " + Y + " Z: " + Z;
	}

}
