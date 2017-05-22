//Quick Sort
import java.util.Scanner;
public class QuickSort{
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

	public void quickSort(int[] arr, int l , int r){
		if( l < r){
			int pivot = partition( arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
	}

	public int partition( int[] arr, int l, int r){ // set pivot at right position, smaller elements on its left, greater on right
		int pivotvalue = arr[r];
		int i = l - 1;
		for( int j = l ; j < r ; j++){
			if( arr[j] < pivotvalue){
				//swap arr[j] and arr[i + 1]
				int temp = arr[j];
				arr[j] = arr[i + 1];
				arr[i + 1] = temp;
				i++;
			}
		}
		//now elements to left of index ( i + 1) are smaller than pivot value and on right are greater, so put pivot on its right position
		//swap arr[r] and arr[i +1 ]
		int temp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = temp;
		return (i + 1); // indexof pivot
	}
}