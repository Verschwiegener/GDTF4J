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
	private NodeSearchPoint startingPoint;

	private int index = 0;
	/**
	 * If the input Path is null this node is invalid and doesnt need to check
	 */
	private boolean valid = true;

	public GDTFNode(String path, NodeSearchPoint startingPoint) {
		if (path == null) {
			valid = false;
		}
		if (path != null && path.contains(".")) {
			nodePath = path.split("\\.");
		} else {
			nodePath = new String[] { path };
		}
		this.startingPoint = startingPoint;
	}

	public GDTFNode(String[] path, NodeSearchPoint startingpoint) {
		nodePath = path;
		this.startingPoint = startingpoint;
	}

	/**
	 * Appends Path Entry to Node
	 * 
	 * @param path
	 */
	public void appendLast(String path) {
		appendLast(new GDTFNode(new String[] { path }, startingPoint));
	}

	/**
	 * Appends Path Entry to Node
	 * 
	 * @param path
	 */
	public void appendFirst(String path) {
		if (path == null)
			valid = false;
		String[] newNodePath = new String[nodePath.length + 1];
		System.arraycopy(nodePath, 0, newNodePath, 1, nodePath.length);
		newNodePath[0] = path;
		nodePath = newNodePath;
	}

	public void appendLast(GDTFNode... node) {
		for (GDTFNode node2 : node) {
			String[] newNodePath = new String[nodePath.length + node2.getNodePath().length];
			// Copy old Content
			System.arraycopy(nodePath, 0, newNodePath, 0, nodePath.length);
			// Append new Node Content
			System.arraycopy(node2.getNodePath(), 0, newNodePath, nodePath.length, node2.getNodePath().length);
			nodePath = newNodePath;
		}
	}

	public String[] getNodePath() {
		return nodePath;
	}

	public boolean checkPoint(NodeSearchPoint point) {
		return startingPoint == point;
	}

	/**
	 * Check given GDTFNode checkNode against this GDTFNode
	 * 
	 * @param checkNode GDTFNode The GDTFNode to check this node against
	 * @return true if we are on the right path, false if not
	 */
	public boolean check(GDTFNode checkNode) {
		// If Path contains null the Node is invalid, is a valid usecase if the node is
		// code generated and some Attribute does not exist in the gdtf file
		if (!valid) {
			System.out.println("Invalid");
			return false;
		}
		if (checkNode.getSearchPoint() == getSearchPoint()) {
			index = 0;
		}
		if (getNodePath()[index] == null) {
			System.out.println("IsNull");
			return false;
		}

		// If this NodePath at the index from the StartingPoint equals the checkNode
		// value we are on the right path and increment the index
		System.out.println("CheckNode: " + getNodePath()[index] + " / " + checkNode.getNodePath()[0]);
		if (getNodePath()[index].equals(checkNode.getNodePath()[0])) {
			System.out.println("Smaller");
			index += 1;
			return true;
		}
		return false;
	}

	public NodeSearchPoint getSearchPoint() {
		return startingPoint;
	}

	// Resets the internal Depth index
	public void reset() {
		index = 0;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public String toGDTF() {
		if (nodePath == null || nodePath.length == 0)
			return "";
		String path = "";
		for (String node : nodePath) {
			path += node + ".";
		}
		return path.substring(0, path.length() - 1);
	}

	/**
	 * The Point this Node can start searching for its target
	 */
	public enum NodeSearchPoint {

		ActivationGroup, FeatureGroup, Attribute, Filter, Emitter, WiringObject, DMXChannel, Wheel, ColorSpace,
		Gammut, DMXMode, DMXProfile, Model

	}

}
