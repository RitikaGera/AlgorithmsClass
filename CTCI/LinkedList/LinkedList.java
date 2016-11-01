package LinkedList;

public class LinkedList{
	

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
			public String toString(Node n){
				String s=" "+n.getData();
				return s;
				
			}
			
			
		
	}

	public Node start,end;
	private int size;
	
	public LinkedList()
	{
		start=null;
		end=null;
		size=0;
	}
	
	public boolean isEmpty()
	{
		return start==null;
	}

	public int size()
	{
		return size;//else count elements of list(primitive)
	}

	public void insert(int data, int pos){
		
		Node newNode=new Node(data);
		Node ptr=start;
		
		if(pos>size){
			System.out.println("List aint so long");
			return;
		}
		
		if(pos<=0){
			newNode.setLink(start);
			start=newNode;
			if(ptr==null)
				end=newNode;
			return;
		}
		
		int count=0;
		while(ptr.link!=null&&count<pos){
			
			if(count==pos-1){
				newNode.link=ptr.link;
				ptr.link=newNode;
			}
			ptr=ptr.link;
			count++;
		}
		
	}
	public void append(int data){
		Node newNode=new Node(data);
		if(end==null){
			start=newNode;
			end=newNode;
			size++;
			return;
		}
		end.setLink(newNode);
		end=newNode;
		size++;
		
	}
	
	public void remove(int pos){
		
		Node ptr=start;
		if(pos>size){
			System.out.println("Node doesnt exist");
		}
		for(int i=0;i<pos-1;i++){
			
			ptr=ptr.link;
		}
		
		ptr.link=ptr.link.link;
	}
	
	public int find(int data){//return position
		Node ptr=start;
		for(int i=0;i<size && ptr!=null;i++){
			if(ptr.data==data){
				return i;
			}
			ptr=ptr.link;
		}
		return -1;
		
	}
	
	public void clear(){
		start=null;
		end=null;
		size=0;
	}
	
	public String toString(){
		Node ptr=start;
		String s="";
		while(ptr!=null){
			s=s+ptr.getData()+" ";
			ptr=ptr.getLink();
		}
		return s;
	}
	
	
}