package de.verschwiegener.gdtf.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class GDTFMatrix {

	float m00, m01, m02, m03;
	float m10, m11, m12, m13;
	float m20, m21, m22, m23;
	float m30, m31, m32, m33;

	public GDTFMatrix() {
		identity();
	}

	public GDTFMatrix(String matrix) {
		if (matrix == null) {
			identity();
			return;
		}

		String[] substrings = everySubstringBetween(matrix, "{", "}");

		String[] uValues = substrings[0].split(",");
		String[] vValues = substrings[1].split(",");
		String[] wValues = substrings[2].split(",");
		String[] oValues = substrings[3].split(",");
		
		
		/*m00 = Float.valueOf(uValues[0]);
		m01 = Float.valueOf(uValues[1]);
		m02 = Float.valueOf(uValues[2]);
		m03 = Float.valueOf(uValues[3]);

		m10 = Float.valueOf(vValues[0]);
		m11 = Float.valueOf(vValues[1]);
		m12 = Float.valueOf(vValues[2]);
		m13 = Float.valueOf(vValues[3]);

		m20 = Float.valueOf(wValues[0]);
		m21 = Float.valueOf(wValues[1]);
		m22 = Float.valueOf(wValues[2]);
		m23 = Float.valueOf(wValues[3]);

		m30 = Float.valueOf(oValues[0]);
		m31 = Float.valueOf(oValues[1]);
		m32 = Float.valueOf(oValues[2]);
		m33 = Float.valueOf(oValues[3]);*/
		

		m00 = Float.valueOf(uValues[0]);
		m10 = Float.valueOf(uValues[1]);
		m20 = Float.valueOf(uValues[2]);
		m30 = Float.valueOf(uValues[3]);

		m01 = Float.valueOf(vValues[0]);
		m11 = Float.valueOf(vValues[1]);
		m21 = Float.valueOf(vValues[2]);
		m31 = Float.valueOf(vValues[3]);

		m02 = Float.valueOf(wValues[0]);
		m12 = Float.valueOf(wValues[1]);
		m22 = Float.valueOf(wValues[2]);
		m32 = Float.valueOf(wValues[3]);

		m03 = Float.valueOf(oValues[0]);
		m13 = Float.valueOf(oValues[1]);
		m23 = Float.valueOf(oValues[2]);
		m33 = Float.valueOf(oValues[3]);
	}

	/**
	 * Resets the Matrix to an Identity matrix
	 */
	public void identity() {
		m00 = 1.0f;
		m01 = 0.0f;
		m02 = 0.0f;
		m03 = 0.0f;

		m10 = 0.0f;
		m11 = 1.0f;
		m12 = 0.0f;
		m13 = 0.0f;

		m20 = 0.0f;
		m21 = 0.0f;
		m22 = 1.0f;
		m23 = 0.0f;

		m30 = 0.0f;
		m31 = 0.0f;
		m32 = 0.0f;
		m33 = 1.0f;
	}

	/**
	 * Returns Scale of the Matrix
	 * 
	 * @return float[] {scaleX, scaleY, scaleZ}
	 */
	public float[] getScale() {
		float[] scale = new float[3];
		scale[0] = (float) Math.sqrt(m00 * m00 + m01 * m01 + m02 * m02);
		scale[1] = (float) Math.sqrt(m10 * m10 + m11 * m11 + m12 * m12);
		scale[2] = (float) Math.sqrt(m20 * m20 + m21 * m21 + m22 * m22);
		return scale;
	}

	/**
	 * Returns the Translation of the Matrix
	 * 
	 * @return float[] {posX, posY, posZ}
	 */
	public float[] getTranslation() {
		float[] translation = new float[3];
		translation[0] = m30;
		translation[1] = m31;
		translation[2] = m32;
		return translation;
	}

	/**
	 * Returns the Translation of the Matrix divided by scaleFactor
	 * 
	 * @param scaleFactor Scales the Position to whatever Unit is wanted scaleFactor
	 *                    1 = Millimeter
	 * @return
	 */
	public float[] getTranslation(float scaleFactor) {
		float[] translation = new float[3];
		translation[0] = m30 / 100;
		translation[1] = m31 / 100;
		translation[2] = m32 / 100;
		return translation;
	}

	/**
	 * Offsets the Position by the given Offset
	 * 
	 * @param offset
	 */
	public void offsetPos(float[] offset) {
		m30 = m30 + offset[0];
		m31 = m31 + offset[1];
		m32 = m32 + offset[2];
	}

	/**
	 * Sets the Rotation of this matrix
	 * 
	 * @param radianX
	 * @param radianY
	 * @param radianZ
	 */
	public void setRotationXYZ(float radianX, float radianY, float radianZ) {
		float sinX = (float) Math.sin(radianX);
		float cosX = (float) Math.sin(radianX + (Math.PI * 0.5));
		float sinY = (float) Math.sin(radianY);
		float cosY = (float) Math.sin(radianY + (Math.PI * 0.5));
		float sinZ = (float) Math.sin(radianZ);
		float cosZ = (float) Math.sin(radianZ + (Math.PI * 0.5));
		float m_sinX = -sinX;
		float m_sinY = -sinY;
		float m_sinZ = -sinZ;

		// rotateX
		float nm11 = cosX;
		float nm12 = sinX;
		float nm21 = m_sinX;
		float nm22 = cosX;
		// rotateY
		float nm00 = cosY;
		float nm01 = nm21 * m_sinY;
		float nm02 = nm22 * m_sinY;
		m20 = sinY;
		m21 = nm21 * cosY;
		m22 = nm22 * cosY;
		// rotateZ
		m00 = nm00 * cosZ;
		m01 = nm01 * cosZ + nm11 * sinZ;
		m02 = nm02 * cosZ + nm12 * sinZ;
		m10 = nm00 * m_sinZ;
		m11 = nm01 * m_sinZ + nm11 * cosZ;
		m12 = nm02 * m_sinZ + nm12 * cosZ;
	}

	public float[] getRotation() {
		float[] rotation = new float[4];

		float nm00 = m00, nm01 = m01, nm02 = m02;
		float nm10 = m10, nm11 = m11, nm12 = m12;
		float nm20 = m20, nm21 = m21, nm22 = m22;
		float lenX = (float) (1.0f / Math.sqrt(m00 * m00 + m01 * m01 + m02 * m02));
		float lenY = (float) (1.0f / Math.sqrt(m10 * m10 + m11 * m11 + m12 * m12));
		float lenZ = (float) (1.0f / Math.sqrt(m20 * m20 + m21 * m21 + m22 * m22));
		nm00 *= lenX;
		nm01 *= lenX;
		nm02 *= lenX;
		nm10 *= lenY;
		nm11 *= lenY;
		nm12 *= lenY;
		nm20 *= lenZ;
		nm21 *= lenZ;
		nm22 *= lenZ;
		float epsilon = 1E-4f, epsilon2 = 1E-3f;
		if (Math.abs(nm10 - nm01) < epsilon && Math.abs(nm20 - nm02) < epsilon && Math.abs(nm21 - nm12) < epsilon) {
			if (Math.abs(nm10 + nm01) < epsilon2 && Math.abs(nm20 + nm02) < epsilon2 && Math.abs(nm21 + nm12) < epsilon2
					&& Math.abs(nm00 + nm11 + nm22 - 3) < epsilon2) {
				rotation[0] = 0f;
				rotation[1] = 0f;
				rotation[2] = 1f;
				rotation[3] = 0f;
				return rotation;
			}
			rotation[3] = (float) Math.PI;
			float xx = (nm00 + 1) / 2;
			float yy = (nm11 + 1) / 2;
			float zz = (nm22 + 1) / 2;
			float xy = (nm10 + nm01) / 4;
			float xz = (nm20 + nm02) / 4;
			float yz = (nm21 + nm12) / 4;
			if ((xx > yy) && (xx > zz)) {
				rotation[0] = (float) Math.sqrt(xx);
				rotation[1] = xy / rotation[0];
				rotation[2] = xz / rotation[0];
			} else if (yy > zz) {
				rotation[1] = (float) Math.sqrt(yy);
				rotation[0] = xy / rotation[1];
				rotation[2] = yz / rotation[1];
			} else {
				rotation[2] = (float) Math.sqrt(zz);
				rotation[0] = xz / rotation[2];
				rotation[1] = yz / rotation[2];
			}
			return rotation;
		}
		float s = (float) Math
				.sqrt((nm12 - nm21) * (nm12 - nm21) + (nm20 - nm02) * (nm20 - nm02) + (nm01 - nm10) * (nm01 - nm10));
		rotation[3] = safeAcos((nm00 + nm11 + nm22 - 1) / 2);
		rotation[0] = (nm12 - nm21) / s;
		rotation[1] = (nm20 - nm02) / s;
		rotation[2] = (nm01 - nm10) / s;
		return rotation;
	}

	/**
	 * Returns the Matrix Rotation as Radian
	 * 
	 * @return
	 */
	public double[] getRotationRadians() {
		// https://stackoverflow.com/a/15029416
		double x = Math.atan2(m21, m22);
		double y = Math.atan2(-m20, Math.sqrt(Math.pow(m21, 2) + Math.pow(m22, 2)));
		double z = Math.atan2(m10, m00);
		return new double[] { x, y, z };
	}

	/**
	 * Returns the Rotation as Angle
	 * 
	 * @return
	 */
	public double[] getRotationAngles() {
		double[] radians = getRotationRadians();
		return new double[] { Math.toDegrees(radians[0]), Math.toDegrees(radians[1]), Math.toDegrees(radians[2]) };
	}

	private float safeAcos(float v) {
		if (v < -1.0f)
			return (float) Math.PI;
		else if (v > +1.0f)
			return 0.0f;
		else
			return (float) Math.acos(v);
	}

	public float m00() {
		return m00;
	}

	public float m01() {
		return m01;
	}

	public float m02() {
		return m02;
	}

	public float m03() {
		return m03;
	}

	public float m10() {
		return m10;
	}

	public float m11() {
		return m11;
	}

	public float m12() {
		return m12;
	}

	public float m13() {
		return m13;
	}

	public float m20() {
		return m20;
	}

	public float m21() {
		return m21;
	}

	public float m22() {
		return m22;
	}

	public float m23() {
		return m23;
	}

	public float m30() {
		return m30;
	}

	public float m31() {
		return m31;
	}

	public float m32() {
		return m32;
	}

	public float m33() {
		return m33;
	}

	/**
	 * Returns Every instance of String between open and close
	 * 
	 * @param str
	 * @param open
	 * @param close
	 * @return
	 */
	private String[] everySubstringBetween(final String str, final String open, final String close) {
		if (str == null || open == null || close == null)
			return null;

		final int start = str.indexOf(open);
		if (start != -1) {
			// Open Char exists
			final int end = str.indexOf(close, start + open.length());

			if (end != -1) {
				// Close Char exist
				String between = str.substring(start + open.length(), end);

				if (end < (str.length() - 1)) {
					// Contains multiple

					// Get substrings from rest of string
					String[] multiple = everySubstringBetween(str.substring(end + close.length()), open, close);

					String[] every = new String[multiple.length + 1];
					every[0] = between;

					// Copy to bigger array
					System.arraycopy(multiple, 0, every, 1, multiple.length);

					return every;
				}
				// Return if contains only one
				return new String[] { between };
			}
		}
		return null;
	}

	public String toGDTF() {
		DecimalFormat decimalFormat = new DecimalFormat("0.000000");
		return "{" + decimalFormat.format(m00) + "," + decimalFormat.format(m10) + "," + decimalFormat.format(m20) + ","
				+ decimalFormat.format(m30) + "}{" + decimalFormat.format(m01) + "," + decimalFormat.format(m11) + ","
				+ decimalFormat.format(m21) + "," + decimalFormat.format(m31) + "}{" + decimalFormat.format(m02) + ","
				+ decimalFormat.format(m12) + "," + decimalFormat.format(m22) + "," + decimalFormat.format(m32) + "}{"
				+ decimalFormat.format(m03) + "," + decimalFormat.format(m13) + "," + decimalFormat.format(m23) + ","
				+ decimalFormat.format(m33) + "}";
	}

	/**
	 * Return a string representation of this matrix.
	 * <p>
	 * This method creates a new {@link DecimalFormat} on every invocation with the
	 * format string "<code>0.000E0;-</code>".
	 * 
	 * @return the string representation
	 */
	public String toString() {
		String str = toString(decimalFormat());
		StringBuffer res = new StringBuffer();
		int eIndex = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'E') {
				eIndex = i;
			} else if (c == ' ' && eIndex == i - 1) {
				// workaround Java 1.4 DecimalFormat bug
				res.append('+');
				continue;
			} else if (Character.isDigit(c) && eIndex == i - 1) {
				res.append('+');
			}
			res.append(c);
		}
		return res.toString();
	}

	/**
	 * Return a string representation of this matrix by formatting the matrix
	 * elements with the given {@link NumberFormat}.
	 * 
	 * @param formatter the {@link NumberFormat} used to format the matrix values
	 *                  with
	 * @return the string representation
	 */
	public String toString(NumberFormat formatter) {
		return format(m00, formatter) + " " + format(m10, formatter) + " " + format(m20, formatter) + " "
				+ format(m30, formatter) + "\n" + format(m01, formatter) + " " + format(m11, formatter) + " "
				+ format(m21, formatter) + " " + format(m31, formatter) + "\n" + format(m02, formatter) + " "
				+ format(m12, formatter) + " " + format(m22, formatter) + " " + format(m32, formatter) + "\n"
				+ format(m03, formatter) + " " + format(m13, formatter) + " " + format(m23, formatter) + " "
				+ format(m33, formatter) + "\n";
	}

	public static String format(double number, NumberFormat format) {
		if (Double.isNaN(number)) {
			return padLeft(format, " NaN");
		} else if (Double.isInfinite(number)) {
			return padLeft(format, number > 0.0 ? " +Inf" : " -Inf");
		}
		return format.format(number);
	}

	private static String padLeft(NumberFormat format, String str) {
		int len = format.format(0.0).length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len - str.length() + 1; i++) {
			sb.append(" ");
		}
		return sb.append(str).toString();
	}

	private static NumberFormat decimalFormat() {
		NumberFormat df;
		char[] prec = new char[3];
		Arrays.fill(prec, '0');
		df = new DecimalFormat(" 0." + new String(prec) + "E0;-");
		return df;
	}

}
