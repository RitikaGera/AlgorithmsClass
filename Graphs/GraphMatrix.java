public class GraphMatrix{

	int size;
	public static int[][] makegraph(int size){
		 int[][] graph = new int[size][size];
		
		 for( int i = 0; i< size; i++){
		 	for( int j = 0; j < size; j++){
		 		if( i == j){
		 			graph[i][j] = 0;
		 		
		 		}
		 		else{
		 			graph[i][j] = Integer.MAX_VALUE;
		 		}
		 	}
		 }

		 //here go your edge weights
		graph[0][1] = 4;
		graph[0][7] = 4;
		graph[0][6] = 7;
		graph[1][2] = 9;
		graph[1][7] = 1;
		graph[1][5] = 6;
		graph[1][6] = 8;
		graph[2][4] = 10;
		graph[4][3] = 6;
		graph[4][2] = 8;
		graph[4][5] = 5;
		graph[5][4] = 6;
		graph[6][5] = 7;
		graph[6][1] = 4;
		graph[7][2] = 3;

		return graph;

	}






}