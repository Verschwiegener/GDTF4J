package de.verschwiegener.gdtf4j.util.math;

import org.joml.Vector3f;

public class GDTFVector3f extends Vector3f {
	
	public static GDTFVector3f NULL = new GDTFVector3f(0,0,0);

	public GDTFVector3f(float x, float y, float z) {
		super(x, y, z);
	}
	public GDTFVector3f() {
		super();
	}

	/**
	 * Returns a Vector3f from gdtf String representation, splitted by Comma
	 * 
	 * @param vector3f String text representation of Vector3f
	 * @return Vector3f or Null if conversion failed
	 */
	public static GDTFVector3f fromString(String vector3f) {
		if (vector3f.isBlank() || !vector3f.contains(","))
			return NULL;
		String[] components = vector3f.split(",");
		if (components.length < 3)
			return NULL;
		return new GDTFVector3f(Float.parseFloat(components[0]), Float.parseFloat(components[1]),
				Float.parseFloat(components[2]));
	}

}
