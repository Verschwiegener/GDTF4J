package de.verschwiegener.gdtf.util;

public class GDTFDMXValue {
	
	private byte byteCount;
	private int[] dmxValues;
	
	public GDTFDMXValue(String value) {
		if(value.equals("None"))
			return;
		String[] parts = value.split("/");
		byteCount = Byte.valueOf(parts[1]);
		dmxValues = decodeGDTF(byteCount, Integer.valueOf(parts[0]));
	}
	
	/**
	 * Creates a 8 Bit DMXValue
	 * @param dmxValue
	 * @param bytecount
	 */
	public GDTFDMXValue(int dmxValue, byte channelCount) {
		dmxValues = new int[channelCount];
		dmxValues[0] = dmxValue;
		this.byteCount = channelCount;
	}
	/**
	 *  Special value: null for Default value: “None”.
	 * @param dmxValues
	 */
	public GDTFDMXValue(int[] dmxValues) {
		this.dmxValues = dmxValues;
		byteCount = (byte) dmxValues.length;
	}
	
	public int[] getDmxValues() {
		return dmxValues;
	}
	
	public byte getChannelCount() {
		return byteCount;
	}
	
	/**
	 * Offsets Highest Channel DMX Value by Offset
	 * 
	 * @param offset
	 */
	public void offsetDMX(int offset) {
		dmxValues[dmxValues.length - 1] = dmxValues[dmxValues.length - 1] + offset;
	}
	/**
	 * If DMXValue is Special Value None
	 * 
	 * @return
	 */
	public boolean isNone() {
		return getDmxValues() == null;
	}
	
	public String toGDTF() {
		if(getDmxValues() == null)
			return "None";
		return encodeGDTF(dmxValues) + "/" + byteCount;
	}
	
	
	/**
	 * Encodes GDTF Value
	 * 
	 * @param dmxValue int Array containing dmx Value
	 * 
	 * @return 8/16Bit encoded DMX Value
	 */
	private int encodeGDTF(int[] dmxValue) {
		if(dmxValue.length == 1) return dmxValue[0];
		float fine = (dmxValue[1] / 256.0f);
		float gdtfValue = (dmxValue[0] + fine) * 256.0f;
		return (Math.round(gdtfValue));
	}
	
	/**
	 * Decodes 8/16 Bit DMX Value into int[]
	 * 
	 * @param bytecount int Count how many bytes are encoded in dmxValue
	 * @param dmxValue encoded dmxValues
	 * @return int[] containing decoded dmxValues
	 */
	private int[] decodeGDTF(int bytecount, int dmxValue) {
		int[] values = new int[bytecount];
		if(bytecount == 1) {
			values[0] = dmxValue;
			return values;
		}
		float f = dmxValue / 256.0f;
		int rough = (int) f;
		values[0] = rough;
		int fine = (int) ((f - rough) * 256);
		values[1] = fine;
		return values;
	}
	
	@Override
	public String toString() {
		return toGDTF();
	}
	
}
