import java.util.*;

public class BellmanFord{
	public static void main(String[] args){
		Graph graph=new Graph(8);

		graph.addEdge(0,1,8);
		graph.addEdge(0,4,6);
		graph.addEdge(1,2,6);
		graph.addEdge(2,7,4);
		graph.addEdge(3,1,2);
		graph.addEdge(4,5,3);
		graph.addEdge(4,6,2);
		graph.addEdge(5,6,6);
		graph.addEdge(6,2,-1);
		graph.addEdge(6,3,-1);
		graph.addEdge(7,6,-7);

		Graph g=new Graph(5);//enter 5 for this graph, no of vertices
		
		g.addEdge(0,1,3);
		g.addEdge(0,3,4);
		g.addEdge(1,2,9);
		g.addEdge(1,3,2);
		g.addEdge(3,4,6);
		g.addEdge(4,2,1);
		g.addEdge(4,1,3);

		System.out.println("Enter source");
		Scanner sc=new Scanner(System.in);
		int source=sc.nextInt();

		
		boolean result = bellmanFord(g, source);
		if(result == true){
			print(g);
		}
		else{
			System.out.println("negative cycle");
		}


	}

	public static boolean bellmanFord(Graph graph, int source){
		graph.getVertexList().get(source).setWeight(0);
		for( int i = 0; i < graph.size - 1; i++){
			for( int j = 0; j < graph.size; j++){
				LinkedList<Neighbour> neighbourList= graph.getVertexList().get(j).getNeighbourList();
				for(int k  = 0; k< neighbourList.size(); k++){
					Iterator<Neighbour> it = neighbourList.listIterator();
					while(it.hasNext()){
						Neighbour current = it.next();
						int index = current.getLabel();
						if(graph.getVertexList().get(j).getWeight() == Integer.MAX_VALUE){
							continue;
						}
						if(graph.getVertexList().get(j).getWeight() + current.getEdgeweight() < graph.getVertexList().get(index).getWeight()){
							graph.getVertexList().get(index).setWeight(graph.getVertexList().get(j).getWeight() + current.getEdgeweight());
							System.out.println("weight "+ graph.getVertexList().get(index).getWeight());
						}
					}
					
				}
			}
		}

		for( int j = 0; j < graph.size; j++){
				LinkedList<Neighbour> neighbourList= graph.getVertexList().get(j).getNeighbourList();
				for(int k  = 0; k< neighbourList.size(); k++){
					Iterator<Neighbour> it = neighbourList.listIterator();
					while(it.hasNext()){
						Neighbour current = it.next();
						int index = current.getLabel();
						if(graph.getVertexList().get(j).getWeight() + current.getEdgeweight() < graph.getVertexList().get(index).getWeight()){
							return false;

						}
					}
					
				}
			}

			return true;



	}


	public static void print(Graph graph){
			for(Vertex v : graph.getVertexList() ){
				System.out.println(""+v.getLabel()+" "+v.getWeight());
			}
		}


}