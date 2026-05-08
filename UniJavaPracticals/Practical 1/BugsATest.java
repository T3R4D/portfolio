

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for: A demonstration and debugging techniques (Part A)
 */
public class BugsATest
{    
    @Test
    public void normSquareTest()
    {
        assertEquals("Testing vector (0,0,0). ",   0,  BugsA.normSquared(0, 0, 0));
        assertEquals("Testing vector (0,0,1). ",   1,  BugsA.normSquared(0, 0, 1));
        assertEquals("Testing vector (5,0,0). ",   25, BugsA.normSquared(5, 0, 0));
        assertEquals("Testing vector (5,-3, 2). ", 38, BugsA.normSquared(5, -3, 2));
    }
}
