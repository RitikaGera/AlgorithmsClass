//BFS

import java.util.Scanner;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class BFS{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		g.addEdge(0,1,1);
		g.addEdge(0,2,5);	
		g.addEdge(1,3,4);
		g.addEdge(1,4,5);
		g.addEdge(2,3,2);
		g.addEdge(2,1,6);
		g.addEdge(3,0,7);


		System.out.println("From which vertex should BFS start");
		int source = sc.nextInt();
		BFS(g, source);

	}

	public static void BFS(Graph g, int source){
		Queue<Vertex> queue = new LinkedList<Vertex>();
		boolean[] visited = new boolean[g.size];
		queue.offer(g.getVertexList().get(source)) ;
		visited[source] = true;
		while(! queue.isEmpty()){
			Vertex popped = queue.poll();
			System.out.println(popped.getLabel());
			ArrayList<Neighbour> neighbourlist = popped.getNeighbourList();
		//	System.out.println(neighbourlist.size() + "size");
			Iterator<Neighbour> it = neighbourlist.iterator();
			while(it.hasNext()){
				Neighbour neighbour = it.next();
				if( visited[neighbour.getLabel()] == false){
					queue.offer(g.getVertexList().get(neighbour.getLabel()));
					visited[neighbour.getLabel()] = true;
				}
				
			}
		}


	}
}
