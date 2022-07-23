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
 * <p>Java-Klasse für LogicalChannel complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogicalChannel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ChannelFunction" type="{}ChannelFunction"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Attribute" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Snap" type="{}SnapEnum" default="No" /&gt;
 *       &lt;attribute name="Master" type="{}MasterEnum" default="None" /&gt;
 *       &lt;attribute name="MibFade" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="DMXChangeTimeLimit" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalChannel", propOrder = {
    "channelFunction"
})
public class LogicalChannel {

    @XmlElement(name = "ChannelFunction")
    protected List<ChannelFunction> channelFunction;
    @XmlAttribute(name = "Attribute", required = true)
    protected String attribute;
    @XmlAttribute(name = "Snap")
    protected SnapEnum snap;
    @XmlAttribute(name = "Master")
    protected MasterEnum master;
    @XmlAttribute(name = "MibFade")
    protected Float mibFade;
    @XmlAttribute(name = "DMXChangeTimeLimit")
    protected Float dmxChangeTimeLimit;

    /**
     * Gets the value of the channelFunction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the channelFunction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChannelFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChannelFunction }
     * 
     * 
     */
    public List<ChannelFunction> getChannelFunction() {
        if (channelFunction == null) {
            channelFunction = new ArrayList<ChannelFunction>();
        }
        return this.channelFunction;
    }

    /**
     * Ruft den Wert der attribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Legt den Wert der attribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute(String value) {
        this.attribute = value;
    }

    /**
     * Ruft den Wert der snap-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SnapEnum }
     *     
     */
    public SnapEnum getSnap() {
        if (snap == null) {
            return SnapEnum.NO;
        } else {
            return snap;
        }
    }

    /**
     * Legt den Wert der snap-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SnapEnum }
     *     
     */
    public void setSnap(SnapEnum value) {
        this.snap = value;
    }

    /**
     * Ruft den Wert der master-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MasterEnum }
     *     
     */
    public MasterEnum getMaster() {
        if (master == null) {
            return MasterEnum.NONE;
        } else {
            return master;
        }
    }

    /**
     * Legt den Wert der master-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterEnum }
     *     
     */
    public void setMaster(MasterEnum value) {
        this.master = value;
    }

    /**
     * Ruft den Wert der mibFade-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMibFade() {
        return mibFade;
    }

    /**
     * Legt den Wert der mibFade-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMibFade(Float value) {
        this.mibFade = value;
    }

    /**
     * Ruft den Wert der dmxChangeTimeLimit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDMXChangeTimeLimit() {
        return dmxChangeTimeLimit;
    }

    /**
     * Legt den Wert der dmxChangeTimeLimit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDMXChangeTimeLimit(Float value) {
        this.dmxChangeTimeLimit = value;
    }

}
