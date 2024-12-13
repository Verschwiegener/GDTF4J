//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


/**
 * <p>Java-Klasse für SubChannelSet complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubChannelSet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PhysicalFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="PhysicalTo" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="SubPhysicalUnit" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="DMXProfile" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubChannelSet")
public class SubChannelSet {

    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "PhysicalFrom", required = true)
    protected float physicalFrom;
    @XmlAttribute(name = "PhysicalTo", required = true)
    protected float physicalTo;
    @XmlAttribute(name = "SubPhysicalUnit", required = true)
    protected String subPhysicalUnit;
    @XmlAttribute(name = "DMXProfile")
    protected String dmxProfile;

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
     * Ruft den Wert der physicalFrom-Eigenschaft ab.
     * 
     */
    public float getPhysicalFrom() {
        return physicalFrom;
    }

    /**
     * Legt den Wert der physicalFrom-Eigenschaft fest.
     * 
     */
    public void setPhysicalFrom(float value) {
        this.physicalFrom = value;
    }

    /**
     * Ruft den Wert der physicalTo-Eigenschaft ab.
     * 
     */
    public float getPhysicalTo() {
        return physicalTo;
    }

    /**
     * Legt den Wert der physicalTo-Eigenschaft fest.
     * 
     */
    public void setPhysicalTo(float value) {
        this.physicalTo = value;
    }

    /**
     * Ruft den Wert der subPhysicalUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getSubPhysicalUnit() {
        return new GDTFNode(subPhysicalUnit, NodeSearchPoint.Attribute);
    }

    /**
     * Legt den Wert der subPhysicalUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubPhysicalUnit(GDTFNode value) {
        this.subPhysicalUnit = value.toGDTF();
    }

    /**
     * Ruft den Wert der dmxProfile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getDMXProfile() {
        return new GDTFNode(dmxProfile, NodeSearchPoint.DMXProfile);
    }

    /**
     * Legt den Wert der dmxProfile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMXProfile(GDTFNode value) {
        this.dmxProfile = value.toGDTF();
    }

}
