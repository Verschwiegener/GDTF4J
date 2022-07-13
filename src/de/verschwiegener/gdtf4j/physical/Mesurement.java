package de.verschwiegener.gdtf4j.physical;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.physical.Mesurement.MesurementPoint;
import de.verschwiegener.gdtf4j.util.Interpolation;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;
/**
 * The measurement defines the relation between the requested output by a control channel and the physically
 * achieved intensity.
 * @author Verschwiegener
 *
 */
public class Mesurement {

	private float physical;
	private float luminousIntensity;
	private float transmission;
	private Interpolation interpolationTo = Interpolation.LINEAR;
	
	private ArrayList<MesurementPoint> mesurementPoints = new ArrayList<MesurementPoint>();

	public Mesurement(String physical, String luminousIntensity, String transmission, String interpolationTo) {
		this.physical = Float.valueOf(physical);
		this.luminousIntensity = Float.valueOf(luminousIntensity);
		this.transmission = Float.valueOf(transmission);
		this.interpolationTo = Interpolation.valueOf(interpolationTo.toUpperCase());
	}
	
	public Mesurement(Node node) {
		NamedNodeMap map = node.getAttributes();
		physical = Float.valueOf(getItemNullSave(map, "Physical"));
		luminousIntensity = getFloatNullSave(map, "LuminousIntensity", 0);
		transmission = getFloatNullSave(map, "Transmission", 0);
		String interpolation = getItemNullSave(map, "InterpolationTo");
		if(!interpolation.isBlank())
			interpolationTo = Interpolation.valueOf(interpolation.toUpperCase());
		
		NodeList list = ((Element)node).getElementsByTagName("MeasurementPoint");
		for (int i = 0; i < list.getLength(); i++) {
			mesurementPoints.add(new MesurementPoint(list.item(i)));
		}
	}
	
	public void addMesurementPoint(String waveLength, String energy) {
		mesurementPoints.add(new MesurementPoint(waveLength, energy));
	}

	public float getPhysical() {
		return physical;
	}

	public float getLuminousIntensity() {
		return luminousIntensity;
	}

	public float getTransmission() {
		return transmission;
	}

	public Interpolation getInterpolationTo() {
		return interpolationTo;
	}
	
	class MesurementPoint {
		private float waveLength;
		private float energy;
		
		public MesurementPoint(String waveLength, String energy) {
			this.waveLength = Float.valueOf(waveLength);
			this.energy = Float.valueOf(energy);
		}
		public MesurementPoint(Node node) {
			NamedNodeMap map = node.getAttributes();
			waveLength = Float.valueOf(getItemNullSave(map, "WaveLength"));
			energy = Float.valueOf(getItemNullSave(map, "Energy"));
			
		}
	}

}
