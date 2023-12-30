package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

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

import assignment7.tests.util.StringTestUtils;
import test.cse131.UnitTestUtils;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#Student(String, String, int)}
 *         {@link Student#getFullName()}
 */
@RunWith(Parameterized.class)
public class StudentFullNameTest {
	private final String firstName;
	private final String lastName;

	public StudentFullNameTest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student(firstName, lastName, 1);
		String expected = firstName + " " + lastName;
		assertEquals(expected, student.getFullName());
	}

	@Parameters(name = "{0}, {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "Anne", "Shirley" });
		result.add(new Object[] { "Charlie", "Bucket" });
		result.add(new Object[] { "Holden", "Caulfield" });
		result.add(new Object[] { "Hotay", "Donkey" });
		result.add(new Object[] { "Ron", "Cytron" });
		result.add(new Object[] { "Scout", "Finch" });

		Random random = new Random();
		final int STRING_LENGTH = 3;
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			String firstName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			String lastName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			result.add(new Object[] { firstName, lastName });
		}

		return result;
	}
}
