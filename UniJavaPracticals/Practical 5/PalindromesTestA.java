

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for palindromes, part (a)
 */
public class PalindromesTestA
{       
    @Test
    public void reverseNullTest()
    {
        assertNull("Reversing null string", Palindromes.reverse(null));
    }

    @Test
    public void reverseEmptyTest()
    {
        assertEquals("Reversing empty string", "", Palindromes.reverse(""));
    }

    @Test
    public void reverseShortTest()
    {
        assertEquals("Reversing string \"Test\"", "tseT", Palindromes.reverse("Test"));
    }


    @Test
    public void reverseLongTest()
    {
        assertEquals("Reversing string \"Hello there!\"", "!ereht olleH", Palindromes.reverse("Hello there!"));
    }

}
