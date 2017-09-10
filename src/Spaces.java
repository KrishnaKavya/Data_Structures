/**
 * 
 * @author M Krishna Kavya
 * 
 *         The Spaces class replaces the spaces in a sentence with %.
 */
public class Spaces {

	public char[] spaces(String input) {

		int spaceCount = 0;
		int length = input.length();
		char[] str = input.toCharArray();
		
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		//new String length.
		int newLength = length + (spaceCount * 2);
		
		char[] newString = new char[(newLength)];

		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newString[newLength - 1] = '0';
				newString[newLength - 2] = '2';
				newString[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				newString[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}

		return newString;

	}

	public static void main(String[] args) {
		Spaces obj = new Spaces();
		char[] result = obj.spaces("The Scentance has spaces");
		System.out.println(new String(result));

	}

}
