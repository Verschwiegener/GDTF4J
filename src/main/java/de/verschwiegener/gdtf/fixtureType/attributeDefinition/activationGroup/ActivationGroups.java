//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.attributeDefinition.activationGroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


/**
 * <p>Java-Klasse für ActivationGroups complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ActivationGroups"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActivationGroup" type="{}ActivationGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivationGroups", propOrder = {
    "activationGroup"
})
public class ActivationGroups {

    @XmlElement(name = "ActivationGroup")
    protected List<ActivationGroup> activationGroup;

    /**
     * Gets the value of the activationGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activationGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivationGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivationGroup }
     * 
     * 
     */
    public List<ActivationGroup> getActivationGroup() {
        if (activationGroup == null) {
            activationGroup = new ArrayList<ActivationGroup>();
        }
        return this.activationGroup;
    }
    
    /**
     * Returns the Name of all Activation Groups as String Array
     */
    public String[] getActivationGroupNames() {
    	String[] names = new String[activationGroup.size()];
    	for(int i = 0; i < activationGroup.size();i++) {
    		names[i] = activationGroup.get(i).getName();
    	}
    	return names;
    }
    
    public ActivationGroup getActivationGroup(GDTFNode node) {
    	if(!node.checkPoint(NodeSearchPoint.ActivationGroup))
			return null;
    	
    	return getActivationGroup().stream().filter(ag -> node.check(ag.getNode())).findFirst().orElse(null);
    }
 
}
