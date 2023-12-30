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
 *         {@link Student#cashOutBearBucks()}
 */
@RunWith(Parameterized.class)
public class StudentCashOutBearBucksTest {
	private final double balance;
	private final double expected;

	public StudentCashOutBearBucksTest(double balance, double expected) {
		this.balance = balance;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testBearBucks() {
		Student student = new Student("Aaa", "Bbb", 1);
		student.depositBearBucks(balance);
		double actual = student.cashOutBearBucks();
		assertEquals(expected, actual, UnitTestUtils.reasonableDelta());
		assertEquals(0.0, student.getBearBucksBalance(), 0.0);
	}

	@Parameters(name = "balance: {0}; expected: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 0.0, 0.0 });
		result.add(new Object[] { 9.99, 0.0 });
		result.add(new Object[] { 10.00, 0.0 });
		result.add(new Object[] { 10.01, 0.01 });
		result.add(new Object[] { 131.00, 121.00 });
		result.add(new Object[] { 231.00, 221.00 });
		result.add(new Object[] { 425.00, 415.00 });
		return result;
	}
}
