import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphClass {

    private int V;
    public static LinkedList<Integer> adj[];
    
  //constructor
    GraphClass(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList();
		}				
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphClass g = new GraphClass(4);
		 
		    g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
       
		
        for(int j=0;j<4;j++){
        	Iterator<Integer> it=adj[j].listIterator();
        	while(it.hasNext()){
        		int nbg=it.next();
        		System.out.println("nbg of"+adj[j].getFirst()+" is "+nbg);
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
	}
	
	
	
	void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public int getV(){
		return V;
	}
	
	public LinkedList<Integer>[] getList(){
		return adj;
	}
	
	public void BFS(int s){
		Queue<Integer> queue= new LinkedList<Integer>();
		boolean visited[]=new boolean[V];
	//	Integer parent[]=new Integer[g.getV()];
	    queue.offer(s);
	    //parent[source]=-1;
	    while (queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			visited[s]=true;
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

}
