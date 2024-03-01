//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Filter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Filter"&gt;
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
 *                 &lt;attribute name="Transmission" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *                 &lt;attribute name="InterpolationTo" type="{}InterpolationToEnum" default="Linear" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filter", propOrder = {
    "measurement"
})
public class Filter {

    @XmlElement(name = "Measurement")
    protected List<Filter.Measurement> measurement;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Color")
    protected String color;

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
     * {@link Filter.Measurement }
     * 
     * 
     */
    public List<Filter.Measurement> getMeasurement() {
        if (measurement == null) {
            measurement = new ArrayList<Filter.Measurement>();
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
     *       &lt;attribute name="Transmission" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
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
        @XmlAttribute(name = "Transmission", required = true)
        protected float transmission;
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
         * Ruft den Wert der transmission-Eigenschaft ab.
         * 
         */
        public float getTransmission() {
            return transmission;
        }

        /**
         * Legt den Wert der transmission-Eigenschaft fest.
         * 
         */
        public void setTransmission(float value) {
            this.transmission = value;
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
