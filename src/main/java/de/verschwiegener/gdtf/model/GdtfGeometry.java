package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Part of the physical structure of a fixture, e.g. base, yoke, head and beam. Geometries form a tree, the
 * position of a child is relative to its parent.
 *
 * @param model     Name of the {@link GdtfModel}, null if the geometry has no model
 * @param position  Position relative to the parent, in meters
 * @param beam      Light output, only for {@link Type#BEAM}
 * @param reference Instance of another geometry, only for {@link Type#GEOMETRY_REFERENCE}
 */
public record GdtfGeometry(Type type, String name, String model, GdtfMatrix position, List<GdtfGeometry> children,
		Beam beam, Reference reference) {

	public enum Type {
		GEOMETRY, AXIS, FILTER_BEAM, FILTER_COLOR, FILTER_GOBO, FILTER_SHAPER, BEAM, MEDIA_SERVER_LAYER,
		MEDIA_SERVER_CAMERA, MEDIA_SERVER_MASTER, DISPLAY, LASER, GEOMETRY_REFERENCE, WIRING_OBJECT, INVENTORY,
		STRUCTURE, SUPPORT, MAGNET;

		/**
		 * @param element Name of the XML element, e.g. "FilterBeam"
		 * @return {@link #GEOMETRY} for unknown elements
		 */
		public static Type ofElement(String element) {
			String name = element.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase(Locale.ROOT);
			for (Type type : values()) {
				if (type.name().equals(name))
					return type;
			}
			return GEOMETRY;
		}
	}

	/**
	 * Light output of a geometry. Missing values have the defaults of GDTF.
	 *
	 * @param lampType         e.g. "Discharge" or "LED"
	 * @param beamType         e.g. "Wash", "Spot" or "None"
	 * @param powerConsumption In watts
	 * @param luminousFlux     In lumen
	 * @param colorTemperature In kelvin
	 * @param beamAngle        In degrees
	 * @param fieldAngle       In degrees
	 * @param beamRadius       In meters
	 * @param emitterSpectrum  Name of the emitter, null if none
	 */
	public record Beam(String lampType, String beamType, double powerConsumption, double luminousFlux,
			double colorTemperature, double beamAngle, double fieldAngle, double beamRadius, double throwRatio,
			double rectangleRatio, int colorRenderingIndex, String emitterSpectrum) {
	}

	/**
	 * Instance of a geometry defined at the top level, e.g. one pixel of a LED bar. Channels of the referenced
	 * geometry are repeated for every reference, already resolved in {@link GdtfDmxMode#channels()}.
	 *
	 * @param geometry Name of the referenced top level geometry
	 * @param breaks   Where the channels of the instance go. The n-th entry applies to the n-th DMX break used by
	 *                 the referenced geometry (ascending), the last one also to its channels with DMXBreak
	 *                 "Overwrite".
	 */
	public record Reference(String geometry, List<Break> breaks) {

		public Reference {
			Objects.requireNonNull(geometry, "geometry");
			breaks = List.copyOf(breaks);
		}
	}

	/**
	 * @param dmxBreak  Break the channels of the instance are on
	 * @param dmxOffset Address of the first channel of the instance on this break, starting at 1
	 */
	public record Break(int dmxBreak, int dmxOffset) {
	}

	public GdtfGeometry {
		Objects.requireNonNull(type, "type");
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(position, "position");
		children = List.copyOf(children);
	}

	/**
	 * @return This geometry and all geometries below it, depth first
	 */
	public Stream<GdtfGeometry> flatten() {
		return Stream.concat(Stream.of(this), children.stream().flatMap(GdtfGeometry::flatten));
	}

	/**
	 * @return The geometry with this name in the tree below and including this one
	 */
	public Optional<GdtfGeometry> find(String name) {
		return flatten().filter(geometry -> geometry.name.equals(name)).findFirst();
	}

}
