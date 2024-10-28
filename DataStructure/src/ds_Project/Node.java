package ds_Project;

public class Node<T> {
	public T data; 
	public Node<T> next ;
	public LinkedList<T> insideList = new LinkedList<T>(); 
	
	public Node(T data, LinkedList<T> list ) {
		this.data = data; 
		next = null ; 
		insideList = list ; 
	}
	
	public Node(T data){
		this.data = data; 
		next = null ; 
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
	

}
