package de.verschwiegener.gdtf;

import java.io.IOException;

/**
 * A GDTF file can not be read. The message names the element or line the problem occurs in, e.g.
 * "DMXMode Standard, DMXChannel Beam_Dimmer Offset: not a number: x".
 */
public class GdtfException extends IOException {

	private static final long serialVersionUID = 1L;

	public GdtfException(String message) {
		super(message);
	}

	public GdtfException(String message, Throwable cause) {
		super(message, cause);
	}

}
