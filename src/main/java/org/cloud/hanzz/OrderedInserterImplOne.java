package org.cloud.hanzz;

import java.util.List;

/**
 * Use no built-in add(int, T) method but shift rightward manually.
 * 
 * @author Jiayun Han
 *
 */
public class OrderedInserterImplOne implements OrderedInserter {

	@Override
	public <T extends Comparable<? super T>> void insert(List<T> list, T element) {

		if (list.isEmpty()) {
			list.add(element);
			return;
		}

		list.add(null);

		for (int i = list.size() - 2; i >= 0; i--) {

			T candidate = list.get(i);

			// The new element should be placed right after candidate
			if (candidate.compareTo(element) <= 0) {
				list.set(i + 1, element);
				return;
			}

			// shift t2 rightward
			list.set(i + 1, candidate);
		}
	}

}
