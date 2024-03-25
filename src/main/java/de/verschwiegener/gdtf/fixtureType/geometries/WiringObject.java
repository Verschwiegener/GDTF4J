//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für WiringObject complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WiringObject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}BasicGeometryType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="PinPatch" type="{}PinPatch"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ConnectorType" type="{}nametype" /&gt;
 *       &lt;attribute name="ComponentType" type="{}wiringComponentEnum" /&gt;
 *       &lt;attribute name="SignalType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PinCount" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="ElectricalPayLoad" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="VoltageRangeMax" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="VoltageRangeMin" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FrequencyRangeMax" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FrequencyRangeMin" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="MaxPayLoad" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Voltage" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="SignalLayer" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="CosPhi" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FuseCurrent" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FuseRating" type="{}fuseRatingEnum" /&gt;
 *       &lt;attribute name="Orientation" type="{}orientationEnum" /&gt;
 *       &lt;attribute name="WireGroup" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WiringObject", propOrder = {
    "pinPatch"
})
public class WiringObject
    extends BasicGeometryType
{

    @XmlElement(name = "PinPatch")
    protected List<PinPatch> pinPatch;
    @XmlAttribute(name = "ConnectorType")
    protected String connectorType;
    @XmlAttribute(name = "ComponentType")
    protected WiringComponentEnum componentType;
    @XmlAttribute(name = "SignalType")
    protected String signalType;
    @XmlAttribute(name = "PinCount")
    protected BigInteger pinCount;
    @XmlAttribute(name = "ElectricalPayLoad")
    protected Float electricalPayLoad;
    @XmlAttribute(name = "VoltageRangeMax")
    protected Float voltageRangeMax;
    @XmlAttribute(name = "VoltageRangeMin")
    protected Float voltageRangeMin;
    @XmlAttribute(name = "FrequencyRangeMax")
    protected Float frequencyRangeMax;
    @XmlAttribute(name = "FrequencyRangeMin")
    protected Float frequencyRangeMin;
    @XmlAttribute(name = "MaxPayLoad")
    protected Float maxPayLoad;
    @XmlAttribute(name = "Voltage")
    protected Float voltage;
    @XmlAttribute(name = "SignalLayer")
    protected BigInteger signalLayer;
    @XmlAttribute(name = "CosPhi")
    protected Float cosPhi;
    @XmlAttribute(name = "FuseCurrent")
    protected Float fuseCurrent;
    @XmlAttribute(name = "FuseRating")
    protected FuseRatingEnum fuseRating;
    @XmlAttribute(name = "Orientation")
    protected OrientationEnum orientation;
    @XmlAttribute(name = "WireGroup")
    protected String wireGroup;

    /**
     * Gets the value of the pinPatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pinPatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPinPatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PinPatch }
     * 
     * 
     */
    public List<PinPatch> getPinPatch() {
        if (pinPatch == null) {
            pinPatch = new ArrayList<PinPatch>();
        }
        return this.pinPatch;
    }

    /**
     * Ruft den Wert der connectorType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorType() {
        return connectorType;
    }

    /**
     * Legt den Wert der connectorType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorType(String value) {
        this.connectorType = value;
    }

    /**
     * Ruft den Wert der componentType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WiringComponentEnum }
     *     
     */
    public WiringComponentEnum getComponentType() {
        return componentType;
    }

    /**
     * Legt den Wert der componentType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WiringComponentEnum }
     *     
     */
    public void setComponentType(WiringComponentEnum value) {
        this.componentType = value;
    }

    /**
     * Ruft den Wert der signalType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignalType() {
        return signalType;
    }

    /**
     * Legt den Wert der signalType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignalType(String value) {
        this.signalType = value;
    }

    /**
     * Ruft den Wert der pinCount-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPinCount() {
        return pinCount;
    }

    /**
     * Legt den Wert der pinCount-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPinCount(BigInteger value) {
        this.pinCount = value;
    }

    /**
     * Ruft den Wert der electricalPayLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getElectricalPayLoad() {
        return electricalPayLoad;
    }

    /**
     * Legt den Wert der electricalPayLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setElectricalPayLoad(Float value) {
        this.electricalPayLoad = value;
    }

    /**
     * Ruft den Wert der voltageRangeMax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVoltageRangeMax() {
        return voltageRangeMax;
    }

    /**
     * Legt den Wert der voltageRangeMax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVoltageRangeMax(Float value) {
        this.voltageRangeMax = value;
    }

    /**
     * Ruft den Wert der voltageRangeMin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVoltageRangeMin() {
        return voltageRangeMin;
    }

    /**
     * Legt den Wert der voltageRangeMin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVoltageRangeMin(Float value) {
        this.voltageRangeMin = value;
    }

    /**
     * Ruft den Wert der frequencyRangeMax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFrequencyRangeMax() {
        return frequencyRangeMax;
    }

    /**
     * Legt den Wert der frequencyRangeMax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFrequencyRangeMax(Float value) {
        this.frequencyRangeMax = value;
    }

    /**
     * Ruft den Wert der frequencyRangeMin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFrequencyRangeMin() {
        return frequencyRangeMin;
    }

    /**
     * Legt den Wert der frequencyRangeMin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFrequencyRangeMin(Float value) {
        this.frequencyRangeMin = value;
    }

    /**
     * Ruft den Wert der maxPayLoad-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaxPayLoad() {
        return maxPayLoad;
    }

    /**
     * Legt den Wert der maxPayLoad-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaxPayLoad(Float value) {
        this.maxPayLoad = value;
    }

    /**
     * Ruft den Wert der voltage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVoltage() {
        return voltage;
    }

    /**
     * Legt den Wert der voltage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVoltage(Float value) {
        this.voltage = value;
    }

    /**
     * Ruft den Wert der signalLayer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSignalLayer() {
        return signalLayer;
    }

    /**
     * Legt den Wert der signalLayer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSignalLayer(BigInteger value) {
        this.signalLayer = value;
    }

    /**
     * Ruft den Wert der cosPhi-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCosPhi() {
        return cosPhi;
    }

    /**
     * Legt den Wert der cosPhi-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCosPhi(Float value) {
        this.cosPhi = value;
    }

    /**
     * Ruft den Wert der fuseCurrent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFuseCurrent() {
        return fuseCurrent;
    }

    /**
     * Legt den Wert der fuseCurrent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFuseCurrent(Float value) {
        this.fuseCurrent = value;
    }

    /**
     * Ruft den Wert der fuseRating-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FuseRatingEnum }
     *     
     */
    public FuseRatingEnum getFuseRating() {
        return fuseRating;
    }

    /**
     * Legt den Wert der fuseRating-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FuseRatingEnum }
     *     
     */
    public void setFuseRating(FuseRatingEnum value) {
        this.fuseRating = value;
    }

    /**
     * Ruft den Wert der orientation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrientationEnum }
     *     
     */
    public OrientationEnum getOrientation() {
        return orientation;
    }

    /**
     * Legt den Wert der orientation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrientationEnum }
     *     
     */
    public void setOrientation(OrientationEnum value) {
        this.orientation = value;
    }

    /**
     * Ruft den Wert der wireGroup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWireGroup() {
        return wireGroup;
    }

    /**
     * Legt den Wert der wireGroup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWireGroup(String value) {
        this.wireGroup = value;
    }

}
