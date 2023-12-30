package assignment8.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment8.Entity;
import assignment8.ZombieSimulator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class ZombieSimulatorCountTest {
	private final String filename;
	private final int expectedZombieCount;
	private final int expectedNonzombieCount;

	public ZombieSimulatorCountTest(String filename, int expectedZombieCount, int expectedNonzombieCount) {
		this.filename = filename;
		this.expectedZombieCount = expectedZombieCount;
		this.expectedNonzombieCount = expectedNonzombieCount;
	}

	@Test
	public void test() {
		ZombieSimulator zombieSimulator = ZombieTestUtils.readZombieSimulator(filename);
		assertNotNull(zombieSimulator);
		Entity[] entities = zombieSimulator.getEntities();
		assertNotNull(entities);
		assertEquals(expectedZombieCount + expectedNonzombieCount, entities.length);

		assertEquals(expectedZombieCount, zombieSimulator.getZombieCount());
		assertEquals(expectedNonzombieCount, zombieSimulator.getNonzombieCount());
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		args.add(new Object[] {"1_nonzombie.sim", 0, 1});
		args.add(new Object[] {"1_on_1.sim", 1, 1});
		args.add(new Object[] {"1_zombie.sim", 1, 0});
		args.add(new Object[] {"5_nonzombies.sim", 0, 5});
		args.add(new Object[] {"5_zombies.sim", 5, 0});
		args.add(new Object[] {"all_alone.sim", 146, 1});
		args.add(new Object[] {"bubbles.sim", 1, 1521});
		args.add(new Object[] {"contagion.sim", 5, 2551});
		args.add(new Object[] {"cse131_vs_zombies.sim", 334, 425});
		args.add(new Object[] {"in_the_house.sim", 17, 928});
		args.add(new Object[] {"surrounded.sim", 859, 41});

		return args;
	}
}
