package de.verschwiegener.gdtf4j.geometry;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.math.GDTFMatrix4f;

public class GenericGeometry1 extends BaseGeometry {

	private GDTFMatrix4f position;
	
	public GenericGeometry1(GeometryTypes type) {
		super(type);
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		position = GDTFMatrix4f.fromString(getItemNullSave(node.getAttributes(), "Position"));
		return getClass();
	}
}
