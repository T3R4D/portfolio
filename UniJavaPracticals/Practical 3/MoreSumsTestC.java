

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Practical 3, Exercise 1
 *
 */
public class MoreSumsTestC
{

    @Test
    public void declarationCTest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "sumC", double.class, int.class, double.class);
    }
 
    private void partCOneValue(int m, double x, double expected) 
    {
        String msg = "Testing m="+m+", x="+x;
        assertEquals(msg, expected, MoreSums.sumC(m, x), expected*1e-8);
    }

    @Test
    public void sumPartDTest() 
    {
        partCOneValue(0, 0.0, 1.0);
        partCOneValue(0, 1.0, 1.0);
        partCOneValue(0, -4.0, 1.0);

        partCOneValue(1, 0.0, 2.0);
        partCOneValue(1, 1.0, 1.0+Math.exp(0.5));
        partCOneValue(1, -4.0, 1.0+Math.exp(-2.0));

        partCOneValue(2, 0.0, 3.0);
        partCOneValue(2, 1.0, 1.0+Math.exp(0.5)+Math.exp(1.0));
        partCOneValue(2, -4.0, 1.0+Math.exp(-2.0)+Math.exp(-4.0));

        partCOneValue(10, 0.0, 11.0);
        partCOneValue(10, 1.0, 375.6496715);
        partCOneValue(10, 2.0, 34844.77384);        
        partCOneValue(10, 10.0, 5.219876782e21);
        partCOneValue(10, -5.0, 1.08942548982);

        partCOneValue(100, 0.0, 101.0);
        partCOneValue(100, 1.0, 1.317689842e22);
        partCOneValue(100, 3.0, 1.794006550e65);        
        partCOneValue(100, 5.0, 4.081483154e108);
        partCOneValue(100, -1.0, 2.541494080);
        partCOneValue(100, -3.0, 1.287216915);
        partCOneValue(100, -10.0, 1.006783655);

    }
        
}
