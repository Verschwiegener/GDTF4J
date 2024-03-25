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
 * <p>Java-Klasse für supportTypeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="supportTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Rope"/&gt;
 *     &lt;enumeration value="GroundSupport"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "supportTypeEnum")
@XmlEnum
public enum SupportTypeEnum {

    @XmlEnumValue("Rope")
    ROPE("Rope"),
    @XmlEnumValue("GroundSupport")
    GROUND_SUPPORT("GroundSupport");
    private final String value;

    SupportTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupportTypeEnum fromValue(String v) {
        for (SupportTypeEnum c: SupportTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
