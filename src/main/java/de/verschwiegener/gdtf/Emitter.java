//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Emitter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Emitter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="Measurement"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="MeasurementPoint" type="{}MeasurementPoint"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Physical" use="required" type="{}physicaltype" /&gt;
 *                 &lt;attribute name="LuminousIntensity" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *                 &lt;attribute name="InterpolationTo" type="{}InterpolationToEnum" default="Linear" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *       &lt;attribute name="DominantWaveLength" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="DiodePart" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Emitter", propOrder = {
    "measurement"
})
public class Emitter {

    @XmlElement(name = "Measurement")
    protected List<Emitter.Measurement> measurement;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Color")
    protected String color;
    @XmlAttribute(name = "DominantWaveLength")
    protected Float dominantWaveLength;
    @XmlAttribute(name = "DiodePart")
    protected String diodePart;

    /**
     * Gets the value of the measurement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Emitter.Measurement }
     * 
     * 
     */
    public List<Emitter.Measurement> getMeasurement() {
        if (measurement == null) {
            measurement = new ArrayList<Emitter.Measurement>();
        }
        return this.measurement;
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
     * Ruft den Wert der dominantWaveLength-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDominantWaveLength() {
        return dominantWaveLength;
    }

    /**
     * Legt den Wert der dominantWaveLength-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDominantWaveLength(Float value) {
        this.dominantWaveLength = value;
    }

    /**
     * Ruft den Wert der diodePart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiodePart() {
        return diodePart;
    }

    /**
     * Legt den Wert der diodePart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiodePart(String value) {
        this.diodePart = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="MeasurementPoint" type="{}MeasurementPoint"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Physical" use="required" type="{}physicaltype" /&gt;
     *       &lt;attribute name="LuminousIntensity" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
     *       &lt;attribute name="InterpolationTo" type="{}InterpolationToEnum" default="Linear" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "measurementPoint"
    })
    public static class Measurement {

        @XmlElement(name = "MeasurementPoint")
        protected List<MeasurementPoint> measurementPoint;
        @XmlAttribute(name = "Physical", required = true)
        protected float physical;
        @XmlAttribute(name = "LuminousIntensity", required = true)
        protected float luminousIntensity;
        @XmlAttribute(name = "InterpolationTo")
        protected InterpolationToEnum interpolationTo;

        /**
         * Gets the value of the measurementPoint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the measurementPoint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMeasurementPoint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeasurementPoint }
         * 
         * 
         */
        public List<MeasurementPoint> getMeasurementPoint() {
            if (measurementPoint == null) {
                measurementPoint = new ArrayList<MeasurementPoint>();
            }
            return this.measurementPoint;
        }

        /**
         * Ruft den Wert der physical-Eigenschaft ab.
         * 
         */
        public float getPhysical() {
            return physical;
        }

        /**
         * Legt den Wert der physical-Eigenschaft fest.
         * 
         */
        public void setPhysical(float value) {
            this.physical = value;
        }

        /**
         * Ruft den Wert der luminousIntensity-Eigenschaft ab.
         * 
         */
        public float getLuminousIntensity() {
            return luminousIntensity;
        }

        /**
         * Legt den Wert der luminousIntensity-Eigenschaft fest.
         * 
         */
        public void setLuminousIntensity(float value) {
            this.luminousIntensity = value;
        }

        /**
         * Ruft den Wert der interpolationTo-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link InterpolationToEnum }
         *     
         */
        public InterpolationToEnum getInterpolationTo() {
            if (interpolationTo == null) {
                return InterpolationToEnum.LINEAR;
            } else {
                return interpolationTo;
            }
        }

        /**
         * Legt den Wert der interpolationTo-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link InterpolationToEnum }
         *     
         */
        public void setInterpolationTo(InterpolationToEnum value) {
            this.interpolationTo = value;
        }

    }

}
