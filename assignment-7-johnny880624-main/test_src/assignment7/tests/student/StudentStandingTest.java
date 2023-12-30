package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Doug Shook
 * 
 *         {@link Student#getClassStanding()}
 */
public class StudentStandingTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testCs() {
		String message = "getClassStanding() isn't working properly";
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 29; i++) {
			s.submitGrade(2.0, 1);
			assertEquals(message, "First Year", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(2.0, 1);
			assertEquals(message, "Sophomore", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(2.0, 1);
			assertEquals(message, "Junior", s.getClassStanding());
		}

		for (int i = 0; i < 30; i++) {
			s.submitGrade(2.0, 1);
			assertEquals(message, "Senior", s.getClassStanding());
		}
	}

	@Test
	public void testDs() {
		String message = "getClassStanding() isn't working properly";
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 200; i++) {
			s.submitGrade(1.0, 1);
			assertEquals(message, "First Year", s.getClassStanding());
		}
	}
}
