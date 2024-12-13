//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


/**
 * <p>Java-Klasse für Model complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Model"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Length" type="{http://www.w3.org/2001/XMLSchema}float" default="0" /&gt;
 *       &lt;attribute name="Width" type="{http://www.w3.org/2001/XMLSchema}float" default="0" /&gt;
 *       &lt;attribute name="Height" type="{http://www.w3.org/2001/XMLSchema}float" default="0" /&gt;
 *       &lt;attribute name="PrimitiveType" type="{}PrimitiveTypeEnum" default="Undefined" /&gt;
 *       &lt;attribute name="File" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Model")
public class Model {

    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Length")
    protected Float length;
    @XmlAttribute(name = "Width")
    protected Float width;
    @XmlAttribute(name = "Height")
    protected Float height;
    @XmlAttribute(name = "PrimitiveType")
    protected PrimitiveTypeEnum primitiveType;
    @XmlAttribute(name = "File")
    protected String file;
    @XmlAttribute(name = "SVGOffsetX")
    protected Float svgOffsetX;
    @XmlAttribute(name = "SVGOffsetY")
    protected Float svgOffsetY;
    @XmlAttribute(name = "SVGSideOffsetX")
    protected Float svgSideOffsetX;
    @XmlAttribute(name = "SVGSideOffsetY")
    protected Float svgSideOffsetY;
    @XmlAttribute(name = "SVGFrontOffsetX")
    protected Float svgFrontOffsetX;
    @XmlAttribute(name = "SVGFrontOffsetY")
    protected Float svgFrontOffsetY;

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
	 * Returns the Node this Class is referenced by
	 * 
	 * @return GDTFNode
	 */
    public GDTFNode getNode() {
    	return new GDTFNode(name, NodeSearchPoint.Model);
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
     * Ruft den Wert der length-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getLength() {
        if (length == null) {
            return  0.0F;
        } else {
            return length;
        }
    }

    /**
     * Legt den Wert der length-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLength(Float value) {
        this.length = value;
    }

    /**
     * Ruft den Wert der width-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getWidth() {
        if (width == null) {
            return  0.0F;
        } else {
            return width;
        }
    }

    /**
     * Legt den Wert der width-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWidth(Float value) {
        this.width = value;
    }

    /**
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getHeight() {
        if (height == null) {
            return  0.0F;
        } else {
            return height;
        }
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setHeight(Float value) {
        this.height = value;
    }

    /**
     * Ruft den Wert der primitiveType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrimitiveTypeEnum }
     *     
     */
    public PrimitiveTypeEnum getPrimitiveType() {
        if (primitiveType == null) {
            return PrimitiveTypeEnum.UNDEFINED;
        } else {
            return primitiveType;
        }
    }

    /**
     * Legt den Wert der primitiveType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimitiveTypeEnum }
     *     
     */
    public void setPrimitiveType(PrimitiveTypeEnum value) {
        this.primitiveType = value;
    }

    /**
     * Ruft den Wert der file-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFile() {
        if (file == null) {
            return "";
        } else {
            return file;
        }
    }

    /**
     * Legt den Wert der file-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFile(String value) {
        this.file = value;
    }

    /**
     * Ruft den Wert der svgOffsetX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGOffsetX() {
        if (svgOffsetX == null) {
            return  0.0F;
        } else {
            return svgOffsetX;
        }
    }

    /**
     * Legt den Wert der svgOffsetX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGOffsetX(Float value) {
        this.svgOffsetX = value;
    }

    /**
     * Ruft den Wert der svgOffsetY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGOffsetY() {
        if (svgOffsetY == null) {
            return  0.0F;
        } else {
            return svgOffsetY;
        }
    }

    /**
     * Legt den Wert der svgOffsetY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGOffsetY(Float value) {
        this.svgOffsetY = value;
    }

    /**
     * Ruft den Wert der svgSideOffsetX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGSideOffsetX() {
        if (svgSideOffsetX == null) {
            return  0.0F;
        } else {
            return svgSideOffsetX;
        }
    }

    /**
     * Legt den Wert der svgSideOffsetX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGSideOffsetX(Float value) {
        this.svgSideOffsetX = value;
    }

    /**
     * Ruft den Wert der svgSideOffsetY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGSideOffsetY() {
        if (svgSideOffsetY == null) {
            return  0.0F;
        } else {
            return svgSideOffsetY;
        }
    }

    /**
     * Legt den Wert der svgSideOffsetY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGSideOffsetY(Float value) {
        this.svgSideOffsetY = value;
    }

    /**
     * Ruft den Wert der svgFrontOffsetX-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGFrontOffsetX() {
        if (svgFrontOffsetX == null) {
            return  0.0F;
        } else {
            return svgFrontOffsetX;
        }
    }

    /**
     * Legt den Wert der svgFrontOffsetX-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGFrontOffsetX(Float value) {
        this.svgFrontOffsetX = value;
    }

    /**
     * Ruft den Wert der svgFrontOffsetY-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSVGFrontOffsetY() {
        if (svgFrontOffsetY == null) {
            return  0.0F;
        } else {
            return svgFrontOffsetY;
        }
    }

    /**
     * Legt den Wert der svgFrontOffsetY-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSVGFrontOffsetY(Float value) {
        this.svgFrontOffsetY = value;
    }

}
