import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author M Krishna Kavya
 * 
 */
public class PermutationOfString {
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
	 * 
	 * 
	 * 
	 * 
	 * @param inputString
	 */
	public void permute(String inputString) {
		char[] input = inputString.toCharArray();
		Map<Character, Integer> countMap = new TreeMap<>();
		for (char ch : input) {
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
s
	public static void main(String[] args) {
		PermutationOfString obj = new PermutationOfString();
		obj.permute("adb");

	}

}
