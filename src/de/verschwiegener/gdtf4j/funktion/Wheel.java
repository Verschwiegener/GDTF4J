package de.verschwiegener.gdtf4j.funktion;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.GDTFUtil;
import de.verschwiegener.gdtf4j.util.GenericNameNode;
import de.verschwiegener.gdtf4j.util.math.GDTFMatrix3f;
import de.verschwiegener.gdtf4j.util.math.GDTFVector3f;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.getItemNullSave;

import static de.verschwiegener.gdtf4j.util.GDTFUtil.addChildrenToArrayList;

public class Wheel extends GenericNameNode {

	private static File wheelFolder;
	private ArrayList<WheelSlot> wheelSlots = new ArrayList<Wheel.WheelSlot>();
	
	public Wheel() {
	}
	
	@Override
	public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
		super.fromXML(node, gdtf);
		wheelFolder = new File(gdtf.gdtfFolder, "wheels");

		NodeList list = ((Element) node).getElementsByTagName("Slot");
		for (int i = 0; i < list.getLength(); i++) {
			WheelSlot ws = new WheelSlot();
			ws.fromXML(list.item(i), gdtf);
			wheelSlots.add(ws);
		}
		return getClass();
	}

	public void addWheelSlot(WheelSlot slot) {
		wheelSlots.add(slot);
	}

	public ArrayList<WheelSlot> getSlots() {
		return wheelSlots;
	}

	class WheelSlot extends GenericNameNode {

		/**
		 * Optional link to filter in the physical description; Do not define color if
		 * filter is used;
		 */
		private String filter;
		/**
		 * Color of the wheel slot, Default value: {0.3127, 0.3290, 100.0} (white) For Y
		 * give relative value compared to overall output defined in property Luminous
		 * Flux of related Beam Geometry (transmissive case).
		 */
		private GDTFVector3f color;
		/**
		 * Optional; PNG file name without extension containing image for specific gobos
		 * etc. These resource files are located in a folder called ./wheels in the zip
		 * archive. Default value: empty;
		 */
		private ByteBuffer mediaFile;
		private ArrayList<Facet> facets = new ArrayList<Facet>();
		private ArrayList<AnimationSystem> animationSystem = new ArrayList<AnimationSystem>();
		
		public WheelSlot() {
		}
		
		@Override
		public Class<? extends GDTFClass> fromXML(Node node, GDTF gdtf) {
			super.fromXML(node, gdtf);
			NamedNodeMap map = node.getAttributes();
			filter = GDTFUtil.getItemNullSave(map, "Filter");
			if (filter.equals(""))
				color = GDTFVector3f.fromString(getItemNullSave(map, "Color"));
			else
				color = GDTFVector3f.NULL;
			String mediaFile = getItemNullSave(map, "MediaFile");
			if (!mediaFile.isEmpty())
				this.mediaFile = GDTFUtil.loadImage(new File(wheelFolder, mediaFile));

			NodeList list = ((Element) node).getElementsByTagName("Facet");
			for (int i = 0; i < list.getLength(); i++) {
				facets.add(new Facet(list.item(i)));
			}
			NodeList list2 = ((Element) node).getElementsByTagName("AnimationSystem");
			for (int i = 0; i < list2.getLength(); i++) {
				animationSystem.add(new AnimationSystem(list2.item(i)));
			}
			return getClass();
		}

		public void addFacet(String color, String rotation) {
			facets.add(new Facet(color, rotation));
		}

		public void addAnimation(String p1, String p2, String p3, String radius) {
			animationSystem.add(new AnimationSystem(p1, p2, p3, radius));
		}

		public String getFilter() {
			return filter;
		}

		public GDTFVector3f getColor() {
			return color;
		}

		public ArrayList<Facet> getFacets() {
			return facets;
		}

		public ArrayList<AnimationSystem> getAnimationSystem() {
			return animationSystem;
		}

		class Facet {
			/**
			 * Color of prism facet, Default value: {0.3127, 0.3290, 100.0} (white)
			 */
			private final GDTFVector3f color;
			/**
			 * Specify the rotation, translation and scaling for the facet.
			 */
			private final GDTFMatrix3f rotation;

			public Facet(String color, String rotation) {
				this.color = GDTFVector3f.fromString(color);
				this.rotation = GDTFMatrix3f.fromString(rotation);
			}

			public Facet(Node node) {
				NamedNodeMap map = node.getAttributes();
				color = GDTFVector3f.fromString(GDTFUtil.getItemNullSave(map, "Color"));
				rotation = GDTFMatrix3f.fromString(GDTFUtil.getItemNullSave(map, "Rotation"));
			}

			public GDTFVector3f getColor() {
				return color;
			}

			public GDTFMatrix3f getRotation() {
				return rotation;
			}

		}

		class AnimationSystem {
			/**
			 * First Point of the Spline describing the path of animation system in the beam
			 * in relation to the middle of the Media File
			 */
			private final float[] p1;
			/**
			 * Second Point of the Spline describing the path of animation system in the
			 * beam in relation to the middle of the Media File
			 */
			private final float[] p2;
			/**
			 * Third Point of the Spline describing the path of animation system in the beam
			 * in relation to the middle of the Media File
			 */
			private final float[] p3;
			/**
			 * Radius of the circle that defines the section of the Animation system which
			 * will be shown in the beam.
			 */
			private final float radius;

			public AnimationSystem(String p1, String p2, String p3, String radius) {
				this.p1 = convertToArray(p1);
				this.p2 = convertToArray(p2);
				this.p3 = convertToArray(p3);
				this.radius = Integer.valueOf(radius);
			}

			public AnimationSystem(Node node) {
				NamedNodeMap map = node.getAttributes();
				this.p1 = convertToArray(getItemNullSave(map, "P1"));
				this.p2 = convertToArray(getItemNullSave(map, "P2"));
				this.p3 = convertToArray(getItemNullSave(map, "P3"));
				radius = Float.valueOf(getItemNullSave(map, "Radius"));
			}

			private float[] convertToArray(String in) {
				float[] out = new float[2];
				if (in.isBlank() || !in.contains("."))
					return out;
				String[] component = in.split(",");
				out[0] = Float.parseFloat(component[0]);
				out[1] = Float.parseFloat(component[1]);
				return out;

			}

			public float[] getP1() {
				return p1;
			}

			public float[] getP2() {
				return p2;
			}

			public float[] getP3() {
				return p3;
			}

			public float getRadius() {
				return radius;
			}

		}
	}

}
