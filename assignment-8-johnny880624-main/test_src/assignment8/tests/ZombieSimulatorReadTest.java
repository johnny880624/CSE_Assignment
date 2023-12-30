package assignment8.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import assignment8.Entity;
import test.cse131.UnitTestUtils;

/**
 * @author Unknown
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ZombieSimulatorReadTest {
	/**
	 * Note: assumes 1_nonzombie.sim has not changed.
	 */
	@Test
	public void testRead1Nonzombie() {
		Entity[] entities = ZombieTestUtils.readEntities("1_nonzombie.sim");
		assertNotNull(entities);
		assertEquals(1, entities.length);
		Entity entity0 = entities[0];
		assertNotNull(entity0);
		assertFalse(entity0.isZombie());
		assertEquals(0.1, entity0.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.2, entity0.getY(), UnitTestUtils.zeroDelta());
	}

	/**
	 * Note: assumes 1_zombie.sim has not changed.
	 */
	@Test
	public void testRead1Zombie() {
		Entity[] entities = ZombieTestUtils.readEntities("1_zombie.sim");
		assertNotNull(entities);
		assertEquals(1, entities.length);
		Entity entity0 = entities[0];
		assertNotNull(entity0);
		assertTrue(entity0.isZombie());
		assertEquals(0.3, entity0.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.4, entity0.getY(), UnitTestUtils.zeroDelta());
	}

	/**
	 * Note: assumes 5_nonzombies.sim has not changed.
	 */
	@Test
	public void testRead5Nonzombies() {
		Entity[] entities = ZombieTestUtils.readEntities("5_nonzombies.sim");
		assertNotNull(entities);
		assertEquals(5, entities.length);

		Entity entity0 = entities[0];
		assertNotNull(entity0);
		assertFalse(entity0.isZombie());
		assertEquals(0.9, entity0.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.1, entity0.getY(), UnitTestUtils.zeroDelta());

		Entity entity1 = entities[1];
		assertNotNull(entity1);
		assertFalse(entity1.isZombie());
		assertEquals(0.8, entity1.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.2, entity1.getY(), UnitTestUtils.zeroDelta());

		Entity entity2 = entities[2];
		assertNotNull(entity2);
		assertFalse(entity2.isZombie());
		assertEquals(0.7, entity2.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.3, entity2.getY(), UnitTestUtils.zeroDelta());

		Entity entity3 = entities[3];
		assertNotNull(entity3);
		assertFalse(entity3.isZombie());
		assertEquals(0.6, entity3.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.4, entity3.getY(), UnitTestUtils.zeroDelta());

		Entity entity4 = entities[4];
		assertNotNull(entity4);
		assertFalse(entity4.isZombie());
		assertEquals(0.5, entity4.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.5, entity4.getY(), UnitTestUtils.zeroDelta());
	}

	/**
	 * Note: assumes 5_zombies.sim has not changed.
	 */
	@Test
	public void testRead5Zombies() {
		Entity[] entities = ZombieTestUtils.readEntities("5_zombies.sim");

		assertNotNull(entities);
		assertEquals(5, entities.length);

		Entity entity0 = entities[0];
		assertNotNull(entity0);
		assertTrue(entity0.isZombie());
		assertEquals(0.1, entity0.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.9, entity0.getY(), UnitTestUtils.zeroDelta());

		Entity entity1 = entities[1];
		assertNotNull(entity1);
		assertTrue(entity1.isZombie());
		assertEquals(0.2, entity1.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.8, entity1.getY(), UnitTestUtils.zeroDelta());

		Entity entity2 = entities[2];
		assertNotNull(entity2);
		assertTrue(entity2.isZombie());
		assertEquals(0.3, entity2.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.7, entity2.getY(), UnitTestUtils.zeroDelta());

		Entity entity3 = entities[3];
		assertNotNull(entity3);
		assertTrue(entity3.isZombie());
		assertEquals(0.4, entity3.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.6, entity3.getY(), UnitTestUtils.zeroDelta());

		Entity entity4 = entities[4];
		assertNotNull(entity4);
		assertTrue(entity4.isZombie());
		assertEquals(0.5, entity4.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.5, entity4.getY(), UnitTestUtils.zeroDelta());
	}

	/**
	 * Note: assumes cse131_vs_zombies.sim has not changed.
	 */
	@Test
	public void testReadCse131vsZombies() {
		Entity[] entities = ZombieTestUtils.readEntities("cse131_vs_zombies.sim");

		assertNotNull(entities);
		assertEquals(759, entities.length);

		Entity entity0 = entities[0];
		assertNotNull(entity0);
		assertTrue(entity0.isZombie());
		assertEquals(0.5747243414406034, entity0.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.35182316835133776, entity0.getY(), UnitTestUtils.zeroDelta());

		Entity entity1 = entities[1];
		assertNotNull(entity1);
		assertFalse(entity1.isZombie());
		assertEquals(0.4719683868189237, entity1.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.8105152839528421, entity1.getY(), UnitTestUtils.zeroDelta());

		Entity entity758 = entities[758];
		assertNotNull(entity758);
		assertTrue(entity758.isZombie());
		assertEquals(0.5001967679478432, entity758.getX(), UnitTestUtils.zeroDelta());
		assertEquals(0.25925918275708726, entity758.getY(), UnitTestUtils.zeroDelta());
	}
}
