package org.cloud.hanzz;

import java.util.List;

/**
 * Implementing the classic binary search by recursion and looping.
 * 
 * @author Jiayun Han
 *
 */
public class BinarySearcher<T extends Comparable<? super T>> {

	public int searchByLoop(List<T> list, T element) {

		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {

			int mid = (left + right) / 2;
			T x = list.get(mid);

			int c = x.compareTo(element);
			if (c == 0) {
				return mid;
			}

			if (c < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public int searchByRecursion(List<T> list, T element) {
		return recursor(list, element, 0, list.size() - 1);
	}

	private int recursor(List<T> list, T element, int left, int right) {

		if (right < left) {
			return -1;
		}

		int mid = (left + right) / 2;
		T x = list.get(mid);

		int c = x.compareTo(element);
		if (c == 0) {
			return mid;
		}

		if (c < 0) { // search right half
			return recursor(list, element, mid + 1, right);
		}

		// search left half
		return recursor(list, element, left, mid - 1);
	}
}
