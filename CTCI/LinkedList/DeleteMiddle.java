package LinkedList;

import java.util.Scanner;

public class DeleteMiddle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			ll.append(sc.nextInt());
		}
		//System.out.print(lnode);
		LinkedList.Node lnode=ll.start;
		
		
		int dataToDelete=sc.nextInt();
		deleteMid(lnode,dataToDelete);
		while(lnode!=null){
			System.out.println(lnode.data);
			lnode=lnode.link;
		}
			
	}
	public static void deleteMid(LinkedList.Node lnode,int dataToDelete){
		LinkedList.Node prev=null,curr=null;
		curr=lnode;
		int i=0;
		while(curr!=null && curr.data!=dataToDelete){
			System.out.println(""+i++ +" ");
			prev=curr;
			curr=curr.link;			
		}
		prev.link=curr.link;
		curr=prev.link;
	
	}

}
