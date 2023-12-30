package assignment6.tests;

import java.util.Arrays;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class MaxPathLengthTestUtils {
	static boolean[][] copy2DArray(boolean[][] source) {
		boolean[][] copy = new boolean[source.length][];
		for (int i = 0; i < source.length; i++) {
			copy[i] = Arrays.copyOf(source[i], source[i].length);
		}
		return copy;
	}

	static String toChartNotRestoredToOriginalStateMessage(boolean[][] originalChart, boolean[][] copyOfChart) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOften, we refrain from mutating (changing) parameters which are passed to our methods.\n");
		sb.append("In this case it is not only acceptable, it is encouraged.\n");
		sb.append("However, it is critical that your changes be only temporary.\n");
		sb.append("The correct implementation of this method requires that you undo your changes (at the appropriate time).\n");
		sb.append("\noriginal");
		sb.append("\n========\n");
		sb.append(toString(originalChart));
		sb.append("\n\nmutated (changed)");
		sb.append("\n=================\n");
		sb.append(toString(copyOfChart));
		sb.append("\n\n");
		return sb.toString();
	}
	
	private static String toString(boolean[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for(boolean[] array: matrix) {
			sb.append(Arrays.toString(array)).append("\n");
		}
		return sb.toString();
	}

}
