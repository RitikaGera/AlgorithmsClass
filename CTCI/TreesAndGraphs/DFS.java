//DFS

import java.util.*;

public class DFS{
	
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
	//	g.addEdge(3,0,7);


		System.out.println("From which vertex should DFS start");
		int source = sc.nextInt();
	//	DFS(g, source);
		boolean[] visited = new boolean[g.size];
	//	DFS_Recursive(g, source, visited);
		Topological_Sort(g);
	}

	public static void DFS(Graph g, int s){
		Stack<Vertex> stack = new Stack<Vertex>();
		ArrayList<Vertex> vertexlist = g.getVertexList();
		boolean[] visited = new boolean[g.size];
		Vertex source = vertexlist.get(s);
		stack.push(source);
		while(! stack.isEmpty()){
			Vertex popped = stack.pop();
			if(visited[popped.getLabel()] == false){
				visited[popped.getLabel()] = true;
				System.out.println(popped.getLabel());
				Iterator<Neighbour> it = popped.getNeighbourList().iterator();
				while(it.hasNext()){
					Vertex nbgh = vertexlist.get(it.next().getLabel());
					stack.push(nbgh);
				}

			}
		}
	}

	public static void DFS_Recursive(Graph g, int s, boolean[] visited){
		Vertex v = g.getVertexList().get(s);
		System.out.println(v.getLabel());
		visited[v.getLabel()] = true;
		ArrayList<Neighbour> nbgh = v.getNeighbourList();
		Iterator<Neighbour> it = nbgh.iterator();
		while(it.hasNext()){
			Neighbour  b = it.next();
			if( visited[b.getLabel()] == false){
				DFS_Recursive(g, b.getLabel(), visited);	
			}
		}
		
	}

	public static void Topological_Sort(Graph g){
		boolean[] visited = new boolean[g.size];
		for( int i = 0; i < g.size; i++){
			visited[i] = false;
		}
		Stack<Vertex> s = new Stack<Vertex>();
		int count = 0;
		for( int i = 0; i < g.size; i++){
			if(visited[i] == false){
				Topological_Sort_Util(s, g, visited, i, count);
			}
		}
		while(! s.isEmpty()){
			System.out.println("t " + s.pop().getLabel());
		}

	}

	public static void Topological_Sort_Util(Stack<Vertex> s, Graph g, boolean[] visited, int i, int count){
		if(count == g.size){
			return;
		}
		//mark it visited the first time you see it, put it in the stack only when you have seen all its adjacents

		visited[i] = true;
		Iterator<Neighbour> it = g.getVertexList().get(i).getNeighbourList().iterator();
		while(it.hasNext()){
			Neighbour n = it.next();
			if(visited[n.getLabel()] == false){
				Topological_Sort_Util(s, g, visited, n.getLabel(), count);	
			}
			
		}
		
		s.push(g.getVertexList().get(i));
		count++;


	}

}