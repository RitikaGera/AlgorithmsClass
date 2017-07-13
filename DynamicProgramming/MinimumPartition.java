/*Partition a set into two subsets such that the difference of subset sums is minimum
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
*/

import java.util.Scanner;

public class MinimumPartition{

	public static void main(String[] args){
		Scanner sc = new Scanner();
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		int[] set = new int[n];
		for( int i = 0; i < n; i++){
			set[i] = sc.nextInt();
		}
		MinimumPartition obj = new MinimumPartition();
		
	}
}