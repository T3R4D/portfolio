

import static org.junit.Assert.*;
import org.junit.Test;
import static java.lang.Math.*;

/**
 * Unit test for the sum in part (g) 
 *
 */
public class MoreSumsTestG
{

    private void partGOneValue(int n, double expected) 
    {
        String msg = String.format("Testing n=%d", n);
        assertEquals(msg, expected, MoreSums.sumG(n), expected*1e-8);
    }

    @Test
    public void sumGTest() 
    {
        partGOneValue(1, 0);
        partGOneValue(2, 0.5);
        partGOneValue(3, 0.833333333333333);
        partGOneValue(9, 1.17619047619048);
        partGOneValue(10, 1.17619047619048);
        partGOneValue(11, 1.26709956709957);
        partGOneValue(100, 1.80281720104887);
    }
        
}
