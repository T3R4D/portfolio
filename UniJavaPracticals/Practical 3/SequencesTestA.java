

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the sequence a_n.
 */
public class SequencesTestA
{
    @Test
    public void declarationTest()
    {
        TestHelper.testFunctionDeclared(Sequences.class, "sequenceA", long.class, int.class);
    }
    
    @Test
    public void sequenceATest() 
    {
        assertEquals("Testing n=1", 2L, Sequences.sequenceA(1) );
        assertEquals("Testing n=2", 3L, Sequences.sequenceA(2) );
        assertEquals("Testing n=3", 1L, Sequences.sequenceA(3) );
        assertEquals("Testing n=4", 5L, Sequences.sequenceA(4) );
        assertEquals("Testing n=10", 173L, Sequences.sequenceA(10) );
        assertEquals("Testing n=50", 187649984473773L, Sequences.sequenceA(50) );
    }
}
