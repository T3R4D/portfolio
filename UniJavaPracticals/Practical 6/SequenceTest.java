/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 
 
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Unit tests for writing sequence to a file
 */
public class SequenceTest
{

    private void testSequenceFile(int n, int testN, long expected) throws Exception
    {
        String filename = "unittest_out_sequence_" + n + ".txt";
        String msg = "testing n="+n+", a_"+testN;
        
        Sequence.writeToFile(filename, n);
        
        File inFile = new File(filename);
        Scanner s = new Scanner(inFile);
        
        try
        {
            for (int i = 0; i < testN; i++)
            {
                s.nextLine();
            }
            String as = s.nextLine();
            long actual = Long.parseLong(as);
            assertEquals(msg, expected, actual);        
            
            for (int i = testN+1; i <= n; i++)
            {
                s.nextLine();
            }
            assertFalse("File seems to contain too many numbers (n="+n+")", s.hasNextLong());
        }
        catch (NoSuchElementException e)
        {
            fail(msg + ": unexpected end of file");
        }
        catch (NumberFormatException e)
        {
            fail(msg + ": invalid number ("+e.getMessage()+")");
        }
        
    }

    @Test
    public void sequenceShortTest() throws Exception
    {
        testSequenceFile(10, 0, 3);
        testSequenceFile(10, 1, 1);
        testSequenceFile(10, 2, 5);
    }

    @Test
    public void sequenceLongTest() throws Exception
    {
        testSequenceFile(50, 49, -375299968947539L);
    }


}
