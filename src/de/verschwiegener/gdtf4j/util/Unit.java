package de.verschwiegener.gdtf4j.util;

public class Unit<T, F> {

	private T value;
	Class<F> type;
	private ValueUnit unit;

	public Unit(T value, Class<F> type, ValueUnit unit) {
		this.value = value;
		this.type = type;
		this.unit = unit;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ValueUnit getUnit() {
		return unit;
	}

	public void setUnit(ValueUnit unit) {
		this.unit = unit;
	}

}
