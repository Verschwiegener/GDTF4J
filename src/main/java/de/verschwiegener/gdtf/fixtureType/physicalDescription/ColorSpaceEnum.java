//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ColorSpaceEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ColorSpaceEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Custom"/&gt;
 *     &lt;enumeration value="sRGB"/&gt;
 *     &lt;enumeration value="ProPhoto"/&gt;
 *     &lt;enumeration value="ANSI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ColorSpaceEnum")
@XmlEnum
public enum ColorSpaceEnum {

    @XmlEnumValue("Custom")
    CUSTOM("Custom"),
    @XmlEnumValue("sRGB")
    S_RGB("sRGB"),
    @XmlEnumValue("ProPhoto")
    PRO_PHOTO("ProPhoto"),
    ANSI("ANSI");
    private final String value;

    ColorSpaceEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ColorSpaceEnum fromValue(String v) {
        for (ColorSpaceEnum c: ColorSpaceEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
