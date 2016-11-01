import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @author M Krishna Kavya
 * 
 * 
 *
 */
public class PalindromeLL {

	public Node head;

	private class Node {

		public Node(char value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}

		private char value;
		private Node next;
	}

	/**
	 * Method to add element to a LinkedList.(Refer SortedLinkedList.java- add
	 * method for detailed comments. ) the add method forms the linked list in
	 * the entered order. Does not sort the elements.
	 * 
	 * @param i
	 *            - value to insert.
	 */
	public void add(char i) {
		Node newNode = new Node(i, null);
		Node temp = head;
		if (head == null) {
			head = newNode;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	/**
	 * Method to display the elements of the linked List.
	 */
	public void display() {
		Node temp = head;
		if (temp == null) {
			return;
		}
		while (temp != null) {
			System.out.print(" " + temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean palindrome() {
		StringBuilder originalString = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<Character>();
		Node temp = head;
		while (temp != null) {
			char c = temp.value;
			originalString.append(c);
			stack.push(c);
			temp = temp.next;
		}
		StringBuilder reverseString = new StringBuilder();
		while (!stack.isEmpty()) {
			char c = stack.pop();
			reverseString.append(c);
		}
		if (originalString.toString().equals(reverseString.toString())) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		PalindromeLL obj = new PalindromeLL();

		obj.add('a');
		obj.add('b');
		obj.add('a');
		obj.add('a');
		obj.display();
		System.out.println(obj.palindrome());

	}

}
