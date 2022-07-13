package de.verschwiegener.gdtf4j.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.verschwiegener.gdtf4j.GDTF;
import de.verschwiegener.gdtf4j.GDTFClass;
import de.verschwiegener.gdtf4j.util.exception.GDTFExceptionTemplate;

public class GDTFUtil {

	public static ByteBuffer loadImage(File imageFile) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new FileInputStream(imageFile));
		} catch (IOException e) {
			throw GDTFExceptionTemplate.FAILED_TO_LOAD_IMAGE.create(e, e.getMessage());
		}

		int pixels[] = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

		ByteBuffer buffer = ByteBuffer.allocateDirect(image.getWidth() * image.getHeight() * 4);

		for (int h = 0; h < image.getHeight(); h++) {
			for (int w = 0; w < image.getWidth(); w++) {
				int pixel = pixels[h * image.getWidth() + w];

				buffer.put((byte) ((pixel >> 16) & 0xFF));
				buffer.put((byte) ((pixel >> 8) & 0xFF));
				buffer.put((byte) (pixel & 0xFF));
				buffer.put((byte) ((pixel >> 24) & 0xFF));
			}
		}

		buffer.flip();
		return buffer;
	}

	public static NodeList getChildren(Element e, String parentName, String name) {
		return ((Element) e.getElementsByTagName(parentName).item(0)).getElementsByTagName(name);
	}

	public static String getItemNullSave(NamedNodeMap map, String name) {
		Node node = map.getNamedItem(name);
		if (node != null)
			return node.getNodeValue();
		return "";
	}

	public static float getFloatNullSave(NamedNodeMap map, String name, float defaultValue) {
		String item = getItemNullSave(map, name);
		if (!item.isEmpty())
			return Float.valueOf(item);
		else
			return defaultValue;
	}

	public static float getFloatNullSave(Node map, String name, float defaultValue) {
		String item = getItemNullSave(map.getAttributes(), name);
		if (!item.isEmpty())
			return Float.valueOf(item);
		else
			return defaultValue;
	}

	public static int getIntegerNullSave(Node map, String name, int defaultValue) {
		String item = getItemNullSave(map.getAttributes(), name);
		if (!item.isEmpty())
			return Integer.valueOf(item);
		else
			return defaultValue;
	}

	public static int getIntegerNullSave(NamedNodeMap map, String name, int defaultValue) {
		String item = getItemNullSave(map, name);
		if (!item.isEmpty())
			return Integer.valueOf(item);
		else
			return defaultValue;
	}

	public static byte getByteNullSave(NamedNodeMap map, String name, byte defaultValue) {
		String item = getItemNullSave(map, name);
		if (!item.isEmpty())
			return Byte.valueOf(item);
		else
			return defaultValue;
	}

	public static byte getByteNullSave(Node map, String name, byte defaultValue) {
		String item = getItemNullSave(map.getAttributes(), name);
		if (!item.isEmpty())
			return Byte.valueOf(item);
		else
			return defaultValue;
	}

	public static String getItemNullSave(Node map, String name) {
		Node node = map.getAttributes().getNamedItem(name);
		if (node != null)
			return node.getNodeValue();
		return "";
	}

	/*public static <T> void addChildrenToArrayList(Class<T> childClass, ArrayList<T> target, Node node,
			String parentName, String name) {
		try {
			NodeList list = GDTFUtil.getChildren((Element) node, parentName, name);
			for (int i = 0; i < list.getLength(); i++) {
				target.add(childClass.getDeclaredConstructor(Node.class).newInstance(list.item(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void addChildrenToArrayListGDTF(Class<T> childClass, ArrayList<T> target, Node node,
			String parentName, String name, GDTF gdtf) {
		try {
			NodeList list = GDTFUtil.getChildren((Element) node, parentName, name);
			for (int i = 0; i < list.getLength(); i++) {
				target.add(
						childClass.getDeclaredConstructor(Node.class, gdtf.getClass()).newInstance(list.item(i), gdtf));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> void addChildrenToArrayList(Class<T> childClass, ArrayList<T> target, Node node,
			String parentName, String name, File gdtfFile) {
		try {
			NodeList list = GDTFUtil.getChildren((Element) node, parentName, name);
			for (int i = 0; i < list.getLength(); i++) {
				target.add(
						childClass.getDeclaredConstructor(Node.class, File.class).newInstance(list.item(i), gdtfFile));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static <T> void addChildrenToArrayList(Class<T> childClass, ArrayList<T> target, Node node,
			String parentName, String name, GDTF gdtf) {
		try {
			NodeList list = GDTFUtil.getChildren((Element) node, parentName, name);
			for (int i = 0; i < list.getLength(); i++) {
				target.add((T) ((GDTFClass) childClass.getDeclaredConstructor().newInstance()).fromXML(list.item(i), gdtf));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static <T> void addChildrenToArrayList(Class<T> childClass, ArrayList<T> target, Node node, String name, GDTF gdtf) {
		try {
			NodeList list = ((Element) node).getElementsByTagName(name);
			for (int i = 0; i < list.getLength(); i++) {
				target.add((T) ((GDTFClass) childClass.getDeclaredConstructor().newInstance()).fromXML(list.item(i), gdtf));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void unzipFile(File gdtfFile, File gdtfFolder) throws IOException {
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(gdtfFile));
		ZipEntry zipEntry = zis.getNextEntry();
		while (zipEntry != null) {
			File newFile = newFile(gdtfFolder, zipEntry);
			if (zipEntry.isDirectory()) {
				if (!newFile.isDirectory() && !newFile.mkdirs()) {
					throw new IOException("Failed to create directory " + newFile);
				}
			} else {
				// fix for Windows-created archives
				File parent = newFile.getParentFile();
				if (!parent.isDirectory() && !parent.mkdirs()) {
					throw new IOException("Failed to create directory " + parent);
				}

				// write file content
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			}
			zipEntry = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
	}

	public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
		File destFile = new File(destinationDir, zipEntry.getName());

		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
		}

		return destFile;
	}
}
