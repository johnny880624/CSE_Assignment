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
public class EntityMoveTowardTest {
	private final double xExpected;
	private final double yExpected;
	private final double x;
	private final double y;
	private final double xMoveToward;
	private final double yMoveToward;
	private final double amountMoveToward;

	public EntityMoveTowardTest(double xExpected, double yExpected, double x, double y,
			double xMoveToward, double yMoveToward, double amountMoveToward) {
		super();
		this.xExpected = xExpected;
		this.yExpected = yExpected;
		this.x = x;
		this.y = y;
		this.xMoveToward = xMoveToward;
		this.yMoveToward = yMoveToward;
		this.amountMoveToward = amountMoveToward;
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
		entity.moveToward(xMoveToward, yMoveToward, amountMoveToward);
		assertEquals(xExpected, entity.getX(), UnitTestUtils.reasonableDelta());
		assertEquals(yExpected, entity.getY(), UnitTestUtils.reasonableDelta());
	}

	@Test
	public void testNonzombie() {
		test(false);
	}

	@Test
	public void testZombie() {
		test(true);
	}

	@Parameterized.Parameters(name = "new Entity(_, {2}, {3}).moveToward({4}, {5}, {6}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0});
		args.add(new Object[] {0.25, 0.0, 0.0, 0.0, 1.0, 0.0, 0.25});
		args.add(new Object[] {0.618, 0.0, 0.0, 0.0, 1.0, 0.0, 0.618});
		args.add(new Object[] {-0.75, 0.0, 0.0, 0.0, 1.0, 0.0, -0.75});
		args.add(new Object[] {0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.0, 0.25, 0.0, 0.0, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.0, 0.618, 0.0, 0.0, 0.0, 1.0, 0.618});
		args.add(new Object[] {0.0, -0.75, 0.0, 0.0, 0.0, 1.0, -0.75});
		args.add(new Object[] {0.7071067811865475, 0.7071067811865475, 0.0, 0.0, 1.0, 1.0, 1.0});
		args.add(new Object[] {0.17677669529663687, 0.17677669529663687, 0.0, 0.0, 1.0, 1.0, 0.25});
		args.add(new Object[] {0.4369919907732863, 0.4369919907732863, 0.0, 0.0, 1.0, 1.0, 0.618});
		args.add(new Object[] {-0.5303300858899106, -0.5303300858899106, 0.0, 0.0, 1.0, 1.0, -0.75});
		args.add(new Object[] {0.6, 0.8, 0.0, 0.0, 0.3, 0.4, 1.0});
		args.add(new Object[] {0.15, 0.2, 0.0, 0.0, 0.3, 0.4, 0.25});
		args.add(new Object[] {0.37079999999999996, 0.4944, 0.0, 0.0, 0.3, 0.4, 0.618});
		args.add(new Object[] {-0.44999999999999996, -0.6000000000000001, 0.0, 0.0, 0.3, 0.4, -0.75});
		args.add(new Object[] {1.093883734673619, -0.010431526074846542, 0.1, 0.1, 1.0, 0.0, 1.0});
		args.add(new Object[] {0.34847093366840476, 0.07239211848128838, 0.1, 0.1, 1.0, 0.0, 0.25});
		args.add(new Object[] {0.7142201480282964, 0.03175331688574484, 0.1, 0.1, 1.0, 0.0, 0.618});
		args.add(new Object[] {-0.6454128010052141, 0.18282364455613492, 0.1, 0.1, 1.0, 0.0, -0.75});
		args.add(new Object[] {-0.010431526074846542, 1.093883734673619, 0.1, 0.1, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.07239211848128838, 0.34847093366840476, 0.1, 0.1, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.03175331688574484, 0.7142201480282964, 0.1, 0.1, 0.0, 1.0, 0.618});
		args.add(new Object[] {0.18282364455613492, -0.6454128010052141, 0.1, 0.1, 0.0, 1.0, -0.75});
		args.add(new Object[] {0.8071067811865476, 0.8071067811865476, 0.1, 0.1, 1.0, 1.0, 1.0});
		args.add(new Object[] {0.2767766952966369, 0.2767766952966369, 0.1, 0.1, 1.0, 1.0, 0.25});
		args.add(new Object[] {0.5369919907732864, 0.5369919907732864, 0.1, 0.1, 1.0, 1.0, 0.618});
		args.add(new Object[] {-0.43033008588991073, -0.43033008588991073, 0.1, 0.1, 1.0, 1.0, -0.75});
		args.add(new Object[] {0.654700196225229, 0.9320502943378438, 0.1, 0.1, 0.3, 0.4, 1.0});
		args.add(new Object[] {0.23867504905630726, 0.308012573584461, 0.1, 0.1, 0.3, 0.4, 0.25});
		args.add(new Object[] {0.4428047212671915, 0.6142070819007873, 0.1, 0.1, 0.3, 0.4, 0.618});
		args.add(new Object[] {-0.3160251471689217, -0.5240377207533828, 0.1, 0.1, 0.3, 0.4, -0.75});
		args.add(new Object[] {1.1363291775690445, -0.05112344158839166, 0.2, 0.3, 1.0, 0.0, 1.0});
		args.add(new Object[] {0.4340822943922611, 0.21221913960290206, 0.2, 0.3, 1.0, 0.0, 0.25});
		args.add(new Object[] {0.7786514317376694, 0.08300571309837396, 0.2, 0.3, 1.0, 0.0, 0.618});
		args.add(new Object[] {-0.5022468831767835, 0.5633425811912938, 0.2, 0.3, 1.0, 0.0, -0.75});
		args.add(new Object[] {-0.07472112789737811, 1.2615239476408233, 0.2, 0.3, 0.0, 1.0, 1.0});
		args.add(new Object[] {0.13131971802565548, 0.5403809869102059, 0.2, 0.3, 0.0, 1.0, 0.25});
		args.add(new Object[] {0.030222342959420334, 0.8942217996420287, 0.2, 0.3, 0.0, 1.0, 0.618});
		args.add(new Object[] {0.4060408459230336, -0.42114296073061747, 0.2, 0.3, 0.0, 1.0, -0.75});
		args.add(new Object[] {0.9525766947068779, 0.958504607868518, 0.2, 0.3, 1.0, 1.0, 1.0});
		args.add(new Object[] {0.3881441736767195, 0.46462615196712953, 0.2, 0.3, 1.0, 1.0, 0.25});
		args.add(new Object[] {0.6650923973288505, 0.7069558476627441, 0.2, 0.3, 1.0, 1.0, 0.618});
		args.add(new Object[] {-0.3644325210301584, -0.19387845590138852, 0.2, 0.3, 1.0, 1.0, -0.75});
		args.add(new Object[] {0.9071067811865472, 1.0071067811865475, 0.2, 0.3, 0.3, 0.4, 1.0});
		args.add(new Object[] {0.3767766952966368, 0.4767766952966369, 0.2, 0.3, 0.3, 0.4, 0.25});
		args.add(new Object[] {0.6369919907732862, 0.7369919907732864, 0.2, 0.3, 0.3, 0.4, 0.618});
		args.add(new Object[] {-0.3303300858899105, -0.23033008588991072, 0.2, 0.3, 0.3, 0.4, -0.75});

		// random cases
		args.add(new Object[] {0.10124380377974002, 0.9534964202833265, 0.010663556803351626, 0.9890560319144006, 0.2740008849616885, 0.8856761733927504, 0.09731015939590448});
		args.add(new Object[] {0.5147507526568846, -0.19607087980058424, 0.4591434589214084, 0.7733690504678351, 0.49999458116581685, 0.06118353594889414, 0.9710334440766812});
		args.add(new Object[] {0.4000986486774952, 0.24293928583268606, 0.23848655638668825, 0.2264844349086591, 0.7525774603453705, 0.27882760469335954, 0.16244762384702416});
		args.add(new Object[] {0.29783119870081887, 0.09726632077057461, 0.31111493166595094, 0.006439533520413376, 0.20573623311991374, 0.7269605390738132, 0.09179304354729168});
		args.add(new Object[] {0.7420484261472853, 0.8233220877111642, 0.9043958535185433, 0.3776439975208743, 0.6918504935720189, 0.9611260497689356, 0.4743265196567973});
		args.add(new Object[] {0.12973630812938036, 0.5880568298882365, 0.02887699683011158, 0.7021698656680424, 0.2526584189122152, 0.4489817653731709, 0.15229703086615332});
		args.add(new Object[] {0.8833262414081648, 0.5037885015313042, 0.22669136078019303, 0.762649454855455, 0.7412628532923802, 0.5597932389661194, 0.7058175115518168});
		args.add(new Object[] {0.9584884968140097, 0.26121521997748226, 0.366529101855237, 0.2361730426873473, 0.8694372669611352, 0.25744800772462906, 0.5924888487755586});

		return args;
	}
}
