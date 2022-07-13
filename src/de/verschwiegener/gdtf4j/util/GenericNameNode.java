package de.verschwiegener.gdtf4j.util;

import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;

/**
 * Generic Class, for XML Nodes, which just contain a Name
 * 
 * @author Verschwiegener
 *
 */
public class GenericNameNode extends GDTFClass{
	/**
	 * The unique name of the XML Node
	 */
	private String name;

	public GenericNameNode() {
	}
	/*public GenericNameNode(Node node) {
		if(node != null)
			name = GDTFUtil.getItemNullSave(node.getAttributes(), "Name");
		else name = "";
	}*/
	public GenericNameNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		System.out.println("From2");
		if(node != null)
			name = GDTFUtil.getItemNullSave(node.getAttributes(), "Name");
		else name = "";
		return this.getClass();
	}

}
