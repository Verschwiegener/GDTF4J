package de.verschwiegener.gdtf4j.geometry;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;

public class Geometry extends GenericNameNode {

	private Break dmxBreak;
	ArrayList<GenericGeometry2> geometry = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry1> typeAxis = new ArrayList<GenericGeometry1>();
	ArrayList<GenericGeometry2> typeBeamFilter = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry2> typeColorFilter = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry2> typeGoboFilter = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry2> typeShaperFilter = new ArrayList<GenericGeometry2>();
	ArrayList<TypeBeam> typeBeam = new ArrayList<TypeBeam>();
	ArrayList<GenericGeometry2> typeMediaServerLayer = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry2> typeMediaServerCamera = new ArrayList<GenericGeometry2>();
	ArrayList<GenericGeometry2> typeMediaServerMaster = new ArrayList<GenericGeometry2>();
	ArrayList<TypeDisplay> typeDisplay = new ArrayList<TypeDisplay>();
	ArrayList<TypeReference> typeReference = new ArrayList<TypeReference>();

	public Geometry() {
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		getChildren(node);
		return getClass();
	}

	private void getChildren(Node node) {
		addChildrenToArrayList(GenericGeometry2.class, geometry, node, "Geometry");
		addChildrenToArrayList(GenericGeometry1.class, typeAxis, node, "Axis");
		addChildrenToArrayList(GenericGeometry2.class, typeBeamFilter, node, "FilterBeam");
		addChildrenToArrayList(GenericGeometry2.class, typeColorFilter, node, "FilterColor");
		addChildrenToArrayList(GenericGeometry2.class, typeGoboFilter, node, "FilterGobo");
		addChildrenToArrayList(GenericGeometry2.class, typeShaperFilter, node, "FilterShaper");
		addChildrenToArrayList(TypeBeam.class, typeBeam, node, "Beam");
		addChildrenToArrayList(GenericGeometry2.class, typeMediaServerLayer, node, "MediaServerLayer");
		addChildrenToArrayList(GenericGeometry2.class, typeMediaServerCamera, node, "MediaServerCamera");
		addChildrenToArrayList(GenericGeometry2.class, typeMediaServerMaster, node, "MediaServerMaster");
		addChildrenToArrayList(TypeDisplay.class, typeDisplay, node, "Display");
		addChildrenToArrayList(TypeReference.class, typeReference, node, "GeometryReference");
		NodeList list = ((Element) node).getElementsByTagName("Break");
		if (list.getLength() > 0)
			dmxBreak = new Break(((Element) node).getElementsByTagName("Break").item(1));
	}

	public <T> void addChildrenToArrayList(Class<T> childClass, ArrayList<T> target, Node node, String name) {
		try {
			NodeList list = ((Element) node).getElementsByTagName(name);
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getParentNode() == node) {
					target.add(childClass.getDeclaredConstructor(Node.class).newInstance(list.item(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Geometry getGeometryByName(String name) {
		if (getName().equals(name))
			return this;
		for (Geometry geo : geometry) {
			Geometry geoChild = geo.getGeometryByName(name);
			if (geoChild != null)
				return geoChild;
		}
		return null;
	}

	public Break getDmxBreak() {
		return dmxBreak;
	}

}
