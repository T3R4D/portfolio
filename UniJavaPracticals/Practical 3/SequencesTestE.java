import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for Practical 3, Exercise 2a)
 *
 */
public class SequencesTestE
{
    @Test
    public void catalanTest()
    {
        assertEquals("Testing n=0", 1L, Sequences.sequenceE(0));
        assertEquals("Testing n=1", 1L, Sequences.sequenceE(1));
        assertEquals("Testing n=2", 2L, Sequences.sequenceE(2));
        assertEquals("Testing n=3", 5L, Sequences.sequenceE(3));
        assertEquals("Testing n=4", 14L, Sequences.sequenceE(4));
        assertEquals("Testing n=10", 16796L, Sequences.sequenceE(10));
        assertEquals("Testing n=20", 6564120420L, Sequences.sequenceE(20));
    }

}
