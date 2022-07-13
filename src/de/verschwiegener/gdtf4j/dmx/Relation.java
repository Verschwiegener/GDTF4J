package de.verschwiegener.gdtf4j.dmx;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.dmx.DMXChannel.ChannelFunktion;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;
import de.verschwiegener.gdtf4j.util.GenericNameNode;

public class Relation extends GenericNameNode{
	
	private String master;
	private String follower;
	private RelationType type;
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		master = getItemNullSave(map, "Master");
		follower = getItemNullSave(map, "Follower");
		type = RelationType.valueOf(getItemNullSave(map, "Type"));
		return getClass();
	}

}
