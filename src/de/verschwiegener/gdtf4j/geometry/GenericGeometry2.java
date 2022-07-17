package de.verschwiegener.gdtf4j.geometry;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.math.GDTFMatrix4f;

public class GenericGeometry2 extends BaseGeometry{

	private String model;
	private GDTFMatrix4f position;
	
	public GenericGeometry2(GeometryTypes type) {
		super(type);
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		model = getItemNullSave(map, "Model");
		position = GDTFMatrix4f.fromString(getItemNullSave(map, "Position"));
		return getClass();
	}
}
