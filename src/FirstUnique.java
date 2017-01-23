import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Question: Find the first non repetitive character in the string.
 * 
 * 
 * 
 * @author M Krishna Kavya
 *
 */
public class FirstUnique {

	public String firstUnique(String params) {

		char[] charArray = params.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Deque<Character> queue = new ArrayDeque<Character>();
		for (int i = 0; i < charArray.length; i++) {
			if (!map.containsKey(charArray[i])) {
				map.put(charArray[i], 1);
				queue.add(charArray[i]);
			} else {
				map.put(charArray[i], (map.get(charArray[i]) + 1));
				queue.add(charArray[i]);
			}
		}

		while (!queue.isEmpty()) {
			char current = queue.remove();
			if (map.get(current) == 1) {
				return "The first unique character is " + current;
			}
		}
		return "The String Does not have unique characters";
	}

	public static void main(String[] args) {
		FirstUnique obj = new FirstUnique();
		String result = obj.firstUnique("kavyak");
		System.out.println(result);
	}

}
