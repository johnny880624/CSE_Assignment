package assignment6.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment6.RecursiveMethods;
import support.cse131.PrimitiveArrays;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class ArraySumComprehensiveTest {
	private final int[] original;
	private final int expected;

	public ArraySumComprehensiveTest(List<Integer> values) {
		this.original = PrimitiveArrays.toIntArray(values);
		this.expected = values.stream().reduce(0, Integer::sum);
	}

	@Test
	public void test() {
		int[] copyToPass = Arrays.copyOf(original, original.length);
		int actual = RecursiveMethods.arraySum(copyToPass);

		String mutatedMessage = "Do not mutate (change) the parameter passed in.";
		assertArrayEquals(mutatedMessage, original, copyToPass);

		assertEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		args.add(new Object[] { Arrays.asList() });
		args.add(new Object[] { Arrays.asList(0) });
		args.add(new Object[] { Arrays.asList(1) });
		args.add(new Object[] { Arrays.asList(42) });
		args.add(new Object[] { Arrays.asList(0, 0) });
		args.add(new Object[] { Arrays.asList(1, 1) });
		args.add(new Object[] { Arrays.asList(1, 2, 3, 4) });
		args.add(new Object[] { Arrays.asList(1, -2, 3, -4) });

		List<Integer> gauss = new ArrayList<Integer>(100);
		for (int i = 1; i <= 100; ++i) {
			gauss.add(i);
		}
		args.add(new Object[] { gauss });

		Random random = new Random();
		for (int i = 0; i < 12; ++i) {
			int length = 23 + random.nextInt(42);
			List<Integer> randomValues = new ArrayList<Integer>(length);
			for (int j = 0; j < length; ++j) {
				randomValues.add(random.nextInt(1000)-500);
			}
			args.add(new Object[] { randomValues });
		}
		return args;
	}
}
