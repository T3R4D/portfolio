

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sum in part (b)
 *
 */
public class MoreSumsTestB
{
    @Test
    public void declarationBTest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "sumB", double.class, int.class);
    }
    
    @Test
    public void sumBTest() 
    {
        assertEquals("Testing n=3",    3, MoreSums.sumB(3), 1e-10 );
        assertEquals("Testing n=4",    13.0/3, MoreSums.sumB(4), 1e-10 );
        assertEquals("Testing n=10",   9.05450105450105, MoreSums.sumB(10), 1e-10 );
        assertEquals("Testing n=100",  57.1856023038538, MoreSums.sumB(100), 1e-9 );
        assertEquals("Testing n=1000", 510.086579180208, MoreSums.sumB(1000), 1e-8 );
    }
        
}
