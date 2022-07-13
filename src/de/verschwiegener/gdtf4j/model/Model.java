package de.verschwiegener.gdtf4j.model;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.Unit;
import de.verschwiegener.gdtf4j.util.ValueUnit;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

public class Model extends GenericNameNode{
	
	private HashMap<FileType, File> files = new HashMap<FileType, File>();
	
	private Unit<?, Float> length;
	private Unit<?, Float> width;
	private Unit<?, Float> height;
	private PrimitiveType type;
	
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		System.out.println("From");
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		length = new Unit<>(Float.valueOf(getItemNullSave(map, "Length")), Float.class, ValueUnit.METER);
		width = new Unit<>(Float.valueOf(getItemNullSave(map, "Width")), Float.class, ValueUnit.METER);
		height = new Unit<>(Float.valueOf(getItemNullSave(map, "Height")), Float.class, ValueUnit.METER);
		type = PrimitiveType.valueOf(getItemNullSave(map, "PrimitiveType").toUpperCase());
		for(File models : new File(gdtf.gdtfFolder, "models").listFiles()) {
			File file = new File(models, getItemNullSave(map, "File") + "." + models.getName());
			if(file.exists())
				files.putIfAbsent(FileType.valueOf("FILE_" + models.getName().toUpperCase()), file);
		}
		return getClass();
	}

}
