package assignment8.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import assignment8.Entity;
import assignment8.ZombieSimulator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ZombieSimulatorConstructorAndGetEntitiesTest {
	@Test
	public void test() {
		ZombieSimulator zombieSimulator = new ZombieSimulator(0);
		Entity[] entities = zombieSimulator.getEntities();
		assertNotNull(entities);
		assertEquals(0, entities.length);
	}
}
