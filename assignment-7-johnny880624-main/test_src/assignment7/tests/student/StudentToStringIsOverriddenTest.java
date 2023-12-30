package assignment7.tests.student;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import assignment7.Student;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#toString()}
 */
public class StudentToStringIsOverriddenTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		@SuppressWarnings("unused")
		Method toStringMethod = Student.class.getDeclaredMethod("toString");
		// note: we need not check the returned toStringMethod
		// getDeclaredMethod will throw a NoSuchMethodException if it is not found
	}
}
