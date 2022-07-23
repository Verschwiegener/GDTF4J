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
 * <p>Java-Klasse für CRIGroup complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CRIGroup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="99"&gt;
 *         &lt;element name="CRI" type="{}CRI"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ColorTemperature" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRIGroup", propOrder = {
    "cri"
})
public class CRIGroup {

    @XmlElement(name = "CRI", required = true)
    protected List<CRI> cri;
    @XmlAttribute(name = "ColorTemperature")
    protected Float colorTemperature;

    /**
     * Gets the value of the cri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCRI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CRI }
     * 
     * 
     */
    public List<CRI> getCRI() {
        if (cri == null) {
            cri = new ArrayList<CRI>();
        }
        return this.cri;
    }

    /**
     * Ruft den Wert der colorTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getColorTemperature() {
        return colorTemperature;
    }

    /**
     * Legt den Wert der colorTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setColorTemperature(Float value) {
        this.colorTemperature = value;
    }

}
