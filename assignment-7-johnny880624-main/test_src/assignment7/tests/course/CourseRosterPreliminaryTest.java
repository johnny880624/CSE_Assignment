package assignment7.tests.course;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

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

import assignment7.Course;
import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#generateRoster()}
 */
@RunWith(Parameterized.class)
public class CourseRosterPreliminaryTest {
	private final int capacity;
	private final List<String> fullNames;

	public CourseRosterPreliminaryTest(int capacity, List<String> fullNames) {
		this.capacity = capacity;
		this.fullNames = fullNames;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course("CSE 131", 3, capacity);

		List<String> alreadyEnrolledFullNames = new LinkedList<>();

		for (String fullName : fullNames) {
			String[] names = fullName.split(" ");
			Student student = new Student(names[0], names[1], alreadyEnrolledFullNames.size() + 1);
			course.addStudent(student);

			alreadyEnrolledFullNames.add(fullName);

			String roster = course.generateRoster();

			assertThat(roster, not(containsString("null")));
			for (String alreadyEnrolledFullName : alreadyEnrolledFullNames) {
				assertThat(roster, containsString(alreadyEnrolledFullName));
			}

		}
	}

	@Parameters(name = "capacity: {0}; fullNames: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 1, Arrays.asList("Ron Cytron") });
		result.add(new Object[] { 2, Arrays.asList("Ron Cytron") });

		result.add(
				new Object[] { 4, Arrays.asList("Anne Shirley", "Charlie Bucket", "Holden Caulfield", "Scout Finch") });
		result.add(
				new Object[] { 5, Arrays.asList("Anne Shirley", "Charlie Bucket", "Holden Caulfield", "Scout Finch") });
		return result;
	}
}
