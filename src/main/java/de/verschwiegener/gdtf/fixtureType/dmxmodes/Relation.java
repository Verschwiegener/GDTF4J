//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;


/**
 * <p>Java-Klasse für Relation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Relation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Master" use="required" type="{}nodetype" /&gt;
 *       &lt;attribute name="Follower" use="required" type="{}nodetype" /&gt;
 *       &lt;attribute name="Type" use="required" type="{}RelationTypesEnum" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Relation")
public class Relation {

	/**
	 * The unique name of the relation
	 */
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    
    /**
     * Link to the master DMX channel; Starting point: DMX mode
     */
    @XmlAttribute(name = "Master", required = true)
    protected String master;
    
    /**
     * Link to the following channel function; Starting point: DMX mode
     */
    @XmlAttribute(name = "Follower", required = true)
    protected String follower;
    
    /**
     * Type of the relation; Values: “Multiply”, “Override”
     */
    @XmlAttribute(name = "Type", required = true)
    protected RelationTypesEnum type;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der master-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getMaster() {
        return new GDTFNode(master, NodeSearchPoint.DMXChannel);
    }

    /**
     * Legt den Wert der master-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaster(GDTFNode value) {
        this.master = value.toGDTF();
    }

    /**
     * Ruft den Wert der follower-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public GDTFNode getFollower() {
        return new GDTFNode(follower, NodeSearchPoint.DMXChannel);
    }

    /**
     * Legt den Wert der follower-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFollower(GDTFNode value) {
        this.follower = value.toGDTF();
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RelationTypesEnum }
     *     
     */
    public RelationTypesEnum getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationTypesEnum }
     *     
     */
    public void setType(RelationTypesEnum value) {
        this.type = value;
    }

}
