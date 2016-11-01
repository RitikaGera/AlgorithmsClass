
public class MakeTree {

	public static BinaryTreeNode MT(){
		BinaryTreeNode node= new BinaryTreeNode(6);
		BinaryTreeNode node1= new BinaryTreeNode(5);
		BinaryTreeNode node2= new BinaryTreeNode(4);
		BinaryTreeNode node3= new BinaryTreeNode(3);
		BinaryTreeNode node9= new BinaryTreeNode(2);
		BinaryTreeNode node4= new BinaryTreeNode(19);
		BinaryTreeNode node5= new BinaryTreeNode(1);
		BinaryTreeNode node6= new BinaryTreeNode(18);
		BinaryTreeNode node7= new BinaryTreeNode(9);
		BinaryTreeNode node8= new BinaryTreeNode(8);
		BinaryTreeNode node10= new BinaryTreeNode(0);
		
		node.setLeft(node1);
		node.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node9);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(null);
		node3.setRight(node7);
		node9.setLeft(node10);
		node9.setRight(null);
		node5.setLeft(node6);
		node5.setRight(null);
		node7.setRight(node8);
		return node;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	
}
