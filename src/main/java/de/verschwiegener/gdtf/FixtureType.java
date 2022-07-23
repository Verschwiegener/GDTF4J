//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FixtureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FixtureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AttributeDefinitions" type="{}AttributeDefinitions"/&gt;
 *         &lt;element name="Wheels" type="{}Wheels" minOccurs="0"/&gt;
 *         &lt;element name="PhysicalDescriptions" type="{}PhysicalDescriptions" minOccurs="0"/&gt;
 *         &lt;element name="Models" type="{}Models" minOccurs="0"/&gt;
 *         &lt;element name="Geometries" type="{}Geometries"/&gt;
 *         &lt;element name="DMXModes" type="{}DMXModes"/&gt;
 *         &lt;element name="Revisions" type="{}Revisions" minOccurs="0"/&gt;
 *         &lt;element name="FTPresets" type="{}FTPresets" minOccurs="0"/&gt;
 *         &lt;element name="Protocols" type="{}Protocols" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LongName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Manufacturer" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FixtureTypeID" use="required" type="{}guidtype" /&gt;
 *       &lt;attribute name="Thumbnail" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RefFT" type="{}guidtype" /&gt;
 *       &lt;attribute name="CanHaveChildren" type="{}YesNoEnum" default="Yes" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixtureType", propOrder = {
    "attributeDefinitions",
    "wheels",
    "physicalDescriptions",
    "models",
    "geometries",
    "dmxModes",
    "revisions",
    "ftPresets",
    "protocols"
})
public class FixtureType {

    @XmlElement(name = "AttributeDefinitions", required = true)
    protected AttributeDefinitions attributeDefinitions;
    @XmlElement(name = "Wheels")
    protected Wheels wheels;
    @XmlElement(name = "PhysicalDescriptions")
    protected PhysicalDescriptions physicalDescriptions;
    @XmlElement(name = "Models")
    protected Models models;
    @XmlElement(name = "Geometries", required = true)
    protected Geometries geometries;
    @XmlElement(name = "DMXModes", required = true)
    protected DMXModes dmxModes;
    @XmlElement(name = "Revisions")
    protected Revisions revisions;
    @XmlElement(name = "FTPresets")
    protected FTPresets ftPresets;
    @XmlElement(name = "Protocols")
    protected Protocols protocols;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "ShortName")
    protected String shortName;
    @XmlAttribute(name = "LongName")
    protected String longName;
    @XmlAttribute(name = "Manufacturer", required = true)
    protected String manufacturer;
    @XmlAttribute(name = "Description", required = true)
    protected String description;
    @XmlAttribute(name = "FixtureTypeID", required = true)
    protected String fixtureTypeID;
    @XmlAttribute(name = "Thumbnail")
    protected String thumbnail;
    @XmlAttribute(name = "RefFT")
    protected String refFT;
    @XmlAttribute(name = "CanHaveChildren")
    protected YesNoEnum canHaveChildren;

    /**
     * Ruft den Wert der attributeDefinitions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AttributeDefinitions }
     *     
     */
    public AttributeDefinitions getAttributeDefinitions() {
        return attributeDefinitions;
    }

    /**
     * Legt den Wert der attributeDefinitions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeDefinitions }
     *     
     */
    public void setAttributeDefinitions(AttributeDefinitions value) {
        this.attributeDefinitions = value;
    }

    /**
     * Ruft den Wert der wheels-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Wheels }
     *     
     */
    public Wheels getWheels() {
        return wheels;
    }

    /**
     * Legt den Wert der wheels-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Wheels }
     *     
     */
    public void setWheels(Wheels value) {
        this.wheels = value;
    }

    /**
     * Ruft den Wert der physicalDescriptions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalDescriptions }
     *     
     */
    public PhysicalDescriptions getPhysicalDescriptions() {
        return physicalDescriptions;
    }

    /**
     * Legt den Wert der physicalDescriptions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalDescriptions }
     *     
     */
    public void setPhysicalDescriptions(PhysicalDescriptions value) {
        this.physicalDescriptions = value;
    }

    /**
     * Ruft den Wert der models-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Models }
     *     
     */
    public Models getModels() {
        return models;
    }

    /**
     * Legt den Wert der models-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Models }
     *     
     */
    public void setModels(Models value) {
        this.models = value;
    }

    /**
     * Ruft den Wert der geometries-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Geometries }
     *     
     */
    public Geometries getGeometries() {
        return geometries;
    }

    /**
     * Legt den Wert der geometries-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Geometries }
     *     
     */
    public void setGeometries(Geometries value) {
        this.geometries = value;
    }

    /**
     * Ruft den Wert der dmxModes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DMXModes }
     *     
     */
    public DMXModes getDMXModes() {
        return dmxModes;
    }

    /**
     * Legt den Wert der dmxModes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DMXModes }
     *     
     */
    public void setDMXModes(DMXModes value) {
        this.dmxModes = value;
    }

    /**
     * Ruft den Wert der revisions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Revisions }
     *     
     */
    public Revisions getRevisions() {
        return revisions;
    }

    /**
     * Legt den Wert der revisions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Revisions }
     *     
     */
    public void setRevisions(Revisions value) {
        this.revisions = value;
    }

    /**
     * Ruft den Wert der ftPresets-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FTPresets }
     *     
     */
    public FTPresets getFTPresets() {
        return ftPresets;
    }

    /**
     * Legt den Wert der ftPresets-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FTPresets }
     *     
     */
    public void setFTPresets(FTPresets value) {
        this.ftPresets = value;
    }

    /**
     * Ruft den Wert der protocols-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Protocols }
     *     
     */
    public Protocols getProtocols() {
        return protocols;
    }

    /**
     * Legt den Wert der protocols-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Protocols }
     *     
     */
    public void setProtocols(Protocols value) {
        this.protocols = value;
    }

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
     * Ruft den Wert der shortName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Legt den Wert der shortName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Ruft den Wert der longName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Legt den Wert der longName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongName(String value) {
        this.longName = value;
    }

    /**
     * Ruft den Wert der manufacturer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Legt den Wert der manufacturer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der fixtureTypeID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixtureTypeID() {
        return fixtureTypeID != null ? fixtureTypeID : "";
    }

    /**
     * Legt den Wert der fixtureTypeID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixtureTypeID(String value) {
        this.fixtureTypeID = value;
    }

    /**
     * Ruft den Wert der thumbnail-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Legt den Wert der thumbnail-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThumbnail(String value) {
        this.thumbnail = value;
    }

    /**
     * Ruft den Wert der refFT-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefFT() {
        return refFT != null ? refFT : "";
    }

    /**
     * Legt den Wert der refFT-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefFT(String value) {
        this.refFT = value;
    }

    /**
     * Ruft den Wert der canHaveChildren-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link YesNoEnum }
     *     
     */
    public YesNoEnum getCanHaveChildren() {
        if (canHaveChildren == null) {
            return YesNoEnum.YES;
        } else {
            return canHaveChildren;
        }
    }

    /**
     * Legt den Wert der canHaveChildren-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoEnum }
     *     
     */
    public void setCanHaveChildren(YesNoEnum value) {
        this.canHaveChildren = value;
    }

}
