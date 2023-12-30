package assignment7.tests.course;

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
import assignment7.Course;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#Course(String, int, int)}
 *         {@link Course#getName()}
 *         {@link Course#getCredits()}
 *         {@link Course#getCapacity()}
 */
@RunWith(Parameterized.class)
public class CourseConstructorNameCreditsCapacityTest {
	private final String name;
	private final int credits;
	private final int capacity;

	public CourseConstructorNameCreditsCapacityTest(String name, int credits, int capacity) {
		this.name = name;
		this.credits = credits;
		this.capacity = capacity;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course(name, credits, capacity);
		assertEquals(name, course.getName());
		assertEquals(credits, course.getCredits());
		assertEquals(capacity, course.getCapacity());
	}

	@Parameters(name = "name: {0}; credits: {1}; capacity: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "CSE 131", 3, 700 });
		result.add(new Object[] { "CSE 132", 3, 400 });
		result.add(new Object[] { "CSE 222", 3, 50 });
		result.add(new Object[] { "CSE 231", 3, 66 });
		result.add(new Object[] { "CSE 247", 3, 500 });
		result.add(new Object[] { "CSE 425", 3, 42 });

		Random random = new Random();
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			String name = StringTestUtils.nextRandomString(random, 3) + " " + (100 + random.nextInt(400));
			int credits = 3 + random.nextInt(2);
			int capacity = 10 + random.nextInt(30);
			result.add(new Object[] { name, credits, capacity });
		}

		return result;
	}

}
