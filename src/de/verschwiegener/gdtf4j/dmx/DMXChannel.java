package de.verschwiegener.gdtf4j.dmx;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.attribute.Attribute;
import de.verschwiegener.gdtf4j.funktion.Wheel;
import de.verschwiegener.gdtf4j.geometry.Geometry;
import de.verschwiegener.gdtf4j.physical.Emitter;
import de.verschwiegener.gdtf4j.physical.Filter;
import de.verschwiegener.gdtf4j.util.DMXValue;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.Unit;
import de.verschwiegener.gdtf4j.util.ValueUnit;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import java.util.ArrayList;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getIntegerNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

public class DMXChannel extends GDTFClass {

	private int dmxBreak;
	private int[] offset;
	private String initialFunktion;
	private DMXValue highlight;
	private Geometry geometry;
	private ArrayList<LogicalChannel> logicChannel = new ArrayList<DMXChannel.LogicalChannel>();

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		NamedNodeMap map = node.getAttributes();
		initialFunktion = getItemNullSave(map, "InitialFunktion");
		geometry = gdtf.getGeometryByName(getItemNullSave(map, "Geometry"));
		String DMXBreak = getItemNullSave(map, "DMXBreak");
		offset = toIntArray(getItemNullSave(map, "Offset"));
		String hightlight = getItemNullSave(map, "Highlight");
		if (!hightlight.contentEquals("None"))
			highlight = new DMXValue(hightlight);
		if (DMXBreak.equals("Overwrite"))
			this.dmxBreak = geometry.getDmxBreak().getDmxBreak();

		addChildrenToArrayList(DMXChannel.LogicalChannel.class, logicChannel, node, "LogicChannel", gdtf);

		return getClass();
	}

	private int[] toIntArray(String in) {
		String[] content = in.split(",");
		int[] offset = new int[content.length];
		for (int i = 0; i < content.length; i++) {
			offset[i] = Integer.valueOf(content[i]);
		}
		return offset;
	}

	class LogicalChannel extends GDTFClass {

		private Attribute attribute;
		private Snap snap = Snap.NO;
		private Master master = Master.NONE;
		private Unit<?, Float> mibFade;
		private Unit<?, Float> dmxChangeTimeLimit;
		private ArrayList<ChannelFunktion> channelFunktions = new ArrayList<DMXChannel.ChannelFunktion>();

		@Override
		public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
			NamedNodeMap map = node.getAttributes();
			attribute = gdtf.attributeDefinition.getAttributeByName(getItemNullSave(map, "Attribute"));
			String snap = getItemNullSave(map, "Snap");
			if (!snap.isEmpty())
				this.snap = Snap.valueOf(snap);
			String master = getItemNullSave(map, "Master");
			if (!master.isEmpty())
				this.master = Master.valueOf(master);
			mibFade = new Unit<>(getFloatNullSave(map, "MibFade", 0), Float.class, ValueUnit.SECONDS);
			dmxChangeTimeLimit = new Unit<>(getFloatNullSave(map, "DMXChangeTimeLiit", 0), Float.class,
					ValueUnit.SECONDS);

			addChildrenToArrayList(DMXChannel.ChannelFunktion.class, channelFunktions, node, "ChannelFunktion", gdtf);

			return getClass();
		}
	}

	class ChannelFunktion extends GenericNameNode {

		private String attribute;
		private String originalAttribute;
		private DMXValue dmxFrom;
		private DMXValue defaultDMX;
		private float physicalFrom;
		private float physicalTo;
		private Unit<?, Float> realFade;
		private Unit<?, Float> realAcceleration;
		private Wheel wheel;
		private Emitter emitter;
		private Filter filter;
		private String modeMaster;
		private DMXValue modeFrom;
		private DMXValue modeTo;

		private ArrayList<ChannelSet> channelSet = new ArrayList<DMXChannel.ChannelFunktion.ChannelSet>();

		@Override
		public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
			super.fromXML(node, gdtf);
			NamedNodeMap map = node.getAttributes();
			attribute = getItemNullSave(map, "Attribute");
			originalAttribute = getItemNullSave(map, "OriginalAttribute");
			dmxFrom = new DMXValue(getItemNullSave(map, "DMXFrom"));
			defaultDMX = new DMXValue(getItemNullSave(map, "Default"));
			physicalFrom = getFloatNullSave(map, "PhysicalFrom", 0);
			physicalTo = getFloatNullSave(map, "PhysicalTo", 0);
			realFade = new Unit<>(getFloatNullSave(map, "RealFade", 0), Float.class, ValueUnit.SECONDS);
			realAcceleration = new Unit<>(getFloatNullSave(map, "RealAcceleration", 0), Float.class, ValueUnit.SECONDS);
			wheel = gdtf.getWheelByName(getItemNullSave(map, "Wheel"));
			emitter = gdtf.getEmitterByName(getItemNullSave(map, "Emitter"));
			filter = gdtf.getFilterByName(getItemNullSave(map, "Filter"));
			modeMaster = getItemNullSave(map, "ModeMaster");
			modeFrom = new DMXValue(getItemNullSave(map, "ModeFrom"));
			modeTo = new DMXValue(getItemNullSave(map, "ModeTo"));

			addChildrenToArrayList(DMXChannel.ChannelFunktion.ChannelSet.class, channelSet, node, "ChannelSet", gdtf);
			return getClass();
		}

		class ChannelSet extends GenericNameNode {

			private DMXValue dmxFrom;
			private float physicalFrom;
			private float physicalTo;
			private int wheelSlotIndex;

			@Override
			public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
				super.fromXML(node, gdtf);
				NamedNodeMap map = node.getAttributes();
				dmxFrom = new DMXValue(getItemNullSave(map, "DMXFrom"));
				physicalFrom = getFloatNullSave(map, "PhysicalFrom", 0);
				physicalTo = getFloatNullSave(map, "PhysicalTo", 1);
				wheelSlotIndex = getIntegerNullSave(map, "WheelSlotIndex", 0);
				return getClass();
			}
		}
	}
}
