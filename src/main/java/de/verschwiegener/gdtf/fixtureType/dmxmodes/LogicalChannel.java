//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.ValueHelper;

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
	 * Returns the DMX Range the Given ChannelFunction occupies
	 * 
	 * @param function ChannelFunction to get DMX Range from
	 * @return String[] containing the Start and End DMX Value in GDTF Format
	 */
	public String[] getDMXRangeFromChannelFunction(ChannelFunction function) {
		int indexFunction = getChannelFunction().indexOf(function);
		return new String[] { function.getDMXFrom(),
				ValueHelper.offsetDMXValue(getChannelFunction().get(indexFunction + 1).getDMXFrom(), -1) };
	}

	/**
	 * Used to get first ChannelFunction with given Attribute, null if nothing was
	 * found
	 * 
	 * @param attribute String to search for
	 * @return ChannelFunction matching given Attribute
	 */
	public ChannelFunction getChannelFunctionByAttribute(String attribute) {
		return getChannelFunction().stream().filter(function -> function.getAttribute().equals(attribute)).findFirst()
				.orElse(null);
	}

	/**
	 * Used to get first ChannelFunction with given Name, null if nothing was found
	 * 
	 * @param name String to search for
	 * @return ChannelFunction matching given Name
	 */
	public ChannelFunction getChannelFunctionByName(String name) {
		return getChannelFunction().stream().filter(function -> function.getName().equals(name)).findFirst()
				.orElse(null);
	}

	/**
	 * Used to get first ChannelFunction with given Attribute and Name, null if
	 * nothing was found
	 * 
	 * @param attribute String to search for * @param name String to search for
	 * @return ChannelFunction matching given Attribute and Name
	 */
	public ChannelFunction getChannelFunctionByAttributeAndName(String attribute, String name) {
		return getChannelFunction().stream()
				.filter(function -> function.getAttribute().equals(attribute) && function.getName().equals(name))
				.findFirst().orElse(null);
	}

	/**
	 * Returns all ChannelFunction Names of its Parents
	 * 
	 * @return ArrayList<String> containing Channel Function Names
	 */
	public ArrayList<String> getAllChannelFunctionNames() {
		ArrayList<String> channelFunctionNames = new ArrayList<String>();
		getChannelFunction().forEach(function -> {
			channelFunctionNames.add(function.getName());
		});
		return channelFunctionNames;
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
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Legt den Wert der attribute-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAttribute(String value) {
		this.attribute = value;
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
