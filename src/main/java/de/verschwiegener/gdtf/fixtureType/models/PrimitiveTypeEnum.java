//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PrimitiveTypeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="PrimitiveTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Undefined"/&gt;
 *     &lt;enumeration value="Cube"/&gt;
 *     &lt;enumeration value="Cylinder"/&gt;
 *     &lt;enumeration value="Sphere"/&gt;
 *     &lt;enumeration value="Base"/&gt;
 *     &lt;enumeration value="Yoke"/&gt;
 *     &lt;enumeration value="Head"/&gt;
 *     &lt;enumeration value="Scanner"/&gt;
 *     &lt;enumeration value="Conventional"/&gt;
 *     &lt;enumeration value="Pigtail"/&gt;
 *     &lt;enumeration value="Base1_1"/&gt;
 *     &lt;enumeration value="Scanner1_1"/&gt;
 *     &lt;enumeration value="Conventional1_1"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PrimitiveTypeEnum")
@XmlEnum
public enum PrimitiveTypeEnum {

    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined"),
    @XmlEnumValue("Cube")
    CUBE("Cube"),
    @XmlEnumValue("Cylinder")
    CYLINDER("Cylinder"),
    @XmlEnumValue("Sphere")
    SPHERE("Sphere"),
    @XmlEnumValue("Base")
    BASE("Base"),
    @XmlEnumValue("Yoke")
    YOKE("Yoke"),
    @XmlEnumValue("Head")
    HEAD("Head"),
    @XmlEnumValue("Scanner")
    SCANNER("Scanner"),
    @XmlEnumValue("Conventional")
    CONVENTIONAL("Conventional"),
    @XmlEnumValue("Pigtail")
    PIGTAIL("Pigtail"),
    @XmlEnumValue("Base1_1")
    BASE_1_1("Base1_1"),
    @XmlEnumValue("Scanner1_1")
    SCANNER_1_1("Scanner1_1"),
    @XmlEnumValue("Conventional1_1")
    CONVENTIONAL_1_1("Conventional1_1");
    private final String value;

    PrimitiveTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrimitiveTypeEnum fromValue(String v) {
        for (PrimitiveTypeEnum c: PrimitiveTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
