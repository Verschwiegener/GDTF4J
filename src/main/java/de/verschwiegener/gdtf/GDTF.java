package de.verschwiegener.gdtf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import de.verschwiegener.gdtf.fixtureType.geometries.Beam;
import de.verschwiegener.gdtf.fixtureType.models.Model;
import de.verschwiegener.gdtf.fixtureType.models.PrimitiveTypeEnum;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRIs;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.ColorSpace;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Connectors;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.DMXProfile;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Gamut;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.OperatingTemperature;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Properties;
import de.verschwiegener.gdtf.fixtureType.protocols.Protocols;
import de.verschwiegener.gdtf.fixtureType.revisions.Revisions;
import de.verschwiegener.gdtf.fixtureType.wheel.Wheel;
import de.verschwiegener.gdtf.util.GDTFDMXValue;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.SimpleDMXFunction;

public class GDTF {

	private GDTFType type;
	private File gdtfFile;
	private File gdtfOutputFolder;

	private File gdtfModel3ds;
	private File gdtfModelsvg;
	
	private DMXMode dmxMode;

	public GDTF(File gdtfFile, File gdtfOutputFolder) throws Exception {
		this.gdtfFile = gdtfFile;
		this.gdtfOutputFolder = gdtfOutputFolder;
		type = GDTFParser.parseGDTF(gdtfFile, gdtfOutputFolder);
		this.gdtfModelsvg = new File(gdtfOutputFolder, "models/svg");
		this.gdtfModel3ds = new File(gdtfOutputFolder, "models/3ds");
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
	
	public void selectMode(DMXMode mode) {
		this.dmxMode = mode;
	}
	
	public SimpleDMXFunction getSimpleDMXFunction(GDTFNode node) {
		return dmxMode.getDmxChannel(node).getSimpleDMXFunction(node);
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
		if(dmxMode == null) 
			return null;
		return dmxMode.getRelations();
	}
	
	
	public FTMacros getMacros() {
		if(dmxMode == null) 
			return null;
		return dmxMode.getFTMacros();
	}
	
		
	public void parse() {
		DMXMode mode = getDMXModes().get(0);
		mode.getGeometry();
		
		BasicGeometryAttributes g = type.getFixtureType().getGeometries().getGeometryOrAxisOrFilterBeam().stream()
				.filter(geo -> geo.getValue().getName().equals(mode.getGeometry())).findFirst().orElse(null).getValue();
		
		
		//TODO continue parser

	}	
	

	private AttributeDefinitions getAttributeDefinitions() {
		return type.getFixtureType().getAttributeDefinitions();
	}

	private PhysicalDescriptions getPhysicalDescriptions() {
		return type.getFixtureType().getPhysicalDescriptions();
	}

	public GDTFType getGDTFType() {
		return type;
	}

	private boolean hasSVG() {
		return gdtfModelsvg.exists();
	}

	public File checkSVG(String file) {
		if (!hasSVG())
			return null;
		File f = new File(gdtfModelsvg, file + ".svg");
		if (!f.exists())
			return null;
		return f;
	}

	private boolean has3ds() {
		return gdtfModel3ds.exists();
	}

	public static record DMXChannelData(int[] dmxOffset, String dmxBreak, String geometry, GDTFDMXValue highlight,
			GDTFNode initialfunction, List<SimpleDMXFunction> channelFunctions) {

	}
	

}
