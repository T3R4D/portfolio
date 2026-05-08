

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Practical 3, Exercise 1
 *
 */
public class MoreSumsTestD
{
    @Test
    public void declarationDTest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "productD", long.class, int.class);
    }
    
    @Test
    public void productDTest() 
    {
        assertEquals("Testing n=1",    3L, MoreSums.productD(1));
        assertEquals("Testing n=2",    18L, MoreSums.productD(2));
        assertEquals("Testing n=3",    198L, MoreSums.productD(3));
        assertEquals("Testing n=10",   104202330449184L, MoreSums.productD(10));
    }
    
}
