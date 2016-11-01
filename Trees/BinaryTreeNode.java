
public class BinaryTreeNode {
	
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
		
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data=data;
	}
	
	public BinaryTreeNode getLeft(){
		
		return this.left;
	}
	
	public void setLeft(BinaryTreeNode left){
		this.left=left;
	}
	
	public BinaryTreeNode getRight(){
		return this.right;
	}
	
	public void setRight(BinaryTreeNode right){
		this.right=right;
	}
}
