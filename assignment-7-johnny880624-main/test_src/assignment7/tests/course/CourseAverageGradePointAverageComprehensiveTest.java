package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
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
 *         {@link Course#calculateAverageGPA()}
 */
@RunWith(Parameterized.class)
public class CourseAverageGradePointAverageComprehensiveTest {
	private final int enrollment;
	private final int capacity;
	private final boolean isCreditVariable;

	public CourseAverageGradePointAverageComprehensiveTest(int enrollment, int capacity, boolean isCreditVariable) {
		this.enrollment = enrollment;
		this.capacity = capacity;
		this.isCreditVariable = isCreditVariable;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course("CSE 131", 3, capacity);

		Student[] students = StudentCourseUtils.generateUniqueStudentsWithRandomGradePointAverages(enrollment,
				isCreditVariable);

		int enrollCount = 0;
		for (Student student : students) {
			assertTrue(course.addStudent(student));
			enrollCount++;
			assertEquals(capacity, course.getCapacity());
			assertEquals(capacity - enrollCount, course.getSeatsRemaining());
		}

		double totalGPA = Arrays.asList(students).stream().mapToDouble(student -> student.calculateGradePointAverage()).sum();
		double expected = totalGPA / enrollment;

		double actual = course.calculateAverageGPA();
		assertEquals(expected, actual, UnitTestUtils.reasonableDelta());

	}

	@Parameters(name = "enrollment: {0}; capacity: {1}; isCreditVariable: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		for (boolean isCreditVariable : new boolean[] { false, true }) {
			result.add(new Object[] { 1, 1, isCreditVariable });
			result.add(new Object[] { 1, 2, isCreditVariable });
			result.add(new Object[] { 10, 10, isCreditVariable });
			result.add(new Object[] { 10, 11, isCreditVariable });
			result.add(new Object[] { 131, 131, isCreditVariable });
			result.add(new Object[] { 131, 231, isCreditVariable });
		}
		return result;
	}
}
