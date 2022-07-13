package de.verschwiegener.gdtf4j.physical;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.math.GDTFVector3f;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

/**
 * he Filter Collect defines subtractive mixing of light sources by filters,
 * such as subtractive mixing flags and media used in physical or virtual Color
 * Wheels
 * 
 * @author Verschwiegener
 *
 */
public class Filter extends GenericNameNode {

	/**
	 * Approximate absolute color point when this filter is the only item fully
	 * inserted into the beam and the fixture is at maximum intensity. For Y give
	 * relative value compared to overall output defined in property Luminous Flux
	 * of related Beam Geometry (transmissive case).
	 */
	private GDTFVector3f color;
	private ArrayList<Mesurement> mesurements = new ArrayList<Mesurement>();

	public Filter(String name, String color) {
		super(name);
		this.color = GDTFVector3f.fromString(color);
	}
	public Filter() {
	}

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		color = GDTFVector3f.fromString(getItemNullSave(map, "Name"));

		NodeList list = ((Element) node).getElementsByTagName("Measurement");
		for (int i = 0; i < list.getLength(); i++) {
			mesurements.add(new Mesurement(list.item(i)));
		}
		return getClass();
	}
}
