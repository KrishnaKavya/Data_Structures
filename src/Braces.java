import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Question 
 * Given a string of opening and closing parentheses, check whether
 * it’s balanced. We have 3 types of parentheses: round brackets: (), square
 * brackets: [], and curly brackets: {}. Assume that the string doesn’t contain
 * any other character than these, no spaces words or numbers. Just to remind,
 * balanced parentheses require every opening parenthesis to be closed in the
 * reverse order opened. For example ‘([])’ is balanced but ‘([)]’ is not.
 */
public class Braces {

	public boolean validate(String string) {
		
		Deque<Character> stack = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder(string);
		boolean result=false;
		for (int i = 0; i < sb.length(); i++) {
			char var=sb.charAt(i);
			if(var=='{'||var=='('||var=='['){
				stack.push(var);
			}else if(stack.isEmpty()){
					result=false;
					break;
				} else if(var==']'||var=='}'||var==')'){
					char peek=stack.peek();
					if(var==']'&&peek=='['||var=='}'&&peek=='{'||var==')'&&peek=='('){
						stack.pop();
					}else{
						result=false;
						break;
					}
				}
		
		}
		if(stack.isEmpty()){
			result=true;
		}
		return result;
	}

	public static void main(String[] args) {

		Braces braces = new Braces();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to validate if balanced");
		String input = sc.nextLine();
		System.out.println(braces.validate(input));
		sc.close();
	}

}
