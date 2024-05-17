//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.fixtureType.FixtureType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FixtureType" type="{}FixtureType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DataVersion" use="required" type="{}dataversion" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fixtureType"
})
@XmlRootElement(name = "GDTF")
public class GDTFType {

    @XmlElement(name = "FixtureType", required = true)
    protected FixtureType fixtureType;
    @XmlAttribute(name = "DataVersion", required = true)
    protected float dataVersion;

    /**
     * Ruft den Wert der fixtureType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FixtureType }
     *     
     */
    public FixtureType getFixtureType() {
        return fixtureType;
    }

    /**
     * Legt den Wert der fixtureType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FixtureType }
     *     
     */
    public void setFixtureType(FixtureType value) {
        this.fixtureType = value;
    }

    /**
     * Ruft den Wert der dataVersion-Eigenschaft ab.
     * 
     */
    public float getDataVersion() {
        return dataVersion;
    }

    /**
     * Legt den Wert der dataVersion-Eigenschaft fest.
     * 
     */
    public void setDataVersion(float value) {
        this.dataVersion = value;
    }

}
