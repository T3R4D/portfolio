

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sequence d_n.
 */
public class SequencesTestD
{
    @Test
    public void declarationTest()
    {
        TestHelper.testFunctionDeclared(Sequences.class, "sequenceD", long.class, int.class, long.class, long.class);
    }
    
    private void partDOneValue(int n, long gamma, long k, long expected) 
    {
        String msg = String.format("Testing n=%d, gamma=%d, k=%d", n, gamma, k);
        assertEquals(msg, expected, Sequences.sequenceD(n, gamma, k));
    }
    
    @Test
    public void sequenceDTest() 
    {
        partDOneValue(1, 0, 5, 0L);
        partDOneValue(1, 10, 5, 10L);
        partDOneValue(1, 34, -17430, 34L);

        partDOneValue(2, 1, 10,  8L);
        partDOneValue(2, 3, 10,  4L);
        partDOneValue(2, 3, 100, 24L);

        partDOneValue(3, 1, 10, 6L);
        partDOneValue(3, 3, 10, 8L);
        partDOneValue(3, 3, 100, 78L);

        partDOneValue(101, 5, 1000, 211L);
        partDOneValue(101, 5, 10000L, 1211L);        
    }
}
