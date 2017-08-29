import java.util.Arrays;

/**
 * 
 * @author M Krishna Kavya
 * 
 *         Class to implement Insertion sort.
 *         Insertion sort is 
 *         1. In place
 *         2. Adaptive
 *         3. Stable
 *         
 *         
 *
 */
public class InsertionSort {

	/**
	 * Insertion sort implementing using the iterative approach.
	 * 
	 * 
	 * @param inputArray
	 * @return
	 */
	
	int i=0;
	public int[] insertionSort(int[] inputArray) {
		int i = 1;
		while (i < inputArray.length) {
			int current = inputArray[i];
			int j = i - 1;
			while (j >= 0 && inputArray[j] > current) {
				inputArray[j + 1] = inputArray[j];
				j = j - 1;
			}
			inputArray[j + 1] = current;
			i = i + 1;
		}
		return inputArray;
	}
	/**
	 * Insertion sort Implementing using Recursive approach.
	 * @param inputArray
	 * @param n
	 */
	public void insertSort(int[] inputArray, int n) {

		if (n <= 1)
			return;

		insertSort(inputArray, n - 1);
		int last = inputArray[n - 1];
		int j = n - 2;
		while (j >= 0 && last < inputArray[j]) {
			inputArray[j + 1] = inputArray[j];
			j = j - 1;
		}
		inputArray[j + 1] = last;

	}

	public static void main(String[] args) {
		
		InsertionSort obj = new InsertionSort();
		
		int arr[] = { 32, 41, 58, 24, 40, 47 };
		int arr2[] = { 32, 41, 58, 24, 40, 47 };
		
		System.out.println("Insertion Sort with Iterative Approach");
		System.out.println("Original Array: "+Arrays.toString(arr));
		obj.insertionSort(arr);
		System.out.println("Sorted Array: "+Arrays.toString(arr));

		System.out.println("Insertion Sort with Recursive Approach");
		System.out.println("Original Array"+Arrays.toString(arr2));
		obj.insertSort(arr2, arr2.length);
		System.out.println("Sorted Array:"+Arrays.toString(arr2));	

	}

}
