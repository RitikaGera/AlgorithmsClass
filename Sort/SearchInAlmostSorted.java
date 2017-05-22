// Search in an almost sorted array
//Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or 
//arr[i-1]

import java.util.Scanner;

public class SearchInAlmostSorted{
		public static void main(String[] args){
		System.out.println("Enter number of elements");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =  new int[n];
		System.out.println("Enter elements");
		
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("element to be searched");
		int x = sc.nextInt();
		SearchInAlmostSorted obj = new SearchInAlmostSorted();
		int index = obj.search(arr, 0 , arr.length - 1, x);
		System.out.println("found at index "+ index);
	}

	public int search(int[] arr, int l, int r, int x){
		if(l <= r){
			int mid =  l + ( r - l)/2; // to avoid overflow
			if(arr[mid] == x)
				return mid;
			if( mid > l  && arr[mid - 1] == x){
				return (mid - 1);
			}
			if( mid < r && arr[mid + 1] == x){
				return (mid+1);
			}
			if(arr[mid] > x){
				return search(arr, l, mid - 2, x);
			}
			else{
				return search(arr, mid + 2, r, x);
			}
		}
		return -1; //not found
	}
}