package de.verschwiegener.gdtf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.verschwiegener.gdtf.model.GdtfChannelFunction;
import de.verschwiegener.gdtf.model.GdtfDmxChannel;
import de.verschwiegener.gdtf.model.GdtfDmxMode;
import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.model.GdtfGeometry;
import de.verschwiegener.gdtf.model.GdtfLogicalChannel;
import de.verschwiegener.gdtf.model.GdtfWheel;

class GdtfReaderTest {

	private static GdtfArchive archive;
	private static GdtfFixtureType type;
	private static GdtfDmxMode mode;

	@BeforeAll
	static void read() throws Exception {
		archive = GdtfReader.create().read(new ByteArrayInputStream(TestGdtf.archive()));
		type = archive.fixtureType();
		mode = type.mode("Standard").orElseThrow();
	}

	private static GdtfDmxChannel channel(String name) {
		return mode.channel(name).orElseThrow(() -> new AssertionError("No channel " + name + " in "
				+ mode.channels().stream().map(GdtfDmxChannel::name).toList()));
	}

	@Test
	void readsFixtureType() {
		assertEquals("1.2", type.dataVersion());
		assertEquals("11111111-2222-3333-4444-555555555555", type.fixtureTypeId());
		assertEquals("Test Spot", type.name());
		assertEquals("Zeus", type.manufacturer());
		assertNull(type.refFT());
		assertEquals(List.of("PanTilt"), type.activationGroups());
		assertEquals("2024-01-01T10:00:00", type.revisions().get(0).date());
		assertEquals("sRGB", type.colorSpace().mode());
	}

	@Test
	void splitsFeatureOfAttribute() {
		var pan = type.attribute("Pan").orElseThrow();
		assertEquals("Position", pan.featureGroup());
		assertEquals("PanTilt", pan.feature());
		assertEquals("PanTilt", pan.activationGroup());
		assertEquals("Angle", pan.physicalUnit());
		assertEquals(0.64, type.attribute("ColorAdd_R").orElseThrow().color().x());
	}

	@Test
	void sixteenBitValuesUseByteMirroring() {
		GdtfDmxChannel dimmer = channel("Base_Dimmer");
		assertEquals(List.of(1, 2), dimmer.offsets());
		assertEquals(2, dimmer.bytes());
		// "128/1" on 16 bit is 0x8080
		assertEquals(0x8080, dimmer.defaultValue());
		assertEquals(65535L, dimmer.highlight());
		GdtfChannelFunction function = dimmer.functions().get(0);
		assertEquals(0, function.dmxFrom());
		assertEquals(65535, function.dmxTo());
		assertEquals(100, function.physicalTo());
		assertEquals(GdtfLogicalChannel.Master.GRAND, dimmer.logicalChannels().get(0).master());
	}

	@Test
	void functionsAndSetsEndAtTheNextOne() {
		GdtfDmxChannel gobo = channel("Beam_Gobo1");
		List<GdtfChannelFunction> functions = gobo.functions();
		assertEquals(127, functions.get(0).dmxTo());
		assertEquals(128, functions.get(1).dmxFrom());
		assertEquals(255, functions.get(1).dmxTo());
		assertEquals(List.of(0L, 10L), functions.get(0).sets().stream().map(s -> s.dmxFrom()).toList());
		assertEquals(List.of(9L, 127L), functions.get(0).sets().stream().map(s -> s.dmxTo()).toList());
		assertEquals(2, functions.get(0).sets().get(1).wheelSlotIndex());
	}

	@Test
	void referencesAreResolvedToObjects() {
		GdtfChannelFunction gobo = channel("Beam_Gobo1").functions().get(0);
		assertEquals("Gobo1", gobo.wheel().name());
		GdtfChannelFunction red = channel("Pixel 1_ColorAdd_R").functions().get(0);
		assertEquals(630.0, red.emitter().dominantWaveLength());
		assertNull(red.wheel());
		assertTrue(archive.warnings().stream().anyMatch(w -> w.contains("unknown wheel Missing")),
				archive.warnings().toString());
	}

	@Test
	void initialFunctionGivesTheDefault() {
		GdtfDmxChannel gobo = channel("Beam_Gobo1");
		assertEquals("Spin", gobo.initialFunction().name());
		assertEquals(200, gobo.defaultValue());
		// without InitialFunction the first function is the initial one
		assertEquals("Pan", channel("Yoke_Pan").initialFunction().name());
		assertNull(channel("Yoke_Pan").highlight());
		assertEquals(GdtfLogicalChannel.Snap.YES, channel("Yoke_Pan").logicalChannels().get(0).snap());
	}

