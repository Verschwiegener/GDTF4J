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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CRI complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRI"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="CES" type="{}CESEnum" default="CES01" /&gt;
 *       &lt;attribute name="ColorRenderingIndex" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRI")
public class CRI {

    @XmlAttribute(name = "CES")
    protected CESEnum ces;
    @XmlAttribute(name = "ColorRenderingIndex")
    @XmlSchemaType(name = "unsignedByte")
    protected Short colorRenderingIndex;

    /**
     * Ruft den Wert der ces-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CESEnum }
     *     
     */
    public CESEnum getCES() {
        if (ces == null) {
            return CESEnum.CES_01;
        } else {
            return ces;
        }
    }

    /**
     * Legt den Wert der ces-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CESEnum }
     *     
     */
    public void setCES(CESEnum value) {
        this.ces = value;
    }

    /**
     * Ruft den Wert der colorRenderingIndex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getColorRenderingIndex() {
        return colorRenderingIndex;
    }

    /**
     * Legt den Wert der colorRenderingIndex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setColorRenderingIndex(Short value) {
        this.colorRenderingIndex = value;
    }

}
