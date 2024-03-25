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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Beam complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Beam"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}BasicGeometryType"&gt;
 *       &lt;attribute name="LampType" type="{}LampTypeEnum" /&gt;
 *       &lt;attribute name="PowerConsumption" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="LuminousFlux" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ColorTemperature" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="BeamAngle" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="FieldAngle" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="ThrowRatio" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="RectangleRatio" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="BeamRadius" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="BeamType" type="{}BeamTypeEnum" /&gt;
 *       &lt;attribute name="ColorRenderingIndex" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
 *       &lt;attribute name="EmitterSpectrum" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Beam")
public class Beam
    extends BasicGeometryType
{

    @XmlAttribute(name = "LampType")
    protected LampTypeEnum lampType;
    @XmlAttribute(name = "PowerConsumption")
    protected Float powerConsumption;
    @XmlAttribute(name = "LuminousFlux")
    protected Float luminousFlux;
    @XmlAttribute(name = "ColorTemperature")
    protected Float colorTemperature;
    @XmlAttribute(name = "BeamAngle")
    protected Float beamAngle;
    @XmlAttribute(name = "FieldAngle")
    protected Float fieldAngle;
    @XmlAttribute(name = "ThrowRatio")
    protected Float throwRatio;
    @XmlAttribute(name = "RectangleRatio")
    protected Float rectangleRatio;
    @XmlAttribute(name = "BeamRadius")
    protected Float beamRadius;
    @XmlAttribute(name = "BeamType")
    protected BeamTypeEnum beamType;
    @XmlAttribute(name = "ColorRenderingIndex")
    @XmlSchemaType(name = "unsignedByte")
    protected Short colorRenderingIndex;
    @XmlAttribute(name = "EmitterSpectrum")
    protected String emitterSpectrum;

    /**
     * Ruft den Wert der lampType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LampTypeEnum }
     *     
     */
    public LampTypeEnum getLampType() {
        return lampType;
    }

    /**
     * Legt den Wert der lampType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LampTypeEnum }
     *     
     */
    public void setLampType(LampTypeEnum value) {
        this.lampType = value;
    }

    /**
     * Ruft den Wert der powerConsumption-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPowerConsumption() {
        return powerConsumption;
    }

    /**
     * Legt den Wert der powerConsumption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPowerConsumption(Float value) {
        this.powerConsumption = value;
    }

    /**
     * Ruft den Wert der luminousFlux-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLuminousFlux() {
        return luminousFlux;
    }

    /**
     * Legt den Wert der luminousFlux-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLuminousFlux(Float value) {
        this.luminousFlux = value;
    }

    /**
     * Ruft den Wert der colorTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getColorTemperature() {
        return colorTemperature;
    }

    /**
     * Legt den Wert der colorTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setColorTemperature(Float value) {
        this.colorTemperature = value;
    }

    /**
     * Ruft den Wert der beamAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBeamAngle() {
        return beamAngle;
    }

    /**
     * Legt den Wert der beamAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBeamAngle(Float value) {
        this.beamAngle = value;
    }

    /**
     * Ruft den Wert der fieldAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFieldAngle() {
        return fieldAngle;
    }

    /**
     * Legt den Wert der fieldAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFieldAngle(Float value) {
        this.fieldAngle = value;
    }

    /**
     * Ruft den Wert der throwRatio-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getThrowRatio() {
        return throwRatio;
    }

    /**
     * Legt den Wert der throwRatio-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setThrowRatio(Float value) {
        this.throwRatio = value;
    }

    /**
     * Ruft den Wert der rectangleRatio-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRectangleRatio() {
        return rectangleRatio;
    }

    /**
     * Legt den Wert der rectangleRatio-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRectangleRatio(Float value) {
        this.rectangleRatio = value;
    }

    /**
     * Ruft den Wert der beamRadius-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBeamRadius() {
        return beamRadius;
    }

    /**
     * Legt den Wert der beamRadius-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBeamRadius(Float value) {
        this.beamRadius = value;
    }

    /**
     * Ruft den Wert der beamType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BeamTypeEnum }
     *     
     */
    public BeamTypeEnum getBeamType() {
        return beamType;
    }

    /**
     * Legt den Wert der beamType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BeamTypeEnum }
     *     
     */
    public void setBeamType(BeamTypeEnum value) {
        this.beamType = value;
    }

    /**
     * Ruft den Wert der colorRenderingIndex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getColorRenderingIndex() {
        return colorRenderingIndex;
    }

    /**
     * Legt den Wert der colorRenderingIndex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setColorRenderingIndex(Short value) {
        this.colorRenderingIndex = value;
    }

    /**
     * Ruft den Wert der emitterSpectrum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmitterSpectrum() {
        return emitterSpectrum;
    }

    /**
     * Legt den Wert der emitterSpectrum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmitterSpectrum(String value) {
        this.emitterSpectrum = value;
    }

}
