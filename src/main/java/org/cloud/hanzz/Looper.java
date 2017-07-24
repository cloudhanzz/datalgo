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
	 * index, both inclusive, indicating the range of the common elements of the
	 * two arrays sitting at the same indexes.
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

	public static void main(String[] args) {
		Looper looper = new Looper();

		int[] arrayA = { 2, -9, 3, 4, 100, 0 };
		int[] arrayB = { 2, 12, 3, 4, 6 };
		
		int[] result = looper.findMaxOverlappingRange(arrayA, arrayB);
		
		printArray(result);
	}

	private static void printArray(int[] result) {
		
		System.out.println();
		
		if(result == null){
			System.out.println("Not found");
		}else{
			for(int e : result){
				System.out.print(e + ", ");
			}
		}
		
		System.out.println();
		
	}

}
