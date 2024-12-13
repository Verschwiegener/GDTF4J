//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.25 um 04:32:18 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


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
 *       &lt;attribute name="ChannelFunction" type="{}nametype" /&gt;
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
    @XmlAttribute(name = "ChannelFunction")
    protected String channelFunction;

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

    /**
     * Ruft den Wert der channelFunction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getChannelFunction() {
        return new GDTFNode(channelFunction, NodeSearchPoint.DMXChannel);
    }

    /**
     * Legt den Wert der channelFunction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelFunction(GDTFNode value) {
        this.channelFunction = value.toGDTF();
    }

}
