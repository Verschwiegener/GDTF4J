package de.verschwiegener.gdtf.model;

import java.util.Objects;

/**
 * An attribute of the fixture type, e.g. Dimmer, Pan or Gobo1
 *
 * @param featureGroup    Name of the feature group, e.g. "Position", null if none
 * @param feature         Name of the feature inside the group, e.g. "PanTilt", null if none
 * @param activationGroup Attributes of the same group are changed together, e.g. Pan and Tilt. Null if none.
 * @param mainAttribute   Attribute this one belongs to, e.g. Gobo1 for Gobo1Pos. Null if none.
 * @param physicalUnit    Unit of the physical values as named in GDTF, e.g. "Angle" or "Percent"
 * @param color           Color of a color mixing attribute, null if none
 */
public record GdtfAttribute(String name, String pretty, String featureGroup, String feature, String activationGroup,
		String mainAttribute, String physicalUnit, CieColor color) {

	public GdtfAttribute {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(pretty, "pretty");
		Objects.requireNonNull(physicalUnit, "physicalUnit");
	}

}
