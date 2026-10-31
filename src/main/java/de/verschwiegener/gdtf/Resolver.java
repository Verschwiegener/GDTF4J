package de.verschwiegener.gdtf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import de.verschwiegener.gdtf.model.CieColor;
import de.verschwiegener.gdtf.model.DmxValue;
import de.verschwiegener.gdtf.model.GdtfAttribute;
import de.verschwiegener.gdtf.model.GdtfChannelFunction;
import de.verschwiegener.gdtf.model.GdtfChannelSet;
import de.verschwiegener.gdtf.model.GdtfDmxChannel;
import de.verschwiegener.gdtf.model.GdtfDmxMode;
import de.verschwiegener.gdtf.model.GdtfFeatureGroup;
import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.model.GdtfGeometry;
import de.verschwiegener.gdtf.model.GdtfLogicalChannel;
import de.verschwiegener.gdtf.model.GdtfMatrix;
import de.verschwiegener.gdtf.model.GdtfModel;
import de.verschwiegener.gdtf.model.GdtfPhysical;
import de.verschwiegener.gdtf.model.GdtfWheel;
import de.verschwiegener.gdtf.xml.BasicGeometryAttributes;
import de.verschwiegener.gdtf.xml.BasicGeometryType;
import de.verschwiegener.gdtf.xml.Beam;
import de.verschwiegener.gdtf.xml.ChannelFunction;
import de.verschwiegener.gdtf.xml.ChannelSet;
import de.verschwiegener.gdtf.xml.DMXChannel;
import de.verschwiegener.gdtf.xml.DMXMode;
import de.verschwiegener.gdtf.xml.FixtureType;
import de.verschwiegener.gdtf.xml.GDTF;
import de.verschwiegener.gdtf.xml.GeometryReference;
import de.verschwiegener.gdtf.xml.LogicalChannel;
import de.verschwiegener.gdtf.xml.PhysicalDescriptions;
import jakarta.xml.bind.JAXBElement;

/**
 * Turns the generated XML classes into the resolved model: DMX values in the resolution of their channel, ranges
 * with end values, references to wheels, emitters and filters as objects and channels of referenced geometries
 * repeated per reference.
 * <p>
 * Problems a real file may have (unknown references, broken colors) become warnings. Problems that make the
 * result wrong (invalid DMX values or offsets) fail with the element they occur in.
 */
final class Resolver {

	private final GDTF root;
	private final FixtureType type;
	private final List<String> warnings = new ArrayList<>();
	private final Map<String, GdtfWheel> wheels = new LinkedHashMap<>();
	private final Map<String, GdtfPhysical.Emitter> emitters = new LinkedHashMap<>();
	private final Map<String, GdtfPhysical.Filter> filters = new LinkedHashMap<>();
	private int unnamedGeometries;

	Resolver(GDTF root) {
		this.root = root;
		this.type = Objects.requireNonNull(root.getFixtureType(), "FixtureType");
	}

	List<String> warnings() {
		return List.copyOf(warnings);
	}

	GdtfFixtureType resolve() throws GdtfException {
		List<GdtfFeatureGroup> featureGroups = new ArrayList<>();
		List<String> activationGroups = new ArrayList<>();
		List<GdtfAttribute> attributes = new ArrayList<>();
		if (type.getAttributeDefinitions() != null) {
			var definitions = type.getAttributeDefinitions();
			if (definitions.getActivationGroups() != null)
				definitions.getActivationGroups().getActivationGroup().forEach(group -> activationGroups.add(group.getName()));
			if (definitions.getFeatureGroups() != null) {
				for (var group : definitions.getFeatureGroups().getFeatureGroup())
					featureGroups.add(new GdtfFeatureGroup(group.getName(), text(group.getPretty(), group.getName()),
							group.getFeature().stream().map(feature -> feature.getName()).toList()));
			}
			if (definitions.getAttributes() != null) {
				for (var attribute : definitions.getAttributes().getAttribute())
					attributes.add(attribute(attribute));
			}
		}

		resolvePhysical(type.getPhysicalDescriptions());
		resolveWheels();

		List<GdtfModel> models = new ArrayList<>();
		if (type.getModels() != null) {
			for (var model : type.getModels().getModel())
				models.add(new GdtfModel(model.getName(), model.getLength(), model.getWidth(), model.getHeight(),
						model.getPrimitiveType() != null ? model.getPrimitiveType().value() : "Undefined",
						blankToNull(model.getFile())));
		}

		List<GdtfGeometry> geometries = new ArrayList<>();
		if (type.getGeometries() != null) {
			for (JAXBElement<?> element : type.getGeometries().getGeometryOrAxisOrFilterBeam())
				geometries.add(geometry(element));
		}

		List<GdtfDmxMode> modes = new ArrayList<>();
		if (type.getDMXModes() != null) {
			for (DMXMode mode : type.getDMXModes().getDMXMode())
				modes.add(new ModeResolver(mode, geometries).resolve());
		}

		List<GdtfFixtureType.Revision> revisions = new ArrayList<>();
		if (type.getRevisions() != null) {
			for (var revision : type.getRevisions().getRevision())
				revisions.add(new GdtfFixtureType.Revision(text(revision.getText(), ""),
						revision.getDate() != null ? revision.getDate().toXMLFormat() : null,
						blankToNull(revision.getModifiedBy())));
		}

		return new GdtfFixtureType(dataVersion(), required(type.getFixtureTypeID(), "FixtureTypeID"),
				required(type.getName(), "Name"), text(type.getShortName(), ""), text(type.getLongName(), ""),
				text(type.getManufacturer(), ""), text(type.getDescription(), ""), blankToNull(type.getThumbnail()),
				blankToNull(type.getRefFT()),
				type.getCanHaveChildren() == null || "Yes".equals(type.getCanHaveChildren().value()), revisions,
				featureGroups, activationGroups, attributes, List.copyOf(wheels.values()),
				List.copyOf(emitters.values()), List.copyOf(filters.values()), colorSpace(type.getPhysicalDescriptions()),
				models, geometries, modes);
	}

