package de.verschwiegener.gdtf4j.physical;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getIntegerNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getByteNullSave;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;

public class Connector extends GenericNameNode{
	/**
	 * The type of the connector.
	 */
	private String type;
	/*
	 * Optional: Defines which DMX Break this connector belongs to.
	 */
	private int dmxBreak;
	/**
	 * Connectors where  the addition of the Gender value equals 0, can
	 * be connected; Default value: 0; Male Connectors are −1, Female
	 * are +1, Universal are 0
	 */
	private byte gender;
	private float length;
	
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		type = getItemNullSave(map, "Type");
		dmxBreak = getIntegerNullSave(map, "DMXBreak", 0);
		gender = getByteNullSave(map, "Gender", (byte) 0);
		length = getFloatNullSave(map, "Length", 0);
		return getClass();
	}

}
