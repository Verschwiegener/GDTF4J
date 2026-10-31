package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * DMX mode of a fixture type. Channels of referenced geometries (multi cell fixtures) are already repeated for
 * every {@link GdtfGeometry.Reference}, with their final break and offsets.
 *
 * @param geometry Name of the top level geometry this mode controls
 */
public record GdtfDmxMode(String name, String description, String geometry, List<GdtfDmxChannel> channels,
		List<Relation> relations) {

	/**
	 * Dependency between two channels, e.g. a virtual dimmer that multiplies the color channels
	 *
	 * @param master   Name of the master channel
	 * @param follower Node of the following channel function, e.g. "Beam_ColorAdd_R.ColorAdd_R.ColorAdd_R 1"
	 * @param type     "Multiply" or "Override"
	 */
	public record Relation(String name, String master, String follower, String type) {

		public Relation {
			Objects.requireNonNull(name, "name");
			Objects.requireNonNull(master, "master");
			Objects.requireNonNull(follower, "follower");
			Objects.requireNonNull(type, "type");
		}
	}

	public GdtfDmxMode {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(description, "description");
		Objects.requireNonNull(geometry, "geometry");
		channels = List.copyOf(channels);
		relations = List.copyOf(relations);
	}

	/**
	 * @return The DMX breaks used by the channels, ascending
	 */
	public SortedSet<Integer> breaks() {
		SortedSet<Integer> breaks = new TreeSet<>();
		channels.stream().filter(channel -> !channel.isVirtual()).forEach(channel -> breaks.add(channel.dmxBreak()));
		return breaks;
	}

	/**
	 * @return Number of DMX channels the mode uses on the break, 0 if none
	 */
	public int footprint(int dmxBreak) {
		return channels.stream().filter(channel -> channel.dmxBreak() == dmxBreak)
				.flatMap(channel -> channel.offsets().stream()).mapToInt(Integer::intValue).max().orElse(0);
	}

	public Optional<GdtfDmxChannel> channel(String name) {
		return channels.stream().filter(channel -> channel.name().equals(name)).findFirst();
	}

}