	private String dataVersion() {
		String version = Float.toString(root.getDataVersion());
		return version.endsWith(".0") ? version.substring(0, version.length() - 2) : version;
	}

	private GdtfAttribute attribute(de.verschwiegener.gdtf.xml.Attribute attribute) {
		String featureGroup = null;
		String feature = null;
		String path = blankToNull(attribute.getFeature());
		if (path != null) {
			int dot = path.indexOf('.');
			featureGroup = dot < 0 ? path : path.substring(0, dot);
			feature = dot < 0 ? null : path.substring(dot + 1);
		}
		return new GdtfAttribute(attribute.getName(), text(attribute.getPretty(), attribute.getName()), featureGroup,
				feature, blankToNull(attribute.getActivationGroup()), blankToNull(attribute.getMainAttribute()),
				attribute.getPhysicalUnit() != null ? attribute.getPhysicalUnit().value() : "None",
				color(attribute.getColor(), () -> "Attribute " + attribute.getName()));
	}

	private void resolvePhysical(PhysicalDescriptions physical) {
		if (physical == null)
			return;
		if (physical.getEmitters() != null) {
			for (var emitter : physical.getEmitters().getEmitter()) {
				emitters.put(emitter.getName(), new GdtfPhysical.Emitter(emitter.getName(),
						color(emitter.getColor(), () -> "Emitter " + emitter.getName()),
						emitter.getDominantWaveLength() != null ? emitter.getDominantWaveLength().doubleValue() : null,
						blankToNull(emitter.getDiodePart())));
			}
		}
		if (physical.getFilters() != null) {
			for (var filter : physical.getFilters().getFilter())
				filters.put(filter.getName(), new GdtfPhysical.Filter(filter.getName(),
						color(filter.getColor(), () -> "Filter " + filter.getName())));
		}
	}

	private GdtfPhysical.ColorSpace colorSpace(PhysicalDescriptions physical) {
		if (physical == null || physical.getColorSpace() == null)
			return new GdtfPhysical.ColorSpace(null, "sRGB", null, null, null, null);
		var space = physical.getColorSpace();
		String mode = space.getMode() != null ? space.getMode().value() : "sRGB";
		boolean custom = mode.equals("Custom");
		return new GdtfPhysical.ColorSpace(blankToNull(space.getName()), mode,
				custom ? color(space.getRed(), () -> "ColorSpace red") : null,
				custom ? color(space.getGreen(), () -> "ColorSpace green") : null,
				custom ? color(space.getBlue(), () -> "ColorSpace blue") : null,
				custom ? color(space.getWhitePoint(), () -> "ColorSpace white point") : null);
	}

	private void resolveWheels() throws GdtfException {
		if (type.getWheels() == null)
			return;
		for (var wheel : type.getWheels().getWheel()) {
			List<GdtfWheel.Slot> slots = new ArrayList<>();
			int index = 1;
			for (var slot : wheel.getSlot()) {
				String context = "Wheel " + wheel.getName() + ", Slot " + index;
				List<GdtfWheel.Facet> facets = new ArrayList<>();
				for (var facet : slot.getFacet())
					facets.add(new GdtfWheel.Facet(color(facet.getColor(), () -> context + " facet"),
							matrix(facet.getRotation(), context + " facet")));
				String filter = blankToNull(slot.getFilter());
				if (filter != null && !filters.containsKey(filter))
					warnings.add(context + " uses unknown filter " + filter);
				slots.add(new GdtfWheel.Slot(index++, text(slot.getName(), ""),
						color(slot.getColor(), () -> context), filter, blankToNull(slot.getMediaFileName()), facets));
			}
			wheels.put(wheel.getName(), new GdtfWheel(wheel.getName(), slots));
		}
	}

