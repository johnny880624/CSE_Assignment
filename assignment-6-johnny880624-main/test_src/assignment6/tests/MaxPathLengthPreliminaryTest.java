package assignment6.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MaxPathLengthPreliminaryTest {
	@Test
	public void test() {
		// . . .
		// . * .
		// . . .
		boolean[][] originalChart = { { false, false, false }, { false, true, false }, { false, false, false } };

		boolean[][] copyOfChart = MaxPathLengthTestUtils.copy2DArray(originalChart);

		int rowStart = 1;
		int colStart = 1;
		int actual = RecursiveMethods.maxPathLength(copyOfChart, rowStart, colStart);

		String message = MaxPathLengthTestUtils.toChartNotRestoredToOriginalStateMessage(originalChart, copyOfChart);
		assertArrayEquals(message, originalChart, copyOfChart);

		int expected = 1;
		assertEquals(expected, actual);
	}
}
