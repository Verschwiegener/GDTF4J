//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SnapEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="SnapEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Yes"/&gt;
 *     &lt;enumeration value="No"/&gt;
 *     &lt;enumeration value="On"/&gt;
 *     &lt;enumeration value="Off"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SnapEnum")
@XmlEnum
public enum SnapEnum {

    @XmlEnumValue("Yes")
    YES("Yes", true),
    @XmlEnumValue("No")
    NO("No", false),
    @XmlEnumValue("On")
    ON("On", true),
    @XmlEnumValue("Off")
    OFF("Off", false);
    private final String value;
    private final boolean bool;

    SnapEnum(String v, boolean bool) {
        value = v;
        this.bool = bool;
    }

    public String value() {
        return value;
    }
    public boolean asBoolean() {
    	return bool;
    }

    public static SnapEnum fromValue(String v) {
        for (SnapEnum c: SnapEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
