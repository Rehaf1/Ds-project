package ds_Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inverted_Index {
	
		
		public LinkedList <Words>  Word ; 
		   public BST WordTree  = new BST();
		
		public Inverted_Index() {
	        Word = new LinkedList<Words>();
	        genrating_reverseIndex();
	    }
		
		  
		public void genrating_reverseIndex() {

		    String file = "/Users/rehaf/git/Ds-project/DataStructure/dataset.csv";
		    String file2 = "/Users/rehaf/git/Ds-project/DataStructure/stop.txt";

		    String[] stop = new String[572];
		    String line = "";
		    int count = 0;
		    int num = 0;
		    BufferedReader reader = null, reader1 = null;

		    try {
		        // Load stop words
		        reader1 = new BufferedReader(new FileReader(file2));
		        while ((line = reader1.readLine()) != null) {
		            stop[count++] = line.trim();
		        }
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    } finally {
		        try {
		            reader1.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    try {
		        // Process the dataset
		        reader = new BufferedReader(new FileReader(file));
		        line = reader.readLine(); // Skip header

		        while ((line = reader.readLine()) != null && num < 50) {
		            num++;

		            int firstCommaIndex = line.indexOf(",");
		            if (firstCommaIndex != -1) {
		                String id = line.substring(0, firstCommaIndex);
		                int ID = Integer.parseInt(id);
		                String content = line.substring(firstCommaIndex + 1);

		                content = content.toLowerCase();
		                for (String str : stop) {
		                    if (str != null)
		                        content = content.replaceAll("\\b" + str + "\\b", " ");
		                }

		                content = content.replaceAll("[^a-z\\s]", "").replaceAll("\\s+", " ").trim();
		                String[] elements = content.split(" ");
		                
		                 // so i don't have repetitive from the same doc
                           String processedWords = ""; 

		                for (String element : elements) {
		                	if (processedWords.contains(element)) {
		                        continue; // Skip if this word exists in the doc
		                    }
		                    processedWords += element; 
		                    Words tempWord = new Words(element, null);
		                    Words existingWord = Word.searchAndRetrieve(tempWord);

		                    if (existingWord != null) {
		                        existingWord.getDocNUm().insert(ID); 
		                    } else {
		                        LinkedList<Integer> docList = new LinkedList<>();
		                        docList.insert(ID);
		                        Words newWord = new Words(element, docList);
		                        Word.insert(newWord);
		                    
		                      
		                     
		                      
		                    	}

		                        
		                    }
		                   
		                    
		                }
		            }
		          
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		       
		   
		   
		    }
		    printInvertedIndex(); 
		      BST();
		}
		
		
		public void BST() {
			if(Word.isEmpty())
				System.out.print("NO WORDS");
			else {  Word.findFirst();
					while(!Word.isLast()) {
						WordTree.insert(Word.retrive().getWord(), Word.retrive().getDocNUm());
						Word.findNext();
					}
					WordTree.insert(Word.retrive().getWord(), Word.retrive().getDocNUm());
				
		}printTree();
			}
		
public void printInvertedIndex() {
			
		    System.out.println("Inverted Index:");
		    if (Word.isEmpty()) {
		        System.out.println("The index is empty.");
		        return;
		    }
		    Word.findFirst(); // Move to the first word in the linked list
		    while (!Word.isLast()) {
		        Words currentWord = Word.retrive();
		        System.out.print(currentWord.getWord() + ": ");
		        LinkedList<Integer> docNumbers = currentWord.getDocNUm(); // Get the document numbers
		        if (docNumbers.isEmpty()) {
		            System.out.println("No documents");
		        } else {
		            docNumbers.findFirst(); // Initialize traversal for docNumbers
		            while (!docNumbers.isLast()) {
		                System.out.print(docNumbers.retrive() + " -> ");
		                docNumbers.findNext();
		            }
		            System.out.println(docNumbers.retrive()); // Print the last document without an arrow
		        }
		        Word.findNext(); 
		    } 
		    Words lastWord = Word.retrive(); // Handle the last word
		    System.out.print(lastWord.getWord() + ": ");
		
		    LinkedList<Integer> lastDocNumbers = lastWord.getDocNUm();
		    if (lastDocNumbers.isEmpty()) {
		        System.out.println("No documents");
		    } else {
		        lastDocNumbers.findFirst();
		        while (!lastDocNumbers.isLast()) {
		            System.out.print(lastDocNumbers.retrive() + " -> ");
		            lastDocNumbers.findNext();
		        }
		        System.out.println(lastDocNumbers.retrive()); // Print the last document without an arrow
		    }
		}

		
		 public void printTree() {
		        WordTree.printTree(); 
		    }
		
		
		
		

		}
	