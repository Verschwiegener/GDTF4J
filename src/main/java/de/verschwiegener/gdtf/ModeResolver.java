package de.verschwiegener.gdtf;

import static de.verschwiegener.gdtf.XmlValues.blankToNull;
import static de.verschwiegener.gdtf.XmlValues.integer;
import static de.verschwiegener.gdtf.XmlValues.or;
import static de.verschwiegener.gdtf.XmlValues.parse;
import static de.verschwiegener.gdtf.XmlValues.required;
import static de.verschwiegener.gdtf.XmlValues.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;

import de.verschwiegener.gdtf.model.DmxValue;
import de.verschwiegener.gdtf.model.GdtfChannelFunction;
import de.verschwiegener.gdtf.model.GdtfChannelSet;
import de.verschwiegener.gdtf.model.GdtfDmxChannel;
import de.verschwiegener.gdtf.model.GdtfDmxMode;
import de.verschwiegener.gdtf.model.GdtfGeometry;
import de.verschwiegener.gdtf.model.GdtfLogicalChannel;
import de.verschwiegener.gdtf.model.GdtfPhysical;
import de.verschwiegener.gdtf.model.GdtfWheel;
import de.verschwiegener.gdtf.xml.ChannelFunction;
import de.verschwiegener.gdtf.xml.ChannelSet;
import de.verschwiegener.gdtf.xml.DMXChannel;
import de.verschwiegener.gdtf.xml.DMXMode;
import de.verschwiegener.gdtf.xml.LogicalChannel;

/**
 * Resolves one DMX mode for the {@link Resolver}: DMX values in the resolution of their channel, ranges with end
 * values, references to wheels, emitters and filters as objects, and channels of referenced geometries repeated
 * per reference with their break and offsets.
 */
final class ModeResolver {


	private final DMXMode mode;
	private final Map<String, GdtfWheel> wheels;
	private final Map<String, GdtfPhysical.Emitter> emitters;
	private final Map<String, GdtfPhysical.Filter> filters;
	private final List<String> warnings;
	private final String context;
	private final GdtfGeometry modeRoot;
	/**
	 * Top level geometry for every geometry name
	 */
	private final Map<String, GdtfGeometry> topLevel = new HashMap<>();
	/**
	 * References inside the tree of this mode, by the name of the referenced geometry
	 */
	private final Map<String, List<GdtfGeometry>> references = new LinkedHashMap<>();
	/**
	 * Resolution of every channel in the file, by its name, for mode masters
	 */
	private final Map<String, Integer> bytesByChannel = new HashMap<>();
	/**
	 * DMX breaks the channels of every top level geometry use, ascending
	 */
	private final Map<String, List<Integer>> templateBreaks = new HashMap<>();

	/**
	 * The parts of a DMXChannel that are needed before the channels are resolved, read once
	 *
	 * @param fileName Name of the channel in the file, used by ModeMaster and InitialFunction
	 * @param dmxBreak Break of the channel, 1 for "Overwrite"
	 */
	private record ParsedChannel(DMXChannel xml, String fileName, String context, String geometry,
			List<Integer> offsets, int bytes, int dmxBreak, boolean overwrite) {
	}

	/**
	 * @param geometries Top level geometries of the fixture type
	 * @param wheels     Resolved wheels by name, functions refer to them
	 * @param emitters   Resolved emitters by name
	 * @param filters    Resolved filters by name
	 * @param warnings   Tolerated problems are added here
	 */
	ModeResolver(DMXMode mode, List<GdtfGeometry> geometries, Map<String, GdtfWheel> wheels,
			Map<String, GdtfPhysical.Emitter> emitters, Map<String, GdtfPhysical.Filter> filters,
			List<String> warnings) throws GdtfException {
		this.mode = mode;
		this.wheels = wheels;
		this.emitters = emitters;
		this.filters = filters;
		this.warnings = warnings;
		this.context = "DMXMode " + mode.getName();
		String rootName = required(mode.getGeometry(), context + " Geometry");
		for (GdtfGeometry top : geometries)
			top.flatten().forEach(geometry -> topLevel.putIfAbsent(geometry.name(), top));
		modeRoot = topLevel.containsKey(rootName) ? topLevel.get(rootName).find(rootName).orElseThrow() : null;
		if (modeRoot == null)
			warnings.add(context + " uses unknown geometry " + rootName);
		else
			modeRoot.flatten().filter(geometry -> geometry.reference() != null).forEach(geometry -> references
					.computeIfAbsent(geometry.reference().geometry(), g -> new ArrayList<>()).add(geometry));
	}

