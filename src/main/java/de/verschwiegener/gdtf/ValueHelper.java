package de.verschwiegener.gdtf;

public class ValueHelper {
	
	
	public static record NameHelper (String name, String pretty) {}
	
	public static record FeatureHelper (String feature, String pretty) {}
	
	/**
	 * Holds the LogicalChannel Attribute and ChannelFunction Attribute
	 */
	public static record NodeHelper (String lcAttribute, String cfAttribute) {}
	
	
	/**
	 * Offsets the gives DMXValue by the given Offset Amount
	 * 
	 * @param dmxValue DMXValue in GDTF Format
	 * @param valueOffset Offset to be applied to the DMXValue Part of the given GDTF DMX Value
	 */
	public static String offsetDMXValue(String dmxValue, int valueOffset) {
		if(dmxValue.equals("None")) return dmxValue;
		String[] dmxParts = dmxValue.split("/");
		return (Integer.valueOf(dmxParts[0]) + valueOffset) + "/" + dmxParts[1];
	}

}
