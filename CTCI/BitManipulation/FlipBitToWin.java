// flip exactly one bit from 0 to 1 to get the longest possible sequence of 1s
// 1775              : 11011101111
//flip 				 : 11011111111 with 4th bit converted to 1
// output : 8
//Time : O(no. of bits)
// Space : O(1)
import java.util.*;

public class FlipBitToWin{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
	//	int convnum = convertToBinary(num);
		FlipBitToWin fl = new FlipBitToWin();
		int output = fl.flip(num);
		System.out.println(output);
	}

	public int flip(int num){
		//Bitset numb = new Bitset();
		//find the set msb so that i can loop for that much only, otherwise I will have to hardcode, making it run for 32 times
		int msbpos = (int)(Math.log(num)/Math.log(2)) + 1;
		
		int output = 0;
		int first = 0;
		int second = 0; 
		int flag = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
	//	System.out.println(~convnum + "the number is all 1s");
		//int count = 32;
		while(msbpos > 0){
			while( (num & 0b1) == 1){ // here if you write (num & 0b1 == 1), you will get an error because == has higher prio than &
				first++;
				num = num >>>1;
			}
			System.out.println("first " + first);
		//now you see a zero
			System.out.println("zero "+ (num & 0b1) + num);
			num = num >>> 1;
			while((num & 0b1) == 1){
				second++;
				num = num >>>1;
			}
			System.out.println("second "+ second);
			//now you have first and second, add and update max if need be
			sum = first + second + 1;//one for the zero found in between, the one we will convert

			if( sum > max ){
				max = sum;
				System.out.println(max);
			}			
			first = second;
			second = 0;
			msbpos--;
		}
		


		 

		return max;
	}

	public static int convertToBinary(int num){
		
		String bin = Integer.toBinaryString(num);
		//System.out.println(bin);
		int binary = Integer.parseInt(bin);
		//System.out.println(binary);
		return binary;
	}

}