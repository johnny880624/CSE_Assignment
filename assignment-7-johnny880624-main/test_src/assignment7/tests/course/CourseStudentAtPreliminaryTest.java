package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Course;
import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#getStudentAt(int)}
 */
public class CourseStudentAtPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		int capacity = 2;
		Course course = new Course("CSE 131", 3, capacity);
		assertEquals(capacity, course.getCapacity());
		assertEquals(capacity, course.getSeatsRemaining());

		for (int i = 0; i < capacity; ++i) {
			assertNull(course.getStudentAt(i));
		}
		Student ronCytron = new Student("Ron", "Cytron", 1);
		boolean status = course.addStudent(ronCytron);
		assertTrue(status);
		assertEquals(capacity, course.getCapacity());
		assertEquals(capacity - 1, course.getSeatsRemaining());

		Student actual0 = course.getStudentAt(0);
		assertSame(ronCytron, actual0);
		for (int i = 1; i < capacity; ++i) {
			assertNull(course.getStudentAt(i));
		}
	}
}
