package de.verschwiegener.gdtf;

public class APi {
	
	
	public APi() {
		
		GDTFType gdtf = new GDTFType(File);
		
		
		
		gdtf.getWheels();
		/**
		 * Wheel
		 */
		
		
		gdtf.getFilters();
		/**
		 * Filter
		 * Measurement
		 */
		
		gdtf.getEmitters();
		/**
		 * Emitter
		 * Measurement
		 */
		
		gdtf.getDescription();
		/**
		 * boolean CanHaveChildren
		 * String description
		 * UUID fixtureTypeID
		 * String longName
		 * String manufacturer
		 * String name
		 * String RefFt
		 * String ShortName
		 * File Thumbnail
		 */
		
		gdtf.getProperties();
		/**
		 * ColorSpace
		 * OperatingTemperatur
		 * Weight
		 * LegHeight
		 */
		
		gdtf.getGeometrys();
		/**
		 * String name
		 * File model
		 * GDTFMatrix Position
		 * float height
		 * float width
		 * float length
		 * PrimitiveType type
		 */
		
		gdtf.getBeam(); // Geometries -> Beam
		/**
		 * String name
		 * File model
		 * GDTFPosition Position
		 * BeamAngle
		 * BeamRadius
		 * BeamType
		 * ColorRenderingIndex
		 * ColorTemperature
		 * FieldAngle
		 * LampType
		 * LuminousFlux
		 * PowerConsumption
		 * RectangleRatio
		 * ThrowRatio
		 */
		
		gdtf.getRevisions();
		/**
		 * Revision
		 */
		
		gdtf.getProtocols();
		/**
		 * Protocols
		 */
		
		gdtf.getGDTF();
		/**
		 * Plain GDTF for custom parsing
		 */
		
		
	}

}
