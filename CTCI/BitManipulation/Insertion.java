// Question1
//In Java SE 7, the integral types (byte, short, int, and long) can also be expressed using the binary number system. To specify a binary literal, add the prefix 0b or 0B to the number
//insert M in to N from bit i through j
import java.util.*;

public class Insertion{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		/*int a = sc.nextInt();
		int b = sc.nextInt();
		*/
		int a = 0b1011111;
		int b = 0b10011;
		System.out.println(a + " "+ b); 
		System.out.println("Enyter i and j");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int count = j - i + 1;
		int mask = 0;
		int temp = 0;
		while(count > 0 ){
			temp= ( 1 << i);
			mask = mask | temp;
			System.out.println(i + " "+ mask);
			count --;
			i ++;
		}
		mask = ~(mask);
		System.out.println("mask "+mask);
		a = a & mask; 
		// now just or
		System.out.println("a :"+ a);
		int result = b | a;
		System.out.println("result "+ result);
		


	}
}
