package ds_Project;

public class BST<T> {
	BSTNode root , current ; 
	
	BST(){
		root= current = null; 
		
	}
	public boolean empty() {
		return root == null; 
	}
	
	
	public  LinkedList<Integer> retrive() {
		return current.value; 
	}
	
	public boolean findKey(String tkey ) {
		BSTNode p = root, q = root;
		if(empty())
		return false;
		while(p != null) {
		q = p;
				if(p.key.equals(tkey) ) {
					current = p;
					return true;
				}
				else if(tkey.compareTo(p.key) <0)
					p = p.left;
				else
					p = p.right;
			}
				current = q;
				return false;
		}
	
	public boolean insert(String k, LinkedList<Integer> val) {
	    BSTNode p = root, q = null;
	    while (p != null) {
	        q = p;
	        if (k.equals(p.key)) {
	            // Merge LinkedLists without duplicates
	            LinkedList<Integer> existingList = p.value;
	            val.findFirst();
	            while (!val.isLast()) {
	                int id = val.retrive();
	                if (!existingList.search(id)) {
	                    existingList.insert(id);
	                }
	                val.findNext();
	            }
	            int id = val.retrive(); // Handle the last element
	            if (!existingList.search(id)) {
	                existingList.insert(id);
	            }
	            return true;
	        } else if (k.compareTo(p.key) < 0) {
	            p = p.left;
	        } else {
	            p = p.right;
	        }
	    }
	    BSTNode newNode = new BSTNode(k, val);
	    if (q == null) {
	        root = newNode;
	    } else if (k.compareTo(q.key) < 0) {
	        q.left = newNode;
	    } else {
	        q.right = newNode;
	    }
	    return true; 
	}

	
	
	private void deleteNode(BSTNode n, BSTNode parent) {
	    // parent is the parent of n. The method deletes node n

	    BSTNode child;
	    if (n.left != null)
	        child = n.left;
	    else
	        child = n.right;

	    if (parent == null) { // No parent for n, root must change
	        root = child;
	    } else {
	        if (n.key.compareTo(parent.key) < 0) { // n is the left child
	            parent.left = child;
	        } else { // n is the right child
	            parent.right = child;
	        }
	    }
	}

	
	public boolean removeKey(String k) {
	    // Search for k
	    BSTNode p = root;
	    BSTNode q = null; // Parent of p
	    boolean found = false;

	    while ((p != null) && (!found)) {
	        int res = k.compareTo(p.key); // Compare lexicographically
	        if (res < 0) {
	            q = p;
	            p = p.left;
	        } else if (res > 0) {
	            q = p;
	            p = p.right;
	        } else { // Found the key
	            found = true;
	        }
	    }

	    if (found) {
	        // Check the three cases
	        if ((p.left != null) && (p.right != null)) {
	            // Case 3: Node has two children
	            // Search for the min in the right subtree
	            BSTNode min = p.right;
	            q = p;
	            while (min.left != null) {
	                q = min;
	                min = min.left;
	            }
	            // Replace p's key and value with min's
	            p.key = min.key;
	            p.value = min.value;
	            deleteNode(min, q); // Delete the min node
	        } else {
	            // Case 1 and 2: Node has one or no children
	            deleteNode(p, q);
	        }
	        current = root;
	        return true;
	    }
	    return false; 
	}
	public void printTree() {
	    printTreeRecursive(root, 0); 
	}

	
	public void printTreeRecursive(BSTNode node, int level) {
	    if (node != null) {
	        printTreeRecursive(node.right, level + 1); // Right subtree first

	        // Print the current node with indentation
	        for (int i = 0; i < level; i++) {
	            System.out.print("    "); // Indentation
	        }
	        System.out.print(node.key + " -> ");

	        LinkedList<Integer> docNumbers = node.value;
	        if (docNumbers.isEmpty()) {
	            System.out.println("No documents");
	        } else {
	            docNumbers.findFirst();
	            while (!docNumbers.isLast()) {
	                System.out.print(docNumbers.retrive() + " -> ");
	                docNumbers.findNext();
	            }
	            System.out.println(docNumbers.retrive()); // Print last document ID
	        }

	        printTreeRecursive(node.left, level + 1); // Left subtree next
	    }
	}

}
