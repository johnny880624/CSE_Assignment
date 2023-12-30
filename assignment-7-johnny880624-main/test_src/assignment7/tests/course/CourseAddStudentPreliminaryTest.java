package assignment7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import assignment7.Course;
import assignment7.Student;
import test.cse131.UnitTestUtils;
/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#addStudent(Student)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseAddStudentPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test0() {
		Course course = new Course("CSE 131", 3, 0);
		assertEquals(0, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());

		Student student = new Student("Ron", "Cytron", 1);
		boolean status = course.addStudent(student);
		assertFalse(status);
		assertEquals(0, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());
	}

	@Test
	public void test1() {
		Course course = new Course("CSE 131", 3, 1);
		assertEquals(1, course.getCapacity());
		assertEquals(1, course.getSeatsRemaining());

		Student studentA = new Student("AF", "AL", 1);
		boolean statusA = course.addStudent(studentA);
		assertTrue(statusA);
		assertEquals(1, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());

		Student studentB = new Student("BF", "BL", 2);
		boolean statusB = course.addStudent(studentB);
		assertFalse(statusB);
		assertEquals(1, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());
	}

	@Test
	public void test2() {
		Course course = new Course("CSE 131", 3, 2);
		assertEquals(2, course.getCapacity());
		assertEquals(2, course.getSeatsRemaining());

		Student studentA = new Student("AF", "AL", 1);
		boolean statusA = course.addStudent(studentA);
		assertTrue(statusA);
		assertEquals(2, course.getCapacity());
		assertEquals(1, course.getSeatsRemaining());

		Student studentB = new Student("BF", "BL", 2);
		boolean statusB = course.addStudent(studentB);
		assertTrue(statusB);
		assertEquals(2, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());

		Student studentC = new Student("CF", "CL", 2);
		boolean statusC = course.addStudent(studentC);
		assertFalse(statusC);
		assertEquals(2, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());
	}

	@Test
	public void test2WithCollision() {
		Course course = new Course("CSE 131", 3, 2);
		assertEquals(2, course.getCapacity());
		assertEquals(2, course.getSeatsRemaining());

		Student studentA = new Student("AF", "AL", 1);
		boolean statusA = course.addStudent(studentA);
		assertTrue(statusA);
		assertEquals(2, course.getCapacity());
		assertEquals(1, course.getSeatsRemaining());

		boolean statusACollision = course.addStudent(studentA);
		assertFalse(statusACollision);
		assertEquals(2, course.getCapacity());
		assertEquals(1, course.getSeatsRemaining());

		Student studentB = new Student("BF", "BL", 2);
		boolean statusB = course.addStudent(studentB);
		assertTrue(statusB);
		assertEquals(2, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());

		boolean statusBCollision = course.addStudent(studentB);
		assertFalse(statusBCollision);
		assertEquals(2, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());

		Student studentC = new Student("CF", "CL", 2);
		boolean statusC = course.addStudent(studentC);
		assertFalse(statusC);
		assertEquals(2, course.getCapacity());
		assertEquals(0, course.getSeatsRemaining());
	}
}
