package ds_Project;

public class Doc {
	private int num ; 
	private LinkedList<String> words = new LinkedList<String>();
	
	
	public Doc(int number , LinkedList<String> Words) {
		num = number ; 
		words = Words; 
		
	}
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public LinkedList<String> getWords() {
		return words;
	}
	public void setWords(LinkedList<String> words) {
		this.words = words;
	}
      
	public void printDoc() {
		System.out.print(num + ": ");
		printinnerList();
	}
	
	public String toString() {
		return ""+ num ;
	}



	public void printinnerList() {
		words.printInner(words); 
	}

}

