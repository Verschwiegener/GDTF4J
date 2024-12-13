package de.verschwiegener.gdtf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBElement;

import de.verschwiegener.gdtf.fixtureType.FTPresets;
import de.verschwiegener.gdtf.fixtureType.PhysicalDescriptions;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.AttributeDefinitions;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.activationGroup.ActivationGroup;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute.Attribute;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.Feature;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.FeatureGroup;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXChannel;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXMode;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.FTMacros;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.Relations;
import de.verschwiegener.gdtf.fixtureType.geometries.BasicGeometryAttributes;
import de.verschwiegener.gdtf.fixtureType.geometries.BasicGeometryType;
import de.verschwiegener.gdtf.fixtureType.models.Model;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRIs;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.ColorSpace;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Connectors;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.DMXProfile;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Gamut;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Properties;
import de.verschwiegener.gdtf.fixtureType.protocols.Protocols;
import de.verschwiegener.gdtf.fixtureType.revisions.Revisions;
import de.verschwiegener.gdtf.fixtureType.wheel.Wheel;
import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFModel;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;
import de.verschwiegener.gdtf.util.SimpleDMXFunction;

public class GDTF {

	private GDTFType type;
	private File gdtfFile;
	private File gdtfOutputFolder;

	private File gdtfModel3ds;
	private File gdtfModelsvg;
	private File gdtfModelgltf;

	private DMXMode dmxMode;

	/**
	 * Creates internal File Structure, gdtf first needs to be parsed to be useful
	 * 
	 * @param gdtfFile
	 * @param gdtfOutputFolder
	 */
	public GDTF(File gdtfFile, File gdtfOutputFolder) {
		this.gdtfFile = gdtfFile;
		this.gdtfOutputFolder = new File(gdtfOutputFolder, gdtfFile.getName().split("\\.")[0]);
		this.gdtfModelsvg = new File(this.gdtfOutputFolder, "models/svg");
		this.gdtfModel3ds = new File(this.gdtfOutputFolder, "models/3ds");
		this.gdtfModelgltf = new File(this.gdtfOutputFolder, "models/gltf");
	}
	
	/**
	 * Parses GDTF
	 * @throws Exception 
	 */
	public void parse() throws Exception {
		//Parse File only once
		if(type != null)
			return;
		type = GDTFParser.parseGDTF(gdtfFile, this.gdtfOutputFolder);
	}

	public ActivationGroup getActivationGroup(GDTFNode node) {
		return getAttributeDefinitions().getActivationGroups().getActivationGroup(node);
	}

	public FeatureGroup getFeatureGroup(GDTFNode node) {
		return getAttributeDefinitions().getFeatureGroups().getFeatureGroup(node);
	}

	public Feature getFeature(GDTFNode node) {
		return getAttributeDefinitions().getFeatureGroups().getFeature(node);
	}

	public Attribute getAttribute(GDTFNode node) {
		return getAttributeDefinitions().getAttributes().getAttribute(node);
	}

	public Wheel getWheel(GDTFNode node) {
		return type.getFixtureType().getWheels().getWheel(node);
	}

	public ColorSpace getDefaultColorSpace() {
		return getPhysicalDescriptions().getColorSpace();
	}

	public ColorSpace getColorSpace(GDTFNode node) {
		return getPhysicalDescriptions().getColorSpace(node);
	}

	public Gamut getGamut(GDTFNode node) {
		return getPhysicalDescriptions().getGamuts().getGammut(node);
	}

	public Filter getFilter(GDTFNode node) {
		return getPhysicalDescriptions().getFilters().getFilter(node);
	}

	public Emitter getEmitter(GDTFNode node) {
		return getPhysicalDescriptions().getEmitters().getEmitter(node);
	}

	public DMXProfile getDmxProfile(GDTFNode node) {
		return getPhysicalDescriptions().getDMXProfiles().getDmxProfile(node);
	}

	public CRIs getCRI() {
		return getPhysicalDescriptions().getCRIs();
	}

	public Connectors getConnectors() {
		return getPhysicalDescriptions().getConnectors();
	}

	public Properties getProperties() {
		return getPhysicalDescriptions().getProperties();
	}

	public Model getModel(GDTFNode node) {
		return type.getFixtureType().getModels().getModel(node);
	}
	
	/**
	 * Returns File to given 3D Model File
	 * @param file
	 * @return
	 */
	public File get3DModelFile(String file) {
		if (has3DS()) {
			File f3ds = new File(gdtfModel3ds, file + ".3ds");
			if (f3ds.exists())
				return f3ds;
		}

		if (hasGLTF()) {
			File fgdtf = new File(gdtfModelgltf, file + ".glb");
			if (fgdtf.exists())
				return fgdtf;
		}
		return null;
	}
	
