

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for computing the parallelogram area
 */
public class ParallelogramTest
{
    
    @Test
    public void parallelogramAreaTest()
    {
        assertEquals("Testing vectors (0, 0), (0, 0). ",    0,  Parallelogram.parallelogramArea(0, 0, 0, 0), 1e-10);
        assertEquals("Testing vectors (1, 0), (0, 1). ",    1,  Parallelogram.parallelogramArea(1, 0, 0, 1), 1e-10);
        assertEquals("Testing vectors (1, 0), (2, 3). ",    3,  Parallelogram.parallelogramArea(1, 0, 2, 3), 1e-10);
        assertEquals("Testing vectors (2, 1), (3, 4). ",    5,  Parallelogram.parallelogramArea(2, 1, 3, 4), 1e-10);
        assertEquals("Testing vectors (2, -2), (4, 5). ",  18,  Parallelogram.parallelogramArea(2, -2, 4, 5), 1e-10);
        assertEquals("Testing vectors (0.1, 0), (0, 0.1). ",    0.01,  Parallelogram.parallelogramArea(0.1, 0, 0, 0.1), 1e-10);
    }

}
