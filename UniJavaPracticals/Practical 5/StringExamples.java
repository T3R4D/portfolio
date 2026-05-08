/*
 * Mathematical Skills II, Programming
 * Code for Practical 5
 */

/**
 * Some examples for string handling
 */
class StringExamples
{
    /**
     * Checks whether the input string contains the lowercase letter 'e'.
     *
     * @param s the string to be checked. It is assumed to be not null.
     * @return whether s contains the letter 'e'
     */
    static boolean containsE(String s)
    {
        int pos = s.indexOf('e');
        
        if (pos >= 0) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Counts the number of occurrences of the lowercase letter 'e' in the 
     * input string.
     * 
     * @param s the string to be cheked. This is assumed to be not null.
     * @return the number of occurences of 'e' in the string s
     */
    static int countE(String s)
    {
        int count = 0;
        int n = s.length(); 
        
        for (int p = 0; p < n; p++)    
        {
            if (s.charAt(p) == 'e')
            {
                count = count + 1;
            }
        }
        
        return count;
    }

    /**
     * Replaces the first occurrence of a space character in the input string
     * with three hyphens.
     *
     * @param s the string where spaces are to be replaced. Assumed to be not null.
     * @return the string s with the first space replaced by "---"
     */
    static String splitAtSpace(String s)
    {
        int pos = s.indexOf(' '); 
        int n = s.length();
        
                        
        if (pos >= 0)
        {
            s = s.substring(0, pos) + "---" + s.substring(pos+1, n);
        }
        
        return s;
    }

}
