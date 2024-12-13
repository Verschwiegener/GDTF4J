package de.verschwiegener.gdtf.util;

import java.util.Arrays;

public class GDTFNode {

	/**
	 * Node Path
	 */
	private String[] nodePath;
	
	/**
	 * Starting Point of the Node
	 */
	private NodeStartingPoint startingPoint;
	
	private int index = 0;
	
	public GDTFNode(String path, NodeStartingPoint startingPoint) {
		if(path != null && path.contains(".")) {
			nodePath = path.split("\\.");
		}else {
			nodePath = new String[] {path};
		}
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
		System.arraycopy(nodePath, 0, newNodePath,1, nodePath.length);
		newNodePath[0] = path;
		nodePath = newNodePath;
	}
	
	public void appendLast(GDTFNode... node) {
		for(GDTFNode node2 : node) {
			String[] newNodePath = new String[nodePath.length + node2.getNodePath().length];
			//Copy old Content
			System.arraycopy(nodePath, 0, newNodePath, 0, nodePath.length);
			//Append new Node Content
			System.arraycopy(node2.getNodePath(), 0, newNodePath, nodePath.length, node2.getNodePath().length);
			nodePath = newNodePath;
		}
	}
	
	public String[] getNodePath() {
		return nodePath;
	}
	public boolean checkPoint(NodeStartingPoint point) {
		return startingPoint == point;
	}
	
	/**
	 * Check given GDTFNode checkNode against this GDTFNode
	 * 
	 * @param checkNode GDTFNode The GDTFNode to check this node against
	 * @return true if we are on the right path, false if not
	 */
	public boolean check(GDTFNode checkNode) {
		if(checkNode.getStartingPoint() == getStartingPoint()) {
			index = 0;
		}
		
		// If this NodePath at the index from the StartingPoint equals the checkNode
		// value we are on the right path and increment the index
		if(getNodePath()[index].equals(checkNode.getNodePath()[0])) {
			if(index < getNodePath().length - 1) {
				index +=1;
			}
			return true;
		}
		return false;
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
