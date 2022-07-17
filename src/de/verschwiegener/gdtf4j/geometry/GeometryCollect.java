package de.verschwiegener.gdtf4j.geometry;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;

public class GeometryCollect extends BaseGeometry {

	public GeometryCollect(GeometryTypes type) {
		super(type);
	}

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		return getClass();
	}
	
	public GenericGeometry2 getGeometry(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.Geometry);
	}
	public GenericGeometry2 getAxis(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.Axis);
	}
	public GenericGeometry2 getFilterBeam(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.FilterBeam);
	}
	public GenericGeometry2 getFilterColor(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.FilterColor);
	}
	public GenericGeometry2 getFilterGobo(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.FilterGobo);
	}
	public GenericGeometry2 getFilterShaper(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.FilterShaper);
	}
	public TypeBeam getBeam(String name) {
		return (TypeBeam) getGeometryRecursive(name, GeometryTypes.Beam);
	}
	public GenericGeometry2 getMediaServerLAyer(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.MediaServerLayer);
	}
	public GenericGeometry2 getMediaServerCamera(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.MediaServerCmaera);
	}
	public GenericGeometry2 getMediaServerMaster(String name) {
		return (GenericGeometry2) getGeometryRecursive(name, GeometryTypes.MediaServerMaster);
	}
	public TypeDisplay getDisplay(String name) {
		return (TypeDisplay) getGeometryRecursive(name, GeometryTypes.Display);
	}
	public TypeReference getGeometryReference(String name) {
		return (TypeReference) getGeometryRecursive(name, GeometryTypes.GeometryReference);
	}

}
