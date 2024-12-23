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

import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeSearchPoint;

/**
 * <p>
 * Java-Klasse für MacroDMXValue complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MacroDMXValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Value" use="required" type="{}dmxtype" /&gt;
 *       &lt;attribute name="DMXChannel" use="required" type="{}nodetype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MacroDMXValue")
public class MacroDMXValue {

	/**
	 * Value of the DMX channel
	 */
	@XmlAttribute(name = "Value", required = true)
	protected String value;

	/**
	 * Link to a DMX channel. Starting node DMX Channel collect
	 */
	@XmlAttribute(name = "DMXChannel", required = true)
	protected String dmxChannel;

	/**
	 * Ruft den Wert der value-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFDMXValue getValue() {
		return new GDTFDMXValue(value);
	}

	/**
	 * Legt den Wert der value-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setValue(GDTFDMXValue value) {
		this.value = value.toGDTF();
	}

	/**
	 * Ruft den Wert der dmxChannel-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getDMXChannel() {
		return new GDTFNode(dmxChannel, NodeSearchPoint.DMXChannel);
	}

	/**
	 * Legt den Wert der dmxChannel-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDMXChannel(GDTFNode value) {
		this.dmxChannel = value.toGDTF();
	}

}
