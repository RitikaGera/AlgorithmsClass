/* Given a string, check if it is a permutation of a plaindrome
 * Approach : Hashmap
 * Even length string can be a permutation of a palindrome if all character occur even number of times
 * Odd length strings: Only one character can occur odd number of times
 *  */
package ArraysStrings;

import java.util.HashMap;
import java.util.Scanner;

public class PalindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		boolean result=isPalindromePermutation(input);
		System.out.println("result is "+result);

	}
	public static boolean isPalindromePermutation(String input){
		HashMap<Character,Integer> hp=new HashMap<Character,Integer>();
		for(int i=0;i<input.length();i++){
			int count=0;
			char c=input.charAt(i);
			if(hp.containsKey(c)){
				count=hp.get(c)+1;
				hp.put(c,count);
			}
			else{
				hp.put(c,1);
			}
		}
		
			
			if(input.length()%2==0){
				for(int i=0;i<input.length();i++){
					char c=input.charAt(i);
					int count=hp.get(c);
					if(count%2!=0){
						return false;
					}
				}
				return true;
			}
			
			boolean flag=false;
			if(input.length()%2!=0){
				for(int i=0;i<input.length();i++){
					char c=input.charAt(i);
					int count=hp.get(c);
					if(count%2!=0){
						if(flag==false){
							flag=true;
							continue;
						}						
						return false;
					}
				}
				return true;
			}
			
			
				
				
		
		return true;
	}

}
