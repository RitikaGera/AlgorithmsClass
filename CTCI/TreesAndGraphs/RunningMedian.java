import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    int data;

	public Node(int data){
		this.data = data;	
	}
}

class MinHeap{    
    int maxsize;
    int size;
    Node[] minheap;
    
    public MinHeap(int max){
        this.size = 0;
        this.maxsize = max;
        this.minheap = new Node[max];
        
    }
    
    public int top(){
        return minheap[0].data;
    }
    
    void MinHeapInsert(Node node){
        minheap[size++] = node;
        bottomUp(minheap);
    }
    
    void bottomUp(Node[] minheap){
        int size = this.size;
        int childindex = size - 1;
        Node child = minheap[childindex];
        int parindex = (childindex - 1)/2;
        int data = minheap[childindex].data;
        while(childindex != 0){
            if( minheap[parindex].data > data){
                minheap[childindex] = minheap[parindex];
                childindex = parindex;
                parindex = (childindex - 1)/2;
            }
            else{
                break;
            }
            minheap[parindex] = child;
        }    
        }    
     void delete(){

    
        Node last = this.minheap[size - 1];
        size--;
        this.minheap[0] = last;
        restoreDown();
    }

    void restoreDown(){
       Node node = this.minheap[0];
       int pos = 0;
       int left = 2 * pos + 1;
       int right = left + 1;
       while(right < this.size){
        int min = (minheap[left].data < minheap[right].data)? left : right;
        if(minheap[min].data < node.data){
            minheap[pos] = minheap[min];
            pos = min;
            left = 2* pos + 1;
            right = left +1;     
        }
        else{
            break;
        }
       
       }
       if(left == size - 1){
            if(minheap[left].data < node.data){
               pos = left;
            }

       }
        minheap[pos] = node;
    }   
    void print(){
        for( int i = 0 ; i < this.size; i++){
            System.out.println("printing minheap ");
            System.out.println(this.minheap[i].data);
        }
    }
    
}

class MaxHeap{
    
    int maxsize;
    int size;
    Node[] maxheap;
    
    public MaxHeap(int max){
        this.size = 0;
        this.maxsize = max;
        this.maxheap = new Node[max];
        
    }
    
   public int top(){
    return maxheap[0].data;
   }
    
    void MaxHeapInsert(Node node){
        maxheap[size++] = node;
        System.out.println("calling bottom with heapsize "+ size);
        bottomUp(maxheap);
    }
    
    void bottomUp(Node[] maxheap){
        int size = this.size;
        int childindex = size - 1;
        Node child = maxheap[childindex];
        int parindex = (childindex - 1)/2;
        int data = maxheap[childindex].data;
        while(childindex != 0){
            if( maxheap[parindex].data < data){
                maxheap[childindex] = maxheap[parindex];
                childindex = parindex;
                parindex = (childindex - 1)/2;
            }
            else{
                break;
            }
            maxheap[parindex] = child;
        }    
        }    
       void print(){
            for( int i = 0 ; i < this.size; i++){
                System.out.println("printing maxheap ");
                System.out.println(this.maxheap[i].data);
            }
       }
    void delete(){

    
        Node last = this.maxheap[size - 1];
        size--;
        this.maxheap[0] = last;
        restoreDown();
    }

    void restoreDown(){
      Node node = this.maxheap[0];
       int pos = 0;
       int left = 2 * pos + 1;
       int right = left + 1;
       while(right < this.size){
        int min = (maxheap[left].data > maxheap[right].data)? left : right;
        if(maxheap[min].data > node.data){
            maxheap[pos] = maxheap[min];
            pos = min;
            left = 2* pos + 1;
            right = left +1;     
        }
        else{
            break;
        }
       
       }
       if(left == size - 1){
            if(maxheap[left].data < node.data){
               pos = left;
            }

       }
        maxheap[pos] = node;
    }
}

public class RunningMedian {
   
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap minheap = new MinHeap(n + 1);
        MaxHeap maxheap = new MaxHeap(n+ 1);
        int a = sc.nextInt();
        System.out.println(a);
        int b = sc.nextInt();
        System.out.println((double)(a + b)/2);

        
        if( a < b){
            maxheap.MaxHeapInsert(new Node(a));
            
            minheap.MinHeapInsert(new Node(b));
            
        }
        else{
            maxheap.MaxHeapInsert(new Node(b));
           
            minheap.MinHeapInsert(new Node(a));
            
        }
        
        for(int i=2; i < n; i++){
            int data = sc.nextInt();
            Node node = new Node(data);
            int comp = comp(minheap.size, maxheap.size);
            System.out.println("compcalc "+ comp);
            if( data < maxheap.top()){
                if(comp == 0 || comp == 1 ){
                    maxheap.MaxHeapInsert(node);
                }
                else{ //comp == -1, i.e. max heap is bigger and wuld get bigger by more than 1 element
                    int root = maxheap.top();
                    maxheap.delete();
                    minheap.MinHeapInsert(new Node(root));
                    maxheap.MaxHeapInsert(node);
                }
            }
            if( data > maxheap.top() ){
                if(comp == 0 || comp == -1 ){
                    minheap.MinHeapInsert(node);
                }
                else{ //comp == 1, i.e. min heap is bigger and wuld get bigger by more than 1 element
                    int root = minheap.top();
                    minheap.delete();
                    minheap.MinHeapInsert(new Node(root));
                    maxheap.MaxHeapInsert(node);
                }

            }
        }
            
        minheap.print();
        maxheap.print();
    }

    public static int comp( int a, int b){
        return (a - b);
    }
}
