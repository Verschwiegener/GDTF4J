//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ChannelSet complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ChannelSet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DMXFrom" type="{}dmxtype" /&gt;
 *       &lt;attribute name="PhysicalFrom" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="PhysicalTo" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="WheelSlotIndex" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChannelSet")
public class ChannelSet {

    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "DMXFrom")
    protected String dmxFrom;
    @XmlAttribute(name = "PhysicalFrom")
    protected Float physicalFrom;
    @XmlAttribute(name = "PhysicalTo")
    protected Float physicalTo;
    @XmlAttribute(name = "WheelSlotIndex")
    protected Integer wheelSlotIndex;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der dmxFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDMXFrom() {
        return dmxFrom;
    }

    /**
     * Legt den Wert der dmxFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMXFrom(String value) {
        this.dmxFrom = value;
    }

    /**
     * Ruft den Wert der physicalFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPhysicalFrom() {
        return physicalFrom;
    }

    /**
     * Legt den Wert der physicalFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPhysicalFrom(Float value) {
        this.physicalFrom = value;
    }

    /**
     * Ruft den Wert der physicalTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPhysicalTo() {
        return physicalTo;
    }

    /**
     * Legt den Wert der physicalTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPhysicalTo(Float value) {
        this.physicalTo = value;
    }

    /**
     * Ruft den Wert der wheelSlotIndex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWheelSlotIndex() {
        return wheelSlotIndex;
    }

    /**
     * Legt den Wert der wheelSlotIndex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWheelSlotIndex(Integer value) {
        this.wheelSlotIndex = value;
    }

}
