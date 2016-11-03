
public class RedBlackNode {

	private int color; 
	private RedBlackNode left;
	private RedBlackNode right;
	private RedBlackNode parent;
	private int data;
	
	public RedBlackNode(int data){
		this(data, null, null);//calling below contructor, when nothing specificied about l-r
	}
	public RedBlackNode(int data, RedBlackNode left, RedBlackNode right){
		this.data=data;
		this.left=left;
		this.right=right;
		this.color= 0;//Red
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public RedBlackNode getLeft() {
		return left;
	}

	public void setLeft(RedBlackNode left) {
		this.left = left;
	}

	public RedBlackNode getRight() {
		return right;
	}

	public void setRight(RedBlackNode right) {
		this.right = right;
	}

	public RedBlackNode getParent() {
		return parent;
	}

	public void setParent(RedBlackNode parent) {
		this.parent = parent;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public static boolean isLeftChild(RedBlackNode parent, RedBlackNode child){
		if(parent.getLeft()==child){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean isRightChild(RedBlackNode parent, RedBlackNode child){
		if(parent.getRight()==child){
			return true;
		}
		else{
			return false;
		}
	}

	
}
