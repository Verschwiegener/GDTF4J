//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2022.07.22 um 09:22:55 PM CEST 
//


package de.verschwiegener.gdtf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Geometries complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Geometries"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;group ref="{}GeometryChildren"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geometries", propOrder = {
    "geometryOrAxisOrFilterBeam"
})
public class Geometries {

    @XmlElementRefs({
        @XmlElementRef(name = "Geometry", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Axis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FilterBeam", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FilterColor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FilterGobo", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FilterShaper", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Beam", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MediaServerLayer", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MediaServerCamera", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MediaServerMaster", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Display", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GeometryReference", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends BasicGeometryAttributes>> geometryOrAxisOrFilterBeam;

    /**
     * Gets the value of the geometryOrAxisOrFilterBeam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometryOrAxisOrFilterBeam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometryOrAxisOrFilterBeam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link Beam }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link Display }{@code >}
     * {@link JAXBElement }{@code <}{@link GeometryReference }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BasicGeometryAttributes>> getGeometryOrAxisOrFilterBeam() {
        if (geometryOrAxisOrFilterBeam == null) {
            geometryOrAxisOrFilterBeam = new ArrayList<JAXBElement<? extends BasicGeometryAttributes>>();
        }
        return this.geometryOrAxisOrFilterBeam;
    }

}
