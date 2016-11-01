import java.util.*;

public class Vertex {
	
	
	private int label;
	private int weight;
	private char color;//green for unvisited, yellow in heap, blue for visited
	private Vertex parent;
	private LinkedList<Neighbour> neighbourList;
	
	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public Vertex(int label){
		this.setLabel(label);
		this.weight=Integer.MAX_VALUE;
		this.color='g';
		this.neighbourList=new LinkedList<Neighbour>();
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public LinkedList<Neighbour> getNeighbourList(){
		return neighbourList;
	}
	
	public int getLabel(){
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getColor(){
		return color;
	}
	
	public void setColor(char color){
		this.color=color;
	}
}
