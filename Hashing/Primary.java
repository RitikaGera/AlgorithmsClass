import java.util.ArrayList;
import java.util.Random;

public class Primary {

	int a,b;
	public int n = 100;
	int prime = 1000000 + 7;
	ArrayList<Long> primaryTable[];
	
	public Primary(){
		
		primaryTable = new ArrayList[2 * n];
		for(int i = 0; i < 2 * n; i++){
			primaryTable[i] = new ArrayList();
		}
	}
	
	void generateAB(){
		Random rand = new Random();
		this.a = (int)(Math.random() * 1000);
		this.b = (int)(Math.random() * 1000);
	}
	
	void GenKeyAndAdd(long x){
		
		int key = (int)((this.a * x + this.b) % prime) % ( 2 * n);
		primaryTable[Math.abs(key)].add(x);
	}
	
	boolean SizeNotExceeded(){
		int sum = 0;
		int local_size;
		for( int i = 0; i < 2 * n; i++){
		    local_size = primaryTable[i].size();
			sum += Math.pow(local_size, 2);
		}
		if( sum > 2 * n){
			return false;
		}
		return true;//ok, no need to rehash at primary level
	}
	
	public ArrayList<Long>[] getFullPrimaryTable(){
		return primaryTable;
	}
	
	public void callSecondaryHash(Secondary[] secondary_structure){
		new Hashing().secondary_hash(this.primaryTable, secondary_structure);
	}
}
