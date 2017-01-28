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
	
	/**
	 *       *
	 *	    *** 
	 * 	   *****	
	 * 	  *******
	 * 	 *********
	 */
	public void three(){
		int levels=5, j=5, odds=1;
		for(int k=1;k<=levels;k++){
			for(int i=1;i<=j;i++){
				System.out.print(" ");
			}
			for(int i=1;i<=odds;i++){
				System.out.print("*");
			}
		   odds=odds+2;
		   j--;
		   System.out.println();
		}
		
	}
	
	public static void main(String args[]) {
		Pattern obj = new Pattern();
		// obj.one();
		//obj.two();
		obj.three();
	}
}
