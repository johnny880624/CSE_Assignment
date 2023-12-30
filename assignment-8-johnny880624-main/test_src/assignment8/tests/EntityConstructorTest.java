package assignment8.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import assignment8.Entity;
import assignment8.Nonzombie;
import assignment8.Zombie;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class EntityConstructorTest {
	@Test
	public void testZombie() {
		double x = 0.3;
		double y = 0.4;
		Zombie zombie = new Zombie(x, y);
		assertTrue(zombie.isZombie());
		assertEquals(x, zombie.getX(), UnitTestUtils.zeroDelta());
		assertEquals(y, zombie.getY(), UnitTestUtils.zeroDelta());
	}

	@Test
	public void testNonzombie() {
		double x = 0.5;
		double y = 0.7;
		Nonzombie nonzombie = new Nonzombie(x, y);
		assertFalse(nonzombie.isZombie());
		assertEquals(x, nonzombie.getX(), UnitTestUtils.zeroDelta());
		assertEquals(y, nonzombie.getY(), UnitTestUtils.zeroDelta());
	}
}
