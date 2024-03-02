//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.dmxmodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für DMXChannels complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DMXChannels"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="DMXChannel" type="{}DMXChannel"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DMXChannels", propOrder = { "dmxChannel" })
public class DMXChannels {

	@XmlElement(name = "DMXChannel")
	protected List<DMXChannel> dmxChannel;

	/**
	 * Gets the value of the dmxChannel property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the dmxChannel property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDMXChannel().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DMXChannel }
	 * 
	 * 
	 */
	public List<DMXChannel> getDMXChannel() {
		if (dmxChannel == null) {
			dmxChannel = new ArrayList<DMXChannel>();
		}
		return this.dmxChannel;
	}

	/**
	 * Returns all ChannelFunction Names of its Parents
	 * 
	 * @return ArrayList<String> containing Channel Function Names
	 */
	public ArrayList<String> getAllChannelFunctionNames() {
		ArrayList<String> channelFunctions = new ArrayList<String>();
		getDMXChannel().forEach(channel -> {
			channelFunctions.addAll(channel.getAllChannelFunctionNames());
		});
		return channelFunctions;
	}

	/**
	 * Returns all ChannelFunction Names sorted by the Geometry of its DMXChannel
	 * 
	 */
	public HashMap<String, ArrayList<String>> getAllChannelFunctionsNamesByGeometry() {
		HashMap<String, ArrayList<String>> namesbygeo = new HashMap<String, ArrayList<String>>();
		getDMXChannel().forEach(channel -> {
			namesbygeo.putIfAbsent(channel.getGeometry(), new ArrayList<String>());
			namesbygeo.get(channel.getGeometry()).addAll(channel.getAllChannelFunctionNames());
		});
		return namesbygeo;
	}

}
