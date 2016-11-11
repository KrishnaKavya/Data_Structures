/**
 * 
 * @author M Krishna Kavya
 * 
 *         The class implements the Binary tree.
 * 
 * 
 */
public class BinaryTree {

	public Node root;

	/**
	 * 
	 * @author M Krishna Kavya Class that represents a node in a tree.
	 */
	public class Node {

		private int value;
		private Node leftNode;
		private Node rightNode;
		private int children;

		public Node(int value, Node leftNode, Node rightNode, int height) {
			super();
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.children = height;
		}
	}

	/**
	 * The method to insert a node in the tree. The insert method with called
	 * with the parameters of root node and the new data.
	 * 
	 * 0 / \ 2 1 / \ 4 3 / \ 6 5
	 * 
	 * @param data
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * The method inserts a node to the binary tree. The recursive function is
	 * called, if a node is null, we have reached an null node, where we insert
	 * the new node. in the right child is null, the recursive function call is
	 * made with the the right child. In the recursive call the current node is
	 * null. Hence, new node is inserted in the right position. if right is not
	 * null, a similar method is performed and a node is inserted to the left
	 * node.
	 * 
	 * The root node is returned by the function at the end of recursion.
	 * 
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	private Node insert(Node node, int value) {

		if (node == null) {
			node = new Node(value, null, null, 0);
		} else {
			if (node.rightNode == null)
				node.rightNode = insert(node.rightNode, value);
			else {
				node.leftNode = insert(node.leftNode, value);
			}
		}
		return node;
	}

	/**
	 * In order traversal of Binary Tree.
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftNode);
		System.out.println(" " + node.value + " " + node.children);
		inOrder(node.rightNode);
	}

	/**
	 * The Method calculates the number of child nodes for every node in Binary
	 * tree.
	 * 
	 * @param node
	 */
	public void calculateChildNode(Node node) {
		if (node == null) {
			return;
		}
		calculateChildNode(node.leftNode);
		if (node.leftNode == null && node.rightNode == null) {
			node.children = 0;
		} else if (node.leftNode != null && node.rightNode != null) {
			node.children = 2;
		} else {
			node.children = 1;
		}
		calculateChildNode(node.rightNode);
	}

	/**
	 * The function get height calculates the height of the node. The definition
	 * of height of the node is given as the difference of height of left
	 * subtree and the height of right subtree should not be greater than 1.
	 * 
	 * In this implementation, the recursive call continues till the leaf node.
	 * where there are null values. and the max of (0,0) +1 gives 1 as the
	 * height of the leaf nodes. parsing upward through recursion, the height
	 * increases by 1 for every level.
	 * 
	 * @param node
	 * @return
	 */
	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			return Math
					.max(getHeight(node.leftNode), getHeight(node.rightNode)) + 1;
		}
	}

	/**
	 * The function check balance returns true when the tree is balanced and
	 * false for an unbalanced tree.
	 * 
	 * The nodes in the insert method generates and imbalanced Tree. The balace
	 * is checked by finding the difference of the left and right nodes. if the
	 * difference is greater than 1, then returns false which implies the tree
	 * is not balanced. Else, continues to parse through all the nodes in the
	 * tree and returns true if non of the nodes return false.
	 * 
	 * @param node
	 * @return
	 */
	public boolean checkBalance(Node node) {
		if (node == null) {
			return true;
		} else {
			int check = getHeight(node.leftNode) - getHeight(node.rightNode);
			if (Math.abs(check) > 1) {
				return false;
			} else {
				return checkBalance(node.leftNode)
						&& checkBalance(node.rightNode);
			}
		}
	}

	/**
	 * 
	 * The method checks if the Binary tree is a Binary search tree. 
	 * The condition if a left node is less than the node and the right 
	 * subtree is greater than the node is checked. Recursive call is 
	 * made of the left and right nodes. its repeated till the left and
	 * right child nodes are not empty. 
	 * @param node
	 * @return
	 */
	public boolean isBinarySearchTree(Node node) {
		if (node.leftNode == null && node.rightNode == null) {
			return true;
		}
		if (!(node.leftNode.value < node.value && node.rightNode.value > node.value)) {
			return false;
		}
		return isBinarySearchTree(node.leftNode)
				&& isBinarySearchTree(node.rightNode);
	}

	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		obj.insert(7);
		obj.insert(20);
		obj.insert(5);
		obj.insert(6);
		obj.insert(25);
		obj.calculateChildNode(obj.root);
		obj.inOrder(obj.root);
		System.out.println(obj.checkBalance(obj.root));
		System.out.println(obj.isBinarySearchTree(obj.root));
	}

}
