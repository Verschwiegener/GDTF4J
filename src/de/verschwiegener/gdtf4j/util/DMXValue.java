package de.verschwiegener.gdtf4j.util;

public class DMXValue {
	
	private byte shiftvalue;
	
	private int dmxValue;
	
	public DMXValue(String value) {
		String[] component = value.split("/");
		dmxValue = Integer.valueOf(component[0]);
		shiftvalue = Byte.valueOf(component[1]);
 	}
	public DMXValue(int dmxValue, byte shiftValue) {
		this.dmxValue = dmxValue;
		this.shiftvalue = shiftValue;
	}
	
	private int convertTo() {
		return dmxValue >> (8 * shiftvalue) - 8;
	}
	private int convertFrom() {
		return dmxValue >> (8 * shiftvalue) - 8;
	}

}
