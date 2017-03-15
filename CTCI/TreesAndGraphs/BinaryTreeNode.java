import java.util.Scanner;

public class BinaryTreeNode{
	
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	public static void main(String[] args){		
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		BinaryTreeNode btn = new BinaryTreeNode(data);

	}

	public BinaryTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setLeft(BinaryTreeNode left){
		this.left = left;
	}
	public void setRight(BinaryTreeNode right){
		this.right = right;
	}
	public void setParent(BinaryTreeNode parent){
		this.parent = parent;
	}
	public void setData(int data){
		this.data = data;
	}
	public BinaryTreeNode getLeft(){
		return this.left;
	}
	public BinaryTreeNode getRight(){
		return this.right;
	}
	public BinaryTreeNode getParent(){
		return this.parent;
	}
	public int getData(){
		return this.data;
	}
}