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
	
	Node find=new Node(7,null,null);

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
	 * To delete a node in the binary search tree, we start by finding the node
	 * that is to be deleted. The parsing starts at the root node if the
	 * deleteValue is less than the current node. we parse to the left subtree
	 * and when the delete Value is greater than the current node we parse to
	 * the right node. We reach the node to be deleted. Then there are 3 cases
	 * for deleting a node.
	 * 
	 * 1. if the node to be deleted is a leaf node When the node to be deleted
	 * is a leaf node. we name the node null. ( That is when the parent tries to
	 * access the child node it returns null)
	 * 
	 * 2. If the node has one child node. 2.1 If the node has left child. make
	 * the left child the current node. 2.2 If the node has a right child. Make
	 * the right child the current node.
	 * 
	 * 3. if the node has two child nodes. 3.1 We can either find highest
	 * element in the left subtree or least value in the right subtree. In this
	 * method we find the min of right subtree. 3.2 Assign the minimum value to
	 * the node to be deleted. 3.3 call the delete method giving the parameters
	 * of right subtree of the replaced node and the min value node. This
	 * function call reduces to the leaf node condition and the node is further
	 * deleted.
	 * 
	 * @param deleteValue
	 *            - value of the node you want to delete.
	 */
	public Node delete(int deleteValue, Node temp) {
		if (temp == null)
			return temp;
		else if (deleteValue < temp.value)
			temp.leftNode = delete(deleteValue, temp.leftNode);
		else if (deleteValue > temp.value)
			temp.rightNode = delete(deleteValue, temp.rightNode);
		else {
			// case1:No Child node
			if (temp.leftNode == null && temp.rightNode == null) {
				temp = null;
			}
			// case2: Only left child is null
			else if (temp.leftNode == null) {
				temp = temp.rightNode;
			}
			// case2:Only right child null
			else if (temp.rightNode == null) {
				temp = temp.leftNode;
			}
			// case 3: 2 child nodes
			else {
				Node min = findMin(temp.rightNode);
				temp.value = min.value;
				temp.rightNode = delete(min.value, temp.rightNode);

			}
		}
		return temp;
	}

	/**
	 * find min method finds the least value in
	 * 
	 * @param node
	 *            - gets the right subtree of the node to be deleted as a
	 *            parameter.
	 * @return- left most node in the right subtree i.e, the minimum value in
	 *          the right subtree.
	 */
	public Node findMin(Node node) {
		Node temp = node;
		while (temp.leftNode != null) {
			temp = temp.leftNode;
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
	
	
	/**
	 * The method implements the inorder traversal of BST
	 * 
	 * @param node
	 *            - root of the tree
	 */
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftNode);
		System.out.print(node.value + " ");
		inOrder(node.rightNode);
	}

	/**
	 * The method implements the pre order traversal of BST
	 * 
	 * @param node
	 *            - root of the tree
	 */
	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.leftNode);
		preOrder(node.rightNode);

	}

	/**
	 * The method implements the post order traversal of BST
	 * 
	 * @param node
	 *            - root of the tree
	 */
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.leftNode);
		postOrder(node.rightNode);
		System.out.print(node.value + " ");
	}
	 public Node findNodeBST(Node root, Node p){
	 
	 if(root==null) return null;
     
     if(p.value<root.value){
        return findNodeBST(root.leftNode, p);
     }else if(p.value> root.value){
         return findNodeBST(root.rightNode, p);
     }else{
         return root;
     }
	 }


	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
		obj.insert(10);
		obj.insert(7);
		obj.insert(14);
		obj.insert(11);
		obj.insert(33);
		// obj.delete(4, obj.root);
		int searchValue = 4;
		System.out.println("Search operation performed on " + searchValue);
		if (obj.search(searchValue)) {
			System.out.println(searchValue + " is found");
		} else {
			System.out.println(searchValue + "is not found");
		}

		System.out.println("Inorder traversal");
		obj.inOrder(obj.root);

		System.out.println();
		System.out.println("PreOrder Traversal");
		obj.preOrder(obj.root);

		System.out.println();
		System.out.println("Post Order Traversal");
		obj.postOrder(obj.root);
		
		System.out.println("Finding a node in the BST");
		Node res=obj.findNodeBST(obj.root, obj.find);
		System.out.println("Node Found: "+ res.value);
	}
}
