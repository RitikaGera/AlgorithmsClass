// Class Vertex
import java.util.ArrayList;

public class Vertex{
	int label;
	ArrayList<Neighbour> neighbourlist;
	
	public Vertex( int label){
		this.label = label;
		neighbourlist = new ArrayList<Neighbour>();
	}

	public ArrayList<Neighbour> getNeighbourList(){
		return this.neighbourlist;
	}

	public int getLabel(){
		return this.label;
	}
}
