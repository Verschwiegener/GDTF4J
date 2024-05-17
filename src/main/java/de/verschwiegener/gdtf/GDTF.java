package de.verschwiegener.gdtf;

import java.io.File;
import java.util.List;
import java.util.UUID;

import de.verschwiegener.gdtf.fixtureType.FixtureType;
import de.verschwiegener.gdtf.fixtureType.geometries.BasicGeometryType;
import de.verschwiegener.gdtf.fixtureType.geometries.Protocol;
import de.verschwiegener.gdtf.fixtureType.models.Model;
import de.verschwiegener.gdtf.fixtureType.models.PrimitiveTypeEnum;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.ColorSpace;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.OperatingTemperature;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Properties;
import de.verschwiegener.gdtf.fixtureType.protocols.Protocols;
import de.verschwiegener.gdtf.fixtureType.revisions.Revision;
import de.verschwiegener.gdtf.fixtureType.wheel.Wheel;
import de.verschwiegener.gdtf.util.GDTFMatrix;

public class GDTF {

	private GDTFType type;
	private File gdtfFile;
	private File gdtfOutputFolder;

	private File gdtfModel3ds;
	private File gdtfModelsvg;

	public GDTF(File gdtfFile, File gdtfOutputFolder) throws Exception {
		this.gdtfFile = gdtfFile;
		this.gdtfOutputFolder = gdtfOutputFolder;
		type = GDTFParser.parseGDTF(gdtfFile, gdtfOutputFolder);
		this.gdtfModelsvg = new File(gdtfOutputFolder, "models/svg");
		this.gdtfModel3ds = new File(gdtfOutputFolder, "models/3ds");
	}

	public GDTFDescription getDescription() {
		FixtureType ftype = type.getFixtureType();
		return new GDTFDescription(ftype.getCanHaveChildren().isState(), ftype.getDescription(),
				UUID.fromString(ftype.getFixtureTypeID()), ftype.getLongName(), ftype.getManufacturer(),
				ftype.getName(), ftype.getRefFT(), ftype.getShortName(),
				new File(gdtfOutputFolder, ftype.getThumbnail()));
	}

	public List<Wheel> getWheel() {
		return type.getFixtureType().getWheels().getWheel();
	}

	public List<Filter> getFilters() {
		return type.getFixtureType().getPhysicalDescriptions().getFilters().getFilter();
	}

	public List<Emitter> getEmitter() {
		return type.getFixtureType().getPhysicalDescriptions().getEmitters().getEmitter();
	}

	public GDTFProperties getProperties() {
		Properties properties = type.getFixtureType().getPhysicalDescriptions().getProperties();
		return new GDTFProperties(type.getFixtureType().getPhysicalDescriptions().getColorSpace(),
				properties.getOperatingTemperature(), properties.getWeight().getValue(),
				properties.getLegHeight().getValue());
	}

	public GDTFModel getModel(String name) {
		Model model = type.getFixtureType().getModels().getModelByName(name);
		
		
		File svgFile = checkSVG(model.getFile());
		//Create SVG Values or Null
		SVGValues svgValues = svgFile != null
				? new SVGValues(model.getSVGFrontOffsetX(), model.getSVGFrontOffsetY(), model.getSVGOffsetX(),
						model.getSVGOffsetY(), model.getSVGSideOffsetX(), model.getSVGSideOffsetY())
				: null;

		//Return Model
		return new GDTFModel(model.getName(), new File(gdtfModel3ds, model.getFile() + ".3ds"),
				svgFile, model.getWidth(),
				model.getHeight(), model.getLength(), model.getPrimitiveType(), svgValues);
	}
	
	//TODO API Work

	public List<Revision> getRevisions() {
		return type.getFixtureType().getRevisions().getRevision();
	}

	public Protocols getProtocols() {
		return type.getFixtureType().getProtocols();
	}

	public GDTFType getGDTF() {
		return type;
	}

	private boolean hasSVG() {
		return gdtfModelsvg.exists();
	}
	
	private File checkSVG(String file) {
		if(!hasSVG()) return null;
		File f = new File(gdtfModelsvg, file + ".svg");
		if(!f.exists()) return null;
		return f;
	}

	private boolean has3ds() {
		return gdtfModel3ds.exists();
	}

	public static record GDTFDescription(boolean canHaveDescription, String description, UUID fixtureTypeID,
			String longName, String manufacturer, String name, String RefFt, String ShortName, File thumbnail) {
	}

	public static record GDTFProperties(ColorSpace colorSpace, OperatingTemperature temp, float weight,
			float legHeight) {
	}

	public static record GDTFModel(String name, File model, File svg, float width, float height, float length,
			PrimitiveTypeEnum type, SVGValues svgValues) {
	}

	public static record SVGValues(float SVGFrontOffsetX, float SVGFrontOffsetY, float SVGOffsetX, float SVGOffsetY,
			float SVGSideOffsetX, float SVGSideOffsetY) {
	}

}
