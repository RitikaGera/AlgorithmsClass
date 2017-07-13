//You are given a large range [a,b] where 'a' and 'b' can be typically between 1 and 4,000,000,000 inclusive. You have to find out the XOR of all the numbers 
//in the given range.
//Time Complexity : O(1)
//GREAT LOGIC : 

import java.util.Scanner;

public class XorRanged{
	public static void main(String[] args){
		Scanner sc = new Scanner();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = find(a,b);
		System.out.println(c);

	}

	public static int find(int a, int b){
		return f(a -1) ^ f(b); // Ist ques of prep : xors till a - 1 will cancel, leaving only ans left
	}

	public static int f(int a){ // return xor of numbers from 0 to a ( both inclusive)
		int[] res = { a, 1, a+1, 0}; // observe pattern
		return res[a%4];
	}
}