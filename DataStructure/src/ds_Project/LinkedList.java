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
	 
	 public void insert(T e) { 
		 Node<T> temp ;
		 
		 if(head == null)
			 head=current=new Node<T>(e) ; 
		 else {
			
		 temp = current.next; 
		 current.next = new Node<T>(e) ;
		 current = current.next;
		 current.next = temp ; 
		 } 
		 }
	 public void insert(T e, LinkedList<T> list) { 
		 Node<T> temp ;
		 
		 
		 if(head == null)
			 head=current=new Node<T>(e , list) ; 
		 else {
			
		 temp = current.next; 
		 current.next = new Node<T>(e, list) ;
		 current = current.next;
		 current.next = temp ; 
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
	 
	 
	 
	 
	 
	 /// this is to make sure it works 
	 public void print() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + ": ");
	            current.insideList.printInner();  // Print inner list
	            current = current.next;
	        }
	    }

	 public void printInner() {
	       current =  head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println("");
	    }

	 public int size() {
        return size;
    }

    public T get(int index) {
        Node < T > temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
}
	}

	 
