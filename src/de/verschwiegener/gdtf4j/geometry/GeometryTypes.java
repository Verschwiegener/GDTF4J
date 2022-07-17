package de.verschwiegener.gdtf4j.geometry;

public enum GeometryTypes {

	Geometry(GenericGeometry2.class), Axis(GenericGeometry2.class), FilterBeam(GenericGeometry2.class),
	FilterColor(GenericGeometry2.class), FilterGobo(GenericGeometry2.class), FilterShaper(GenericGeometry2.class),
	Beam(TypeBeam.class), MediaServerLayer(GenericGeometry2.class), MediaServerCmaera(GenericGeometry2.class),
	MediaServerMaster(GenericGeometry2.class), Display(TypeDisplay.class), GeometryReference(TypeReference.class),
	Collect(GeometryCollect.class),;

	private final Class<? extends BaseGeometry> target;

	private GeometryTypes(Class<? extends BaseGeometry> target) {
		this.target = target;
	}

	public Class<? extends BaseGeometry> getTarget() {
		return target;
	}
}
