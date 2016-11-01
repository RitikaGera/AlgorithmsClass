import java.util.LinkedList;
import java.util.Queue;
public class RBLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeRBTree rbtree=new makeRBTree();
		RBNode root=rbtree.makeRBTree();
		RBLevelOrderTraversal(root);
	}
	public static void RBLevelOrderTraversal(RBNode root){
		Queue<RBNode> q=new LinkedList<RBNode>();
		q.offer(root);
		
		while(!q.isEmpty()){
				RBNode temp=q.poll();
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