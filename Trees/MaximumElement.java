import java.util.LinkedList;
import java.util.Queue;

public class MaximumElement{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		int max=max_ele_recur(root);
		System.out.println(""+max);
		int max1=max_ele_iter(root);
		System.out.println(""+max1);

	}
	public static int max_ele_recur(BinaryTreeNode root){
		int rootData,rmax,lmax,max=Integer.MIN_VALUE;
		if(root!=null){
			rootData=root.getData();
			lmax=max_ele_recur(root.getLeft());
			rmax=max_ele_recur(root.getRight());
			if(lmax>rmax && lmax> rootData){
				max=lmax;
			}
			else if(rmax>lmax && rmax>rootData){
				max=rmax;
			}
			else{
				max=rootData;
			}
			
		}
		return max;
	}
	
	public static int max_ele_iter(BinaryTreeNode root){
		int max=Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			BinaryTreeNode node=q.poll();
			if(max<node.getData()){
				max=node.getData();
			}
			if(node.getLeft()!=null){
				q.offer(node.getLeft());
			}
			if(node.getRight()!=null){
				q.offer(node.getRight());
			}
			
			
		}
		
		return max;
	}
}
