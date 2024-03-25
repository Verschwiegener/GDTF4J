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
 * <p>Java-Klasse für Structure complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Structure"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}BasicGeometryType"&gt;
 *       &lt;attribute name="LinkedGeometry" type="{}nametype" /&gt;
 *       &lt;attribute name="StructureType" type="{}structureTypeEnum" /&gt;
 *       &lt;attribute name="CrossSectionType" type="{}crossSectionEnum" /&gt;
 *       &lt;attribute name="CrossSectionHeight" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CrossSectionWallThickness" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="TrussCrossSection" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Structure")
public class Structure
    extends BasicGeometryType
{

    @XmlAttribute(name = "LinkedGeometry")
    protected String linkedGeometry;
    @XmlAttribute(name = "StructureType")
    protected StructureTypeEnum structureType;
    @XmlAttribute(name = "CrossSectionType")
    protected CrossSectionEnum crossSectionType;
    @XmlAttribute(name = "CrossSectionHeight")
    protected Float crossSectionHeight;
    @XmlAttribute(name = "CrossSectionWallThickness")
    protected Float crossSectionWallThickness;
    @XmlAttribute(name = "TrussCrossSection")
    protected String trussCrossSection;

    /**
     * Ruft den Wert der linkedGeometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedGeometry() {
        return linkedGeometry;
    }

    /**
     * Legt den Wert der linkedGeometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedGeometry(String value) {
        this.linkedGeometry = value;
    }

    /**
     * Ruft den Wert der structureType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StructureTypeEnum }
     *     
     */
    public StructureTypeEnum getStructureType() {
        return structureType;
    }

    /**
     * Legt den Wert der structureType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureTypeEnum }
     *     
     */
    public void setStructureType(StructureTypeEnum value) {
        this.structureType = value;
    }

    /**
     * Ruft den Wert der crossSectionType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CrossSectionEnum }
     *     
     */
    public CrossSectionEnum getCrossSectionType() {
        return crossSectionType;
    }

    /**
     * Legt den Wert der crossSectionType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossSectionEnum }
     *     
     */
    public void setCrossSectionType(CrossSectionEnum value) {
        this.crossSectionType = value;
    }

    /**
     * Ruft den Wert der crossSectionHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCrossSectionHeight() {
        return crossSectionHeight;
    }

    /**
     * Legt den Wert der crossSectionHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCrossSectionHeight(Float value) {
        this.crossSectionHeight = value;
    }

    /**
     * Ruft den Wert der crossSectionWallThickness-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCrossSectionWallThickness() {
        return crossSectionWallThickness;
    }

    /**
     * Legt den Wert der crossSectionWallThickness-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCrossSectionWallThickness(Float value) {
        this.crossSectionWallThickness = value;
    }

    /**
     * Ruft den Wert der trussCrossSection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrussCrossSection() {
        return trussCrossSection;
    }

    /**
     * Legt den Wert der trussCrossSection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrussCrossSection(String value) {
        this.trussCrossSection = value;
    }

}
