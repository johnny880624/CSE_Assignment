package assignment6.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment6.RecursiveMethods;
import assignment6.dragon.Dragons;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DragonTest {
	private final int n;
	private final String expected;

	public DragonTest(int n, String expected) {
		this.n = n;
		this.expected = expected;
	}

	@Test
	public void test() {
		String actual = RecursiveMethods.dragon(n);
		assertEquals(expected, actual);
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		int i = 0;
		while (true) {
			Optional<String> expectedOpt = Dragons.getExpected(i);
			if (expectedOpt.isPresent()) {
				args.add(new Object[] { i, expectedOpt.get() });
			} else {
				break;
			}
			++i;
			if (i >= 10) {
				// the most common incorrect implementation of dragon can produce some long strings
				// we cut off the testing at 9 to prevent the test suite from taking too long
				break;
			}
		}
		return args;
	}
}
