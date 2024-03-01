//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PowerConsumption complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PowerConsumption"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="PowerFactor" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Connector" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="VoltageLow" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="VoltageHigh" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FrequencyLow" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FrequencyHigh" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerConsumption")
public class PowerConsumption {

    @XmlAttribute(name = "Value")
    protected Float value;
    @XmlAttribute(name = "PowerFactor")
    protected Float powerFactor;
    @XmlAttribute(name = "Connector", required = true)
    protected String connector;
    @XmlAttribute(name = "VoltageLow")
    protected Float voltageLow;
    @XmlAttribute(name = "VoltageHigh")
    protected Float voltageHigh;
    @XmlAttribute(name = "FrequencyLow")
    protected Float frequencyLow;
    @XmlAttribute(name = "FrequencyHigh")
    protected Float frequencyHigh;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der powerFactor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPowerFactor() {
        return powerFactor;
    }

    /**
     * Legt den Wert der powerFactor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPowerFactor(Float value) {
        this.powerFactor = value;
    }

    /**
     * Ruft den Wert der connector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnector() {
        return connector;
    }

    /**
     * Legt den Wert der connector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnector(String value) {
        this.connector = value;
    }

    /**
     * Ruft den Wert der voltageLow-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVoltageLow() {
        return voltageLow;
    }

    /**
     * Legt den Wert der voltageLow-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVoltageLow(Float value) {
        this.voltageLow = value;
    }

    /**
     * Ruft den Wert der voltageHigh-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVoltageHigh() {
        return voltageHigh;
    }

    /**
     * Legt den Wert der voltageHigh-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVoltageHigh(Float value) {
        this.voltageHigh = value;
    }

    /**
     * Ruft den Wert der frequencyLow-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFrequencyLow() {
        return frequencyLow;
    }

    /**
     * Legt den Wert der frequencyLow-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFrequencyLow(Float value) {
        this.frequencyLow = value;
    }

    /**
     * Ruft den Wert der frequencyHigh-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFrequencyHigh() {
        return frequencyHigh;
    }

    /**
     * Legt den Wert der frequencyHigh-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFrequencyHigh(Float value) {
        this.frequencyHigh = value;
    }

}
