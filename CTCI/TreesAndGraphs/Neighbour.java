//Neighbour : will have vertex, and weight of edge

public class Neighbour{
	int label;
	int weight;
	
	public Neighbour(int label, int weight){
		this.label = label;
		this.weight = weight;
	}

	public int getLabel(){
		return this.label;
	}
}