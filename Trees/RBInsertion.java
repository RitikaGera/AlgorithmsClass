import java.util.Scanner;

public class RBInsertion {
	
	public static RBNode RBbstInsert(RBNode root, int data){//or pass obj and getdata
		
		RBNode temp=root;
		//System.out.println("root: "+ root);
		if(root==null){
			
			RBNode newNode=new RBNode(data);
			newNode.setParent(root);
			root=newNode;
			System.out.println("inside insertion vala"+root.getData());
			return root;
		}
		else if(data==temp.getData()){
			System.out.println("duplicate RBTreeNode");
			return root;
		}
		else if(data<temp.getData()){
			
			temp.setLeft(RBbstInsert(temp.getLeft(),data));
			
		}
		else if(data>temp.getData()){
			temp.setRight(RBbstInsert(temp.getRight(),data));
			}
	    System.out.println("temp:"+temp.getData());
		return root;
		
	}
	
	public static RBNode search(RBNode root, int data){
		if(root==null){
			System.out.println("Not found");
			return null;
		}
		if(root.getData()==data){
			return root;
		}
		else if(data<root.getData()){
			search(root.getLeft(),data );			
		}
		else if(data>root.getData()){
			search(root.getRight(),data);
		}
		return root;
		
	}
	
	
	//case 1 
	public static RBNode Insert_Case1(RBNode root, int data){
		RBbstInsert(root,data);
		RBNode x=search(root,data);
		if(x.getLeft()==null && x.getRight()==null){
			x.setColor('b');
			return root;
		}
		else if(x.getParent().getColor()=='b'){
			return root;			
		}
		else if(x.getParent().getColor()=='r'){
			RBNode uncle;
			if(RBNode.isLeftChild(x.getParent().getParent(), x.getParent())){
				uncle=x.getParent().getParent().getRight();
			}
			else{
				uncle=x.getParent().getParent().getLeft();
			}
			//case1 : uncle red 
			if(uncle.getColor()=='r'){
				uncle.setColor('b');
				x.getParent().setColor('b');
				x.getParent().getParent().setColor('r');
				
			}
			
		}
		
		return root;
	}
	
}
