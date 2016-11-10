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

	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		for (int i = 0; i < 10; i++)
			obj.insert(i);
		obj.calculateChildNode(obj.root);
		obj.inOrder(obj.root);
	}

}
