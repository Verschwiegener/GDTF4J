//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Break complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Break"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="DMXOffset" type="{}dmxaddresstype" default="1" /&gt;
 *       &lt;attribute name="DMXBreak" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" default="1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Break")
public class Break {

    @XmlAttribute(name = "DMXOffset")
    protected Integer dmxOffset;
    @XmlAttribute(name = "DMXBreak")
    @XmlSchemaType(name = "unsignedByte")
    protected Short dmxBreak;

    /**
     * Ruft den Wert der dmxOffset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getDMXOffset() {
        if (dmxOffset == null) {
            return  1;
        } else {
            return dmxOffset;
        }
    }

    /**
     * Legt den Wert der dmxOffset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDMXOffset(Integer value) {
        this.dmxOffset = value;
    }

    /**
     * Ruft den Wert der dmxBreak-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getDMXBreak() {
        if (dmxBreak == null) {
            return ((short) 1);
        } else {
            return dmxBreak;
        }
    }

    /**
     * Legt den Wert der dmxBreak-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDMXBreak(Short value) {
        this.dmxBreak = value;
    }

}
