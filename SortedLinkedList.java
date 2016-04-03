import java.util.Scanner;
import java.util.Stack;

/**
 * A linked list is a linear data structure where each element is a separate
 * object.
 * 
 * Each element (we will call it a node) of a list is comprising of two items -
 * the data and a reference to the next node. The last node has a reference to
 * null.
 * 
 * 
 * The entry point into a linked list is called the head of the list. It should
 * be noted that head is not a separate node, but the reference to the first
 * node. If the list is empty then the head is a null reference. A linked list
 * is a dynamic data structure. The number of nodes in a list is not fixed and
 * can grow and shrink on demand. Any application which has to deal with an
 * unknown number of objects will need to use a linked list.
 * 
 * 
 * This class implements sorted singly Linked List. The elements in the linked
 * list are stored in ascending order.
 * 
 * @author M Krishna Kavya
 * 
 */
public class SortedLinkedList {
	Node head;

	/**
	 * Node class gives the structure to a linked List.
	 * 
	 */
	public class Node {
		public int value;
		public Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	/**
	 * Method to add element to the linked List. The method adds the element to
	 * the linked list in ascending order of the value of the nodes.
	 * 
	 * case 1: if linked List is empty. Head is initialized with new node.
	 * 
	 * case 2: Two indices are declared to parse through the nodes. When the
	 * element greater than the value of the node is reached . The new Node is
	 * inserted between the before and after indices. This makes sure that the
	 * elements are in ascending order. eg: LL has 1-3-4 . when add() is
	 * performed before-1 ;after- 3. new element 2 is entered between 1 and 3.
	 * 
	 * 
	 * @param element
	 *            - new Node value.
	 */
	public void add(int element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = newNode;
		} else if (head.value > newNode.value) {
			newNode.next = head;
			head = newNode;
		} else {
			Node before = head;
			Node after = head.next;
			// starting at the head node, crawl to the end of the list
			while (after != null) {
				if (after.value > newNode.value) {
					break;
				}
				before = after;
				after = after.next;
			}
			newNode.next = before.next;
			before.next = newNode;
		}
	}

	/**
	 * Method to display the elements of the linked List.
	 */
	public void display() {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}

	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Method to remove node(element) from the linked List.
	 * 
	 * case 1: To remove the element in the head node, the next element is made
	 * head.
	 * 
	 * case 2: To remove the element the element is found in the linked list
	 * using the before and after indices with the similar concept used in the
	 * insert method. The pointer of the before node is assigned to after.next
	 * node which removes the element from the linked list.
	 * 
	 * @param element
	 */
	public void remove(int element) {

		if (head.value == element) {
			head = head.next;
		} else {
			Node before = head;
			Node after = head.next;
			while (after != null) {
				if (after.value == element) {
					before.next = after.next;
					System.out.println("element removed");
					break;
				}
				before = after;
				after = after.next;
			}
		}
	}

	/**
	 * Method to check duplicate elements in the linked List.
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		Node temp = head;
		while (temp != null) {
			if (temp.value == element) {
				return true;
			}
			temp=temp.next;
		}
		return false;
	}

	/**
	 * The checkInteger method is to check the user enters valid input when a
	 * value is pushed into stack.
	 * 
	 * The parameter is taken as a string. for the given input the loop checks
	 * if all the characters in the parameter are digits. the value is
	 * calculated when the given parameter doesnot have any characters . else it
	 * returns -1.
	 * 
	 * @param next
	 *            - The value entered by user.
	 * @return- -1 when the user enter invalid input.
	 * 
	 */
	private int checkInteger(String next) {
		int result = -1;
		boolean isInteger = true;
		for (int index = 0; index < next.length(); index++) {
			isInteger = isInteger && Character.isDigit(next.charAt(index));
		}

		if (isInteger) {
			result = Integer.parseInt(next);
		}

		return result;
	}

	public void reverse() {
		if(isEmpty()){
			System.out.println(" The Linked List is Empty. ");
			return;
		}else{
		Node temp = head;
		Stack<Node> stack = new Stack<Node>();
		// Pushing the All the nodes into the stack.
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		System.out.println(" The reverse of a Linked List is: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().value+" ");
		}

		}
	}

	public static void main(String[] args) {
		SortedLinkedList obj = new SortedLinkedList();
		Scanner sc = new Scanner(System.in);
		String ch;
		do {
			System.out.println("Please select index to perform the operation");
			System.out.println("1. Add node to the Liked List");
			System.out.println("2. remove node from the linked List");
			System.out.println("3. isEmpty");
			System.out.println("5. Display Linked List");
			System.out.println("6. Display reverse of a linked List");
			ch = sc.next();
			switch (ch) {
			case "1":
				System.out
						.println("Please enter the value of element to insert into a linked list");
				String input = sc.next();
				/*
				 * The element to be added to the stack is assigned to input. 1.
				 * When the input is a single length string . i. The character
				 * is checked to be a digit or not. if the character entered is
				 * a digit value of the integer is computed and assigned to num.
				 * if the character entered is an alphabet , the ASCI value is
				 * computed and assigned to num. 2. When the input has a length
				 * greater than 1. i. checkInteger method is called to compute
				 * the integer value.
				 */
				int insertElement = (input.length() == 1 ? (Character
						.isDigit(input.charAt(0)) ? Integer.valueOf(input)
						: input.charAt(0)) : obj.checkInteger(input));
				if (insertElement != -1 && !obj.contains(insertElement)) {
					obj.add(insertElement);
				} else {
					System.out
							.println(" The value entered is not an integer./ element already exists in the list.");
				}
				break;
			case "2":
				System.out
						.println("Please enter the value of the element to remove from the linked List.");
				String del = sc.next();
				int deleteElement = (del.length() == 1 ? (Character.isDigit(del
						.charAt(0)) ? Integer.valueOf(del) : del.charAt(0))
						: obj.checkInteger(del));
				if (deleteElement != -1) {
					obj.remove(deleteElement);
				} else {
					System.out.println(" The value entered is not an integer.");
				}
				break;

			case "3":
				if (obj.isEmpty()) {
					System.out.println("Queue is empty");
				} else {
					System.out.println("Queue is not empty");
				}
				break;
			case "5":
				obj.display();
				System.out.println();
				break;
			case "6":
				obj.reverse();
				break;
			}

			System.out
					.println("Please enter \"Y\" to continue and any other key to stop.");
			ch = sc.next();

		} while (ch.equals("Y") || ch.equals("y"));
		sc.close();
	}
}