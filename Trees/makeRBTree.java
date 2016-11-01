import java.util.Scanner;

public class makeRBTree {

	public RBNode makeRBTree(){
		System.out.println("Enter number of vertices");
		Scanner sc=new Scanner(System.in);
		int i = 0;
		int n=sc.nextInt();
		
		System.out.println("enter nodes");
		int data=sc.nextInt();
		
				
	    RBNode root=RBInsertion.RBbstInsert(null,data);
	   
	   
		for(int k=0;k<n-1;k++){
			data=sc.nextInt();
			RBInsertion.RBbstInsert(root,data).getData();
			
			
		}
		
		return root;
		
	}

	
	public static void main(String[] args) {
		makeRBTree rbtree = new makeRBTree();
		RBNode root=rbtree.makeRBTree();
	    RBLevelOrder.RBLevelOrderTraversal(root);
		
		
	}

}
