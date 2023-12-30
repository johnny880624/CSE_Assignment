package assignment6.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import assignment6.RecursiveMethods;

import static org.junit.Assert.*;

/**
 * Methods that test the arraySum() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArraySumPreliminaryTest {
    /**
     * Test the sum of {1}
     */
    @Test
    public void testSumOfOneItem() {
        int[] testArray = {1};
        assertEquals(1,                              // The value we expect to get (to pass the test)
                RecursiveMethods.arraySum(testArray));  // The thing to test
    }

    /**
     * Test the sum of {1,2,3,4,-5}
     */
    @Test
    public void testSumOfFiveItems() {
        int[] testArray = {1, 2, 3, 4, -5};
        assertEquals(5, RecursiveMethods.arraySum(testArray));
    }

    /**
     * Test the sum of {} (an empty array):  Should be 0
     */
    @Test
    public void testSumOfEmptyArray() {
        int[] testArray = {};
        assertEquals(0, RecursiveMethods.arraySum(testArray));
    }

    /**
     * Test the sum of {5,5,5,5,5,5,5,5,5,5,5,5}
     */
    @Test
    public void testSumOfTwelveFives() {
        int[] testArray = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        assertEquals(60, RecursiveMethods.arraySum(testArray));
    }
}