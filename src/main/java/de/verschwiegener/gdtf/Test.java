package de.verschwiegener.gdtf;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import de.verschwiegener.gdtf.GDTF.DMXChannelData;
import de.verschwiegener.gdtf.GDTF.GDTFGeometry;

public class Test {

	public static void main(String[] args) {

		GDTF gdtf = new GDTF(new File(new File("").getAbsolutePath() + "/MVRExport/Demostage_MVR/Robe Lighting@Robin SuperSpikie.gdtf"),
				new File(new File("").getAbsolutePath() + "/GDTFExport"));
		try {
			gdtf.parse();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(gdtf.isParsed()) {
			gdtf.selectMode(gdtf.getDMXModes().get(0));
			List<DMXChannelData> data = gdtf.getDMXChannels();
			
			
			for(GDTFGeometry geo : gdtf.getGeometries()) {
				System.out.println("Name: " + geo.typeClass().getName());
			}
			
			System.out.println("Data: " + data);
		}

	}

}
