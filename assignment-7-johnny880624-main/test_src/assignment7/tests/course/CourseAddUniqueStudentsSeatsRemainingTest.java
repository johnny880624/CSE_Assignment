package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import assignment7.tests.util.StudentCourseUtils;
import test.cse131.UnitTestUtils;
import assignment7.Course;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#addStudent(Student)}
 */
@RunWith(Parameterized.class)
public class CourseAddUniqueStudentsSeatsRemainingTest {
	private final int capacity;

	public CourseAddUniqueStudentsSeatsRemainingTest(int capacity) {
		this.capacity = capacity;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testAllUnique() {
		Course course = new Course("CSE 131", 3, capacity);
		assertEquals(capacity, course.getCapacity());

		Student[] students = StudentCourseUtils.generateUniqueStudents(capacity * 2);

		assertEquals(capacity, course.getSeatsRemaining());
		for (int i = 0; i < capacity; ++i) {
			boolean actualStatus = course.addStudent(students[i]);
			assertTrue(actualStatus);

			int actualSeatsRemaining = course.getSeatsRemaining();
			int expectedSeatsRemaining = capacity - (i + 1);
			assertEquals(expectedSeatsRemaining, actualSeatsRemaining);
			assertEquals(capacity, course.getCapacity());
		}

		for (int i = capacity; i < students.length; ++i) {
			boolean actualStatus = course.addStudent(students[i]);
			assertFalse(actualStatus);
			assertEquals(0, course.getSeatsRemaining());
			assertEquals(capacity, course.getCapacity());
		}
	}

	@Parameters(name = "capacity: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 8 });
		result.add(new Object[] { 131 });

		Random random = new Random();
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			int capacity = 10 + random.nextInt(700);
			result.add(new Object[] { capacity });
		}

		return result;
	}
}