/**
 * 
 * @author M Krishna Kavya
 *
 */
public class Pattern {
	/**
	 * Method to print pattern
	 * 
	 * * 
	 * ** 
	 * *** 
	 * **** 
	 * *****
	 */
	public void one() {
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
	/**
	 * Method prints the pattern
	 * 
	 *     *
	 *    **
	 *   ***
	 *  ****
	 * *****	
	 */
	public void two() {
		int i = 1, j = 6;
		for (int k = 1; k < j; k++) {
			for (int c = 1; c < (j - i); c++) {
				System.out.print(" ");
			}
			for (int c = 1; c <= i; c++) {
				System.out.print("*");
			}
			System.out.println();
			i++;
		}

	}

	public static void main(String args[]) {
		Pattern obj = new Pattern();
		// obj.one();
		obj.two();
	}
}
