import java.util.Scanner;

/**
 * 
 * Queue is a particular kind of abstract data type or collection in which the
 * entities in the collection are kept in order and the principal (or only)
 * operations on the collection are the addition of entities to the rear
 * terminal position and removal of entities from the front terminal position.
 * This makes queue a First-In-First-Out (FIFO) data structure.
 * 
 * @author M Krishna Kavya
 * 
 */
public class QueueImplementation {

	public int queue[];
	public int rear = -1, front = -1, size;

	/**
	 * Initialization of a queue.
	 * 
	 * @param size
	 */
	QueueImplementation(int size) {
		this.queue = new int[size];
		this.size = size;
	}

	/**
	 * Method to add element to the queue. 1. if the queue is full element
	 * cannot be entered into the queue. 2. when the first element is entered
	 * into the queue. The front and rear indices are incremented. 3. if the
	 * queue is not full and first element is already present in the queue. New
	 * element is added into the queue and rear is incremented. 4.
	 * 
	 * @param element
	 */
	public void enqueue(int element) {
		if (isFull()) {
			System.out
					.println("queue is full cannot perform insertion operation./OverFlow");
		}
		if (isFull() && front != 0) {
			resize();
			queue[++rear] = element;
		} else if (rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = element;
		} else if (rear + 1 < size) {
			queue[++rear] = element;
		}
	}

	/**
	 * Method to resize the queue. When the elements are dequeued from the front
	 * index is incremented. The resize method is called when the total number
	 * of elements in the queue is less than the size of the queue.
	 * 
	 * ex: size of queue-2. enqueue(1) , enqueue(2) is performed to add 1,2 to
	 * the queue. dequeue()- removes 1 from the queue. In this scenario the size
	 * of the queue is 2 but we cannot add new elements to the queue as the rear
	 * pointer reaches the maximum.
	 * 
	 * In such scenario resize operation is performed to optimize the
	 * performance.
	 * 
	 * A temporary array of size equal to the initialized queue is created.
	 * Elements from the front to the rear pointers is assigned. The original
	 * array copies the temporary array. front and rear indices are initialized.
	 * front becomes the first element in the array. and rear is initialized
	 * equals to the number of copies which is equal to the number of elements.
	 * 
	 * 
	 * 
	 */
	private void resize() {
		System.out.println(front + " " + rear);
		int temp[] = new int[size];
		int counter = 0;
		for (int i = front; i <= rear; i++) {
			temp[counter] = queue[i];
			counter++;
		}
		queue = temp;
		front = 0;
		rear = counter - 1;
	}

	/**
	 * Method to remove an element from queue. 1.if the queue is empty. The
	 * element cannot be deleted. 2. The queue follows first in first out
	 * method. Hence the first pointer is incremented. 3. when the elements are
	 * removed from the queue. The front pointer may exceed the rear pointer. In
	 * that case The front and rear pointers are re initialized to the default
	 * positions. is r
	 * 
	 */
	public void dequeue() {
		if (isEmpty()) {
			System.out
					.println("queue is empty cannot perform deletion operation./UnderFlow");
		} else {
			System.out.println(queue[front] + " is deleted");
			front++;
			if (front > rear) {
				reinitialize();
			}

		}

	}

	/**
	 * Method to re initialize the queue once it overflows. That is when the
	 * front index is greater then the rear.
	 */
	private void reinitialize() {
		System.out
				.println("All the elements in the queue are processed. re initialising the queue");
		front = -1;
		rear = -1;

	}

	/**
	 * Method to check if the queue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}
	/**
	 * Method to check if the queue is full
	 * @return
	 */
	public boolean isFull() {
		if (rear == size - 1) {
			return true;
		}
		return false;

	}
	/**
	 * Method to display all the elements in the queue. 
	 */
	public void displayQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
		}
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of queue.");
		String ch;
		QueueImplementation obj = new QueueImplementation(sc.nextInt());
		do {
			System.out.println("Please select index to perform the operation");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. isFull");
			System.out.println("4. isEmpty");
			System.out.println("5. Display Queue");
			ch = sc.next();
			switch (ch) {
			case "1":
				System.out
						.println("Please enter the value of element to enqueue into the queue");
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
					obj.enqueue(num);
				} else {
					System.out.println(" The value entered is not an integer.");
				}
				break;
			case "2":
				obj.dequeue();
				break;
			case "3":
				if (obj.isFull()) {
					System.out.println("Queue is full");
				} else {
					System.out.println("Queue is not full");
				}
				break;
			case "4":
				if (obj.isEmpty()) {
					System.out.println("Queue is empty");
				} else {
					System.out.println("Queue is not empty");
				}
				break;
			case "5":
				obj.displayQueue();
				System.out.println();
				break;
			}

			System.out
					.println("Please enter \"Y\" to continue and any other key to stop.");
			ch = sc.next();

		} while (ch.equals("Y") || ch.equals("y"));

		System.out.println("");

		sc.close();
	}

}