	GdtfDmxMode resolve() throws GdtfException {
		List<DMXChannel> xmlChannels = mode.getDMXChannels() != null ? mode.getDMXChannels().getDMXChannel()
				: List.of();
		// mode masters and references need all channels before any is resolved
		List<ParsedChannel> parsed = new ArrayList<>();
		for (DMXChannel channel : xmlChannels) {
			ParsedChannel channelInfo = parseChannel(channel);
			parsed.add(channelInfo);
			bytesByChannel.put(channelInfo.fileName(), channelInfo.bytes());
			GdtfGeometry top = topLevel.get(channelInfo.geometry());
			if (top != null && !channelInfo.overwrite()) {
				List<Integer> breaks = templateBreaks.computeIfAbsent(top.name(), t -> new ArrayList<>());
				if (!breaks.contains(channelInfo.dmxBreak()))
					breaks.add(channelInfo.dmxBreak());
			}
		}
		templateBreaks.values().forEach(breaks -> breaks.sort(null));

		List<GdtfDmxChannel> channels = new ArrayList<>();
		for (ParsedChannel channel : parsed)
			channels.addAll(channel(channel));

		List<GdtfDmxMode.Relation> relations = new ArrayList<>();
		if (mode.getRelations() != null) {
			for (var relation : mode.getRelations().getRelation())
				relations.add(new GdtfDmxMode.Relation(text(relation.getName(), ""), text(relation.getMaster(), ""),
						text(relation.getFollower(), ""),
						relation.getType() != null ? relation.getType().value() : "Multiply"));
		}
		return new GdtfDmxMode(mode.getName(), text(mode.getDescription(), ""), text(mode.getGeometry(), ""),
				channels, relations);
	}

	/**
	 * @return The channel, or one instance per reference if its geometry is referenced in this mode
	 */
	private List<GdtfDmxChannel> channel(ParsedChannel parsed) throws GdtfException {
		DMXChannel xml = parsed.xml();
		String geometry = parsed.geometry();
		String channelContext = parsed.context();
		List<Integer> offsets = parsed.offsets();
		int bytes = parsed.bytes();
		boolean overwrite = parsed.overwrite();
		int dmxBreak = parsed.dmxBreak();
		List<GdtfLogicalChannel> logicalChannels = logicalChannels(xml, bytes, channelContext);
		if (logicalChannels.isEmpty())
			throw new GdtfException(channelContext + " has no LogicalChannel");
		GdtfChannelFunction initial = initialFunction(xml, logicalChannels, channelContext);
		Long highlight = parse(() -> DmxValue.parseOptional(xml.getHighlight(), bytes), channelContext + " Highlight");

		GdtfGeometry template = topLevel.get(geometry);
		List<GdtfGeometry> instances = template != null && template != modeRoot
				? references.getOrDefault(template.name(), List.of())
				: List.of();
		if (instances.isEmpty()) {
			return List.of(new GdtfDmxChannel(name(geometry, logicalChannels), dmxBreak, offsets, bytes, geometry,
					null, geometry, highlight, initial, logicalChannels));
		}

		// the n-th Break of a reference applies to the n-th break the template uses, the last to "Overwrite"
		List<Integer> usedBreaks = templateBreaks.getOrDefault(template.name(), List.of());
		List<GdtfDmxChannel> result = new ArrayList<>();
		for (GdtfGeometry instance : instances) {
			List<GdtfGeometry.Break> breaks = instance.reference().breaks();
			int index = overwrite ? breaks.size() - 1 : usedBreaks.indexOf(dmxBreak);
			int instanceBreak = dmxBreak;
			List<Integer> instanceOffsets = offsets;
			if (index >= 0 && index < breaks.size()) {
				GdtfGeometry.Break brk = breaks.get(index);
				instanceBreak = brk.dmxBreak();
				int shift = brk.dmxOffset() - 1;
				instanceOffsets = offsets.stream().map(offset -> offset + shift).toList();
			} else {
				warnings.add(channelContext + ": reference " + instance.name() + " has no Break for "
						+ (overwrite ? "Overwrite" : "DMX break " + dmxBreak));
			}
			String instanceName = geometry.equals(template.name()) ? instance.name()
					: instance.name() + "." + geometry;
			result.add(new GdtfDmxChannel(name(instanceName, logicalChannels), instanceBreak, instanceOffsets,
					bytes, geometry, instance.name(), instanceName, highlight, initial, logicalChannels));
		}
		return result;
	}

