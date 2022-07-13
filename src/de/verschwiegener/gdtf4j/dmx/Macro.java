package de.verschwiegener.gdtf4j.dmx;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.DMXValue;
import de.verschwiegener.gdtf4j.util.GDTFUtil;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

import java.util.ArrayList;

import de.verschwiegener.gdtf4j.util.GenericNameNode;

public class Macro extends GenericNameNode{
	
	private ArrayList<MacroDMXStep> macroDMXStep = new ArrayList<Macro.MacroDMXStep>();

	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		addChildrenToArrayList(Macro.MacroDMXStep.class, macroDMXStep, node, "MacroDMXStep", gdtf);
		return getClass();
	}
	
	class MacroDMXStep extends GDTFClass{
		
		private ArrayList<MacroDMXValue> macroDMXValue = new ArrayList<Macro.MacroDMXStep.MacroDMXValue>();
		private float duration;
		
		@Override
		public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
			duration = getFloatNullSave(node, "Duration", 0);
			addChildrenToArrayList(Macro.MacroDMXStep.MacroDMXValue.class, macroDMXValue, node, "MacroDMXValue", gdtf);
			return getClass();
		}
		
		
		class MacroDMXValue extends GDTFClass{
			
			private DMXValue dmxValue;
			private String dmxChannel;
			
			@Override
			public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
				NamedNodeMap map = node.getAttributes();
				dmxValue = new DMXValue(getItemNullSave(map, "DMXValue"));
				dmxChannel = getItemNullSave(map, "DMXChannel");
				return getClass();
			}
			
		}
	}

}
