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
    "operatingTemperatureOrWeightOrPowerConsumption"
})
public class Properties {

    @XmlElements({
        @XmlElement(name = "OperatingTemperature", type = OperatingTemperature.class),
        @XmlElement(name = "Weight", type = Weight.class),
        @XmlElement(name = "PowerConsumption", type = PowerConsumption.class),
        @XmlElement(name = "LegHeight", type = LegHeight.class)
    })
    protected List<Object> operatingTemperatureOrWeightOrPowerConsumption;

    /**
     * Gets the value of the operatingTemperatureOrWeightOrPowerConsumption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operatingTemperatureOrWeightOrPowerConsumption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperatingTemperatureOrWeightOrPowerConsumption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperatingTemperature }
     * {@link Weight }
     * {@link PowerConsumption }
     * {@link LegHeight }
     * 
     * 
     */
    public List<Object> getOperatingTemperatureOrWeightOrPowerConsumption() {
        if (operatingTemperatureOrWeightOrPowerConsumption == null) {
            operatingTemperatureOrWeightOrPowerConsumption = new ArrayList<Object>();
        }
        return this.operatingTemperatureOrWeightOrPowerConsumption;
    }

}