	@Test
	void modeMasterRangesUseTheResolutionOfTheMaster() {
		List<GdtfChannelFunction> functions = channel("Base_Control1").functions();
		// both start at 0 in different master ranges, so both run to the end
		assertEquals(255, functions.get(0).dmxTo());
		assertEquals(255, functions.get(1).dmxTo());
		assertEquals("Base_Dimmer", functions.get(0).modeMaster());
		assertEquals(0x7f7f, functions.get(0).modeTo());
		assertEquals(0x8080, functions.get(1).modeFrom());
		assertEquals(0xffff, functions.get(1).modeTo());
	}

	@Test
	void virtualChannelTakesResolutionFromItsValues() {
		GdtfDmxChannel virtual = channel("Yoke_Control1");
		assertTrue(virtual.isVirtual());
		assertEquals(2, virtual.bytes());
		assertEquals(65535, virtual.defaultValue());
		assertEquals("Control1 1", virtual.functions().get(0).name());
	}

	@Test
	void referencedGeometryChannelsAreRepeatedPerReference() {
		assertEquals("Pixel", channel("Pixel 1_ColorAdd_R").geometry());
		assertEquals("Pixel 1", channel("Pixel 1_ColorAdd_R").reference());
		// first Break for break 1 of the template, second for break 2, last for "Overwrite"
		assertChannel("Pixel 1_ColorAdd_R", 1, 20);
		assertChannel("Pixel 2_ColorAdd_R", 1, 23);
		assertChannel("Pixel 1_Dimmer", 2, 1);
		assertChannel("Pixel 2_Dimmer", 2, 4);
		assertChannel("Pixel 1_Control1", 1, 30);
		assertChannel("Pixel 2_Control1", 1, 31);
		// the template itself is no channel of the mode
		assertTrue(mode.channel("Pixel_ColorAdd_R").isEmpty());
	}

	private static void assertChannel(String name, int dmxBreak, int offset) {
		GdtfDmxChannel channel = channel(name);
		assertEquals(dmxBreak, channel.dmxBreak(), name);
		assertEquals(List.of(offset), channel.offsets(), name);
	}

	@Test
	void footprintPerBreak() {
		assertEquals(Set.of(1, 2), mode.breaks());
		assertEquals(31, mode.footprint(1));
		assertEquals(4, mode.footprint(2));
		assertEquals(0, mode.footprint(3));
		assertEquals("Yoke_Control1", mode.relations().get(0).master());
	}

	@Test
	void geometryTreeKeepsPartsWithoutModel() {
		GdtfGeometry base = type.geometries().get(0);
		GdtfGeometry yoke = base.children().get(0);
		assertEquals(GdtfGeometry.Type.AXIS, yoke.type());
		assertNull(yoke.model());
		assertEquals(-0.1, yoke.position().translation()[2]);
		assertEquals(List.of("Beam", "Laser"), yoke.children().stream().map(GdtfGeometry::name).toList());
		assertEquals(20, yoke.children().get(0).beam().beamAngle());
		// Laser is a geometry with name and position since the schema fix
		GdtfGeometry laser = type.geometry("Laser").orElseThrow();
		assertEquals(GdtfGeometry.Type.LASER, laser.type());
		assertEquals(0.5, laser.position().translation()[0]);
		GdtfGeometry reference = type.geometry("Pixel 2").orElseThrow();
		assertEquals("Pixel", reference.reference().geometry());
		assertEquals(3, reference.reference().breaks().size());
	}

	@Test
	void findsFilesOfTheArchive() throws Exception {
		assertEquals(List.of("thumbnail.png", "thumbnail.svg"), archive.thumbnailFiles());
		var base = type.model("Base").orElseThrow();
		assertEquals(List.of("models/3ds/base.3ds", "models/gltf/base.glb"), archive.modelFiles(base));
		assertTrue(archive.modelFiles(type.model("Head").orElseThrow()).isEmpty());
		GdtfWheel.Slot dots = type.wheel("Gobo1").orElseThrow().slot(2).orElseThrow();
		assertEquals("wheels/dots.png", archive.wheelImage(dots).orElseThrow());
		assertArrayEquals(new byte[] { 5 }, archive.readResource("wheels/dots.png"));
		assertFalse(archive.resourceNames().contains("description.xml"));
	}

	@Test
	void toleratesPaddingAfterTheRootElement() throws Exception {
		byte[] archive = TestGdtf.withDescription(TestGdtf.DESCRIPTION + "\0\0");
		assertEquals("Test Spot", GdtfReader.create().read(new ByteArrayInputStream(archive)).fixtureType().name());
	}

