package assignment7.tests.course;

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
import assignment7.Course;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#toString()}
 */
@RunWith(Parameterized.class)
public class CourseToStringTest {
	private final String name;
	private final int credits;

	public CourseToStringTest(String name, int credits) {
		this.name = name;
		this.credits = credits;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		int capacity = 20;
		Course course = new Course(name, credits, capacity);
		String stringRepresentation = course.toString();

		assertThat(stringRepresentation, containsString(name));
		assertThat(stringRepresentation, containsString(Integer.toString(credits)));
	}

	@Parameters(name = "name: {0}; credits: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "Data Structures and Algorithms", 3 });
		result.add(new Object[] { "Chemistry", 3 });
		result.add(new Object[] { "Chem Lab", 1 });
		result.add(new Object[] { "Doctoral Research", 9 });

		Random random = new Random();
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			String name = StringTestUtils.nextRandomString(random, 5);
			int credits = 3 + random.nextInt(2);
			result.add(new Object[] { name, credits });
		}

		return result;
	}

}
