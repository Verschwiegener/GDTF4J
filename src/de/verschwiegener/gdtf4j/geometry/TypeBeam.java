package de.verschwiegener.gdtf4j.geometry;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.Unit;
import de.verschwiegener.gdtf4j.util.ValueUnit;

public class TypeBeam extends GenericGeometry2 {

	private LampType lampType = LampType.DISCHARGE;
	private Unit<?, Float> powerConsumption;
	private Unit<?, Float> luminousFlux;
	private Unit<?, Float> colorTemperatur;
	private Unit<?, Float> beamAngle;
	private Unit<?, Float> fieldAngle;
	private Unit<?, Float> throwRatio;
	private Unit<?, Float> rectangleRatio;
	private Unit<?, Float> beamRadius;
	private BeamType beamType = BeamType.WASH;
	private byte colorRenderingIndex = 100;
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		NamedNodeMap map = node.getAttributes();
		String lampType = getItemNullSave(map, "LampType");
		if(!lampType.isEmpty()) this.lampType = LampType.valueOf(lampType);
		
		powerConsumption = new Unit<>(getFloatNullSave(map, "PowerConsumption", 1000), Float.class, ValueUnit.WATT);
		luminousFlux = new Unit<>(getFloatNullSave(map, "LuminousFlux", 10000), Float.class, ValueUnit.LUMEN);
		colorTemperatur = new Unit<>(getFloatNullSave(map, "ColorTemperatur", 6000), Float.class, ValueUnit.KELVIN);
		beamAngle = new Unit<>(getFloatNullSave(map, "BeamAngle", 25.0f), Float.class, ValueUnit.DEGREE);
		fieldAngle = new Unit<>(getFloatNullSave(map, "FieldAngle", 25.0f), Float.class, ValueUnit.DEGREE);
		throwRatio = new Unit<>(getFloatNullSave(map, "ThrowRatio", 1), Float.class, ValueUnit.NONE);
		rectangleRatio = new Unit<>(getFloatNullSave(map, "RectangleRatio", 1.7777f), Float.class, ValueUnit.NONE);
		beamRadius = new Unit<>(getFloatNullSave(map, "BeamRadius", 0.05f), Float.class, ValueUnit.METER);
		
		String beamType = getItemNullSave(map, "BeamType");
		if(!beamType.isEmpty()) this.beamType = BeamType.valueOf(beamType.toUpperCase());
		
		String colorRenderingIndex = getItemNullSave(map, "ColorRenderingIndex");
		if(!colorRenderingIndex.isEmpty()) this.colorRenderingIndex = Byte.valueOf(colorRenderingIndex);
		return getClass();
	}

}