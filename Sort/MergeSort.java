//Merge Sort
import java.util.Scanner;

public class MergeSort{
	public static void main(String[] args){
		System.out.println("Enter number of elements");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =  new int[n];
		System.out.println("Enter elements");
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		MergeSort obj = new MergeSort();
		obj.mergeSort(arr, 0, arr.length - 1);
		printArray(arr);

	}

	public static void printArray(int[] arr){
		for( int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public void mergeSort(int[] arr, int l, int r){
		
		if( r > l){
			int mid = ( l + r)/2;
			mergeSort(arr,l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public void merge(int[] arr, int l, int m, int r){
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for( int i = 0; i < n1; i ++){
			left[i] = arr[ l + i];
		}
		for( int i = 0; i < n2; i++){
			right[i] = arr[ m + i + 1];
		}
		int i = 0, j = 0; // starting index for left and right arrays
		int k = l; // starting index for main array
		while( i < n1 && j < n2){
			if( left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while( i < n1){
			arr[k++] = left[i++];
		}
		while( j < n2){
			arr[k++] = right[j++];
		}
	}
}