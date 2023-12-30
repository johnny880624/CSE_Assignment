package test.cse131;

import java.util.concurrent.TimeUnit;

import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class UnitTestUtils {
	public static TestRule createTimeoutRule(long scale) {
		return new DisableOnDebug(new Timeout(scale, TimeUnit.SECONDS));
	}

	public static TestRule createTimeoutRule() {
		return createTimeoutRule(1L);
	}

	public static double reasonableDelta() {
		return 0.00000001;
	}

	public static double reasonableRelativeDelta(double expected) {
		return Math.abs(reasonableDelta() * expected);
	}
}
