import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author M Krishna Kavya
 * 
 * 
 *
 */
public class RemoveDuplicateLL {
	public Node head;

	/**
	 * 
	 * @author M Krishna Kavya
	 * 
	 *         Class Node represents the structure of Linked List.
	 */
	private class Node {

		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}

		private int value;
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
	public void add(int i) {
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
		while (temp != null) {
			System.out.print(" " + temp.value);
			temp = temp.next;
		}
	}

	/**
	 * 
	 * The method remove duplicate removes the duplicate elements from a linked
	 * List.
	 * 
	 * 1. Initialize a set of Integers.
	 * 
	 * 2. while the linked list is not empty, parse through the array.
	 * 
	 * 3. if the set contains the the character, remove the node (by taking
	 * updating the pointer to the next node.)
	 * 
	 * 4. if the set does not contain, add it in the set and increment the
	 * before.
	 * 
	 * @param head
	 * @return
	 */
	public void removeDuplicate() {
		Set<Integer> unique = new HashSet<Integer>();
		Node temp = head;
		Node before = null;
		if (head == null) {
			System.out.println("linked list is empty");
		}
		while (temp != null) {
			if (unique.contains(temp.value)) {
				before.next = temp.next;
			} else {
				unique.add(temp.value);
				before = temp;
			}
			temp = temp.next;
		}
	}

	/**
	 * 
	 * The remove duplicate without buffer or set.
	 * 
	 * Here, we need the runner technique. we maintain two pointers for parsing
	 * the Node.
	 * 
	 * parse through the linked List, for every node create a pointer runner.
	 * parse through the rest of of the list from runner to the end. if the
	 * current value is equal to the runner values. remove the node.
	 * 
	 * repeat the process for all nodes in the liked List.
	 * 
	 * 
	 */
	public void removeDuplicateWithoutSet() {
		Node current = head;
		if (head == null) {
			System.out.println("Linked List is Empty");
		} else {
			while (current != null) {
				Node runner = current;
				while (runner.next != null) {
					if (runner.next.value == current.value) {
						runner.next = runner.next.next;
					} else {
						runner = runner.next;
					}
				}
				current = current.next;
			}
		}

	}

	public static void main(String[] args) {
		RemoveDuplicateLL obj = new RemoveDuplicateLL();

		System.out.println("Linked List:");
		obj.add(1);
		obj.add(2);
		obj.add(1);
		obj.add(0);
		obj.add(1);
		obj.add(1);
		obj.display();
		System.out.println();
		System.out.println("Linked List after removng duplicates:");
		obj.removeDuplicate();
		obj.display();
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(0);
		obj.add(0);
		obj.removeDuplicateWithoutSet();
		System.out.println();
		System.out
				.println("Linked List after removing duplicate using runner technique");
		obj.display();

	}
}
