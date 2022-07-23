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
 * <p>Java-Klasse für InterpolationToEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="InterpolationToEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Linear"/&gt;
 *     &lt;enumeration value="Step"/&gt;
 *     &lt;enumeration value="Log"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InterpolationToEnum")
@XmlEnum
public enum InterpolationToEnum {

    @XmlEnumValue("Linear")
    LINEAR("Linear"),
    @XmlEnumValue("Step")
    STEP("Step"),
    @XmlEnumValue("Log")
    LOG("Log");
    private final String value;

    InterpolationToEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InterpolationToEnum fromValue(String v) {
        for (InterpolationToEnum c: InterpolationToEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
