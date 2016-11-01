package LinkedList;

import java.util.Scanner;

public class RemoveDuplicates_NoBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lnode=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			lnode.append(sc.nextInt());
		}
		System.out.print(lnode);
		System.out.println();
		removeDuplicates(lnode.start);
		System.out.print(lnode);
	}
	public static void removeDuplicates(LinkedList.Node start_node){
		LinkedList.Node current=start_node;
		LinkedList.Node runner;
		while(current!=null){
			 runner=current;
			 while(runner.link!=null){
				 if(current.getData()==runner.link.getData()){
					 runner.link=runner.link.link;
				 }
				 else{
					 runner=runner.link;
				 }
			 }
			
			 current=current.link;
			 
		}
	}

}
