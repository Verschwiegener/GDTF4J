package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;

/**
 * Range of a DMX channel with one meaning, e.g. "Dimmer" from 0 to 255 or "Gobo1" from 10 to 19. DMX values are
 * in the resolution of the channel.
 *
 * @param name              Name of the function, "&lt;Attribute&gt; &lt;n&gt;" if the file does not name it
 * @param dmxTo             End of the range, derived from the next function of the logical channel with the same
 *                          mode master range
 * @param defaultValue      Value of the channel when this function is the initial one
 * @param physicalFrom      Physical value at {@code dmxFrom}, in the unit of the attribute
 * @param physicalTo        Physical value at {@code dmxTo}
 * @param wheel             Wheel the function selects slots of, null if none
 * @param emitter           Emitter the function controls, null if none
 * @param filter            Filter the function controls, null if none
 * @param modeMaster        Name of the DMX channel this function depends on, null if none
 * @param modeFrom          Start of the master range, in the resolution of the master channel. Null if no master.
 * @param modeTo            End of the master range, in the resolution of the master channel. Null if no master.
 * @param sets              Named ranges inside the function, e.g. the slots of a gobo wheel
 */
public record GdtfChannelFunction(String name, String attribute, String originalAttribute, long dmxFrom,
		long dmxTo, long defaultValue, double physicalFrom, double physicalTo, double realFade,
		double realAcceleration, GdtfWheel wheel, GdtfPhysical.Emitter emitter, GdtfPhysical.Filter filter,
		String colorSpace, String gamut, String modeMaster, Long modeFrom, Long modeTo, String dmxProfile,
		double min, double max, String customName, List<GdtfChannelSet> sets) {

	public GdtfChannelFunction {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(attribute, "attribute");
		sets = List.copyOf(sets);
	}

	/**
	 * @return true if the value lies inside this function
	 */
	public boolean contains(long dmx) {
		return dmx >= dmxFrom && dmx <= dmxTo;
	}

}
