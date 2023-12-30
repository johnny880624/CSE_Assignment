package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import assignment7.Student;
import test.cse131.UnitTestUtils;
/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#depositBearBucks(double)}
 *         {@link Student#deductBearBucks(double)}
 *         {@link Student#getBearBucksBalance()}
 */
@RunWith(Parameterized.class)
public class StudentBearBucksTest {
	private final List<Double> amounts;

	public StudentBearBucksTest(List<Double> amounts) {
		this.amounts = amounts;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student("A", "B", 1);
		double expected = 0.0;
		for (double amount : amounts) {
			if (amount < 0.0) {
				student.deductBearBucks(-amount);
			} else {
				student.depositBearBucks(amount);
			}
			expected += amount;
			double actual = student.getBearBucksBalance();
			assertEquals(expected, actual, UnitTestUtils.reasonableDelta());
		}
	}

	@Parameters(name = "gradeCreditPairs:{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { Arrays.asList() });
		result.add(new Object[] { Arrays.asList(1.0) });
		result.add(new Object[] { Arrays.asList(1.0, 2.0) });
		result.add(new Object[] { Arrays.asList(3.0, -2.0) });
		result.add(new Object[] { Arrays.asList(10.0, -2.0, -3.0) });
		result.add(new Object[] { Arrays.asList(10.0, -2.0, -3.0, 4.0) });
		result.add(new Object[] { Arrays.asList(10.0, -2.0, -3.0, 4.0, -5.0) });

		Random random = new Random();
		for (int i = 0; i < 10; ++i) {
			final int CAPACITY = 10;
			List<Double> amounts = new ArrayList<>(CAPACITY);
			double total = 0.0;
			for (int j = 0; j < CAPACITY; ++j) {
				double r = random.nextInt(4000) * 0.25;
				if (r < total) {
					if (random.nextBoolean()) {
						r = -r;
					}
				}
				amounts.add(r);
				total += r;
			}
			result.add(new Object[] { amounts });
		}

		return result;
	}
}
