import java.util.Random;
import java.io.PrintWriter;

public class RandomNumber {

	private static Random rnd = new Random();
	
	public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++)
	        sb.append((char)('0' + rnd.nextInt(10)));
	    return sb.toString();
	}
	
	public void write(){
		try{//use random.txt later in final code
		    PrintWriter writer = new PrintWriter("random.txt", "UTF-8");
		    for(int i = 0; i < 100; i++){//generating ten 10 digit numbers
			    String random_number = getRandomNumber(10);
			    writer.println(random_number);
		    }
		    writer.close();
		} 
		catch (Exception e) {
		   	System.out.println("jhol hua");
		}
	}
	public static void main(String[] args){
		RandomNumber myrand = new RandomNumber();
		myrand.write();
		
	}
}

