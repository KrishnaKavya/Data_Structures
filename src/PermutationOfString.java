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
	 * @param inputString
	 *            - input String to find the permutations.
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

		// Initializing the array of characters and count of each character.
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index=0;
		//assigning the values to the array. 
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index]=entry.getKey();
			count[index]=entry.getValue();
		}
		//Initializing result array.The length of the result permutation is equal to the input
		char result[]=new char[input.length];
		permuteUtil(str,count,result,0);
		
		

	}

	public void permuteUtil(char[] str, int[] count, char[] result, int level) {
		if(level==result.length){
			printArray(result);
			return;
		}
		
		for(int i=0;i<str.length;i++){
			//The character's count is 0.
			if(count[i]==0){
				continue;
			}
			result[level]=str[i];
			count[i]--;
			permuteUtil(str,count,result,level+1);
			count[i]++;
		}
		
	}

	private void printArray(char[] result) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		PermutationOfString obj = new PermutationOfString();
		obj.permute("adb");

	}

}
