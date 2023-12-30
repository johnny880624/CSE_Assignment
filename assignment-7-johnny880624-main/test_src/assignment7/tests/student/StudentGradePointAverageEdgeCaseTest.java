package assignment7.tests.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#submitGrade(double, int)}
 *         {@link Student#calculateGradePointAverage()}
 */
public class StudentGradePointAverageEdgeCaseTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testNotANumber() {
		Student student = new Student("Daniel", "SimpsonDay", 2);
		assertTrue(Double.isNaN(student.calculateGradePointAverage()));
	}

	@Test
	public void testZeroPointZero() {
		Student student = new Student("John", "Blutarsky", 3);
		student.submitGrade(0.0, 3);
		student.submitGrade(0.0, 3);
		student.submitGrade(0.0, 3);
		student.submitGrade(0.0, 3);

		assertEquals(0.0, student.calculateGradePointAverage(), UnitTestUtils.reasonableDelta());
	}
}
