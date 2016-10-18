import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author M Krishna Kavya
 * 
 */
public class PermutationOfString {

	private List<String> result = new ArrayList<String>();

	/**
	 * The permute method calculates the the permutations possible for a given
	 * input string.
	 * 
	 * 1. The input String is converted to a character Array.
	 * 
	 * 2. A map is created with the key value pair of characters and the count
	 * of the character in the String. The TreeMap sorts the input string to key
	 * value pairs in natural sorting order of the Key.
	 * 
	 * 3. A character array and and integer array are initialized, to store the
	 * characters and the count of the character respectively.
	 * 
	 * 4. A character array is initialized to store the result or each
	 * permutation.
	 * 
	 * 5. permUtil function is called to find different permutations of the
	 * String.
	 * 
	 * @param inputString
	 *            - input String to find the permutations.
	 */
	public void permute(String inputString) {
		if (inputString == null || inputString.length() == 0) {
			System.out.println("The input String cannot be null/ empty");
			System.exit(0);
		}
		char[] input = inputString.toCharArray();
		Map<Character, Integer> countMap = new TreeMap<>();
		for (char ch : input) {
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
		}

		// Initializing the array of characters and count of each character.
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;

		// assigning the values to the array.
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey().charValue();
			count[index] = entry.getValue().intValue();
			index++;
		}
		// Initializing result array.The length of the result permutation is
		// equal to the input
		char result[] = new char[input.length];
		permuteUtil(str, count, result, 0);

	}

	/**
	 * The permUtil method is a recursive method to find all possible
	 * permutation in a string.
	 * 
	 * level acts as the index of the array. for easier understanding. Every
	 * level we parse we insert the new character at that level.
	 * 
	 * if the level== result array length, that implies that the a new
	 * permutation is formed. The result array is passed to a method to add it
	 * to the result List.
	 * 
	 * for all the characters in the str array, if the count of the current
	 * character is 0, we continue. else, the character is added to the result
	 * at the current level(say 0). and the count of that character is reduced
	 * in the count array.
	 * 
	 * This is repeated with a recursion call by incrementing the level. In the
	 * next function call the character is again found having count >0 and added
	 * at level+1 (i.e. 1)
	 * 
	 * After recursive function calls the counter is reset with count[i]++. 
	 * @param str
	 *            - array of unique characters.
	 * @param count
	 *            - count of characters.
	 * @param result
	 *            - result array with length equal to the input array.
	 * @param level
	 *            - level of the array starts with 0 to input.length
	 */
	public void permuteUtil(char[] str, int[] count, char[] result, int level) {

		if (level == result.length) {
			addResult(result);
			return;
		}

		for (int i = 0; i < str.length; i++) {
			// The character's count is 0.
			if (count[i] == 0) {
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1);
			count[i]++;
		}

	}
	/**
	 * Method to add permutations to the result list. 
	 * @param res- result array
	 */
	public void addResult(char[] res) {
		String newPermutation = new String(res);
		result.add(newPermutation);

	}
	/**
	 * Method to find if the string is a permutation. 
	 * It returns true if the input is present in the permutation of the 
	 * @param input- String to test.
	 * @return
	 */
	public boolean isPermmutation(String input) {
		if (result.contains(input)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PermutationOfString obj = new PermutationOfString();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String input = sc.nextLine();
		obj.permute(input);
		System.out
				.println("Enter a different combination of the initial string to find if its a permutation");
		String inputPerm = sc.nextLine();

		if (obj.isPermmutation(inputPerm)) {
			System.out.println("the input string is a permutation of: "
					+ inputPerm);
		} else {
			System.out.println("is not");
		}

		sc.close();
	}

}
