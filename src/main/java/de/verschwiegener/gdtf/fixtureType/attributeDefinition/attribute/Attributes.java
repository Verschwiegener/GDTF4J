//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;

/**
 * <p>
 * Java-Klasse für Attributes complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Attributes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Attribute" type="{}Attribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attributes", propOrder = { "attribute" })
public class Attributes {

	@XmlElement(name = "Attribute")
	protected List<Attribute> attribute;

	/**
	 * Gets the value of the attribute property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the attribute property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAttribute().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Attribute }
	 * 
	 * 
	 */
	public List<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new ArrayList<Attribute>();
		}
		return this.attribute;
	}

	/**
	 * Returns all Attributes of a given ActivationGroup
	 * 
	 * @param activationGroup String
	 */
	public ArrayList<Attribute> getAttributeByFeatureGroup(String activationGroup) {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();

		getAttribute().forEach(attribute -> {
			if (attribute.activationGroup.equals(activationGroup))
				attributes.add(attribute);
		});
		return attributes;
	}

	/**
	 * Returns Attribute with given Name, or null if nothing was found
	 * 
	 * @param name String of the Attribute
	 */
	public Attribute getAttributeByName(String name) {
		return getAttribute().stream().filter(attribute -> attribute.getName().equals(name)).findFirst().orElse(null);
	}
	
	public Attribute getAttribute(GDTFNode node) {
		if(!node.checkPoint(NodeStartingPoint.Attribute))
			return null;
		return getAttribute().stream().filter(attribute -> attribute.getName().equals(node.getNodePath()[0])).findFirst().orElse(null);
	}
	

}
