public class BinaryTreeNode{
	
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	public static void main(String[] args){		
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

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
}