	public GDTFModel get2DModelFile(String file) {
		if (hasSVG()) {
			File fsvg = new File(gdtfModelsvg, file + ".svg");
			if (fsvg.exists())
				return new GDTFModel(fsvg);
		}
		return null;
	}

	public ArrayList<GDTFGeometry> getGeometries() {
		ArrayList<GDTFGeometry> geo = new ArrayList<GDTF.GDTFGeometry>();
		for (JAXBElement<? extends BasicGeometryAttributes> geoType : type.getFixtureType().getGeometries()
				.getGeometryOrAxisOrFilterBeam()) {
			GDTFGeometry gdtfGeo = parseGeo(geoType);
			if(gdtfGeo != null)
				geo.add(gdtfGeo);
		}
		return geo;
	}

	public Revisions getRevisions() {
		return type.getFixtureType().getRevisions();
	}

	public FTPresets getPresets() {
		return type.getFixtureType().getFTPresets();
	}

	public Protocols getProtocols() {
		return type.getFixtureType().getProtocols();
	}

	public List<DMXMode> getDMXModes() {
		return type.getFixtureType().getDMXModes().getDMXMode();
	}
	
	public DMXMode getDMXModeByName(String dmxMode) {
		return type.getFixtureType().getDMXModes().getDMXMode().stream().filter(m -> m.getName().equals(dmxMode)).findFirst().orElse(null);
	}

	public void selectMode(DMXMode mode) {
		this.dmxMode = mode;
	}

	public SimpleDMXFunction getSimpleDMXFunction(GDTFNode node) {
		DMXChannel channel = dmxMode.getDmxChannel(node);
		return channel.getSimpleDMXFunction(node);
	}

	public List<DMXChannelData> getDMXChannels() {
		List<DMXChannelData> channelData = new ArrayList<>();
		for (DMXChannel channel : dmxMode.getDMXChannels().getDMXChannel()) {
			channelData.add(new DMXChannelData(channel.getOffsetAsInt(), channel.getDMXBreak(), channel.getGeometry(),
					channel.getHighlight(), channel.getInitialFunction(), channel.getFunctions()));
		}
		return channelData;
	}

	public Relations getRelations() {
		if (dmxMode == null)
			return null;
		return dmxMode.getRelations();
	}

	public FTMacros getMacros() {
		if (dmxMode == null)
			return null;
		return dmxMode.getFTMacros();
	}

	public GDTFType getGDTFType() {
		return type;
	}

	/**
	 * Parses XML Geometry into GDTFGeometry
	 * @param element
	 * @return
	 */
	private GDTFGeometry parseGeo(JAXBElement<? extends BasicGeometryAttributes> element) {
		BasicGeometryType type = (BasicGeometryType) element.getValue();
		//Get Children of Geometry
		ArrayList<GDTFGeometry> children = type.getGeometryOrAxisOrFilterBeam().stream().map(child -> parseGeo(child))
				.collect(Collectors.toCollection(ArrayList::new));

		Model model = getModel(type.getModel());
		if(model == null)
			return null;
		return new GDTFGeometry(element.getName().getLocalPart(), type, children,
				new GDTFModel(get3DModelFile(model.getFile()), type.getPosition()), get2DModelFile(model.getFile()));
	}

	private AttributeDefinitions getAttributeDefinitions() {
		return type.getFixtureType().getAttributeDefinitions();
	}

	private PhysicalDescriptions getPhysicalDescriptions() {
		return type.getFixtureType().getPhysicalDescriptions();
	}

	private boolean hasSVG() {
		return gdtfModelsvg.exists();
	}

	private boolean has3DS() {
		return gdtfModel3ds.exists();
	}
	
	private boolean hasGLTF() {
		return gdtfModelgltf.exists();
	}

	/**
	 * Utility Class holding parsed DMXChannelData
	 */
	public static record DMXChannelData(int[] dmxOffset, String dmxBreak, String geometry, GDTFDMXValue highlight,
			GDTFNode initialfunction, List<SimpleDMXFunction> channelFunctions) {
		
		/**
		 * Returns SimpleDMXFunction by ChannelFunction Attribute node
		 * 
		 * @param node
		 * @return
		 */
		public SimpleDMXFunction getSimpleDMXFunctionFromAttribute(GDTFNode node) {
			if(!node.checkPoint(NodeStartingPoint.Attribute)) 
				return null;
			//return channelFunctions.stream().filter(cf -> node.check(cf.getAttribute())).findFirst().orElse(null);
			return null;
		}
	}
	
	/**
	 * Utility Class holding parsed Geometry Information
	 */
	public static record GDTFGeometry(String geoType, BasicGeometryType typeClass, ArrayList<GDTFGeometry> children, GDTFModel model3D, GDTFModel model2D) {
	}

}
