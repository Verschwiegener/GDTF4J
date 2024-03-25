//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Point complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Point"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="DMXPercentage" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CFC0" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CFC1" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CFC2" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="CFC3" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Point")
public class Point {

    @XmlAttribute(name = "DMXPercentage", required = true)
    protected float dmxPercentage;
    @XmlAttribute(name = "CFC0", required = true)
    protected float cfc0;
    @XmlAttribute(name = "CFC1", required = true)
    protected float cfc1;
    @XmlAttribute(name = "CFC2", required = true)
    protected float cfc2;
    @XmlAttribute(name = "CFC3", required = true)
    protected float cfc3;

    /**
     * Ruft den Wert der dmxPercentage-Eigenschaft ab.
     * 
     */
    public float getDMXPercentage() {
        return dmxPercentage;
    }

    /**
     * Legt den Wert der dmxPercentage-Eigenschaft fest.
     * 
     */
    public void setDMXPercentage(float value) {
        this.dmxPercentage = value;
    }

    /**
     * Ruft den Wert der cfc0-Eigenschaft ab.
     * 
     */
    public float getCFC0() {
        return cfc0;
    }

    /**
     * Legt den Wert der cfc0-Eigenschaft fest.
     * 
     */
    public void setCFC0(float value) {
        this.cfc0 = value;
    }

    /**
     * Ruft den Wert der cfc1-Eigenschaft ab.
     * 
     */
    public float getCFC1() {
        return cfc1;
    }

    /**
     * Legt den Wert der cfc1-Eigenschaft fest.
     * 
     */
    public void setCFC1(float value) {
        this.cfc1 = value;
    }

    /**
     * Ruft den Wert der cfc2-Eigenschaft ab.
     * 
     */
    public float getCFC2() {
        return cfc2;
    }

    /**
     * Legt den Wert der cfc2-Eigenschaft fest.
     * 
     */
    public void setCFC2(float value) {
        this.cfc2 = value;
    }

    /**
     * Ruft den Wert der cfc3-Eigenschaft ab.
     * 
     */
    public float getCFC3() {
        return cfc3;
    }

    /**
     * Legt den Wert der cfc3-Eigenschaft fest.
     * 
     */
    public void setCFC3(float value) {
        this.cfc3 = value;
    }

}
