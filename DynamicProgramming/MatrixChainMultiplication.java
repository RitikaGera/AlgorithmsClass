// Matrix Chain Multiplication
import java.util.Scanner;
public class MatrixChainMultiplication{
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("enter number of matrices");
	    
	    int mat = sc.nextInt();
	    
	    int[] dim = new int[mat+1];// number of dims will be one more 
		
		System.out.println("enter dimensions");
		for( int i = 0; i <= mat; i++){
			dim[i] = sc.nextInt();
		}
		
		MatrixChainMultiplication obj = new MatrixChainMultiplication();
		
	//	int[][] dp = obj.matrixChainDP(dim) ;
		
		System.out.println(" minimum number of multiplications required are " + obj.matrixChain_recursive(dim, 1, dim.length - 1) );
	}

	public int matrixChain_recursive(int[] dim, int i, int j){
		int min = Integer.MAX_VALUE;
		int count = 0;
		for( int k = i; k < j; k++){
			count = matrixChain_recursive(dim, i, k - 1) + matrixChain_recursive(dim, k + 1, j) + dim[ i - 1] * dim[k] * dim[j];
			if( count < min){
				min = count;
			}
		}
			return min;
		}
	
	public static int[][] matrixChainDP(int[] dim){
		int[][] dp = new int[dim.length][dim.length];	
		return dp;
	}
}