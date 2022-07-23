//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AttributeDefinitions complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AttributeDefinitions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ActivationGroups" type="{}ActivationGroups" minOccurs="0"/&gt;
 *         &lt;element name="FeatureGroups" type="{}FeatureGroups"/&gt;
 *         &lt;element name="Attributes" type="{}Attributes"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeDefinitions", propOrder = {

})
public class AttributeDefinitions {

    @XmlElement(name = "ActivationGroups")
    protected ActivationGroups activationGroups;
    @XmlElement(name = "FeatureGroups", required = true)
    protected FeatureGroups featureGroups;
    @XmlElement(name = "Attributes", required = true)
    protected Attributes attributes;

    /**
     * Ruft den Wert der activationGroups-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActivationGroups }
     *     
     */
    public ActivationGroups getActivationGroups() {
        return activationGroups;
    }

    /**
     * Legt den Wert der activationGroups-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivationGroups }
     *     
     */
    public void setActivationGroups(ActivationGroups value) {
        this.activationGroups = value;
    }

    /**
     * Ruft den Wert der featureGroups-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FeatureGroups }
     *     
     */
    public FeatureGroups getFeatureGroups() {
        return featureGroups;
    }

    /**
     * Legt den Wert der featureGroups-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureGroups }
     *     
     */
    public void setFeatureGroups(FeatureGroups value) {
        this.featureGroups = value;
    }

    /**
     * Ruft den Wert der attributes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Attributes }
     *     
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Legt den Wert der attributes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Attributes }
     *     
     */
    public void setAttributes(Attributes value) {
        this.attributes = value;
    }

}
