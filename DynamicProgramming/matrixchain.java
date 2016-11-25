import java.util.*;
public class matrixchain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of matrices");
		int number = sc.nextInt();
		System.out.println("Enter the dimensions");
		int[] dimensions = new int[number+1];
		for(int i = 0; i <= number; i++){
			dimensions[i] = sc.nextInt();
		}
		int s[][] = new int[dimensions.length][dimensions.length];
		int[][] dp = matrixchain(dimensions, s);
		
		for( int i = 0; i < dp.length; i++){
			for( int j = 0; j < dp.length; j++){
				System.out.println(i+" "+j+" " +dp[i][j]);
			}
		}
		
		System.out.println("result "+ dp[1][dp.length - 1]);
		
		for( int i = 0; i < dp.length; i++){
			for( int j = 0; j < dp.length; j++){
				System.out.print(" " +s[i][j]);
			}
			System.out.println();
		}
		
		printOptimalParens(s,1,dimensions.length - 1);
		
	}
	
	public static int[][] matrixchain(int[] dimensions, int[][] s){
		int[][] dp = new int[dimensions.length][dimensions.length];
		/* one extra row and one extra column are added to dp */
		int q;
		for( int i = 1; i< dp.length; i++){
			dp[i][i] = 0;
		}
		for( int l = 2; l < dp.length; l++ ){
			for( int i = 1; i < dp.length - l + 1; i++){
					int j = i + l - 1;
					if( j == dp.length){
						continue;
					}
					dp[i][j] = Integer.MAX_VALUE;
					for( int k = i; k < j; k++){
						 q = dp[i][k] + dp[k+1][j] + dimensions[i-1] * dimensions[k] * dimensions[j];
						 System.out.println("dim i-1,k,j"+dimensions[i-1]+" "+dimensions[k]+" "+dimensions[j]+" "+ q);
						 if(q < dp[i][j]){
							 dp[i][j] = q;
							 s[i][j] = k;
							 System.out.println("k is : "+i+" " +j +" " +s[i][j]);
							 
						 }
					}
				}
			}
		
		return dp;
		}

	public static void printOptimalParens(int[][] s,int i, int j){
		if( i == j){
			System.out.print("A"+i);
		}
		else{
			System.out.print("(");
			printOptimalParens(s,i,s[i][j]);
			printOptimalParens(s,s[i][j] + 1,j);
			System.out.print(")");
		}
	}
}
