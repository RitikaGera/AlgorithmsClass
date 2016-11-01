package ArraysStrings;


//Java's implementation of .indexOf() is 
//just the naive string matching algorithm, 
//which is O(n+m) average and O(n*m) worst 


import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			Scanner sc=new Scanner(System.in);
			String s1=sc.next();
			String s2=sc.next();
			boolean result=isRotated(s1,s2);
			System.out.println(""+result);
		}
	}
	
	private static boolean isRotated(String s1, String s2){
		if(s1.length()==s2.length()&& s1.length()>0){
			String appendedS1=s1.concat(s1);
			return isSubString(s2,appendedS1);
		}
			return false;
		
	}
	private static boolean isSubString(String s2, String appendedS1){
		if(appendedS1.indexOf(s2)>=0){// The method indexOf() is used
										//for finding out the index of the specified character or substring in a particular String.
			return true;
		}
		else{
			return false;
		}
	}
}
