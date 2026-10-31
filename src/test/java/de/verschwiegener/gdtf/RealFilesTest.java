package de.verschwiegener.gdtf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import de.verschwiegener.gdtf.model.GdtfDmxChannel;
import de.verschwiegener.gdtf.model.GdtfDmxMode;

/**
 * Reads real GDTF files, e.g. from GDTF-Share. They are not part of the repository, point the system property
 * {@code gdtf.samples} to a folder with .gdtf files: {@code mvn test -Dgdtf.samples=/path/to/gdtfs}
 */
class RealFilesTest {

	private static final Pattern CHANNEL_COUNT = Pattern.compile("(\\d+)\\s*(ch|CH|Ch|channel|Channel)\\b");

	@Test
	void readsAllSampleFiles() throws IOException {
		String folder = System.getProperty("gdtf.samples", "");
		Assumptions.assumeTrue(!folder.isBlank() && !folder.startsWith("${") && Files.isDirectory(Path.of(folder)),
				"No sample folder given in gdtf.samples");
		List<Path> files;
		try (Stream<Path> walk = Files.walk(Path.of(folder))) {
			files = walk.filter(path -> path.toString().toLowerCase().endsWith(".gdtf")).sorted().toList();
		}
		assertFalse(files.isEmpty(), "No .gdtf files in " + folder);

		List<String> problems = new ArrayList<>();
		int read = 0;
		for (Path file : files) {
			GdtfArchive archive;
			try {
				archive = GdtfReader.create().read(file);
				read++;
			} catch (GdtfException e) {
				// a file the reader rejects must at least say why
				assertFalse(e.getMessage().isBlank(), file.toString());
				continue;
			} catch (Exception e) {
				problems.add(file.getFileName() + ": unexpected " + e);
				continue;
			}
			for (GdtfDmxMode mode : archive.fixtureType().modes()) {
				checkMode(file, mode, problems);
			}
		}
		System.out.println("Read " + read + " of " + files.size() + " sample files");
		if (!problems.isEmpty())
			fail(problems.size() + " problems:\n" + String.join("\n", problems));
	}

	private static void checkMode(Path file, GdtfDmxMode mode, List<String> problems) {
		// many modes name their channel count, e.g. "Standard (32 ch)"
		Matcher count = CHANNEL_COUNT.matcher(mode.name());
		int footprint = mode.breaks().stream().mapToInt(mode::footprint).sum();
		if (count.find() && Integer.parseInt(count.group(1)) != footprint)
			problems.add(file.getFileName() + " / " + mode.name() + ": footprint " + footprint);
		for (GdtfDmxChannel channel : mode.channels()) {
			for (var function : channel.functions()) {
				if (function.dmxFrom() > function.dmxTo() || function.dmxTo() > channel.maxValue())
					problems.add(file.getFileName() + " / " + mode.name() + " / " + channel.name() + " / "
							+ function.name() + ": range " + function.dmxFrom() + ".." + function.dmxTo());
			}
			assertEquals(channel.isVirtual() ? 0 : channel.bytes(), channel.offsets().size());
		}
	}

}
