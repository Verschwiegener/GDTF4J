//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für wiringComponentEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="wiringComponentEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Input"/&gt;
 *     &lt;enumeration value="Output"/&gt;
 *     &lt;enumeration value="PowerSource"/&gt;
 *     &lt;enumeration value="Consumer"/&gt;
 *     &lt;enumeration value="Fuse"/&gt;
 *     &lt;enumeration value="Output"/&gt;
 *     &lt;enumeration value="NetworkProvider"/&gt;
 *     &lt;enumeration value="NetworkInput"/&gt;
 *     &lt;enumeration value="NetworkOutput"/&gt;
 *     &lt;enumeration value="NetworkInOut"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "wiringComponentEnum")
@XmlEnum
public enum WiringComponentEnum {

    @XmlEnumValue("Input")
    INPUT("Input"),
    @XmlEnumValue("Output")
    OUTPUT("Output"),
    @XmlEnumValue("PowerSource")
    POWER_SOURCE("PowerSource"),
    @XmlEnumValue("Consumer")
    CONSUMER("Consumer"),
    @XmlEnumValue("Fuse")
    FUSE("Fuse"),
    @XmlEnumValue("NetworkProvider")
    NETWORK_PROVIDER("NetworkProvider"),
    @XmlEnumValue("NetworkInput")
    NETWORK_INPUT("NetworkInput"),
    @XmlEnumValue("NetworkOutput")
    NETWORK_OUTPUT("NetworkOutput"),
    @XmlEnumValue("NetworkInOut")
    NETWORK_IN_OUT("NetworkInOut");
    private final String value;

    WiringComponentEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WiringComponentEnum fromValue(String v) {
        for (WiringComponentEnum c: WiringComponentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
