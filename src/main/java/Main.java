

import java.io.File;
import java.io.FileInputStream;

import de.verschwiegener.gdtf.GDTF;
import de.verschwiegener.gdtf4j.GDTFParser;

public class Main {
	
	public static void main(String[] args) {
		try {
			GDTFParser schema = new GDTFParser();
			GDTF gdtf = schema.parseGDTF(new File("//home/julius/Schreibtisch/gdtf/MacUltra.gdtf"), new File(
					"/home/julius/Schreibtisch/gdtf/"));
			System.out.println("GDTF: " + gdtf);
			System.out.println("Test: " + gdtf.getFixtureType().getDescription());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
