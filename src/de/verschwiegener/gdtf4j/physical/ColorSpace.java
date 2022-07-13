package de.verschwiegener.gdtf4j.physical;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.verschwiegener.gdtf4j.util.ColorSpaces;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.math.GDTFVector3f;

public class ColorSpace {

	public static ColorSpace ADOBE_SRGB = new ColorSpace(ColorSpaces.SRGB, new GDTFVector3f(0.6400f, 0.3300f, 0.2126f),
			new GDTFVector3f(0.3000f, 0.6000f, 0.7152f), new GDTFVector3f(0.1500f, 0.0600f, 0.0722f),
			new GDTFVector3f(0.3127f, 0.3290f, 1.0000f));

	public static ColorSpace KODAK_PROPHOTO = new ColorSpace(ColorSpaces.PROPHOTO,
			new GDTFVector3f(0.7347f, 0.2653f, 0f), new GDTFVector3f(0.7347f, 0.2653f, 0f),
			new GDTFVector3f(0.0366f, 0.0001f, 0f), new GDTFVector3f(0.3457f, 0.3585f, 0f));

	public static ColorSpace ANSI = new ColorSpace(ColorSpaces.ANSI, new GDTFVector3f(0.7347f, 0.2653f, 0f),
			new GDTFVector3f(0.1596f, 0.8404f, 0f), new GDTFVector3f(0.0366f, 0.001f, 0f),
			new GDTFVector3f(0.4254f, 0.4044f, 0f));

	private ColorSpaces colorSpace = ColorSpaces.SRGB;
	private GDTFVector3f red;
	private GDTFVector3f green;
	private GDTFVector3f blue;
	private GDTFVector3f whitePoint;

	public ColorSpace(String colorSpace, String red, String green, String blue, String whitePoints) {
		this.colorSpace = ColorSpaces.valueOf(colorSpace.toUpperCase());
		this.red = GDTFVector3f.fromString(red);
		this.green = GDTFVector3f.fromString(green);
		this.blue = GDTFVector3f.fromString(blue);
		this.whitePoint = GDTFVector3f.fromString(whitePoints);
	}

	public ColorSpace(ColorSpaces colorSpace, GDTFVector3f red, GDTFVector3f green, GDTFVector3f blue,
			GDTFVector3f whitePoints) {
		this.colorSpace = colorSpace;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.whitePoint = whitePoints;
	}
	
	public ColorSpace(Node node) {
		NamedNodeMap map = node.getAttributes();
		String mode = GDTFUtil.getItemNullSave(map, "Mode");
		if(!mode.isBlank())
			colorSpace = ColorSpaces.valueOf(mode.toUpperCase());
		if(colorSpace ==  ColorSpaces.CUSTOM) {
			red = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "Red"));
			green = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "Green"));
			blue = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "Blue"));
			whitePoint = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "WhitePoint"));	
		}
	}

	public ColorSpaces getColorSpace() {
		return colorSpace;
	}

	public GDTFVector3f getRed() {
		return red;
	}

	public GDTFVector3f getGreen() {
		return green;
	}

	public GDTFVector3f getBlue() {
		return blue;
	}

	public GDTFVector3f getWhitePoint() {
		return whitePoint;
	}

}
