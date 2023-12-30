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

import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#Student(String, String, int)}
 *         {@link Student#getId()}
 */
@RunWith(Parameterized.class)
public class StudentIdTest {
	private final int id;

	public StudentIdTest(int id) {
		this.id = id;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student("Yevg�ny", "Baz�rov", id);
		assertEquals(id, student.getId());
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		for (int id = 1; id < 4; ++id) {
			result.add(new Object[] { id });
		}

		Random random = new Random();
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; ++i) {
			int id = random.nextInt(1_000);
			result.add(new Object[] { id });
		}

		return result;
	}
}
