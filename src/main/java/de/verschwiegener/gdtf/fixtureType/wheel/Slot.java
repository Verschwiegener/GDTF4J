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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFColor;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;

/**
 * <p>
 * Java-Klasse für Slot complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Slot"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element name="Facet" type="{}Facet" maxOccurs="unbounded"/&gt;
 *         &lt;element name="AnimationSystem" type="{}AnimationSystem"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Filter" type="{}nametype" /&gt;
 *       &lt;attribute name="MediaFileName" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Slot", propOrder = { "facet", "animationSystem" })

//TODO New GDTF Attributes
public class Slot {

	@XmlElement(name = "Facet")
	protected List<Facet> facet;
	@XmlElement(name = "AnimationSystem")
	protected AnimationSystem animationSystem;

	/**
	 * The unique name of the wheel slot
	 */
	@XmlAttribute(name = "Name", required = true)
	protected String name;

	/**
	 * Color of the wheel slot, Default value: {0.3127, 0.3290, 100.0 } (white) For
	 * Y give relative value compared to overall output defined in property Luminous
	 * Flux of related Beam Geometry (transmissive case).
	 */
	@XmlAttribute(name = "Color")
	protected String color;

	/**
	 * Optional. Link to filter in the physical description; Do not define color if
	 * filter is used; Starting point: Filter Collect
	 */
	@XmlAttribute(name = "Filter")
	protected String filter;

	/**
	 * Optional. PNG file name without extension containing image for specific gobos
	 * etc. - Maximum resolution of picture: 1024x1024 - Recommended resolution of
	 * gobo: 256x256 - Recommended resolution of animation wheel: 256x256 These
	 * resource files are located in a folder called ./wheels in the zip archive.
	 * Default value: empty.
	 */
	@XmlAttribute(name = "MediaFileName")
	protected String mediaFileName;

	/**
	 * Gets the value of the facet property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the facet property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFacet().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Facet }
	 * 
	 * 
	 */
	public List<Facet> getFacet() {
		if (facet == null) {
			facet = new ArrayList<Facet>();
		}
		return this.facet;
	}

	/**
	 * Ruft den Wert der animationSystem-Eigenschaft ab.
	 * 
	 * @return possible object is {@link AnimationSystem }
	 * 
	 */
	public AnimationSystem getAnimationSystem() {
		return animationSystem;
	}

	/**
	 * Legt den Wert der animationSystem-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link AnimationSystem }
	 * 
	 */
	public void setAnimationSystem(AnimationSystem value) {
		this.animationSystem = value;
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
	 * Ruft den Wert der color-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFColor getColor() {
		if (color == null)
			return new GDTFColor();
		return GDTFColor.fromGDTF(color);
	}

	/**
	 * Legt den Wert der color-Eigenschaft fest.
	 * 
	 * @param color allowed object is {@link String }
	 * 
	 */
	public void setColor(GDTFColor color) {
		this.color = color.toGDTF();
	}

	/**
	 * Ruft den Wert der filter-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getFilter() {
		return new GDTFNode(filter, NodeStartingPoint.Filter);
	}

	/**
	 * Legt den Wert der filter-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFilter(GDTFNode value) {
		this.filter = value.toGDTF();
	}

	/**
	 * Ruft den Wert der mediaFileName-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMediaFileName() {
		if (mediaFileName == null) {
			return "";
		} else {
			return mediaFileName;
		}
	}

	/**
	 * Legt den Wert der mediaFileName-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMediaFileName(String value) {
		this.mediaFileName = value;
	}

}
