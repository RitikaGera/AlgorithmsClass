
public class RBNode {

	private char color;//'r' 'b'
	private RBNode left;
	private RBNode right;
	private RBNode parent;
	private int data;
	
	public RBNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
		this.parent=null;
		this.color='r';
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public RBNode getLeft() {
		return left;
	}

	public void setLeft(RBNode left) {
		this.left = left;
	}

	public RBNode getRight() {
		return right;
	}

	public void setRight(RBNode right) {
		this.right = right;
	}

	public RBNode getParent() {
		return parent;
	}

	public void setParent(RBNode parent) {
		this.parent = parent;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public static boolean isLeftChild(RBNode parent, RBNode child){
		if(parent.getLeft()==child){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isRightChild(RBNode parent, RBNode child){
		if(parent.getRight()==child){
			return true;
		}
		else{
			return false;
		}
	}

	
}
