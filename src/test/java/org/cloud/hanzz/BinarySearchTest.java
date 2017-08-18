package org.cloud.hanzz;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {
	
	private static BinarySearcher<String> searcher;
	private static List<String> list;
	
	@BeforeClass
	public static void setup(){
		searcher = new BinarySearcher<>();
		list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("f");
		list.add("f");
		list.add("m");
	}
	
	@Test
	public void testEmptyList(){
		List<String> emptyList= new ArrayList<>();
		int index = searcher.searchByRecursion(emptyList, "");
		Assert.assertTrue(index == -1);
	}
	
	@Test
	public void testNonexistent(){
		int index = searcher.searchByRecursion(list, "g");
		Assert.assertTrue(index == -1);
	}
	
	@Test
	public void testExistingFarleft(){

		int index = searcher.searchByRecursion(list, "a");
		Assert.assertTrue(index == 0);
	}
	
	@Test
	public void testExistingFarRight(){

		int index = searcher.searchByRecursion(list, "m");
		Assert.assertTrue(index == list.size() - 1);
	}
	
	@Test
	public void testDuplicate(){

		int index = searcher.searchByRecursion(list, "f");
		boolean correct = (index == 2) || (index == 3);
		Assert.assertTrue(correct);
	}
}
