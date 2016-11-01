
public class PostOrderRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		R_postOrder(root);

	}
	public static void R_postOrder(BinaryTreeNode root){
		if(root!=null){
			R_postOrder(root.getLeft());
			R_postOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

}
