package projectTest1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {



    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\Hessa\\Downloads\\dataset.csv"; // file place        
        String file2 = "C:\\Users\\Hessa\\Downloads\\stop.txt";

        String[] stop = new String[572];
        String line = "";
        int count = 0;
        int num = 0;

        BufferedReader reader = null, reader1 = null;

        try {
            reader1 = new BufferedReader(new FileReader(file2)); // reading the file 

            while ((line = reader1.readLine()) != null) {

                stop[count++] = line.trim(); // without extra spaces
            }
            //stop[count] = "\"";

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
        	try {
                reader1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        LinkedList < String > outerlist = new LinkedList < String > ();
        try {
            reader = new BufferedReader(new FileReader(file)); // reading the file 
            line = reader.readLine(); // to not read the header of the column 
            
            while ((line = reader.readLine()) != null && num < 50) {
                num++; // to not read the tokens or the vocab or the topic. //but the null comes before them no? 

                LinkedList < String > innerlist = new LinkedList < String > ();

                int firstCommaIndex = line.indexOf(","); //find 1st comma
                if (firstCommaIndex != -1) {
                    String id = line.substring(0, firstCommaIndex); // get ID
                    String content = line.substring(firstCommaIndex + 1); // get content

                    content = content.toLowerCase();
                    content = content.replaceAll(",", " "); //need?
                    content = content.replaceAll("-", ""); // remove "-" 

                    
                    // removing all stop words
                    for (String str: stop) { // this is basically a loop for every string in stop
                        if (str != null)
                            content = content.replaceAll("\\b" + str + "\\b", " "); // so that i don't replace the letters in words
                    }

                    content = content.replaceAll("[^a-z\\s]", ""); // remove all not letters/spaces
                    content = content.replaceAll("\\s+", " ").trim(); // replace multiple spaces with a single space and trim spaces in beginning and end

                    String[] elements = content.split(" ");
                    for (String element: elements)
                        innerlist.insert(element);

                    outerlist.insert(id, innerlist);
                }

            }

            System.out.println();
            outerlist.print();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
