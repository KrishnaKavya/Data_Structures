import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author M Krishna Kavya
 * 
 * Question: Given a string of opening and closing parentheses, check whether
 * it’s balanced. We have 3 types of parentheses: round brackets: (), square
 * brackets: [], and curly brackets: {}. Assume that the string doesn’t contain
 * any other character than these, no spaces words or numbers. Just to remind,
 * balanced parentheses require every opening parenthesis to be closed in the
 * reverse order opened. For example ‘([])’ is balanced but ‘([)]’ is not.
 */

/**
 * solution: This is a data structure problem, the balancing of the expression
 * with the parenthesis can be solved using the stack.
 * The validate function gets the parameter string as an input from the user. 
 *  
 * 1. The String builder is declared and initialized with the input string.
 * 2. For every character in in the string is processed in the for loop. 
 * 3. for each character,
 *    3.1 if the character is equal to (, {, [ the character is pushed into the stack. 
 *    3.2 if the character is not equal to (,{,,[ then the stack is checked if its empty or not.
 *        is the stack is empty that implies that the expression is not balanced(There is one more close character to process and the stack is empty.
 *    3.3 if the stack is not empty, and the character is equal to },],). 
 *    	  The last element of the stack is peeked and compared to the current element. If the pair is a balanced expression. 
 *        The stack is popped.
 *    3.4 If the pair is not a balanced expression then, the expression is not balanced. result is false. 
 *    3.5 Once the string is processed, the expression is balanced when the stack is empty. else it is unbalanced. 
 *   
 *  Note: Balanced Expression is when it is in the form of open and close that is (),{},[]. 
 */
public class Braces {
	public boolean validate(String string) {
		
		
		Deque<Character> stack = new ArrayDeque<Character>();       //stack Declaration.
		StringBuilder sb = new StringBuilder(string);				//Intializing string builder with the input string. 
		boolean result = false;										//result variable. 
		for (int i = 0; i < sb.length(); i++) {
			char var = sb.charAt(i);
			if (var == '{' || var == '(' || var == '[') {		    //comparing if the current character is open. if true push into stack. 
				stack.push(var);
			} else if (stack.isEmpty()) {							//When there is a character to process and stack is empty, that implies the expression is not balanced and the loop is breaked. 
				result = false;
				break;												
			} else if (var == ']' || var == '}' || var == ')') {	//when the character is close and the top of the stack is its pair.stack is popped 
				char peek = stack.peek();
				if (var == ']' && peek == '[' || var == '}' && peek == '{'
						|| var == ')' && peek == '(') {
					stack.pop();
				} else {										   //when the condition fails the expression is not balances and the loop is breaked. 
					result = false;
					break;
				}
			}
		}	
		if (stack.isEmpty()) {									// After processing all  the characters of a string is the stack is empty that means the expression is balances. 
			result = true;
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
