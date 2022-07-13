package de.verschwiegener.gdtf4j.util.math;

import org.apache.commons.lang3.StringUtils;
import org.joml.Matrix4f;

public class GDTFMatrix4f extends Matrix4f {

	public GDTFMatrix4f() {
		super();
	}

	public GDTFMatrix4f(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13,
			float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
		super(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}

	public static GDTFMatrix4f fromString(String matrix4f) {
		if (matrix4f.isBlank())
			return new GDTFMatrix4f();
		String[] components = StringUtils.substringsBetween(matrix4f, "{", "}");
		if (components.length < 4)
			return new GDTFMatrix4f();
		GDTFMatrix4f matrix = new GDTFMatrix4f();
		String[] m0 = components[0].split(",");
		String[] m1 = components[1].split(",");
		String[] m2 = components[2].split(",");
		String[] m3 = components[3].split(",");
		matrix.m00(Float.parseFloat(m0[0]));
		matrix.m01(Float.parseFloat(m0[1]));
		matrix.m02(Float.parseFloat(m0[2]));
		matrix.m03(Float.parseFloat(m0[3]));
		matrix.m10(Float.parseFloat(m1[0]));
		matrix.m11(Float.parseFloat(m1[1]));
		matrix.m12(Float.parseFloat(m1[2]));
		matrix.m13(Float.parseFloat(m1[3]));
		matrix.m20(Float.parseFloat(m2[0]));
		matrix.m21(Float.parseFloat(m2[1]));
		matrix.m22(Float.parseFloat(m2[2]));
		matrix.m23(Float.parseFloat(m2[3]));
		matrix.m30(Float.parseFloat(m3[0]));
		matrix.m31(Float.parseFloat(m3[1]));
		matrix.m32(Float.parseFloat(m3[2]));
		matrix.m33(Float.parseFloat(m3[3]));
		return matrix;
	}

}
