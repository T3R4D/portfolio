

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sequence c_n.
 */
public class SequencesTestC
{
    @Test
    public void declarationTest()
    {
        TestHelper.testFunctionDeclared(Sequences.class, "sequenceC", long.class, int.class, long.class, long.class);
    }
    
    private void partCOneValue(int n, long a, long b, long expected) 
    {
        String msg = String.format("Testing n=%d, alpha=%d, beta=%d", n, a, b);
        assertEquals(msg, expected, Sequences.sequenceC(n, a, b));
    }
    
    @Test
    public void sequenceCTest() 
    {
        partCOneValue(2, 0, 0, 0L);
        partCOneValue(2, 1, 1, -1L);
        partCOneValue(2, 1, 3, 3L);
        partCOneValue(2, 3, 1, -7L);
        
        partCOneValue(0, 0, 0, 0L);
        partCOneValue(0, 15L, -33L, 15L);

        partCOneValue(1, 0, 0, 0L);
        partCOneValue(1, 15L, -33L, -33L);

        partCOneValue(0, 0, 0, 0L);
        partCOneValue(0, 15L, -33L, 15L);

        partCOneValue(10, 0, 0, 0L);
        partCOneValue(10, 2, 0, -438L);
        partCOneValue(10, 0, 2, -44L);
        partCOneValue(10, 5, -7, -941L);

        partCOneValue(60, -6, -8, -1089350721175294L);
        
    }
}
