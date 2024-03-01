//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.protocols;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.fixtureType.protocols.rdm.SoftwareVersionID;


/**
 * <p>Java-Klasse für FTRDM complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FTRDM"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="SoftwareVersionID" type="{}SoftwareVersionID"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ManufacturerID" type="{}hextype" /&gt;
 *       &lt;attribute name="DeviceModelID" type="{}hextype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FTRDM", propOrder = {
    "softwareVersionID"
})
public class FTRDM {

    @XmlElement(name = "SoftwareVersionID")
    protected List<SoftwareVersionID> softwareVersionID;
    @XmlAttribute(name = "ManufacturerID")
    protected String manufacturerID;
    @XmlAttribute(name = "DeviceModelID")
    protected String deviceModelID;

    /**
     * Gets the value of the softwareVersionID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the softwareVersionID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSoftwareVersionID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoftwareVersionID }
     * 
     * 
     */
    public List<SoftwareVersionID> getSoftwareVersionID() {
        if (softwareVersionID == null) {
            softwareVersionID = new ArrayList<SoftwareVersionID>();
        }
        return this.softwareVersionID;
    }

    /**
     * Ruft den Wert der manufacturerID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturerID() {
        return manufacturerID;
    }

    /**
     * Legt den Wert der manufacturerID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturerID(String value) {
        this.manufacturerID = value;
    }

    /**
     * Ruft den Wert der deviceModelID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelID() {
        return deviceModelID;
    }

    /**
     * Legt den Wert der deviceModelID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelID(String value) {
        this.deviceModelID = value;
    }

}
