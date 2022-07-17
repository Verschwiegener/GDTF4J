package de.verschwiegener.gdtf4j.geometry;

import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;


import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

public class TypeDisplay extends GenericGeometry2{

	private String texture;

	public TypeDisplay(GeometryTypes type) {
		super(type);
	}

	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		texture = getItemNullSave(node, "Texture");
		return getClass();
	}

}
