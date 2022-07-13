package de.verschwiegener.gdtf4j.util.math;

import org.apache.commons.lang3.StringUtils;
import org.joml.Matrix3f;

public class GDTFMatrix3f extends Matrix3f {

	public GDTFMatrix3f(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21,
			float m22) {
		super(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}
	public GDTFMatrix3f() {
		super();
	}
	/**
	 * Returns a Matrix3f from gdtf String representation
	 * 
	 * @param matrix3f String text representation of matrix
	 * @return GDTFMatrix3f or empty matrix if conversion failed
	 */
	public static GDTFMatrix3f fromString(String matrix3f) {
		if(matrix3f.isBlank()) return new GDTFMatrix3f();
		String[] components = StringUtils.substringsBetween(matrix3f, "{", "}");
		if(components.length < 3) return new GDTFMatrix3f();
		GDTFMatrix3f matrix = new GDTFMatrix3f();
		String[] m0 = components[0].split(",");
		String[] m1 = components[1].split(",");
		String[] m2 = components[2].split(",");
		matrix.m00 = Float.parseFloat(m0[0]);
		matrix.m01 = Float.parseFloat(m0[1]);
		matrix.m02 = Float.parseFloat(m0[2]);
		matrix.m10 = Float.parseFloat(m1[0]);
		matrix.m11 = Float.parseFloat(m1[1]);
		matrix.m12 = Float.parseFloat(m1[2]);
		matrix.m20 = Float.parseFloat(m2[0]);
		matrix.m21 = Float.parseFloat(m2[1]);
		matrix.m22 = Float.parseFloat(m2[2]);
		return matrix;
	}

}
