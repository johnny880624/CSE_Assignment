package assignment5.tests;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Methods that test the nonzombieCount() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NonzombieCountTest {
	@Test
	public void testSingleNonzombie() throws Exception {
		boolean[] areZombies = { false };
		assertEquals(1, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testSingleZombie() throws Exception {
		boolean[] areZombies = { true };
		assertEquals(0, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testTwoNonzombies() throws Exception {
		boolean[] areZombies = { false, false };
		assertEquals(2, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testTwoZombies() throws Exception {
		boolean[] areZombies = { true, true };
		assertEquals(0, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testTwoEntitiesFirstZombie() throws Exception {
		boolean[] areZombies = { true, false };
		assertEquals(1, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testTwoEntitiesSecondZombie() throws Exception {
		boolean[] areZombies = { false, true };
		assertEquals(1, Reflections.invokeNonzombieCount(areZombies));
	}

	@Test
	public void testOneHundredEntitiesFiftyZombies() throws Exception {
		boolean[] areZombies = new boolean[100];
		for (int i = 0; i < areZombies.length; i++) {
			areZombies[i] = (i % 2 == 0);
		}
		assertEquals(50, Reflections.invokeNonzombieCount(areZombies));
	}
}
