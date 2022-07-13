package de.verschwiegener.gdtf4j.geometry;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import org.w3c.dom.Node;

public class Break{
	
	private int dmxOffset = 1;
	private byte dmxBreak = 1;
	
	public Break(Node node) {
		String dmxOffset = getItemNullSave(node, "DMXOffset");
		if(!dmxOffset.isEmpty()) this.dmxOffset = Integer.valueOf(dmxOffset);
		String dmxBreak = getItemNullSave(node, "DMXBreak");
		if(!dmxBreak.isEmpty()) this.dmxBreak = Byte.valueOf(dmxBreak);
	}
	public byte getDmxBreak() {
		return dmxBreak;
	}
	public int getDmxOffset() {
		return dmxOffset;
	}

}
