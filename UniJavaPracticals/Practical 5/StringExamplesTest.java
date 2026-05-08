import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for string handling examples
 */
public class StringExamplesTest
{
    @Test
    public void containsETest()
    {
        assertTrue("Testing: abcdefg", StringExamples.containsE("abcdefg"));
        assertTrue("Testing: revision", StringExamples.containsE("revision"));
        assertTrue("Testing: abcde", StringExamples.containsE("abcde"));
        assertTrue("Testing: edcba", StringExamples.containsE("edcba"));
        assertFalse("Testing: abc", StringExamples.containsE("abc"));
        assertFalse("Testing: a", StringExamples.containsE("a"));
    }
    
    
    private void testOneCountE(String s, int expected)
    {
        int actual = StringExamples.countE(s);
        String msg = "Testing: \""+s+"\"";
        assertEquals(msg, expected, actual);        
    }
    
    @Test
    public void countETest()
    {
        testOneCountE("abcd", 0);
        testOneCountE("abcde", 1);
        testOneCountE("eabcd", 1);
        testOneCountE("review", 2);
        testOneCountE("internet connection", 3);
    }

    private void testOneSplitAtSpace(String s, String expected)
    {
        String actual = StringExamples.splitAtSpace(s);
        String msg = "Testing: \""+s+"\"";
        assertEquals(msg, expected, actual);        
    }
    
    @Test
    public void testSplitAtSpace()
    {
        testOneSplitAtSpace("a b", "a---b");
        testOneSplitAtSpace("ab", "ab");
        testOneSplitAtSpace("Just a test", "Just---a test");
        testOneSplitAtSpace("Mathematical Skills II, Programming", "Mathematical---Skills II, Programming");
        testOneSplitAtSpace("MAT00027I", "MAT00027I");
        testOneSplitAtSpace(" ab", "---ab");
        testOneSplitAtSpace("ab ", "ab---");
    }

}
