package assignment5.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import assignment5.ZombieSimulator;

/**
 * Methods that test the readEntities() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReadEntitiesTest {
	private static class ZombieArrays {
		private final boolean[] areZombies;
		private final double[][] positions;

		private ZombieArrays(boolean[] areZombies, double[][] positions) {
			this.areZombies = areZombies;
			this.positions = positions;
		}

		public static ZombieArrays read(String filename) throws FileNotFoundException {
			File f = new File("zombieSims/" + filename);
			Scanner in = new Scanner(f);
			int N = in.nextInt();
			boolean[] areZombies = new boolean[N];
			double[][] positions = new double[N][2];
			ZombieSimulator.readEntities(in, areZombies, positions);
			return new ZombieArrays(areZombies, positions);
		}
	}

	private static final double DELTA = 1e-4;

	/**
	 * Test if all values from aNonZombie.sim are read correctly (assumes file is
	 * unchanged!)
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadANonZombie() throws FileNotFoundException {
		ZombieArrays zombieArrays = ZombieArrays.read("1_nonzombie.sim");
		assertEquals(1, zombieArrays.areZombies.length);
		assertEquals(1, zombieArrays.positions.length);
		assertFalse(zombieArrays.areZombies[0]);
		assertEquals(0.1, zombieArrays.positions[0][ZombieSimulator.X], DELTA);
		assertEquals(0.2, zombieArrays.positions[0][ZombieSimulator.Y], DELTA);
	}

	/**
	 * Test if all values from aZombie.sim are read correctly (assumes file is
	 * unchanged!)
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadAZombie() throws FileNotFoundException {
		ZombieArrays zombieArrays = ZombieArrays.read("1_zombie.sim");
		assertEquals(1, zombieArrays.areZombies.length);
		assertEquals(1, zombieArrays.positions.length);
		assertTrue(zombieArrays.areZombies[0]);
		assertEquals(0.3, zombieArrays.positions[0][ZombieSimulator.X], DELTA);
		assertEquals(0.4, zombieArrays.positions[0][ZombieSimulator.Y], DELTA);
	}

	/**
	 * Test if all values from nonzombies.sim are read correctly (assumes file is
	 * unchanged!)
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadNonzombies() throws FileNotFoundException {
		ZombieArrays zombieArrays = ZombieArrays.read("5_nonzombies.sim");

		assertEquals(5, zombieArrays.areZombies.length);
		assertEquals(5, zombieArrays.positions.length);

		assertFalse(zombieArrays.areZombies[0]);
		assertEquals(0.9, zombieArrays.positions[0][ZombieSimulator.X], DELTA);
		assertEquals(0.1, zombieArrays.positions[0][ZombieSimulator.Y], DELTA);
		assertFalse(zombieArrays.areZombies[1]);
		assertEquals(0.8, zombieArrays.positions[1][ZombieSimulator.X], DELTA);
		assertEquals(0.2, zombieArrays.positions[1][ZombieSimulator.Y], DELTA);
		assertFalse(zombieArrays.areZombies[2]);
		assertEquals(0.7, zombieArrays.positions[2][ZombieSimulator.X], DELTA);
		assertEquals(0.3, zombieArrays.positions[2][ZombieSimulator.Y], DELTA);
		assertFalse(zombieArrays.areZombies[3]);
		assertEquals(0.6, zombieArrays.positions[3][ZombieSimulator.X], DELTA);
		assertEquals(0.4, zombieArrays.positions[3][ZombieSimulator.Y], DELTA);
		assertFalse(zombieArrays.areZombies[4]);
		assertEquals(0.5, zombieArrays.positions[4][ZombieSimulator.X], DELTA);
		assertEquals(0.5, zombieArrays.positions[4][ZombieSimulator.Y], DELTA);
	}

	/**
	 * Test if all values from zombies.sim are read correctly (assumes file is
	 * unchanged!)
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadZombies() throws FileNotFoundException {
		ZombieArrays zombieArrays = ZombieArrays.read("5_zombies.sim");

		assertEquals(5, zombieArrays.areZombies.length);
		assertEquals(5, zombieArrays.positions.length);
		assertTrue(zombieArrays.areZombies[0]);
		assertEquals(0.1, zombieArrays.positions[0][ZombieSimulator.X], DELTA);
		assertEquals(0.9, zombieArrays.positions[0][ZombieSimulator.Y], DELTA);
		assertTrue(zombieArrays.areZombies[1]);
		assertEquals(0.2, zombieArrays.positions[1][ZombieSimulator.X], DELTA);
		assertEquals(0.8, zombieArrays.positions[1][ZombieSimulator.Y], DELTA);
		assertTrue(zombieArrays.areZombies[2]);
		assertEquals(0.3, zombieArrays.positions[2][ZombieSimulator.X], DELTA);
		assertEquals(0.7, zombieArrays.positions[2][ZombieSimulator.Y], DELTA);
		assertTrue(zombieArrays.areZombies[3]);
		assertEquals(0.4, zombieArrays.positions[3][ZombieSimulator.X], DELTA);
		assertEquals(0.6, zombieArrays.positions[3][ZombieSimulator.Y], DELTA);
		assertTrue(zombieArrays.areZombies[4]);
		assertEquals(0.5, zombieArrays.positions[4][ZombieSimulator.X], DELTA);
		assertEquals(0.5, zombieArrays.positions[4][ZombieSimulator.Y], DELTA);
	}

	/**
	 * Test if all select values from zombieWorls.sim are read correctly (assumes
	 * file is unchanged!)
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testReadNZombieWorld() throws FileNotFoundException {
		ZombieArrays zombieArrays = ZombieArrays.read("cse131_vs_zombies.sim");

		assertEquals(759, zombieArrays.areZombies.length);
		assertEquals(759, zombieArrays.positions.length);

		assertTrue(zombieArrays.areZombies[0]);
		assertEquals(0.5747243414406034, zombieArrays.positions[0][ZombieSimulator.X], DELTA);
		assertEquals(0.35182316835133776, zombieArrays.positions[0][ZombieSimulator.Y], DELTA);

		assertFalse(zombieArrays.areZombies[1]);
		assertEquals(0.4719683868189237, zombieArrays.positions[1][ZombieSimulator.X], DELTA);
		assertEquals(0.8105152839528421, zombieArrays.positions[1][ZombieSimulator.Y], DELTA);

		assertTrue(zombieArrays.areZombies[758]);
		assertEquals(0.5001967679478432, zombieArrays.positions[758][ZombieSimulator.X], DELTA);
		assertEquals(0.25925918275708726, zombieArrays.positions[758][ZombieSimulator.Y], DELTA);
	}
}
