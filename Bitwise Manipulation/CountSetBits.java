/*Count total set bits in all numbers from 1 to n
Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.

Examples:

Input: n = 3
Output:  4

Input: n = 6
Output: 9
Approach 1: do it for each number : O(nlogn)
Appraoch2 : The clever approach : If the input number is of the form 2^b -1 e.g., 1,3,7,15.. etc, the number of set bits is b * 2^(b-1). This is because for all the numbers 0 to (2^b)-1, if you complement and flip the list you end up with the same list (half the bits are on, half off).

If the number does not have all set bits, then some position m is the position of leftmost set bit. The number of set bits in that position is n – (1 << m) + 1. 
Example for number not of form 111...
take 6, 0110 

*/

import java.util.Scanner;

public class CountSetBits{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = CountSetBits(n);
	}

	public static int CountSetBits(int n ){
		
	}
}