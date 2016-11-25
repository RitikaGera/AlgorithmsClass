import java.util.*;
public class ChangeMaker{
	
	public static int[][] coinchange(int[] den, int amount){
		int[][] dp =new int[den.length][amount +1];
		int i,j;
		for( i = 0; i < den.length; i++){
			dp[i][0] = 0;
			for( j = 1; j <= amount; j++){
				if(den[i] > j){
					if( i == 0){
						dp[i][j] = 0;
						//System.out.println("i and j"+ i +" "+ j+ "one");
						//System.out.println(""+dp[i][j]);
					}
					else{
						//System.out.println("i and j"+ i +" "+ j+ "dusra");
						dp[i][j] = dp[i-1][j];
						//System.out.println(""+dp[i][j]);
					}
				}
				else{
					if( i== 0){
						//System.out.println("i and j- den[i]"+ i +" "+ j+ "third");
						dp[i][j] = dp[i][j-den[i]] + 1;
						//System.out.println(""+dp[i][j]);
						
					}
					else{
						//System.out.println("i and j"+ i +" "+ j+ "fourth");
						dp[i][j] = min(dp[i][j-den[i]] + 1, dp[i-1][j]);
						//System.out.println(""+dp[i][j]);
					}
				}
			}
		}
		return dp;
	}
	
	public static int min(int a, int b){
		if( a >= b){
			return b;
		}
		else{
			return a;
		}
	}
	
	public static void backtrack(int[][] dp,int[] den){
		ArrayList<Integer> number = new ArrayList<Integer>();
		int k = dp[dp.length-1][dp[0].length-1];
		int amount = dp[0].length-1;
		int i = dp.length-1;
		int j = dp[0].length-1;
		System.out.println("start i "+i +" j "+j);
		while( i!=0 || j!=0){
			//dp[i][j]
			System.out.println(j-den[i]);
			if(j >= den[i]){
				if(dp[i][j] == dp[i][j-den[i]] + 1){
					number.add(den[i]);
					i = i;
					j = j - den[i];
					System.out.println(i+" if "+j+" ");
				}
				else{
				
					i = i-1;
					j = j;
				System.out.println(i+" else "+j);
				}
			}
			else{
				i = i-1;
				j = j;
			}
		}
		for( int  m = 0 ; m < number.size(); m++){
			System.out.println("coins "+number.get(m));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount");
		int amount = sc.nextInt();
		System.out.println("Enter the number of denominations");
		int nden = sc.nextInt();
		System.out.println("Enter the denominations");
		int[] den = new int[nden];
		
		for( int i = 0; i < nden; i++){
			den[i] = sc.nextInt();
		}
		Arrays.sort(den);
		int[][] dp=coinchange(den,amount);
		int numberOfCoins = coinchange(den, amount)[den.length-1][amount];
		System.out.println("number of coins needed are "+numberOfCoins);
		
		//Now tell me which coins you used exactly
		backtrack(dp,den);
		
	}

}
