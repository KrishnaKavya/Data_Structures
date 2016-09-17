import java.util.Scanner;

/**
 * 
 * Doubly linked list is a linked data structure that consists of a set of
 * sequentially linked records called nodes. Each node contains two fields,
 * called links, that are references to the previous and to the next node in the
 * sequence of nodes.
 * 
 * The First node in the sequence has a null in the previous link and the last
 * node has null in the last element.
 * 
 * The size of the doubly Linked List sets the maximum number of nodes that can
 * be added to the linked list.
 * 
 * The number if elements variables keeps the count of number of nodes added to
 * the Doubly linked list.
 * 
 * 
 * @author M Krishna Kavya
 * 
 */
public class DoubleLinkedList {

	public Node head;
	public int sizeOfDoubleLinkedList, numberOfElements = 0;

	DoubleLinkedList(int size) {
		this.sizeOfDoubleLinkedList = size;
	}

	/**
	 * 
	 * The Node class represents the structure of the node in a DLL. A node has
	 * a value and the previous and next pointers that points to the previous
	 * and next nodes.
	 * 
	 * 
	 * @author M Krishna Kavya
	 * 
	 */
	private class Node {

		private int value;
		private Node prev;
		private Node next;

		public Node(int value, Node prev, Node next) {
			super();
			this.value = value;
			this.prev = prev;
			this.next = next;
		}

	}

	/**
	 * Method to add an element to the DLL.
	 * 
	 * case 1: If the DLL is full a new element cannot be entered. case 2: If
	 * the DLL is empty the new entry is the fist the element/ head. case 3: The
	 * head is parsed to the last element. New Node is appended at the end of
	 * the DLL.
	 * 
	 * @param value
	 */
	public void insert(int value) {
		Node newNode = new Node(value, null, null);
		if (isFull()) {
			System.out
					.println("OverFlow/ The Linked list is full cannot insert new element.");
		} else if (isEmpty()) {
			head = newNode;
			numberOfElements++;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			temp.next = newNode;
		}
	}

	/**
	 * Method to delete the element from the double Linked List.
	 * 
	 * case 1: if the list empty , deletion is not possible.
	 * 
	 * case 2: if the element is equal to the first element(head). The next
	 * element is made as head and previous is set to null as the first element
	 * does not have a previous pointer.
	 * 
	 * case 3: if the element is equal to the last element in the DLL. The
	 * previous element's next is set to null which removes the last element
	 * from the DLL.
	 * 
	 * case 4: If the element is present in between head and tail. The before
	 * and after are derived from the temp where the value is equal to the input
	 * . The previous of after is set to the before and next of before is set to
	 * after. Which eliminates the current node.
	 * 
	 * @param num
	 */
	public boolean delete(int num) {

		Node temp = head;
		if (isEmpty()) {
			System.out
					.println("UnderFlow/ No elements in the Double Linked List to delete. ");
		} else if (head.value == num) {
			head = head.next;
			head.prev = null;
			return true;
		} else {
			while (temp != null) {
				if (temp.value == num) {
					if (temp.next == null) {
						temp.prev.next = null;
						return true;
					} else {
						Node before = temp.prev;
						Node after = temp.next;
						before.next = after;
						after.prev = before;
						return true;

					}
				}

				temp = temp.next;
			}

		}
		return false;
	}

	/**
	 * Method to display the elements in the double linked list.
	 */
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	/**
	 * Method to check if the DLL is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;

	}

	/**
	 * Method to check if the double linked list is full.
	 * 
	 * @return
	 */
	public boolean isFull() {
		if (numberOfElements == sizeOfDoubleLinkedList) {
			return true;
		}
		return false;

	}

	/**
	 * 
	 * Method to swap two elements in a Doubly linked List without swapping the
	 * values. 
	 * The two values are searched in the DLL. and the previous and next elements of each of them are kept track of.
	 * 
	 * 
	 * if the values entered are not present in the DLL. A message is displayed
	 * to return. else 
	 * 
	 * case 1: The values we are searching can be head and tail in the DLL. 
	 * The first and last elements are swapped. In this case the The previous of the 
	 * First value and the next of the second value are null. 
	 * The pointers are exchanged. 
	 * 
	 * case 2,3: The first or the second element can be head or tail. The pointers are exchanged respectively 
	 * maintaining the null position values.
	 * 
	 * case 4: The first and second values that we are searching for can be in the middle of the DLL. 
	 * The pointers of the elements are swapped to swap the
	 * position of the two Nodes.
	 * 
	 * @param val1
	 *            - value in the node
	 * @param val2
	 *            - value in the node
	 */

