package ds_Project;

public class BSTNode {
	public String key; 
	public LinkedList<Integer> value;
	public BSTNode left , right ; 
	
	public BSTNode(String k ,LinkedList<Integer> Value ) {
		 key = k; 
		value = Value; 
		left = right = null; 
		
		
	}
	public BSTNode(String k ,LinkedList<Integer> Value, BSTNode l , BSTNode r ) {
		 key = k; 
		value = Value; 
		left = l ; 
		right = r; 
		
		
	}

}
