/*
 * Mathematical Skills II, Programming
 */
 
 import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for Euler's summation result
 *
 */
public class EulerSumTest
{
    @Test
    public void eulersumTestSmallN()
    {
        double sops = 6.0 / Math.PI / Math.PI;
        assertEquals("Testing at N=1", sops, EulerSum.eulerSum(1), 1e-12);
        assertEquals("Testing at N=2", sops*5.0/4.0, EulerSum.eulerSum(2), 1e-12);
        assertEquals("Testing at N=3", sops*49.0/36.0, EulerSum.eulerSum(3), 1e-12);
        assertEquals("Testing at N=10", 0.942145805354967, EulerSum.eulerSum(10), 1e-12);
    }

    @Test
    public void eulersumTestLargeN()
    {
        assertEquals("Testing at N=1000",    0.99939237676, EulerSum.eulerSum(1000), 1e-9);
        assertEquals("Testing at N=10000",   0.99993921032, EulerSum.eulerSum(10000), 1e-9);
        assertEquals("Testing at N=1000000", 0.99999939207, EulerSum.eulerSum(1000000), 1e-9);
    }

}
