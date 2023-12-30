package assignment8.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assignment8.Entity;
import assignment8.Nonzombie;
import assignment8.Zombie;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class EntityMoveAwayFromTest {
	private final double xExpected;
	private final double yExpected;
	private final double x;
	private final double y;
	private final double xMoveAwayFrom;
	private final double yMoveAwayFrom;

	public EntityMoveAwayFromTest(double xExpected, double yExpected, double x, double y,
			double xMoveAwayFrom, double yMoveAwayFrom) {
		super();
		this.xExpected = xExpected;
		this.yExpected = yExpected;
		this.x = x;
		this.y = y;
		this.xMoveAwayFrom = xMoveAwayFrom;
		this.yMoveAwayFrom = yMoveAwayFrom;
	}

	private void test(boolean isZombie) {
		Entity entity;
		if(isZombie) {
			entity = new Zombie(x, y);
		}
		else {
			entity = new Nonzombie(x, y);
		}
		assertEquals(isZombie, entity.isZombie());
		assertEquals(x, entity.getX(), UnitTestUtils.zeroDelta());
		assertEquals(y, entity.getY(), UnitTestUtils.zeroDelta());
		entity.moveAwayFrom(xMoveAwayFrom, yMoveAwayFrom);
		assertEquals(xExpected, entity.getX(), UnitTestUtils.reasonableDelta());
		assertEquals(yExpected, entity.getY(), UnitTestUtils.reasonableDelta());
	}

	@Test
	public void testNonzombie() {
		test(false);
	}

	@Parameterized.Parameters(name = "new Entity(_, {2}, {3}).moveAwayFrom({4}, {5}, {6}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {-Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0, 0.0});
		args.add(new Object[] {-Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0, 0.0});
		args.add(new Object[] {-Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0, 0.0});
		args.add(new Object[] {-Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0, 0.0});
		args.add(new Object[] {0.0, -Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0});
		args.add(new Object[] {0.0, -Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0});
		args.add(new Object[] {0.0, -Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0});
		args.add(new Object[] {0.0, -Nonzombie.NONZOMBIE_SPEED, 0.0, 0.0, 0.0, 1.0});
		
		return args;
	}
}
