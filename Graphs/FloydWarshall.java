import java.util.*;

public class FloydWarshall{

public static void main(String[] args){
	GraphMatrix gmat = new GraphMatrix();
	int[][] graph = gmat.makegraph(8);
	int[][] dist = floyd(graph);
	print(dist);


}


	public static int[][] floyd(int[][] graph){
		int[][] dist = new int[graph.length][graph.length];
		for( int i = 0; i < graph.length; i++){
				for( int j = 0; j < graph.length; j++){
					dist[i][j] = graph[i][j];
					System.out.println("dis["+i+"]"+"["+ j +"] is "+ dist[i][j]);
				}
				System.out.println();
				
			}

		for( int k = 1; k < dist.length; k++){
			for( int i = 0; i < dist.length; i++){
				for( int j = 0; j < dist.length; j++){
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
							continue;
					}
					if(dist[i][j]  > dist[i][k] + dist[k][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
						System.out.println("graph[i][j] "+ dist[i][j]);
						
					}
				}
			}
		}
		return dist;

	}



public static void print(int[][] dist){
			for( int i = 0; i < dist.length; i++){
				for( int j = 0; j < dist.length; j++){
					System.out.println("distance from "+ i +" to "+ j+ " is : "+ dist[i][j]+" ");
				}
				System.out.println();
				
			}
		}



}