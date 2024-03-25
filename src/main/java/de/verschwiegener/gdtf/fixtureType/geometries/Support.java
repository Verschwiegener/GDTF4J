//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Support complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Support"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}BasicGeometryType"&gt;
 *       &lt;attribute name="SupportType" type="{}supportTypeEnum" /&gt;
 *       &lt;attribute name="RopeCrossSection" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RopeOffset" type="{}vector3" /&gt;
 *       &lt;attribute name="CapacityX" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CapacityY" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CapacityXX" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CapacityYY" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CapacityZZ" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceX" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceY" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceZ" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceXX" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceYY" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ResistanceZZ" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Support")
public class Support
    extends BasicGeometryType
{

    @XmlAttribute(name = "SupportType")
    protected SupportTypeEnum supportType;
    @XmlAttribute(name = "RopeCrossSection")
    protected String ropeCrossSection;
    @XmlAttribute(name = "RopeOffset")
    protected String ropeOffset;
    @XmlAttribute(name = "CapacityX")
    protected Float capacityX;
    @XmlAttribute(name = "CapacityY")
    protected Float capacityY;
    @XmlAttribute(name = "CapacityXX")
    protected Float capacityXX;
    @XmlAttribute(name = "CapacityYY")
    protected Float capacityYY;
    @XmlAttribute(name = "CapacityZZ")
    protected Float capacityZZ;
    @XmlAttribute(name = "ResistanceX")
    protected Float resistanceX;
    @XmlAttribute(name = "ResistanceY")
    protected Float resistanceY;
    @XmlAttribute(name = "ResistanceZ")
    protected Float resistanceZ;
    @XmlAttribute(name = "ResistanceXX")
    protected Float resistanceXX;
    @XmlAttribute(name = "ResistanceYY")
    protected Float resistanceYY;
    @XmlAttribute(name = "ResistanceZZ")
    protected Float resistanceZZ;

    /**
     * Ruft den Wert der supportType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SupportTypeEnum }
     *     
     */
    public SupportTypeEnum getSupportType() {
        return supportType;
    }

    /**
     * Legt den Wert der supportType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportTypeEnum }
     *     
     */
    public void setSupportType(SupportTypeEnum value) {
        this.supportType = value;
    }

    /**
     * Ruft den Wert der ropeCrossSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRopeCrossSection() {
        return ropeCrossSection;
    }

    /**
     * Legt den Wert der ropeCrossSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRopeCrossSection(String value) {
        this.ropeCrossSection = value;
    }

    /**
     * Ruft den Wert der ropeOffset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRopeOffset() {
        return ropeOffset;
    }

    /**
     * Legt den Wert der ropeOffset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRopeOffset(String value) {
        this.ropeOffset = value;
    }

    /**
     * Ruft den Wert der capacityX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityX() {
        return capacityX;
    }

    /**
     * Legt den Wert der capacityX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCapacityX(Float value) {
        this.capacityX = value;
    }

    /**
     * Ruft den Wert der capacityY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityY() {
        return capacityY;
    }

    /**
     * Legt den Wert der capacityY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCapacityY(Float value) {
        this.capacityY = value;
    }

    /**
     * Ruft den Wert der capacityXX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityXX() {
        return capacityXX;
    }

    /**
     * Legt den Wert der capacityXX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCapacityXX(Float value) {
        this.capacityXX = value;
    }

    /**
     * Ruft den Wert der capacityYY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityYY() {
        return capacityYY;
    }

    /**
     * Legt den Wert der capacityYY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCapacityYY(Float value) {
        this.capacityYY = value;
    }

    /**
     * Ruft den Wert der capacityZZ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCapacityZZ() {
        return capacityZZ;
    }

    /**
     * Legt den Wert der capacityZZ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCapacityZZ(Float value) {
        this.capacityZZ = value;
    }

    /**
     * Ruft den Wert der resistanceX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceX() {
        return resistanceX;
    }

    /**
     * Legt den Wert der resistanceX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceX(Float value) {
        this.resistanceX = value;
    }

    /**
     * Ruft den Wert der resistanceY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceY() {
        return resistanceY;
    }

    /**
     * Legt den Wert der resistanceY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceY(Float value) {
        this.resistanceY = value;
    }

    /**
     * Ruft den Wert der resistanceZ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceZ() {
        return resistanceZ;
    }

    /**
     * Legt den Wert der resistanceZ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceZ(Float value) {
        this.resistanceZ = value;
    }

    /**
     * Ruft den Wert der resistanceXX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceXX() {
        return resistanceXX;
    }

    /**
     * Legt den Wert der resistanceXX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceXX(Float value) {
        this.resistanceXX = value;
    }

    /**
     * Ruft den Wert der resistanceYY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceYY() {
        return resistanceYY;
    }

    /**
     * Legt den Wert der resistanceYY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceYY(Float value) {
        this.resistanceYY = value;
    }

    /**
     * Ruft den Wert der resistanceZZ-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getResistanceZZ() {
        return resistanceZZ;
    }

    /**
     * Legt den Wert der resistanceZZ-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setResistanceZZ(Float value) {
        this.resistanceZZ = value;
    }

}
