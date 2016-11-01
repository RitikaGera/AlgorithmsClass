import java.io.File;
import java.util.*;

public class PerfectHashing {
	
	
	
	int n = 100; //number of numbers to be hashed btw change n= 1000000, size = 2 * n, 1000000 can be stored in int
	int size = 2 * n;
	LinkedList<Long> primary[] = new LinkedList[size];
	int a, b;
	
	static int prime = 1000000+7;

	public PerfectHashing(){
		
		for(int i = 0; i< size; i++){
			primary[i]= new LinkedList<Long>();
		}
	}
	
	public void setA(){
		Random rand = new Random();
		this.a = rand.nextInt();
	}
	
	public void setB(){
		Random rand = new Random();
		this.b = rand.nextInt();//Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
	}
	
	public LinkedList<Long>[] getFullList(){
		return this.primary;
	}
	
	public static void main(String[] args) {
		
		PerfectHashing ph = new PerfectHashing();
		ph.setA();
		ph.setB();
		
		try{			
			Scanner sc = new Scanner(new File("random.txt"));
			
			while(sc.hasNext()){
				long x = sc.nextLong();
				int key = ph.computePrimaryKey(x);
				System.out.println(key);
				ph.primary[(int)key].add(x);
				System.out.println(x+" added at index "+ key);
				/*if(Math.pow(ph.primary[key].size(),2) < ph.size){
					for(int i = 0; i < ph.size; i++){
						ph.primary[i]=null;
					}
					//make sc move to beginning of file
					//wrong since reset method resets scanner's delimited to default delimiter
					sc.reset();
				}*/
			}
		    ph.second_level(ph);
			
		}
		catch(Exception e){
				e.printStackTrace();
		}

		
		
	}
	
	
	
	
	
	//read number from file, random1 finally
	
	
	
	public int computePrimaryKey(long x){
		
		System.out.println(a+" "+b+" "+x);
		int key =  Math.abs((int)(((this.a * x + this.b) % size)% prime)); 
		return key;
	}
	
	public int computeSecondaryKey(long x, int size_newarray){
		System.out.println("size "+size_newarray);
		Random rand = new Random();
		int A = rand.nextInt();
		int B = rand.nextInt();
		int key = Math.abs((int)(((A * x + B) % size_newarray)% prime)); 
		return key;
	}
	
	public void second_level(PerfectHashing ph){
		for(int i = 0; i < ph.size; i++){
			
			if(ph.getFullList()[i].size() == 0){
				continue;
			}
			int size_second = ((int) Math.pow(ph.getFullList()[i].size(),2));
			long[] second = new long[size_second];
			System.out.println("second ka size: "+(int) Math.pow(ph.getFullList()[i].size(),2));
			for(int j = 0; j < size_second; j++){
				second[j] = -1;
			}
			Iterator<Long> it = ph.getFullList()[i].listIterator();
			while(it.hasNext()){
				System.out.println("ander ke ander iska sqaure pass kr rhe"+ size_second);
				long x = it.next();
				int sec_key = computeSecondaryKey(x, size_second);
				while(second[sec_key] != -1){
					sec_key = computeSecondaryKey(x, size_second);
					System.out.println("collision");
				}
				second[sec_key] = x;
				System.out.println("successfully set");
			}
					
			
			
		}
	}

}


