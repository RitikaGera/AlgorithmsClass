/* Given two Strings, check if one is a permutation of the other
 * Apporoach : YOu can do it in O(nlogn), sort both then compare OR
 * you can count the frequency of each character of both string and compre the frequency arrays(not elegant): O(n) time, O(2n) space
 * So, we will do it in O(n) using Hashmap
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */

package ArraysStrings;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String input1=sc.next();
		String input2=sc.next();
		boolean result=arePermutations(input1,input2);
		System.out.println("result is "+result);

	}
	private static boolean arePermutations(String input1, String input2){
		if(input1.length()!=input2.length()){
			return false;
		}
		HashMap<Character,Integer> hp=new HashMap<Character,Integer>();
		for(int i=0;i<input1.length();i++){//populating the hashmap
			char c1=input1.charAt(i);
			int count=0;
			if(hp.containsKey(c1)){
				count=hp.get(c1)+1;
				hp.put(c1, count);
				//System.out.println(""+count);
			}
			else{
				hp.put(c1,1);
			}
			
		}
		for(int i=0;i<input2.length();i++){
			char c2=input2.charAt(i);
			if(hp.containsKey(c2)){//key is present
				int count2=hp.get(c2);
				if(count2==0){//key present but in original string that character occurred fewer times
					return false;
				}
				
				hp.put(c2, count2-1);
			}
			else{//key absent  that is this character was absent in original string
				return false;
			}
		}
		//What if original String had extra characters, so at end all values in hash map must be 0
		Set<Character> keys=hp.keySet();
		for(Character k : keys){
			if(hp.get(k)!=0){
				return false;
			}
		}
		return true;
	}

}
