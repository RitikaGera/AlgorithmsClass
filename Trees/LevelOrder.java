import java.util.*;
public class LevelOrder {

	public static void main(String[] args) {
		// static tree defined in maketree class
	    MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		
		//custom tree every time
		MakeBinaryTree mt1=new MakeBinaryTree();
		BinaryTreeNode root1=mt1.MakeBTree();
		
		LevelOrderTraversal(root);
		LevelOrderTraversal(root1);
		
	}
	public static void LevelOrderTraversal(BinaryTreeNode root){
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		
		while(!q.isEmpty()){
			BinaryTreeNode temp=q.poll();
			System.out.println(""+temp.getData());
			if(temp.getLeft()!=null){
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null){
				q.offer(temp.getRight());
			}
		}
		
		
	}

}