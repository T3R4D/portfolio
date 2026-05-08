

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sequence b_n.
 */
public class SequencesTestB
{
    @Test
    public void declarationTest()
    {
        TestHelper.testFunctionDeclared(Sequences.class, "sequenceB", long.class, int.class);
    }
    
    @Test
    public void sequenceBTest() 
    {
        assertEquals("Testing n=0", 1L, Sequences.sequenceB(0) );
        assertEquals("Testing n=1", 1L, Sequences.sequenceB(1) );
        assertEquals("Testing n=2", -5L, Sequences.sequenceB(2) );
        assertEquals("Testing n=3", 85L, Sequences.sequenceB(3) );
        assertEquals("Testing n=6", 1043052931468675L, Sequences.sequenceB(6) );
    }
}
