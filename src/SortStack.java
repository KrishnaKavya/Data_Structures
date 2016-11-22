import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author M Krishna Kavya
 * 
 *         The class implements a method two sort a stack in descending order
 *         using one buffer stack. This is done without using any other data
 *         structure. using the functions of stack. push, pop,peek.
 * 
 *         Algorithm: The original stack(original stack) has all the elements.
 *         the second stack stores all the elements in a sorted order. 1. pop
 *         the element from stack original stack and save it in a temporary
 *         variable current. while the second stack(sortStack) is not empty and
 *         if the current is less than the top. we pop the element from stack
 *         and push it into original stack. This process is repeated till
 *         original stack is empty.
 * 
 * 
 *
 */
public class SortStack {

	Deque<Integer> stack = new ArrayDeque<Integer>();
	Deque<Integer> sortStack = new ArrayDeque<Integer>();

	/**
	 * adding sample elements in a stack.
	 */
	public void add() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
	}

	/**
	 * sorting a stack
	 * 
	 * The method takes each element from the stack and while the second stack
	 * is not empty and the element is less than the top element of second
	 * stack. we pop the element from the second and push it into the first.
	 * This is repeated till the current position of top satisfies the
	 * descending order. The element is pushed into the current position.
	 * 
	 */
	public void sort() {
		while (!stack.isEmpty()) {
			int current = stack.pop();
			while (!sortStack.isEmpty() && current < sortStack.peek()) {
				stack.push(sortStack.pop());
			}
			sortStack.push(current);
		}

		display(sortStack);
	}

	/**
	 * Display a stack
	 * 
	 * @param stack
	 */
	public void display(Deque<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		SortStack obj = new SortStack();
		obj.add();
		obj.sort();

	}

}
