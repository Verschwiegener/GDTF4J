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
		
	}
	
	
	public ArrayList<SimpleSet> getSimpleSet() {
		return simpleSet;
	}
	
	
	
	public class SimpleSet {
		
		private GDTFDMXValue dmxFrom;
		private GDTFDMXValue dmxTo;
		
		private String name;
		
		public SimpleSet(GDTFDMXValue dmxFrom, GDTFDMXValue dmxTo, String name) {
		}
		
	}

}
