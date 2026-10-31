package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Color, gobo, prism or animation wheel
 */
public record GdtfWheel(String name, List<Slot> slots) {

	/**
	 * @param index         Position on the wheel, starting at 1 like {@link GdtfChannelSet#wheelSlotIndex()}
	 * @param color         Color of the slot, null if none
	 * @param filter        Name of the filter of the slot, null if none
	 * @param mediaFileName Image of the slot without extension, e.g. "15020363" for
	 *                      {@code wheels/15020363.png}. Null if none. See
	 *                      {@link de.verschwiegener.gdtf.GdtfArchive#wheelImage}.
	 * @param facets        Facets of a prism slot, empty otherwise
	 */
	public record Slot(int index, String name, CieColor color, String filter, String mediaFileName,
			List<Facet> facets) {

		public Slot {
			if (index < 1)
				throw new IllegalArgumentException("Slot index starts at 1");
			Objects.requireNonNull(name, "name");
			facets = List.copyOf(facets);
		}
	}

	/**
	 * Facet of a prism
	 *
	 * @param rotation 3x3 rotation of the facet
	 */
	public record Facet(CieColor color, GdtfMatrix rotation) {

		public Facet {
			Objects.requireNonNull(rotation, "rotation");
		}
	}

	public GdtfWheel {
		Objects.requireNonNull(name, "name");
		slots = List.copyOf(slots);
	}

	/**
	 * @param index Starting at 1
	 */
	public Optional<Slot> slot(int index) {
		return index >= 1 && index <= slots.size() ? Optional.of(slots.get(index - 1)) : Optional.empty();
	}

}
