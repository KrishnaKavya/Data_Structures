/**
 * 
 * @author M Krishna Kavya
 *
 *         The class Rotate Matrix implements the methods to rotate a matrix.
 * 
 */

public class RotateMatrix {

	/**
	 * The rotate method implements the in place rotation of a matrix.
	 * 
	 * @param matrix
	 * @return
	 */
	public int[][] rotate90Clockwise(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {

				int temp = matrix[i][j];// save the top element;
				matrix[i][j] = matrix[n - 1 - j][i]; // right -> top;
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // bottom
																		// ->
																		// right;
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]; // left ->
																		// bottom;
				matrix[j][n - 1 - i] = temp; // top -> left;
			}
		}

		return matrix;
	}

	/**
	 * The method rotate 180 rotates the matrix with 180 degrees. A temp matrix
	 * is initialized. A 180 rotation of a matrix reverses the rows from bottom
	 * to top. we assign rows in the reverse order to a new Matrix. which is the
	 * 180 degree rotation.
	 * 
	 * @param matrix
	 */
	public int[][] rotate180(int[][] matrix) {
		int n = matrix.length;
		int temp[][] = new int[n][n];
		int lastIndex = n - 1;
		for (int i = 0; i < n; i++) {
			if (i != lastIndex) {
				temp[i] = matrix[lastIndex];
				lastIndex--;
			}
		}
		return matrix;
	}

	/**
	 * Method displays an matrix.
	 * 
	 * @param temp
	 */
	public void display(int[][] temp) {
		int n = temp.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + temp[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateMatrix obj = new RotateMatrix();
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		System.out.println("The main matrix is");
		obj.display(matrix);
		
		System.out.println("The matrix after 90 degree rotation");
		int[][] _90 = obj.rotate90Clockwise(matrix);
		obj.display(_90);
		
		
		System.out.println("A 90 degree rotation on the result. ");
		int[][] _180 = obj.rotate90Clockwise(_90);
		obj.display(_180);
		
		System.out.println("180 degree rotation on the main matrix.");
		int[][] _180Method2=obj.rotate180(matrix);
		obj.display(_180Method2);

	}

}
