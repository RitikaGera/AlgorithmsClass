import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InsertAnywhereInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeTree mt=new MakeTree();
		BinaryTreeNode root=mt.MT();
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		//my_insert(root,data);
		//System.out.println("By MyInsert");
		//LevelOrder.LevelOrderTraversal(root);
		//System.out.println("By LevelOrder");
		//levelOrder(root,data);
		//LevelOrder.LevelOrderTraversal(root);
		System.out.println("Recursively");
		insert_recur(root,data);
		LevelOrder.LevelOrderTraversal(root);
		
	}
	
	public static BinaryTreeNode my_insert(BinaryTreeNode root, int data){
		BinaryTreeNode newNode=new BinaryTreeNode(data);
		BinaryTreeNode temp=root;
		if(temp==null){
			root=newNode;
			return root;
		}
		while(temp.getLeft()!=null){
			temp=temp.getLeft();
		}
		temp.setLeft(newNode);
		return root;
	}
	//give better output in case of an already levelled tree 
	public static BinaryTreeNode levelOrder(BinaryTreeNode root,int data){
		BinaryTreeNode newNode=new BinaryTreeNode(data);
		BinaryTreeNode temp=root;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(temp);
		while(!q.isEmpty()){
		    temp=q.poll();
			System.out.println(""+temp.getData());
			if(temp!=null){
				{
					if(temp.getLeft()!=null){
						System.out.println("left entered of "+temp.getData()+"it is "+temp.getLeft().getData());
						q.offer(temp.getLeft());
					}
					else if(temp.getLeft()==null){
						temp.setLeft(newNode);
						System.out.println("left "+temp.getData()+" "+temp.getLeft().getData());
						return root;
					}
				}
				{
					if(temp.getRight()!=null){
						System.out.println("right entered of "+temp.getData());
						q.offer(temp.getRight());
					}
					else if(temp.getRight()==null){
						temp.setRight(newNode);
						System.out.println("right "+temp.getData()+" "+temp.getRight().getData());
						return root;
					}
				}
			}
		}
		return root;
	}
	
	public static BinaryTreeNode insert_recur(BinaryTreeNode root, int data){
		BinaryTreeNode newNode=new BinaryTreeNode(data);
		
		if(root==null){
			root=newNode;
			return root;
		}
		if(root.getData()>=data){
			if(root.getLeft()==null){
				root.setLeft(newNode);	
				//break;
			}
			else{
				insert_recur(root.getLeft(),data);
			}
		}
		else{
			if(root.getRight()==null){
				root.setRight(newNode);
				//break;
			}
			else{
				insert_recur(root.getRight(),data);
			}
		}
		
		return root;
	}

}
