package de.verschwiegener.gdtf.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Matrix as GDTF stores it, row by row: {@code {u1,v1,w1,o1}{u2,v2,w2,o2}{u3,v3,w3,o3}{0,0,0,1}}. The columns u,
 * v and w are the axes, o is the offset. Lengths are in meters like everywhere in GDTF.
 * <p>
 * Also used for the 3x3 rotation of prism facets. Immutable.
 */
public final class GdtfMatrix {

	public static final GdtfMatrix IDENTITY = new GdtfMatrix(4, 4,
			new double[] { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 });

	private final int rows;
	private final int columns;
	private final double[] values;

	private GdtfMatrix(int rows, int columns, double[] values) {
		this.rows = rows;
		this.columns = columns;
		this.values = values;
	}

	/**
	 * @param text Matrix as in the file, e.g. {@code "{1,0,0,0}{0,1,0,0}{0,0,1,0.5}{0,0,0,1}"}
	 * @return {@link #IDENTITY} if the text is missing or blank
	 * @throws IllegalArgumentException if the rows have different lengths or contain no numbers
	 */
	public static GdtfMatrix parse(String text) {
		if (text == null || text.isBlank())
			return IDENTITY;
		List<double[]> parsed = new ArrayList<>();
		int start = text.indexOf('{');
		while (start >= 0) {
			int end = text.indexOf('}', start);
			if (end < 0)
				throw new IllegalArgumentException("Unclosed row in matrix: " + text);
			String[] parts = text.substring(start + 1, end).split(",");
			double[] row = new double[parts.length];
			try {
				for (int i = 0; i < parts.length; i++)
					row[i] = Double.parseDouble(parts[i].strip());
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Invalid matrix: " + text, e);
			}
			parsed.add(row);
			start = text.indexOf('{', end);
		}
		if (parsed.isEmpty())
			throw new IllegalArgumentException("Invalid matrix: " + text);
		int columns = parsed.get(0).length;
		double[] values = new double[parsed.size() * columns];
		for (int r = 0; r < parsed.size(); r++) {
			if (parsed.get(r).length != columns)
				throw new IllegalArgumentException("Rows of matrix have different lengths: " + text);
			System.arraycopy(parsed.get(r), 0, values, r * columns, columns);
		}
		return new GdtfMatrix(parsed.size(), columns, values);
	}

	public int rows() {
		return rows;
	}

	public int columns() {
		return columns;
	}

	public double get(int row, int column) {
		if (row < 0 || row >= rows || column < 0 || column >= columns)
			throw new IndexOutOfBoundsException("No element " + row + "," + column + " in " + rows + "x" + columns);
		return values[row * columns + column];
	}

	/**
	 * @return The offset {@code {o1, o2, o3}} in meters, zero for matrices without offset column
	 */
	public double[] translation() {
		if (rows < 3 || columns < 4)
			return new double[3];
		return new double[] { get(0, 3), get(1, 3), get(2, 3) };
	}

	/**
	 * @return The values row by row
	 */
	public double[] toArray() {
		return values.clone();
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof GdtfMatrix matrix && rows == matrix.rows && columns == matrix.columns
				&& Arrays.equals(values, matrix.values);
	}

	@Override
	public int hashCode() {
		return 31 * (31 * rows + columns) + Arrays.hashCode(values);
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for (int r = 0; r < rows; r++) {
			text.append('{');
			for (int c = 0; c < columns; c++) {
				if (c > 0)
					text.append(',');
				text.append(get(r, c));
			}
			text.append('}');
		}
		return text.toString();
	}

}
