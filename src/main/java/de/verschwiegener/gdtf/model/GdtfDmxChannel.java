package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;

/**
 * DMX channel of a mode. All DMX values of the channel and its functions are in the resolution of the channel,
 * e.g. 0 to 65535 for a 16 bit channel.
 *
 * @param name            Name as GDTF derives it: geometry (or reference) and attribute of the first logical
 *                        channel, e.g. "Beam_Dimmer"
 * @param dmxBreak        Break of the channel, starting at 1
 * @param offsets         Addresses of the channel bytes, most significant first, starting at 1. Empty for a
 *                        virtual channel.
 * @param bytes           Resolution of the channel, 1 to 4
 * @param geometry        Geometry the channel controls
 * @param reference       Name of the {@link GdtfGeometry.Reference} this channel was repeated for, null if it is
 *                        no instance of a referenced geometry
 * @param highlight       Value for highlight, null if the channel has none
 * @param initialFunction Function that is active by default, gives the default value
 */
public record GdtfDmxChannel(String name, int dmxBreak, List<Integer> offsets, int bytes, String geometry,
		String reference, Long highlight, GdtfChannelFunction initialFunction,
		List<GdtfLogicalChannel> logicalChannels) {

	public GdtfDmxChannel {
		Objects.requireNonNull(name, "name");
		if (dmxBreak < 1)
			throw new IllegalArgumentException("Break starts at 1");
		offsets = List.copyOf(offsets);
		if (bytes < 1 || bytes > DmxValue.MAX_BYTES)
			throw new IllegalArgumentException("Channel resolution must be 1 to 4 bytes");
		if (!offsets.isEmpty() && offsets.size() != bytes)
			throw new IllegalArgumentException("Channel " + name + " has " + offsets.size() + " offsets but "
					+ bytes + " bytes");
		Objects.requireNonNull(geometry, "geometry");
		Objects.requireNonNull(initialFunction, "initialFunction");
		logicalChannels = List.copyOf(logicalChannels);
		if (logicalChannels.isEmpty())
			throw new IllegalArgumentException("Channel " + name + " has no logical channel");
	}

	/**
	 * @return true if the channel has no DMX address, e.g. a virtual dimmer
	 */
	public boolean isVirtual() {
		return offsets.isEmpty();
	}

	/**
	 * @return Value of the {@link #initialFunction()}
	 */
	public long defaultValue() {
		return initialFunction.defaultValue();
	}

	public long maxValue() {
		return DmxValue.max(bytes);
	}

	/**
	 * @return All functions of all logical channels
	 */
	public List<GdtfChannelFunction> functions() {
		return logicalChannels.stream().flatMap(channel -> channel.functions().stream()).toList();
	}

}
