/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 

import static org.junit.Assert.*;
import org.junit.rules.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Unit tests for reading statistical data from a file
 */
public class FileStatsTest
{
    static final String inputA = "unittest_filestats_a.txt";
    static final String inputB = "unittest_filestats_b.txt";
    static final String inputX1 = "unittest_filestats_x1.txt";
    static final String inputX2 = "unittest_filestats_x2.txt";
    static final String inputNonex = "unittest_filestats_does_not_exist.txt";
    
    @Test
    public void meanValueTest() throws IOException
    {
        double m;
        
        m = FileStats.meanValueFromFile(inputA);
        assertEquals("data series A", 2.5, m, 1e-10);

        m = FileStats.meanValueFromFile(inputB);
        assertEquals("data series B", 50.3317493971, m, 1e-6);

    }

    @Test
    public void momentTest() throws IOException
    {
        double m;
        
        m = FileStats.momentFromFile(inputA, 4);
        assertEquals("data series A, k=4", 88.5, m, 1e-10);

        m = FileStats.momentFromFile(inputB, 4);
        assertEquals("data series B, k=4", 19845650.0873707, m, 1e-3);

    }

    @Test
    public void standardDeviationTest() throws IOException
    {
        double m;
        
        m = FileStats.standardDeviationFromFile(inputA);
        assertEquals("data series A", Math.sqrt(5.0/3.0), m, 1e-10);

        m = FileStats.standardDeviationFromFile(inputB);
        assertEquals("data series B", 28.5915652909, m, 1e-6);

    }

    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void meanValueFileNotFoundTest() throws IOException
    {
        exception.expect(IOException.class);
        FileStats.meanValueFromFile(inputNonex);
    }

    @Test
    public void momentFileNotFoundTest() throws IOException
    {
        exception.expect(IOException.class);
        FileStats.momentFromFile(inputNonex, 4);
    }
    
    @Test
    public void standardDeviationFileNotFoundTest() throws IOException
    {
        exception.expect(IOException.class);
        FileStats.standardDeviationFromFile(inputNonex);
    }

    @Test
    public void meanValueMismatchTest() throws IOException
    {
        exception.expect(InputMismatchException.class);
        FileStats.meanValueFromFile(inputX1);
    }

    @Test
    public void momentMismatchTest() throws IOException
    {
        exception.expect(InputMismatchException.class);
        FileStats.momentFromFile(inputX1, 4);
    }

    @Test
    public void standarddeviationMismatchTest() throws IOException
    {
        exception.expect(InputMismatchException.class);
        FileStats.standardDeviationFromFile(inputX1);
    }

    @Test
    public void standardDeviationIllegalArgumentTest() throws IOException
    {
        double x = FileStats.standardDeviationFromFile(inputX2);
        assertEquals("Testing too short data series", Double.NaN, x, 0);
    }

}
