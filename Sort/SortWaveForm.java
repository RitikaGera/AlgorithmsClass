//Given an unsorted array of integers, sort the array into a wave like array.
// An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >=
// Approach1 : sort and then swap adjacent elements O(nlogn)
// Approach2 :  Traverse all even positioned elements of input array, and do following.
//….a) If current element is smaller than previous odd element, swap previous and current.
//….b) If current element is smaller than next odd element, swap next and current.

import java.util.Scanner;

public class SortWaveForm {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        sortWave(arr);
        printArray(arr);
    }

    public static void sortWave(int[] arr){

    	for( int i = 0; i < arr.length; i+=2 ){
    		 int l = i - 1;
    		 int r = i + 1;
    		if( l >= 0 && arr[l] > arr[i]){
    			swap(arr, i, l);
    		}
    		if( r < arr.length && arr[r] > arr[i]){
    			swap(arr, i, r);
    		}
    	}
    }

    public static void swap(int[] arr, int a, int b){
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }

    public static void printArray(int[] arr){
        for( int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}