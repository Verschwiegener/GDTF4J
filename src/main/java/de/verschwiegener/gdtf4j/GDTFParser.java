package de.verschwiegener.gdtf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.verschwiegener.gdtf.GDTF;
import de.verschwiegener.gdtf.GDTFUtil;

public class GDTFParser {

	private SchemaFactory schemaFactory;
	private Schema schema;

	public GDTFParser() throws SAXException, FileNotFoundException {
		schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schema = schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream("gdtf/gdtf.xsd")));
		System.out.println("Schema: " + schema);
	}

	public GDTF parseGDTF(File gdtfFile, File gdtfOutputFolder) throws Exception {
		gdtfOutputFolder = new File(gdtfOutputFolder, gdtfFile.getName().split("\\.")[0]);
		GDTFUtil.unzipFile(gdtfFile, gdtfOutputFolder);

		Unmarshaller unmarshaller = JAXBContext.newInstance(de.verschwiegener.gdtf.GDTF.class).createUnmarshaller();
		unmarshaller.setSchema(schema);

		GDTF root = (GDTF) unmarshaller
				.unmarshal(new InputSource(new FileReader(new File(gdtfOutputFolder, "description.xml"))));
		return root;
	}

}
