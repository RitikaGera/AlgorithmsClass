import java.util.*;

public class GraphEdgeList{

		
	public LinkedList<Edge> getGraph(){
		LinkedList<Edge> edgelist = new LinkedList<Edge>();

		Edge edge1 = new Edge(1,2,8);

		Edge edge2 = new Edge(2,3,7);
		
		Edge edge3 = new Edge(3,4,9);
		
		Edge edge4 = new Edge(4,5,10);
		
		Edge edge5 = new Edge(3,5,14);
		
		Edge edge6 = new Edge(2,5,4);
		
		Edge edge7 = new Edge(2,8,2);

		Edge edge8 = new Edge(1,7,11);

		Edge edge9 = new Edge(7,8,7);

		Edge edge10 = new Edge(6,7,1);
		
		Edge edge11 = new Edge(0,1,4);
		
		Edge edge12 = new Edge(0,7,8);
		
		Edge edge13 = new Edge(8,6,6);

		Edge edge14 = new Edge(6,5,2);

		edgelist.add(edge1);
		edgelist.add(edge2);
		edgelist.add(edge3);
		edgelist.add(edge4);
		edgelist.add(edge5);
		edgelist.add(edge6);
		edgelist.add(edge7);
		edgelist.add(edge8);
		edgelist.add(edge9);
		edgelist.add(edge10);
		edgelist.add(edge11);
		edgelist.add(edge12);
		edgelist.add(edge13);
		edgelist.add(edge14);
		return edgelist;
	}


}