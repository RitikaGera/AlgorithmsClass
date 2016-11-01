import java.util.*;

public class Graph {
	
	int size;
	ArrayList<Vertex> vertexList=new ArrayList<Vertex>();
	
	public Graph(int s_user){
		this.size=s_user;
		for(int i = 0; i<size;i++){
			Vertex v=new Vertex(i);
			vertexList.add(v);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		Graph g=new Graph(size);//enter 5 for this graph, no of vertices
		
		g.addEdge(0,1,3);
		g.addEdge(0,3,4);
		g.addEdge(1,2,9);
		g.addEdge(1,3,2);
		g.addEdge(3,4,6);
		g.addEdge(4,2,1);
		g.addEdge(4,1,3);
		
		
		
	}
	
	public void addEdge(int u, int v, int w){
		Neighbour neighbour=new Neighbour(v,w);
		vertexList.get(u).getNeighbourList().add(neighbour);
		
	}
	
	public ArrayList<Vertex> getVertexList(){
		return vertexList;
	}

}
