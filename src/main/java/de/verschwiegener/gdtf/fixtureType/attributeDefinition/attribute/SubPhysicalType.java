package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import javax.xml.bind.annotation.XmlEnumValue;

public enum SubPhysicalType {

	@XmlEnumValue("PlacementOffset")
	PLACEMENTOFFSET("PlacementOffset"),

	@XmlEnumValue("Amplitude")
	AMPLITUDE("Amplitude"),

	@XmlEnumValue("AmplitudeMin")
	AMPLITUDEMIN("AmplitudeMin"),

	@XmlEnumValue("AmplitudeMax")
	AMPLITUDEMAX("AmplitudeMax"),

	@XmlEnumValue("Duration")
	DURATION("Duration"),

	@XmlEnumValue("DutyCycle")
	DUTYCYCLE("DutyCycle"),

	@XmlEnumValue("TimeOffset")
	TIMEOFFSET("TimeOffset"),

	@XmlEnumValue("MinimumOpening")
	MINIMUMOPENING("MinimumOpening"),

	@XmlEnumValue("Value")
	VALUE("Value"),

	@XmlEnumValue("RatioHorizontal")
	RATIOHORIZONTAL("RatioHorizontal"),

	@XmlEnumValue("RatioVertical")
	RATIOVERTICAL("RatioVertical");

	private final String value;

	SubPhysicalType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static SubPhysicalType fromValue(String v) {
		for (SubPhysicalType c : SubPhysicalType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
