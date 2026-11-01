package de.verschwiegener.gdtf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.model.GdtfModel;
import de.verschwiegener.gdtf.model.GdtfWheel;

/**
 * A read GDTF file: the fixture type and all other files of the archive (models, wheel images, thumbnail). The
 * archive stays in memory, files are unpacked when they are read. Immutable, safe to share between threads.
 */
public final class GdtfArchive {

	private final GdtfFixtureType fixtureType;
	private final ZipArchive zip;
	private final List<String> warnings;

	GdtfArchive(GdtfFixtureType fixtureType, ZipArchive zip, List<String> warnings) {
		this.fixtureType = Objects.requireNonNull(fixtureType, "fixtureType");
		this.zip = zip;
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
		SortedSet<String> names = new TreeSet<>(zip.names());
		names.remove(GdtfReader.DESCRIPTION);
		return names;
	}

	public boolean hasResource(String name) {
		return !GdtfReader.DESCRIPTION.equals(name) && zip.contains(name);
	}

	/**
	 * @throws NoSuchFileException if the archive has no such file
	 * @throws GdtfException       if the file is broken inside the archive
	 */
	public InputStream openResource(String name) throws IOException {
		return new ByteArrayInputStream(readResource(name));
	}

	/**
	 * @return The file content, unpacked on every call
	 * @throws NoSuchFileException if the archive has no such file
	 * @throws GdtfException       if the file is broken inside the archive
	 */
	public byte[] readResource(String name) throws IOException {
		if (!hasResource(name))
			throw new NoSuchFileException(name);
		return zip.read(name);
	}

	/**
	 * @return The files of the thumbnail, e.g. "thumbnail.png" and "thumbnail.svg". Empty if the type has none.
	 */
	public List<String> thumbnailFiles() {
		String thumbnail = fixtureType.thumbnail();
		return thumbnail == null ? List.of() : find(name -> !name.contains("/") && baseName(name).equals(thumbnail));
	}

	/**
	 * @return The files of a model in all formats and views, e.g. "models/gltf/head.glb" and
	 *         "models/3ds/head.3ds". Empty for primitives or missing files.
	 */
	public List<String> modelFiles(GdtfModel model) {
		return model.file() == null ? List.of()
				: find(name -> name.startsWith("models/") && baseName(name).equals(model.file()));
	}

	/**
	 * @return The image of a wheel slot, e.g. "wheels/15020363.png"
	 */
	public Optional<String> wheelImage(GdtfWheel.Slot slot) {
		String media = slot.mediaFileName();
		if (media == null)
			return Optional.empty();
		if (hasResource("wheels/" + media))
			return Optional.of("wheels/" + media);
		return find(name -> name.startsWith("wheels/") && baseName(name).equals(media)).stream().findFirst();
	}

	private List<String> find(Predicate<String> filter) {
		return resourceNames().stream().filter(filter).toList();
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
		return "GdtfArchive[" + fixtureType.manufacturer() + " " + fixtureType.name() + ", "
				+ resourceNames().size() + " files]";
	}

}
