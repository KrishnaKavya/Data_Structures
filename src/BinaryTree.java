/**
 * 
 * @author M Krishna Kavya
 * 
 * 
 */
public class BinaryTree {

	public Node root;

	public class Node {

		private int value;
		private Node leftNode;
		private Node rightNode;
		private int height;

		public Node(int value, Node leftNode, Node rightNode, int height) {
			super();
			this.value = value;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.height = height;
		}
	}
	public void insert(int data){
		root=insert(root, data);
	}
	public Node insert(Node node,int value){
		
		if(node==null){
			node=new Node(value, null, null,0);
		}else{
			if(node.rightNode==null)
					node.rightNode=insert(node.rightNode, value);
			else{
				node.leftNode=insert(node.leftNode, value);
			}
		}
		return node;
	}
	
	public void inOrder(Node node){
		if(node==null){
			return;
		}
		inOrder(node.leftNode);
		System.out.println(" "+node.value);
		inOrder(node.rightNode);
	}
	
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		obj.insert(0);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.inOrder(obj.root);
	}

}
