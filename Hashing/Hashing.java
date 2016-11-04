import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hashing {

	
public static void main(String args[]){
	Primary primary = new Primary(); //structure initialized in constructor
	primary.generateAB();
	
	try{
		Scanner sc = new Scanner(new File("/home/ritika/workspace/Hashing/random.txt"));
		while(sc.hasNextLine()){
			long x = Long.parseLong(sc.nextLine());
			primary.GenKeyAndAdd(x);
		}
		sc.close();
		while(primary.SizeNotExceeded() == false){//size is being exceeded so rehash
			primary.generateAB();
			//Scanner sc1 = new Scanner(new File("random1.txt"));
			while(sc.hasNextLine()){
				long x = Long.parseLong(sc.nextLine());
				primary.GenKeyAndAdd(x);
			}
			
		}
		sc.close();
		
		Secondary[] secondary_str = new Secondary[ 2 * primary.n];
		primary.callSecondaryHash(secondary_str);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public void secondary_hash(ArrayList<Long>[] primaryTable, Secondary[] secondary_structure){
	
	BufferedWriter bw = null;
	try{
		bw = new BufferedWriter(new FileWriter("output.txt"));
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	//Initializing secondary structure, that is allocating memory to its objects
	for( int i = 0; i < primaryTable.length; i++){
		secondary_structure[i] = new Secondary();
		while(true){
			long prime = 101723;
			int a = (int) Math.random() * 1000;
			int b = (int) Math.random() * 1000;
			int local_size = primaryTable[i].size();
			if( local_size > 0){
				secondary_structure[i].secondaryarray = new long[local_size * local_size];
				Arrays.fill(secondary_structure[i].secondaryarray, -1);
				int j;
				for( j = 0; j < local_size; j++){
					long value = primaryTable[i].get(j);
					int sec_index = Math.abs((int)(( a * value + b ) % prime) % (local_size * local_size));
					if(secondary_structure[i].secondaryarray[sec_index] == -1)
                    {
						secondary_structure[i].secondaryarray[sec_index] = value;
                    }
					else{
						System.out.println("collision detected, so rehash");
						break;//inner for
					}
				}
				if( j== local_size){
					secondary_structure[i].a = a;
					secondary_structure[i].b = b;
					secondary_structure[i].p = prime;
					
					try{
						System.out.println("likhega");
						bw.write(secondary_structure[i].a +" "+ secondary_structure[i].b +" "+ secondary_structure[i].p + " ");
					} 
					
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;//while
					
				}
				else{
				//	System.out.println("complete nhi ho paya, dobara obj create hoga");
				}
			}
			else{
				break;//while
			}
		}
	}
	
	
}
}
