package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.tests.util.StudentCourseUtils;
import test.cse131.UnitTestUtils;
import assignment7.Course;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#addStudent(Student)}
 */
public class CourseAddStudentComprehensiveTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		int capacity = 700;
		Course course = new Course("CSE 131", 3, capacity);
		assertEquals(capacity, course.getCapacity());
		assertEquals(capacity, course.getSeatsRemaining());

		List<Student> remainingCandidates = new LinkedList<>(
				Arrays.asList(StudentCourseUtils.generateUniqueStudents(capacity + 100)));
		List<Student> enrolled = new LinkedList<>();

		Random random = new Random();
		while (enrolled.size() < capacity) {
			boolean isCollisionDesired = enrolled.size() > 1 && random.nextBoolean();
			if (isCollisionDesired) {
				int randomIndex = random.nextInt(enrolled.size());
				Student collision = enrolled.get(randomIndex);
				assertFalse(course.addStudent(collision));
				assertEquals(capacity, course.getCapacity());
				assertEquals(capacity - enrolled.size(), course.getSeatsRemaining());
			} else {
				int randomIndex = random.nextInt(remainingCandidates.size());
				Student student = remainingCandidates.remove(randomIndex);
				assertTrue(course.addStudent(student));
				enrolled.add(student);
				assertEquals(capacity, course.getCapacity());
				assertEquals(capacity - enrolled.size(), course.getSeatsRemaining());
			}
		}

		for (Student student : remainingCandidates) {
			assertFalse(course.addStudent(student));
			assertEquals(capacity, course.getCapacity());
			assertEquals(0, course.getSeatsRemaining());
		}
	}

}
