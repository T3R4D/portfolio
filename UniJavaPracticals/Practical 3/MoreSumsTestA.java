

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sum in part (a).
 */
public class MoreSumsTestA
{
    @Test
    public void declarationATest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "sumA", int.class, int.class);
    }
    
    @Test
    public void sumATest() 
    {
        assertEquals("Testing n=1", 0, MoreSums.sumA(1) );
        assertEquals("Testing n=2", 3, MoreSums.sumA(2) );
        assertEquals("Testing n=3", 11, MoreSums.sumA(3) );
        assertEquals("Testing n=10", 375, MoreSums.sumA(10) );
        assertEquals("Testing n=100", 338250, MoreSums.sumA(100) );
    }
}
