
public class InorderRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		R_InOrder(root);

	}
	public static void R_InOrder(BinaryTreeNode root){
		if(root!=null){
			R_InOrder(root.getLeft());
			System.out.println(root.getData());
			R_InOrder(root.getRight());
			
		}
	}
}

