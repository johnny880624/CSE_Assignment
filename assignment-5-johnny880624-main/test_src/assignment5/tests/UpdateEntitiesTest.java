package assignment5.tests;

import static assignment5.ZombieSimulator.X;
import static assignment5.ZombieSimulator.Y;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import assignment5.ZombieSimulator;

/**
 * Methods that test the ZombieSimulator.updateEntities() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdateEntitiesTest {
	/**
	 * Utility to copy an array
	 * 
	 * @param source 2D array to copy
	 * @return Deep copy of the array
	 */
	private static double[][] copy2DArray(double[][] source) {
		double[][] copy = new double[source.length][];
		for (int i = 0; i < source.length; i++) {
			copy[i] = Arrays.copyOf(source[i], source[i].length);
		}
		return copy;
	}

	private static void assertDistanceNotTooFar(double curr, double prev) {
		double distanceMovedInDimension = Math.abs(curr - prev);
		assertThat(distanceMovedInDimension, lessThanOrEqualTo(ZombieSimulator.RANDOM_DELTA_HALF_RANGE));
	}

	/**
	 * Move a single nonzombie repeatedly. Verify that it never moves more than .005
	 * in any single direction and that it moves along all directions.
	 */
	@Test
	public void testSingleNonzombieMotion() {
		boolean[] areZombies = { false };
		double[][] positions = { { 0.5, 0.5 } };
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;

		for (int i = 0; i < 100; i++) {
			double[][] prevPositions = copy2DArray(positions);

			ZombieSimulator.updateEntities(areZombies, positions);

			// Check the the X coordinate changed
			assertTrue(positions[0][X] != prevPositions[0][X]);
			// Check the the Y coordinate changed
			assertTrue(positions[0][Y] != prevPositions[0][Y]);

			// Check the the X coordinate didn't change too much
			assertDistanceNotTooFar(positions[0][X], prevPositions[0][X]);

			// Check the the Y coordinate didn't change too much
			assertDistanceNotTooFar(positions[0][Y], prevPositions[0][Y]);

			// Check if it moved right
			if (positions[0][X] > prevPositions[0][X])
				right = true;
			// Check if it moved left
			if (positions[0][X] < prevPositions[0][X])
				left = true;
			// Check if it moved up
			if (positions[0][Y] > prevPositions[0][Y])
				up = true;
			// Check if it moved down
			if (positions[0][Y] < prevPositions[0][Y])
				down = true;
		}
		// Check that it moved left at least once
		assertTrue(left);
		// Check that it moved right at least once
		assertTrue(right);
		// Check that it moved up at least once
		assertTrue(up);
		// Check that it moved down at least once
		assertTrue(down);
	}

	/**
	 * Move a single zombie repeatedly. Verify that it never moves more than .005 in
	 * any single direction and that it moves along all directions.
	 */
	@Test
	public void testSingleZombieMotion() {
		boolean[] areZombies = { true };
		double[][] positions = { { 0.5, 0.5 } };
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;

		for (int i = 0; i < 100; i++) {
			double[][] prevPositions = copy2DArray(positions);

			ZombieSimulator.updateEntities(areZombies, positions);

			// Check the the X coordinate changed
			assertTrue(positions[0][X] != prevPositions[0][X]);
			// Check the the Y coordinate changed
			assertTrue(positions[0][Y] != prevPositions[0][Y]);

			// Check the the X coordinate didn't change too much
			assertDistanceNotTooFar(positions[0][X], prevPositions[0][X]);

			// Check the the Y coordinate didn't change too much
			assertDistanceNotTooFar(positions[0][Y], prevPositions[0][Y]);

			// Check if it moved right
			if (positions[0][X] > prevPositions[0][X])
				right = true;
			// Check if it moved left
			if (positions[0][X] < prevPositions[0][X])
				left = true;
			// Check if it moved up
			if (positions[0][Y] > prevPositions[0][Y])
				up = true;
			// Check if it moved down
			if (positions[0][Y] < prevPositions[0][Y])
				down = true;
		}
		// Check that it moved left at least once
		assertTrue(left);
		// Check that it moved right at least once
		assertTrue(right);
		// Check that it moved up at least once
		assertTrue(up);
		// Check that it moved down at least once
		assertTrue(down);
	}

	/**
	 * Move zombies that are near the screen boarders for several steps. Verify that
	 * none ever leave the screen.
	 */
	@Test
	public void testZombiesStayingInBoundariesMultiStep() {
		double[][] positions = {
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
		};
		boolean[] areZombies = new boolean[positions.length];
		Arrays.fill(areZombies, true);

		for (int i = 0; i < 200; i++) {
			ZombieSimulator.updateEntities(areZombies, positions);
			for (int j = 0; j < positions.length; j++) {
				// Check if x>=0
				assertTrue(positions[j][X] >= 0);
				// Check if x<=1
				assertTrue(positions[j][X] <= 1.0);
				// Check if y>=0
				assertTrue(positions[j][Y] >= 0);
				// Check if y<=1
				assertTrue(positions[j][Y] <= 1.0);
			}
		}
	}

	/**
	 * Move nonzombies that are near the screen boarders repeatedly. Verify that
	 * none ever leave the screen.
	 */
	@Test
	public void testNonzombiesStayingInBoundariesMultiStep() {
		double[][] positions = {
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
				{ 0.0001, .9999 },
				{ 0.0001, .0001 },
				{ 0.9999, .0001 },
				{ 0.9999, .9999 },
				{ 0.5, .9999 },
				{ 0.5, .0001 },
				{ 0.9999, 0.5 },
				{ 0.9999, 0.5 },
		};
		boolean[] areZombies = new boolean[positions.length];

		for (int i = 0; i < 200; i++) {
			ZombieSimulator.updateEntities(areZombies, positions);
			for (int j = 0; j < positions.length; j++) {
				// Check if x>=0
				assertTrue(positions[j][X] >= 0);
				// Check if x<=1
				assertTrue(positions[j][X] <= 1.0);
				// Check if y>=0
				assertTrue(positions[j][Y] >= 0);
				// Check if y<=1
				assertTrue(positions[j][Y] <= 1.0);
			}
		}
	}

	/**
	 * Put a zombie in the middle of non-zombies. Confirm that one of them changes
	 * to a zombie
	 */
	@Test
	public void testNonZombieToZombie1() {
		double[][] positions = {
				{ 0.5, 0.5 }, // Zombie

				{ 0.5, 0.5 },
				{ 0.5 + 0.002, 0.5 },
				{ 0.5 - 0.002, 0.5 },
				{ 0.5, 0.5 + .002 },
				{ 0.5, 0.5 - .002 },
		};
		boolean[] areZombies = new boolean[positions.length];
		areZombies[0] = true;

		ZombieSimulator.updateEntities(areZombies, positions);

		int zombies = 0;
		for (boolean isZombie : areZombies) {
			if (isZombie) {
				zombies++;
			}
		}
		// Verify that one of the non-zombies is now a zombie
		assertTrue(zombies > 1);
	}

	/**
	 * Put a zombie in the middle of non-zombies. Confirm that one of them changes
	 * to a zombie
	 */
	@Test
	public void testNonZombieToZombie2() {
		double[][] positions = {
				{ 0.5, 0.5 },
				{ 0.5 + 0.002, 0.5 },

				{ 0.5, 0.5 }, // Zombie

				{ 0.5 - 0.002, 0.5 },
				{ 0.5, 0.5 + .002 },
				{ 0.5, 0.5 - .002 },
		};
		boolean[] areZombies = new boolean[positions.length];
		areZombies[2] = true;

		ZombieSimulator.updateEntities(areZombies, positions);

		int zombies = 0;
		for (boolean isZombie : areZombies) {
			if (isZombie) {
				zombies++;
			}
		}
		// Verify that one of the non-zombies is now a zombie
		assertTrue(zombies > 1);
	}

	/**
	 * Verify that a world with only non-zombies will not spontaneously create a
	 * zombie.
	 */
	@Test
	public void testOnlyNonZombies() {
		double positions[][] = {
				{ 0.5, 0.5 },
				{ 0.5 + 0.002, 0.5 },
				{ 0.5, 0.5 },
				{ 0.5 - 0.002, 0.5 },
				{ 0.5, 0.5 + .002 },
				{ 0.5, 0.5 - .002 },
		};
		boolean[] areZombies = new boolean[positions.length];
		ZombieSimulator.updateEntities(areZombies, positions);

		int zombieCount = 0;
		for (boolean isZombie : areZombies) {
			if (isZombie) {
				zombieCount++;
			}
		}
		assertEquals(0, zombieCount);
	}

	/**
	 * Verify that a world with only zombies stays only zombies.
	 */
	@Test
	public void testOnlyZombies() {
		double positions[][] = {
				{ 0.5, 0.5 },
				{ 0.5 + 0.002, 0.5 },
				{ 0.5, 0.5 },
				{ 0.5 - 0.002, 0.5 },
				{ 0.5, 0.5 + .002 },
				{ 0.5, 0.5 - .002 },
		};
		boolean[] areZombies = new boolean[positions.length];
		Arrays.fill(areZombies, true);
		ZombieSimulator.updateEntities(areZombies, positions);

		int zombieCount = 0;
		for (boolean isZombie : areZombies) {
			if (isZombie) {
				zombieCount++;
			}
		}
		assertEquals(positions.length, zombieCount);
	}
}
