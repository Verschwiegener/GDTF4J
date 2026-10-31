package de.verschwiegener.gdtf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.model.GdtfModel;
import de.verschwiegener.gdtf.model.GdtfWheel;

/**
 * A read GDTF file: the fixture type and all other files of the archive (models, wheel images, thumbnail), held
 * in memory. Immutable, safe to share between threads.
 */
public final class GdtfArchive {

	private final GdtfFixtureType fixtureType;
	private final Map<String, byte[]> resources;
	private final List<String> warnings;

	GdtfArchive(GdtfFixtureType fixtureType, Map<String, byte[]> resources, List<String> warnings) {
		this.fixtureType = Objects.requireNonNull(fixtureType, "fixtureType");
		this.resources = Map.copyOf(resources);
		this.warnings = List.copyOf(warnings);
	}

	public GdtfFixtureType fixtureType() {
		return fixtureType;
	}

	/**
	 * @return Problems that were tolerated while reading, e.g. a reference to an unknown wheel. Empty for a clean
	 *         file.
	 */
	public List<String> warnings() {
		return warnings;
	}

	/**
	 * @return Paths of all files in the archive except description.xml, e.g. "models/gltf/head.glb"
	 */
	public SortedSet<String> resourceNames() {
		return new TreeSet<>(resources.keySet());
	}

	public boolean hasResource(String name) {
		return resources.containsKey(name);
	}

	/**
	 * @throws NoSuchFileException if the archive has no such file
	 */
	public InputStream openResource(String name) throws NoSuchFileException {
		return new ByteArrayInputStream(resource(name));
	}

	/**
	 * @return A copy of the file content
	 * @throws NoSuchFileException if the archive has no such file
	 */
	public byte[] readResource(String name) throws NoSuchFileException {
		return resource(name).clone();
	}

	/**
	 * @return The files of the thumbnail, e.g. "thumbnail.png" and "thumbnail.svg". Empty if the type has none.
	 */
	public List<String> thumbnailFiles() {
		String thumbnail = fixtureType.thumbnail();
		if (thumbnail == null)
			return List.of();
		return resources.keySet().stream().filter(name -> baseName(name).equals(thumbnail) && !name.contains("/"))
				.sorted().toList();
	}

	/**
	 * @return The files of a model in all formats and views, e.g. "models/gltf/head.glb" and
	 *         "models/3ds/head.3ds". Empty for primitives or missing files.
	 */
	public List<String> modelFiles(GdtfModel model) {
		if (model.file() == null)
			return List.of();
		return resources.keySet().stream()
				.filter(name -> name.startsWith("models/") && baseName(name).equals(model.file())).sorted().toList();
	}

	/**
	 * @return The image of a wheel slot, e.g. "wheels/15020363.png"
	 */
	public Optional<String> wheelImage(GdtfWheel.Slot slot) {
		String media = slot.mediaFileName();
		if (media == null)
			return Optional.empty();
		if (resources.containsKey("wheels/" + media))
			return Optional.of("wheels/" + media);
		return resources.keySet().stream()
				.filter(name -> name.startsWith("wheels/") && baseName(name).equals(media)).sorted().findFirst();
	}

	private byte[] resource(String name) throws NoSuchFileException {
		byte[] data = resources.get(name);
		if (data == null)
			throw new NoSuchFileException(name);
		return data;
	}

	/**
	 * @return File name without folder and extension, "models/gltf/Head.glb" gives "Head"
	 */
	private static String baseName(String path) {
		String name = path.substring(path.lastIndexOf('/') + 1);
		int dot = name.lastIndexOf('.');
		return dot > 0 ? name.substring(0, dot) : name;
	}

	@Override
	public String toString() {
		return "GdtfArchive[" + fixtureType.manufacturer() + " " + fixtureType.name() + ", " + resources.size()
				+ " files]";
	}

}
