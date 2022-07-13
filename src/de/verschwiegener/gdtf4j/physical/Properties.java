package de.verschwiegener.gdtf4j.physical;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.util.Unit;
import de.verschwiegener.gdtf4j.util.ValueUnit;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;
import static de.verschwiegener.gdtf4j.util.GDTFUtil.getFloatNullSave;

public class Properties {

	private Unit<?, Float> OperationTemperaturLow;
	private Unit<?, Float> OperationTemperaturLigh;

	private Unit<?, Float> weight;

	private Unit<?, Float> legHeight;

	private PowerConsumption powerConsumption;

	public Properties(Node node, GDTF gdtf) {
		Element e = (Element) node;

		Node opTemp = e.getElementsByTagName("OperatingTemperature").item(0);
		OperationTemperaturLow = new Unit<>(getFloatNullSave(opTemp, "Low", 0), Float.class, ValueUnit.CELSIUS);
		OperationTemperaturLigh = new Unit<>(getFloatNullSave(opTemp, "High", 40), Float.class, ValueUnit.CELSIUS);

		Node weightN = e.getElementsByTagName("Weight").item(0);
		weight = new Unit<>(getFloatNullSave(weightN, "Weight", 0), Float.class, ValueUnit.KG);

		Node legHeightN = e.getElementsByTagName("LegHeight").item(0);
		legHeight = new Unit<>(getFloatNullSave(legHeightN.getAttributes(), "LegHeight", 0), Float.class,
				ValueUnit.METER);

		powerConsumption = new PowerConsumption(e.getElementsByTagName("PowerConsumption").item(0), gdtf);
	}

	class PowerConsumption {
		private Unit<?, Float> value;
		private Unit<?, Float> powerFactor;
		private Connector connector;
		private Unit<?, Float> voltageLow;
		private Unit<?, Float> voltageHigh;
		private Unit<?, Float> frequencyLow;
		private Unit<?, Float> frequencyHigh;

		public PowerConsumption(Node node, GDTF gdtf) {
			if (node == null)
				return;
			NamedNodeMap map = node.getAttributes();
			value = new Unit<>(Float.valueOf(getItemNullSave(map, "Value")), Float.class, ValueUnit.VA);
			powerFactor = new Unit<>(Float.valueOf(getItemNullSave(map, "PowerFactor")), Float.class, ValueUnit.NONE);
			connector = gdtf.physicalDescription.getConnectorByName(getItemNullSave(map, "Connector"));
			voltageLow = new Unit<>(Float.valueOf(getItemNullSave(map, "VoltageLow")), Float.class, ValueUnit.VOLT);
			voltageHigh = new Unit<>(Float.valueOf(getItemNullSave(map, "VoltageHigh")), Float.class, ValueUnit.VOLT);
			frequencyLow = new Unit<>(Float.valueOf(getItemNullSave(map, "FrequencyLow")), Float.class,
					ValueUnit.HERTZ);
			frequencyHigh = new Unit<>(Float.valueOf(getItemNullSave(map, "FrequencyHigh")), Float.class,
					ValueUnit.HERTZ);
		}
	}
}
