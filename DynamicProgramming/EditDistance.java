import java.util.*;
//converting second string to first string

public class EditDistance{
	private static final int REPLACE = 10;
	private static final int DELETE = 7;
	private static final int ADD = 5;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s0 = "0";
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int[][] result = edit(s1,s2, s1.length(), s2.length());
		for( int i = 0; i < s1.length()+1; i++){
			for( int j =0 ; j < s2.length()+1; j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}


		System.out.println("The minimum number of operations required are : "+ result[s1.length()][s2.length()]);
	//	backtrack(result, s1, s2);
	}

	public static int[][] edit(String s1, String s2, int m, int n){//converting s1 to s2
		int dp[][] = new int[m + 1][n + 1];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for( int i =0 ; i < c1.length; i++){//0,1,2
			System.out.println(c1[i]);

		}
		for( int i = 0; i <= m; i++){
			for( int j = 0; j <= n; j++){
				if(i == 0){// if first string is null , you have to add second string in first
					dp[i][j] = j * ADD;
				}
				else if( j == 0){ // if second string is empty, you have to delete all characters of s1
					dp[i][j] = i * DELETE ;
				}
				else if(c1[i-1] == c2[j-1]){// if characters match
					dp[i][j] = dp[i-1][j-1];// no operation
				}
				else{
					dp[i][j] =  min(dp[i-1][j] + DELETE,dp[i][j-1] + ADD,dp[i-1][j-1] + REPLACE);
				}

			}
		}
		return dp;
	}

	public static int min( int a, int b, int c){
		int temp = (a < b)? a : b;
		if(c < temp){
			return c;
		}
		return temp;
	}

	public static void backtrack(int dp[][], String s1, String s2){
			int i = dp.length -1 ;
			int j = dp[0].length - 1;
			while(true){
				if(i == 0 || j ==0){
					break;
				}
				System.out.println("char"+ i +" ");
				if(s1.charAt(i-1) == s2.charAt(j-1)){
						i = i-1;
						j = j-1;
						System.out.println("2");
					}
					
				else if(dp[i][j] == dp[i-1][j-1] + 1){
						System.out.println("replace "+ s2.charAt(j-1)+" with "+ s1.charAt(i-1));
						i--;
						j--;
						System.out.println("3");
				}
				
				else if(dp[i][j] == dp[i-1][j] + 1){
						System.out.println("delete in s2 "+ s2.charAt(j-1));
						i--;
						System.out.println("4");
				}
				
				else if( dp[i][j] == dp[i][j-1] + 1){
						System.out.println("add in s2 this character of s1" + s1.charAt(i - 1));
						j--;
				}
				
			}
	}
	
}
