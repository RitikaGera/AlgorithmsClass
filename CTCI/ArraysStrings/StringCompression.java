package ArraysStrings;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String result=compress(s1);
		if(result.length()>=s1.length()){
			result=s1;
		}
		System.out.println("Final Result "+result);

	}
	public static String compress(String s1){
		StringBuffer s2=new StringBuffer();
		for(int i=0;i<s1.length();){
			char a=s1.charAt(i);
			int count=0;
			s2.append(a);
			
			while(i<s1.length() && s1.charAt(i)==a){
				i++;
				count++;
			}
			s2.append(count);
			
		}
		System.out.println("Inside function "+s2);
		return s2.toString();
	
	}

}
