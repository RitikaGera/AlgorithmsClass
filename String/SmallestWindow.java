//INTERESTING AND IMPORTANT asked in AMAZON
/*Find the smallest window in a string containing all characters of another string
Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
For Example:

Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestWindow {
   
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int test = sc.nextInt();
	    for( int i = 0; i <test; i++){
	        String str1 = sc.next();
	        String str2 = sc.next();
	        int winsize = GetSmallestWindow(str1, str2);
	        System.out.println(winsize);
	    }
	}

	public static int GetSmallestWindow(String str, String pattern){
		if( pattern.length() > str.length()){
			return -1;
		}

		int[] pat_count = new int[256];
		int[] str_count = new int[256]; // Why 256? because in the extended ASCII set, there are 256 characters, we can keep it to 26 and use ch -'a' as well
		for( int i = 0; i < pattern.length(); i++){
			pat_count[pattern.charAt(i)]++; // its extended ASCII code which falls from 0 to 256
		} 
		int min_length = Integer.MAX_VALUE;
		int start_index = -1;
		int start = 0;
		int count = 0;
		for( int i = 0; i < str.length(); i++){
			str_count[str.charAt(i)]++;
			if(pat_count[str.charAt(i)] > 0 && str_count[str.charAt(i)] <= pat_count[str.charAt(i)]){ //you only need to count when theres is requirement, that is if strcount is greater that means I dont need an extra matching characer so I dont put it in count variable
				count++;
			}
			if( count == pattern.length()){ // a window is found, now try to shorten it
				while((str_count[str.charAt(start)] > pat_count[str.charAt(start)]) || pat_count[str.charAt(start)] == 0){// either in the window, I have more than required or I don't need that character as its not in the pattern
					if( str_count[str.charAt(start)] > pat_count[str.charAt(start)]){ // this condition is going to be true( since while condition) unless str's count is also 0, in whihch case, I would nt want to set it -1
						str_count[str.charAt(start)]--; // since Now, that I am sliding the window, I cant say in the window, I have these many occurences of ch
					}
					start++;
				} 					

				int curr_win_size = i - start + 1;
				if(curr_win_size < min_length){
					min_length = curr_win_size;
					start_index = start; // of you found a smaller window,,update start
				}
			}
		}
		if(start_index == -1){
			System.out.println("No such window exists");
		}
		for( int i = start_index; i <= (start_index + min_length - 1); i++){
			System.out.print(str.charAt(i));
		}
		return min_length;


	}


}