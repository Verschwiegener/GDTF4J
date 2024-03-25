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
 * <p>Java-Klasse für crossSectionEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="crossSectionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TrussFramework"/&gt;
 *     &lt;enumeration value="Detail"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "crossSectionEnum")
@XmlEnum
public enum CrossSectionEnum {

    @XmlEnumValue("TrussFramework")
    TRUSS_FRAMEWORK("TrussFramework"),
    @XmlEnumValue("Detail")
    DETAIL("Detail");
    private final String value;

    CrossSectionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CrossSectionEnum fromValue(String v) {
        for (CrossSectionEnum c: CrossSectionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
