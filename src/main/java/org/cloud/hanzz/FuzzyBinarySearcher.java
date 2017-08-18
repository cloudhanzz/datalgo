package org.cloud.hanzz;

import java.util.List;

/**
 * A binary search class searching an element that is or is not contained in a
 * sorted list of elements of the same type. Generics is used.
 * 
 * <p>
 * August 17, 2017, Montreal, Quebec
 * 
 * @author Jiayun Han
 *
 */
public class FuzzyBinarySearcher<T extends Comparable<? super T>> {

	/**
	 * <b>Problem Statement</b>
	 * <p>
	 * Given a list of elements in non-descending order and a new element of the
	 * same type, this function:
	 * 
	 * <ul>
	 * <li>returns -1 if the list is empty
	 * <li>returns the index of any of the elements in the list that equals to
	 * the new element if the new element is contained in the list
	 * <li>returns the first index of the list, i.e. 0, if the new element is
	 * smaller than the first element of the list
	 * <li>returns the last index of the list if the new element is greater than
	 * the last element of the list
	 * <li>returns 1 plus the index of the element that is just smaller than the
	 * new element for the other situation
	 * </ul>
	 * 
	 * <p>
	 * Assume that:
	 * 
	 * <ol>
	 * <li>the list can be empty
	 * <li>the list is sorted in ascending order
	 * <li>the list may contain duplicates
	 * <li>the list may or may not contain the new element to be searched
	 * </ol>
	 * 
	 * <p>
	 * Examples:
	 * 
	 * <pre>
	 * case 1:
	 * --------------------------------------------------
	 * list = [], then returns -1
	 * 
	 * 
	 * Case 2:
	 * --------------------------------------------------
	 * index   0  1  2  3  4
	 * list = [2, 3, 3, 3, 100]
	 * element = 3
	 * 
	 * then returns 1, or 2, or 3, since they represent the indice 
	 * of the duplicated target element
	 * 
	 * 
	 * Case 3:
	 * --------------------------------------------------
	 *
	 * index   0  1  2  3  4
	 * list = [2, 3, 3, 3, 100]
	 * element = -300
	 * 
	 * then returns 0, since -300 < 0
	 * 
	 * 
	 * Case 4:
	 * --------------------------------------------------
	 * 
	 * index   0  1  2  3  4
	 * list = [2, 3, 3, 3, 100]
	 * element = 108
	 * 
	 * then returns 4, since 108 > 100
	 * 	
	 * 
	 * Case 5:
	 * --------------------------------------------------
	 * 
	 * index   0  1   2   3   4
	 * list = [1, 30, 63, 84, 100]
	 * element = 70
	 * 
	 * then returns 3, since 63 indexed by 2 is just smaller 
	 * than 70 and 2 + 1 = 3
	 * 
	 * </pre>
	 * 
	 * <p>
	 * Time complexity is O(log(n)) and space complexity is O(1).
	 * 
	 * @param list
	 *            The list of elements sorted in ascending order
	 * @param target
	 *            The element to be searched for
	 * @return As described above
	 */
	public int findJustSmaller(List<T> list, T target) {

		if (list.isEmpty()) {
			return -1;
		}

		if (list.size() == 1) {
			return 0;
		}

		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			T trial = list.get(mid);
			int com = trial.compareTo(target);

			// case 1
			if (com == 0) {
				return mid;
			}

			// case 2: target is smaller than trial: --->>>>
			if (com < 0) {

				int idxPlusOne = mid + 1;
				if (idxPlusOne < list.size()) {
					T biggerOne = list.get(idxPlusOne);
					int com2 = biggerOne.compareTo(target);
					if (com2 > 0) {
						return idxPlusOne;
					}

					left = idxPlusOne;
				} else {
					return mid;
				}
			}
			// case 3: target is greater than trial: <<<<----
			else if (com > 0) {
				int idxMinusOne = mid - 1;
				if (idxMinusOne >= 0) {
					T smallerOne = list.get(idxMinusOne);
					int com2 = smallerOne.compareTo(target);
					if (com2 < 0) {
						return mid;
					}

					right = idxMinusOne;
				} else {
					return mid;
				}
			}
		}

		return -1;
	}
}
