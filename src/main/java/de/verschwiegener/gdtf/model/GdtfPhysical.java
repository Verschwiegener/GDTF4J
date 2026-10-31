package de.verschwiegener.gdtf.model;

import java.util.Objects;

/**
 * Physical descriptions of a fixture type: emitters, filters and color space
 */
public final class GdtfPhysical {

	private GdtfPhysical() {
	}

	/**
	 * Light source, e.g. the red LED of an RGB fixture
	 *
	 * @param color              Color of the emitter, null if only described by its wavelength
	 * @param dominantWaveLength In nanometers, null if not given
	 * @param diodePart          Manufacturer part number of the diode, null if none
	 */
	public record Emitter(String name, CieColor color, Double dominantWaveLength, String diodePart) {

		public Emitter {
			Objects.requireNonNull(name, "name");
		}
	}

	/**
	 * Color filter, e.g. a CMY flag or a slot of a color wheel
	 */
	public record Filter(String name, CieColor color) {

		public Filter {
			Objects.requireNonNull(name, "name");
		}
	}

	/**
	 * Color space of the fixture's color mixing
	 *
	 * @param mode  "Custom", "sRGB", "ProPhoto" or "ANSI"
	 * @param red   Primary, only given for "Custom", null otherwise
	 * @param green Primary, only given for "Custom", null otherwise
	 * @param blue  Primary, only given for "Custom", null otherwise
	 * @param white White point, only given for "Custom", null otherwise
	 */
	public record ColorSpace(String name, String mode, CieColor red, CieColor green, CieColor blue, CieColor white) {

		public ColorSpace {
			Objects.requireNonNull(mode, "mode");
		}
	}

}
