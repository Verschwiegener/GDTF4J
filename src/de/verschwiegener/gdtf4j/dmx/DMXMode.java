package de.verschwiegener.gdtf4j.dmx;

import java.util.ArrayList;

import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.geometry.Geometry;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;


import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

public class DMXMode extends GenericNameNode {

	private Geometry geometry;

	private ArrayList<DMXChannel> channel = new ArrayList<DMXChannel>();
	private ArrayList<Relation> relations = new ArrayList<Relation>();
	private ArrayList<Macro> macros = new ArrayList<Macro>();

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		geometry = gdtf.getGeometryByName(GDTFUtil.getItemNullSave(node, "Geometry"));
		
		
		addChildrenToArrayList(DMXChannel.class, channel, node, "DMXChannels",  "DMXChannel", gdtf);
		addChildrenToArrayList(Relation.class, relations, node, "Relations",  "Relation", gdtf);
		addChildrenToArrayList(Macro.class, macros, node, "FTMacros",  "FTMacro", gdtf);
		return getClass();
	}

}
