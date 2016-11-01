import java.util.LinkedList;
import java.util.Queue;

public class SizeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		int size=find_size_recur(root);
		System.out.println("recursively found, size is "+size);
		int size1=find_size_iter(root);
		System.out.println("iteratively found, size is "+size1);
				
		
	}
	public static int find_size_recur(BinaryTreeNode root){
		if(root==null){
			return 0;
		}
		System.out.println(""+root.getData());
		int size=1+find_size_recur(root.getLeft())+find_size_recur(root.getRight());
		return size;
	}
	
	public static int find_size_iter(BinaryTreeNode root){
		Queue<BinaryTreeNode> q= new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int size=0;
		while(!q.isEmpty()){
			BinaryTreeNode node=q.poll();
			if(node!=null){
				size++;
			}
			if(node.getLeft()!=null){
				q.offer(node.getLeft());
			}
			if(node.getRight()!=null){
				q.offer(node.getRight());
			}
			
		}
		return size;
	}

}
