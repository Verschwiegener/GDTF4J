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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für DMXMode complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DMXMode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DMXChannels" type="{}DMXChannels"/&gt;
 *         &lt;element name="Relations" type="{}Relations" minOccurs="0"/&gt;
 *         &lt;element name="FTMacros" type="{}FTMacros" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Geometry" use="required" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMXMode", propOrder = { "dmxChannels", "relations", "ftMacros" })
public class DMXMode {

	/**
	 * Description of all DMX channels used in the mode
	 */
	@XmlElement(name = "DMXChannels", required = true)
	protected DMXChannels dmxChannels;

	/**
	 * Description of relations between channels
	 */
	@XmlElement(name = "Relations")
	protected Relations relations;

	/**
	 * Is used to describe macros of the manufacturer.
	 */
	@XmlElement(name = "FTMacros")
	protected FTMacros ftMacros;

	/**
	 * The unique name of the DMX mode
	 */
	@XmlAttribute(name = "Name", required = true)
	protected String name;

	/**
	 * Description of the DMX mode
	 */
	@XmlAttribute(name = "Description", required = true)
	protected String description;

	/**
	 * Name of the first geometry in the device; Only top level geometries are
	 * allowed to be linked.
	 */
	@XmlAttribute(name = "Geometry", required = true)
	protected String geometry;

	/**
	 * Ruft den Wert der dmxChannels-Eigenschaft ab.
	 * 
	 * @return possible object is {@link DMXChannels }
	 * 
	 */
	public DMXChannels getDMXChannels() {
		return dmxChannels;
	}

	/**
	 * Legt den Wert der dmxChannels-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link DMXChannels }
	 * 
	 */
	public void setDMXChannels(DMXChannels value) {
		this.dmxChannels = value;
	}

	/**
	 * Ruft den Wert der relations-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Relations }
	 * 
	 */
	public Relations getRelations() {
		return relations;
	}

	/**
	 * Legt den Wert der relations-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link Relations }
	 * 
	 */
	public void setRelations(Relations value) {
		this.relations = value;
	}

	/**
	 * Ruft den Wert der ftMacros-Eigenschaft ab.
	 * 
	 * @return possible object is {@link FTMacros }
	 * 
	 */
	public FTMacros getFTMacros() {
		return ftMacros;
	}

	/**
	 * Legt den Wert der ftMacros-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link FTMacros }
	 * 
	 */
	public void setFTMacros(FTMacros value) {
		this.ftMacros = value;
	}

	/**
	 * Ruft den Wert der name-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Legt den Wert der name-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Ruft den Wert der geometry-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGeometry() {
		return geometry;
	}

	/**
	 * Legt den Wert der geometry-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGeometry(String value) {
		this.geometry = value;
	}

}
