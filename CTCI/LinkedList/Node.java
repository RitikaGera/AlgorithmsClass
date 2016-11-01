package LinkedList;

public class Node {
	    int  data;
		Node link;
		
		public Node(int data)
		{
			this.data=data;
			this.link=null;
		}
		
		
		public void setLink(Node n)
		{
			link=n;
		}
		
		public void setData(int d)
		{
			data=d;
		}
		
		public Node getLink()
		{
			return link;
		}
		public int getData(){
			return data;
		}
		
		
		
	
}
