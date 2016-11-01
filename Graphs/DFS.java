import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	

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
		System.out.println("Enter source from which you want DFS to begin");
		Scanner sc=new Scanner(System.in);
		int source=sc.nextInt();
		int discovery_time[]= new int[g.getV()];
		int finish_time[] = new int[g.getV()];
		System.out.println("DFS is :");
		DFS(g,source);
		System.out.println("*************");
		
		GraphClass g1=new GraphClass(5);
	    g1.addEdge(0,1);
        g1.addEdge(0,3);
        g1.addEdge(1,2);
	    g1.addEdge(1,3);
        g1.addEdge(3,4);
        g1.addEdge(4,1);
        g1.addEdge(4,2);
		
        ArrayList<Integer> topologicallysorted= TopologicalSort(g1, source, discovery_time, finish_time);
        
		for(int i = 0; i<g1.getV(); i++){
			System.out.println("discovery time of "+ i +" is : "+ discovery_time[i]);
			System.out.println("finish time of " + i + "is : "+ finish_time[i]);
		}
		
		System.out.println("topological sort yields");
		
		for(int i=0; i < g1.getV(); i++){
			System.out.println(topologicallysorted.get(i));
		}
		
		recursive_DFS(g, source);
		
		

	}

	public static void DFS(GraphClass g, int s){//only DFS no finish time
		
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]= new boolean[g.getV()];
		stack.push(s);
		while(!stack.isEmpty()){
			int current=stack.pop();
			
			if(!visited[current]){
				visited[current]=true;
				System.out.println(""+current);
				Iterator<Integer> it=g.getList()[current].listIterator();
				while(it.hasNext()){
					int nbg=it.next();
					stack.push(nbg);
				}
			}
		
		}
	}
	
	public static ArrayList<Integer> TopologicalSort(GraphClass g,int s, int discovery_time[], int finish_time[]){//finish time with DFS, returns a list of vertices in decreasing order of fininsh time
		ArrayList<Integer> topological=new ArrayList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]= new boolean[g.getV()];
		stack.push(s);
		
		int time=0;
		while(!stack.isEmpty()){
			int current=stack.pop();
			if(visited[current]==false){
				stack.push(current);
			//	System.out.println("pushed is"+ current);
			}
			if(!visited[current]){
				visited[current]=true;
				time=time+1;
				discovery_time[current]=time;
			//	System.out.println("discovered is "+current);
				Iterator<Integer> it=g.getList()[current].listIterator();
				while(it.hasNext()){
					int nbg=it.next();
					if(visited[nbg]==false)
						stack.push(nbg);
				}
			}
			else{
				 if(finish_time[current] == 0){
					time=time + 1;
					finish_time[current]=time;
					topological.add(0,current);
				//	System.out.println("now added is :"+ topological.get(0));
					
				}
			}
		
		}
		return topological;
	}
	
	public static void recursive_DFS(GraphClass g, int s){
		int time=0;
		boolean visited[] = new boolean[g.getV()];
		int parent[] = new int[g.getV()];
		int discovery_time[]= new int[g.getV()];
		int finish_time[]= new int[g.getV()];
		for(int i=0 ; i < g.getV() ; i++){
			visited[i] = false;
			parent[i]=-1;
		}
		System.out.println("Calling DFS Visit");
		DFS_Visit(g, s, visited,discovery_time, finish_time, time, parent);
		for(int i = 0; i < g.getV(); i++){
			System.out.println(i+"  dtime:"+ discovery_time[i]+"ftime: "+ finish_time[i]);
		}
		 
	}
	
	public static void DFS_Visit(GraphClass g, int u, boolean visited[], int[] discovery_time, int[] finish_time, int time, int parent[]){
	    time = time + 1;
		visited[u] = true;
		discovery_time[u]=time;
		System.out.println("discovered"+u);
		System.out.println("discovery of "+u+" :"+ time);
		
		Iterator<Integer> it=g.getList()[u].listIterator();
		
		while(it.hasNext()){
			int v = it.next();
			if(visited[v] == false){
				parent[v] = u;
				DFS_Visit(g, v, visited, discovery_time, finish_time, time, parent);
				//time passed is wrong here because neeche vali 2 statements wont be taken in account
				
			}
		}
		time = time + 1;
		finish_time[u] = time;
		System.out.println("finish of "+u+" :"+ time);
		
		
	}

}
