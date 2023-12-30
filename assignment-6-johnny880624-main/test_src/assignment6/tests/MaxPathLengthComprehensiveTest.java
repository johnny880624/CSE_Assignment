package assignment6.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment6.RecursiveMethods;
import assignment6.maxpath.MaxPathLengthScenarios;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class MaxPathLengthComprehensiveTest {
	private final boolean[][] originalChart;
	private final int row0;
	private final int col0;
	private final int expected;

	public MaxPathLengthComprehensiveTest(String description, String scenario) {
		this.originalChart = MaxPathLengthScenarios.parseStones(scenario);
		this.row0 = MaxPathLengthScenarios.parseRow0(scenario);
		this.col0 = MaxPathLengthScenarios.parseColumn0(scenario);
		this.expected = MaxPathLengthScenarios.lookupExpected(scenario);
	}

	@Test
	public void test() {
		boolean[][] copyOfChart = MaxPathLengthTestUtils.copy2DArray(originalChart);
		int actual = RecursiveMethods.maxPathLength(copyOfChart, row0, col0);

		String message = MaxPathLengthTestUtils.toChartNotRestoredToOriginalStateMessage(originalChart, copyOfChart);
		assertArrayEquals(message, originalChart, copyOfChart);
		
		assertEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "{0}; {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		for (String scenario : MaxPathLengthScenarios.scenariosAsArray()) {
			args.add(new Object[] { MaxPathLengthScenarios.lookupDescription(scenario), scenario });
		}
		return args;
	}
}
