package ds_Project;

public class Words {
	
		private String Word ; 
		private LinkedList<Integer> DocNUm = new LinkedList<Integer>();
		
		
		public Words(String word , LinkedList<Integer> docNumber) {
			Word = word ; 
			DocNUm = docNumber; 
			
		}
		
		
		public void printWords() {
			System.out.print(Word + ": ");
			printinnerList();
		}
		
		
		public void printinnerList() {
			DocNUm.printInner(DocNUm); 
		}


		public String getWord() {
			return Word;
		}


		public void setWord(String word) {
			Word = word;
		}


		public LinkedList<Integer> getDocNUm() {
			return DocNUm;
		}


		public void setDocNUm(LinkedList<Integer> docNUm) {
			DocNUm = docNUm;
		}
	
		public boolean equals(Object obj) {
		    if (this == obj) return true;
		    if (obj == null || getClass() != obj.getClass()) return false;
		    Words other = (Words) obj;
		   
		    return Word.equals(other.Word);
		}
		
}


