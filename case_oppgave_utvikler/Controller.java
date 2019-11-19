package case_oppgave_utvikler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author eivind
 */
class Controller {
    //declear variables
    private List<String> wordlist;
    private List<Anagram> anagram;
    //constructor takes in a string of a path to file
    public Controller(String filename) throws FileNotFoundException{
        //take in the file and read into array, make word objects and go trough the list
        wordlist=new ArrayList<>();
        anagram=new ArrayList<>();
        
        try{//try to read file
            BufferedReader fil= new BufferedReader(new FileReader(filename));
            String line = fil.readLine();
            while (line!=null)
            {
                //is there empty data?
                if (line.equals("")){
                }
                else{
                    //System.out.println(line);
                    wordlist.add(line);
                }
                
                line = fil.readLine();     
            }        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //file read and done with so out of the try block
        //System.out.println(wordlist);
        //find the anagrams
        anagramifiser();
        //System.out.println(anagram);
        //make the output window.
        TextOutput output= new TextOutput();
        output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output.setSize(500, 300);
        //construct the text
        for(Anagram a:anagram)
        {
            String text="";
            String anagramstring;          
            anagramstring=a.getAnagrams();
            if (!anagramstring.equals(""))
            {
                text=a.getWord()+" "+a.getAnagrams()+"\n";
                //System.out.println(text);
                output.addData(text);

            }
        }
    }
    public List GetAnagrams()
    {
        return anagram;
    }
    private void anagramifiser()
    {
        //fast coding so word 1 is a single word in the list and that same for word 2. and word is just to save the object word temporary
        for (String word1 : wordlist) 
        {
            //System.out.println(word1);
            Anagram a=new Anagram(word1);
            
            for (String word2 : wordlist) 
            {
                String word=a.getWord();
                char[] wordleters=word.toCharArray();
                Arrays.sort(wordleters);
                //if word2 is not equal to word and word and word2 is equal in lenght then we can move on to next phase.
                if (!word.equals(word2) && word.length()==word2.length())
                {
                    char[] leters=word2.toCharArray();
                    Arrays.sort(leters);
                    if(java.util.Arrays.equals(wordleters, leters))
                    {
                        //System.out.println(word1+" "+word2);
                        a.addanagram(word2);
                    }
                    //System.out.println(leters);
                    //System.out.println(word1+" "+word2);
                    
                }
            }
            anagram.add(a);
            //System.out.println(a);
        }
    }
}
