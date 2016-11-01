
public class PreOrderRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		R_preOrder(root);

	}
	public static void R_preOrder(BinaryTreeNode root){
		if(root!=null){
			System.out.print(" "+root.getData());
			R_preOrder(root.getLeft());
			R_preOrder(root.getRight());
		}
		
		
	}
	
	
}
