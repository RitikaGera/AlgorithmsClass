// Question2
// Convert a decimal fraction in to a binary string
//	user enters a value between 0 and 1
// see link, observe special cases : http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
import java.util.*;

public class BinaryToString{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double fraction = sc.nextDouble();
		BinaryToString bts = new BinaryToString();
		bts.convert(fraction);
	}
	


public void convert(double decfrac){ // eg 0.625

	double fractional = decfrac % 1; // gives .625 for .625, gives .898 for 12.898 or xxxx.898
	double integral;
	System.out.print(".");
	int length = 32;
	while(fractional != 0 && length > 0){
		decfrac = fractional * 2; // 1.250
		fractional = decfrac % 1; // .250
		integral = decfrac - fractional; // 1.250 - .250 gives 1
		System.out.print((int)integral);
		length--;
	}
	if(length == 0){
		System.out.println("ERROR");
	}
}


}