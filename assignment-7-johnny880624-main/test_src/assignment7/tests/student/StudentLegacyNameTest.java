package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#createLegacy(String, Student, boolean, int)}
 */
public class StudentLegacyNameTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testName() {
		Student parentA = new Student("Aaa", "Bbb", 1);
		Student parentB = new Student("Ccc", "Ddd", 2);

		Student legacyHyphenated = parentA.createLegacy("Eee", parentB, true, 3);
		assertEquals("Eee Bbb-Ddd", legacyHyphenated.getFullName());

		Student legacyUnhyphenated = parentA.createLegacy("Eee", parentB, false, 3);
		assertEquals("Eee Bbb", legacyUnhyphenated.getFullName());
	}
}
