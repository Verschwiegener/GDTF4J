package de.verschwiegener.gdtf.util;

public class GDTFNode {

	/**
	 * Node Path
	 */
	private String[] nodePath;
	
	/**
	 * Starting Point of the Node
	 */
	private NodeStartingPoint startingPoint;
	
	public GDTFNode(String path, NodeStartingPoint startingPoint) {
		nodePath = path.split(".");
		this.startingPoint = startingPoint;
	}
	public GDTFNode(String[] path, NodeStartingPoint startingpoint) {
		nodePath = path;
		this.startingPoint = startingpoint;
	}
	
	
	/**
	 * Appends Path Entry to Node
	 * @param path
	 */
	public void appendLast(String path) {
		appendLast(new GDTFNode(new String[] {path}, startingPoint));
	}
	
	
	/**
	 * Appends Path Entry to Node
	 * @param path
	 */
	public void appendFirst(String path) {
		String[] newNodePath = new String[nodePath.length + 1];
		System.arraycopy(nodePath, 0, newNodePath,1, newNodePath.length);
		newNodePath[0] = path;
		nodePath = newNodePath;
	}
	
	public void appendLast(GDTFNode... node) {
		for(GDTFNode node2 : node) {
			String[] newNodePath = new String[nodePath.length + node2.getNodePath().length];
			System.arraycopy(node2.getNodePath(), 0, newNodePath, 0, newNodePath.length);
			nodePath = newNodePath;
		}
	}
	
	public String[] getNodePath() {
		return nodePath;
	}
	public boolean checkPoint(NodeStartingPoint point) {
		return startingPoint == point;
	}
	
	public NodeStartingPoint getStartingPoint() {
		return startingPoint;
	}
	
	
	public String toGDTF() {
		if(nodePath == null || nodePath.length == 0)
			return "";
		String path = "";
		for(String node : nodePath) {
			path += node + ".";
		}
		return path.substring(0, path.length() - 1);
	}
	
	public enum NodeStartingPoint {
		
		ActivationGroup,
		FeatureGroup,
		Attribute,
		Filter,
		Emitter,
		WiringObject,
		DMXChannel,
		Wheel,
		PhysicalDescription,
		Gammut,
		DMXMode,
		DMXProfile,
		Model
		
	}
	
}
