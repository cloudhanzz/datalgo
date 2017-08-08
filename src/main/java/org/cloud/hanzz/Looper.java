package org.cloud.hanzz;

/**
 * This class contains the looping methods as the solutions to some basic
 * testing questions.
 * 
 * @author Jiayun Han
 *
 */
public class Looper {

	/**
	 * <b>Problem Statement</b>
	 * <p>
	 * Given two arrays of integers, find the starting index and the ending
	 * index, both inclusive, indicating the maximal range of the common
	 * elements of the two arrays sitting at the same indexes.
	 * 
	 * <p>
	 * Assume that (1) the two arrays each can contain any integers and they can
	 * be empty as well, (2) the two arrays are not necessarily sorted, (3) The
	 * two array may have different lengths.
	 * 
	 * <p>
	 * Examples:
	 * 
	 * <pre>
	 * Case 1:
	 *
	 * idx  0   1  2  3  4    5
	 * a = [2, -9, 3, 4, 100, 0]
	 * b = [0]
	 * 
	 * Then null should be returned, as there is no common index range
	 * 
	 * Case 2:
	 * 
	 * idx  0   1  2  3  4    5
	 * a = [2, -9, 3, 4, 100, 0]
	 * b = [2, 12, 3, 4, 6]
	 * 
	 * Then [2, 3] should be returned, as elements of the two arrays 
	 * at index 2 and index 3 are the same. Although [0, 0] also contain
	 * the same element, its length is 1, so it should not the answer.
	 * 
	 * 
	 * Case 3:
	 * 
	 * idx  0   1  2  3  4    5  6  7  8   9  10
	 * a = [2, -9, 3, 4, 100, 0, 9, 5, 9, -1, 10]
	 * b = [2, 12, 3, 4, 6,   0, 3, 5, 9, -1, 12]
	 * 
	 * Then [7, 9] should be returned, as elements of the two arrays 
	 * at indice 7, 8, 9 are the same and they are three elements and are
	 * bigger than the common elements at index 2 and index 3 (which only
	 * has two).
	 * 
	 * </pre>
	 * 
	 * <p>
	 * Time complexity is O(n) and space complexity is O(1).
	 * 
	 * @param arrayA
	 *            The first integer array
	 * @param arrayB
	 *            The second integer array
	 * 
	 * @return A 2-element integer array, the first element is the starting
	 *         index while the second is the ending index, both inclusive,
	 *         indicating the range of the common elements of the two arrays
	 *         sitting at the same indexes. Return null if the two arrays have
	 *         no common elements at the same location range.
	 */
	public int[] findMaxOverlappingRange(int[] arrayA, int[] arrayB) {

		// The 2-element array for return
		int[] result = new int[2];

		// the number of same elements
		int maxRange = 0;

		for (int i = 0; i < arrayA.length && i < arrayB.length; i++) {

			if (arrayA[i] == arrayB[i]) {
				int start = i;

				i++;
				while (i < arrayA.length && i < arrayB.length) {

					if (arrayA[i] != arrayB[i]) {
						break;
					}

					i++;
				}

				int end = i - 1;
				int range = (end - start) + 1;

				if (range > maxRange) {
					maxRange = range;
					result[0] = start;
					result[1] = end;
				}
			}
		}

		if (maxRange == 0) {
			return null;
		}

		return result;
	}

	/**
	 * <b>Problem Statement</b>
	 * <p>
	 * Given an integer <i>number</i> and the number of batches <i>batches</i>, we want to
	 * split the number into <i>batches</i> batches and return an integer array
	 * <i>array</i> which has the following features
	 * 
	 * <ul>
	 * <li>array[0] is the start of batch_1, array[1] is the end of batch_1;
	 * array[2] is the start of the batch_2 and array[3] is the end of batch_2,
	 * and so on.
	 * 
	 * <li>Except the last batch, the difference between the start and the end
	 * of any batch equals that of any another batch
	 * 
	 * <li>If batch_j is immediately following batch_i, then the difference
	 * between the start of batch_j and the end of batch_i is exactly 1.
	 * </ul>
	 * 
	 * <p>
	 * Example
	 * 
	 * <pre>
	 * if x = 123 and b = 4 (split the number 123 into 4 batches)
	 * 
	 * then the following array should be returned
	 * 
	 * [1,40, 41,80, 81,120, 121,123]
	 * 
	 * <p>
	 * Time complexity is O(n) and space complexity is O(n), in worse case.
	 * 
	 * @param number
	 *            The set of positive integers in ascending order
	 * 
	 * @param batches
	 *            The start limit, which is less than or equals to ids.first
	 * 
	 * @return an integer array <i>array</i> which has the above-described
	 *         features.
	 */
	public int[] splitUp(int number, int batches) {

		int batchSize = number / batches;

		int size = batches * 2;
		if (number % batches != 0) {
			size += 2;
		}

		int[] ret = new int[size];

		int start = 1;
		int end = 0;

		int i = 0;
		while (true) {
			
			ret[i++] = start;
			end = start + batchSize - 1;
			
			if (end >= number) {
				ret[i] = number;
				break;
			} else {
				ret[i++] = end;
			}

			start = end + 1;
		}

		return ret;
	}
}
