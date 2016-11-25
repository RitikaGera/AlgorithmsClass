import java.util.*;

public class Edge{

	private int u;
	private int v;
	private int weight;

	public Edge(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;

	}

	public int getU(){
		return this.u;
	}

	public int getV(){
		return this.v;
	}

	public int getWeight(){
		return this.weight;
	}


}