package de.verschwiegener.gdtf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getIntegerNullSave;;

public class Revision extends GDTFClass{
	
	private String text;
	private LocalDateTime date;
	private int userID;
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		NamedNodeMap map = node.getAttributes();
		text = getItemNullSave(map, "Text");
		date = LocalDateTime.parse(getItemNullSave(map, "Date"));
		userID = getIntegerNullSave(map, "UserID", 0);
		return getClass();
	}

}
