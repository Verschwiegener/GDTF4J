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

import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;

/**
 * <p>
 * Java-Klasse für ChannelFunction complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ChannelFunction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ChannelSet" type="{}ChannelSet"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" type="{}nametype" /&gt;
 *       &lt;attribute name="Attribute" type="{}nametype" default="NoFeature" /&gt;
 *       &lt;attribute name="OriginalAttribute" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *       &lt;attribute name="DMXFrom" type="{}dmxtype" default="0/1" /&gt;
 *       &lt;attribute name="Default" use="required" type="{}dmxtype" /&gt;
 *       &lt;attribute name="PhysicalFrom" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="PhysicalTo" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="RealFade" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="RealAcceleration" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Wheel" type="{}nametype" /&gt;
 *       &lt;attribute name="Emitter" type="{}nametype" /&gt;
 *       &lt;attribute name="Filter" type="{}nametype" /&gt;
 *       &lt;attribute name="ModeMaster" type="{}nodetype" /&gt;
 *       &lt;attribute name="ModeFrom" type="{}dmxtype" default="0/1" /&gt;
 *       &lt;attribute name="ModeTo" type="{}dmxtype" default="0/1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChannelFunction", propOrder = {
    "channelSet",
    "subChannelSet"
})
public class ChannelFunction {

    @XmlElement(name = "ChannelSet")
    protected List<ChannelSet> channelSet;
    @XmlElement(name = "SubChannelSet")
    protected List<SubChannelSet> subChannelSet;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Attribute")
    protected String attribute;
    @XmlAttribute(name = "OriginalAttribute")
    protected String originalAttribute;
    @XmlAttribute(name = "DMXFrom")
    protected String dmxFrom;
    @XmlAttribute(name = "Default", required = true)
    protected String _default;
    @XmlAttribute(name = "PhysicalFrom")
    protected Float physicalFrom;
    @XmlAttribute(name = "PhysicalTo")
    protected Float physicalTo;
    @XmlAttribute(name = "RealFade")
    protected Float realFade;
    @XmlAttribute(name = "RealAcceleration")
    protected Float realAcceleration;
    @XmlAttribute(name = "Wheel")
    protected String wheel;
    @XmlAttribute(name = "Emitter")
    protected String emitter;
    @XmlAttribute(name = "Filter")
    protected String filter;
    @XmlAttribute(name = "ColorSpace")
    protected String colorSpace;
    @XmlAttribute(name = "Gammut")
    protected String gamut;
    @XmlAttribute(name = "ModeMaster")
    protected String modeMaster;
    @XmlAttribute(name = "ModeFrom")
    protected String modeFrom;
    @XmlAttribute(name = "ModeTo")
    protected String modeTo;
    @XmlAttribute(name = "DMXProfile")
    protected String dmxProfile;
    @XmlAttribute(name = "Min")
    protected Float min;
    @XmlAttribute(name = "Max")
    protected Float max;
    @XmlAttribute(name = "CustomName")
    protected String customName;

    /**
     * Gets the value of the channelSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the channelSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChannelSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChannelSet }
     * 
     * 
     */
    public List<ChannelSet> getChannelSet() {
        if (channelSet == null) {
            channelSet = new ArrayList<ChannelSet>();
        }
        return this.channelSet;
    }

    /**
     * Gets the value of the subChannelSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subChannelSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubChannelSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubChannelSet }
     * 
     * 
     */
    public List<SubChannelSet> getSubChannelSet() {
        if (subChannelSet == null) {
            subChannelSet = new ArrayList<SubChannelSet>();
        }
        return this.subChannelSet;
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
     * Ruft den Wert der attribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getAttribute() {
        if (attribute == null) {
            return new GDTFNode("NoFeature", NodeStartingPoint.Attribute);
        } else {
            return new GDTFNode(attribute, NodeStartingPoint.Attribute);
        }
    }

    /**
     * Legt den Wert der attribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribute(GDTFNode value) {
        this.attribute = value.toString();
    }

    /**
     * Ruft den Wert der originalAttribute-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAttribute() {
        if (originalAttribute == null) {
            return "";
        } else {
            return originalAttribute;
        }
    }

    /**
     * Legt den Wert der originalAttribute-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAttribute(String value) {
        this.originalAttribute = value;
    }

    /**
     * Ruft den Wert der dmxFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFDMXValue getDMXFrom() {
        if (dmxFrom == null) {
            return new GDTFDMXValue("0/1");
        } else {
            return new GDTFDMXValue(dmxFrom);
        }
    }

    /**
     * Legt den Wert der dmxFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMXFrom(GDTFDMXValue value) {
        this.dmxFrom = value.toGDTF();
    }

    /**
     * Ruft den Wert der default-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFDMXValue getDefault() {
        return new GDTFDMXValue(_default);
    }

    /**
     * Legt den Wert der default-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefault(GDTFDMXValue value) {
        this._default = value.toGDTF();
    }

    /**
     * Ruft den Wert der physicalFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPhysicalFrom() {
        return physicalFrom;
    }

    /**
     * Legt den Wert der physicalFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPhysicalFrom(Float value) {
        this.physicalFrom = value;
    }

    /**
     * Ruft den Wert der physicalTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPhysicalTo() {
        return physicalTo;
    }

    /**
     * Legt den Wert der physicalTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPhysicalTo(Float value) {
        this.physicalTo = value;
    }

    /**
     * Ruft den Wert der realFade-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRealFade() {
        return realFade;
    }

    /**
     * Legt den Wert der realFade-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRealFade(Float value) {
        this.realFade = value;
    }

    /**
     * Ruft den Wert der realAcceleration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRealAcceleration() {
        return realAcceleration;
    }

    /**
     * Legt den Wert der realAcceleration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRealAcceleration(Float value) {
        this.realAcceleration = value;
    }

    /**
     * Ruft den Wert der wheel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getWheel() {
        return new GDTFNode(wheel, NodeStartingPoint.Wheel);
    }

    /**
     * Legt den Wert der wheel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWheel(GDTFNode value) {
        this.wheel = value.toGDTF();
    }

    /**
     * Ruft den Wert der emitter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getEmitter() {
        return new GDTFNode(emitter, NodeStartingPoint.Emitter);
    }

    /**
     * Legt den Wert der emitter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmitter(GDTFNode value) {
        this.emitter = value.toGDTF();
    }

    /**
     * Ruft den Wert der filter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getFilter() {
        return new GDTFNode(filter, NodeStartingPoint.Filter);
    }

    /**
     * Legt den Wert der filter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilter(GDTFNode value) {
        this.filter = value.toGDTF();
    }

    /**
     * Ruft den Wert der colorSpace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getColorSpace() {
        return new GDTFNode(colorSpace, NodeStartingPoint.PhysicalDescription);
    }

    /**
     * Legt den Wert der colorSpace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorSpace(GDTFNode value) {
        this.colorSpace = value.toGDTF();
    }
    /**
     * Ruft den Wert der Gammut-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getGamut() {
    	return new GDTFNode(gamut, NodeStartingPoint.Gammut);
    }
    /**
     * Legt den Wert der Gammut-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGamut(GDTFNode gamut) {
		this.gamut = gamut.toGDTF();
	}

    /**
     * Ruft den Wert der modeMaster-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getModeMaster() {
        return new GDTFNode(modeMaster, NodeStartingPoint.DMXMode);
    }

    /**
     * Legt den Wert der modeMaster-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeMaster(GDTFNode value) {
        this.modeMaster = value.toGDTF();
    }

    /**
     * Ruft den Wert der modeFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFDMXValue getModeFrom() {
        if (modeFrom == null) {
            return new GDTFDMXValue("0/1");
        } else {
            return new GDTFDMXValue(modeFrom);
        }
    }

    /**
     * Legt den Wert der modeFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeFrom(GDTFDMXValue value) {
        this.modeFrom = value.toGDTF();
    }

    /**
     * Ruft den Wert der modeTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFDMXValue getModeTo() {
        if (modeTo == null) {
            return new GDTFDMXValue("0/1");
        } else {
            return new GDTFDMXValue(modeTo);
        }
    }

    /**
     * Legt den Wert der modeTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeTo(String value) {
        this.modeTo = value;
    }

    /**
     * Ruft den Wert der dmxProfile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getDMXProfile() {
        return new GDTFNode(dmxProfile, NodeStartingPoint.DMXProfile);
    }

    /**
     * Legt den Wert der dmxProfile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMXProfile(GDTFNode value) {
        this.dmxProfile = value.toGDTF();
    }

    /**
     * Ruft den Wert der min-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMin() {
        return min;
    }

    /**
     * Legt den Wert der min-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMin(Float value) {
        this.min = value;
    }

    /**
     * Ruft den Wert der max-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMax() {
        return max;
    }

    /**
     * Legt den Wert der max-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMax(Float value) {
        this.max = value;
    }

    /**
     * Ruft den Wert der customName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomName() {
        return customName;
    }

    /**
     * Legt den Wert der customName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomName(String value) {
        this.customName = value;
    }
}
