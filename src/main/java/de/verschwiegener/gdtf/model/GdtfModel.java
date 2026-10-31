package de.verschwiegener.gdtf.model;

import java.util.Objects;

/**
 * 3D model of a geometry
 *
 * @param length        In meters
 * @param width         In meters
 * @param height        In meters
 * @param primitiveType "Undefined" for a model file, otherwise a built-in shape like "Cube" or "Cylinder"
 * @param file          Name of the model file without extension and folder, e.g. "head" for
 *                      {@code models/gltf/head.glb}. Null if the model is a primitive. See
 *                      {@link de.verschwiegener.gdtf.GdtfArchive#modelFiles}.
 */
public record GdtfModel(String name, double length, double width, double height, String primitiveType,
		String file) {

	public GdtfModel {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(primitiveType, "primitiveType");
	}

}