	private List<GdtfLogicalChannel> logicalChannels(DMXChannel xml, int bytes, String channelContext)
			throws GdtfException {
		List<GdtfLogicalChannel> result = new ArrayList<>();
		for (LogicalChannel logical : xml.getLogicalChannel()) {
			String attribute = text(logical.getAttribute(), "NoFeature");
			String logicalContext = channelContext + ", LogicalChannel " + attribute;
			List<ChannelFunction> xmlFunctions = logical.getChannelFunction();

			// start values first, the end of a function is the start of the next one in the same mode range
			List<Long> starts = new ArrayList<>();
			List<String> modeKeys = new ArrayList<>();
			for (int i = 0; i < xmlFunctions.size(); i++) {
				ChannelFunction function = xmlFunctions.get(i);
				String functionName = text(function.getName(), text(function.getAttribute(), "NoFeature") + " " + (i + 1));
				starts.add(parse(() -> DmxValue.parse(text(function.getDMXFrom(), "0/1"), bytes),
						logicalContext + ", ChannelFunction " + functionName + " DMXFrom"));
				modeKeys.add(text(function.getModeMaster(), "") + "|" + text(function.getModeFrom(), "") + "|"
						+ text(function.getModeTo(), ""));
			}

			List<GdtfChannelFunction> functions = new ArrayList<>();
			for (int i = 0; i < xmlFunctions.size(); i++) {
				String modeKey = modeKeys.get(i);
				long end = endBefore(starts, i, DmxValue.max(bytes), j -> modeKeys.get(j).equals(modeKey));
				functions.add(function(xmlFunctions.get(i), i, attribute, starts.get(i), end, bytes,
						logicalContext));
			}
			result.add(new GdtfLogicalChannel(attribute, snap(logical), master(logical),
					or(logical.getMibFade(), 0), or(logical.getDMXChangeTimeLimit(), 0), functions));
		}
		return result;
	}

	private GdtfChannelFunction function(ChannelFunction xml, int index, String logicalAttribute, long from,
			long to, int bytes, String logicalContext) throws GdtfException {
		String attribute = text(xml.getAttribute(), "NoFeature");
		String name = text(xml.getName(), attribute + " " + (index + 1));
		String context = logicalContext + ", ChannelFunction " + name;
		long defaultValue = parse(() -> DmxValue.parse(text(xml.getDefault(), "0/1"), bytes), context + " Default");

		// a broken set only loses its name for a range, the function still works, so it is skipped
		List<GdtfChannelSet> sets = new ArrayList<>();
		List<ChannelSet> xmlSets = new ArrayList<>();
		List<Long> setStarts = new ArrayList<>();
		for (Object element : xml.getChannelSetAndSubChannelSet()) {
			if (!(element instanceof ChannelSet set))
				continue;
			try {
				setStarts.add(DmxValue.parse(text(set.getDMXFrom(), "0/1"), bytes));
				xmlSets.add(set);
			} catch (IllegalArgumentException e) {
				warnings.add(context + ", ChannelSet " + text(set.getName(), "") + " skipped: " + e.getMessage());
			}
		}
		for (int i = 0; i < xmlSets.size(); i++) {
			long end = endBefore(setStarts, i, to, j -> true);
			ChannelSet set = xmlSets.get(i);
			sets.add(new GdtfChannelSet(text(set.getName(), ""), setStarts.get(i), Math.max(setStarts.get(i), end),
					or(set.getPhysicalFrom(), Double.NaN), or(set.getPhysicalTo(), Double.NaN),
					set.getWheelSlotIndex() != null && set.getWheelSlotIndex() > 0 ? set.getWheelSlotIndex() : null));
		}

		String modeMaster = blankToNull(xml.getModeMaster());
		Long modeFrom = null;
		Long modeTo = null;
		if (modeMaster != null) {
			// the node may continue to a function of the master channel, the channel is the first part
			String masterChannel = modeMaster.split("\\.")[0];
			int masterBytes = bytesByChannel.getOrDefault(masterChannel, 1);
			if (!bytesByChannel.containsKey(masterChannel))
				warnings.add(context + " uses unknown ModeMaster " + modeMaster);
			modeFrom = parse(() -> DmxValue.parse(text(xml.getModeFrom(), "0/1"), masterBytes), context + " ModeFrom");
			modeTo = parse(() -> DmxValue.parse(text(xml.getModeTo(), "0/1"), masterBytes), context + " ModeTo");
		}

		double physicalFrom = or(xml.getPhysicalFrom(), 0);
		double physicalTo = or(xml.getPhysicalTo(), 1);
		return new GdtfChannelFunction(name, attribute, blankToNull(xml.getOriginalAttribute()), from, to,
				defaultValue, physicalFrom, physicalTo, or(xml.getRealFade(), 0), or(xml.getRealAcceleration(), 0),
				reference(wheels, xml.getWheel(), context, "wheel"),
				reference(emitters, xml.getEmitter(), context, "emitter"),
				reference(filters, xml.getFilter(), context, "filter"), blankToNull(xml.getColorSpace()),
				blankToNull(xml.getGammut()), modeMaster, modeFrom, modeTo, blankToNull(xml.getDMXProfile()),
				or(xml.getMin(), physicalFrom), or(xml.getMax(), physicalTo), blankToNull(xml.getCustomName()),
				sets);
	}

