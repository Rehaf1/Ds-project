package ds_Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {



	public static void main(String[] args) throws IOException {
		String file = "/Users/rehaf/git/Ds-project/DataStructure/dataset.csv";  // file place
		BufferedReader reader = null , reader1 = null; 
		
		String line ="";
		String file2 ="/Users/rehaf/git/Ds-project/DataStructure/stop.txt"; 
		String [] stop = new String[572];
		int count = 0; 
		int num = 0 ; 
		try { 
		reader1 = new BufferedReader(new FileReader(file2));  // reading the file 
		
		while((line = reader1.readLine()) != null  ) {
			 
			stop[count++]=" "+ line+ " "; // so that i don't replace the letters in words
		}stop[count]="\"";
		 
		}catch (IOException e1) { 
			e1.printStackTrace();
		}finally {
			reader1.close(); 
		}
		
		
		LinkedList <String> outerlist = new LinkedList<String>();  
		try { 
			reader = new BufferedReader(new FileReader(file));  // reading the file 
			line = reader.readLine();  // to not read the header of the column 
			while((line = reader.readLine()) != null && num < 50 ) {
				num++ ;// to not read the tokens or the vocab or the topic.  
				LinkedList <String> innerlist = new LinkedList<String>(); 
				
				String[]row = line.split(",");  
				   if (row.length > 1) {
					  row[1]= row[1].toLowerCase(); 
					  row[1] =  row[1]; // to remove stop word if its the first word 
					   // removing all stop words 
					   for (String str : stop) {       // this is basically a loop for every string in stop
						   if(str != null)
						   	row[1]= row[1].replace(str, " ") ;
					   } 
					   
				String[] elements = row[1].split(" ");
				for (int i =0 ; i< elements.length ; i++) 
					innerlist.insert(elements[i]);
					
				outerlist.insert(row[0], innerlist);
				   } 
				
				}
				System.out.println();
				
				outerlist.print(); 
			}
		catch(IOException e)
		{
             e.printStackTrace();
	}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		

	}}



