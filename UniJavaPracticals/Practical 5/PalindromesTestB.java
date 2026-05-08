import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for palindromes, part (b)
 */
public class PalindromesTestB
{       
    @Test
    public void isPalindromeNullTest()
    {
        assertFalse("Testing null string", Palindromes.isPalindrome(null));
    }

    @Test
    public void isPalindromeEmptyTest()
    {
        assertTrue("Testing empty string", Palindromes.isPalindrome(""));
    }

    @Test
    public void isPalindromeNegativeTest()
    {
        assertFalse("Testing string \"Test\"", Palindromes.isPalindrome("Test"));
    }

    @Test
    public void isPalindromePositiveTest1()
    {
        assertTrue("Testing string \"Avid diva\"", Palindromes.isPalindrome("Avid diva"));
    }

    @Test
    public void isPalindromePositiveTest2()
    {
        assertTrue("Testing string \"avid diva\"", Palindromes.isPalindrome("avid diva"));
    }

}
