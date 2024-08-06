//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.08.04 um 12:03:53 AM CEST 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import de.verschwiegener.gdtf.fixtureType.FTPreset;
import de.verschwiegener.gdtf.fixtureType.FTPresets;
import de.verschwiegener.gdtf.fixtureType.FixtureType;
import de.verschwiegener.gdtf.fixtureType.PhysicalDescriptions;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.AttributeDefinitions;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.activationGroup.*;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute.*;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.*;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.*;
import de.verschwiegener.gdtf.fixtureType.geometries.*;
import de.verschwiegener.gdtf.fixtureType.models.Model;
import de.verschwiegener.gdtf.fixtureType.models.Models;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.*;
import de.verschwiegener.gdtf.fixtureType.protocols.*;
import de.verschwiegener.gdtf.fixtureType.protocols.rdm.*;
import de.verschwiegener.gdtf.fixtureType.revisions.*;
import de.verschwiegener.gdtf.fixtureType.wheel.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.verschwiegener.gdtf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BasicGeometryTypeGeometry_QNAME = new QName("", "Geometry");
    private final static QName _BasicGeometryTypeAxis_QNAME = new QName("", "Axis");
    private final static QName _BasicGeometryTypeFilterBeam_QNAME = new QName("", "FilterBeam");
    private final static QName _BasicGeometryTypeFilterColor_QNAME = new QName("", "FilterColor");
    private final static QName _BasicGeometryTypeFilterGobo_QNAME = new QName("", "FilterGobo");
    private final static QName _BasicGeometryTypeFilterShaper_QNAME = new QName("", "FilterShaper");
    private final static QName _BasicGeometryTypeBeam_QNAME = new QName("", "Beam");
    private final static QName _BasicGeometryTypeMediaServerLayer_QNAME = new QName("", "MediaServerLayer");
    private final static QName _BasicGeometryTypeMediaServerCamera_QNAME = new QName("", "MediaServerCamera");
    private final static QName _BasicGeometryTypeMediaServerMaster_QNAME = new QName("", "MediaServerMaster");
    private final static QName _BasicGeometryTypeDisplay_QNAME = new QName("", "Display");
    private final static QName _BasicGeometryTypeGeometryReference_QNAME = new QName("", "GeometryReference");
    private final static QName _BasicGeometryTypeLaser_QNAME = new QName("", "Laser");
    private final static QName _BasicGeometryTypeWiringObject_QNAME = new QName("", "WiringObject");
    private final static QName _BasicGeometryTypeInventory_QNAME = new QName("", "Inventory");
    private final static QName _BasicGeometryTypeStructure_QNAME = new QName("", "Structure");
    private final static QName _BasicGeometryTypeSupport_QNAME = new QName("", "Support");
    private final static QName _BasicGeometryTypeMagnet_QNAME = new QName("", "Magnet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.verschwiegener.gdtf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link Emitter }
     * 
     */
    public Emitter createEmitter() {
        return new Emitter();
    }

    /**
     * Create an instance of {@link GDTF }
     * 
     */
    public GDTFType createGDTF() {
        return new GDTFType();
    }

    /**
     * Create an instance of {@link FixtureType }
     * 
     */
    public FixtureType createFixtureType() {
        return new FixtureType();
    }

    /**
     * Create an instance of {@link AttributeDefinitions }
     * 
     */
    public AttributeDefinitions createAttributeDefinitions() {
        return new AttributeDefinitions();
    }

    /**
     * Create an instance of {@link ActivationGroups }
     * 
     */
    public ActivationGroups createActivationGroups() {
        return new ActivationGroups();
    }

    /**
     * Create an instance of {@link FeatureGroups }
     * 
     */
    public FeatureGroups createFeatureGroups() {
        return new FeatureGroups();
    }

    /**
     * Create an instance of {@link ActivationGroup }
     * 
     */
    public ActivationGroup createActivationGroup() {
        return new ActivationGroup();
    }

    /**
     * Create an instance of {@link FeatureGroup }
     * 
     */
    public FeatureGroup createFeatureGroup() {
        return new FeatureGroup();
    }

    /**
     * Create an instance of {@link Feature }
     * 
     */
    public Feature createFeature() {
        return new Feature();
    }

    /**
     * Create an instance of {@link Attributes }
     * 
     */
    public Attributes createAttributes() {
        return new Attributes();
    }

    /**
     * Create an instance of {@link Attribute }
     * 
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link SubPhysicalUnit }
     * 
     */
    public SubPhysicalUnit createSubPhysicalUnit() {
        return new SubPhysicalUnit();
    }

    /**
     * Create an instance of {@link Wheels }
     * 
     */
    public Wheels createWheels() {
        return new Wheels();
    }

    /**
     * Create an instance of {@link Wheel }
     * 
     */
    public Wheel createWheel() {
        return new Wheel();
    }

    /**
     * Create an instance of {@link Slot }
     * 
     */
    public Slot createSlot() {
        return new Slot();
    }

    /**
     * Create an instance of {@link Facet }
     * 
     */
    public Facet createFacet() {
        return new Facet();
    }

    /**
     * Create an instance of {@link AnimationSystem }
     * 
     */
    public AnimationSystem createAnimationSystem() {
        return new AnimationSystem();
    }

    /**
     * Create an instance of {@link PhysicalDescriptions }
     * 
     */
    public PhysicalDescriptions createPhysicalDescriptions() {
        return new PhysicalDescriptions();
    }

    /**
     * Create an instance of {@link Emitters }
     * 
     */
    public Emitters createEmitters() {
        return new Emitters();
    }

    /**
     * Create an instance of {@link Filters }
     * 
     */
    public Filters createFilters() {
        return new Filters();
    }

    /**
     * Create an instance of {@link MeasurementPoint }
     * 
     */
    public MeasurementPoint createMeasurementPoint() {
        return new MeasurementPoint();
    }

    /**
     * Create an instance of {@link AdditionalColorSpaces }
     * 
     */
    public AdditionalColorSpaces createAdditionalColorSpaces() {
        return new AdditionalColorSpaces();
    }

    /**
     * Create an instance of {@link ColorSpace }
     * 
     */
    public ColorSpace createColorSpace() {
        return new ColorSpace();
    }

    /**
     * Create an instance of {@link Gamuts }
     * 
     */
    public Gamuts createGamuts() {
        return new Gamuts();
    }

    /**
     * Create an instance of {@link Gamut }
     * 
     */
    public Gamut createGamut() {
        return new Gamut();
    }

    /**
     * Create an instance of {@link DMXProfiles }
     * 
     */
    public DMXProfiles createDMXProfiles() {
        return new DMXProfiles();
    }

    /**
     * Create an instance of {@link DMXProfile }
     * 
     */
    public DMXProfile createDMXProfile() {
        return new DMXProfile();
    }

    /**
     * Create an instance of {@link Point }
     * 
     */
    public Point createPoint() {
        return new Point();
    }

    /**
     * Create an instance of {@link CRIs }
     * 
     */
    public CRIs createCRIs() {
        return new CRIs();
    }

    /**
     * Create an instance of {@link CRIGroup }
     * 
     */
    public CRIGroup createCRIGroup() {
        return new CRIGroup();
    }

    /**
     * Create an instance of {@link CRI }
     * 
     */
    public CRI createCRI() {
        return new CRI();
    }

    /**
     * Create an instance of {@link Connectors }
     * 
     */
    public Connectors createConnectors() {
        return new Connectors();
    }

    /**
     * Create an instance of {@link Connector }
     * 
     */
    public Connector createConnector() {
        return new Connector();
    }

    /**
     * Create an instance of {@link Properties }
     * 
     */
    public Properties createProperties() {
        return new Properties();
    }

    /**
     * Create an instance of {@link OperatingTemperature }
     * 
     */
    public OperatingTemperature createOperatingTemperature() {
        return new OperatingTemperature();
    }

    /**
     * Create an instance of {@link Weight }
     * 
     */
    public Weight createWeight() {
        return new Weight();
    }

    /**
     * Create an instance of {@link PowerConsumption }
     * 
     */
    public PowerConsumption createPowerConsumption() {
        return new PowerConsumption();
    }

    /**
     * Create an instance of {@link LegHeight }
     * 
     */
    public LegHeight createLegHeight() {
        return new LegHeight();
    }

    /**
     * Create an instance of {@link Models }
     * 
     */
    public Models createModels() {
        return new Models();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link Geometries }
     * 
     */
    public Geometries createGeometries() {
        return new Geometries();
    }

    /**
     * Create an instance of {@link BasicGeometryAttributes }
     * 
     */
    public BasicGeometryAttributes createBasicGeometryAttributes() {
        return new BasicGeometryAttributes();
    }

    /**
     * Create an instance of {@link BasicGeometryType }
     * 
     */
    public BasicGeometryType createBasicGeometryType() {
        return new BasicGeometryType();
    }

    /**
     * Create an instance of {@link Beam }
     * 
     */
    public Beam createBeam() {
        return new Beam();
    }

    /**
     * Create an instance of {@link Display }
     * 
     */
    public Display createDisplay() {
        return new Display();
    }

    /**
     * Create an instance of {@link GeometryReference }
     * 
     */
    public GeometryReference createGeometryReference() {
        return new GeometryReference();
    }

    /**
     * Create an instance of {@link Break }
     * 
     */
    public Break createBreak() {
        return new Break();
    }

    /**
     * Create an instance of {@link Laser }
     * 
     */
    public Laser createLaser() {
        return new Laser();
    }

    /**
     * Create an instance of {@link Protocol }
     * 
     */
    public Protocol createProtocol() {
        return new Protocol();
    }

    /**
     * Create an instance of {@link WiringObject }
     * 
     */
    public WiringObject createWiringObject() {
        return new WiringObject();
    }

    /**
     * Create an instance of {@link PinPatch }
     * 
     */
    public PinPatch createPinPatch() {
        return new PinPatch();
    }

    /**
     * Create an instance of {@link Inventory }
     * 
     */
    public Inventory createInventory() {
        return new Inventory();
    }

    /**
     * Create an instance of {@link Structure }
     * 
     */
    public Structure createStructure() {
        return new Structure();
    }

    /**
     * Create an instance of {@link Support }
     * 
     */
    public Support createSupport() {
        return new Support();
    }

    /**
     * Create an instance of {@link DMXModes }
     * 
     */
    public DMXModes createDMXModes() {
        return new DMXModes();
    }

    /**
     * Create an instance of {@link DMXMode }
     * 
     */
    public DMXMode createDMXMode() {
        return new DMXMode();
    }

    /**
     * Create an instance of {@link DMXChannels }
     * 
     */
    public DMXChannels createDMXChannels() {
        return new DMXChannels();
    }

    /**
     * Create an instance of {@link DMXChannel }
     * 
     */
    public DMXChannel createDMXChannel() {
        return new DMXChannel();
    }

    /**
     * Create an instance of {@link LogicalChannel }
     * 
     */
    public LogicalChannel createLogicalChannel() {
        return new LogicalChannel();
    }

    /**
     * Create an instance of {@link ChannelFunction }
     * 
     */
    public ChannelFunction createChannelFunction() {
        return new ChannelFunction();
    }

    /**
     * Create an instance of {@link ChannelSet }
     * 
     */
    public ChannelSet createChannelSet() {
        return new ChannelSet();
    }

    /**
     * Create an instance of {@link SubChannelSet }
     * 
     */
    public SubChannelSet createSubChannelSet() {
        return new SubChannelSet();
    }

    /**
     * Create an instance of {@link Relations }
     * 
     */
    public Relations createRelations() {
        return new Relations();
    }

    /**
     * Create an instance of {@link Relation }
     * 
     */
    public Relation createRelation() {
        return new Relation();
    }

    /**
     * Create an instance of {@link FTMacros }
     * 
     */
    public FTMacros createFTMacros() {
        return new FTMacros();
    }

    /**
     * Create an instance of {@link FTMacro }
     * 
     */
    public FTMacro createFTMacro() {
        return new FTMacro();
    }

    /**
     * Create an instance of {@link MacroDMX }
     * 
     */
    public MacroDMX createMacroDMX() {
        return new MacroDMX();
    }

    /**
     * Create an instance of {@link MacroDMXStep }
     * 
     */
    public MacroDMXStep createMacroDMXStep() {
        return new MacroDMXStep();
    }

    /**
     * Create an instance of {@link MacroDMXValue }
     * 
     */
    public MacroDMXValue createMacroDMXValue() {
        return new MacroDMXValue();
    }

    /**
     * Create an instance of {@link Revisions }
     * 
     */
    public Revisions createRevisions() {
        return new Revisions();
    }

    /**
     * Create an instance of {@link Revision }
     * 
     */
    public Revision createRevision() {
        return new Revision();
    }

    /**
     * Create an instance of {@link FTPresets }
     * 
     */
    public FTPresets createFTPresets() {
        return new FTPresets();
    }

    /**
     * Create an instance of {@link FTPreset }
     * 
     */
    public FTPreset createFTPreset() {
        return new FTPreset();
    }

    /**
     * Create an instance of {@link Protocols }
     * 
     */
    public Protocols createProtocols() {
        return new Protocols();
    }

    /**
     * Create an instance of {@link ArtNet }
     * 
     */
    public ArtNet createArtNet() {
        return new ArtNet();
    }

    /**
     * Create an instance of {@link Map }
     * 
     */
    public Map createMap() {
        return new Map();
    }

    /**
     * Create an instance of {@link SACN }
     * 
     */
    public SACN createSACN() {
        return new SACN();
    }

    /**
     * Create an instance of {@link PosiStageNet }
     * 
     */
    public PosiStageNet createPosiStageNet() {
        return new PosiStageNet();
    }

    /**
     * Create an instance of {@link OpenSoundControl }
     * 
     */
    public OpenSoundControl createOpenSoundControl() {
        return new OpenSoundControl();
    }

    /**
     * Create an instance of {@link CITP }
     * 
     */
    public CITP createCITP() {
        return new CITP();
    }

    /**
     * Create an instance of {@link FTRDM }
     * 
     */
    public FTRDM createFTRDM() {
        return new FTRDM();
    }

    /**
     * Create an instance of {@link SoftwareVersionID }
     * 
     */
    public SoftwareVersionID createSoftwareVersionID() {
        return new SoftwareVersionID();
    }

    /**
     * Create an instance of {@link DMXPersonality }
     * 
     */
    public DMXPersonality createDMXPersonality() {
        return new DMXPersonality();
    }

    /**
     * Create an instance of {@link Filter.Measurement }
     * 
     */
    public Filter.Measurement createFilterMeasurement() {
        return new Filter.Measurement();
    }

    /**
     * Create an instance of {@link Emitter.Measurement }
     * 
     */
    public Emitter.Measurement createEmitterMeasurement() {
        return new Emitter.Measurement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Geometry", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeGeometry(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeGeometry_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Axis", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeAxis(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeAxis_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterBeam", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeFilterBeam(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterBeam_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterColor", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeFilterColor(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterColor_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterGobo", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeFilterGobo(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterGobo_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterShaper", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeFilterShaper(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterShaper_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Beam }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Beam }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Beam", scope = BasicGeometryType.class)
    public JAXBElement<Beam> createBasicGeometryTypeBeam(Beam value) {
        return new JAXBElement<Beam>(_BasicGeometryTypeBeam_QNAME, Beam.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerLayer", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeMediaServerLayer(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerLayer_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerCamera", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeMediaServerCamera(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerCamera_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerMaster", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeMediaServerMaster(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerMaster_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Display }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Display }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Display", scope = BasicGeometryType.class)
    public JAXBElement<Display> createBasicGeometryTypeDisplay(Display value) {
        return new JAXBElement<Display>(_BasicGeometryTypeDisplay_QNAME, Display.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryReference }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometryReference }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "GeometryReference", scope = BasicGeometryType.class)
    public JAXBElement<GeometryReference> createBasicGeometryTypeGeometryReference(GeometryReference value) {
        return new JAXBElement<GeometryReference>(_BasicGeometryTypeGeometryReference_QNAME, GeometryReference.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Laser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Laser }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Laser", scope = BasicGeometryType.class)
    public JAXBElement<Laser> createBasicGeometryTypeLaser(Laser value) {
        return new JAXBElement<Laser>(_BasicGeometryTypeLaser_QNAME, Laser.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WiringObject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WiringObject }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "WiringObject", scope = BasicGeometryType.class)
    public JAXBElement<WiringObject> createBasicGeometryTypeWiringObject(WiringObject value) {
        return new JAXBElement<WiringObject>(_BasicGeometryTypeWiringObject_QNAME, WiringObject.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inventory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Inventory }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Inventory", scope = BasicGeometryType.class)
    public JAXBElement<Inventory> createBasicGeometryTypeInventory(Inventory value) {
        return new JAXBElement<Inventory>(_BasicGeometryTypeInventory_QNAME, Inventory.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Structure }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Structure }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Structure", scope = BasicGeometryType.class)
    public JAXBElement<Structure> createBasicGeometryTypeStructure(Structure value) {
        return new JAXBElement<Structure>(_BasicGeometryTypeStructure_QNAME, Structure.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Support }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Support }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Support", scope = BasicGeometryType.class)
    public JAXBElement<Support> createBasicGeometryTypeSupport(Support value) {
        return new JAXBElement<Support>(_BasicGeometryTypeSupport_QNAME, Support.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Magnet", scope = BasicGeometryType.class)
    public JAXBElement<BasicGeometryType> createBasicGeometryTypeMagnet(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMagnet_QNAME, BasicGeometryType.class, BasicGeometryType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Geometry", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesGeometry(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeGeometry_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Axis", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesAxis(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeAxis_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterBeam", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesFilterBeam(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterBeam_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterColor", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesFilterColor(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterColor_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterGobo", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesFilterGobo(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterGobo_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FilterShaper", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesFilterShaper(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeFilterShaper_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Beam }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Beam }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Beam", scope = Geometries.class)
    public JAXBElement<Beam> createGeometriesBeam(Beam value) {
        return new JAXBElement<Beam>(_BasicGeometryTypeBeam_QNAME, Beam.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerLayer", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesMediaServerLayer(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerLayer_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerCamera", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesMediaServerCamera(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerCamera_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MediaServerMaster", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesMediaServerMaster(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMediaServerMaster_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Display }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Display }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Display", scope = Geometries.class)
    public JAXBElement<Display> createGeometriesDisplay(Display value) {
        return new JAXBElement<Display>(_BasicGeometryTypeDisplay_QNAME, Display.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryReference }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometryReference }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "GeometryReference", scope = Geometries.class)
    public JAXBElement<GeometryReference> createGeometriesGeometryReference(GeometryReference value) {
        return new JAXBElement<GeometryReference>(_BasicGeometryTypeGeometryReference_QNAME, GeometryReference.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Laser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Laser }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Laser", scope = Geometries.class)
    public JAXBElement<Laser> createGeometriesLaser(Laser value) {
        return new JAXBElement<Laser>(_BasicGeometryTypeLaser_QNAME, Laser.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WiringObject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WiringObject }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "WiringObject", scope = Geometries.class)
    public JAXBElement<WiringObject> createGeometriesWiringObject(WiringObject value) {
        return new JAXBElement<WiringObject>(_BasicGeometryTypeWiringObject_QNAME, WiringObject.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Inventory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Inventory }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Inventory", scope = Geometries.class)
    public JAXBElement<Inventory> createGeometriesInventory(Inventory value) {
        return new JAXBElement<Inventory>(_BasicGeometryTypeInventory_QNAME, Inventory.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Structure }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Structure }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Structure", scope = Geometries.class)
    public JAXBElement<Structure> createGeometriesStructure(Structure value) {
        return new JAXBElement<Structure>(_BasicGeometryTypeStructure_QNAME, Structure.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Support }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Support }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Support", scope = Geometries.class)
    public JAXBElement<Support> createGeometriesSupport(Support value) {
        return new JAXBElement<Support>(_BasicGeometryTypeSupport_QNAME, Support.class, Geometries.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Magnet", scope = Geometries.class)
    public JAXBElement<BasicGeometryType> createGeometriesMagnet(BasicGeometryType value) {
        return new JAXBElement<BasicGeometryType>(_BasicGeometryTypeMagnet_QNAME, BasicGeometryType.class, Geometries.class, value);
    }

}
