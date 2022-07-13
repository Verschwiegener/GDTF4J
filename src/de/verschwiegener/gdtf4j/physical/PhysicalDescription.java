package de.verschwiegener.gdtf4j.physical;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.util.GDTFUtil;


import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

public class PhysicalDescription {

	private ColorSpace colorSpace;
	public ArrayList<Connector> connectors = new ArrayList<Connector>();
	public ArrayList<Emitter> emitters = new ArrayList<Emitter>();
	public ArrayList<Filter> filters = new ArrayList<Filter>();
	private Properties properties;
	
	public PhysicalDescription(Node node, GDTF gdtf) {
		Element e = (Element) node;
		colorSpace = new ColorSpace(e.getElementsByTagName("ColorSpace").item(0));
		properties = new Properties(e.getElementsByTagName("Properties").item(0), gdtf);
		
		addChildrenToArrayList(Connector.class, connectors, node, "Connectors", gdtf);
		addChildrenToArrayList(Emitter.class, emitters, node, "Emitters", gdtf);
		addChildrenToArrayList(Filter.class, filters, node, "Filters", gdtf);
		
		
		/*NodeList list = ((Element)node).getElementsByTagName("Connectors");
		for (int i = 0; i < list.getLength(); i++) {
			connectors.add(new Connector(list.item(i)));
		}
		NodeList list2 = ((Element)node).getElementsByTagName("Emitters");
		for (int i = 0; i < list2.getLength(); i++) {
			emitters.add(new Emitter(list2.item(i)));
		}
		NodeList list3 = ((Element)node).getElementsByTagName("Filters");
		for (int i = 0; i < list3.getLength(); i++) {
			filters.add(new Filter(list3.item(i)));
		}*/
	}

	
	public Connector getConnectorByName(String name) {
		return connectors.stream().filter(conector -> conector.getName().equals(name)).findFirst().orElse(null);
	}
	
}
