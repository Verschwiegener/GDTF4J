//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.ValueHelper;
import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;

/**
 * <p>
 * Java-Klasse für LogicalChannel complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LogicalChannel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ChannelFunction" type="{}ChannelFunction"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Attribute" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Snap" type="{}SnapEnum" default="No" /&gt;
 *       &lt;attribute name="Master" type="{}MasterEnum" default="None" /&gt;
 *       &lt;attribute name="MibFade" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="DMXChangeTimeLimit" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalChannel", propOrder = { "channelFunction" })
public class LogicalChannel {

	@XmlElement(name = "ChannelFunction")
	protected List<ChannelFunction> channelFunction;
	@XmlAttribute(name = "Attribute", required = true)
	protected String attribute;
	/**
	 * If snap is enabled, the logical channel will not fade between values.
	 * Instead, it will jump directly to the new value.; Value: “Yes”, “No”, “On”,
	 * “Off”. Default value: “No”
	 */
	@XmlAttribute(name = "Snap")
	protected SnapEnum snap;
	/**
	 * Defines if all the subordinate channel functions react to a Group Control
	 * defined by the control system. Values: “None”, “Grand”, “Group”; Default
	 * value: “None”.
	 */
	@XmlAttribute(name = "Master")
	protected MasterEnum master;

	/**
	 * Minimum fade time for moves in black action. MibFade is defined for the
	 * complete DMX range. Default value: 0; Unit: second
	 */
	@XmlAttribute(name = "MibFade")
	protected Float mibFade;
	/**
	 * Minimum fade time for the subordinate channel functions to change DMX values
	 * by the control system. DMXChangeTimeLimit is defined for the complete DMX
	 * range. Default value: 0; Unit: second
	 */
	@XmlAttribute(name = "DMXChangeTimeLimit")
	protected Float dmxChangeTimeLimit;
	
	
	/**
	 * Returns ChannelFunction by GDTFNode
	 * 
	 * @param node
	 * @return
	 */
	public ChannelFunction getChannelFunction(GDTFNode node) {
		if(!node.checkPoint(NodeStartingPoint.DMXChannel))
			return null;
		return getChannelFunction().stream()
				.filter(cf -> cf.getAttribute().getNodePath()[0]
						.equals(node.getNodePath()[2]) && cf.getName().equals(node.getNodePath()[3]))
				.findFirst().orElse(null);
	}
	
	
	
	public GDTFDMXValue[] getDMXRange(GDTFNode node) {
		ChannelFunction function = getChannelFunction(node);
		
		if(function == null)
			throw new RuntimeException("Invalid GDTF Node path: " + Arrays.toString(node.getNodePath()));

		GDTFDMXValue minValue = function.getDMXFrom();
		GDTFDMXValue maxValue = null;

		// Is last ChannelFunction
		int index = getChannelFunction().indexOf(function);
		if (index == getChannelFunction().size() - 1) {
			// Get Max DMX Value
			maxValue = switch (minValue.getChannelCount()) {
			case 1 -> new GDTFDMXValue(new int[] { 255 });
			case 2 -> new GDTFDMXValue(new int[] { 255, 255 });
			default -> new GDTFDMXValue(new int[] { 255 });
			};

		} else {
			// Get Max Value from Next ChannelFunction and Offset by -1
			maxValue = getChannelFunction().get(index + 1).getDMXFrom();
			maxValue.offsetDMX(-1);
		}
		return new GDTFDMXValue[] { minValue, maxValue };
	}

	/**
	 * Gets the value of the channelFunction property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the channelFunction property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChannelFunction().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ChannelFunction }
	 * 
	 * 
	 */
	public List<ChannelFunction> getChannelFunction() {
		if (channelFunction == null) {
			channelFunction = new ArrayList<ChannelFunction>();
		}
		return this.channelFunction;
	}

	/**
	 * Ruft den Wert der attribute-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getAttribute() {
		return new GDTFNode(attribute, NodeStartingPoint.Attribute);
	}

	/**
	 * Legt den Wert der attribute-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAttribute(GDTFNode value) {
		this.attribute = value.toGDTF();
	}

	/**
	 * Ruft den Wert der snap-Eigenschaft ab.
	 * 
	 * @return possible object is {@link SnapEnum }
	 * 
	 */
	public SnapEnum getSnap() {
		if (snap == null) {
			return SnapEnum.NO;
		} else {
			return snap;
		}
	}

	/**
	 * Legt den Wert der snap-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link SnapEnum }
	 * 
	 */
	public void setSnap(SnapEnum value) {
		this.snap = value;
	}

	/**
	 * Ruft den Wert der master-Eigenschaft ab.
	 * 
	 * @return possible object is {@link MasterEnum }
	 * 
	 */
	public MasterEnum getMaster() {
		if (master == null) {
			return MasterEnum.NONE;
		} else {
			return master;
		}
	}

	/**
	 * Legt den Wert der master-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link MasterEnum }
	 * 
	 */
	public void setMaster(MasterEnum value) {
		this.master = value;
	}

	/**
	 * Ruft den Wert der mibFade-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Float }
	 * 
	 */
	public Float getMibFade() {
		if (mibFade == null)
			return 0f;
		return mibFade;
	}

	/**
	 * Legt den Wert der mibFade-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link Float }
	 * 
	 */
	public void setMibFade(Float value) {
		this.mibFade = value;
	}

	/**
	 * Ruft den Wert der dmxChangeTimeLimit-Eigenschaft ab.
	 * 
	 * @return possible object is {@link Float }
	 * 
	 */
	public Float getDMXChangeTimeLimit() {
		if (dmxChangeTimeLimit == null)
			return 0f;
		return dmxChangeTimeLimit;
	}

	/**
	 * Legt den Wert der dmxChangeTimeLimit-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link Float }
	 * 
	 */
	public void setDMXChangeTimeLimit(Float value) {
		this.dmxChangeTimeLimit = value;
	}

}
