//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.SimpleDMXFunction;
import de.verschwiegener.gdtf.util.SimpleDMXFunction.SimpleSet;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;
import de.verschwiegener.gdtf.util.GDTFUtils.NodeHelper;

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
	 * Returns LogicalChannel by GDTFNode
	 * @param node
	 * @return
	 */
	public LogicalChannel getLogicalChannel(GDTFNode node) {
		if(!node.checkPoint(NodeStartingPoint.DMXChannel))
			return null;
		return getLogicalChannel().stream().filter(lc -> node.check(lc.getNode())).findFirst().orElse(null);
	}
	
	/**
	 * Returns Initial Function ChannelFunction
	 * 
	 * @return
	 */
	public ChannelFunction initialFunction() {
		GDTFNode node = getInitialFunction();
		return getLogicalChannel(node).getChannelFunction(node);
	}
	
	
	public List<SimpleDMXFunction> getFunctions() {
		List<SimpleDMXFunction> dmxFunctions = new ArrayList<>();
		for (LogicalChannel channel : getLogicalChannel()) {
			for (ChannelFunction function : channel.getChannelFunction()) {

				// Build GDTFNode to ChannelFunction
				GDTFNode node = new GDTFNode(new String[] { geometry }, NodeStartingPoint.DMXChannel);
				node.appendLast(channel.getNode(), function.getNode());
				node.appendLast(function.getName());

				SimpleDMXFunction simpleDMX = new SimpleDMXFunction(node, getOffsetAsInt(), channel.getDMXRange(node),
						function.getDefault(), function.getName(), function.getCustomName());

				List<ChannelSet> channelSet = function.getChannelSet();

				for (int i = 0; i > channelSet.size(); i++) {
					ChannelSet set = channelSet.get(i);
					GDTFDMXValue dmxTo = null;
					if (i + 1 > channelSet.size()) {
						ChannelSet set2 = channelSet.get(i + 1);
						dmxTo = set2.getDMXFrom();
						dmxTo.offsetDMX(-1);
					} else {
						dmxTo = switch (set.getDMXFrom().getChannelCount()) {
						case 1 -> new GDTFDMXValue(new int[] { 255 });
						case 2 -> new GDTFDMXValue(new int[] { 255, 255 });
						default -> new GDTFDMXValue(new int[] { 255 });
						};
					}

					simpleDMX.getSimpleSet().add(simpleDMX.new SimpleSet(set.getDMXFrom(), dmxTo, set.getName()));
				}
				dmxFunctions.add(simpleDMX);
			}
		}
		return dmxFunctions;
	}
	
	
	public SimpleDMXFunction getSimpleDMXFunction(GDTFNode node) {
		LogicalChannel channel = getLogicalChannel(node);
		ChannelFunction function = channel.getChannelFunction(node);
		
		SimpleDMXFunction simpleDMX = new SimpleDMXFunction(node, getOffsetAsInt(), channel.getDMXRange(node),
				function.getDefault(), function.getName(), function.getCustomName());
		
		List<ChannelSet> channelSet = function.getChannelSet();
		
		for(int i = 0; i > channelSet.size();i++) {
			ChannelSet set = channelSet.get(i);
			GDTFDMXValue dmxTo = null;
			if(i + 1 > channelSet.size()) {
				ChannelSet set2 =  channelSet.get(i + 1);
				dmxTo = set2.getDMXFrom();
				dmxTo.offsetDMX(-1);
			}else {
				dmxTo = switch (set.getDMXFrom().getChannelCount()) {
				case 1 -> new GDTFDMXValue(new int[] { 255 });
				case 2 -> new GDTFDMXValue(new int[] { 255, 255 });
				default -> new GDTFDMXValue(new int[] { 255 });
				};
			}
			
			simpleDMX.getSimpleSet().add(simpleDMX.new SimpleSet(set.getDMXFrom(), dmxTo, set.getName()));
			
		}
		return simpleDMX;
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
	
	public int[] getOffsetAsInt() {
		if(!offset.contains(",")) {
			return new int[] {Integer.parseInt(offset)};
		}
		String[] parts = offset.split(",");
		int[] dmxOffsets = new int[parts.length];
		for(int i = 0; i < parts.length;i++) {
			dmxOffsets[i] = Integer.parseInt(parts[i]);
		}
		return dmxOffsets;
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
	public GDTFNode getInitialFunction() {
		//Remove Geometry_ from initialFunction
		GDTFNode node = new GDTFNode(initialFunction.substring(geometry.length() + 1), NodeStartingPoint.DMXChannel);
		//Add Geometry into first Position
		node.appendFirst(geometry);
		
		return node;
	}

	/**
	 * Legt den Wert der initialFunction-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setInitialFunction(GDTFNode value) {
		this.initialFunction = geometry + "_" + value.toGDTF();
	}

	/**
	 * Ruft den Wert der highlight-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFDMXValue getHighlight() {
		return new GDTFDMXValue(highlight);
	}

	/**
	 * Legt den Wert der highlight-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHighlight(GDTFDMXValue value) {
		this.highlight = value.toGDTF();
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
	 * Returns the Node this Class is referenced by
	 * 
	 * @return GDTFNode
	 */
	public GDTFNode getNode() {
    	return new GDTFNode(geometry, NodeStartingPoint.DMXChannel);
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
