package de.verschwiegener.gdtf4j.geometry;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;

import static de.verschwiegener.gdtf4j.geometry.GeometryTypes.*;

public abstract class BaseGeometry extends GenericNameNode{
	
	
	private ArrayList<BaseGeometry> baseGeometry = new ArrayList<BaseGeometry>();
	private GeometryTypes geoType;
	private Break dmxBreak;
	
	public BaseGeometry(GeometryTypes type) {
		this.geoType = type;
	}
	
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "Geometry", gdtf, Geometry);
		if(getName().equals("Base")) {
			for(BaseGeometry geo : baseGeometry) {
				System.out.println("Base: " + geo.getName());
			}
		}
		addChildrenToArrayList(GenericGeometry1.class, baseGeometry, node, "Axis", gdtf, Axis);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "FilterBeam", gdtf, FilterBeam);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "FilterColor", gdtf, FilterColor);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "FilterGobo", gdtf, FilterGobo);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "FilterShaper", gdtf, FilterShaper);
		addChildrenToArrayList(TypeBeam.class, baseGeometry, node, "Beam", gdtf, Beam);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "MediaServerLayer", gdtf, MediaServerLayer);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "MediaServerCamera", gdtf, MediaServerCmaera);
		addChildrenToArrayList(GenericGeometry2.class, baseGeometry, node, "MediaServerMaster", gdtf, MediaServerMaster);
		addChildrenToArrayList(TypeDisplay.class, baseGeometry, node, "Display", gdtf, Display);
		addChildrenToArrayList(TypeReference.class, baseGeometry, node, "GeometryReference", gdtf, GeometryReference);
		
		NodeList list = ((Element) node).getElementsByTagName("Break");
		if (list.getLength() > 0)
			dmxBreak = new Break(((Element) node).getElementsByTagName("Break").item(1));
		return getClass();
	}
	
	public Break getDmxBreak() {
		return dmxBreak;
	}
	
	private <T extends BaseGeometry> void addChildrenToArrayList(Class<T> childClass, ArrayList<BaseGeometry> target, Node node, String name,
			GDTF gdtf, GeometryTypes type) {
		try {
			NodeList list = ((Element) node).getElementsByTagName(name);
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getParentNode() == node) {
					T child = childClass.getDeclaredConstructor(GeometryTypes.class).newInstance(type);
					target.add(child);
					((GDTFClass) child).fromXML(list.item(i), gdtf);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BaseGeometry getGeometryRecursive(String name, GeometryTypes type) {
		if(getGeoType().equals(type) && getName().equals(name)) {
			return this;
		}
		for(BaseGeometry geo : baseGeometry) {
			BaseGeometry rec = geo.getGeometryRecursive(name, type);
			if(rec != null) return rec;
		}
		return null;
	}
	public BaseGeometry getGeometryRecursive(String name) {
		if(getName().equals(name)) {
			return this;
		}
		for(BaseGeometry geo : baseGeometry) {
			BaseGeometry rec = geo.getGeometryRecursive(name);
			if(rec != null) return rec;
		}
		return null;
	}
	public GeometryTypes getGeoType() {
		return geoType;
	}
	
	public BaseGeometry getGeometry(String name, GeometryTypes type){
		return baseGeometry.stream().filter(geo -> geo.getName().equals(name) && geo.getGeoType().equals(type)).findFirst().orElse(null);
	}
	public BaseGeometry getGeometry(String name){
		return baseGeometry.stream().filter(geo -> geo.getName().equals(name)).findFirst().orElse(null);
	}
	

}
