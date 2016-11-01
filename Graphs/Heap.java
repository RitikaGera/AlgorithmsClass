
public class Heap {

	int max_size;
	int size;
	private Vertex[] minheap;
	
	//constructor
	public Heap(int maxsize){
		this.max_size=maxsize;
		this.size=0;
		minheap=new Vertex[this.max_size];		
	}
	
	public static void main(String args[]){
		Heap heap=new Heap(7);
		Vertex v1=new Vertex(2);
		v1.setWeight(2);
		heap.add(v1);
		
		Vertex v2=new Vertex(4);
		v2.setWeight(4);
		heap.add(v2);
		
		
		
		Vertex v3=new Vertex(3);
		v3.setWeight(3);
		heap.add(v3);
		
		Vertex v4=new Vertex(8);
		v4.setWeight(8);
		heap.add(v4);
		
		Vertex v5=new Vertex(5);
		v5.setWeight(5);
		heap.add(v5);
		
		Vertex v6=new Vertex(6);
		v6.setWeight(6);
		heap.add(v6);
		
		Vertex v7=new Vertex(7);
		v7.setWeight(7);
		heap.add(v7);
		
		for(int i=0;i<heap.size;i++){
			System.out.println(""+heap.minheap[i].getLabel()+" "+heap.minheap[i].getWeight());
		}
		heap.decreaseKey(4, 0);
		//heap.restoreDown(0);
		//heap.DeleteMin();
		for(int i=0;i<heap.size;i++){
			System.out.println("****"+heap.minheap[i].getLabel()+" "+heap.minheap[i].getWeight());
		}
	}
	private int getParent(int pos){
		return pos/2;
	}
	
	private int getLeft(int pos){
		return 2* pos+1;
	}
	
	private int getRight(int pos){
		return (2*pos)+1;
	}
	
	private boolean isLeaf(int pos){
		if(pos>=size/2 && pos < size){
			return true;
		}
		return false;
	}
	
	private void swap(Vertex u, Vertex v){
		Vertex temp;
		temp=u;
		u=v;
		v=temp;
	}
	
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
	public void restoreDown(int pos){
		Vertex v=minheap[pos];
		int left,right,min;
		int check=minheap[pos].getWeight();
		left=2*pos+1;
		right=left+1;
		while(right<size){
			if(minheap[left].getWeight()<minheap[right].getWeight()){
				min = left;
			}
			else{
				min = right;
			}
			if(check>minheap[min].getWeight()){
				minheap[pos]=minheap[min];
			}
			pos=min;
			left=2*pos+1;
			right=left+1;
		}
		//if number of nodes are even
		if(left==max_size){
			if(minheap[left].getLabel()<check){
				pos=left;
			}
		}
		//set the object that was passed at position pos of min heap
		
		//it attributes
		minheap[pos]=v;
		
		
	}
	
	public void BottomUp(int pos){
		int parent=(pos - 1)/2;
		Vertex v=minheap[pos];
		int check=v.getWeight();
		while(pos!=0){
			//System.out.println("loop"+ minheap[parent].getWeight() + minheap[pos].getWeight());
			
			if(minheap[parent].getWeight()>check){
				minheap[pos]=minheap[parent];
				pos=parent;
				parent=(pos - 1) /2;
			}
			else{
				System.out.println("else");
				break;
			}
		}
		minheap[pos]=v;
	}
	
	public void add(Vertex v){
		minheap[size++]=v;
		BottomUp(size-1);
	}
	
	public void decreaseKey(int pos,int newWeight){
			 minheap[pos].setWeight(newWeight);
		     BottomUp(pos);
	}
	
	public Vertex DeleteMin(){
		Vertex deleted=minheap[0];
		minheap[0]=minheap[size-1];
		size--;
		System.out.println("size is"+size);
		restoreDown(0);
		return deleted;
	}
	
	public int linearSearch(int label){
		
		for(int i=0;i<size;i++){
			if(minheap[i].getLabel()==label){
				return i;
			}
		}
		return -1;
		
	}
}
