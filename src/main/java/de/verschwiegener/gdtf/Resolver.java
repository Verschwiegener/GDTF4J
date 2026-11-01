package de.verschwiegener.gdtf;

import static de.verschwiegener.gdtf.XmlValues.blankToNull;
import static de.verschwiegener.gdtf.XmlValues.matrix;
import static de.verschwiegener.gdtf.XmlValues.or;
import static de.verschwiegener.gdtf.XmlValues.required;
import static de.verschwiegener.gdtf.XmlValues.text;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import de.verschwiegener.gdtf.model.CieColor;
import de.verschwiegener.gdtf.model.GdtfAttribute;
import de.verschwiegener.gdtf.model.GdtfDmxMode;
import de.verschwiegener.gdtf.model.GdtfFeatureGroup;
import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.model.GdtfGeometry;
import de.verschwiegener.gdtf.model.GdtfModel;
import de.verschwiegener.gdtf.model.GdtfPhysical;
import de.verschwiegener.gdtf.model.GdtfWheel;
import de.verschwiegener.gdtf.xml.Attribute;
import de.verschwiegener.gdtf.xml.BasicGeometryAttributes;
import de.verschwiegener.gdtf.xml.BasicGeometryType;
import de.verschwiegener.gdtf.xml.Beam;
import de.verschwiegener.gdtf.xml.DMXMode;
import de.verschwiegener.gdtf.xml.FixtureType;
import de.verschwiegener.gdtf.xml.GDTF;
import de.verschwiegener.gdtf.xml.GeometryReference;
import de.verschwiegener.gdtf.xml.PhysicalDescriptions;
import jakarta.xml.bind.JAXBElement;

/**
 * Turns the generated XML classes into the resolved model: attributes, wheels, physical descriptions, models and
 * the geometry tree here, the DMX modes in {@link ModeResolver}.
 * <p>
 * Problems a real file may have (unknown references, broken colors) become warnings. Problems that make the
 * result wrong (invalid DMX values or offsets) fail with the element they occur in.
 */
final class Resolver {

	private final GDTF root;
	private final FixtureType type;
	private final List<String> warnings = new ArrayList<>();
	private final Map<String, GdtfWheel> wheels = new LinkedHashMap<>();
	private final Map<String, GdtfPhysical.Emitter> emitters = new LinkedHashMap<>();
	private final Map<String, GdtfPhysical.Filter> filters = new LinkedHashMap<>();
	private int unnamedGeometries;

	Resolver(GDTF root) {
		this.root = root;
		this.type = Objects.requireNonNull(root.getFixtureType(), "FixtureType");
	}

	List<String> warnings() {
		return List.copyOf(warnings);
	}

