//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.geometries;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PinPatch complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PinPatch"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ToWiringObject" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="FromPin" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="ToPin" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PinPatch")
public class PinPatch {

    @XmlAttribute(name = "ToWiringObject", required = true)
    protected String toWiringObject;
    @XmlAttribute(name = "FromPin", required = true)
    protected BigInteger fromPin;
    @XmlAttribute(name = "ToPin", required = true)
    protected BigInteger toPin;

    /**
     * Ruft den Wert der toWiringObject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToWiringObject() {
        return toWiringObject;
    }

    /**
     * Legt den Wert der toWiringObject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToWiringObject(String value) {
        this.toWiringObject = value;
    }

    /**
     * Ruft den Wert der fromPin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFromPin() {
        return fromPin;
    }

    /**
     * Legt den Wert der fromPin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFromPin(BigInteger value) {
        this.fromPin = value;
    }

    /**
     * Ruft den Wert der toPin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getToPin() {
        return toPin;
    }

    /**
     * Legt den Wert der toPin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setToPin(BigInteger value) {
        this.toPin = value;
    }

}
