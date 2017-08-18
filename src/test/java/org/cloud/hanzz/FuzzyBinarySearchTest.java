package org.cloud.hanzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test the correctness of FuzzyBinarySearch
 * 
 * @author Jiayun Han
 *
 */
public class FuzzyBinarySearchTest {

	private static FuzzyBinarySearcher<Integer> searcher;
	private static List<Integer> list;
	private static int element;
	private static int index;

	@BeforeClass
	public static void setup() {
		searcher = new FuzzyBinarySearcher<>();
		list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(100);
	}

	@Test
	public void testSearchEmptyList() {
		index = searcher.findJustSmaller(new ArrayList<Integer>(), 152);
		Assert.assertTrue(index == -1);
	}

	@Test
	public void testSingleExistent() {

		element = 100;
		index = searcher.findJustSmaller(list, element);
		Assert.assertTrue(index == 4);
	}

	@Test
	public void testMultipleExistents() {

		element = 3;

		index = searcher.findJustSmaller(list, element);
		boolean ok = (index == 2) || (index == 3) || (index == 4);
		Assert.assertTrue(ok);
	}

	@Test
	public void testSmallerThanSmallest() {

		element = -300;
		index = searcher.findJustSmaller(list, element);
		Assert.assertTrue(index == 0);
	}

	@Test
	public void testBiggerThanBiggest() {

		element = 108;
		index = searcher.findJustSmaller(list, element);
		Assert.assertTrue(index == list.size() - 1);
	}

	@Test
	public void testFuzzieness() {

		list.clear();
		list.add(1);
		list.add(30);
		list.add(63);
		list.add(84);
		list.add(100);
		element = 70;

		index = searcher.findJustSmaller(list, element);
		Assert.assertTrue(index == 3);
	}

	@Test
	public void strictTest() {

		int size = 10000;
		int upperBound = size * 4;

		List<Integer>list2 = new ArrayList<>(size);
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			list2.add(random.nextInt(upperBound));
		}

		Collections.sort(list2);

		int target = random.nextInt(upperBound);
		while (list2.contains(target)) {
			target = random.nextInt(upperBound);
		}

		int last = list2.get(list2.size() - 1);
		System.out.println(list2 + " : " + target);

		if (target >= last) {

			list2.add(target);
		} else {
			int index = searcher.findJustSmaller(list2, target);
			list2.add(index, target);
		}

		for (int i = 0; i < size; i++) {
			int smaller = list2.get(i);
			int bigger = list2.get(i + 1);

			Assert.assertTrue(smaller <= bigger);
		}
	}
}
