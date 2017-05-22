// find kth smallest or largest element in worst case Linear time  
// Approach 1 : partition method of quick sort : amortized cost O(n), worst case O(n2)
// Approach2 : Median of medians method : Worst case : O(n)

import java.util.Scanner;

public class KthSmallestElement{
	 public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k");
        int k = sc.nextInt();
        
}