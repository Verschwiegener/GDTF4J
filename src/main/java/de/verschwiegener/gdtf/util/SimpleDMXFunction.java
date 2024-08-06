package de.verschwiegener.gdtf.util;

import java.util.ArrayList;

public class SimpleDMXFunction {
	
	/**
	 * Node to the ChannelFunction
	 */
	private GDTFNode node;
	
	private int[] dmxOffset;
	
	private GDTFDMXValue dmxFrom;
	private GDTFDMXValue dmxTo;
	private GDTFDMXValue dmxDefault;
	
	
	private String name;
	private String customName;
	private GDTFNode attribute;
	
	private ArrayList<SimpleSet> simpleSet = new ArrayList<>();
	
	
	
	public SimpleDMXFunction(GDTFNode node, int[] dmxOffset, GDTFDMXValue[] dmxRange, GDTFDMXValue dmxDefault, String name, String customName, GDTFNode attribute) {
		this.node  = node;
		this.dmxOffset = dmxOffset;
		this.dmxFrom = dmxRange[0];
		this.dmxTo = dmxRange[1];
		this.dmxDefault = dmxDefault;
		this.name = name;
		this.customName = customName;
		this.attribute = attribute;
	}
	
	
	public ArrayList<SimpleSet> getSimpleSet() {
		return simpleSet;
	}
	
	public GDTFNode getNode() {
		return node;
	}


	public int[] getDmxOffset() {
		return dmxOffset;
	}


	public GDTFDMXValue getDmxFrom() {
		return dmxFrom;
	}


	public GDTFDMXValue getDmxTo() {
		return dmxTo;
	}


	public GDTFDMXValue getDmxDefault() {
		return dmxDefault;
	}


	public String getName() {
		return name;
	}


	public String getCustomName() {
		return customName;
	}


	public GDTFNode getAttribute() {
		return attribute;
	}





	public class SimpleSet {
		
		private GDTFDMXValue dmxFrom;
		private GDTFDMXValue dmxTo;
		
		private String name;
		
		public SimpleSet(GDTFDMXValue dmxFrom, GDTFDMXValue dmxTo, String name) {
		}
		
	}

}
