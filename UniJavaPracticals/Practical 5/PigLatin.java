
/*
 * Mathematical Skills II, Programming
 * Code for Practical 5
 */

/**
 * Translating to Pig Latin
 */
class PigLatin
{
    /**
     * Takes English text and translates all words into Pig Latin.
     * 
     * @param s a String of English text
     * @return returns the text in Pig Latin
     */
    static String translateToPigLatin(String s)
    {
        int a = s.length();
        if (a == 0)
        {return "";}
        
        s = s.toLowerCase();
        String result = "";
        
        int pos;
        String word;
        do
        {
            pos=s.indexOf(" ");
            if (pos == -1)
            {
                word = s;
                s = "";
            }
            else
            {
                word = s.substring(0, pos);
                s = s.substring(pos+1).trim();
            }
            
            String translate = "";
            if (word.charAt(0) == 'y')
            {
                translate = word;
            }
            else if (word.charAt(0) == 'a')
            {
                translate = vowelsPigLatin(word); 
            }
            else if (word.charAt(0) == 'e')
            {
                translate = vowelsPigLatin(word); 
            }
            else if (word.charAt(0) == 'i')
            {
                translate = vowelsPigLatin(word); 
            }
            else if (word.charAt(0) == 'o')
            {
                translate = vowelsPigLatin(word); 
            }
            else if (word.charAt(0) == 'u')
            {
                translate = vowelsPigLatin(word); 
            }
            else
            {
                translate = consonantsPigLatin(word);
            }
            
            result = result + translate;
            if (s.length() > 0)
            {
                result = result + " ";
            }
        }
        while (pos != -1);
        
        return result;
    }
    
    /**
     * Translate a word starting with a vowel into Pig Latin.
     * 
     * @param s a word beginning with a vowel
     * @return the word translated into Pig Latin
     */
    static String vowelsPigLatin(String s)
    {
        String result = "";
        result = s + "way";
        
        return result;
    }
    
    /**
     * Translate a word starting with a consonant into Pig Latin
     * 
     * @param s a word beginning with a consonant
     * @return the word translated into Pig Latin
     */
    static String consonantsPigLatin(String s)
    {
        String result = s;
        int n = s.length();
        String t = "";
        String u = "";
        int pos = 0;
                
        do
        {
            if (s.charAt(pos) == 'a' || s.charAt(pos) == 'e' || 
            s.charAt(pos) == 'i' || s.charAt(pos) == 'o' || 
            s.charAt(pos) == 'u')
            {
                result = result + "ay";
        
                return result;
            }
            else
            {
                t = result.substring(1,n);
                u = result.substring(0,1);
                result = t + u;
            }
        
            pos++;
        }
        while (pos < n);
        
        
        result = result + "ay";
     
        
        return result;
    }

}
