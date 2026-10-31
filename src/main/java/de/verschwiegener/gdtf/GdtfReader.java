package de.verschwiegener.gdtf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import de.verschwiegener.gdtf.model.GdtfFixtureType;
import de.verschwiegener.gdtf.xml.GDTF;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.UnmarshalException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventLocator;

/**
 * Reads GDTF files. The archive is read in memory, nothing is written to disk and no global state (locale, system
 * properties) is changed. A reader is immutable and can be used by several threads at once.
 *
 * <pre>
 * GdtfArchive archive = GdtfReader.create().read(Path.of("Robe@Spiider.gdtf"));
 * for (GdtfDmxMode mode : archive.fixtureType().modes())
 * 	System.out.println(mode.name() + ": " + mode.footprint(1) + " channels");
 * </pre>
 */
public final class GdtfReader {

	public static final String DESCRIPTION = "description.xml";
	/**
	 * Default limit for the unpacked size of an archive, protects against zip bombs
	 */
	public static final long DEFAULT_MAX_SIZE = 512L * 1024 * 1024;

	private static final String SCHEMA = "/de/verschwiegener/gdtf/gdtf.xsd";

	private final boolean validate;
	private final long maxSize;

	private GdtfReader(boolean validate, long maxSize) {
		this.validate = validate;
		this.maxSize = maxSize;
	}

	/**
	 * @return A reader that accepts files which do not follow the schema exactly, as long as they can be resolved
	 */
	public static GdtfReader create() {
		return new GdtfReader(false, DEFAULT_MAX_SIZE);
	}

	/**
	 * @param validate true to reject every file that does not follow the GDTF 1.2 schema. Many real files have
	 *                 small deviations, so this is meant for checking files, not for importing them.
	 */
	public GdtfReader validating(boolean validate) {
		return new GdtfReader(validate, maxSize);
	}

	/**
	 * @param maxSize Maximum unpacked size of an archive in bytes
	 */
	public GdtfReader withMaxSize(long maxSize) {
		if (maxSize < 1)
			throw new IllegalArgumentException("maxSize must be positive");
		return new GdtfReader(validate, maxSize);
	}

	public GdtfArchive read(Path file) throws IOException {
		try (InputStream in = Files.newInputStream(file)) {
			return read(in);
		} catch (GdtfException e) {
			throw new GdtfException(file.getFileName() + ": " + e.getMessage(), e);
		}
	}

	/**
	 * Reads a GDTF archive (zip). The stream is read to its end but not closed.
	 *
	 * @throws GdtfException if the archive is no GDTF file or its description can not be read
	 */
	public GdtfArchive read(InputStream gdtf) throws IOException {
		Map<String, byte[]> files = new LinkedHashMap<>();
		for (Map.Entry<String, byte[]> file : ZipArchive.read(readAll(gdtf), maxSize).entrySet())
			files.put(normalize(file.getKey()), file.getValue());
		byte[] description = files.remove(DESCRIPTION);
		if (description == null)
			throw new GdtfException("Not a GDTF file: " + DESCRIPTION + " is missing");
		List<String> warnings = new ArrayList<>();
		GdtfFixtureType type = resolve(unmarshal(new ByteArrayInputStream(trimEnd(description)), warnings),
				warnings);
		return new GdtfArchive(type, files, warnings);
	}

	/**
	 * Reads only a description.xml, without the other files of the archive
	 */
	public GdtfFixtureType readDescription(InputStream descriptionXml) throws IOException {
		List<String> warnings = new ArrayList<>();
		return resolve(unmarshal(new ByteArrayInputStream(trimEnd(readAll(descriptionXml))), warnings), warnings);
	}

	private static GdtfFixtureType resolve(GDTF root, List<String> warnings) throws GdtfException {
		if (root.getFixtureType() == null)
			throw new GdtfException(DESCRIPTION + " has no FixtureType");
		Resolver resolver = new Resolver(root);
		try {
			GdtfFixtureType type = resolver.resolve();
			warnings.addAll(resolver.warnings());
			return type;
		} catch (IllegalArgumentException | IllegalStateException | NullPointerException e) {
			throw new GdtfException("Invalid GDTF: " + e.getMessage(), e);
		}
	}

