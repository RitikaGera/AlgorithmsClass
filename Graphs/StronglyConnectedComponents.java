import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class StronglyConnectedComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphClass g = new GraphClass(5);
		g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
	    g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(4,1);
        g.addEdge(4,2);
        
        System.out.println("Enter source");
        Scanner sc = new Scanner(System.in);
        int source = sc.nextInt();
      
        
        int discovery_time[] = new int[g.getV()];
        int finish_time[] = new int[g.getV()];
        
    //  DFS(g,source) done and list formed in topological sort
        ArrayList<Integer> g_list = DFS.TopologicalSort(g, source , discovery_time, finish_time);//list of vertices in dec order of finishh time in DFS traversal
       
        boolean visited[] = new boolean[g.getV()];
        
        //initialising the resultant component list
        LinkedList<Integer>[] result = new LinkedList[g.getV()];
        for( int i = 0; i < g.getV(); i++){
        	result[i] = new LinkedList();
        }
        
        GraphClass g_inv =g.inverse();
        LinkedList<Integer>[] adj_list = g_inv.getList();
        
        for(int i = 0; i < g.getV(); i++){
        	Iterator it = adj_list[i].listIterator();
        	while(it.hasNext()){
        		System.out.println(i+" "+ it.next());
        	}
        }
     //   System.out.println(adj_list[2]);
        result = stronglyconnectedcompo(g_inv, 0, g_list, visited, result, adj_list);
     //   System.out.println(result[1]);
        
        //printing components
        System.out.println("printing components");
        for(int i = 0; i < g.getV(); i++){
        	Iterator it = result[i].listIterator();
        	while(it.hasNext()){
        		System.out.println(i+" "+ it.next());
        	}
        }

	}
	
	public static LinkedList<Integer>[] stronglyconnectedcompo(GraphClass g_inv, int i, ArrayList<Integer> graph_list, boolean visited[], LinkedList<Integer>[] result, LinkedList<Integer>[] adj_list ){
		
		if(i>g_inv.getV())
			return result;
		int head = graph_list.get(i);
		visited[head] = true;
	
		DFS(g_inv, head, visited, result);
		return stronglyconnectedcompo(g_inv, i, graph_list, visited, result, adj_list);
			
		
		 
		
		
	}

	
public static void DFS(GraphClass g, int s, boolean visited[],LinkedList<Integer>[] result){//only DFS no finish time
		
		Stack<Integer> stack=new Stack<Integer>();
		//visited[]= new boolean[g.getV()];
		stack.push(s);
		while(!stack.isEmpty()){
			int current=stack.pop();
			
			if(!visited[current]){
				visited[current]=true;
				System.out.println(""+current);
				result[s].add(current);
				Iterator<Integer> it=g.getList()[current].listIterator();
				while(it.hasNext()){
					int nbg=it.next();
					stack.push(nbg);
				}
			}
		
		}
	}

}
