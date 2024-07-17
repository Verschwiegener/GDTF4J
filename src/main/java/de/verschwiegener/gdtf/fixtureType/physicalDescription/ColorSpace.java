//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ColorSpace complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ColorSpace"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Mode" type="{}ColorSpaceEnum" default="sRGB" /&gt;
 *       &lt;attribute name="Red" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Green" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Blue" type="{}colorcietype" /&gt;
 *       &lt;attribute name="WhitePoint" type="{}colorcietype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorSpace")
public class ColorSpace {
	
	@XmlAttribute(name = "Name")
	protected String name;
	
    @XmlAttribute(name = "Mode")
    protected ColorSpaceEnum mode;
    @XmlAttribute(name = "Red")
    protected String red;
    @XmlAttribute(name = "Green")
    protected String green;
    @XmlAttribute(name = "Blue")
    protected String blue;
    @XmlAttribute(name = "WhitePoint")
    protected String whitePoint;

    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    /**
     * Ruft den Wert der mode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColorSpaceEnum }
     *     
     */
    public ColorSpaceEnum getMode() {
        if (mode == null) {
            return ColorSpaceEnum.S_RGB;
        } else {
            return mode;
        }
    }

    /**
     * Legt den Wert der mode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorSpaceEnum }
     *     
     */
    public void setMode(ColorSpaceEnum value) {
        this.mode = value;
    }

    /**
     * Ruft den Wert der red-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRed() {
        return red;
    }

    /**
     * Legt den Wert der red-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRed(String value) {
        this.red = value;
    }

    /**
     * Ruft den Wert der green-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreen() {
        return green;
    }

    /**
     * Legt den Wert der green-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreen(String value) {
        this.green = value;
    }

    /**
     * Ruft den Wert der blue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlue() {
        return blue;
    }

    /**
     * Legt den Wert der blue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlue(String value) {
        this.blue = value;
    }

    /**
     * Ruft den Wert der whitePoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhitePoint() {
        return whitePoint;
    }

    /**
     * Legt den Wert der whitePoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhitePoint(String value) {
        this.whitePoint = value;
    }

}
