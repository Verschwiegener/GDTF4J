//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//

package de.verschwiegener.gdtf.fixtureType.attributeDefinition.attribute;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFColor;
import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;
import de.verschwiegener.gdtf.util.GDTFUtils.FeatureHelper;
import de.verschwiegener.gdtf.util.GDTFUtils.NameHelper;

/**
 * <p>
 * Java-Klasse für Attribute complex type.
 * 
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Attribute"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Name" use="required" type="{}nametype" /&gt;
 *       &lt;attribute name="Pretty" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ActivationGroup" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PhysicalUnit" type="{}PhysicalUnitEnum" default="None" /&gt;
 *       &lt;attribute name="Color" type="{}colorcietype" /&gt;
 *       &lt;attribute name="Feature" use="required" type="{}featuretype" /&gt;
 *       &lt;attribute name="MainAttribute" type="{}nametype" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attribute", propOrder = { "subphysicalUnit" })
public class Attribute {

	@XmlElement(name = "SubPhysicalUnit")
	protected List<SubPhysicalUnit> subphysicalUnit;

	/**
	 * The unique name of the attribute.
	 */
	@XmlAttribute(name = "Name", required = true)
	protected String name;

	/**
	 * The pretty name of the attribute .
	 */
	@XmlAttribute(name = "Pretty", required = true)
	protected String pretty;

	/**
	 * Optional link to the activation group. The starting point is the activation
	 * groups node.
	 */
	@XmlAttribute(name = "ActivationGroup")
	protected String activationGroup;

	/**
	 * The currently defined unit values are: “None”, “Percent”, “Length” (m),
	 * “Mass” (kg), “Time” (s), “Temperature” (K), “LuminousIntensity”(cd), “Angle”
	 * (degree), “Force” (N), “Frequency” (Hz), “Current” (A), “Voltage” (V),
	 * “Power” (W), “Energy” (J), “Area” (m2), “Volume” (m3), “Speed” (m/s),
	 * “Acceleration” (m/s2), “AngularSpeed” (degree/s), “AngularAccc” (degree/s2),
	 * “WaveLength” (nm), “ColorComponent”. Default: “None”.
	 */
	@XmlAttribute(name = "PhysicalUnit")
	protected PhysicalUnitEnum physicalUnit;

	/**
	 * Optional. Defines the color for the attribute.
	 */
	@XmlAttribute(name = "Color")
	protected String color;

	/**
	 * Link to the corresponding feature. The starting point is the feature groups
	 * node.
	 */
	@XmlAttribute(name = "Feature", required = true)
	protected String feature;

	/**
	 * Optional link to the main attribute. The starting point is the attribute
	 * node.
	 */
	@XmlAttribute(name = "MainAttribute")
	protected String mainAttribute;
	
	
	
	public NameHelper getNameAndPretty() {
		return new NameHelper(name, pretty);
	}
	
	public FeatureHelper getFeatureAndPretty() {
		return new FeatureHelper(feature, pretty);
	}

	public List<SubPhysicalUnit> getSubPhysicalUnit() {
		if (subphysicalUnit == null) {
			subphysicalUnit = new ArrayList<SubPhysicalUnit>();
		}
		return this.subphysicalUnit;
	}

	/**
	 * Ruft den Wert der name-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Legt den Wert der name-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Ruft den Wert der pretty-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPretty() {
		return pretty;
	}

	/**
	 * Legt den Wert der pretty-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPretty(String value) {
		this.pretty = value;
	}

	/**
	 * Ruft den Wert der activationGroup-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getActivationGroup() {
		return new GDTFNode(activationGroup, NodeStartingPoint.ActivationGroup);
	}

	/**
	 * Legt den Wert der activationGroup-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setActivationGroup(GDTFNode value) {
		this.activationGroup = value.toGDTF();
	}

	/**
	 * Ruft den Wert der physicalUnit-Eigenschaft ab.
	 * 
	 * @return possible object is {@link PhysicalUnitEnum }
	 * 
	 */
	public PhysicalUnitEnum getPhysicalUnit() {
		if (physicalUnit == null) {
			return PhysicalUnitEnum.NONE;
		} else {
			return physicalUnit;
		}
	}

	/**
	 * Legt den Wert der physicalUnit-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link PhysicalUnitEnum }
	 * 
	 */
	public void setPhysicalUnit(PhysicalUnitEnum value) {
		this.physicalUnit = value;
	}

	/**
	 * Ruft den Wert der color-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFColor getColor() {
		return GDTFColor.fromGDTF(color);
	}

	/**
	 * Legt den Wert der color-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setColor(GDTFColor color) {
		this.color = color.toGDTF();
	}

	/**
	 * Ruft den Wert der feature-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getFeature() {
		return new GDTFNode(feature, NodeStartingPoint.FeatureGroup);
	}

	/**
	 * Legt den Wert der feature-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFeature(GDTFNode value) {
		this.feature = value.toGDTF();
	}

	/**
	 * Ruft den Wert der mainAttribute-Eigenschaft ab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GDTFNode getMainAttribute() {
		return new GDTFNode(mainAttribute, NodeStartingPoint.Attribute);
	}

	/**
	 * Legt den Wert der mainAttribute-Eigenschaft fest.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMainAttribute(GDTFNode value) {
		this.mainAttribute = value.toString();
	}

}
