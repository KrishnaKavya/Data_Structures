import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithTwoStacks {

	Deque<Integer> originalStack = new ArrayDeque<Integer>();
	Deque<Integer> reverseStack = new ArrayDeque<Integer>();

	public int size() {
		return originalStack.size() + reverseStack.size();
	}

	public void push(int value) {
		originalStack.add(value);
	}

	private void shiftStacks() {
		if (reverseStack.isEmpty()) {
			while (!originalStack.isEmpty()) {
				reverseStack.add(originalStack.pop());
			}
		}
	}

	public int pop() {
		shiftStacks();
		return reverseStack.pop();
	}

	public int peek() {
		shiftStacks();
		return reverseStack.peek();
	}

	public static void main(String[] args) {

		QueueWithTwoStacks obj = new QueueWithTwoStacks();
		
		for(int i=1;i<10;i++){
			obj.push(i);
		}
		
		System.out.println(obj.peek());
		

	}

}
