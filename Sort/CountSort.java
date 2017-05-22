// Count Sort
import java.util.Scanner;
public class CountSort{
	public static void main(String[] args){
		System.out.println("Enter number of elements");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =  new int[n];
		System.out.println("Enter elements");
		int max = Integer.MIN_VALUE;
		for( int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
			if(arr[i] > max){
				max = arr[i];
			}
		}
		CountSort obj = new CountSort();
		obj.countSort(arr, max);
		printArray(arr);

	}
	
	public static void printArray(int[] arr){
		for( int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

	public void countSort(int[] arr, int max){
		int[] count = new int[max + 1];
		int[] output = new int[arr.length];
		for( int i = 0; i <= max; i++){
			 count[i] = 0;
		}
		for( int i = 0; i < arr.length; i++){
			 count[arr[i]] ++;
		}
		for( int i = 1; i <= max; i++){
			count[i] += count[i - 1];
		}
		//now place elements in their correct position
		for( int i = 0; i < arr.length; i++){
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for( int i = 0; i < arr.length; i++){
			arr[i] = output[i];
		}
	}
}