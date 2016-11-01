
public class BSTInsertion {

	public static BinaryTreeNode bstInsert(BinaryTreeNode root,int data){//or pass obj and getdata
		BinaryTreeNode newBinaryTreeNode=new BinaryTreeNode(data);
		BinaryTreeNode temp=root;
		if(root==null){
			root=newBinaryTreeNode;
			return root;
		}
		if(data==temp.getData()){
			System.out.println("duplicate BinaryTreeNode");
			return root;
		}
		else if(data<temp.getData()){
			temp.setLeft(bstInsert(temp.getLeft(),data));
		}
		else if(data>temp.getData()){
			temp.setRight(bstInsert(temp.getRight(),data));
			}
		return root;
		
	}
}
