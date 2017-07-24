package org.cloud.hanzz;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * In order to run this class from Maven command, the class name must end with
 * "Test"; otherwise, it is hidden from Maven.
 * 
 * @author Jiayun Han
 *
 */
public class LooperTest {

	private static Looper looper;

	@BeforeClass
	public static void setup() {
		looper = new Looper();
	}

	@Test
	public void case1() {

		int[] arrayA = { 2, -9, 3, 4, 100, 0 };
		int[] arrayB = { 0 };

		int[] result = looper.findMaxOverlappingRange(arrayA, arrayB);
		Assert.assertNull(result);
	}

	@Test
	public void case2() {

		int[] arrayA = { 2, -9, 3, 4, 100, 0 };
		int[] arrayB = { 2 };

		int[] result = looper.findMaxOverlappingRange(arrayA, arrayB);
		int range = result[1] - result[0] + 1;

		// only the first element is common
		Assert.assertTrue(range == 1);
		Assert.assertTrue(result[0] == 0);
	}

	@Test
	public void case3() {

		int[] arrayA = { 2, -9, 3, 4, 100, 0 };
		int[] arrayB = { 2, 12, 3, 4, 6 };

		int[] result = looper.findMaxOverlappingRange(arrayA, arrayB);
		int range = result[1] - result[0] + 1;

		// shares element at [2, 3]
		Assert.assertTrue(range == 2);
	}

	@Test
	public void case4() {

		// 0 1 2 3 4 5 6 7 8 9 10 11 12
		int[] arrayA = { 2, -9, 3, 4, 100, 0, 9, 10, 13, 23, 89, 91, 0 };
		int[] arrayB = { 2, 12, 3, 4, 6, 5, 9, 10, 13, 23, 7, 91, 0, 88 };

		int[] result = looper.findMaxOverlappingRange(arrayA, arrayB);

		// share elements at 6, 7, 8, 9.
		Assert.assertTrue(result[0] == 6);
		Assert.assertTrue(result[1] == 9);
	}
}
