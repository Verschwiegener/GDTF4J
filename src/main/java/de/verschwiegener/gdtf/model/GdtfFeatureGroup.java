package de.verschwiegener.gdtf.model;

import java.util.List;
import java.util.Objects;

/**
 * Group of features for the user interface, e.g. "Position" with the feature "PanTilt"
 */
public record GdtfFeatureGroup(String name, String pretty, List<String> features) {

	public GdtfFeatureGroup {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(pretty, "pretty");
		features = List.copyOf(features);
	}

}
