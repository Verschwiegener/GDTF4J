package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;

/**
 * @param attribute         Main attribute of the logical channel
 * @param snap              Whether the channel jumps instead of fading
 * @param master            Which master scales this channel
 * @param mibFade           Move in black fade time in seconds
 * @param dmxChangeTimeLimit Minimum time between changes in seconds
 */
public record GdtfLogicalChannel(String attribute, Snap snap, Master master, double mibFade,
		double dmxChangeTimeLimit, List<GdtfChannelFunction> functions) {

	public enum Snap {
		NO, YES, ON, OFF
	}

	public enum Master {
		NONE, GRAND, GROUP
	}

	public GdtfLogicalChannel {
		Objects.requireNonNull(attribute, "attribute");
		Objects.requireNonNull(snap, "snap");
		Objects.requireNonNull(master, "master");
		functions = List.copyOf(functions);
	}

}
