package assignment6.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class ExponentParameterizedTest {
	private final int base;
	private final int exponent;
	private final double expected;

	public ExponentParameterizedTest(int base, int exponent, double expected) {
		super();
		this.base = base;
		this.exponent = exponent;
		this.expected = expected;
	}

	@Test
	public void test() {
		double actual = RecursiveMethods.exponent(base, exponent);
		double acceptableDelta = 0.000001;
		assertEquals(expected, actual, acceptableDelta);
	}

	@Parameterized.Parameters(name = "{0} ^ {1} = {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();

		// specific cases
		args.add(new Object[] { 1, 1, 1.0 });
		args.add(new Object[] { 1, 42, 1.0 });
		args.add(new Object[] { 1, -32, 1.0 });
		args.add(new Object[] { -1, 1, -1.0 });
		args.add(new Object[] { -1, 42, 1.0 });
		args.add(new Object[] { -1, -32, 1.0 });
		args.add(new Object[] { 2, 3, 8.0 });
		args.add(new Object[] { 2, -3, 0.125 });
		args.add(new Object[] { -2, 3, -8.0 });
		args.add(new Object[] { -2, -3, -0.125 });
		args.add(new Object[] { 3, 2, 9.0 });
		args.add(new Object[] { 3, -2, 0.1111111111111111 });
		args.add(new Object[] { -3, 2, 9.0 });
		args.add(new Object[] { -3, -2, 0.1111111111111111 });
		args.add(new Object[] { 131, 0, 1.0 });
		args.add(new Object[] { 131, 1, 131.0 });
		args.add(new Object[] { 131, 2, 17161.0 });
		args.add(new Object[] { 131, -1, 0.007633587786259542 });
		args.add(new Object[] { 131, -2, 5.8271662490530857E-5 });
		args.add(new Object[] { 0, 1, 0.0 });
		args.add(new Object[] { 0, 42, 0.0 });
		args.add(new Object[] { 0, 0, 1.0 });
		args.add(new Object[] { 0, -1, Double.POSITIVE_INFINITY });
		args.add(new Object[] { 0, -42, Double.POSITIVE_INFINITY });

		return args;
	}
}
