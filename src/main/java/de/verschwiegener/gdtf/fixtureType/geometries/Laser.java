//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Laser complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Laser"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}BasicGeometryType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="Protocol" type="{}Protocol"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ColorType" type="{}colorTypeEnum" default="RGB" /&gt;
 *       &lt;attribute name="Color" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="OutputStrength" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Emitter" type="{}nametype" /&gt;
 *       &lt;attribute name="BeamDiameter" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="BeamDivergenceMin" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="BeamDivergenceMax" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ScanAnglePan" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ScanAngleTilt" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ScanSpeed" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Laser", propOrder = {
    "protocol"
})
public class Laser
    extends BasicGeometryType
{

    @XmlElement(name = "Protocol")
    protected List<Protocol> protocol;
    @XmlAttribute(name = "ColorType")
    protected ColorTypeEnum colorType;
    @XmlAttribute(name = "Color")
    protected Float color;
    @XmlAttribute(name = "OutputStrength")
    protected Float outputStrength;
    @XmlAttribute(name = "Emitter")
    protected String emitter;
    @XmlAttribute(name = "BeamDiameter")
    protected Float beamDiameter;
    @XmlAttribute(name = "BeamDivergenceMin")
    protected Float beamDivergenceMin;
    @XmlAttribute(name = "BeamDivergenceMax")
    protected Float beamDivergenceMax;
    @XmlAttribute(name = "ScanAnglePan")
    protected Float scanAnglePan;
    @XmlAttribute(name = "ScanAngleTilt")
    protected Float scanAngleTilt;
    @XmlAttribute(name = "ScanSpeed")
    protected Float scanSpeed;

    /**
     * Gets the value of the protocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Protocol }
     * 
     * 
     */
    public List<Protocol> getProtocol() {
        if (protocol == null) {
            protocol = new ArrayList<Protocol>();
        }
        return this.protocol;
    }

    /**
     * Ruft den Wert der colorType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColorTypeEnum }
     *     
     */
    public ColorTypeEnum getColorType() {
        if (colorType == null) {
            return ColorTypeEnum.RGB;
        } else {
            return colorType;
        }
    }

    /**
     * Legt den Wert der colorType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorTypeEnum }
     *     
     */
    public void setColorType(ColorTypeEnum value) {
        this.colorType = value;
    }

    /**
     * Ruft den Wert der color-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getColor() {
        return color;
    }

    /**
     * Legt den Wert der color-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setColor(Float value) {
        this.color = value;
    }

    /**
     * Ruft den Wert der outputStrength-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOutputStrength() {
        return outputStrength;
    }

    /**
     * Legt den Wert der outputStrength-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOutputStrength(Float value) {
        this.outputStrength = value;
    }

    /**
     * Ruft den Wert der emitter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmitter() {
        return emitter;
    }

    /**
     * Legt den Wert der emitter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmitter(String value) {
        this.emitter = value;
    }

    /**
     * Ruft den Wert der beamDiameter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBeamDiameter() {
        return beamDiameter;
    }

    /**
     * Legt den Wert der beamDiameter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBeamDiameter(Float value) {
        this.beamDiameter = value;
    }

    /**
     * Ruft den Wert der beamDivergenceMin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBeamDivergenceMin() {
        return beamDivergenceMin;
    }

    /**
     * Legt den Wert der beamDivergenceMin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBeamDivergenceMin(Float value) {
        this.beamDivergenceMin = value;
    }

    /**
     * Ruft den Wert der beamDivergenceMax-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBeamDivergenceMax() {
        return beamDivergenceMax;
    }

    /**
     * Legt den Wert der beamDivergenceMax-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBeamDivergenceMax(Float value) {
        this.beamDivergenceMax = value;
    }

    /**
     * Ruft den Wert der scanAnglePan-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getScanAnglePan() {
        return scanAnglePan;
    }

    /**
     * Legt den Wert der scanAnglePan-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setScanAnglePan(Float value) {
        this.scanAnglePan = value;
    }

    /**
     * Ruft den Wert der scanAngleTilt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getScanAngleTilt() {
        return scanAngleTilt;
    }

    /**
     * Legt den Wert der scanAngleTilt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setScanAngleTilt(Float value) {
        this.scanAngleTilt = value;
    }

    /**
     * Ruft den Wert der scanSpeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getScanSpeed() {
        return scanSpeed;
    }

    /**
     * Legt den Wert der scanSpeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setScanSpeed(Float value) {
        this.scanSpeed = value;
    }

}
