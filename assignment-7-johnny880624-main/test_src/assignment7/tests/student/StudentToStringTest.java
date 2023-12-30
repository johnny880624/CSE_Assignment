package assignment7.tests.student;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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
 *         {@link Student#toString()}
 */
@RunWith(Parameterized.class)
public class StudentToStringTest {
	private final String firstName;
	private final String lastName;
	private final int id;

	public StudentToStringTest(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student(firstName, lastName, id);

		String stringRepresentation = student.toString();

		assertThat(stringRepresentation, containsString(firstName + " " + lastName));
		assertThat(stringRepresentation, containsString(Integer.toString(id)));
	}

	@Parameters(name = "{0}; {1}; id: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "Anne", "Shirley", 1 });
		result.add(new Object[] { "Charlie", "Bucket", 2 });
		result.add(new Object[] { "Holden", "Caulfield", 3 });
		result.add(new Object[] { "Hotay", "Donkey", 4 });
		result.add(new Object[] { "Ron", "Cytron", 5 });
		result.add(new Object[] { "Scout", "Finch", 6 });

		Random random = new Random();
		final int STRING_LENGTH = 3;
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			String firstName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			String lastName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			int id = 400_000 + random.nextInt(100_000);
			result.add(new Object[] { firstName, lastName, id });
		}

		return result;
	}
}
