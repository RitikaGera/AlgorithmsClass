/*Check if a String has all unique characters
 *Assumption : all characters are small case
 *Approach : We treat the integer checker as a collection of 32 bits, yhis works because we have only 26 characters possible
 *Complexity : O(String length)
 *Space COplexity : O(1), I used bits, no extra space allocated
 */
package ArraysStrings;

import java.util.Scanner;

public class UniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		boolean result=areUnique(input);
		System.out.println("result is "+result);
		

	}
	private static boolean areUnique(String input){
		if(input.length()>256){
			return false;
		}
		int checker=0;
		for(int i=0;i<input.length();i++){
			char in=input.charAt(i);
			int val=in-'a';
			if((checker & (1<<val) )> 0){//setting 1 at the value stored in val
				return false;//because in (1<<val) 1 is set in a position, 1 will be set in same position in
				//checker as well if that character has appeared before
			}
			checker|=(1<<val);
		}
		return true;
	}

}
