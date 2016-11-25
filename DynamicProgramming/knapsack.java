import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter max Weight");
		int W = sc.nextInt();
		System.out.println("Enter the number of items");
		int nweight = sc.nextInt();
		System.out.println("Enter the valu-weight of items");
		int[] weight = new int[nweight];
		int[] value = new int[nweight];
		for( int i = 0; i < nweight; i++){
			value[i] = sc.nextInt();
			weight[i] = sc.nextInt();		
		}
		for(int i = 0; i < nweight; i++){
			for( int j = 0; j < nweight-i-1; j++){
				if( weight[j] > weight[j+1]){
					int temp = weight[j];
					weight[j] = weight[j+1];
					weight[j+1] = temp;
					
					int temp1 = value[j];
					value[j] = value[j+1];
					value[j+1] = temp1;
				}
			}
		}
		
		for( int i = 0; i < nweight; i++){
			System.out.println(""+weight[i]+" "+value[i]);
		}
		
	    int[][] dp=knapsack(weight, W, value);
		System.out.println("max profit is: "+ dp[dp.length-1][dp[0].length-1]);
		backtrack(dp,W,value,weight);
	}
	
	public static int[][] knapsack(int[] weight, int W, int[] value){
		int dp[][] = new int[weight.length][W + 1];
		for( int i = 0; i < weight.length; i++){
			dp[i][0]=0;
			for( int j = 1; j < W + 1; j++){
					if(weight[i] > j){
						if(i == 0){
							dp[i][j] = 0;
							System.out.println("if1 "+dp[i][j]);
						}
						else{
							dp[i][j] = dp[i - 1][j];
							System.out.println("if2 "+dp[i][j]);
						}
						
					}
					else{
						if(i == 0){
							dp[i][j] = value[i];
							System.out.println("else1 "+dp[i][j]);
						}
						else{
							dp[i][j] = max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);					
							System.out.println("else2 "+i+" "+j+" "+dp[i][j]);
						}
						
					}
				
			}
		}
		
		return dp;
	}
	
	public static int max(int a, int b){
		if(a >= b){
			return a;
		}
		return b;
	}
	public static void backtrack(int[][]dp, int W,int[] value,int[] weight){
		int i = dp.length - 1;
		int j = dp[0].length - 1;
		ArrayList<Integer> number = new ArrayList<Integer>();
		while(i!=0 && j!=0){
			System.out.println(i+" "+j);
			if( i > 0 && j - weight[i] >=0){
				if(dp[i][j]== dp[i-1][j-weight[i]] + value[i]){
					number.add(weight[i]);
					i = i - 1;
					j = j - weight[i];
					
				}
				else{			
					i = i - 1;
					j = j;
				}
			}
			else{
				i = i - 1;
				j = j;
			}
		
		}
		for( int k = 0; k < number.size(); k++){
			System.out.println("weights are: "+ number.get(k));
		}
	
		}

}