	/**
	 * InitialFunction is a node like "Beam_Dimmer.Dimmer.Dimmer 1": channel, logical channel, function
	 */
	private GdtfChannelFunction initialFunction(DMXChannel xml, List<GdtfLogicalChannel> logicalChannels,
			String channelContext) throws GdtfException {
		GdtfChannelFunction first = logicalChannels.get(0).functions().isEmpty() ? null
				: logicalChannels.get(0).functions().get(0);
		String node = blankToNull(xml.getInitialFunction());
		if (node != null) {
			String[] parts = node.split("\\.");
			String functionName = parts[parts.length - 1];
			String logicalName = parts.length >= 2 ? parts[parts.length - 2] : null;
			for (GdtfLogicalChannel logical : logicalChannels) {
				if (logicalName != null && !logical.attribute().equals(logicalName))
					continue;
				for (GdtfChannelFunction function : logical.functions()) {
					if (function.name().equals(functionName))
						return function;
				}
			}
			warnings.add(channelContext + " uses unknown InitialFunction " + node);
		}
		if (first == null)
			throw new GdtfException(channelContext + " has no ChannelFunction");
		return first;
	}

	private ParsedChannel parseChannel(DMXChannel xml) throws GdtfException {
		String fileName = fileName(xml);
		String channelContext = context + ", DMXChannel " + fileName;
		String geometry = required(xml.getGeometry(), context + " DMXChannel Geometry");
		List<Integer> offsets = offsets(xml, channelContext);
		String breakText = text(xml.getDMXBreak(), "1").strip();
		boolean overwrite = breakText.equalsIgnoreCase("Overwrite");
		int dmxBreak = overwrite ? 1 : integer(breakText, channelContext + " DMXBreak");
		return new ParsedChannel(xml, fileName, channelContext, geometry, offsets, bytes(xml, offsets), dmxBreak,
				overwrite);
	}

	private static List<Integer> offsets(DMXChannel xml, String channelContext) throws GdtfException {
		String text = text(xml.getOffset(), "None").strip();
		if (text.isEmpty() || text.equalsIgnoreCase("None"))
			return List.of();
		List<Integer> offsets = new ArrayList<>();
		for (String part : text.split(","))
			offsets.add(integer(part.strip(), channelContext + " Offset"));
		if (offsets.size() > DmxValue.MAX_BYTES)
			throw new GdtfException(channelContext + " has more than " + DmxValue.MAX_BYTES + " bytes");
		return offsets;
	}

	/**
	 * Virtual channels have no offsets, their resolution follows from the values they use
	 */
	private static int bytes(DMXChannel xml, List<Integer> offsets) {
		if (!offsets.isEmpty())
			return offsets.size();
		int bytes = 1;
		for (LogicalChannel logical : xml.getLogicalChannel()) {
			for (ChannelFunction function : logical.getChannelFunction()) {
				bytes = Math.max(bytes, DmxValue.byteCount(function.getDMXFrom()));
				bytes = Math.max(bytes, DmxValue.byteCount(function.getDefault()));
			}
		}
		return bytes;
	}

	/**
	 * Name of the channel in the file, used by ModeMaster and InitialFunction
	 */
	private static String fileName(DMXChannel xml) {
		String attribute = xml.getLogicalChannel().isEmpty() ? "" : text(xml.getLogicalChannel().get(0).getAttribute(), "");
		return text(xml.getGeometry(), "") + "_" + attribute;
	}

	private static String name(String geometry, List<GdtfLogicalChannel> logicalChannels) {
		return geometry + "_" + logicalChannels.get(0).attribute();
	}

	private static GdtfLogicalChannel.Snap snap(LogicalChannel logical) {
		return logical.getSnap() == null ? GdtfLogicalChannel.Snap.NO
				: GdtfLogicalChannel.Snap.valueOf(logical.getSnap().name());
	}

	private static GdtfLogicalChannel.Master master(LogicalChannel logical) {
		return logical.getMaster() == null ? GdtfLogicalChannel.Master.NONE
				: GdtfLogicalChannel.Master.valueOf(logical.getMaster().name());
	}

	private <T> T reference(Map<String, T> known, String name, String context, String kind) {
		String key = blankToNull(name);
		if (key == null)
			return null;
		T value = known.get(key);
		if (value == null)
			warnings.add(context + " uses unknown " + kind + " " + key);
		return value;
	}

	/**
	 * GDTF only stores where a range starts. It ends before the next larger start among the ranges that count,
	 * or at {@code max}.
	 */
	private static long endBefore(List<Long> starts, int index, long max, IntPredicate counts) {
		long end = max;
		for (int j = 0; j < starts.size(); j++) {
			if (counts.test(j) && starts.get(j) > starts.get(index))
				end = Math.min(end, starts.get(j) - 1);
		}
		return end;
	}

}
