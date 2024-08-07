//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.wheel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFColor;

/**
 * <p>
 * Java-Klasse für Facet complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Facet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Rotation" use="required" type="{}rotationtype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Facet")
public class Facet {

	/**
	 * Color of prism facet, Default value: {0.3127, 0.3290, 100.0 } (white)
	 */
	@XmlAttribute(name = "Color")
	protected String color;
	
	/**
	 * Specify the rotation, translation and scaling for the facet.
	 */
	@XmlAttribute(name = "Rotation", required = true)
	protected String rotation;

	/**
	 * Ruft den Wert der color-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFColor getColor() {
		if(color == null)
			return new GDTFColor();
		return GDTFColor.fromGDTF(color);
	}

	/**
	 * Legt den Wert der color-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setColor(GDTFColor color) {
		this.color = color.toGDTF();
	}

	/**
	 * Ruft den Wert der rotation-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRotation() {
		return rotation;
	}

	/**
	 * Legt den Wert der rotation-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRotation(String value) {
		this.rotation = value;
	}

}
