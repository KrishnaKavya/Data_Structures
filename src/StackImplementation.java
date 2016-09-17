import java.util.Scanner;

/**
 * 
 * The program implements the stack data structure.
 * 
 * Stack follows first in last out Structure (LIFO).Stack is Data Structure used
 * to store the data in such a way that element inserted into the stack will be
 * removed at last.
 * 
 * The class implements the following operations of stack:
 * 1. push.
 * 2. pop.
 * 3. isEmpty 
 * 4. isFull.
 * 5. PrintStack. 
 * 
 * @author M Krishna Kavya
 * 
 */
public class StackImplementation {
	public int[] stack;
	public int size, top = -1;

	/**
	 * The constructor initializes the array.
	 * 
	 * @param size
	 */
	StackImplementation(int size) {
		stack = new int[size];
		this.size = size;
	}

	
	
	/**
	 * 
	 *  isFull Function Checks whether stack is full or not
	 *  @return 
	 *  Function returns “True”  if Stack is Full 
	 *  Function returns “False” if Stack is Not Full.
	 */
	public boolean isFull() {
		if (top == size - 1) {
			return true;
		} else {
			return false;
		}
	}

	
	
	/**
	 * isEmpty Function Checks whether stack is empty or not
	 * 
	 * @return 
	 * Function returns “True” if Stack is Empty.
	 * Function returns “False” if Stack is Non-Empty.
	 * 
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * Push Adds Element onto Stack.
	 * Push Operation carried out in following 2 steps –
	 * 1. check the stack is full.
	 * 2. if the stack is not full insert the element into the stack after incrementing the “top“.
	 *    else element is not added when the stack is full. 
	 * @param element
	 */
	public void push(int element) {
		if (isFull()) {
			System.out.println("The stack is full cannot add new Elements");
		} else {
			stack[++top] = element;
			System.out.println("Element pushed into stack");
		}
	}
	
	
	
	/**
	 * Pop operation removes the top element from the stack.
	 * Pop operation is carried out in two steps.
	 * 1. Check if the stack is empty. 
	 * 2. if stack is not empty remove the top element and decrement the top. 
	 *    else element is not poped as stack is empty. 
	 */
	public void pop() {
		if (isEmpty()) {
			System.out.println(" The stack is empty cannot remove Elements.");
		} else {
			top--;
			System.out.println("Element popped from the stack ");
		}
	}
	
	
	
	/**
	 * 
	 * The print Stack method prints the elements of the stack.
	 * i.e, the elements from zeroth location to the top. 
	 */
	public void printStack() {
		System.out.println(" The elements of the stack are:");
		System.out.println(" ");
		for (int i = 0; i <= top; i++) {
			System.out.print(" " + stack[i]);
		}
	}
	
	
	
	/**
	 * The checkInteger method is to check the user enters valid input when
	 * a value is pushed into stack.  
	 * 
	 * The parameter is taken as a string. for the given input the loop checks if all the characters in the parameter are digits.
	 * the value is calculated when the given parameter doesnot have any characters . 
	 * else it returns -1. 
	 * 
	 * @param next- The value entered by user. 
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

		System.out.println("Enter the size of stack.");
		StackImplementation obj = new StackImplementation(sc.nextInt());
		String ch = "N";

		do {
			System.out.println("Please select index to perform the operation");
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. isFull");
			System.out.println("4. isEmpty");
			System.out.println("5. printStack");
			ch = sc.next();
			switch (ch) {
			case "1":
				System.out.println("Please enter the value of element to push into the stack");
				String input=sc.next();
				/*
				 * The element to be added to the stack is assigned to input. 
				 * 1. When the input is a single length string .
				 * 		i. The character is checked to be a digit or not. 
				 * 			if the character entered is a digit value of the integer is computed and assigned to num.
				 * 			if the character entered is an alphabet , the ASCI value is computed and assigned to num. 
				 * 2. When the input has a length greater than 1.
				 *    	i. checkInteger method is called to compute the integer value.  
				 * 
				 */
				int num = (input.length() == 1 ? (Character.isDigit(input.charAt(0)) ?
						Integer.valueOf(input) : input.charAt(0)) : obj.checkInteger(input));
				if (num != -1) {
					obj.push(num);
				} else {
					System.out.println(" The value entered is not an integer.");
				}
				break;
			case "2":
				obj.pop();
				break;
			case "3":
				if (obj.isFull()) {
					System.out.println("Stack is full");
				} else {
					System.out.println("Stack is not full");
				}
				break;
			case "4":
				if (obj.isEmpty()) {
					System.out.println("stack is empty");
				} else {
					System.out.println("stack is not empty");
				}
				break;
			case "5":
				obj.printStack();
				System.out.println();
				break;
			}

			System.out.println("Please enter \"Y\" to continue and any other key to stop.");
			ch = sc.next();

		} while (ch.equals("Y") || ch.equals("y"));

		sc.close();

	}

}
