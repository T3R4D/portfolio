

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sum in part (a).
 */
public class MoreSumsTestH
{
    @Test
    public void sumHTest() 
    {
        assertEquals("Testing [1]", 1, MoreSums.sumH(1), 1e-10 );
        assertEquals("Testing [2]", 0.25, MoreSums.sumH(2), 1e-10 );
        assertEquals("Testing [1,1,1,1]", 4, MoreSums.sumH(1,1,1,1), 1e-10 );
        assertEquals("Testing [2,10,0.1]", 100.26, MoreSums.sumH(2, 10, 0.1), 1e-10 );
    }
}
