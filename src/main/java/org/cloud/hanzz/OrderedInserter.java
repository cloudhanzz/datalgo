package org.cloud.hanzz;

import java.util.List;

/**
 * 
 * @author Jiayun Han
 *
 */
public interface OrderedInserter {

	/**
	 * <b>Problem Statement</b>
	 * <p>
	 * Given a list of comparable elements of type T that is in no-descending
	 * order and a new element of the same type, insert the element to the list
	 * and the resulted list keeps its sorting order.
	 * 
	 * <p>
	 * Examples
	 * 
	 * <pre>
	 * Example 1:
	 * 
	 * List<String> = [a, b, f, m]
	 * element = d
	 * 
	 * The resulted list after the insertion should be [a, b, d, f, m] 
	 *  
	 *  
	 * Example 2:
	 * 
	 * List<Integer> = []  (i.e. an empty list)
	 * element = -60
	 * 
	 * The resulted list after the insertion should be [-60]
	 * </pre>
	 * 
	 * <p>
	 * Assuming both the list and the element are not null but the list can be
	 * initially empty.
	 * 
	 * <p>
	 * Time complexity is O(n) or O(log(n)) and space complexity is O(n), in
	 * worse case.
	 * 
	 * @param list
	 *            A non-descending list into which the new element is to be
	 *            inserted
	 * 
	 * @param element
	 *            The new element to be inserted into the list
	 */
	<T extends Comparable<? super T>> void insert(List<T> list, T element);
}