	@Test
	void validatingReaderAcceptsValidFile() throws Exception {
		// the reference to the unknown wheel is the only deviation from the schema
		String valid = TestGdtf.DESCRIPTION.replace(" Wheel=\"Missing\"", "");
		GdtfArchive validated = GdtfReader.create().validating(true)
				.read(new ByteArrayInputStream(TestGdtf.withDescription(valid)));
		assertEquals("Test Spot", validated.fixtureType().name());
		assertThrows(GdtfException.class, () -> GdtfReader.create().validating(true)
				.read(new ByteArrayInputStream(TestGdtf.archive())));
	}

	@Test
	void unknownElementsAreWarningsUnlessValidating() throws Exception {
		String extended = TestGdtf.DESCRIPTION.replace("<Revisions>", "<FutureElement/>\n    <Revisions>");
		GdtfArchive lenient = GdtfReader.create().read(new ByteArrayInputStream(TestGdtf.withDescription(extended)));
		assertTrue(lenient.warnings().stream().anyMatch(w -> w.contains("FutureElement")), lenient.warnings().toString());

		assertThrows(GdtfException.class, () -> GdtfReader.create().validating(true)
				.read(new ByteArrayInputStream(TestGdtf.withDescription(extended))));
	}

	@Test
	void invalidDmxValueNamesTheElement() {
		String broken = TestGdtf.DESCRIPTION.replace("DMXFrom=\"128/1\" Default=\"200/1\"", "DMXFrom=\"x/1\"");
		GdtfException e = assertThrows(GdtfException.class,
				() -> GdtfReader.create().read(new ByteArrayInputStream(TestGdtf.withDescription(broken))));
		assertTrue(e.getMessage().contains("DMXChannel Beam_Gobo1"), e.getMessage());
		assertTrue(e.getMessage().contains("ChannelFunction Spin"), e.getMessage());
	}

	@Test
	void brokenChannelSetIsSkipped() throws Exception {
		String broken = TestGdtf.DESCRIPTION.replace("<ChannelSet Name=\"Dots\" DMXFrom=\"10/1\"",
				"<ChannelSet Name=\"Dots\" DMXFrom=\"6D6D\"");
		GdtfArchive read = GdtfReader.create().read(new ByteArrayInputStream(TestGdtf.withDescription(broken)));
		var sets = read.fixtureType().mode("Standard").orElseThrow().channel("Beam_Gobo1").orElseThrow().functions()
				.get(0).sets();
		assertEquals(List.of("Open"), sets.stream().map(s -> s.name()).toList());
		assertEquals(127, sets.get(0).dmxTo());
	}

	@Test
	void rejectsFilesThatAreNoGdtf() {
		assertThrows(GdtfException.class,
				() -> GdtfReader.create().read(new ByteArrayInputStream("no zip".getBytes(StandardCharsets.UTF_8))));
		assertThrows(GdtfException.class, () -> GdtfReader.create()
				.read(new ByteArrayInputStream(TestGdtf.zip(Map.of("other.xml", new byte[] { 1 })))));
		assertThrows(GdtfException.class, () -> GdtfReader.create()
				.read(new ByteArrayInputStream(TestGdtf.withDescription("<GDTF DataVersion=\"1.2\">"))));
	}

	@Test
	void rejectsDoctypeAndExternalEntities() {
		String xxe = """
				<?xml version="1.0"?>
				<!DOCTYPE GDTF [<!ENTITY secret SYSTEM "file:///etc/passwd">]>
				<GDTF DataVersion="1.2"><FixtureType Name="&secret;"/></GDTF>
				""";
		assertThrows(GdtfException.class,
				() -> GdtfReader.create().read(new ByteArrayInputStream(TestGdtf.withDescription(xxe))));
	}

	@Test
	void readsFromSeveralThreadsAtOnce() {
		GdtfReader reader = GdtfReader.create();
		byte[] file = TestGdtf.archive();
		List<Integer> footprints = java.util.stream.IntStream.range(0, 16).parallel().mapToObj(i -> {
			try {
				return reader.read(new ByteArrayInputStream(file)).fixtureType().mode("Standard").orElseThrow()
						.footprint(1);
			} catch (java.io.IOException e) {
				throw new java.io.UncheckedIOException(e);
			}
		}).toList();
		assertEquals(List.of(31), footprints.stream().distinct().toList());
	}

	@Test
	void limitsUnpackedSize() {
		assertThrows(GdtfException.class,
				() -> GdtfReader.create().withMaxSize(100).read(new ByteArrayInputStream(TestGdtf.archive())));
	}

}
