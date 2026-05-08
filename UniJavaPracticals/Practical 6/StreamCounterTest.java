import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
 * Unit tests for the StreamCounter class.
 */
public class StreamCounterTest
{
    @Test
    public void mostFrequentTest() throws IOException
    {
        int expected = 17;
        int actual = StreamCounter.mostFrequent(StreamCounter.sampleSmall, 1000);
        assertEquals("most freq number in small file", expected, actual);
    }
    
    @Test
    public void mostFrequentApproxTest() throws IOException
    {
        int expected = 17;
        int actual = StreamCounter.mostFrequentApprox(StreamCounter.sampleSmall, 20);
        assertEquals("most freq number in small file", expected, actual);
    }

}
