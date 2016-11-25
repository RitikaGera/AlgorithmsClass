import java.util.Scanner;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of terms in set");
		int n = sc.nextInt();
		int[] set = new int[n];
		System.out.println("enter terms");
		for( int i = 0; i < n; i++){
			set[i] = sc.nextInt();
		}
		System.out.println("enter the desired sum");
		int sum = sc.nextInt();
		boolean[][] dp = subsetsum(set,sum);
		System.out.println("result "+dp[set.length-1][sum]);

	}
	public static boolean[][] subsetsum(int[] set, int sum){
		boolean[][]dp = new boolean[set.length][sum+1];
		for( int i = 0; i < dp.length; i++){
			dp[i][0]= true;
			for( int j = 1; j < sum + 1; j++){
				if(i == 0){
					if(set[i] == j){
						dp[i][j] = true;
					}
					else{
						dp[i][j] = false;
					}
				}
				else{
					if(j- set[i] >=0){
						dp[i][j] = dp[i-1][j-set[i]] || dp[i-1][j];
					}
					else{
						dp[i][j] = dp[i-1][j];
					}
				}
				
			}
		}
		return dp;
	}

}
