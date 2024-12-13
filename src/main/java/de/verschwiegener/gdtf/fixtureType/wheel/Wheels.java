//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.wheel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;


/**
 * <p>Java-Klasse für Wheels complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Wheels"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="Wheel" type="{}Wheel"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Wheels", propOrder = {
    "wheel"
})
public class Wheels {

    @XmlElement(name = "Wheel")
    protected List<Wheel> wheel;

    /**
     * Gets the value of the wheel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wheel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWheel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Wheel }
     * 
     * 
     */
    public List<Wheel> getWheel() {
        if (wheel == null) {
            wheel = new ArrayList<Wheel>();
        }
        return this.wheel;
    }
    
    /**
     * Returns the first Wheel with the given name, or null if nothing was found
     * @param name String to search for
     */
    public Wheel getWheelByName(String name) {
    	return getWheel().stream().filter(wheel -> wheel.getName().equals(name)).findFirst().orElse(null);
    }
    
    public Wheel getWheel(GDTFNode node) {
    	if(!node.checkPoint(NodeStartingPoint.Wheel))
			return null;
    	return getWheel().stream().filter(w -> node.check(w.getNode())).findFirst().orElse(null);
    }

}
