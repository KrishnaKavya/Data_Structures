import java.util.Scanner;

public class ReverseOfString {

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

	public String reverseRecurssion(String inputString) {
		if (isNull(inputString)) {
			return "The input String is empty";
		}
		return inputString.substring(1)+inputString.charAt(0);
	}

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
		System.out.println("Reverse of String using Recursion: "+obj.reverseRecurssion(inputString));

	}

}
