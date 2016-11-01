import java.util.Scanner;

public class MakeBinaryTree {

	public BinaryTreeNode MakeBTree(){//constructs binary tree 
												//	from scratch and returns root
		
		System.out.println("Enter number of vertices");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		BinaryTreeNode temp=null;
		System.out.println("enter nodes");
		int data=sc.nextInt();
		
		temp=BSTInsertion.bstInsert(null,data);
		BinaryTreeNode root=temp;//root obtained
		for(int i=0;i<n-1;i++){
			data=sc.nextInt();
			temp=BSTInsertion.bstInsert(temp,data);
		}
		
		return root;
		
	}
}
