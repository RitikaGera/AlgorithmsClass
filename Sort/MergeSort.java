import java.util.*;
public class MergeSort {

	static int[] sorted = new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={4, 7, 19, 16, 14, 18, 17, 13, 10, 2, 3, 8};
		mergesort(input,0, input.length-1);
		//merge m = new merge();
		//m.merger(input);
		for( int i = 0 ; i < input.length; i++){
			System.out.println(input[i]);
		}

	}
	
	public static void mergesort(int[] input, int start, int end){
		ArrayList<Integer> temp1 = new ArrayList();
		ArrayList<Integer> temp2 = new ArrayList();
		
		for( int i =0; i< input.length - 1;){
			int j =i;
			if(temp1.isEmpty()){
				temp1.add(input[i]);
			    j = i;
			//	System.out.println("j is"+ j);
				if( j< input.length){
					while( input[j+1] > input[j] ){
						temp1.add(input[j+1]);
						j++;
					}
				}
				j = j + 1;
			}
			temp2.add(input[j]);
			if( j <input.length){
				while( input[j] > input[j + 1]){
					temp2.add(input[j+1]);
					j++;
				}
			}
			j++;
			//ArrayList<Integer> temp = new ArrayList();
			temp1 = merge(temp1,temp2,start);
			//System.out.println("start"+ start);
			
			
			
			i = j;
			
			}
			
	}
	
	
	public static ArrayList<Integer> merge(ArrayList<Integer> temp1, ArrayList<Integer> temp2, int start){
		ArrayList<Integer> left = temp1;
		ArrayList<Integer> right = temp2;
		ArrayList<Integer> temp = new ArrayList();
		int size = temp2.size()-1;
		
		if(temp2.get(0) > temp2.get(1)){
			for(int i = 0; i< temp2.size(); i++){
				right.set(i,temp2.get(size));
				size--;
			}
		}
		//left and right in increasing order now
		
		
		int i =start;
		Iterator<Integer> it1 = temp1.iterator();
		Iterator<Integer> it2 = temp2.iterator();
		while(it1.hasNext() && it2.hasNext()){
			int a = it1.next();
			int b = it2.next();
			if(a < b){
				temp.add(a);
			}
			else{
				temp.add(b);
			}
		}
		while(it1.hasNext()){
				temp.add(it1.next());
		}
		while(it2.hasNext()){
			    temp.add(it1.next());
		}
		
		return temp;
	}
	}


