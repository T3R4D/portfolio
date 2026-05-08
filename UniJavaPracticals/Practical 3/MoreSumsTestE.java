

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sum in part (e) 
 *
 */
public class MoreSumsTestE
{

    @Test
    public void declarationETest()
    {
        TestHelper.testFunctionDeclared(MoreSums.class, "sumE", double.class, int.class, double.class, double.class);

    }
    
    private void partEOneValue(int n, double a, double b, double expected) 
    {
        String msg = String.format("Testing n=%d, a=%f, b=%f", n, a, b);
        assertEquals(msg, expected, MoreSums.sumE(n, a, b), expected*1e-8);
    }

    @Test
    public void sumETest() 
    {
        partEOneValue(0, 0, 0, 1);
        partEOneValue(1, 0, 0, 3);
        partEOneValue(2, 0, 0, 6);
        partEOneValue(10, 0, 0, 66);

        partEOneValue(0, 1, 0, 1);
        partEOneValue(1, 1, 0, 2.5);
        partEOneValue(1, 2, 0, 7.0/3.0);
        partEOneValue(1, 10, 0, 23.0/11.0);
        partEOneValue(2, 2, 0, 34.0/9.0);
        partEOneValue(10, 2, 0, 16.2335523039279);
        
        partEOneValue(0, 0, 1, 1);
        partEOneValue(1, 0, 1, 2);
        partEOneValue(1, 0, 2, 5.0/3.0);
        partEOneValue(1, 0, 10, 13.0/11.0);
        partEOneValue(2, 0, 2, 2.0);
        partEOneValue(10, 0, 2, 2.84223052116634);

        partEOneValue(1, 3, 4, 53.0/40.0);
        partEOneValue(10, 3, 4, 1.81697615501209);
        
        partEOneValue(5, 1.5, 2.5, 2.04169263088983);
    }
        
}
