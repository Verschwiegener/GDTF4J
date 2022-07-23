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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Attribute complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Attribute"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Pretty" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ActivationGroup" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PhysicalUnit" type="{}PhysicalUnitEnum" default="None" /&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Feature" use="required" type="{}featuretype" /&gt;
 *       &lt;attribute name="MainAttribute" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attribute")
public class Attribute {

    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Pretty", required = true)
    protected String pretty;
    @XmlAttribute(name = "ActivationGroup")
    protected String activationGroup;
    @XmlAttribute(name = "PhysicalUnit")
    protected PhysicalUnitEnum physicalUnit;
    @XmlAttribute(name = "Color")
    protected String color;
    @XmlAttribute(name = "Feature", required = true)
    protected String feature;
    @XmlAttribute(name = "MainAttribute")
    protected String mainAttribute;

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
     * Ruft den Wert der pretty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPretty() {
        return pretty;
    }

    /**
     * Legt den Wert der pretty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPretty(String value) {
        this.pretty = value;
    }

    /**
     * Ruft den Wert der activationGroup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivationGroup() {
        return activationGroup;
    }

    /**
     * Legt den Wert der activationGroup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivationGroup(String value) {
        this.activationGroup = value;
    }

    /**
     * Ruft den Wert der physicalUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalUnitEnum }
     *     
     */
    public PhysicalUnitEnum getPhysicalUnit() {
        if (physicalUnit == null) {
            return PhysicalUnitEnum.NONE;
        } else {
            return physicalUnit;
        }
    }

    /**
     * Legt den Wert der physicalUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalUnitEnum }
     *     
     */
    public void setPhysicalUnit(PhysicalUnitEnum value) {
        this.physicalUnit = value;
    }

    /**
     * Ruft den Wert der color-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Legt den Wert der color-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Ruft den Wert der feature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeature() {
        return feature;
    }

    /**
     * Legt den Wert der feature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeature(String value) {
        this.feature = value;
    }

    /**
     * Ruft den Wert der mainAttribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainAttribute() {
        return mainAttribute;
    }

    /**
     * Legt den Wert der mainAttribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainAttribute(String value) {
        this.mainAttribute = value;
    }

}
