package de.verschwiegener.gdtf4j.attribute;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;


import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

/**
 * 
 * Describes the logical grouping of attributes. For example, Gobo 1 and
 * Gobo 2 are grouped in the feature Gobo of the feature group Gobo.
 * 
 * @author Verschwiegener
 *
 */
public class FeatureGroup extends GenericNameNode{
	/**
	 * The pretty name of the FeatureGroup
	 */
	private String pretty;
	private ArrayList<GenericNameNode> feature;
	public FeatureGroup() {
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		feature = new ArrayList<GenericNameNode>();
		pretty = GDTFUtil.getItemNullSave(node.getAttributes(), "Pretty");
		
		addChildrenToArrayList(GenericNameNode.class, feature, node, "Feature", gdtf);
		return getClass();
	}
	public String getPretty() {
		return pretty;
	}
	public ArrayList<GenericNameNode> getFeature() {
		return feature;
	}
	public boolean addFeature(String name) {
		return feature.add(new GenericNameNode(name));
	}
	/**
	 * Returns the child Feature of this FeatureGroup by its unique name
	 * 
	 * @param name String the name of the Feature to return
	 */
	public GenericNameNode getFeatureByName(String name) {
		return feature.stream().filter(feature -> feature.getName().equals(name)).findFirst().orElse(null);
	}

}
