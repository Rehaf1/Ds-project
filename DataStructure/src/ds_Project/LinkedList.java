package ds_Project;

public class LinkedList<T>{
	private Node<T> head;
	private Node<T> current ; 
	
	public LinkedList() {
		head = current = null; 
	}
	public boolean isEmpty() {
		 return head == null; 
	}
	
	 public boolean isLast() {
		  return current.next == null; 
	 }
	 public boolean isFull() {
		 return false; 
	 }
	 
	 public void findFirst() {
		 current = head ; 
	 }
	 
	 public void findNext() { 
		 current = current.next; 
	 }
	 public T retrive() { 
		  return current.data; 
	 }
	 public void update(T e) { 
		 current.data= e; 
	 }
	 
	 public void insert(T element) { 
		 Node<T> temp ;
		 
		 if(head == null)
			 head = current = new Node<T>(element) ; 
		 
		 else {
			
		 temp = new Node<T>(element);
		 current.next = temp; 
	     current = current.next;
		 } 
		 }
	 
	 
	 
	 public void remove() {
		 if (current == head)
			 head = head.next ; 
		 else { 
			 Node<T> prev = head  ;
			 
			 while (prev.next != current)
				 prev = prev.next ; 
			 
			 prev.next = current.next ; 
			 
			 if (prev.next == null)
				 current = head; 
			 else 
				 current = current.next ; 
		 }
	 }
	 
	 public int size() {
		 int count = 0 ; 
		 Node current = head;
	        while (current != null) {
	        	count++; 
	        	current = current.next; 
	        }
	        return count; 
	 }
	 
	 
	 
	 
	 public void print() {
		    Node<T> current = head;
		    while (current != null) {
		        System.out.println(current.data); 
		        current = current.next;
		    }
		}

	 public void printInner(LinkedList<T> l) {
		 if (!l.isEmpty())
               l.findFirst(); 
		      while(!l.isLast()) {
		    	  System.out.print(l.retrive() + "->"); 
		    	  l.findNext();    
		 
		      		}
		      System.out.print(l.retrive() + "->\n"); 
	 }	      
		     

	public boolean  search(T data) {
		int lengeth = size();
		Node<T>  temp= new Node<T>(data); 
		if(head == null)
			 return false; 
		 else { 
			 current = head ; 
		       while (!(current == null)) { 
		    	   if (current.data.equals(data))
		    		   return true ; 
		    	   current = current.next ; 
		       }
		
	}
		return false ; 
	} 
	
	public T searchAndRetrieve(T data) {
	    Node<T> current = head;
	     while (current != null) {
	        if (current.data.equals(data)) {
	            return current.data; 
	        }
	        current = current.next;
	    }
	    return null; // Return null if not found
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    while (current != null) {
	        sb.append(current.data); 
	        if (current.next != null) {
	            sb.append(" -> "); 
	        }
	        current = current.next;
	    }
	    return sb.toString();
	}

	




} 



	
	 
