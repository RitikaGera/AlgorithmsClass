import java.util.ArrayList;
import java.util.Scanner;

public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s0 = "0";
		String s1 = s0 + sc.next();
		String s2 = s0 + sc.next();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int dp[][] = lcs(c1,c2);
		System.out.println("result "+dp[c1.length-1][c2.length-1]);
		for(int i = 0; i < c1.length; i++){
			for( int j = 0; j < c2.length; j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		ArrayList<Character> number = backtrack(dp,c1,c2);
		System.out.print("lcs is: ");
		for (int k = number.size() - 1; k >= 0; k--) {
			System.out.print(number.get(k));
		}
	}
	
	public static int max(int a, int b){
		if(a > b){
			return a;
		}
		return b;
	}
	
	public static int[][] lcs(char[] c1, char[] c2){
		int[][] dp = new int[c1.length][c2.length];
		for( int i = 1; i < c1.length; i++){
			for( int j = 1; j < c2.length; j++){
				dp[0][j] = 0;
				dp[i][0] = 0;
				if( c1[i] == c2[j]){
					dp[i][j] = dp[i-1][j-1] + 1;					
				}
				else{
					dp[i][j] = max(dp[i - 1][j], dp[i][j -1]);
				}
			}
		}
		return dp;
	}

	public static ArrayList<Character> backtrack(int[][] dp, char[] c1, char[] c2){
		int i = c1.length - 1;
		int j = c2.length - 1;
		ArrayList<Character> number = new ArrayList<Character>();
		while(dp[i][j]!=0){
			
			if(dp[i][j] == dp[i-1][j]){
				i--;
			}
			else if(dp[i][j] == dp[i][j-1]){
				j--;
				
			}
			else if(dp[i][j] == dp[i-1][j-1] + 1){
				number.add(c1[i]);
				i--;
				j--;
			}
			
		}
		return number;
	}
}
