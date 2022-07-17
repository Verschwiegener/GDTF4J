package de.verschwiegener.gdtf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.verschwiegener.gdtf4j.attribute.AttributeDefinition;
import de.verschwiegener.gdtf4j.dmx.DMXChannel;
import de.verschwiegener.gdtf4j.dmx.DMXMode;
import de.verschwiegener.gdtf4j.funktion.Wheel;
import de.verschwiegener.gdtf4j.geometry.BaseGeometry;
import de.verschwiegener.gdtf4j.geometry.GenericGeometry2;
import de.verschwiegener.gdtf4j.geometry.GeometryCollect;
import de.verschwiegener.gdtf4j.geometry.GeometryTypes;
import de.verschwiegener.gdtf4j.model.Model;
import de.verschwiegener.gdtf4j.physical.Emitter;
import de.verschwiegener.gdtf4j.physical.Filter;
import de.verschwiegener.gdtf4j.physical.PhysicalDescription;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

public class GDTF {

	public File gdtfFolder;
	public File gdtfFile;

	/**
	 * GDTF File Information
	 */
	private GDTFVersion GDTF_VERSION;

	/**
	 * Fixture Type Information
	 */
	private String description;
	private UUID fixtureTypeID;

	private UUID refFT;
	private String longName;
	private String manufacturer;
	private String name;
	private String shortName;
	private ByteBuffer thumbnail;

	public AttributeDefinition attributeDefinition;

	public PhysicalDescription physicalDescription;

	private ArrayList<Wheel> wheels = new ArrayList<Wheel>();
	private ArrayList<Model> models = new ArrayList<Model>();
	private GeometryCollect geometry;
	private ArrayList<DMXMode> dmxModes = new ArrayList<DMXMode>();
	private ArrayList<Revision> revisions = new ArrayList<Revision>();

	public GDTF(File gdtfFolder, File gdtfFile) {
		this.gdtfFolder = gdtfFolder;
		this.gdtfFile = gdtfFile;
	}

	public void fromGDTF() throws IOException, SAXException, ParserConfigurationException {
		GDTFUtil.unzipFile(gdtfFile, gdtfFolder);
		Document gdtfDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new FileReader(new File(gdtfFolder, "description.xml"))));

		Node gdtfNode = gdtfDocument.getElementsByTagName("GDTF").item(0);
		Element fixtureType = (Element) ((Element) gdtfNode).getElementsByTagName("FixtureType").item(0);

		GDTFVersion.valueOf(
				"VERSION_" + gdtfNode.getAttributes().getNamedItem("DataVersion").getNodeValue().replace(".", "_"));

		setFixtureTypeInformation(fixtureType);
		attributeDefinition = new AttributeDefinition(fixtureType.getElementsByTagName("AttributeDefinitions").item(0), this);

		addChildrenToArrayList(Wheel.class, wheels, fixtureType, "Wheels", "Wheel", this);
		physicalDescription = new PhysicalDescription(fixtureType.getElementsByTagName("PhysicalDescriptions").item(0),
				this);
		addChildrenToArrayList(Model.class, models, fixtureType, "Models", "Model", this);
		
		geometry = new GeometryCollect(GeometryTypes.Collect);
		geometry.fromXML(fixtureType.getElementsByTagName("Geometries").item(0), this);
		
		addChildrenToArrayList(DMXMode.class, dmxModes, fixtureType, "DMXModes", "DMXMode", this);
		addChildrenToArrayList(Revision.class, revisions, fixtureType, "Revisions", "Revision", this);
	}

	public void setFixtureTypeInformation(Node fixtureType) {
		NamedNodeMap map = fixtureType.getAttributes();
		name = map.getNamedItem("Name").getNodeValue();
		description = map.getNamedItem("Description").getNodeValue();
		fixtureTypeID = UUID.fromString(map.getNamedItem("FixtureTypeID").getNodeValue());
		String refFTValue = map.getNamedItem("RefFT").getNodeValue();
		if (!refFTValue.isEmpty())
			refFT = UUID.fromString(refFTValue);
		longName = map.getNamedItem("LongName").getNodeValue();
		shortName = map.getNamedItem("ShortName").getNodeValue();
		manufacturer = map.getNamedItem("Manufacturer").getNodeValue();
		thumbnail = GDTFUtil.loadImage(new File(gdtfFolder, map.getNamedItem("Thumbnail").getNodeValue() + ".png"));
	}

	public Wheel getWheelByName(String name) {
		return wheels.stream().filter(wheel -> wheel.getName().equals(name)).findFirst().orElse(null);
	}

	public Emitter getEmitterByName(String name) {
		return physicalDescription.emitters.stream().filter(emitter -> emitter.getName().equals(name)).findFirst()
				.orElse(null);
	}

	public Filter getFilterByName(String Filter) {
		return physicalDescription.filters.stream().filter(filter -> filter.getName().equals(Filter)).findFirst()
				.orElse(null);
	}
	public GeometryCollect getGeometry() {
		return geometry;
	}

}
