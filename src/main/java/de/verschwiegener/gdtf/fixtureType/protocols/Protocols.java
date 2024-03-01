//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.protocols;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Protocols complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Protocols"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="FTRDM" type="{}FTRDM" minOccurs="0"/&gt;
 *         &lt;element name="Art-Net" type="{}Art-Net" minOccurs="0"/&gt;
 *         &lt;element name="sACN" type="{}sACN" minOccurs="0"/&gt;
 *         &lt;element name="PosiStageNet" type="{}PosiStageNet" minOccurs="0"/&gt;
 *         &lt;element name="OpenSoundControl" type="{}OpenSoundControl" minOccurs="0"/&gt;
 *         &lt;element name="CITP" type="{}CITP" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Protocols", propOrder = {

})
public class Protocols {

    @XmlElement(name = "FTRDM")
    protected FTRDM ftrdm;
    @XmlElement(name = "Art-Net")
    protected ArtNet artNet;
    @XmlElement(name = "sACN")
    protected SACN sacn;
    @XmlElement(name = "PosiStageNet")
    protected PosiStageNet posiStageNet;
    @XmlElement(name = "OpenSoundControl")
    protected OpenSoundControl openSoundControl;
    @XmlElement(name = "CITP")
    protected CITP citp;

    /**
     * Ruft den Wert der ftrdm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FTRDM }
     *     
     */
    public FTRDM getFTRDM() {
        return ftrdm;
    }

    /**
     * Legt den Wert der ftrdm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FTRDM }
     *     
     */
    public void setFTRDM(FTRDM value) {
        this.ftrdm = value;
    }

    /**
     * Ruft den Wert der artNet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ArtNet }
     *     
     */
    public ArtNet getArtNet() {
        return artNet;
    }

    /**
     * Legt den Wert der artNet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArtNet }
     *     
     */
    public void setArtNet(ArtNet value) {
        this.artNet = value;
    }

    /**
     * Ruft den Wert der sacn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SACN }
     *     
     */
    public SACN getSACN() {
        return sacn;
    }

    /**
     * Legt den Wert der sacn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SACN }
     *     
     */
    public void setSACN(SACN value) {
        this.sacn = value;
    }

    /**
     * Ruft den Wert der posiStageNet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PosiStageNet }
     *     
     */
    public PosiStageNet getPosiStageNet() {
        return posiStageNet;
    }

    /**
     * Legt den Wert der posiStageNet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PosiStageNet }
     *     
     */
    public void setPosiStageNet(PosiStageNet value) {
        this.posiStageNet = value;
    }

    /**
     * Ruft den Wert der openSoundControl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OpenSoundControl }
     *     
     */
    public OpenSoundControl getOpenSoundControl() {
        return openSoundControl;
    }

    /**
     * Legt den Wert der openSoundControl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OpenSoundControl }
     *     
     */
    public void setOpenSoundControl(OpenSoundControl value) {
        this.openSoundControl = value;
    }

    /**
     * Ruft den Wert der citp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CITP }
     *     
     */
    public CITP getCITP() {
        return citp;
    }

    /**
     * Legt den Wert der citp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CITP }
     *     
     */
    public void setCITP(CITP value) {
        this.citp = value;
    }

}
