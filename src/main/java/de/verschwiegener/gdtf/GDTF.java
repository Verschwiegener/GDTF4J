package de.verschwiegener.gdtf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.SimpleDMXFunction;

public class GDTF {

	private GDTFType type;
	private File gdtfFile;
	private File gdtfOutputFolder;

	private File gdtfModel3ds;
	private File gdtfModelsvg;
	private File gdtfModelgltf;

	private DMXMode dmxMode;

	public GDTF(File gdtfFile, File gdtfOutputFolder) throws Exception {
		this.gdtfFile = gdtfFile;
		this.gdtfOutputFolder = gdtfOutputFolder;
		type = GDTFParser.parseGDTF(gdtfFile, gdtfOutputFolder);
		this.gdtfModelsvg = new File(gdtfOutputFolder, "models/svg");
		this.gdtfModel3ds = new File(gdtfOutputFolder, "models/3ds");
		this.gdtfModelgltf = new File(gdtfOutputFolder, "models/gltf");
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

	public ArrayList<GDTFModelFile> getModelFile(String file) {
		ArrayList<GDTFModelFile> modelFiles = new ArrayList<GDTF.GDTFModelFile>();
		if (hasSVG()) {
			File fsvg = new File(gdtfModelsvg, file + ".svg");
			if (fsvg.exists())
				modelFiles.add(new GDTFModelFile(fsvg, GDTFModelType.TYPE_SVG));
		}
		if (has3DS()) {
			File f3ds = new File(gdtfModel3ds, file + ".3ds");
			if (f3ds.exists())
				modelFiles.add(new GDTFModelFile(f3ds, GDTFModelType.TYPE_3DS));
		}

		if (hasGLTF()) {
			File fgdtf = new File(gdtfModelgltf, file + ".glb");
			if (fgdtf.exists())
				modelFiles.add(new GDTFModelFile(fgdtf, GDTFModelType.TYPE_GLTF));
		}
		return modelFiles;
	}

	public ArrayList<GDTFGeometry> getGeometries() {
		ArrayList<GDTFGeometry> geo = new ArrayList<GDTF.GDTFGeometry>();
		for (JAXBElement<? extends BasicGeometryAttributes> geoType : type.getFixtureType().getGeometries()
				.getGeometryOrAxisOrFilterBeam()) {
			geo.add(parseGeo(geoType));
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

	private GDTFGeometry parseGeo(JAXBElement<? extends BasicGeometryAttributes> element) {
		BasicGeometryType type = (BasicGeometryType) element.getValue();
		ArrayList<GDTFGeometry> children = new ArrayList<GDTF.GDTFGeometry>();
		for (JAXBElement<? extends BasicGeometryAttributes> child : type.getGeometryOrAxisOrFilterBeam()) {
			children.add(parseGeo(child));
		}
		return new GDTFGeometry(element.getName().getLocalPart(), type, children);
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

	public static record DMXChannelData(int[] dmxOffset, String dmxBreak, String geometry, GDTFDMXValue highlight,
			GDTFNode initialfunction, List<SimpleDMXFunction> channelFunctions) {
	}

	public static record GDTFGeometry(String geoType, BasicGeometryType typeClass, ArrayList<GDTFGeometry> children) {
	}

	public static record GDTFModelFile(File file, GDTFModelType modelType) {
	}

	private static enum GDTFModelType {
		TYPE_3DS, TYPE_SVG, TYPE_GLTF;
	}

}
