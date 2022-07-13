package de.verschwiegener.gdtf4j;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public abstract class GDTFClass {
	
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		return null;
	}
	
	public Node toXMl(Document document) {
		return null;
	}

}
