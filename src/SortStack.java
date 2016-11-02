import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author M Krishna Kavya
 *
 */
public class SortStack {

	Deque<Integer> stack = new ArrayDeque<Integer>();
	Deque<Integer> sortStack = new ArrayDeque<Integer>();

	public void add() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
	}

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
