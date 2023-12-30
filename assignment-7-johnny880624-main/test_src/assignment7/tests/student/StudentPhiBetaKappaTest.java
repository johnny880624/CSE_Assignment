package assignment7.tests.student;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
 *         {@link Student#submitGrade(double, int)}
 *         {@link Student#isEligibleForPhiBetaKappa()}
 */
@RunWith(Parameterized.class)
public class StudentPhiBetaKappaTest {
	private final double grade;
	private final int credits;
	private final boolean expected;

	public StudentPhiBetaKappaTest(double grade, int credits, boolean expected) {
		this.grade = grade;
		this.credits = credits;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student("A", "B", 1);
		student.submitGrade(grade, credits);
		boolean isEligibleForPhiBetaKappa = student.isEligibleForPhiBetaKappa();
		if (expected) {
			assertTrue(isEligibleForPhiBetaKappa);
		} else {
			assertFalse(isEligibleForPhiBetaKappa);
		}
	}

	@Parameters(name = "grade: {0}, credits: {1}; expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();

		for (double grade : new double[] { 3.9, 3.8 }) {
			result.add(new Object[] { grade, 74, false });
			result.add(new Object[] { grade, 75, true });
			result.add(new Object[] { grade, 76, true });
			result.add(new Object[] { grade, 97, true });
			result.add(new Object[] { grade, 98, true });
			result.add(new Object[] { grade, 99, true });
		}

		for (double grade : new double[] { 3.7, 3.6 }) {
			result.add(new Object[] { grade, 74, false });
			result.add(new Object[] { grade, 75, false });
			result.add(new Object[] { grade, 76, false });
			result.add(new Object[] { grade, 97, false });
			result.add(new Object[] { grade, 98, true });
			result.add(new Object[] { grade, 99, true });
		}

		for (int credits : new int[] { 1, 71, 87, 131, 1853 }) {
			result.add(new Object[] { 3.5, credits, false });
		}

		return result;
	}
}
