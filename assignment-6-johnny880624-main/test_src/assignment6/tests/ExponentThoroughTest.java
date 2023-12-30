package assignment6.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment6.RecursiveMethods;

public class ExponentThoroughTest {

	/**
	 * Tests exponents with a positive value for the base and exponent
	 */
	@Test
	public void testPositiveExponentPositiveBase() {
		for (int i = 1; i <= 50; i++) {
			for (int j = 1; j <= 10; j++) {
				double expected = Math.pow(i, j);
				assertEquals("Error when computing " + i + "^" + j, expected, RecursiveMethods.exponent(i, j),
						.0001 * expected);
			}
		}
	}

	/**
	 * Tests exponents with a negative value for the base and a positive value for
	 * the exponent
	 */
	@Test
	public void testPositiveExponentNegativeBase() {
		for (int i = -1; i >= -50; i--) {
			for (int j = 1; j <= 10; j++) {
				double expected = Math.pow(i, j);
				assertEquals("Error when computing " + i + "^" + j, expected, RecursiveMethods.exponent(i, j),
						.0001 * expected);
			}
		}
	}

	/**
	 * Tests exponents with a negative value for the base and exponent
	 */
	@Test
	public void testNegativeExponentNegativeBase() {
		for (int i = -1; i >= -50; i--) {
			for (int j = -1; j >= -10; j--) {
				double expected = Math.pow(i, j);
				assertEquals("Error when computing " + i + "^" + j, expected, RecursiveMethods.exponent(i, j), .001);
			}
		}
	}

	/**
	 * Tests exponents with a positive value for the base and a negative value for
	 * the exponent
	 */
	@Test
	public void testNegativeExponentPositiveBase() {
		for (int i = 1; i <= 50; i++) { // Base
			for (int j = -1; j >= -10; j--) { // Exp
				double expected = Math.pow(i, j);
				assertEquals("Error when computing " + i + "^" + j, expected, RecursiveMethods.exponent(i, j), .001);
			}
		}
	}

	/**
	 * Tests exponents with a base of zero
	 */
	@Test
	public void testZeroBase() {
		for (int i = 1; i <= 50; i++) {
			assertEquals("Error when computing " + 0 + "^" + i, Math.pow(0, i), RecursiveMethods.exponent(0, i), .01);
		}
	}

	/**
	 * Tests exponents with an exponent of zero
	 */
	@Test
	public void testZeroExponent() {
		for (int i = 1; i <= 50; i++) {
			assertEquals("Error when computing " + i + "^" + 0, Math.pow(i, 0), RecursiveMethods.exponent(i, 0), .01);
		}
	}
}
