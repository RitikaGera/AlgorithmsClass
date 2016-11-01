
public class DeleteBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		DeleteTree(root);
	}
	public static void DeleteTree(BinaryTreeNode root){
		System.out.println(""+root.getData());
		root=null;
		System.out.println("tree deleted");
		//System.out.println(""+root.getData());
	}

}
