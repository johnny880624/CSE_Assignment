package assignment5.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import assignment5.ZombieSimulator;
import static assignment5.ZombieSimulator.ENTITY_RADIUS;

/**
 * Methods that test the touchingZombie() method
 */
public class TouchingZombieTest {

	/**
	 * Check a single nonzombie isn't touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombie() {
		boolean[] areZombies = { false };
		double[][] positions = { { 0.5, 0.5 } };
		assertFalse(ZombieSimulator.touchingZombie(0, areZombies, positions));
	}

	/**
	 * Check a single nonzombie that is touching a zombie
	 */
	@Test
	public void testTwoEntitiesSingleNonzombieTouching() {
		boolean[] areZombies = { true, false, false };
		double[][] positions = { { 0.5, 0.5 },
				{ 0.5, 0.50001 },
				{ 0.5, 0.8 } };
		assertTrue(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a single nonzombie that is barely non touching a zombie
	 */
	@Test
	public void testTwoEntitiesSingleNonzombieNotTouching() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.50001 },
				{ 0.5, 0.8 } };
		assertFalse(ZombieSimulator.touchingZombie(2, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is barely above and barely touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyTouchingYAbove() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.5 + 2 * ENTITY_RADIUS - .0005 },
				{ 0.5, 0.8 } };
		assertTrue(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is below and barely touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyTouchingYBelow() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.5 - 2 * ENTITY_RADIUS + .0005 },
				{ 0.5, 0.8 } };
		assertTrue(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is left of and barely touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyTouchingXRight() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5 + 2 * ENTITY_RADIUS - .0005, 0.5 },
				{ 0.5, 0.8 } };
		assertTrue(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is right of and barely touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyTouchingLeft() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5 - 2 * ENTITY_RADIUS + .0005, 0.5 },
				{ 0.5, 0.8 } };
		assertTrue(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that above and is barely not touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyNotTouchingYAbove() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.5 + 2 * ENTITY_RADIUS + .0005 },
				{ 0.5, 0.8 } };
		assertFalse(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is below and barely not touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyNotTouchingYBelow() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.5 - 2 * ENTITY_RADIUS - .0005 },
				{ 0.5, 0.8 } };
		assertFalse(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is left of and barely not touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyNotTouchingXRight() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5 + 2 * ENTITY_RADIUS + .0005, 0.5 },
				{ 0.5, 0.8 } };
		assertFalse(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}

	/**
	 * Check a nonzombie that is right of and barely not touching a zombie
	 */
	@Test
	public void testSingleEntitySingleNonzombieBarelyNotTouchingXLeft() {
		boolean[] areZombies = { true, false, false };
		double positions[][] = { { 0.5, 0.5 },
				{ 0.5, 0.5 - 2 * ENTITY_RADIUS - .0005 },
				{ 0.5, 0.8 } };
		assertFalse(ZombieSimulator.touchingZombie(1, areZombies, positions));
	}
}
