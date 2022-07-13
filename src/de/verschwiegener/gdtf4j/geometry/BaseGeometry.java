package de.verschwiegener.gdtf4j.geometry;

import java.util.ArrayList;

public interface BaseGeometry {

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
	
}
