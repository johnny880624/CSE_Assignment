package assignment8.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
public class EntityEdgeToEdgeAndIsTouchingTest {
	private final double x;
	private final double y;
	private final double xOnUnit;
	private final double yOnUnit;
	private final double otherRadiusScalar;
	private final double positionScalar;

	public EntityEdgeToEdgeAndIsTouchingTest(double x, double y, double xOnUnit, double yOnUnit, double otherRadiusScalar,
			double positionScalar) {
		super();
		this.x = x;
		this.y = y;
		this.xOnUnit = xOnUnit;
		this.yOnUnit = yOnUnit;
		this.otherRadiusScalar = otherRadiusScalar;
		this.positionScalar = positionScalar;
	}

	private Entity createEntity(boolean isZombie) {
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
		return entity;
	}

	private void test(Entity entity) {
		double radiusOther = entity.getRadius() * otherRadiusScalar;
		double justTouching = entity.getRadius() + radiusOther;
		double expectedCenterToCenter = entity.getRadius() + radiusOther * positionScalar;
		double expectedEdgeToEdge = expectedCenterToCenter - justTouching;

		double xOther = entity.getX() + xOnUnit * expectedCenterToCenter;
		double yOther = entity.getY() + yOnUnit * expectedCenterToCenter;
		double actualCenterToCenter = entity.distanceCenterToPoint(xOther, yOther);
		assertEquals(expectedCenterToCenter, actualCenterToCenter,
				UnitTestUtils.reasonableRelativeDelta(radiusOther));
		double actualEdgeToEdge = entity.distanceEdgeToEdge(xOther, yOther, radiusOther);
		assertEquals(expectedEdgeToEdge, actualEdgeToEdge, UnitTestUtils.reasonableRelativeDelta(radiusOther));
		if (positionScalar != 1.0) {
			boolean expectedIsTouching = positionScalar < 1.0;
			boolean actualIsTouching = entity.isTouching(xOther, yOther, radiusOther);
			assertEquals(expectedIsTouching, actualIsTouching);
		}
	}

	@Test
	public void testNonzombie() {
		test(createEntity(false));
	}

	@Test
	public void testZombie() {
		test(createEntity(true));
	}

	@Parameterized.Parameters(name = "new Entity(_, {0}, {1}).isTouching(_, _, _); onUnit: ({2}, {3}); otherRadiusScalar: {4}; positionScalar: {5}")
	public static Collection<Object[]> getConstructorArguments() {

		Random random = new Random(131_231_425L);

		List<double[]> xys = new LinkedList<>();
		xys.add(new double[] { 0.0, 0.0 });
		xys.add(new double[] { 0.3, 0.4 });

		for (int i = 0; i < 4; ++i) {
			xys.add(new double[] { random.nextDouble(), random.nextDouble() });
		}

		List<double[]> xyScalars = new LinkedList<>();
		xyScalars.add(new double[] { 1.0, 0.0 });
		xyScalars.add(new double[] { -1.0, 0.0 });
		xyScalars.add(new double[] { 0.0, 1.0 });
		xyScalars.add(new double[] { 0.0, -1.0 });

		double thetaDelta = Math.PI / 2;
		double theta0 = 0;
		for (int i = 0; i < 4; ++i) {
			double theta = theta0 + (random.nextDouble() * thetaDelta);
			double x = Math.cos(theta);
			double y = Math.sin(theta);
			xyScalars.add(new double[] { x, y });
			theta0 += thetaDelta;
		}

		List<Double> otherRadiusScalar = new LinkedList<>();
		otherRadiusScalar.add(1.0);
		otherRadiusScalar.add(1.618);
		otherRadiusScalar.add(0.23);

		List<Double> positionScalars = new LinkedList<>();
		positionScalars.add(1.0);
		positionScalars.add(0.99);
		positionScalars.add(1.01);

		List<Object[]> args = new LinkedList<>();

		for (double[] xy : xys) {
			for (double[] xyScalar : xyScalars) {
				for (double radiusScalar : otherRadiusScalar) {
					for (double positionScalar : positionScalars) {
						args.add(new Object[] { xy[0], xy[1], xyScalar[0], xyScalar[1], radiusScalar, positionScalar });
					}
				}
			}
		}

		return args;
	}
}
