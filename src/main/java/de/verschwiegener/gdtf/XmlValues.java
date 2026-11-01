package de.verschwiegener.gdtf;

import java.util.function.Supplier;

import de.verschwiegener.gdtf.model.GdtfMatrix;

/**
 * Reading attribute values of the generated XML classes. Missing or blank values get a fallback, invalid ones
 * become a {@link GdtfException} that names the element.
 */
final class XmlValues {

	private XmlValues() {
	}

	/**
	 * Values of the model classes reject invalid text with IllegalArgumentException, here it becomes a
	 * GdtfException naming the element
	 */
	static <T> T parse(Supplier<T> value, String context) throws GdtfException {
		try {
			return value.get();
		} catch (IllegalArgumentException e) {
			throw new GdtfException(context + ": " + e.getMessage(), e);
		}
	}

	static GdtfMatrix matrix(String text, String context) throws GdtfException {
		return parse(() -> GdtfMatrix.parse(text), context);
	}

	static int integer(String text, String context) throws GdtfException {
		try {
			return Integer.parseInt(text.strip());
		} catch (NumberFormatException e) {
			throw new GdtfException(context + ": not a number: " + text, e);
		}
	}

	static String required(String value, String context) throws GdtfException {
		if (value == null || value.isBlank())
			throw new GdtfException(context + " is missing");
		return value;
	}

	static String text(String value, String fallback) {
		return value == null || value.isBlank() ? fallback : value;
	}

	static String blankToNull(String value) {
		return value == null || value.isBlank() ? null : value;
	}

	static double or(Number value, double fallback) {
		return value != null ? value.doubleValue() : fallback;
	}

}
