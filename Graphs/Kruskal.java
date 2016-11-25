//Kruskal's Algorithm
// Key points : Union and Find Operations
// Uses of Union and Find : detect cycles in path, find connected components
//Problems to do next : Panda and Combination, Monkey's birthday treat

import java.util.*;

public class Kruskal{

	private static int[] root = new int[9];
	private static int[] size = new int[9];
	
	public static void main(String args[]){
		GraphEdgeList graph = new GraphEdgeList();
		LinkedList<Edge> edgelist = graph.getGraph();
		Collections.sort(edgelist, new MyWeightCompare());
		for( Edge e : edgelist){
			System.out.println(e.getU()+" "+ e.getV()+" "+ e.getWeight());
		}
		//Kruskal k = new Kruskal();
	//	HashSet<Edge> hs = kruskal(edgelist);
		kruskal(edgelist);

		

	


	}

	public static HashSet<Edge> kruskal(LinkedList<Edge> edgelist){
		HashSet<Edge> hs = new HashSet<Edge>();
		initialize();
		for( Edge e : edgelist){
			int u = e.getU();
			int v = e.getV();
			int weight = e.getWeight();

			if( find(u,v) == false){
				System.out.println(u + ":"+v+":"+weight);
				weightedUnion(u,v);
				hs.add(e);
			}

		}
		Iterator<Edge> it = hs.iterator();
		System.out.println(hs);
		while(it.hasNext()){
			//System.out.println(it.next().getU() + " " + it.next().getV() + " " + it.next().getWeight());
			Edge e = it.next();
			System.out.println(e.getU()+ " " + e.getV() +" " + e.getWeight());
		}

		return hs;

	}

	public static void initialize(){
		for( int i = 0; i < root.length; i++){
				root[i] = i;
				size[i] = 1;
		}
	}

	public static int root(int i){
		
		while(root[i] != i){
			i = root[i];
		}
		return i;
	}

	public static boolean find(int u, int v){ // same component
		//System.out.println("u: "+ u + "v : "+v);
		if(root(u) == root(v)){
			return true;
		}
		
		return false;

	}

	public static void weightedUnion(int u, int v){
		int root_u = root(u);
		int root_v = root(v);
		if(size[root_u] < size[root_v]){// make root of v the root of u, since it is easier to change color of smaller compo
			root[root_u] = root[root_v];
			size[root_v] += size[root_u];
			
		}
		else{
			root[root_v] = root[root_u];
			size[root_u] += size[root_v];
			
		}

	}

	
}

class MyWeightCompare implements Comparator<Edge>{
	@Override
	public int compare(Edge e1, Edge e2){
		if(e1.getWeight() < e2.getWeight()){
			return -1; // increasing order
		}
		else if(e1.getWeight() == e2.getWeight()){
			return 0;
		}
		else{
			return 1;//e1 > e2
		}

	}


}