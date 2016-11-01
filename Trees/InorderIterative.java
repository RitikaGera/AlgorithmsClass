import java.util.Stack;

public class InorderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		I_inOrder(root);

	}
	
	public static void I_inOrder(BinaryTreeNode root){
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		while(true){
			
			while(root!=null){
				s.push(root);
				root=root.getLeft();
				
			}
			if(s.isEmpty()){
				break;
			}
			root=s.pop();
			System.out.println(""+root.getData());
			root=root.getRight();
			}
			s.clear();
	    }

}
