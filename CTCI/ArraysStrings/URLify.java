/* Given a string, replace all the spaces with %20, do it in-place
 * Time Complexity : O(n)
 * Approach : To do it in-place, I have to write to the array from the end
 * since I start writing from starting the contents of original array will get overwritten
 * DEKHO : JAB SPACE COUNT KARTE HAIN TO Scanner.nextLine() lete hain, Scanner.next() nhi
 */
package ArraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sinput=sc.nextLine();
		char[] input = sinput.toCharArray();
		
		int truelength=findLastCharacterIndex(input)+1;
			
		doURLify(input, truelength);
		
		

	}
	public static int findLastCharacterIndex(char[] input){
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] != ' ') {
				return i;
			}
		}
		return -1;
		
	}
	public static void doURLify(char[] input,int truelength){
		int spacecount=0;
		
		for(int i=0;i<truelength;i++){
			if(input[i]==' '){
				spacecount++;
			}
		}
		
		int newlength=truelength+2*spacecount;//since I remove one space and put %20, that is two characters extra
		if(truelength<input.length){
			input[truelength]='\0';
		}
		
		for(int i=truelength-1;i>=0;i--){
				if(input[i]==' '){
					input[newlength-1]='0';
					input[newlength-2]='2';
					input[newlength-3]='%';
					newlength-=3;
					System.out.println(""+(newlength));
				}
				else{
					
					input[newlength-1]=input[i];
				//	System.out.print(input[newlength-i]);
					newlength--;
					System.out.println(input[i]);
					
				}
		}
		
		
		//print output(in place);
		Arrays.toString(input);
		System.out.println(input);
		

}
}