//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
