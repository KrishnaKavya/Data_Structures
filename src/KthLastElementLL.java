/**
 * 
 * @author M Krishna Kavya
 *
 *         The class calculates the k th last element in a singly Linked List.
 * 
 *         There are 2 approaches for solving this problem kthLastSLL1 and
 *         kthLastSLL2 implement the two approaches.
 */
public class KthLastElementLL {
	public Node head;
	int[] _1={1,2};
	int[] _2={3,4};
	int[] _3={3,4};
	int [][] n={_1, _2,_3};

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
		if (temp == null) {
			return;
		}
		while (temp != null) {
			System.out.print(" " + temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * 
	 * The approach 1:
	 * 
	 * 1. calculate the length of the single Linked List.
	 * 
	 * 2. the kth last element if in the position of Length -k (3rd last element
	 * is in the position of length-3).
	 * 
	 * 3. compute the index of the kth last element. (length-k)
	 * 
	 * 4. from the start to the index parse index number of nodes. The index
	 * node at the end of the node is the the kth last node
	 * 
	 * 5. return the index node.
	 * 
	 * @param k
	 * @return
	 */
	public int kthLastSLL1(int k) {
		Node temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		int index = length - k;
		Node temp1 = head;
		for (int i = 1; i <= index; i++) {
			temp1 = temp1.next;
		}
		return temp1.value;
	}

	/**
	 * The approach 2 to find the kth last element in a singly linked List.
	 * 
	 * 1. In this approach we use 2 pointers p2 and p2 for the Single linked
	 * List.
	 * 
	 * 2. p2 is set to kth element in the SLL. (for k=3. p2 is set to the third
	 * node in SLL).
	 * 
	 * 3. p2 and p1 parse one node at a step while p2's next is not equal to
	 * null. p2 and p1 are at a distance k from each other. 
	 * 
	 * 4. When p3 reaches the end of the Sll. p1 is k elements away from the end. 
	 * 
	 * 5. the value of p1 is the kth last element in a SLL.
	 * 
	 * @param k
	 * @return
	 */
	public int kthLastSll2(int k) {

		Node p1 = head;
		Node p2 = head;

		for (int i = 1; i < k; i++) {
			p2 = p2.next;
		}

		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1.value;
	}
	
	
	
	public static void main(String[] args) {

		KthLastElementLL obj = new KthLastElementLL();
		for (int i = 1; i < 11; i++) {
			obj.add(i);
		}
		obj.display();

		System.out
				.println("Approach1:to find 3rd last element in the Linked List "
						+ obj.kthLastSLL1(3));
		System.out
				.println("Approach2:to find 3rd last element in the Linked List"
						+ obj.kthLastSll2(3));
	}

}