	private GdtfGeometry geometry(JAXBElement<?> element) throws GdtfException {
		BasicGeometryAttributes geometry = (BasicGeometryAttributes) element.getValue();
		GdtfGeometry.Type kind = GdtfGeometry.Type.ofElement(element.getName().getLocalPart());
		String context = element.getName().getLocalPart() + " " + geometry.getName();

		List<GdtfGeometry> children = new ArrayList<>();
		if (geometry instanceof BasicGeometryType parent) {
			for (JAXBElement<?> child : parent.getGeometryOrAxisOrFilterBeam())
				children.add(geometry(child));
		}
		GdtfGeometry.Beam beam = geometry instanceof Beam b ? beam(b) : null;
		GdtfGeometry.Reference reference = null;
		if (geometry instanceof GeometryReference r) {
			List<GdtfGeometry.Break> breaks = r.getBreak().stream()
					.map(b -> new GdtfGeometry.Break(b.getDMXBreak(), b.getDMXOffset())).toList();
			reference = new GdtfGeometry.Reference(required(r.getGeometry(), context + " Geometry"), breaks);
		}
		String model = blankToNull(geometry.getModel());
		if (model != null && type.getModels() != null
				&& type.getModels().getModel().stream().noneMatch(m -> model.equals(m.getName())))
			warnings.add(context + " uses unknown model " + model);
		String name = blankToNull(geometry.getName());
		if (name == null) {
			name = element.getName().getLocalPart() + " " + ++unnamedGeometries;
			warnings.add(element.getName().getLocalPart() + " without name, called it " + name);
		}
		return new GdtfGeometry(kind, name, model, matrix(geometry.getPosition(), context), children, beam,
				reference);
	}

	private static GdtfGeometry.Beam beam(Beam beam) {
		return new GdtfGeometry.Beam(beam.getLampType() != null ? beam.getLampType().value() : "Discharge",
				beam.getBeamType() != null ? beam.getBeamType().value() : "Wash", or(beam.getPowerConsumption(), 1000),
				or(beam.getLuminousFlux(), 10000), or(beam.getColorTemperature(), 6000), or(beam.getBeamAngle(), 25),
				or(beam.getFieldAngle(), 25), or(beam.getBeamRadius(), 0.05), or(beam.getThrowRatio(), 1),
				or(beam.getRectangleRatio(), 1.7777), beam.getColorRenderingIndex() != null
						? beam.getColorRenderingIndex()
						: 100,
				blankToNull(beam.getEmitterSpectrum()));
	}

	/**
	 * Resolves one DMX mode
	 */
	private final class ModeResolver {

		private final DMXMode mode;
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

		ModeResolver(DMXMode mode, List<GdtfGeometry> geometries) throws GdtfException {
			this.mode = mode;
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
			for (DMXChannel channel : xmlChannels) {
				bytesByChannel.put(fileName(channel), bytes(channel, offsets(channel)));
				GdtfGeometry top = topLevel.get(text(channel.getGeometry(), ""));
				String breakText = text(channel.getDMXBreak(), "1").strip();
				if (top != null && !breakText.equalsIgnoreCase("Overwrite")) {
					List<Integer> breaks = templateBreaks.computeIfAbsent(top.name(), t -> new ArrayList<>());
					int dmxBreak = integer(breakText, context + ", DMXChannel " + fileName(channel) + " DMXBreak");
					if (!breaks.contains(dmxBreak))
						breaks.add(dmxBreak);
				}
			}
			templateBreaks.values().forEach(breaks -> breaks.sort(null));

			List<GdtfDmxChannel> channels = new ArrayList<>();
			for (DMXChannel channel : xmlChannels)
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
		private List<GdtfDmxChannel> channel(DMXChannel xml) throws GdtfException {
			String geometry = required(xml.getGeometry(), context + " DMXChannel Geometry");
			String channelContext = context + ", DMXChannel " + fileName(xml);
			List<Integer> offsets = offsets(xml);
			int bytes = bytes(xml, offsets);
			List<GdtfLogicalChannel> logicalChannels = logicalChannels(xml, bytes, channelContext);
			if (logicalChannels.isEmpty())
				throw new GdtfException(channelContext + " has no LogicalChannel");
			GdtfChannelFunction initial = initialFunction(xml, logicalChannels, channelContext);
			Long highlight = dmx(() -> DmxValue.parseOptional(xml.getHighlight(), bytes), channelContext + " Highlight");

			String breakText = text(xml.getDMXBreak(), "1").strip();
			boolean overwrite = breakText.equalsIgnoreCase("Overwrite");
			int dmxBreak = overwrite ? 1 : integer(breakText, channelContext + " DMXBreak");

			GdtfGeometry template = topLevel.get(geometry);
			List<GdtfGeometry> instances = template != null && template != modeRoot
					? references.getOrDefault(template.name(), List.of())
					: List.of();
			if (instances.isEmpty()) {
				return List.of(new GdtfDmxChannel(name(geometry, logicalChannels), dmxBreak, offsets, bytes, geometry,
						null, highlight, initial, logicalChannels));
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
						bytes, geometry, instance.name(), highlight, initial, logicalChannels));
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
					starts.add(dmx(() -> DmxValue.parse(text(function.getDMXFrom(), "0/1"), bytes),
							logicalContext + ", ChannelFunction " + functionName + " DMXFrom"));
					modeKeys.add(text(function.getModeMaster(), "") + "|" + text(function.getModeFrom(), "") + "|"
							+ text(function.getModeTo(), ""));
				}

