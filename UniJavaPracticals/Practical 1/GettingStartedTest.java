

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the "getting started" example
 */
public class GettingStartedTest
{

    @Test
    public void squarePlusOneTest()
    {
        assertEquals("Testing n=0. ", 1, GettingStarted.squarePlusOne(0));
        assertEquals("Testing n=1. ", 2, GettingStarted.squarePlusOne(1));
        assertEquals("Testing n=5. ", 26, GettingStarted.squarePlusOne(5));
        assertEquals("Testing n=-2. ", 5, GettingStarted.squarePlusOne(-2));
        assertEquals("Testing n=-100. ", 10001, GettingStarted.squarePlusOne(-100));
    }
}

