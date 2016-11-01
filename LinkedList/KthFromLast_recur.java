package LinkedList;

import java.util.Scanner;

public class KthFromLast_recur {

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
		int k=sc.nextInt();
			
		int result=kthFromLast(lnode,k);
		
	}
	static int kthFromLast(LinkedList.Node lnode, int index){
		LinkedList.Node ptr=lnode;
		if(lnode==null){
			//System.out.println("List is empty");
			return -1;
		}
		int result=kthFromLast(ptr.link,index)+1;
		System.out.print(" "+ptr.data);
		return result;
	}

}
