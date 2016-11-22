/**
 * 
 * @author M Krishna Kavya
 *
 *         The class implements a problem to convert an ascending ordered array
 *         to a Binary Search Tree with minimal Height.
 * 
 *         The technique of Binary Search is applied in creating the Binary
 *         Search tree. The root is the middle element of the array and recursed
 *         for the left and right nodes by recursive call to the left sublist
 *         and right sublist from the middle element.
 * 		   
 */
public class ArrayToBST {
	public Node root;

	/**
	 * 
	 * @author M Krishna Kavya
	 * 
	 *         Class that represents a node in a tree.
	 */
	public class Node {

		private int value;
		private Node leftNode;
		private Node rightNode;

		public Node(int value, Node leftNode, Node rightNode) {
			super();
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
		
	/**
	 *  Method to implement array to BST conversion.
	 * @param array
	 * @return
	 */
	public Node toBST(int[] array) {

		return toBST(array, 0, array.length - 1);

	}
	
	/**
	 * 
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	private Node toBST(int[] array, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		Node tree = new Node(array[mid], null, null);
		tree.leftNode = toBST(array, low, mid - 1);
		tree.rightNode = toBST(array, mid + 1, high);
		return tree;

	}

	/**
	 * The method implements the in order traversal of the tree.
	 * 
	 * 
	 * left child node - parent node - right child node.
	 * 
	 * @param node
	 */
	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.leftNode);
		System.out.print(" " + node.value);
		inorder(node.rightNode);
	}

	public static void main(String[] args) {
		ArrayToBST obj = new ArrayToBST();
		int[] array = { 2, 3, 4, 5, 6, 7, 8 };
		Node result = obj.toBST(array);
		obj.inorder(result);

	}

}
