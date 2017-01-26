import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author M Krishna Kavya
 * 
 *         The class UniqueCharactersInString implements to check if there are
 *         unique characters in the String given.
 * 
 * 
 */
public class UniqueCharactersInString {

	/**
	 * Approach 1
	 * 
	 * The method validates returns true if the string is unique else returns
	 * false.
	 * 
	 * Implementation:
	 * 
	 * A list of type Character is initialized. The input string is converted to
	 * a character array. For each character in a string, we check is the
	 * character is already in the Array List. If yes, the character is
	 * repeated. return false. else, we add the character to the List. The above
	 * process is done for all the characters in the string.
	 * 
	 * If the loop is not broken that implies all the characters are processed
	 * and there was no character being repeated. Hence, return false at the end
	 * of function call.
	 * 
	 * @param string
	 * @return
	 */
	public boolean validate(String string) {
		if (string == null) {
			return false;
		}
		List<Character> list = new ArrayList<Character>();
		char[] charArray = string.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (list.contains(charArray[i])) {
				return false;
			} else {
				list.add(charArray[i]);
			}
		}
		return true;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public boolean isUnique(String string) {
		int length = string.length();
		char[] charArray = string.toCharArray();
		boolean[] bool = new boolean[256];
		for (int i = 0; i < length; i++) {
			if (bool[charArray[i]] == true) {
				return false;
			} else {
				bool[charArray[i]] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		UniqueCharactersInString obj = new UniqueCharactersInString();

		/*
		 * Scanner sc = new Scanner(System.in); System.out .println(
		 * "Please give an input string to validate if the string has unique characters"
		 * ); boolean result = obj.validate(sc.next()); if (result) { System.
		 * out.println("The String has unique characters"); } else { System.out
		 * .
		 * println("The input is empty/The String does not have unique characters"
		 * ); } sc.close();
		 */
		System.out.println(obj.isUnique("Kvya"));
	}

}
