//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SubphysicalTypeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="SubphysicalTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PlacementOffset"/&gt;
 *     &lt;enumeration value="Amplitude"/&gt;
 *     &lt;enumeration value="AmplitudeMin"/&gt;
 *     &lt;enumeration value="AmplitudeMax"/&gt;
 *     &lt;enumeration value="Duration"/&gt;
 *     &lt;enumeration value="DutyCycle"/&gt;
 *     &lt;enumeration value="TimeOffset"/&gt;
 *     &lt;enumeration value="MinimumOpening"/&gt;
 *     &lt;enumeration value="Value"/&gt;
 *     &lt;enumeration value="RatioHorizontal"/&gt;
 *     &lt;enumeration value="RatioVertical"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubphysicalTypeEnum")
@XmlEnum
public enum SubphysicalTypeEnum {

    @XmlEnumValue("PlacementOffset")
    PLACEMENT_OFFSET("PlacementOffset"),
    @XmlEnumValue("Amplitude")
    AMPLITUDE("Amplitude"),
    @XmlEnumValue("AmplitudeMin")
    AMPLITUDE_MIN("AmplitudeMin"),
    @XmlEnumValue("AmplitudeMax")
    AMPLITUDE_MAX("AmplitudeMax"),
    @XmlEnumValue("Duration")
    DURATION("Duration"),
    @XmlEnumValue("DutyCycle")
    DUTY_CYCLE("DutyCycle"),
    @XmlEnumValue("TimeOffset")
    TIME_OFFSET("TimeOffset"),
    @XmlEnumValue("MinimumOpening")
    MINIMUM_OPENING("MinimumOpening"),
    @XmlEnumValue("Value")
    VALUE("Value"),
    @XmlEnumValue("RatioHorizontal")
    RATIO_HORIZONTAL("RatioHorizontal"),
    @XmlEnumValue("RatioVertical")
    RATIO_VERTICAL("RatioVertical");
    private final String value;

    SubphysicalTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubphysicalTypeEnum fromValue(String v) {
        for (SubphysicalTypeEnum c: SubphysicalTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
