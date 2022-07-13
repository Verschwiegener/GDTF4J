package de.verschwiegener.gdtf4j.physical;

import java.util.ArrayList;


public class CRIS {
	//TODO CRIS

	private final ArrayList<CRIGroup> CRIs;

	public CRIS() {
		CRIs = new ArrayList<CRIGroup>();
	}

	public void addCRI(String colorTemperature) {
		CRIs.add(new CRIGroup(colorTemperature));
	}

	public ArrayList<CRIGroup> getCRIs() {
		return CRIs;
	}
	
	class CRIGroup {
		/**
		 * Color temperature; Default value: 6 000; Unit: Kelvin
		 */
		private final float colorTemperature;

		public CRIGroup(String colorTemperature) {
			this.colorTemperature = Float.valueOf(colorTemperature);
		}
		public float getColorTemperature() {
			return colorTemperature;
		}
	}

}
