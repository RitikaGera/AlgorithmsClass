// Detect if two integers have opposite signs
/*
Given two signed integers, write a function that returns true if the signs of given integers are different, otherwise false. 
For example, the function should return true -1 and +100, and should return false for -100 and -200. The function should not use any of the arithmetic operators.*/
// The sign bit of negative is 1, positive is 0, so xor of pos and neg numers will be negative : O(1)
import java.util.Scanner;

public class OppositeSigns{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		OppositeSigns obj = new OppositeSigns();
		boolean result = obj.detect(a, b);
		System.out.println(result);
	}
	public boolean detect(int a, int b){
		int c = ( a ^ b);
		boolean d = ( c < 0 )? true : false;
		return d;

	}
}