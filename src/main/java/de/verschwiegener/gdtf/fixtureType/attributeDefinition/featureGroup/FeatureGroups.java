//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2024.03.01 um 02:31:37 PM CET 
//


package de.verschwiegener.gdtf.fixtureType.attributeDefinition.featureGroup;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.verschwiegener.gdtf.util.GDTFNode;
import de.verschwiegener.gdtf.util.GDTFNode.NodeStartingPoint;
import de.verschwiegener.gdtf.util.GDTFUtils.NameHelper;


/**
 * <p>Java-Klasse für FeatureGroups complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FeatureGroups"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FeatureGroup" type="{}FeatureGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureGroups", propOrder = {
    "featureGroup"
})
public class FeatureGroups {

    @XmlElement(name = "FeatureGroup")
    protected List<FeatureGroup> featureGroup;

    /**
     * Gets the value of the featureGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeatureGroup }
     * 
     * 
     */
    public List<FeatureGroup> getFeatureGroup() {
        if (featureGroup == null) {
            featureGroup = new ArrayList<FeatureGroup>();
        }
        return this.featureGroup;
    }
    
    /**
     * Returns first FeatureGroup with given name, or null if nothing was found
     * @param name String to Search for
     */
    public FeatureGroup getFeatureGroupByName(String name) {
    	return getFeatureGroup().stream().filter(group -> group.getName().equals(name)).findFirst().orElse(null);
    }
    
    /**
     * Returns all Features of a given FeatureGroup as a String Array
     * @param groupName String FeatureGroup Name to get Features from
     */
    public String[] getFeaturesFromGroup(String groupName) {
    	FeatureGroup group = getFeatureGroupByName(groupName);
    	String[] features = new String[group.getFeature().size()];
    	for(int i = 0; i < group.getFeature().size();i++) {
    		features[i] = group.getFeature().get(i).getName();
    	}
    	return features;
    }
    /**
     * Returns Name and Pretty Name of all Feature groups as a NameHelper Array
     * @return String[] {NameHelper}
     */
    public NameHelper[] getFeatureGroupNameAndPretty() {
    	NameHelper[] featureGroupNameAndPretty = new NameHelper[getFeatureGroup().size()];
    	for(int i = 0; i < getFeatureGroup().size();i++) {
    		FeatureGroup group = getFeatureGroup().get(i);
    		featureGroupNameAndPretty[i] = new NameHelper(group.getName(), group.getPretty());
    	}
    	return featureGroupNameAndPretty;
    }
    
    /**
     * Returns all Features in GDTF XML Node Representation (FeatureGroupName.FeatureName)
     */
    public ArrayList<String> getFeatures() {
    	ArrayList<String> featureGroupFeatures = new ArrayList<String>();
    	getFeatureGroup().forEach(featureG -> {
    		featureG.feature.forEach(feature -> {
    			featureGroupFeatures.add(featureG.getName() + "." + feature.getName());
    		});
    	});
    	return featureGroupFeatures;
    }
    
    
    
    public FeatureGroup getFeatureGroup(GDTFNode node) {
    	if(!node.checkPoint(NodeStartingPoint.FeatureGroup))
			return null;
    	return getFeatureGroup().stream().filter(fg -> fg.name.equals(node.getNodePath()[0])).findFirst().orElse(null);
    }
    
    public Feature getFeature(GDTFNode node) {
    	if(!node.checkPoint(NodeStartingPoint.FeatureGroup))
			return null;
    	return getFeatureGroup(node).getFeature(node);
    }
    
    
    
    

}
