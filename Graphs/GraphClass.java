import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphClass {

    private int V;//number of vertices
    private  LinkedList<Integer> adj[];
    
  //constructor
   public GraphClass(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList();
		}				
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphClass g = new GraphClass(5);
		 
		    g.addEdge(0,1);
	        g.addEdge(0,3);
	        g.addEdge(1,2);
		    g.addEdge(1,3);
	        g.addEdge(3,4);
	        g.addEdge(4,1);
	        g.addEdge(4,2);
       

	        
	        
	        
	        
        for(int j=0;j<=4;j++){
        	Iterator<Integer> it=g.adj[j].listIterator();
        	while(it.hasNext()){
        		int nbg=it.next();
        		System.out.println("nbg of"+j+" is "+nbg);
        	}
        }
        
        
        System.out.println("Enter source from which you want BFS to begin");
		Scanner sc=new Scanner(System.in);
		int source=sc.nextInt();
		System.out.println("BFS is:");
		g.BFS(source);
		
		System.out.println("Enter source from which you want DFS to begin");
		int D_source=sc.nextInt();
		System.out.println("DFS is:");
		g.DFS(D_source);
		
		GraphClass g_inv = g.inverse();
//		g_inv.setV(g.getV());
		LinkedList<Integer>[] inverse_adj = g_inv.getList();
		for(int i = 0; i < g.getV(); i++){
        	Iterator it = inverse_adj[i].listIterator();
        	while(it.hasNext()){
        		System.out.println(i+ " " +it.next());
        	}
        }

	}
	
	
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public int getV(){
		return V;
	}
	
	public void setV(int v){
		this.setV(v);
	}
	
	public LinkedList<Integer>[] getList(){
		return adj;
	}
	
	public void setList(LinkedList<Integer>[] mylist){
		System.out.println("setting list");
		this.setList(mylist);
	}
	public void BFS(int s){
		Queue<Integer> queue= new LinkedList<Integer>();
		boolean visited[]=new boolean[V];
	//	Integer parent[]=new Integer[g.getV()];
	    queue.offer(s);
	    visited[s]=true;
	    while (queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			
			System.out.print(s+" ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int nbg = i.next();
				if (!visited[nbg])
				{				
					queue.offer(nbg);
					visited[nbg]=true;
				}
			}
		}
	    	
	    }
	
	public void DFS(int s){
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]= new boolean[V];
		stack.push(s);
		while(!stack.isEmpty()){
			int current=stack.pop();
		if(!visited[current]){
			visited[current]=true;
			System.out.println(""+current);
			Iterator<Integer> it=adj[current].listIterator();
			while(it.hasNext()){
				int nbg=it.next();
				stack.push(nbg);
			}
		}
		
		}
	}



public  GraphClass inverse(){
	GraphClass g_inv = new GraphClass(this.getV());
	LinkedList<Integer> inv_adj[] = new LinkedList[this.getV()];
	//g_inv.setV(5);
	for(int i = 0; i < this.getV(); i++){
		inv_adj[i]=new LinkedList();
	}
	
	for(int i = 0; i < this.getV(); i++){
		Iterator<Integer> it = this.adj[i].listIterator();
		//System.out.println("before iterator"+ it.hasNext());
		while(it.hasNext()){
			int v = it.next();
			inv_adj[v].add(i);
			//System.out.println(i+" added to"+ v);
			
		}
	}
	g_inv.adj = inv_adj;
	g_inv.V = this.getV();
//	this.setV(this.getV());
//	g_inv.setList(inv_adj);
	
	return g_inv;

	
}


}