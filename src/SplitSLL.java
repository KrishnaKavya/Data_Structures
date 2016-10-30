/**
 * 
 * @author M Krishna Kavya
 *
 */
public class SplitSLL {
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
	public void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(" " + temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * 
	 * The split function is to sort the LL based on one value. the values less
	 * than or equal to k are to the left and greater than k are to right.
	 * 
	 * 1. consider a head to temp.initialise before after and itself pointers.
	 * 
	 * 2. while the linked list is not empty. since pointer will be updated
	 * later save the next node in next.
	 * 
	 * 3. To split the linked list before LL has the list of elements less than
	 * k. after contains all the elements greater than k. and itself has a LL
	 * when the value is equal to k.
	 * 
	 * 4.we add elements in the front of the before and after list.
	 * 
	 * @param k
	 * @return
	 */
	public Node split(int k) {
		Node temp = head;
		Node before = null, after = null, itself = null;
		while (temp != null) {
			Node next = temp.next;
			/*
			 * node adds in front of the before list and before is updated to
			 * the end. say 3 should be added to before list and before is null.
			 * 3 is in temp and 3.next has before and before is updated to node
			 * 3.
			 * 
			 * when a new element is added to the before list( say 4), list is
			 * updated as 4. next= 3. and 4 will act as a current before.
			 * 
			 * Similar process is followed for after list.
			 */

			if (temp.value < k) {
				temp.next = before;
				before = temp;
			} else if (temp.value > k) {
				temp.next = after;
				after = temp;
			} else if (temp.value == k) {
				itself = temp;
			}
			temp = next;
		}

		/*
		 * merge code. if before and itself are null then return after. if after
		 * is null then returns null else returns after.
		 */
		if (before == null && itself == null) {
			return after;
		}

		/*
		 * if before is equal to null and itself has a value. after is appended
		 * to itself and returned. if after is null. only itself is returned
		 * else whole list is returned.
		 */
		if (before == null && itself != null) {
			itself.next = after;
			return itself;
		}
		/*
		 * if before is not null then result variable is initialized. before is
		 * added to result, itself and after are appended and result is
		 * returned.
		 */
		Node result = before;
		while (before.next != null) {
			before = before.next;
		}
		if (itself == null) {
			before.next = after;
		} else {
			before.next = itself;
			itself.next = after;
		}
		return result;
	}

	public static void main(String[] args) {

		SplitSLL obj = new SplitSLL();
		obj.add(1);
		obj.add(12);
		obj.add(13);
		obj.add(4);
		obj.add(15);
		obj.add(5);
		System.out.println("Elements of the Linked List before insertion");
		obj.display(obj.head);
		Node result = obj.split(5);
		System.out
				.println("sorting the Linked List into parts based on th value 5");
		obj.display(result);

	}

}
