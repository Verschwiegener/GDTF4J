package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Content of {@code description.xml} of a GDTF file, with all references resolved and DMX values converted to
 * the resolution of their channel. Immutable, safe to share between threads.
 * <p>
 * Lengths are in meters, angles in degrees, like in GDTF.
 *
 * @param dataVersion   GDTF version of the file, e.g. "1.2"
 * @param fixtureTypeId GUID of the fixture type, the same for all revisions
 * @param thumbnail     Name of the preview image without extension, e.g. "thumbnail". Null if none. See
 *                      {@link de.verschwiegener.gdtf.GdtfArchive#thumbnailFiles()}.
 * @param refFT         GUID of a fixture type this one is derived from, null if none
 * @param geometries    Top level geometries. The tree of a mode starts at {@link GdtfDmxMode#geometry()}, the
 *                      others are referenced by {@link GdtfGeometry.Reference}s.
 * @param colorSpace    Color space of the fixture, sRGB if the file does not give one
 */
public record GdtfFixtureType(String dataVersion, String fixtureTypeId, String name, String shortName,
		String longName, String manufacturer, String description, String thumbnail, String refFT,
		boolean canHaveChildren, List<Revision> revisions, List<GdtfFeatureGroup> featureGroups,
		List<String> activationGroups, List<GdtfAttribute> attributes, List<GdtfWheel> wheels,
		List<GdtfPhysical.Emitter> emitters, List<GdtfPhysical.Filter> filters, GdtfPhysical.ColorSpace colorSpace,
		List<GdtfModel> models, List<GdtfGeometry> geometries, List<GdtfDmxMode> modes) {

	/**
	 * @param date Date of the revision as in the file (ISO 8601), null if none
	 */
	public record Revision(String text, String date, String modifiedBy) {

		public Revision {
			Objects.requireNonNull(text, "text");
		}
	}

	public GdtfFixtureType {
		Objects.requireNonNull(dataVersion, "dataVersion");
		Objects.requireNonNull(fixtureTypeId, "fixtureTypeId");
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(shortName, "shortName");
		Objects.requireNonNull(longName, "longName");
		Objects.requireNonNull(manufacturer, "manufacturer");
		Objects.requireNonNull(description, "description");
		revisions = List.copyOf(revisions);
		featureGroups = List.copyOf(featureGroups);
		activationGroups = List.copyOf(activationGroups);
		attributes = List.copyOf(attributes);
		wheels = List.copyOf(wheels);
		emitters = List.copyOf(emitters);
		filters = List.copyOf(filters);
		Objects.requireNonNull(colorSpace, "colorSpace");
		models = List.copyOf(models);
		geometries = List.copyOf(geometries);
		modes = List.copyOf(modes);
	}

	public Optional<GdtfAttribute> attribute(String name) {
		return attributes.stream().filter(attribute -> attribute.name().equals(name)).findFirst();
	}

	public Optional<GdtfWheel> wheel(String name) {
		return wheels.stream().filter(wheel -> wheel.name().equals(name)).findFirst();
	}

	public Optional<GdtfModel> model(String name) {
		return models.stream().filter(model -> model.name().equals(name)).findFirst();
	}

	public Optional<GdtfDmxMode> mode(String name) {
		return modes.stream().filter(mode -> mode.name().equals(name)).findFirst();
	}

	/**
	 * @return The geometry with this name anywhere in the tree
	 */
	public Optional<GdtfGeometry> geometry(String name) {
		return geometries.stream().flatMap(GdtfGeometry::flatten).filter(geometry -> geometry.name().equals(name))
				.findFirst();
	}

}
