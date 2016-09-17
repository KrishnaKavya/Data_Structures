import java.util.Queue;
import java.util.Scanner;

/**
 * The priority queue is a data structure with and additional feature to a
 * queue. The element with the highest priority is served first.If two elements
 * have the same priority . They are served according to the order in the queue.
 * 
 * This class implements the priority queue using Binary Heap.
 * 
 * Binary Heap is heap data Structure. It is a binary tree with additional
 * constraints. we represent Binary heap with array.
 * 
 * It satisfies the complete binary tree property and Heap property(min and max
 * heap) This program implements the Binary heap data structure satisfying the
 * property of a Min Heap.
 * 
 * Complete binary tree:A binary tree T is complete if each node is either a
 * leaf or possesses exactly two child nodes.
 * 
 * 
 * Note: The binary heap is represented in the form of an array. 0th location is
 * unused during the insertion of new element. for every location i in the array
 * (int) i/2 represents the parent node. and for a given node i i. 2*i-
 * represents the left Node and ii. 2*i+1 - represents the right node.
 * 
 * Operations performed are : 1. insertion. 2. deletion.
 * 
 * @author M Krishna Kavya
 * 
 */
public class PriorityQueue {
	public int priorityQueue[];
	public int lastIndex = 0;
	public int size;

	PriorityQueue(int size) {
		priorityQueue = new int[size];
		this.size=size;
	}

	/**
	 * Method to add an element to the priority Queue. 1.Resize method is called
	 * when the heap is full. 2.else the element is inserted in the last index
	 * and percolate up operation is performed to satisfy the heap property.
	 * 
	 * @param element
	 *            -integer value.
	 * 
	 */
	public void insert(int element) {
		if (priorityQueue.length == lastIndex) {
			resize();
		} else {
			priorityQueue[++lastIndex] = element;
			System.out.println("new element inserted "
					+ priorityQueue[lastIndex]);
			percolateUp(lastIndex);
		}

	}

	public void resize() {

		
		int newqueue[]=new int[size];
		
		for (int i = 1; i <=lastIndex; i++) {
		newqueue[i]=priorityQueue[i];
		}
		this.priorityQueue=new int[4*size];
		
		for (int i = 1; i <=lastIndex; i++) {
			priorityQueue[i]=priorityQueue[i];
		}
		
		
	}

	/**
	 * 
	 * Method to satisfy the heap property.
	 * 
	 * @param i - the last index of the priority Queue which has the new
	 *            inserted element.
	 */
	public void percolateUp(int i) {

		// assign the new element in the zeroth location.
		priorityQueue[0] = priorityQueue[i];

		/*
		 * while the parent element is greater than the new element that is
		 * inserted. percolate up. In a Min heap the element with least value
		 * has high priority.
		 * 
		 * while the parent has greater value than the child. The parent element
		 * is inserted in the place of child.
		 * 
		 * The loop is repeated till the location where the parent is less than
		 * its child is found.
		 */
		while (priorityQueue[i / 2] > priorityQueue[0]) {
			// parent node is assigned to child node.
			priorityQueue[i] = priorityQueue[i / 2];
			i = i / 2;
		}

		priorityQueue[i] = priorityQueue[0];
	}

	/**
	 * 
	 * 
	 * The deleteMin method returns the element with minimum value and maximum
	 * priority. The element in the last Index replaces the root element. The
	 * last Index of an element is reduced by one. The heap property is violated
	 * when the element is replaced. percolateUp method is called to retain the
	 * binary heap property.
	 * 
	 * @return- element with minimum value and maximum priority.
	 */
	public int deleteMin() {
		int root = 1;
		int minimum = priorityQueue[root];
		priorityQueue[root] = priorityQueue[lastIndex];
		lastIndex = lastIndex - 1;
		percolateDown(root);
		return minimum;
	}

	/**
	 * 
	 * 
	 * Method to maintain the heap property. Steps: 1. store the new root. 2.
	 * while the current node does not have child nodes. case1: If the current
	 * node has one child node and the value of child is less than the new node
	 * move the new root down. case2: If the current node has two child nodes.
	 * minimum is fetched and if the minimum value of the child nodes is less
	 * then current node move the new root minimum of the child nodes. 3. The
	 * loop is terminated(break;) when the child nodes are less than the current
	 * node. 4. The new root is assigned at the index that satisfies the heap
	 * property.
	 * 
	 * @param i
	 */
	public void percolateDown(int i) {
		int newRoot = priorityQueue[i];
		while (2 * i <= lastIndex) {
			// One child.
			if (2 * i == lastIndex) {
				if (newRoot > priorityQueue[lastIndex]) {
					priorityQueue[i] = priorityQueue[lastIndex];
					i = lastIndex;
				} else {
					break;
				}
			}
			// 2 child nodes.
			else {
				int minIndex = minimum(priorityQueue, 2 * i, (2 * i) + 1);
				if (newRoot > priorityQueue[minIndex]) {
					priorityQueue[i] = priorityQueue[minIndex];
					i = minIndex;
				} else {
					break;
				}

			}
		}

		priorityQueue[i] = newRoot;
	}

	/**
	 * 
	 * The method returns the index of the minimum element in an array.
	 * 
	 * @param priorityQueue2
	 * @param i
	 * @param j
	 * @return
	 */
	private int minimum(int[] priorityQueue2, int i, int j) {
		if (priorityQueue2[i] <= priorityQueue2[j]) {
			return i;
		} else {
			return j;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of the priorityQueue. ");
		int size = sc.nextInt();
		PriorityQueue pq = new PriorityQueue(size + 1);

		/*
		 * Insertion of elements into the priority queue.
		 * 
		 * Example: if size=5.
		 * 
		 * elements are inserted in the order 5 4 3 2 1.
		 */

		for (int i = size; i > 0; i--) {
			pq.insert(i);
		}

		System.out.println("The elements of the PriorityQueue(Least value highest Priority) are: ");
		for (int i = 1; i <= pq.lastIndex; i++) {
			System.out.print(pq.priorityQueue[i] + " ");
		}

		System.out.println("Delete Min operation: ");
		int min = pq.deleteMin();
		System.out.println(" element with highest priority " + min);
		System.out.println(" The elements in the priority Queue after deletion");
		pq.resize();
		for (int i = 1; i <= pq.lastIndex; i++) {
			System.out.print(pq.priorityQueue[i] + " ");
		}
		
		
		sc.close();
	}

}
