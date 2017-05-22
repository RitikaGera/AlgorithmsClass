// Find kth smallest element in amortized cost O(n)
import java.util.Scanner;

public class Median {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
         int medianindex = 0;
         medianindex = partition(arr, 0 , n - 1);

        while( medianindex != n/2){
            if( medianindex > n/2){
                medianindex = partition(arr, 0, medianindex - 1 );
            }
            else{
                medianindex = partition(arr, medianindex + 1 , n - 1);    
            }
            
        }
        System.out.println(arr[medianindex]);
    }
    public static int partition(int[] arr, int l, int r){
        int pivotvalue = arr[r];
        int i = l - 1;
        for( int k = l; k < r; k++){
            if( arr[k] < arr[r]){
                //swap arr[ i + 1 ] and arr[j]
                int temp = arr[k];
                arr[k] = arr[ i + 1];
                arr[i + 1] = temp;
                i++;
            }
        }
        System.out.println("before swap");
        printArray(arr);
        //now swap arr[i + 1] and arr[r]
        int temp = arr[r];
        arr[r] = arr[i+1];
        arr[i+1] = temp;
        System.out.println("after swap");
        printArray(arr);
        return ( i + 1);
    }

    public static void printArray(int[] arr){
        for( int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}