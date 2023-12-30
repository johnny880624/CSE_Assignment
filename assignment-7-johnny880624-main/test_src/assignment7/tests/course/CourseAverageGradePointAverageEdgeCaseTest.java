package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Course;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#calculateAverageGPA()}
 */
public class CourseAverageGradePointAverageEdgeCaseTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testNotANumber() {
		Course course = new Course("Meets On Friday", 3, 999);
		assertEquals(course.getCapacity(), course.getSeatsRemaining());
		assertTrue(Double.isNaN(course.calculateAverageGPA()));
	}
}
