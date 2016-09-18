/**
 * 
 * @author M Krishna Kavya
 * 
 *         Binary search tree is a sorted binary tree.BST keeps the keys in
 *         sorted order. A Binary Search Tree should satisfy the following
 *         conditions 1. The tree should be a binary tree i.e, A tree whose
 *         elements have only 2 children. 2. The left subtree of a node should
 *         contain only nodes less than the key. 3. The right subtree of a node
 *         should contain only nodes greater than the key.
 * 
 *         Average Worst case Space Θ(n) O(n) Search Θ(log n) O(n) Insert Θ(log
 *         n) O(n) Delete Θ(log n) O(n)
 */

public class BinarySearchTree {
	public Node root;

	private class Node {
		public int value;
		public Node leftNode;
		public Node rightNode;
	}

	
	/**
	 * 
	 * @param newNode
	 */
	public void insert(Node newNode) {

	}

	
	/**
	 * 
	 */
	public void display() {

	}

	
	/**
	 * 
	 * @param node
	 */
	public void delete(Node node) {

	}

	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean search(Node node) {

		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree obj=new BinarySearchTree();
	}

}
