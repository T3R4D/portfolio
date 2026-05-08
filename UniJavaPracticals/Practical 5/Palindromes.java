
/*
 * Mathematical Skills II, Programming
 * Code for Practical 5
 */

/**
 * Reversing strings, and palindromes
 */
class Palindromes
{
    /**
     * Reverse the order of characters and return the result.
     *
     * @param s a string 
     * @return returns the reverse of s
     */
    static String reverse(String s)
    {
        if (s == null)
        {
            return null;
        }
        
        int n = s.length();
        String t = "";
        String u = "";
        
        for(int i = 0; i < n; i++)
        {
            String a = s.substring(i,i+1);
            t = a + u;
            u = t;
        }
        
        return t;
    }
    
    /**
     * Tests whether a string is a palindrome.
     * 
     * @param s a string
     * @return returns the boolean
     */
    static boolean isPalindrome(String s)
    {
        if (s == null)
        {
            return false;
        }
        
        String t = reverse(s);
        
        if (s.equalsIgnoreCase(t))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
