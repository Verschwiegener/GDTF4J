//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Properties complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Properties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="OperatingTemperature" type="{}OperatingTemperature"/&gt;
 *         &lt;element name="Weight" type="{}Weight"/&gt;
 *         &lt;element name="PowerConsumption" type="{}PowerConsumption"/&gt;
 *         &lt;element name="LegHeight" type="{}LegHeight"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Properties", propOrder = {
    "operatingTemperature",
    "weight",
    "legHeight",
    "powerConsumption"
})
public class Properties {

    @XmlElement(name = "OperatingTemperature")
    protected OperatingTemperature operatingTemperature;
    @XmlElement(name = "Weight")
    protected Weight weight;
    @XmlElement(name = "LegHeight")
    protected LegHeight legHeight;
    @XmlElement(name = "PowerConsumption")
    protected List<PowerConsumption> powerConsumption;

    /**
     * Ruft den Wert der operatingTemperature-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OperatingTemperature }
     *     
     */
    public OperatingTemperature getOperatingTemperature() {
        return operatingTemperature;
    }

    /**
     * Legt den Wert der operatingTemperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingTemperature }
     *     
     */
    public void setOperatingTemperature(OperatingTemperature value) {
        this.operatingTemperature = value;
    }

    /**
     * Ruft den Wert der weight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Weight }
     *     
     */
    public Weight getWeight() {
        return weight;
    }

    /**
     * Legt den Wert der weight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Weight }
     *     
     */
    public void setWeight(Weight value) {
        this.weight = value;
    }

    /**
     * Ruft den Wert der legHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LegHeight }
     *     
     */
    public LegHeight getLegHeight() {
        return legHeight;
    }

    /**
     * Legt den Wert der legHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LegHeight }
     *     
     */
    public void setLegHeight(LegHeight value) {
        this.legHeight = value;
    }

    /**
     * Gets the value of the powerConsumption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the powerConsumption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPowerConsumption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PowerConsumption }
     * 
     * 
     */
    public List<PowerConsumption> getPowerConsumption() {
        if (powerConsumption == null) {
            powerConsumption = new ArrayList<PowerConsumption>();
        }
        return this.powerConsumption;
    }

}
