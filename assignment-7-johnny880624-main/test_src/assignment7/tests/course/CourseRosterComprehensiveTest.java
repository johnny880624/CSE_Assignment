package assignment7.tests.course;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

import assignment7.tests.util.StudentCourseUtils;
import test.cse131.UnitTestUtils;
import assignment7.Course;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#generateRoster()}
 */
@RunWith(Parameterized.class)
public class CourseRosterComprehensiveTest {
	private final int capacity;
	private final int enrollment;

	public CourseRosterComprehensiveTest(int capacity, int enrollment) {
		this.capacity = capacity;
		this.enrollment = enrollment;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course("CSE 131", 3, capacity);

		Student[] students = StudentCourseUtils.generateRandomStudentsWithNamesNotContainingNull(enrollment);

		int enrollCount = 0;
		for (Student student : students) {
			assertTrue(course.addStudent(student));
			enrollCount++;
			assertEquals(capacity, course.getCapacity());
			assertEquals(capacity - enrollCount, course.getSeatsRemaining());
		}

		String rosterRepresentation = course.generateRoster();
		assertThat(rosterRepresentation, not(containsString("null")));
		for (Student student : students) {
			assertThat(rosterRepresentation, containsString(student.getFullName()));
		}
	}

	@Parameters(name = "capacity: {0}; enrollment: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 1, 1 });
		result.add(new Object[] { 2, 1 });
		result.add(new Object[] { 10, 10 });
		result.add(new Object[] { 11, 10 });
		result.add(new Object[] { 131, 131 });
		result.add(new Object[] { 231, 131 });
		return result;
	}
}
