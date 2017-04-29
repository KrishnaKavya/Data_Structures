/**
 * 
 * @author M Krishna Kavya
 * 
 * The class implements the Binary Search Algorithm.
 *
 */
public class BinarySearch {

	public boolean binarySearch(int[] array, int low, int high, int searchValue) {

		if (low > high) {
			return false;
		}
		int mid = (low + high) / 2;
		if (searchValue < array[mid]) {
			binarySearch(array, low, mid - 1, searchValue);
		} else if (searchValue > array[mid]) {
			binarySearch(array, mid + 1, high, searchValue);
		} else if (array[mid] == searchValue) {
			System.out.println("element found");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		BinarySearch obj = new BinarySearch();

		int[] arr = { 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(obj.binarySearch(arr, 0, arr.length - 1, 1));
	}

}
