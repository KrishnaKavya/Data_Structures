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

	public class Node {
		public int value;
		public Node leftNode;
		public Node rightNode;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.leftNode = left;
			this.rightNode = right;
		}
	}

	/**
	 * The function inserts the node to the Binary Search Tree. To perform the
	 * insertion operation in the BST. The following steps are followed
	 * 
	 * 1. If the tress is empty, the new Node is assigned as the root node. 2.
	 * else, The tree is parsed based on the criteria starting with the root
	 * node. 2.1 If the value of the new Node is less than the current node, we
	 * parse to the left node. 2.2 If the value of the new Node is greater than
	 * the current node, we parse to the right node. 3. The above step is
	 * performed till we reach the node which has a null leaf node. And the new
	 * Node is inserted in the position.
	 * 
	 * @param newNode
	 *            - new Node to the tree.
	 */
	public void insert(int val) {
		Node newNode = new Node(val, null, null); // creating a new node in the
													// tree
		Node temp = root;
		if (root == null) { // when tree is empty the new node is assigned to
							// the root node.
			root = newNode;
		} else {
			while (temp != null) { // while the node is not null the tree is
									// parsed based on the conditions(mentioned
									// in function comments)
				if (newNode.value < temp.value) {
					if (temp.leftNode == null) {
						temp.leftNode = newNode;
						System.out.println("left node inserted");
						break;
					} else {
						temp = temp.leftNode;
					}
				} else {
					if (temp.rightNode == null) {
						System.out.println("right node inserted");
						temp.rightNode = newNode;
						break;
					} else {
						temp = temp.rightNode;
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param deleteValue- value of the node you want to delete. 
	 */
	public void delete(int deleteValue) {

	}
	
	public Node findMin(Node node){
		Node temp=node;
		while(temp.leftNode!=null){
			temp=temp.leftNode;
		}
		return temp;
	}

	/**
	 * 
	 * The tree is parsed from root. The value of the current node is compared
	 * to the search value. if the value matches the current node the value is
	 * found and the loop breaks. else the search value is compared to the
	 * current node in the tree. if the value is less than the node value. The
	 * tree is parsed left. else the tree is parsed right. The function returns
	 * false if the value is not found.
	 * 
	 * @param value
	 *            - value of the tree that is searched.
	 * @return true if the value is found
	 */
	public boolean search(int searchValue) {
		boolean result = false;
		Node temp = root;
		while (temp != null) {
			if (temp.value == searchValue) {
				result = true;
				break;
			} else {
				if (searchValue < temp.value) {
					temp = temp.leftNode;
				} else {
					temp = temp.rightNode;
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
		obj.insert(10);
		obj.insert(7);
		obj.insert(11);
		obj.insert(4);
		obj.insert(33);
		int searchValue=11;
		System.out.println("Search operation performed on "+searchValue);
		if(obj.search(searchValue)){
			System.out.println(searchValue+" is found");
		}else{
			System.out.println(searchValue+"is not found");
		}
	}
}
