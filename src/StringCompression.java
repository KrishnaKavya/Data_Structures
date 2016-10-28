/**
 * 
 * @author M Krishna Kavya
 *
 *         Question:Implement a method to perform basic string compression using
 *         the counts of repeated characters. For example, the string
 *         aabcccccaaa would become a2blc5a3. If the "compressed" string would
 *         not become smaller than the original string, your method should
 *         return the original string.
 * 
 */
public class StringCompression {
	private String input;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * The compress String method takes a input string. The String is converted
	 * into a character array. we initialize a string builder. and add the first
	 * character to it. The count of the character is set to one.
	 * 
	 * we iterate the array from the second character(Index 1). till the end. if
	 * the character is equal to the current we increase the count. In the other
	 * case, when a new character is found we add the current character and
	 * count of it to the String builder and make the new character as a current
	 * character. Once the loop terminates. Add the last character and count
	 * outside the loop.
	 * 
	 * 
	 * 
	 * @return
	 */
	public String compressString() {
		char arr[] = input.toCharArray();
		char currentChar = arr[0];
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == currentChar) {
				count++;
			} else {
				sb.append(currentChar + "" + count);
				currentChar = arr[i];
				count = 1;
			}
		}
		sb.append(currentChar + "" + count);
		/*
		 * if the length of the compression is equal to or greater than original
		 * length then we return the original String.
		 */
		if (sb.length() >= input.length()) {
			return input;
		}
		/*
		 * else return the compressed string.
		 */
		return sb.toString();
	}

	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		obj.setInput("aabcccccaaa");
		System.out.println(obj.getInput());
		System.out.println(obj.compressString());

	}

}
