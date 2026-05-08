/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

/**
 * Unit tests for reading statistical data from a web address
 */
public class NetStatsTest
{
    @Test
    public void meanValueTest() throws IOException
    {
        double actual = NetStats.meanValueFromNet();
        assertEquals("Testing mean value", 0.4962458188, actual, 1e-9);
    }

    @Test
    public void medianTest() throws IOException
    {
        double actual = NetStats.medianFromNet();
        assertEquals("Testing median", 0.4774152008, actual, 1e-9);
    }

    @Test
    public void dataSeriesTest() throws IOException
    {
        double[] actual = NetStats.readDataSeries();
        assertEquals("Length of series", 1000, actual.length);
        assertEquals("element 0", 0.1520069023, actual[0], 1e-10);
        assertEquals("element 1", 0.79935101, actual[1], 1e-10);
        assertEquals("element 567", 0.8819364519, actual[567], 1e-10);
        
    }
    
}
