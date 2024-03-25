//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für fuseRatingEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="fuseRatingEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="Z"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "fuseRatingEnum")
@XmlEnum
public enum FuseRatingEnum {

    B,
    C,
    D,
    K,
    Z;

    public String value() {
        return name();
    }

    public static FuseRatingEnum fromValue(String v) {
        return valueOf(v);
    }

}
