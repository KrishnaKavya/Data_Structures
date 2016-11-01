import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author M Krishna Kavya
 * 
 *         The class implements the queue with 2 stacks. The concept of queue is
 *         First in first out. The following methods are implemented:
 * 
 *         original stack in the stack to insert an element to perform the
 *         enqueue operation. To dequeue the element we reverse the stack into a
 *         reverse stack and pop the top most element. This pops the first
 *         element inserted. The shift stack method optimizes the reverse
 *         process. Reverse operation need not be performed for every insert, to
 *         optimize the operation, we perform the shift stacks only when pop or peek operation is called. 
 * 
 *
 */
public class QueueWithTwoStacks {

	Deque<Integer> originalStack = new ArrayDeque<Integer>();
	Deque<Integer> reverseStack = new ArrayDeque<Integer>();

	/**
	 * size method returns the number of elements in both the stacks equal to
	 * the number of elements in queue.
	 * 
	 * 
	 * @return
	 */
	public int size() {
		return originalStack.size() + reverseStack.size();
	}
	
	/**
	 * Add element into a queue.
	 * To perform this operation we add element to original stack. 
	 * @param value
	 */
	public void push(int value) {
		originalStack.add(value);
	}
	/**
	 * The method handles the reversal of the stack.
	 * The reverse of the stack is only performed when the reverse stack is empty.
	 * All the elements of the original stack are added to reverse stack. 
	 * The reverse stack now follows FIFO  
	 */
	private void shiftStacks() {
		if (reverseStack.isEmpty()) {
			while (!originalStack.isEmpty()) {
				reverseStack.add(originalStack.pop());
			}
		}
	}
	
	/**
	 * to perform the pop operation, shift stacks is performed first and the top of reverseStack is eliminated. 
	 * @return
	 */
	public int pop() {
		shiftStacks();
		return reverseStack.pop();
	}
	/**
	 * to perform the peek operation, shift stacks is performed first and the top of reverseStack is eliminated.
	 * @return
	 */
	public int peek() {
		shiftStacks();
		return reverseStack.peek();
	}

	public static void main(String[] args) {

		QueueWithTwoStacks obj = new QueueWithTwoStacks();
		System.out.println("Inserting 1- 10 elements in stack");
		for (int i = 1; i < 10; i++) {
			obj.push(i);
		}
		System.out.println("Deque the first element");
		System.out.println(obj.peek());

	}

}
