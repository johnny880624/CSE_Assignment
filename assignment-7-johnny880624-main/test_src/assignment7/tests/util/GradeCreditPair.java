package assignment7.tests.util;

import java.util.Random;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class GradeCreditPair {
	private final double grade;
	private final int credits;

	public GradeCreditPair(double grade, int credits) {
		this.grade = grade;
		this.credits = credits;
	}

	public double getGrade() {
		return grade;
	}

	public int getCredits() {
		return credits;
	}

	@Override
	public String toString() {
		return "(" + grade + "," + credits + ")";
	}

	public static GradeCreditPair generateRandom(Random random) {
		// double grade = ((int) (4000 * random.nextDouble())) / 1000.0;
		double grade = values[random.nextInt(values.length)];
		int credits = random.nextInt(4) + 1;
		return new GradeCreditPair(grade, credits);
	}

	private static double[] values = { 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.0 };
}
