package de.verschwiegener.gdtf4j.attribute;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.PhysicalUnit;
import de.verschwiegener.gdtf4j.util.exception.GDTFException;
import de.verschwiegener.gdtf4j.util.math.GDTFVector3f;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

/**
 * 
 * @author Verschwiegener
 *
 */
public class AttributeDefinition {

	/**
	 * Defines which attributes are to be activated together. For example, Pan and
	 * Tilt are in the same activation group.
	 */
	private final ArrayList<GenericNameNode> activationGroup = new ArrayList<GenericNameNode>();

	private final ArrayList<FeatureGroup> featureGroup = new ArrayList<FeatureGroup>();

	private final ArrayList<Attribute> attributes = new ArrayList<Attribute>();

	public AttributeDefinition(Node node, GDTF gdtf) {
		addChildrenToArrayList(GenericNameNode.class, activationGroup, node, "ActivationGroups", "ActivationGroup",
				gdtf);
		addChildrenToArrayList(FeatureGroup.class, featureGroup, node, "FEatureGroups", "FeatureGroup",
				gdtf);
		addChildrenToArrayList(Attribute.class, attributes, node, "Attributes", "Attribute",
				gdtf);
	}

	/**
	 * Returns the ActivationGroup by its unique Name
	 * 
	 * @param name String unique Name of ActivationGroup
	 * @return GenericNameNode ActivationGroup
	 */
	public GenericNameNode getActivationGroupByName(String name) {
		return activationGroup.stream().filter(group -> group.getName().equals(name)).findFirst().orElse(null);
	}
	/**
	 * Returns the Attribute by its unique Name
	 * 
	 * @param name String unique Name of Attribute
	 * @return Attribute attribute
	 */
	public Attribute getAttributeByName(String name) {
		return attributes.stream().filter(attr -> attr.getName().equals(name)).findFirst().orElse(null);
	}

	/**
	 * Returns the Feature of a FeatureGroup by its Node name (e.g. Color.RGB /
	 * Color.Color)
	 * 
	 * 
	 * @param name String Node name of the Feature, has to be splitted by a dot
	 * @return GenericNameNode Feature
	 */
	public GenericNameNode getFeatureGroupFeatureByNodeName(String name) {
		if (!name.contains("."))
			throw new GDTFException("Invalid FeatureGroup Node Name: " + name);
		String[] components = name.split(".");
		if (components.length < 2)
			throw new GDTFException("Invalid FeatureGroup Node Name: " + name);
		return getFeatureGroupByName(components[0]).getFeatureByName(components[1]);
	}

	/**
	 * Returns the FeatureGroup to the Corresponding unique name
	 * 
	 * @param name String unique Name of the FeatureGroup
	 * @return FeatureGroup
	 */
	public FeatureGroup getFeatureGroupByName(String name) {
		return featureGroup.stream().filter(group -> group.getName().equals(name)).findFirst().orElse(null);
	}

}
