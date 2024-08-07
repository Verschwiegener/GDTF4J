//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.fixtureType.physicalDescription.AdditionalColorSpaces;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.CRIs;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.ColorSpace;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Connectors;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.DMXProfiles;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Emitters;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Filters;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Gamuts;
import de.verschwiegener.gdtf.fixtureType.physicalDescription.Properties;
import de.verschwiegener.gdtf.util.GDTFNode;


/**
 * <p>Java-Klasse für PhysicalDescriptions complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PhysicalDescriptions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Emitters" type="{}Emitters" minOccurs="0"/&gt;
 *         &lt;element name="Filters" type="{}Filters" minOccurs="0"/&gt;
 *         &lt;element name="ColorSpace" type="{}ColorSpace" minOccurs="0"/&gt;
 *         &lt;element name="DMXProfiles" type="{}DMXProfiles" minOccurs="0"/&gt;
 *         &lt;element name="CRIs" type="{}CRIs" minOccurs="0"/&gt;
 *         &lt;element name="Connectors" type="{}Connectors" minOccurs="0"/&gt;
 *         &lt;element name="Properties" type="{}Properties" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalDescriptions", propOrder = {

})
public class PhysicalDescriptions {

    @XmlElement(name = "Emitters")
    protected Emitters emitters;
    @XmlElement(name = "Filters")
    protected Filters filters;
    @XmlElement(name = "AdditionalColorSpaces")
    protected AdditionalColorSpaces additionalColorSpaces;
    @XmlElement(name = "Gamuts")
    protected Gamuts gamuts;
    @XmlElement(name = "ColorSpace")
    protected ColorSpace colorSpace;
    @XmlElement(name = "DMXProfiles")
    protected DMXProfiles dmxProfiles;
    @XmlElement(name = "CRIs")
    protected CRIs crIs;
    @XmlElement(name = "Connectors")
    protected Connectors connectors;
    @XmlElement(name = "Properties")
    protected Properties properties;
    
    
    
    public ColorSpace getColorSpace(GDTFNode node) {
    	if(colorSpace.getName().equals(node.getNodePath()[0]))
    		return colorSpace;
    	return additionalColorSpaces.getColorSpace().stream().filter(cs -> cs.getName().equals(node.getNodePath()[0])).findFirst().orElse(null);
    }
    
    

    /**
     * Ruft den Wert der emitters-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Emitters }
     *     
     */
    public Emitters getEmitters() {
        return emitters;
    }

    /**
     * Legt den Wert der emitters-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Emitters }
     *     
     */
    public void setEmitters(Emitters value) {
        this.emitters = value;
    }

    /**
     * Ruft den Wert der filters-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Filters }
     *     
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * Legt den Wert der filters-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Filters }
     *     
     */
    public void setFilters(Filters value) {
        this.filters = value;
    }

    /**
     * Ruft den Wert der additionalColorSpaces-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalColorSpaces }
     *     
     */
    public AdditionalColorSpaces getAdditionalColorSpaces() {
        return additionalColorSpaces;
    }

    /**
     * Legt den Wert der additionalColorSpaces-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalColorSpaces }
     *     
     */
    public void setAdditionalColorSpaces(AdditionalColorSpaces value) {
        this.additionalColorSpaces = value;
    }

    /**
     * Ruft den Wert der gamuts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Gamuts }
     *     
     */
    public Gamuts getGamuts() {
        return gamuts;
    }

    /**
     * Legt den Wert der gamuts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Gamuts }
     *     
     */
    public void setGamuts(Gamuts value) {
        this.gamuts = value;
    }

    /**
     * Ruft den Wert der colorSpace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ColorSpace }
     *     
     */
    public ColorSpace getColorSpace() {
        return colorSpace;
    }

    /**
     * Legt den Wert der colorSpace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorSpace }
     *     
     */
    public void setColorSpace(ColorSpace value) {
        this.colorSpace = value;
    }

    /**
     * Ruft den Wert der dmxProfiles-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DMXProfiles }
     *     
     */
    public DMXProfiles getDMXProfiles() {
        return dmxProfiles;
    }

    /**
     * Legt den Wert der dmxProfiles-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DMXProfiles }
     *     
     */
    public void setDMXProfiles(DMXProfiles value) {
        this.dmxProfiles = value;
    }

    /**
     * Ruft den Wert der crIs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CRIs }
     *     
     */
    public CRIs getCRIs() {
        return crIs;
    }

    /**
     * Legt den Wert der crIs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CRIs }
     *     
     */
    public void setCRIs(CRIs value) {
        this.crIs = value;
    }

    /**
     * Ruft den Wert der connectors-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Connectors }
     *     
     */
    public Connectors getConnectors() {
        return connectors;
    }

    /**
     * Legt den Wert der connectors-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Connectors }
     *     
     */
    public void setConnectors(Connectors value) {
        this.connectors = value;
    }

    /**
     * Ruft den Wert der properties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Legt den Wert der properties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

}
