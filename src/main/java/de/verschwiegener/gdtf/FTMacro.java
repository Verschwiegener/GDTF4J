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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FTMacro complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FTMacro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MacroDMX" type="{}MacroDMX" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTMacro", propOrder = {
    "macroDMX"
})
public class FTMacro {

    @XmlElement(name = "MacroDMX")
    protected MacroDMX macroDMX;
    @XmlAttribute(name = "Name", required = true)
    protected String name;

    /**
     * Ruft den Wert der macroDMX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MacroDMX }
     *     
     */
    public MacroDMX getMacroDMX() {
        return macroDMX;
    }

    /**
     * Legt den Wert der macroDMX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MacroDMX }
     *     
     */
    public void setMacroDMX(MacroDMX value) {
        this.macroDMX = value;
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

}
