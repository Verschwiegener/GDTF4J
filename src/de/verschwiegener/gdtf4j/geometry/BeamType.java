package de.verschwiegener.gdtf4j.geometry;

public enum BeamType {
	
	//“Wash” – A conical beam with soft edges.
	WASH, 
	//“Spot” – A conical beam with hard edges.
	SPOT, 
	//“Rectangle” – A pyramid-shaped beam with hard edges.
	RECTANGLE, 
	//“None” – No beam will be drawn, only the geometry itself will emit light.
	NONE

}
