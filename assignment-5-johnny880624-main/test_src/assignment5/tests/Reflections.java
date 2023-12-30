package assignment5.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import assignment5.ZombieSimulator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Reflections {
	public static int invokeNonzombieCount(boolean[] areZombies) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = ZombieSimulator.class.getMethod("nonzombieCount", boolean[].class);
		Object returnValue = method.invoke(null, areZombies);
		return (Integer) returnValue;
	}
}
