//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für LampTypeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="LampTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Discharge"/&gt;
 *     &lt;enumeration value="Tungsten"/&gt;
 *     &lt;enumeration value="Halogen"/&gt;
 *     &lt;enumeration value="LED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LampTypeEnum")
@XmlEnum
public enum LampTypeEnum {

    @XmlEnumValue("Discharge")
    DISCHARGE("Discharge"),
    @XmlEnumValue("Tungsten")
    TUNGSTEN("Tungsten"),
    @XmlEnumValue("Halogen")
    HALOGEN("Halogen"),
    LED("LED");
    private final String value;

    LampTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LampTypeEnum fromValue(String v) {
        for (LampTypeEnum c: LampTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
