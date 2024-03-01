//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.physicalDescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MeasurementPoint complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MeasurementPoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="WaveLength" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="Energy" use="required" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementPoint")
public class MeasurementPoint {

    @XmlAttribute(name = "WaveLength", required = true)
    protected float waveLength;
    @XmlAttribute(name = "Energy", required = true)
    protected float energy;

    /**
     * Ruft den Wert der waveLength-Eigenschaft ab.
     * 
     */
    public float getWaveLength() {
        return waveLength;
    }

    /**
     * Legt den Wert der waveLength-Eigenschaft fest.
     * 
     */
    public void setWaveLength(float value) {
        this.waveLength = value;
    }

    /**
     * Ruft den Wert der energy-Eigenschaft ab.
     * 
     */
    public float getEnergy() {
        return energy;
    }

    /**
     * Legt den Wert der energy-Eigenschaft fest.
     * 
     */
    public void setEnergy(float value) {
        this.energy = value;
    }

}