	GdtfFixtureType resolve() throws GdtfException {
		List<GdtfFeatureGroup> featureGroups = new ArrayList<>();
		List<String> activationGroups = new ArrayList<>();
		List<GdtfAttribute> attributes = new ArrayList<>();
		if (type.getAttributeDefinitions() != null) {
			var definitions = type.getAttributeDefinitions();
			if (definitions.getActivationGroups() != null)
				definitions.getActivationGroups().getActivationGroup().forEach(group -> activationGroups.add(group.getName()));
			if (definitions.getFeatureGroups() != null) {
				for (var group : definitions.getFeatureGroups().getFeatureGroup())
					featureGroups.add(new GdtfFeatureGroup(group.getName(), text(group.getPretty(), group.getName()),
							group.getFeature().stream().map(feature -> feature.getName()).toList()));
			}
			if (definitions.getAttributes() != null) {
				for (var attribute : definitions.getAttributes().getAttribute())
					attributes.add(attribute(attribute));
			}
		}

		resolvePhysical(type.getPhysicalDescriptions());
		resolveWheels();

		List<GdtfModel> models = new ArrayList<>();
		if (type.getModels() != null) {
			for (var model : type.getModels().getModel())
				models.add(new GdtfModel(model.getName(), model.getLength(), model.getWidth(), model.getHeight(),
						model.getPrimitiveType() != null ? model.getPrimitiveType().value() : "Undefined",
						blankToNull(model.getFile())));
		}

		List<GdtfGeometry> geometries = new ArrayList<>();
		if (type.getGeometries() != null) {
			for (JAXBElement<?> element : type.getGeometries().getGeometryOrAxisOrFilterBeam())
				geometries.add(geometry(element));
		}

		List<GdtfDmxMode> modes = new ArrayList<>();
		if (type.getDMXModes() != null) {
			for (DMXMode mode : type.getDMXModes().getDMXMode())
				modes.add(new ModeResolver(mode, geometries, wheels, emitters, filters, warnings).resolve());
		}

		List<GdtfFixtureType.Revision> revisions = new ArrayList<>();
		if (type.getRevisions() != null) {
			for (var revision : type.getRevisions().getRevision())
				revisions.add(new GdtfFixtureType.Revision(text(revision.getText(), ""),
						revision.getDate() != null ? revision.getDate().toXMLFormat() : null,
						blankToNull(revision.getModifiedBy())));
		}

		return new GdtfFixtureType(dataVersion(), required(type.getFixtureTypeID(), "FixtureTypeID"),
				required(type.getName(), "Name"), text(type.getShortName(), ""), text(type.getLongName(), ""),
				text(type.getManufacturer(), ""), text(type.getDescription(), ""), blankToNull(type.getThumbnail()),
				blankToNull(type.getRefFT()),
				type.getCanHaveChildren() == null || "Yes".equals(type.getCanHaveChildren().value()), revisions,
				featureGroups, activationGroups, attributes, List.copyOf(wheels.values()),
				List.copyOf(emitters.values()), List.copyOf(filters.values()), colorSpace(type.getPhysicalDescriptions()),
				models, geometries, modes);
	}

	private String dataVersion() {
		String version = Float.toString(root.getDataVersion());
		return version.endsWith(".0") ? version.substring(0, version.length() - 2) : version;
	}

	private GdtfAttribute attribute(Attribute attribute) {
		String featureGroup = null;
		String feature = null;
		String path = blankToNull(attribute.getFeature());
		if (path != null) {
			int dot = path.indexOf('.');
			featureGroup = dot < 0 ? path : path.substring(0, dot);
			feature = dot < 0 ? null : path.substring(dot + 1);
		}
		return new GdtfAttribute(attribute.getName(), text(attribute.getPretty(), attribute.getName()), featureGroup,
				feature, blankToNull(attribute.getActivationGroup()), blankToNull(attribute.getMainAttribute()),
				attribute.getPhysicalUnit() != null ? attribute.getPhysicalUnit().value() : "None",
				color(attribute.getColor(), () -> "Attribute " + attribute.getName()));
	}

	private void resolvePhysical(PhysicalDescriptions physical) {
		if (physical == null)
			return;
		if (physical.getEmitters() != null) {
			for (var emitter : physical.getEmitters().getEmitter()) {
				emitters.put(emitter.getName(), new GdtfPhysical.Emitter(emitter.getName(),
						color(emitter.getColor(), () -> "Emitter " + emitter.getName()),
						emitter.getDominantWaveLength() != null ? emitter.getDominantWaveLength().doubleValue() : null,
						blankToNull(emitter.getDiodePart())));
			}
		}
		if (physical.getFilters() != null) {
			for (var filter : physical.getFilters().getFilter())
				filters.put(filter.getName(), new GdtfPhysical.Filter(filter.getName(),
						color(filter.getColor(), () -> "Filter " + filter.getName())));
		}
	}

	private GdtfPhysical.ColorSpace colorSpace(PhysicalDescriptions physical) {
		if (physical == null || physical.getColorSpace() == null)
			return new GdtfPhysical.ColorSpace(null, "sRGB", null, null, null, null);
		var space = physical.getColorSpace();
		String mode = space.getMode() != null ? space.getMode().value() : "sRGB";
		boolean custom = mode.equals("Custom");
		return new GdtfPhysical.ColorSpace(blankToNull(space.getName()), mode,
				custom ? color(space.getRed(), () -> "ColorSpace red") : null,
				custom ? color(space.getGreen(), () -> "ColorSpace green") : null,
				custom ? color(space.getBlue(), () -> "ColorSpace blue") : null,
				custom ? color(space.getWhitePoint(), () -> "ColorSpace white point") : null);
	}

