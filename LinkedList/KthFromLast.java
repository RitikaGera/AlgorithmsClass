package LinkedList;

import java.util.Scanner;

public class KthFromLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lnode=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			lnode.append(sc.nextInt());
		}
		System.out.print(lnode);
		int size=lnode.size();
		System.out.println(""+size);
		int k=sc.nextInt();
		int index=size-k;
		System.out.println(""+index);
		if(index>size){
			System.out.println("Such index does not exist");
		}
		else{
			int result=kthFromLast(lnode,size,index);
			System.out.println("Kth node from last is"+result);
		}
	}
	static int kthFromLast(LinkedList lnode, int size,int index){
		LinkedList.Node ptr=lnode.start;
		
		for(int i=0;i<index;i++){
			ptr=ptr.link;
		}
		
		return ptr.data;
	}

}
