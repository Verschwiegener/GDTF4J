//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DMXChannel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DMXChannel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="LogicalChannel" type="{}LogicalChannel"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DMXBreak" type="{}dmxbreaktype" default="1" /&gt;
 *       &lt;attribute name="Offset" type="{}offsettype" default="None" /&gt;
 *       &lt;attribute name="InitialFunction" type="{}nodetype" /&gt;
 *       &lt;attribute name="Highlight" type="{}dmxtype" default="None" /&gt;
 *       &lt;attribute name="Geometry" use="required" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMXChannel", propOrder = {
    "logicalChannel"
})
public class DMXChannel {

    @XmlElement(name = "LogicalChannel")
    protected List<LogicalChannel> logicalChannel;
    @XmlAttribute(name = "DMXBreak")
    protected String dmxBreak;
    @XmlAttribute(name = "Offset")
    protected String offset;
    @XmlAttribute(name = "InitialFunction")
    protected String initialFunction;
    @XmlAttribute(name = "Highlight")
    protected String highlight;
    @XmlAttribute(name = "Geometry", required = true)
    protected String geometry;

    /**
     * Gets the value of the logicalChannel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalChannel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalChannel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogicalChannel }
     * 
     * 
     */
    public List<LogicalChannel> getLogicalChannel() {
        if (logicalChannel == null) {
            logicalChannel = new ArrayList<LogicalChannel>();
        }
        return this.logicalChannel;
    }

    /**
     * Ruft den Wert der dmxBreak-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDMXBreak() {
        if (dmxBreak == null) {
            return "1";
        } else {
            return dmxBreak;
        }
    }

    /**
     * Legt den Wert der dmxBreak-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMXBreak(String value) {
        this.dmxBreak = value;
    }

    /**
     * Ruft den Wert der offset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffset() {
        if (offset == null) {
            return "None";
        } else {
            return offset;
        }
    }

    /**
     * Legt den Wert der offset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffset(String value) {
        this.offset = value;
    }

    /**
     * Ruft den Wert der initialFunction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialFunction() {
        return initialFunction;
    }

    /**
     * Legt den Wert der initialFunction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialFunction(String value) {
        this.initialFunction = value;
    }

    /**
     * Ruft den Wert der highlight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighlight() {
        if (highlight == null) {
            return "None";
        } else {
            return highlight;
        }
    }

    /**
     * Legt den Wert der highlight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighlight(String value) {
        this.highlight = value;
    }

    /**
     * Ruft den Wert der geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeometry() {
        return geometry;
    }

    /**
     * Legt den Wert der geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeometry(String value) {
        this.geometry = value;
    }

}
