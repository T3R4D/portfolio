

import static org.junit.Assert.*;
import org.junit.Test;
import static java.lang.Math.*;

/**
 * Unit test for the sum in part (f) 
 *
 */
public class MoreSumsTestF
{
    @Test
    public void declarationFTest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "sumF", double.class, int.class);
    }

    private void partFOneValue(int n, double expected) 
    {
        String msg = String.format("Testing n=%d", n);
        assertEquals(msg, expected, MoreSums.sumF(n), expected*1e-8);
    }

    @Test
    public void sumFTest() 
    {
        partFOneValue(1, sqrt(2) + sqrt(3));
        partFOneValue(2, sqrt(2) + sqrt(3) + sqrt(4) + sqrt(5));
        partFOneValue(3, 13.2107594721880);
        partFOneValue(10, 212.792825965546);
        partFOneValue(100, 7.68812546363336e15);
    }
        
}
