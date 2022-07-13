import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import de.verschwiegener.gdtf4j.GDTF;

public class Main {

	public static void main(String[] args) {
		try {
			int dmxValue = 255;
			int shiftvalue = 1;
			int test = dmxValue << (8 * shiftvalue) - 8;
			System.out.println("Test: " + test);

			new GDTF(new File("/home/julius-laptop/Schreibtisch/testgdtf"), new File(
					"/home/julius-laptop/Schreibtisch/gdtf/Martin_Professional@MAC_Viper_Performance@Rev_1.5.gdtf"))
							.fromGDTF();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
