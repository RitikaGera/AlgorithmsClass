//Making a graph
import java.util.Scanner;
import java.util.ArrayList;
public class Graph{

	int size;
	ArrayList<Vertex> vertexlist;
	
	public Graph(int size){
		this.size = size;
		this.vertexlist = new ArrayList<Vertex>();
		for( int i = 0; i < size; i++){
			this.vertexlist.add(new Vertex(i));
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		g.addEdge(0,1,1);
		g.addEdge(0,2,5);
		g.addEdge(1,3,4);
		g.addEdge(2,3,2);
		g.addEdge(2,1,6);
		g.addEdge(3,0,7);
	

	}

	public ArrayList<Vertex> getVertexList(){
		return this.vertexlist;
	}

	
	public void addEdge(int u, int v, int w ){
		Vertex a = this.getVertexList().get(u); // u is also the index
		a.getNeighbourList().add(new Neighbour( v, w));

	}
}
