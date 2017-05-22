// Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
// Time Complexity : O(n)
// Approach : merge the two sorted arrays : O(n) or just do the next step in two separate arrays : think, it doesnt matter : still O(n + m)
// then take two pointers left and right and do the needful :O(n + m)
import java.util.Scanner;

public class ClosestPair{
	public static void main(String[] args){
		System.out.println("Enter number of elements of first array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =  new int[n];
		System.out.println("Enter elements");
		
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter number of elements of second array");
		int n2 = sc.nextInt();
		int[] arr2 =  new int[n2];
		System.out.println("Enter elements");
		
		for( int i = 0; i < n2; i++){
			arr2[i] = sc.nextInt();
		}

		System.out.println("Find element closest to x, enter x");
		int x = sc.nextInt();

		ClosestPair obj =  new ClosestPair();
		int[] pair = obj.find(arr, arr2, x);
		printArray(pair);
		
	}

	public int[] find( int[] arr1, int[] arr2, int x){
		
		int[] pair = new int[2];
		int diff = Integer.MAX_VALUE;
		int i = 0;
		for( int l = 0, r = arr2.length - 1;  l < arr1.length && r >= 0;  ){
			System.out.println("i is " + i++);
			if(Math.abs(arr1[l] + arr2[r] - x) < diff){
				diff = Math.abs(arr1[l] + arr2[r] - x);
			//	System.out.println("diff updated to "+ diff);
				pair[0] = arr1[l];
				pair[1] = arr2[r];
				//printArray(pair);
			}
			if( arr1[l] + arr2[r] < x){
				l++;
				//System.out.println("l "+ l);
			}
			else{
				r--;
				//System.out.println("r "+ r);
			}
			
		}
		return pair;


	}

	 public static void printArray(int[] arr){
        for( int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}