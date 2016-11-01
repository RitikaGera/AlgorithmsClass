package LinkedList;

import java.util.HashSet;
import java.util.Scanner;
//O(n) time, O(n) space : HashSet
public class RemoveDuplicates{
	static void removeDuplicates(LinkedList.Node start_node){
		HashSet<Integer> hs=new HashSet<Integer>();
		LinkedList.Node previous=null;
		while(start_node!=null){
			if(hs.contains(start_node.data)){
				previous.link=start_node.link;
				
			}
			else{
				hs.add(start_node.data);
				previous=start_node;
			}
			start_node=start_node.link;
		}
		
		}
		
	
	public static void main(String args[]){
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
}
