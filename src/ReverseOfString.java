import java.util.Scanner;

/**
 * 
 * @author M Krishna Kavya
 * 
 *         The class Reverse of String implements different techniques of
 *         reversing a string.
 * 
 *         1. Using StringBuilder. 2. Using Recursion 3. Using swap Technique.
 * 
 */
public class ReverseOfString {

	/**
	 * The method reverse implements the reverse using StringBuilder.
	 * 
	 * The StringBuilder is initialized null. A for loop starts from the last
	 * character to the first. for every character. the string builder is
	 * appends a character. (in backwards order). the String Builder object gets
	 * the reverse string after the end of loop.
	 * 
	 * @param inputString
	 * @return- returns the reverse string
	 */
	public String reverse(String inputString) {
		if (isNull(inputString)) {
			return "The input String is empty";
		}
		char[] charArray = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

	/**
	 * This method implements the reverse of string using recursion. The input
	 * string is split into a substring from the indices 1-end and character at
	 * 0 is fetched. The recursive call is performed making the split as above.
	 * Once input string becomes null. the charAt(0)'s of every function are
	 * concatenated and returned by the function.
	 * 
	 * @param inputString
	 * @return
	 */
	public String reverseRecurssion(String inputString) {
		if (isNull(inputString)) {
			return inputString;
		}
		return reverseRecurssion(inputString.substring(1))
				+ inputString.charAt(0);
	}

	/**
	 * The function implements the swap technique to reverse a string. The
	 * string is converted into a character array. Two indices left and right
	 * are initialised. The left-0 (start) right- length-1 end of the array. we
	 * swap left and right indices increment left index and decrement right
	 * node. repeat the process while left<right.
	 * 
	 * @param inputString
	 * @return
	 */
	public String reverseSwap(String inputString) {
		if(isNull(inputString)){
			return "The input String is empty";
		}
		char[] charArray = inputString.toCharArray();
		int leftIndex = 0;
		int rightIndex = charArray.length - 1;
		for (leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
			// swap;
			char temp = charArray[leftIndex];
			charArray[leftIndex] = charArray[rightIndex];
			charArray[rightIndex] = temp;
			rightIndex--;
		}

		String result = new String(charArray);
		return result;
	}
	/**
	 * Method that checks if input is null.
	 * @param string
	 * @return
	 */
	private boolean isNull(String string) {
		if (string == null || string.length() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ReverseOfString obj = new ReverseOfString();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the string to reverse.");
		String inputString = sc.nextLine();
		System.out.println("reverse of String using String Builder: "
				+ obj.reverse(inputString));
		System.out.println("Reverse of String using Recursion: "
				+ obj.reverseRecurssion(inputString));
		System.out.println("reverse of a String using swap Technique: "
				+ obj.reverseSwap(inputString));

	}

}
