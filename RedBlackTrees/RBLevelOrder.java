import java.util.LinkedList;
import java.util.Queue;
public class RBLevelOrder {

	/*public static void main(String[] args) {
		RedBlackNode root = null;
		RedBlackNode newNode = new RedBlackNode(1);
		
		LevelOrderTraversal(root);
		
		
	}*/
	public static void LevelOrderTraversal(RedBlackNode root){
		Queue<RedBlackNode> q=new LinkedList<RedBlackNode>();
		q.offer(root);
		
		while(!q.isEmpty()){
			RedBlackNode temp=q.poll();
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