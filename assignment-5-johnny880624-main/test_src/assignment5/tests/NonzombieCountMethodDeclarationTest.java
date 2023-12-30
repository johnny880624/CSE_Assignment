package assignment5.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import assignment5.ZombieSimulator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class NonzombieCountMethodDeclarationTest {
	private static final String NONZOMBIE_COUNT_METHOD_NAME = "nonzombieCount";

	@Test
	public void testNonzombieCountMethod() throws NoSuchMethodException, SecurityException {
		List<Method> ignoringCaseNonzombieCountMethods = getAllNonzombieCountMethods(true);

		String couldNotFindMethodMessage = "\nCould not find method named " + NONZOMBIE_COUNT_METHOD_NAME + " on class "
				+ ZombieSimulator.class.getName() + "\nSize: ";
		assertNotEquals(couldNotFindMethodMessage, 0, ignoringCaseNonzombieCountMethods.size());

		String tooManyMethodsFountMessage = "\nFound too many methods (case insensitively) named "
				+ NONZOMBIE_COUNT_METHOD_NAME + " on class "
				+ ZombieSimulator.class.getName() + "\n" + ignoringCaseNonzombieCountMethods + "\nSize: ";
		assertEquals(tooManyMethodsFountMessage, 1, ignoringCaseNonzombieCountMethods.size());

		Method method = ignoringCaseNonzombieCountMethods.get(0);
		assertEquals("\nMethod name is not an exact (case sensitive) match.\n", method.getName(),
				NONZOMBIE_COUNT_METHOD_NAME);

		Class<?>[] expectedParameterTypes = { getArrayType(Boolean.TYPE) };
		Class<?>[] actualParameterTypes = method.getParameterTypes();

		String noParametersMessage = "\n" + NONZOMBIE_COUNT_METHOD_NAME
				+ " method requires 1 parameter.  None found.\nexpected parameter types: "
				+ toSimpleNames(expectedParameterTypes) + "\nactual parameter types: "
				+ toSimpleNames(actualParameterTypes) + "\nSize: ";
		assertNotEquals(noParametersMessage, 0, actualParameterTypes.length);

		String tooManyParametersMessage = "\n" + NONZOMBIE_COUNT_METHOD_NAME
				+ " method requires only 1 parameter.\nexpected parameter types: "
				+ toSimpleNames(expectedParameterTypes) + "\nactual parameter types: "
				+ toSimpleNames(actualParameterTypes) + "\nSize: ";
		assertEquals(tooManyParametersMessage, 1, actualParameterTypes.length);

		String javaModifiersUrl = "https://www.w3schools.com/java/java_modifiers.asp";

		String incorrectParameterTypeMessage = "\n" + NONZOMBIE_COUNT_METHOD_NAME
				+ " method's parameter has the incorrect type.\nexpected parameter type: "
				+ expectedParameterTypes[0].getSimpleName() + "\nactual parameter type: "
				+ actualParameterTypes[0].getSimpleName() + "\n\nIgnore this not so helpful line: ";
		assertEquals(incorrectParameterTypeMessage, expectedParameterTypes[0], actualParameterTypes[0]);

		String notPublicMessage = "\n" + NONZOMBIE_COUNT_METHOD_NAME + " method must be declared as public\nSee:\n\n\t"
				+ javaModifiersUrl + "\n\nfor details.\n";
		assertTrue(notPublicMessage, Modifier.isPublic(method.getModifiers()));

		String notStaticMessage = "\n" + NONZOMBIE_COUNT_METHOD_NAME + " method must be declared as static\nSee:\n\n\t"
				+ javaModifiersUrl + "\n\nfor details.\n";
		assertTrue(notStaticMessage, Modifier.isStatic(method.getModifiers()));

		String notIntReturnTypeMessage = "\nExpected return type to be int or Integer.  Actual return type: "
				+ method.getReturnType().getSimpleName() + "\n";
		assertThat(notIntReturnTypeMessage, method.getReturnType(), anyOf(is(Integer.TYPE), is(Integer.class)));
	}

	private static Class<?> getArrayType(Class<?> cls) {
		// JDK 12 adds cls.arrayType()
		return Array.newInstance(cls, 0).getClass();
	}

	private static List<Method> getAllNonzombieCountMethods(boolean isIgnoringCaseDesired) {
		List<Method> nonzombieCountMethods = new LinkedList<>();
		for (Method method : ZombieSimulator.class.getDeclaredMethods()) {
			String methodName = method.getName();
			boolean isMatch = isIgnoringCaseDesired ? NONZOMBIE_COUNT_METHOD_NAME.equalsIgnoreCase(methodName)
					: NONZOMBIE_COUNT_METHOD_NAME.equals(methodName);
			if (isMatch) {
				nonzombieCountMethods.add(method);
			}
		}
		return nonzombieCountMethods;
	}

	private static String toSimpleNames(Class<?>[] classes) {
		String[] simpleNames = new String[classes.length];
		int index = 0;
		for (Class<?> cls : classes) {
			simpleNames[index] = cls.getSimpleName();
			++index;
		}
		return Arrays.toString(simpleNames);
	}
}
