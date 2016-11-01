import java.util.Stack;

public class PreOrderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		I_preOrder(root);
	}
	
	public static void I_preOrder(BinaryTreeNode root){
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			BinaryTreeNode node=s.pop();
			System.out.println(""+node.getData());
			if(node.getRight()!=null){
				s.push(node.getRight());
			}
			if(node.getLeft()!=null){
				s.push(node.getLeft());
			}
			
		}
	}
	
	

}
