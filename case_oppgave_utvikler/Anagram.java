package case_oppgave_utvikler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eivind
 */
class Anagram 
{
    private String word;
    private List<String> anagram;
    public Anagram(String n){
        word=n;
        anagram=new ArrayList<String>();
    }
    public void addanagram(String o)
    {
        anagram.add(o);
    }
    public String getWord()
    {
      return word;  
    }
    public String getAnagrams()
    {
        String anagrams="";
        if(anagram!=null)
        {
            for(String a:anagram)
            {
                anagrams=anagrams+" "+a;
            }
        }
        return anagrams;
    }
    //made for testing
    public String toString()
    {
        if (anagram==null)
        {
            return word;
        }
        return word+anagram;
    }
}
