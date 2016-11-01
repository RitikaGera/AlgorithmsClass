import java.util.Iterator;
import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph graph=new Graph(5);//enter 5 for this graph, no of vertices
		
		graph.addEdge(0,1,3);
		graph.addEdge(0,3,4);
		graph.addEdge(1,2,9);
		graph.addEdge(1,3,2);
		graph.addEdge(3,4,6);
		graph.addEdge(4,2,1);
		graph.addEdge(4,1,3);
		
		System.out.println("Enter source");
		Scanner sc=new Scanner(System.in);
		int source=sc.nextInt();
		
		dijkstra(graph, source);
		print(graph);
	}
	private static void dijkstra(Graph graph, int source) {
		// TODO Auto-generated method stub
		graph.getVertexList().get(source).setWeight(0);
		Heap minheap=new Heap(5);
		Vertex s=graph.getVertexList().get(source);
		s.setColor('y');
		minheap.add(s);
		while(!minheap.isEmpty()){
			s=minheap.DeleteMin();
			s.setColor('b');
			Iterator<Neighbour> it=graph.getVertexList().get(s.getLabel()).getNeighbourList().listIterator();
			while(it.hasNext()){
				Neighbour nbg = it.next();
				Vertex vertex_in_list=graph.getVertexList().get(nbg.getLabel());
				if(vertex_in_list.getColor()=='g'){
					vertex_in_list.setWeight(s.getWeight()+nbg.getEdgeweight());
					vertex_in_list.setColor('y');
					vertex_in_list.setParent(s);
					minheap.add(vertex_in_list);
				}
				else if(vertex_in_list.getColor()=='y'){
					if(vertex_in_list.getWeight() > s.getWeight()+nbg.getEdgeweight()){
						vertex_in_list.setWeight(s.getWeight()+nbg.getEdgeweight());
						vertex_in_list.setParent(s);
						//get pos by linear search
						int pos=minheap.linearSearch(vertex_in_list.getLabel());
						minheap.decreaseKey(pos, vertex_in_list.getWeight());
					
					}
				}
						
			}
		}
		
		
		
	}
	public static void print(Graph graph){
		for(Vertex v : graph.getVertexList() ){
			System.out.println(""+v.getLabel()+" "+v.getWeight());
		}
	}
	

}
