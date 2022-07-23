package de.verschwiegener.gdtf4j;

import java.util.List;
import java.util.UUID;

import de.verschwiegener.gdtf.GDTF;
import de.verschwiegener.gdtf.Revision;

public class GDTFWrapper {
	
	private String name, manufacturer, shortName, longName, description;
	private UUID fixtureTypeID, refFT;
	private List<Revision> revisions;
	
	public GDTFWrapper(GDTF gdtf) {
		name = gdtf.getFixtureType().getName();
		manufacturer = gdtf.getFixtureType().getManufacturer();
		shortName = gdtf.getFixtureType().getShortName();
		longName = gdtf.getFixtureType().getLongName();
		description = gdtf.getFixtureType().getLongName();
		
		fixtureTypeID = UUID.fromString(gdtf.getFixtureType().getFixtureTypeID());
		refFT = UUID.fromString(gdtf.getFixtureType().getRefFT());
		revisions = gdtf.getFixtureType().getRevisions().getRevision();
	}

}
