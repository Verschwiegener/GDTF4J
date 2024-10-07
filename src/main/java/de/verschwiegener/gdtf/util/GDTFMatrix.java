package de.verschwiegener.gdtf.util;

import java.text.DecimalFormat;

public class GDTFMatrix {

	private float[][] m = new float[4][4];

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

		for (int i = 0; i < uValues.length; i++) {
			set(0, i, Float.valueOf(uValues[i]));
		}

		for (int i = 0; i < vValues.length; i++) {
			set(1, i, Float.valueOf(vValues[i]));
		}

		for (int i = 0; i < wValues.length; i++) {
			set(2, i, Float.valueOf(wValues[i]));
		}

		for (int i = 0; i < oValues.length; i++) {
			set(3, i, Float.valueOf(oValues[i]));
		}
	}

	/**
	 * Resets the Matrix to an Identity matrix
	 */
	public void identity() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				m[row][col] = (row == col) ? 1.0f : 0.0f;
			}
		}
	}

	public void set(int row, int col, float value) {
		m[row][col] = value;
	}

	public float get(int row, int col) {
		return m[row][col];
	}

	public void setScale(float scaleX, float scaleY, float scaleZ) {
		m[0][0] = scaleX;
		m[1][1] = scaleY;
		m[2][2] = scaleZ;
	}

	public void setScale(float[] scale) {
		if (scale.length != 3)
			return;
		m[0][0] = scale[0];
		m[1][1] = scale[1];
		m[2][2] = scale[2];
	}

	public float[] getScale() {
		float scaleX = (float) Math.sqrt(m[0][0] * m[0][0] + m[0][1] * m[0][1] + m[0][2] * m[0][2]);
		float scaleY = (float) Math.sqrt(m[1][0] * m[1][0] + m[1][1] * m[1][1] + m[1][2] * m[1][2]);
		float scaleZ = (float) Math.sqrt(m[2][0] * m[2][0] + m[2][1] * m[2][1] + m[2][2] * m[2][2]);
		return new float[] { scaleX, scaleY, scaleZ };
	}

	public void setTranslation(float x, float y, float z) {
		m[0][3] = x;
		m[1][3] = y;
		m[2][3] = z;
	}

	public void setTranslation(float[] translation) {
		if (translation.length != 3)
			return;
		m[0][3] = translation[0];
		m[1][3] = translation[1];
		m[2][3] = translation[2];
	}

	public void addTranslation(float[] translation) {
		if (translation.length != 3)
			return;
		m[0][3] += translation[0];
		m[1][3] += translation[1];
		m[2][3] += translation[2];
	}

	public float[] getTranslation() {
		return new float[] { m[0][3], m[1][3], m[2][3] };
	}

	/**
	 * Returns Rotation as Quaternion [x, y, z, w]
	 * 
	 * @return
	 */
	public float[] getRotation() {
		float[] scale = getScale(); // Skalierung wird benötigt, um die Matrix zu "normalisieren"

		// Normiere die Rotationskomponenten
		float m00 = m[0][0] / scale[0];
		float m01 = m[0][1] / scale[0];
		float m02 = m[0][2] / scale[0];
		float m10 = m[1][0] / scale[1];
		float m11 = m[1][1] / scale[1];
		float m12 = m[1][2] / scale[1];
		float m20 = m[2][0] / scale[2];
		float m21 = m[2][1] / scale[2];
		float m22 = m[2][2] / scale[2];

		// Berechne Quaternion aus der 3x3-Rotationsmatrix
		float trace = m00 + m11 + m22;
		float[] quat = new float[4]; // Quaternion: [x, y, z, w]

		if (trace > 0) {
			float s = (float) Math.sqrt(trace + 1.0f) * 2; // s = 4 * w
			quat[3] = 0.25f * s;
			quat[0] = (m21 - m12) / s;
			quat[1] = (m02 - m20) / s;
			quat[2] = (m10 - m01) / s;
		} else if ((m00 > m11) && (m00 > m22)) {
			float s = (float) Math.sqrt(1.0f + m00 - m11 - m22) * 2; // s = 4 * x
			quat[3] = (m21 - m12) / s;
			quat[0] = 0.25f * s;
			quat[1] = (m01 + m10) / s;
			quat[2] = (m02 + m20) / s;
		} else if (m11 > m22) {
			float s = (float) Math.sqrt(1.0f + m11 - m00 - m22) * 2; // s = 4 * y
			quat[3] = (m02 - m20) / s;
			quat[0] = (m01 + m10) / s;
			quat[1] = 0.25f * s;
			quat[2] = (m12 + m21) / s;
		} else {
			float s = (float) Math.sqrt(1.0f + m22 - m00 - m11) * 2; // s = 4 * z
			quat[3] = (m10 - m01) / s;
			quat[0] = (m02 + m20) / s;
			quat[1] = (m12 + m21) / s;
			quat[2] = 0.25f * s;
		}

		return quat; // Rückgabe: Quaternion in der Form [x, y, z, w]
	}

	/**
	 * Sets the Matrix Rotation (Quaternion)
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public void setRotation(float x, float y, float z, float w) {
		float xx = x * x, yy = y * y, zz = z * z;
		float xy = x * y, xz = x * z, yz = y * z;
		float wx = w * x, wy = w * y, wz = w * z;

		m[0][0] = 1.0f - 2.0f * (yy + zz);
		m[0][1] = 2.0f * (xy - wz);
		m[0][2] = 2.0f * (xz + wy);
		m[0][3] = 0.0f;

		m[1][0] = 2.0f * (xy + wz);
		m[1][1] = 1.0f - 2.0f * (xx + zz);
		m[1][2] = 2.0f * (yz - wx);
		m[1][3] = 0.0f;

		m[2][0] = 2.0f * (xz - wy);
		m[2][1] = 2.0f * (yz + wx);
		m[2][2] = 1.0f - 2.0f * (xx + yy);
		m[2][3] = 0.0f;

		m[3][0] = 0.0f;
		m[3][1] = 0.0f;
		m[3][2] = 0.0f;
		m[3][3] = 1.0f;
	}

	/**
	 * Sets the Matrix Rotation (Quaternion)
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public void setRotation(float[] rotation) {
		if (rotation.length != 4)
			return;
		float x = rotation[0];
		float y = rotation[1];
		float z = rotation[2];
		float w = rotation[3];

		float xx = x * x, yy = y * y, zz = z * z;
		float xy = x * y, xz = x * z, yz = y * z;
		float wx = w * x, wy = w * y, wz = w * z;

		m[0][0] = 1.0f - 2.0f * (yy + zz);
		m[0][1] = 2.0f * (xy - wz);
		m[0][2] = 2.0f * (xz + wy);
		m[0][3] = 0.0f;

		m[1][0] = 2.0f * (xy + wz);
		m[1][1] = 1.0f - 2.0f * (xx + zz);
		m[1][2] = 2.0f * (yz - wx);
		m[1][3] = 0.0f;

		m[2][0] = 2.0f * (xz - wy);
		m[2][1] = 2.0f * (yz + wx);
		m[2][2] = 1.0f - 2.0f * (xx + yy);
		m[2][3] = 0.0f;

		m[3][0] = 0.0f;
		m[3][1] = 0.0f;
		m[3][2] = 0.0f;
		m[3][3] = 1.0f;
	}

	public void multiply(GDTFMatrix other) {
		GDTFMatrix result = new GDTFMatrix();
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				result.m[row][col] = 0;
				for (int k = 0; k < 4; k++) {
					result.m[row][col] += this.m[row][k] * other.m[k][col];
				}
			}
		}
		m = result.m;
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
		String out = "{";
		DecimalFormat decimalFormat = new DecimalFormat("0.000000");
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				out += decimalFormat.format(m[row][col]) + ",";
			}
			out += "}{";
		}
		return out;
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
		String str = "";
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				str += m[row][col] + " ";
			}
			str += System.lineSeparator();
		}
		return str;
	}

}
