import java.util.Scanner;

public class ReverseOfString {

	public void reverse(String inputString) {

		char[] charArray = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		ReverseOfString obj = new ReverseOfString();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the string to reverse.");
		String inputString = sc.next();
		obj.reverse(inputString);

	}

}
