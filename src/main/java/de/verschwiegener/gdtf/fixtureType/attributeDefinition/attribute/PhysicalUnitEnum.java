//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PhysicalUnitEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalUnitEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="None"/&gt;
 *     &lt;enumeration value="Percent"/&gt;
 *     &lt;enumeration value="Length"/&gt;
 *     &lt;enumeration value="Mass"/&gt;
 *     &lt;enumeration value="Time"/&gt;
 *     &lt;enumeration value="Temperature"/&gt;
 *     &lt;enumeration value="LuminousIntensity"/&gt;
 *     &lt;enumeration value="Angle"/&gt;
 *     &lt;enumeration value="Force"/&gt;
 *     &lt;enumeration value="Frequency"/&gt;
 *     &lt;enumeration value="Current"/&gt;
 *     &lt;enumeration value="Voltage"/&gt;
 *     &lt;enumeration value="Power"/&gt;
 *     &lt;enumeration value="Energy"/&gt;
 *     &lt;enumeration value="Area"/&gt;
 *     &lt;enumeration value="Volume"/&gt;
 *     &lt;enumeration value="Speed"/&gt;
 *     &lt;enumeration value="Acceleration"/&gt;
 *     &lt;enumeration value="AngularSpeed"/&gt;
 *     &lt;enumeration value="AngularAccc"/&gt;
 *     &lt;enumeration value="WaveLength"/&gt;
 *     &lt;enumeration value="ColorComponent"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PhysicalUnitEnum")
@XmlEnum
public enum PhysicalUnitEnum {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Percent")
    PERCENT("Percent"),
    @XmlEnumValue("Length")
    LENGTH("Length"),
    @XmlEnumValue("Mass")
    MASS("Mass"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("Temperature")
    TEMPERATURE("Temperature"),
    @XmlEnumValue("LuminousIntensity")
    LUMINOUS_INTENSITY("LuminousIntensity"),
    @XmlEnumValue("Angle")
    ANGLE("Angle"),
    @XmlEnumValue("Force")
    FORCE("Force"),
    @XmlEnumValue("Frequency")
    FREQUENCY("Frequency"),
    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Voltage")
    VOLTAGE("Voltage"),
    @XmlEnumValue("Power")
    POWER("Power"),
    @XmlEnumValue("Energy")
    ENERGY("Energy"),
    @XmlEnumValue("Area")
    AREA("Area"),
    @XmlEnumValue("Volume")
    VOLUME("Volume"),
    @XmlEnumValue("Speed")
    SPEED("Speed"),
    @XmlEnumValue("Acceleration")
    ACCELERATION("Acceleration"),
    @XmlEnumValue("AngularSpeed")
    ANGULAR_SPEED("AngularSpeed"),
    @XmlEnumValue("AngularAccc")
    ANGULAR_ACCC("AngularAccc"),
    @XmlEnumValue("WaveLength")
    WAVE_LENGTH("WaveLength"),
    @XmlEnumValue("ColorComponent")
    COLOR_COMPONENT("ColorComponent");
    private final String value;

    PhysicalUnitEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalUnitEnum fromValue(String v) {
        for (PhysicalUnitEnum c: PhysicalUnitEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
