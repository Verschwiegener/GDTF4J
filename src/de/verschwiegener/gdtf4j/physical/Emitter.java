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
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;

/**
 * Emmiter Collect defines additive mixing of light sources, such as LEDs and
 * tungsten lamps with permanently fitted filters
 * 
 * @author Verschwiegener
 *
 */
public class Emitter extends GenericNameNode {

	private GDTFVector3f color;
	private float dominantWaveLength;
	private String diodePart;

	private ArrayList<Mesurement> mesurements = new ArrayList<Mesurement>();

	public Emitter(String name, String color, String dominantWaveLength, String diodePart) {
		super(name);
		this.color = GDTFVector3f.fromString(color);
		this.dominantWaveLength = Float.valueOf(dominantWaveLength);
		this.diodePart = diodePart;
	}
	
	public Emitter() {
	}

	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		color = GDTFVector3f.fromString(getItemNullSave(map, "Color"));
		dominantWaveLength = getFloatNullSave(map, "DominantWaveLength", 0);
		diodePart = getItemNullSave(map, "DiodePart");

		NodeList list = ((Element) node).getElementsByTagName("Measurement");
		for (int i = 0; i < list.getLength(); i++) {
			mesurements.add(new Mesurement(list.item(i)));
		}
		return getClass();
	}

	public void addMesurement(String physical, String luminousIntensity, String transmission, String interpolationTo) {
		mesurements.add(new Mesurement(physical, luminousIntensity, transmission, interpolationTo));
	}

	public GDTFVector3f getColor() {
		return color;
	}

	public float getDominantWaveLength() {
		return dominantWaveLength;
	}

	public String getDiodePart() {
		return diodePart;
	}

	public ArrayList<Mesurement> getMesurements() {
		return mesurements;
	}

}
