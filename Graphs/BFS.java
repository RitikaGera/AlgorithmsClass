import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphClass g=new GraphClass(5);
	    g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
	    g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(4,1);
        g.addEdge(4,2);
		System.out.println("Enter source from which you want BFS to begin");
		Scanner sc=new Scanner(System.in);
		int source=sc.nextInt();
		BFS(g,source);
	}
	
	public static void BFS(GraphClass g,int s){
		Queue<Integer> queue= new LinkedList<Integer>();
		boolean visited[]=new boolean[g.getV()];
	//	Integer parent[]=new Integer[g.getV()];
	    queue.offer(s);
	    visited[s]=true;
	    //parent[source]=-1;
	    while (!queue.isEmpty())
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s+" ");
		//	visited[s]=true;

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			
		//	Iterator<Integer> j=check.listIterator();
			Iterator<Integer> i = g.getList()[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				//System.out.println(""+ s+" "+n);
				if (!visited[n])
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	    	
	    }
	}
	


