package assignment7.tests.student;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import assignment7.tests.util.GradeCreditPair;
import test.cse131.UnitTestUtils;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Student#submitGrade(double, int)}
 *         {@link Student#calculateGradePointAverage()}
 */
@RunWith(Parameterized.class)
public class StudentGradePointAverageTest {
	private final List<GradeCreditPair> gradeCreditPairs;
	private final double expected;

	public StudentGradePointAverageTest(List<GradeCreditPair> gradeCreditPairs) {
		this.gradeCreditPairs = gradeCreditPairs;
		class MutableContainer {
			private double totalPoints;
			private int totalCount;

			public void accumulate(GradeCreditPair other) {
				this.totalPoints += (other.getGrade() * other.getCredits());
				this.totalCount += other.getCredits();
			}

			public MutableContainer combine(MutableContainer other) {
				this.totalPoints += other.totalPoints;
				this.totalCount += other.totalCount;
				return this;
			}
		}
		Collector<GradeCreditPair, MutableContainer, Double> collector = Collector.of(MutableContainer::new,
				MutableContainer::accumulate, MutableContainer::combine,
				(MutableContainer acc) -> acc.totalPoints / acc.totalCount);
		this.expected = gradeCreditPairs.stream().collect(collector).doubleValue();
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Student student = new Student("A", "B", 1);
		for (GradeCreditPair pair : gradeCreditPairs) {
			student.submitGrade(pair.getGrade(), pair.getCredits());
		}
		double actual = student.calculateGradePointAverage();
		assertEquals(expected, actual, UnitTestUtils.reasonableDelta());
	}

	@Parameters(name = "gradeCreditPairs:{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		for (double grade : new double[] { 1.0, 2.0 }) {
			for (int credits : new int[] { 1, 2 }) {
				result.add(new Object[] { Arrays.asList(new GradeCreditPair(grade, credits)) });
			}
		}

		GradeCreditPair gp11 = new GradeCreditPair(1.0, 1);
		GradeCreditPair gp12 = new GradeCreditPair(1.0, 2);
		GradeCreditPair gp21 = new GradeCreditPair(2.0, 1);
		GradeCreditPair gp22 = new GradeCreditPair(2.0, 2);

		result.add(new Object[] { Arrays.asList(gp11, gp11) });
		result.add(new Object[] { Arrays.asList(gp11, gp12) });
		result.add(new Object[] { Arrays.asList(gp12, gp11) });
		result.add(new Object[] { Arrays.asList(gp12, gp12) });

		result.add(new Object[] { Arrays.asList(gp22, gp22) });

		result.add(new Object[] { Arrays.asList(gp12, gp22) });
		result.add(new Object[] { Arrays.asList(gp11, gp21) });
		result.add(new Object[] { Arrays.asList(gp21, gp11) });

		result.add(new Object[] { Arrays.asList(gp12, gp21) });
		result.add(new Object[] { Arrays.asList(gp11, gp22) });

		Random random = new Random();
		for (int i = 0; i < 10; ++i) {
			final int CAPACITY = 5;
			List<GradeCreditPair> pairs = new ArrayList<>(CAPACITY);
			for (int j = 0; j < CAPACITY; ++j) {
				pairs.add(GradeCreditPair.generateRandom(random));
			}
			result.add(new Object[] { pairs });
		}

		return result;
	}
}
