package de.verschwiegener.gdtf4j.attribute;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.PhysicalUnit;
import de.verschwiegener.gdtf4j.util.math.GDTFVector3f;

/**
 * List of Fixture Type Attributes that are used. Predefindes fixtury type
 * attributes can be found in Annex A.
 * 
 * @author Verschwiegener
 */
public class Attribute extends GenericNameNode {
	private String pretty;
	private String activationGroup;
	private String feature;
	private String mainAttribute;
	private PhysicalUnit physicalUnit = PhysicalUnit.NONE;
	private GDTFVector3f color;

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		pretty = GDTFUtil.getItemNullSave(map, "Pretty");
		activationGroup = GDTFUtil.getItemNullSave(map, "ActivationGroup");
		feature = GDTFUtil.getItemNullSave(map, "Feature");
		mainAttribute = GDTFUtil.getItemNullSave(map, "MainAttribute");
		physicalUnit = PhysicalUnit.valueOf(GDTFUtil.getItemNullSave(map, "PhysicalUnit").toUpperCase());
		color = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "Color"));
		return getClass();
	}

}
