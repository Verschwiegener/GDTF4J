package de.verschwiegener.gdtf;

import java.io.File;
import java.util.List;

import de.verschwiegener.gdtf.GDTF.DMXChannelData;

public class Test {

	public static void main(String[] args) throws Exception {

		GDTF gdtf = new GDTF(new File(new File("").getAbsolutePath() + "/Robin MegaPointe.gdtf"),
				new File(new File("").getAbsolutePath() + "/GDTFExport"));
		
		gdtf.selectMode(gdtf.getDMXModes().get(0));
		List<DMXChannelData> data = gdtf.getDMXChannels();
		
		System.out.println("Data: " + data);

	}

}
