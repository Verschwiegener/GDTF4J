package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubPhysicalUnit")
public class SubPhysicalUnit {

	/**
	 * The currently defined unit values are: “None”, “Percent”, “Length” (m),
	 * “Mass” (kg), “Time” (s), “Temperature” (K), “LuminousIntensity”(cd), “Angle”
	 * (degree), “Force” (N), “Frequency” (Hz), “Current” (A), “Voltage” (V),
	 * “Power” (W), “Energy” (J), “Area” (m2), “Volume” (m3), “Speed” (m/s),
	 * “Acceleration” (m/s2), “AngularSpeed” (degree/s), “AngularAccc” (degree/s2),
	 * “WaveLength” (nm), “ColorComponent”. Default: “None”.
	 */
	@XmlAttribute(name = "PhysicalUnit")
	protected PhysicalUnitEnum physicalUnit;

	/**
	 * The default physical from of the subphysical unit; Unit: as defined in
	 * PhysicalUnit; Default value: 0
	 */
	@XmlAttribute(name = "PhysicalFrom")
	protected Float physicalFrom;

	/**
	 * The default physical to of the subphysical unit; Unit: as defined in
	 * PhysicalUnit; Default value: 1
	 */
	@XmlAttribute(name = "PhysicalTo")
	protected Float physicalTo;

	public PhysicalUnitEnum getPhysicalUnit() {
		return physicalUnit;
	}

	public void setPhysicalUnit(PhysicalUnitEnum physicalUnit) {
		this.physicalUnit = physicalUnit;
	}

	public float getPhysicalFrom() {
		if (physicalFrom == null)
			return 0f;
		return physicalFrom;
	}

	public void setPhysicalFrom(float physicalFrom) {
		this.physicalFrom = physicalFrom;
	}

	public float getPhysicalTo() {
		if (physicalTo == null)
			return 1f;
		return physicalTo;
	}

	public void setPhysicalTo(float physicalTo) {
		this.physicalTo = physicalTo;
	}

}
