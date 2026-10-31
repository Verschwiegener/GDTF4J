package de.verschwiegener.gdtf.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValuesTest {

	@Test
	void dmxValueInChannelResolution() {
		assertEquals(128, DmxValue.parse("128/1", 1));
		assertEquals(32768, DmxValue.parse("32768/2", 2));
		// mirroring by default, shifting with "s"
		assertEquals(65535, DmxValue.parse("255/1", 2));
		assertEquals(0x8080, DmxValue.parse("128/1", 2));
		assertEquals(0xff00, DmxValue.parse("255/1s", 2));
		assertEquals(0xffffff, DmxValue.parse("255/1", 3));
		assertEquals(0x12341234L, DmxValue.parse("4660/2", 4));
		// more bytes than the channel are shifted down
		assertEquals(128, DmxValue.parse("32768/2", 1));
		// plain numbers are already in channel resolution
		assertEquals(300, DmxValue.parse("300", 2));
		assertEquals(255, DmxValue.parse("300", 1));
	}

	@Test
	void dmxValueSpecialCases() {
		assertNull(DmxValue.parseOptional("None", 1));
		assertNull(DmxValue.parseOptional(null, 1));
		assertEquals(65535, DmxValue.max(2));
		assertEquals(0xffffffffL, DmxValue.max(4));
		assertEquals(2, DmxValue.byteCount("1/2"));
		assertEquals(1, DmxValue.byteCount("12"));
		assertThrows(IllegalArgumentException.class, () -> DmxValue.parse("6D6D6D", 1));
		assertThrows(IllegalArgumentException.class, () -> DmxValue.parse("1/5", 1));
		assertThrows(IllegalArgumentException.class, () -> DmxValue.parse("1/1", 5));
	}

	@Test
	void matrixIsReadRowByRow() {
		GdtfMatrix matrix = GdtfMatrix.parse("{1,0,0,0.5}{0,1,0,-0.25}{0,0,1,2}{0,0,0,1}");
		assertEquals(4, matrix.rows());
		assertArrayEquals(new double[] { 0.5, -0.25, 2 }, matrix.translation());
		assertEquals(GdtfMatrix.IDENTITY, GdtfMatrix.parse(""));
		assertEquals(matrix, GdtfMatrix.parse(matrix.toString()));
		assertEquals(3, GdtfMatrix.parse("{1,0,0}{0,1,0}{0,0,1}").columns());
		assertThrows(IllegalArgumentException.class, () -> GdtfMatrix.parse("{1,0}{0}"));
		assertThrows(IllegalArgumentException.class, () -> GdtfMatrix.parse("{a,b}"));
	}

	@Test
	void colorFromXyY() {
		CieColor color = CieColor.parse("0.3127, 0.3290, 100");
		assertEquals(0.3127, color.x());
		assertEquals(100, color.toXyz()[1]);
		assertEquals(95.05, color.toXyz()[0], 0.01);
		assertNull(CieColor.parse(" "));
		assertThrows(IllegalArgumentException.class, () -> CieColor.parse("-nan,-nan,-nan"));
	}

}