				List<GdtfChannelFunction> functions = new ArrayList<>();
				for (int i = 0; i < xmlFunctions.size(); i++) {
					long end = DmxValue.max(bytes);
					for (int j = 0; j < xmlFunctions.size(); j++) {
						if (modeKeys.get(j).equals(modeKeys.get(i)) && starts.get(j) > starts.get(i))
							end = Math.min(end, starts.get(j) - 1);
					}
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
			long defaultValue = dmx(() -> DmxValue.parse(text(xml.getDefault(), "0/1"), bytes), context + " Default");

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
				long end = to;
				for (long start : setStarts) {
					if (start > setStarts.get(i))
						end = Math.min(end, start - 1);
				}
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
				modeFrom = dmx(() -> DmxValue.parse(text(xml.getModeFrom(), "0/1"), masterBytes), context + " ModeFrom");
				modeTo = dmx(() -> DmxValue.parse(text(xml.getModeTo(), "0/1"), masterBytes), context + " ModeTo");
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
				String channelContext) {
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
				throw new IllegalStateException(channelContext + " has no ChannelFunction");
			return first;
		}

		private List<Integer> offsets(DMXChannel xml) throws GdtfException {
			String text = text(xml.getOffset(), "None").strip();
			if (text.isEmpty() || text.equalsIgnoreCase("None"))
				return List.of();
			List<Integer> offsets = new ArrayList<>();
			for (String part : text.split(","))
				offsets.add(integer(part.strip(), context + ", DMXChannel " + fileName(xml) + " Offset"));
			if (offsets.size() > DmxValue.MAX_BYTES)
				throw new GdtfException(context + ", DMXChannel " + fileName(xml) + " has more than "
						+ DmxValue.MAX_BYTES + " bytes");
			return offsets;
		}

		/**
		 * Virtual channels have no offsets, their resolution follows from the values they use
		 */
		private int bytes(DMXChannel xml, List<Integer> offsets) {
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

	private CieColor color(String text, Supplier<String> context) {
		try {
			return CieColor.parse(text);
		} catch (IllegalArgumentException e) {
			warnings.add(context.get() + ": " + e.getMessage());
			return null;
		}
	}

	private static GdtfMatrix matrix(String text, String context) throws GdtfException {
		try {
			return GdtfMatrix.parse(text);
		} catch (IllegalArgumentException e) {
			throw new GdtfException(context + ": " + e.getMessage(), e);
		}
	}

	@FunctionalInterface
	private interface DmxParse<T> {

		T parse();

	}

	private static <T> T dmx(DmxParse<T> parse, String context) throws GdtfException {
		try {
			return parse.parse();
		} catch (IllegalArgumentException e) {
			throw new GdtfException(context + ": " + e.getMessage(), e);
		}
	}

	private static int integer(String text, String context) throws GdtfException {
		try {
			return Integer.parseInt(text.strip());
		} catch (NumberFormatException e) {
			throw new GdtfException(context + ": not a number: " + text, e);
		}
	}

	private static String required(String value, String context) throws GdtfException {
		if (value == null || value.isBlank())
			throw new GdtfException(context + " is missing");
		return value;
	}

	private static String text(String value, String fallback) {
		return value == null || value.isBlank() ? fallback : value;
	}

	private static String blankToNull(String value) {
		return value == null || value.isBlank() ? null : value;
	}

	private static double or(Number value, double fallback) {
		return value != null ? value.doubleValue() : fallback;
	}

}
