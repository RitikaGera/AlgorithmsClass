//Partition Problem : determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
// Approach : If sum is odd, no solution is possible since sum = s1 + s1  = 2 * s1
// So, every element can be in any of the two sets : Exponential : Naive
// Recursive : We break the problem into two cases, one containing the last element and updating required sum = required sum - last element and updating n = n-1 or
// 				excluding the last element and updating n =  n-1 
//				we update n = n-1 in both cases since an element can only be in one of the two subsets
// Dynamic Programming : Every recursive problem can be solved using dynamic programming with possibly decreasing time complexity
// 
import java.util.Scanner;

public class Partition{

	public static void main(String[] args){
		Scanner sc = new Scanner();
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		int[] set = new int[n];
		for( int i = 0; i < n; i++){
			set[i] = sc.nextInt();
		}
		Partition obj = new Partition();
		obj.find(set);
	}
}