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
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


/**
 * <p>Java-Klasse für Emitters complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Emitters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="Emitter" type="{}Emitter"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Emitters", propOrder = {
    "emitter"
})
public class Emitters {

    @XmlElement(name = "Emitter")
    protected List<Emitter> emitter;

    /**
     * Gets the value of the emitter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emitter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmitter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Emitter }
     * 
     * 
     */
    public List<Emitter> getEmitter() {
        if (emitter == null) {
            emitter = new ArrayList<Emitter>();
        }
        return this.emitter;
    }
    
    public Emitter getEmitter(GDTFNode node) {
    	if(node.getSearchPoint() != NodeSearchPoint.Emitter) 
    		return null;
    	return getEmitter().stream().filter(e -> e.getName().equals(node.getNodePath()[0])).findFirst().orElse(null);
    }

}
