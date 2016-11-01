import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		Scanner sc=new Scanner(System.in);
		int find=sc.nextInt();
		if(search_recur(root,find))
			System.out.println("found");
		else
			System.out.println("not found");
		if(search_iter(root,find))
			System.out.println("found");
		else
			System.out.println("not found");
	}
	
	public static boolean search_recur(BinaryTreeNode root, int find){
		if(root==null){
			return false;
		}
		if(root.getData()==find){
			
			return true;
		}
		System.out.println(""+root.getData());
		return search_recur(root.getLeft(),find)|| search_recur(root.getRight(),find);
		
	}

	public static boolean search_iter(BinaryTreeNode root, int find){
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		if(root==null){
			return false;
		}
		q.offer(root);
		while(!q.isEmpty()){
			System.out.println(""+q.peek().getData());
			BinaryTreeNode temp=q.poll();
			if(temp.getData()==find){
				return true;
			}
			if(temp.getLeft()!=null){
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null){
				q.offer(temp.getRight());
			}
		}
		return false;
		
		
		
		
	}

}