	public void swap(int val1, int val2) {
		Node currentOne = null, currentTwo = null, prevTwo, prevOne = null, nextTwo, nextOne = null;
		prevOne = null;
		currentOne = head;
		nextOne = head.next;
		while (currentOne != null && currentOne.value != val1) {
			prevOne = currentOne;
			currentOne = currentOne.next;
			nextOne = currentOne.next;
		}

		prevTwo = null;
		currentTwo = head;
		nextTwo = head.next;
		while (currentTwo != null && currentTwo.value != val2) {
			prevTwo = currentTwo;
			currentTwo = currentTwo.next;
			nextTwo = currentTwo.next;
		}

		if (currentOne == null || currentTwo == null) {
			System.out
					.println(" The elements entered are not present in the DLL.");
			return;
		}
		
		// The head and tail are exchanged. 
		if (prevOne == null && nextTwo == null) {

			head = currentTwo;
			head.next = nextOne;

			prevTwo.next = currentOne;
			currentOne.prev = prevOne;
			currentOne.next = null;

		}
		//The head and element between the linked List are exchanged.
		else if (prevOne == null) {
			head = currentTwo;
			head.next = nextOne;

			prevTwo.next = currentOne;
			currentOne.prev = prevTwo;
			currentOne.next = nextTwo;
			display();
		}
		// The element between the DLL and tail is swapped. 
		else if (nextTwo == null) {

			prevOne.next = currentTwo;
			currentTwo.prev = prevOne;
			currentTwo.next = nextOne;

			prevTwo.next = currentOne;
			currentOne.prev = prevOne;
			currentOne.next = null;

		}
		// The elements in the middle of DLL are swapped. 
		else {
			prevOne.next = currentTwo;
			currentTwo.prev = prevOne;
			currentTwo.next = nextOne;

			prevTwo.next = currentOne;
			currentOne.prev = prevTwo;
			currentOne.next = nextTwo;
			display();
		}
	}

	/**
	 * The checkInteger method is to check the user enters valid input when a
	 * value is pushed into stack.
	 * 
	 * The parameter is taken as a string. for the given input the loop checks
	 * if all the characters in the parameter are digits. the value is
	 * calculated when the given parameter does not have any characters . else
	 * it returns -1.
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the linkedList");
		DoubleLinkedList obj = new DoubleLinkedList(8);

		String ch = "N";
		obj.insert(1);
		obj.insert(2);
		obj.insert(6);
		obj.insert(3);
		obj.insert(7);
		obj.insert(4);
		// obj.display();
		obj.swap(1, 4);
		// obj.display();

		do {
			System.out.println("Please select index to perform the operation");
			System.out.println("1. insert");
			System.out.println("2. delete");
			System.out.println("3. isFull");
			System.out.println("4. isEmpty");
			System.out.println("5. display");
			System.out.println("6. Swap the elements in the DLL.");
			ch = sc.next();
			switch (ch) {
			case "1":
				System.out
						.println("Please enter the value of element to insert into the DLL");
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
				int num = (input.length() == 1 ? (Character.isDigit(input
						.charAt(0)) ? Integer.valueOf(input) : input.charAt(0))
						: obj.checkInteger(input));
				if (num != -1) {
					obj.insert(num);
				} else {
					System.out.println(" The value entered is not an integer.");
				}
				break;
			case "2":
				System.out.println("Please enter the value to delete");
				String input1 = sc.next();
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

				int del = (input1.length() == 1 ? (Character.isDigit(input1
						.charAt(0)) ? Integer.valueOf(input1) : input1
						.charAt(0)) : obj.checkInteger(input1));
				if (del != -1) {
					boolean success = obj.delete(del);
					if (!success) {
						System.out
								.println("The element entered is not in the DLL.");
					}
				} else {
					System.out.println(" The value entered is not an integer.");
				}
				break;
			case "3":
				if (obj.isFull()) {
					System.out.println("DLL is full");
				} else {
					System.out.println("DLL is not full");
				}
				break;
			case "4":
				if (obj.isEmpty()) {
					System.out.println("DLL is empty");
				} else {
					System.out.println("DLL is not empty");
				}
				break;
			case "5":
				obj.display();
				System.out.println();
				break;
			case "6":
				System.out.println("Enter value 1 ");
				int value1 = sc.nextInt();
				System.out.println("Enter value 2");
				int value2 = sc.nextInt();
				obj.swap(value1, value2);
			}

			System.out
					.println("Please enter \"Y\" to continue and any other key to stop.");
			ch = sc.next();

		} while (ch.equals("Y") || ch.equals("y"));

		sc.close();
	}
}
