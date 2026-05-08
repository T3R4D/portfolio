
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for: A demonstration and debugging techniques (Part B)
 */
public class BugsBTest
{    
    @Test
    public void scalarProductTest()
    {
        assertEquals("Testing vectors (0,0,0), (0,0,0). ",  0,  BugsB.scalarProduct(0, 0, 0, 0, 0, 0));
        assertEquals("Testing vectors (0,0,0), (1,2,3). ",  0,  BugsB.scalarProduct(0, 0, 0, 1, 2, 3));
        assertEquals("Testing vectors (1,0,0), (3,4,5). ",  3,  BugsB.scalarProduct(1, 0, 0, 3, 4, 5));
        assertEquals("Testing vectors (0,1,0), (3,4,5). ",  4,  BugsB.scalarProduct(0, 1, 0, 3, 4, 5));
        assertEquals("Testing vectors (0,0,1), (3,4,5). ",  5,  BugsB.scalarProduct(0, 0, 1, 3, 4, 5));
        assertEquals("Testing vectors (3,4,5), (1,0,0). ",  3,  BugsB.scalarProduct(3, 4, 5, 1, 0, 0));
        assertEquals("Testing vectors (3,4,5), (0,1,0). ",  4,  BugsB.scalarProduct(3, 4, 5, 0, 1, 0));
        assertEquals("Testing vectors (3,4,5), (0,0,1). ",  5,  BugsB.scalarProduct(3, 4, 5, 0, 0, 1));
        assertEquals("Testing vectors (3,4,5), (1,2,-3). ",-4,  BugsB.scalarProduct(3, 4, 5, 1, 2, -3));
    }
}
