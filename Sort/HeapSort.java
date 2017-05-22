//Heap Sort
import java.util.Scanner;

public class HeapSort{
	public static void main(String[] args){
		System.out.println("Enter number of elements");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =  new int[n];
		System.out.println("Entere elements");
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		HeapSort obj = new HeapSort();
		arr = obj.heapSort(arr);
		printArray(arr);

	}

	public int[] heapSort(int[] arr){
		int half = arr.length/2 - 1;
		for( int i = half; i >= 0; i--){
			heapify(arr, arr.length, i);
		}
		for(  int i = arr.length - 1; i >= 0 ; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		return arr;
	}

	public void heapify( int[] arr, int length, int i ){
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if( left < length && arr[left] > arr[largest]){
			largest = left;
		}
		if( right < length && arr[right] > arr[largest]){
			largest = right;
		}
		if( largest != i){
			//swap
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, length, largest);
		}
	}

	public static void printArray(int[] arr){
		for( int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}