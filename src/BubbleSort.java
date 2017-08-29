import java.util.Arrays;

/**
 * 
 * 
 * Bubble sort is an algorithm that sorts an array of elements in increasing
 * order by comparing adjacent elements.
 * 
 * Analysis of Bubble Sort: worst case: O(n2) Average: O(n2) Best: O(n)
 * 
 * @author M Krishna Kavya
 *
 */

public class BubbleSort {
	/**
	 * 
	 * 
	 * we start comparision with the one element with its adjacent element. if
	 * the elements of the left element is greater than the right then swap. we now
	 * consider the right element and its adjacent element. This operation is
	 * performed to all the elements in the array.
	 * 
	 * Once we reach the end of the array performing the swaps. The largest
	 * element is placed at the last index. The process of comparision from
	 * start till the end of an array is called as a pass.
	 * 
	 * Depending on the input . after a certain number of pass the array will be
	 * sorted.
	 * 
	 * 
	 * Optimization:
	 * 
	 * 1. At the end of every pass the higher elements gets placed in order in
	 * the end. so, It is not required to perform comparision and swaps. Hence,
	 * we reduce the iterations of the inner loop size-1 to size-i-1. 2. After
	 * certain number of pass operations. The array is already sorted. (Eg:
	 * there are 10 elements in the array the outer loop runs for n times but
	 * the elements get sorted in 3rd iteration).When the array is already
	 * sorted there are no swaps being performed. Hence, we set a flag to check
	 * if swaps are performed. Once there are no swaps we can break the loop and
	 * save the rest of iterations.
	 * 
	 * @param input
	 *            - array of elements.
	 */
	public static void bubbleSort(int input[]) {
		int size = input.length;
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] input = { 7, 1, 3, 5, 4 };
		bubbleSort(input);
		System.out.println(Arrays.toString(input));
		
	}

}
