package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
 *         {@link Student#createLegacy(String, Student, boolean, int)}
 */
@RunWith(Parameterized.class)
public class StudentLegacyBearBucksTest {
	private final double aBalance;
	private final double bBalance;
	private final double expected;

	public StudentLegacyBearBucksTest(double aBalance, double bBalance, double expected) {
		this.aBalance = aBalance;
		this.bBalance = bBalance;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testBearBucks() {
		Student parentA = new Student("Aaa", "Bbb", 1);
		parentA.depositBearBucks(aBalance);

		Student parentB = new Student("Ccc", "Ddd", 2);
		parentB.depositBearBucks(bBalance);

		Student legacy = parentA.createLegacy("Eee", parentB, true, 3);
		assertEquals(expected, legacy.getBearBucksBalance(), UnitTestUtils.reasonableDelta());

		assertEquals(0.0, parentA.getBearBucksBalance(), 0.0);
		assertEquals(0.0, parentB.getBearBucksBalance(), 0.0);
	}

	@Parameters(name = "a: {0}; b: {1}; expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 0.0, 0.0, 0.0 });
		result.add(new Object[] { 9.99, 0.0, 0.0 });
		result.add(new Object[] { 0, 9.99, 0.0 });
		result.add(new Object[] { 100.0, 0.0, 90.0 });
		result.add(new Object[] { 100.0, 9.99, 90.0 });
		result.add(new Object[] { 0.0, 100.0, 90.0 });
		result.add(new Object[] { 9.99, 100.0, 90.0 });
		result.add(new Object[] { 200.0, 300.0, 480.0 });
		return result;
	}
}