	private void resolveWheels() throws GdtfException {
		if (type.getWheels() == null)
			return;
		for (var wheel : type.getWheels().getWheel()) {
			List<GdtfWheel.Slot> slots = new ArrayList<>();
			int index = 1;
			for (var slot : wheel.getSlot()) {
				String context = "Wheel " + wheel.getName() + ", Slot " + index;
				List<GdtfWheel.Facet> facets = new ArrayList<>();
				for (var facet : slot.getFacet())
					facets.add(new GdtfWheel.Facet(color(facet.getColor(), () -> context + " facet"),
							matrix(facet.getRotation(), context + " facet")));
				String filter = blankToNull(slot.getFilter());
				if (filter != null && !filters.containsKey(filter))
					warnings.add(context + " uses unknown filter " + filter);
				slots.add(new GdtfWheel.Slot(index++, text(slot.getName(), ""),
						color(slot.getColor(), () -> context), filter, blankToNull(slot.getMediaFileName()), facets));
			}
			wheels.put(wheel.getName(), new GdtfWheel(wheel.getName(), slots));
		}
	}

	private GdtfGeometry geometry(JAXBElement<?> element) throws GdtfException {
		BasicGeometryAttributes geometry = (BasicGeometryAttributes) element.getValue();
		GdtfGeometry.Type kind = GdtfGeometry.Type.ofElement(element.getName().getLocalPart());
		String context = element.getName().getLocalPart() + " " + geometry.getName();

		List<GdtfGeometry> children = new ArrayList<>();
		if (geometry instanceof BasicGeometryType parent) {
			for (JAXBElement<?> child : parent.getGeometryOrAxisOrFilterBeam())
				children.add(geometry(child));
		}
		GdtfGeometry.Beam beam = geometry instanceof Beam b ? beam(b) : null;
		GdtfGeometry.Reference reference = null;
		if (geometry instanceof GeometryReference r) {
			List<GdtfGeometry.Break> breaks = r.getBreak().stream()
					.map(b -> new GdtfGeometry.Break(b.getDMXBreak(), b.getDMXOffset())).toList();
			reference = new GdtfGeometry.Reference(required(r.getGeometry(), context + " Geometry"), breaks);
		}
		String model = blankToNull(geometry.getModel());
		if (model != null && type.getModels() != null
				&& type.getModels().getModel().stream().noneMatch(m -> model.equals(m.getName())))
			warnings.add(context + " uses unknown model " + model);
		String name = blankToNull(geometry.getName());
		if (name == null) {
			name = element.getName().getLocalPart() + " " + ++unnamedGeometries;
			warnings.add(element.getName().getLocalPart() + " without name, called it " + name);
		}
		return new GdtfGeometry(kind, name, model, matrix(geometry.getPosition(), context), children, beam,
				reference);
	}

	private static GdtfGeometry.Beam beam(Beam beam) {
		return new GdtfGeometry.Beam(beam.getLampType() != null ? beam.getLampType().value() : "Discharge",
				beam.getBeamType() != null ? beam.getBeamType().value() : "Wash", or(beam.getPowerConsumption(), 1000),
				or(beam.getLuminousFlux(), 10000), or(beam.getColorTemperature(), 6000), or(beam.getBeamAngle(), 25),
				or(beam.getFieldAngle(), 25), or(beam.getBeamRadius(), 0.05), or(beam.getThrowRatio(), 1),
				or(beam.getRectangleRatio(), 1.7777), beam.getColorRenderingIndex() != null
						? beam.getColorRenderingIndex()
						: 100,
				blankToNull(beam.getEmitterSpectrum()));
	}

	private CieColor color(String text, Supplier<String> context) {
		try {
			return CieColor.parse(text);
		} catch (IllegalArgumentException e) {
			warnings.add(context.get() + ": " + e.getMessage());
			return null;
		}
	}

}
