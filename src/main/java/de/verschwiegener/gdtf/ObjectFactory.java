//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
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
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.activationGroup.ActivationGroup;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.activationGroup.ActivationGroups;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute.Attribute;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute.Attributes;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.Feature;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.FeatureGroup;
import de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup.FeatureGroups;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.ChannelFunction;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.ChannelSet;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXChannel;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXChannels;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXMode;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.DMXModes;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.FTMacro;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.FTMacros;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.LogicalChannel;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.MacroDMX;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.MacroDMXStep;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.MacroDMXValue;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.Relation;
import de.verschwiegener.gdtf.fixtureType.dmxmodes.Relations;
import de.verschwiegener.gdtf.fixtureType.geometries.BasicGeometryAttributes;
import de.verschwiegener.gdtf.fixtureType.geometries.BasicGeometryType;
import de.verschwiegener.gdtf.fixtureType.geometries.Beam;
import de.verschwiegener.gdtf.fixtureType.geometries.Break;
import de.verschwiegener.gdtf.fixtureType.geometries.Display;
import de.verschwiegener.gdtf.fixtureType.geometries.Geometries;
import de.verschwiegener.gdtf.fixtureType.geometries.GeometryReference;
import de.verschwiegener.gdtf.fixtureType.models.Model;
import de.verschwiegener.gdtf.fixtureType.models.Models;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRI;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRIGroup;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRIs;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.ColorSpace;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Connector;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Connectors;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.DMXProfile;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.DMXProfiles;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitters;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filter;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filters;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.LegHeight;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.MeasurementPoint;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.OperatingTemperature;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.PowerConsumption;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Properties;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Weight;
import de.verschwiegener.gdtf.fixtureType.protocols.ArtNet;
import de.verschwiegener.gdtf.fixtureType.protocols.CITP;
import de.verschwiegener.gdtf.fixtureType.protocols.FTRDM;
import de.verschwiegener.gdtf.fixtureType.protocols.OpenSoundControl;
import de.verschwiegener.gdtf.fixtureType.protocols.PosiStageNet;
import de.verschwiegener.gdtf.fixtureType.protocols.Protocols;
import de.verschwiegener.gdtf.fixtureType.protocols.SACN;
import de.verschwiegener.gdtf.fixtureType.protocols.rdm.DMXPersonality;
import de.verschwiegener.gdtf.fixtureType.protocols.rdm.SoftwareVersionID;
import de.verschwiegener.gdtf.fixtureType.revisions.Revision;
import de.verschwiegener.gdtf.fixtureType.revisions.Revisions;
import de.verschwiegener.gdtf.fixtureType.wheel.AnimationSystem;
import de.verschwiegener.gdtf.fixtureType.wheel.Facet;
import de.verschwiegener.gdtf.fixtureType.wheel.Slot;
import de.verschwiegener.gdtf.fixtureType.wheel.Wheel;
import de.verschwiegener.gdtf.fixtureType.wheel.Wheels;


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
    public GDTF createGDTF() {
        return new GDTF();
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
     * Create an instance of {@link ColorSpace }
     * 
     */
    public ColorSpace createColorSpace() {
        return new ColorSpace();
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

}
