/*
 * Mathematical Skills II, Programming
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for computing sums
 */
public class SumsTest
{
    @Test
    public void sumPartATest() 
    {
        assertEquals(44060, Sums.sumPartA(), 1e-8);
    }
    
    @Test
    public void sumPartBTest() 
    {
        assertEquals(1090.77283802263, Sums.sumPartB(), 1e-8);
    }

    @Test
    public void sumPartCTest() 
    {
        assertEquals("Testing n=1", -0.756802495307928, Sums.sumPartC(1), 1e-8);
        assertEquals("Testing n=2", 0.232555751315454, Sums.sumPartC(2), 1e-8);
        assertEquals("Testing n=3", -0.304017166684981, Sums.sumPartC(3), 1e-8);
        assertEquals("Testing n=10", -0.8886818043249e-2, Sums.sumPartC(10), 1e-8);
        assertEquals("Testing n=100",  -0.774491375828507, Sums.sumPartC(100), 1e-8);
    } 
   
}
