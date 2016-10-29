
/**
 * 
 * The class ZeroMatrix implements an algorithm such that, if an element in an
 * MxN matrix is 0, its entire row and column are set to 0.
 * 
 * @author M Krishna Kavya
 *
 */
public class ZeroMatrix {

	/**
	 * The method setZeros takes the matrix of size m* n as an input and
	 * replaces the column and row to 0's.
	 * 
	 * 1.Initialize the row and column boolean array. This keeps track of the
	 * columns and rows that contain 0.
	 * 
	 * 
	 * 2. Parse through the matrix and set boolean arrays to true when 0 is
	 * found.(The elements atre marked first as direct manipulation will change
	 * the elements in the main array. and that might lead to a 0 matrix.)
	 * 
	 * 3. parse through the matrix and if the column or row of the index(boolean
	 * array) is true, then set the element to 0.
	 * 
	 * @param matrix
	 */
	public void setZeros(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows[i] || columns[j]) {
					matrix[i][j] = 0;
				}
			}
		}

		System.out.println("zero matrix:");
		display(matrix);
	}

	/**
	 * method to display the matrix
	 * 
	 * @param matrix
	 */
	public void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int[] inner = matrix[i];
			for (int j = 0; j < inner.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 2, 7, 3 }, { 4, 5, 6 } };
		ZeroMatrix obj = new ZeroMatrix();
		System.out.println("Main Matrix");
		obj.display(matrix);
		obj.setZeros(matrix);

	}

}
