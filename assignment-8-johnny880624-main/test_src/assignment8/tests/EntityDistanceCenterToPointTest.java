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
public class EntityDistanceCenterToPointTest {
	private final double expected;
	private final double x;
	private final double y;
	private final double xOther;
	private final double yOther;

	public EntityDistanceCenterToPointTest(double expected, double x, double y, double xOther, double yOther) {
		super();
		this.expected = expected;
		this.x = x;
		this.y = y;
		this.xOther = xOther;
		this.yOther = yOther;
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
		double actual = entity.distanceCenterToPoint(xOther, yOther);
		assertEquals(expected, actual, UnitTestUtils.reasonableRelativeDelta(expected));
	}

	@Test
	public void testNonzombie() {
		test(false);
	}

	@Test
	public void testZombie() {
		test(true);
	}

	@Parameterized.Parameters(name = "new Entity(_, {1}, {2}).distanceTo({3}, {4})")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {1.0, 0.0, 0.0, 1.0, 0.0});
		args.add(new Object[] {1.0, 0.0, 0.0, 0.0, 1.0});
		args.add(new Object[] {1.4142135623730951, 0.0, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.5, 0.0, 0.0, 0.3, 0.4});
		args.add(new Object[] {0.9055385138137417, 0.1, 0.1, 1.0, 0.0});
		args.add(new Object[] {0.9055385138137417, 0.1, 0.1, 0.0, 1.0});
		args.add(new Object[] {1.2727922061357855, 0.1, 0.1, 1.0, 1.0});
		args.add(new Object[] {0.36055512754639896, 0.1, 0.1, 0.3, 0.4});
		args.add(new Object[] {0.8544003745317532, 0.2, 0.3, 1.0, 0.0});
		args.add(new Object[] {0.7280109889280517, 0.2, 0.3, 0.0, 1.0});
		args.add(new Object[] {1.063014581273465, 0.2, 0.3, 1.0, 1.0});
		args.add(new Object[] {0.14142135623730953, 0.2, 0.3, 0.3, 0.4});

		// random cases
		args.add(new Object[] {0.2829027103962209, 0.010663556803351626, 0.9890560319144006, 0.2740008849616885, 0.8856761733927504});
		args.add(new Object[] {0.6772919890165807, 0.09731015939590448, 0.4591434589214084, 0.7733690504678351, 0.49999458116581685});
		args.add(new Object[] {0.7653689228793186, 0.06118353594889414, 0.9710334440766812, 0.23848655638668825, 0.2264844349086591});
		args.add(new Object[] {0.5910124325330222, 0.7525774603453705, 0.27882760469335954, 0.16244762384702416, 0.31111493166595094});
		args.add(new Object[] {0.7294748589866994, 0.006439533520413376, 0.20573623311991374, 0.7269605390738132, 0.09179304354729168});
		args.add(new Object[] {0.6209885951693532, 0.9043958535185433, 0.3776439975208743, 0.6918504935720189, 0.9611260497689356});
		args.add(new Object[] {0.31935985218979634, 0.4743265196567973, 0.02887699683011158, 0.7021698656680424, 0.2526584189122152});
		args.add(new Object[] {0.6495714783176106, 0.4489817653731709, 0.15229703086615332, 0.22669136078019303, 0.762649454855455});

		return args;
	}
}
