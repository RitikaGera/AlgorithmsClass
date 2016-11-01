package LinkedList;

import java.util.Scanner;

public class LinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			ll.append(sc.nextInt());
		}
		System.out.print(ll);
	}

}
