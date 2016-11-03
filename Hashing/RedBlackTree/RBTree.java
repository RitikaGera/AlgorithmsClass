
public class RBTree {

	
    public static void LeftRotate(RedBlackNode root,RedBlackNode x){
    	RedBlackNode y = x.getRight();
    	x.setRight(y.getLeft());
    	if(y.getLeft() != null){
    		y.getLeft().setParent(x);
    	}
    	y.setParent(x.getParent());
    	if(x.getParent() == null){
    		root = y;
    	}
    	else if(x.getParent().getLeft() == x){
    		x.getParent().setLeft(y);
    	}
    	else if(x.getParent().getRight() == x){
    		x.getParent().setRight(x);
    	}
    	y.setLeft(x);
    	x.setParent(y);
    }
    
    public static void RightRotate(RedBlackNode root, RedBlackNode y){
    	RedBlackNode x = y.getLeft();
    	y.setLeft(x.getRight());
    	if(x.getRight() != null){
    		x.getRight().setParent(y);
    	}
    	x.setParent(y.getParent());
    	if(y.getParent() == null){
    		root = x;
    	}
    	else if(y.getParent().getLeft() == y){
    		y.getParent().setLeft(x);
    	}
    	else if(y.getParent().getRight() == y){
    		y.getParent().setRight(x);
    	}
    	x.setRight(y);
    	y.setParent(x);
    }
    
    public static RedBlackNode Insertion(RedBlackNode root, RedBlackNode z){ // z is node to be inserted
    	RedBlackNode x = root;//holds root since x changes
    	RedBlackNode y = null; // becomes parent to incoming node
    	if(root == null && z !=null){
    		root = z;
    		root.setColor(1);
    	}
    	while(x != null){
    		y = x;
    		if(z.getData() < x.getData() ){
    			x = x.getLeft();
    		}
    		else{
    			x = x.getRight();//if x is present it goes to right duplicates are accepted
    		}
    	}
    	z.setParent(y);
    	if( y == null){
    		root = z;
    	}
    	else if( z.getData() < y.getData()){
    		y.setLeft(z);
    	}
    	else{
    		y.setRight(z);
    	}
    /*	z.setLeft(null);
    	z.setRight(null);
    	z.setColor(0);
    	*/
    	RBTreeInsertionFixUp(root, z);
    	//root.setColor(1);
    	return root;
    	
    }
    
    public static void RBTreeInsertionFixUp(RedBlackNode root, RedBlackNode z){
    	RedBlackNode y = null;
    	
    	while( z.getParent() != null && z.getParent().getColor() != 1){
    		if(z.getParent().getParent() != null && z.getParent().getParent().getLeft() == z.getParent()){//parent is left child of its parent, uncle is right
    			y = z.getParent().getParent().getRight();// uncle
    			if(y == null){
    				y = new RedBlackNode(-1);
    				y.setColor(1);
    			}
    			if(y.getColor() == 0){// case 1 uncle is red : make parent and uncle black and grandparent red
    				y.setColor(1);
    				z.getParent().setColor(1);
    				z.getParent().getParent().setColor(1);
    				z = z.getParent().getParent();
    				
    			}
    			else{// uncle is black case 2 0r 3
    				if(z.getParent().getRight() == z){//now z ka parent is left child of its parent so z should be left child for case3 and right for case2
    					z = z.getParent();
    					LeftRotate(root, z);//resulting tree is case 3
    				}
    				z.getParent().setColor(1); 
    				z.getParent().getParent().setColor(0);
    				RightRotate(root,z.getParent().getParent());
    				}
    			}
    		
    		else if(z.getParent().getParent() != null && z.getParent().getParent().getRight() == z.getParent()){ //parent is right child of its parent 
    			y = z.getParent().getParent().getLeft();//uncle
    			if(y == null){
    				y = new RedBlackNode(-1);
    				y.setColor(1);
    			}
    			if(y.getColor() == 0){// case 1 uncle is red : make parent and uncle black and grandparent red
    				y.setColor(1);
    				z.getParent().setColor(1);
    				z.getParent().getParent().setColor(1);
    				z = z.getParent().getParent();    				
    			}
    			else{
    				if(z.getParent().getLeft() == z){//parent is right child of its parent, so z should be left for case2 and right for case3
    					z = z.getParent();//case2
    					RightRotate(root, z);
    				}
    				z.getParent().setColor(1);
    				z.getParent().getParent().setColor(0);
    				LeftRotate(root,z.getParent().getParent());
    			}
    			
    		}
    		
    		else{
    			z.getParent().setColor(1);
    			
    		}
    		
    			
    		}
    	}
    public static void main(String[] args){
    	RedBlackNode root = null;
    	RedBlackNode newNode = new RedBlackNode(10);
    	root = Insertion(root,newNode);
    	System.out.println("10:" + root.getColor());
    	RBLevelOrder.LevelOrderTraversal(root);
    	
    	RedBlackNode newNode1 = new RedBlackNode(5);
    	root = Insertion(root,newNode1);
    	System.out.println("10:" + root.getColor());
    	RBLevelOrder.LevelOrderTraversal(root);
    	
    	RedBlackNode newNode3 = new RedBlackNode(0);
    	root = Insertion(root,newNode3);
    	System.out.println("10:" + root.getColor());
    	RBLevelOrder.LevelOrderTraversal(root);
    	
    	
    	
    	    }
    }
    

