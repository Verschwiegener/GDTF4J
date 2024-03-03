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

import de.verschwiegener.gdtf.ValueHelper.NodeHelper;

/**
 * <p>
 * Java-Klasse für DMXChannel complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DMXChannel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="LogicalChannel" type="{}LogicalChannel"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DMXBreak" type="{}dmxbreaktype" default="1" /&gt;
 *       &lt;attribute name="Offset" type="{}offsettype" default="None" /&gt;
 *       &lt;attribute name="InitialFunction" type="{}nodetype" /&gt;
 *       &lt;attribute name="Highlight" type="{}dmxtype" default="None" /&gt;
 *       &lt;attribute name="Geometry" use="required" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMXChannel", propOrder = { "logicalChannel" })
public class DMXChannel {

	@XmlElement(name = "LogicalChannel")
	protected List<LogicalChannel> logicalChannel;

	/**
	 * Number of the DMXBreak; Default value: 1; Special value: “Overwrite” – means
	 * that this number will be overwritten by Geometry Reference; Size: 4 bytes
	 */
	@XmlAttribute(name = "DMXBreak")
	protected String dmxBreak;

	/**
	 * Relative addresses of the current DMX channel from highest to least
	 * significant; Separator of values is ","; Special value: “None” – does not
	 * have any addresses; Default value: “None”; Size per int: 4 bytes
	 */
	@XmlAttribute(name = "Offset")
	protected String offset;

	/**
	 * Link to the channel function that will be activated by default for this
	 * DMXChannel. Default value is the first channel function of the first logical
	 * function of this DMX channel.
	 */
	@XmlAttribute(name = "InitialFunction")
	protected String initialFunction;

	/**
	 * Highlight value for current channel; Special value: “None”. Default value:
	 * “None”.
	 */
	@XmlAttribute(name = "Highlight")
	protected String highlight;
	/**
	 * Name of the geometry the current channel controls.
	 */
	@XmlAttribute(name = "Geometry", required = true)
	protected String geometry;

	/**
	 * Used to Split InitialFunction up into usable Node Paths
	 * 
	 * @return String[] Initial Function Node Path
	 */
	public String[] parseInitialFunction() {
		String[] parsedValues;
		String[] splitDot = initialFunction.split(".");

		parsedValues = new String[splitDot.length + 1];

		// Split First Value into its parts
		int indexUnderscore = splitDot[0].indexOf("_");
		parsedValues[0] = splitDot[0].substring(0, indexUnderscore);
		parsedValues[1] = splitDot[0].substring(indexUnderscore);

		// Add Remaining Values
		for (int i = 1; i < splitDot.length; i++) {
			parsedValues[i + 1] = splitDot[i];
		}
		return parsedValues;
	}

	/**
	 * Used to get the ChannelFunction which is specified in InitialFunction
	 * 
	 * @return ChannelFunction InitialFunction
	 */
	public ChannelFunction initialFunction() {
		String[] initialFunctionParts = parseInitialFunction();
		if (initialFunctionParts.length > 3)
			return null;
		return getLogicalChannel(initialFunctionParts[1]).getChannelFunctionByAttributeAndName(initialFunctionParts[2],
				initialFunctionParts[3]);
	}

	/**
	 * Returns First LogicalChannel with given Attribute, null if nothing was found
	 * 
	 * @param attribute String attribute to search for
	 * @return First LogicalChannel with given attribute or null
	 */
	public LogicalChannel getLogicalChannel(String attribute) {
		return getLogicalChannel().stream().filter(channel -> channel.getAttribute().equals(attribute)).findFirst()
				.orElse(null);
	}

	/**
	 * Returns all ChannelFunction Names of its Parents
	 * 
	 * @return ArrayList<String> containing Channel Function Names
	 */
	public ArrayList<String> getAllChannelFunctionNames() {
		ArrayList<String> channelFunctions = new ArrayList<String>();
		getLogicalChannel().forEach(channel -> {
			channelFunctions.addAll(channel.getAllChannelFunctionNames());
		});
		return channelFunctions;
	}

	/**
	 * Returns all usable Nodes of this DMX Channel in Format
	 * LogicalChannel(Attribute).ChannelFunction(Attribute)
	 * 
	 * @return
	 */
	public ArrayList<NodeHelper> getAllUsableNodeIDs() {
		ArrayList<NodeHelper> nodes = new ArrayList<NodeHelper>();
		getLogicalChannel().forEach(lchannel -> {
			lchannel.getAllChannelFunctionAttributes().forEach(attribute -> {
				nodes.add(new NodeHelper(lchannel.getAttribute(), attribute));
			});
		});
		return nodes;
	}
	
	/**
	 * Returns ChannelFunction by Node Path
	 * 
	 * @param helper NodeHelper Node Path
	 */
	public ChannelFunction getChannelFunction(NodeHelper helper) {
		return getLogicalChannel(helper.lcAttribute()).getChannelFunctionByAttribute(helper.cfAttribute());
	}

	/**
	 * Gets the value of the logicalChannel property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the logicalChannel property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLogicalChannel().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link LogicalChannel }
	 * 
	 * 
	 */
	public List<LogicalChannel> getLogicalChannel() {
		if (logicalChannel == null) {
			logicalChannel = new ArrayList<LogicalChannel>();
		}
		return this.logicalChannel;
	}

	/**
	 * Ruft den Wert der dmxBreak-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDMXBreak() {
		if (dmxBreak == null) {
			return "1";
		} else {
			return dmxBreak;
		}
	}

	/**
	 * Legt den Wert der dmxBreak-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDMXBreak(String value) {
		this.dmxBreak = value;
	}

	/**
	 * Ruft den Wert der offset-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOffset() {
		if (offset == null) {
			return "None";
		} else {
			return offset;
		}
	}

	/**
	 * Legt den Wert der offset-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOffset(String value) {
		this.offset = value;
	}

	/**
	 * Ruft den Wert der initialFunction-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInitialFunction() {
		return initialFunction;
	}

	/**
	 * Legt den Wert der initialFunction-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setInitialFunction(String value) {
		this.initialFunction = value;
	}

	/**
	 * Ruft den Wert der highlight-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHighlight() {
		if (highlight == null) {
			return "None";
		} else {
			return highlight;
		}
	}

	/**
	 * Legt den Wert der highlight-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHighlight(String value) {
		this.highlight = value;
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
