/*Check if two given Strings are atmost one edit distance away
 *  Approach : simultaneously traverse both strings and keep track of count of different characters.
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
package ArraysStrings;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String input1=sc.next();
		String input2=sc.next();
		System.out.println("The two strings are oneEditaway: "+oneEditAway(input1,input2));
		
	}
	private static boolean oneEditAway(String first, String second){
		if(first.length()==second.length()){
			return oneEditReplace(first,second);
		}
		else if(first.length()+1==second.length()){
			return oneEditInsert(first,second);//second is larger by 1
		}
		else if(first.length()==second.length()+1){
			return oneEditInsert(second,first);//first is larger by 1
		}
		return false;
	}


	private static boolean oneEditReplace(String first, String second){
		boolean foundDifference=false;
		for(int i=0;i<first.length();i++){
			if(first.charAt(i)!=second.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference=true;
			}
		}
		return true;
		
	}
	private static boolean oneEditInsert(String first, String second){
		int index1=0,index2=0;
		while(index1<first.length()&& index2<second.length()){
			if(first.charAt(index1)!=second.charAt(index2)){
				if(index1!=index2){
					return false;//incrementing larger only
				}
				index2++;
			}
			else{
				index1++;
				index2++;
			}
			}
		return true;
		}
	}
