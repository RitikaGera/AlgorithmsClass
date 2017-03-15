// Binary Search Tree

import java.util.Scanner;

public class BinarySearchTree{
	BinaryTreeNode root;
	int size;

	public BinarySearchTree(){
		root = null;
		size = 0;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int size = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		//System.out.println(bst.root);
		for( int i = 0; i < size; i++){
			int data = sc.nextInt();
			bst.insert(data);
		}
		System.out.println("InOrderTraversal");
		bst.InOrderTraversal(bst.root);
		System.out.println("searching");
		BinaryTreeNode node = bst.search(bst.root, 1);
		System.out.println(node + " "+ node.getData());
		System.out.println("deleting");
		BinaryTreeNode root_after_deletion = bst.deleteKey(2);
		System.out.println(root_after_deletion.getData());
		bst.InOrderTraversal(bst.root);
	}

	public void insert(int data){
		this.root = this.insert_rec(this.root, data);
	}
	public BinaryTreeNode insert_rec(BinaryTreeNode root, int data){
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		BinaryTreeNode temp = root;
		if( temp == null){
			temp = newNode;
			if( this.size == 0){
				this.size++;
				root = newNode;
				return root;
			}
			this.size++;
			return temp;
		}
		if( data == temp.getData()){
			System.out.println("duplicate value");

		}
		if(  data < temp.getData()){
			
			temp.setLeft(insert_rec(temp.getLeft(), data));
		}
		else{
			
			temp.setRight(insert_rec(temp.getRight(), data));
		}
		return root;
	}

	public BinaryTreeNode getRoot(){
		return this.root;
	}

	public void LevelOrderTraversal(BinaryTreeNode root){
		BinaryTreeNode temp = root;
		System.out.println(root.getData());
		LevelOrderTraversal(root.getLeft());
		LevelOrderTraversal(root.getRight());
	}

	public void InOrderTraversal(BinaryTreeNode root){
		if( root == null){	
			return;
		}
		InOrderTraversal(root.getLeft());
		System.out.println(root.getData());
		InOrderTraversal(root.getRight());
	}
	public void PreOrderTraversal(BinaryTreeNode root){
		if( root == null){	
			return;
		}
		System.out.println(root.getData());
		PreOrderTraversal(root.getLeft());
		PreOrderTraversal(root.getRight());
	}
	public void PostOrderTraversal(BinaryTreeNode root){
		if( root == null){	
			return;
		}

		PostOrderTraversal(root.getLeft());
		PostOrderTraversal(root.getRight());
		System.out.println(root.getData());
	}

	public BinaryTreeNode deleteKey( int data){
		this.root = delete(this.root, data);
		return root;
	}

	public BinaryTreeNode delete(BinaryTreeNode root, int data){
		if( root == null ){
			return null;
		}
		
		if( data < root.getData()){
			root.setLeft(delete(root.getLeft(), data));
		}
		
		if( data > root.getData()){
			root.setRight(delete(root.getRight(), data));
		}
		
		if( data == root.getData()){
			if( root.getLeft() == null){
				return root.getRight(); // works even if right is null
			}
			else if( root.getRight() == null){
				return root.getLeft();
			}
			else{ // both not null
				System.out.println("succ is :" + this.inorder_successor(root).getData());
				root.setData(this.inorder_successor(root).getData());
				System.out.println("root"+ root.getData());
				root.setRight(delete( root.right, root.getData()));
			}
			
		}
		return root;
	}

	public BinaryTreeNode search( BinaryTreeNode root, int data){
		BinaryTreeNode temp = root;
		if( root == null){
			System.out.println("not found");
			return null;
		}
		if( data == temp.getData()){
			return temp;
		}
		if( data < temp.getData()){
			return search(temp.getLeft(), data);
		}
		else{
			return search(temp.getRight(), data);
		}
		
	}

	public BinaryTreeNode inorder_successor(BinaryTreeNode node){
		BinaryTreeNode temp = node.getRight();
		BinaryTreeNode temp1 = temp;

		while(temp !=  null){
			temp1 = temp;
			temp = temp.getLeft();
		}

		return temp1;
	}

}