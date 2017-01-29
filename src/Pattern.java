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
		System.out.println("Pattern 1");
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
	 *      *
	 *     ** 
	 *    *** 
	 *   **** 
	 *  *****
	 */
	public void two() {
		System.out.println("Pattern 2");
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

	/**
	 * Program to print Pyramid
	 * 
	 *     * 
	 *    *** 
	 *   ***** 
	 *  ******* 
	 * *********
	 */
	public void pyramid() {
		System.out.println("Pyramid");
		int levels = 6;
		int j = levels, odds = 1;
		for (int k = 1; k <= levels; k++) {
			// spaces
			for (int i = 1; i <= j; i++) {
				System.out.print(" ");
			}
			// Stars
			for (int i = 1; i <= odds; i++) {
				System.out.print("*");
			}
			odds = odds + 2;
			j--;
			System.out.println();
		}

	}

	/**
	 * Program to print inverse Pyramid
	 * 
	 *  *******
	 *   *****
	 *    ***
	 *     *
	 *    
	 */
	public void inversePyramid() {
		System.out.println("Inverse Pyramid");
		int levels = 6;
		int odds = (2 * levels) - 1, spaces = 0;
		for (int i = 1; i <= levels; i++) {
			// spaces
			for (int k = 0; k < spaces; k++) {
				System.out.print(" ");
			}
			spaces++;
			// stars
			for (int k = 0; k <= odds - 1; k++) {
				System.out.print("*");
			}
			odds = odds - 2;
			System.out.println();
		}

	}

	public static void main(String args[]) {
		Pattern obj = new Pattern();
		obj.one();
		obj.two();
		obj.pyramid();
		obj.inversePyramid();
	}
}
