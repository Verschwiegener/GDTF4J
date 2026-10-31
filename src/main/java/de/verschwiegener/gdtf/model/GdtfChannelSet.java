package de.verschwiegener.gdtf.model;

import java.util.Objects;

/**
 * Named range inside a channel function, e.g. one gobo. DMX values are in the resolution of the channel.
 *
 * @param dmxTo          End of the range, derived from the next set or the end of the function
 * @param physicalFrom   NaN if the file does not give it
 * @param physicalTo     NaN if the file does not give it
 * @param wheelSlotIndex Slot of the function's wheel, starting at 1. Null if none.
 */
public record GdtfChannelSet(String name, long dmxFrom, long dmxTo, double physicalFrom, double physicalTo,
		Integer wheelSlotIndex) {

	public GdtfChannelSet {
		Objects.requireNonNull(name, "name");
	}

}
