package de.verschwiegener.gdtf.util;

import org.joml.Matrix4f;

public class GDTFUtils {
	
	
	public static record NameHelper (String name, String pretty) {}
	
	public static record FeatureHelper (String feature, String pretty) {}
	
	/**
	 * Holds the LogicalChannel Attribute and ChannelFunction Attribute
	 */
	public static record NodeHelper (String lcAttribute, String cfAttribute) {}
	
	
	/**
	 * Offsets the gives DMXValue by the given Offset Amount
	 * 
	 * @param dmxValue DMXValue in GDTF Format
	 * @param valueOffset Offset to be applied to the DMXValue Part of the given GDTF DMX Value
	 */
	public static String offsetDMXValue(String dmxValue, int valueOffset) {
		if(dmxValue.equals("None")) return dmxValue;
		String[] dmxParts = dmxValue.split("/");
		return (Integer.valueOf(dmxParts[0]) + valueOffset) + "/" + dmxParts[1];
	}
	
	/**
	 * Converts GDTF Matrix String to Matrix4f
	 * @param gdtfMatrix
	 * @return
	 */
	public static Matrix4f toMatrix(String gdtfMatrix) {

		String[] substrings = everySubstringBetween(gdtfMatrix, "{", "}");

		String[] uValues = substrings[0].split(",");
		String[] vValues = substrings[1].split(",");
		String[] wValues = substrings[2].split(",");
		String[] oValues = substrings[3].split(",");
		
		/*Matrix4f m = new Matrix4f(Float.valueOf(uValues[0]), Float.valueOf(uValues[1]), Float.valueOf(uValues[2]),
				Float.valueOf(uValues[3]), Float.valueOf(vValues[0]), Float.valueOf(vValues[1]),
				Float.valueOf(vValues[2]), Float.valueOf(vValues[3]), Float.valueOf(wValues[0]),
				Float.valueOf(wValues[1]), Float.valueOf(wValues[2]), Float.valueOf(wValues[3]),
				Float.valueOf(oValues[0]), Float.valueOf(oValues[1]), Float.valueOf(oValues[2]),
				Float.valueOf(oValues[3]));*/
		
		Matrix4f m = new Matrix4f();
		
		
		m.m00(Float.valueOf(uValues[0]));
		m.m01(Float.valueOf(uValues[1]));
		m.m02(Float.valueOf(uValues[2]));
		
		//m.m03(Float.valueOf(uValues[3]));
		
		m.m10(Float.valueOf(vValues[0]));
		m.m11(Float.valueOf(vValues[1]));
		m.m12(Float.valueOf(vValues[2]));
		
		//m.m13(Float.valueOf(vValues[3]));
		
		m.m20(Float.valueOf(wValues[0]));
		m.m21(Float.valueOf(wValues[1]));
		m.m22(Float.valueOf(wValues[2]));
		
		//m.m23(Float.valueOf(wValues[3]));
		
		//Set Translation
		m.m30(Float.valueOf(uValues[3]));
		m.m31(Float.valueOf(vValues[3]));
		m.m32(Float.valueOf(wValues[3]));
		
		//m.m33(Float.valueOf(oValues[3]));
		

		//System.out.println("Translation: " + m.getTranslation(new Vector3f()) + " / " + uValues[3] + " / " + vValues[3] + " / " + wValues[3]);
		//System.out.println("Scale: " + m.getScale(new Vector3f()));
		//System.out.println("Rotation: " + m.getUnnormalizedRotation(new Quaternionf()).getEulerAnglesXYZ(new Vector3f()));
		
		return m;
	}
	
	/**
	 * Converts Matrix4f to GDTF String Matrix
	 * @param m
	 * @return
	 */
	public static String toGDTFMatrix(Matrix4f m) {
		float[] matrixArray = new float[16];
		m.get(matrixArray);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i < matrixArray.length;i++) {
			sb.append(Float.toString(matrixArray[0]));
			if(i % 4 == 0) {
				sb.append("}{");
			}else {
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Returns Every instance of String between open and close
	 * 
	 * @param str
	 * @param open
	 * @param close
	 * @return
	 */
	private static String[] everySubstringBetween(final String str, final String open, final String close) {
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

}