	private byte[] readAll(InputStream in) throws IOException {
		ByteArrayOutputStream data = new ByteArrayOutputStream();
		byte[] buffer = new byte[64 * 1024];
		long total = 0;
		int read;
		while ((read = in.read(buffer)) >= 0) {
			total += read;
			if (total > maxSize || total > Integer.MAX_VALUE - 8)
				throw new GdtfException("File is larger than " + Math.min(maxSize, Integer.MAX_VALUE - 8) + " bytes");
			data.write(buffer, 0, read);
		}
		return data.toByteArray();
	}

	/**
	 * Some exporters write a NUL byte or other padding after the root element, which XML does not allow
	 */
	private static byte[] trimEnd(byte[] xml) {
		int end = xml.length;
		while (end > 0 && (xml[end - 1] == 0 || Character.isWhitespace(xml[end - 1])))
			end--;
		return end == xml.length ? xml : Arrays.copyOf(xml, end);
	}

	/**
	 * Archives from Windows may use backslashes or start with "./"
	 */
	private static String normalize(String name) {
		String path = name.replace('\\', '/');
		while (path.startsWith("./") || path.startsWith("/"))
			path = path.substring(path.startsWith("./") ? 2 : 1);
		return path;
	}

	private GDTF unmarshal(InputStream xml, List<String> warnings) throws GdtfException {
		try {
			Unmarshaller unmarshaller = Context.INSTANCE.createUnmarshaller();
			if (validate)
				unmarshaller.setSchema(SchemaHolder.schema());
			unmarshaller.setEventHandler(event -> {
				if (validate || event.getSeverity() == ValidationEvent.FATAL_ERROR)
					return false;
				warnings.add(location(event.getLocator()) + event.getMessage());
				return true;
			});
			Object result = unmarshaller.unmarshal(new SAXSource(secureReader(), new InputSource(xml)));
			if (result instanceof JAXBElement<?> element)
				result = element.getValue();
			if (!(result instanceof GDTF root))
				throw new GdtfException(DESCRIPTION + " has no GDTF root element");
			return root;
		} catch (UnmarshalException e) {
			throw new GdtfException(DESCRIPTION + " " + describe(e), e);
		} catch (JAXBException | SAXException | ParserConfigurationException e) {
			throw new GdtfException(DESCRIPTION + " can not be read: " + e.getMessage(), e);
		}
	}

	/**
	 * Parser without DOCTYPE and external entities, files come from users and the network
	 */
	private static XMLReader secureReader() throws SAXException, ParserConfigurationException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		return factory.newSAXParser().getXMLReader();
	}

	private static String describe(UnmarshalException e) {
		Throwable cause = e.getLinkedException() != null ? e.getLinkedException() : e.getCause();
		if (cause instanceof SAXParseException parse)
			return "line " + parse.getLineNumber() + ": " + parse.getMessage();
		if (cause != null)
			return "can not be read: " + cause.getMessage();
		return "can not be read: " + e.getMessage();
	}

	private static String location(ValidationEventLocator locator) {
		return locator != null && locator.getLineNumber() > 0 ? "Line " + locator.getLineNumber() + ": " : "";
	}

	/**
	 * Creating the context is expensive, it is immutable and thread safe once created
	 */
	private static final class Context {

		static final JAXBContext INSTANCE;

		static {
			try {
				INSTANCE = JAXBContext.newInstance(GDTF.class);
			} catch (JAXBException e) {
				throw new ExceptionInInitializerError(e);
			}
		}
	}

	private static final class SchemaHolder {

		private static volatile Schema schema;

		static Schema schema() throws SAXException {
			Schema result = schema;
			if (result == null) {
				URL url = GdtfReader.class.getResource(SCHEMA);
				if (url == null)
					throw new SAXException("GDTF schema " + SCHEMA + " is missing");
				result = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(url);
				schema = result;
			}
			return result;
		}
	}

}
