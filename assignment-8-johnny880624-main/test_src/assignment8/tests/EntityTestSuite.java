package assignment8.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ EntityConstructorTest.class, EntityRadiusTest.class, EntityDistanceCenterToPointTest.class,
		EntityEdgeToEdgeAndIsTouchingTest.class, EntityMoveTowardTest.class, EntityMoveAwayFromTest.class })
public class EntityTestSuite {
}
