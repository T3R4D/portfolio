/*
 * Mathematical Skills II, Programming
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for the quadratic solver
 */
public class QuadraticTest
{
    
    @Test
    public void quadraticSolverTestNoSolutions()
    {
        assertEquals("Testing a=1, b=0, c=1", 
        "no real solutions", Quadratic.solveQuadratic(1, 0, 1));
        assertEquals("Testing a=1, b=-2, c=6", 
        "no real solutions", Quadratic.solveQuadratic(1, -2, 6));
        assertEquals("Testing a=10, b=-20, c=60", 
        "no real solutions", Quadratic.solveQuadratic(10, -20, 60));
    }

    private void testSolutions(double a, double b, double c, double expect0, double expect1)
    {
        String message = "Testing a="+a+", b="+b+", c="+c+", ";
        String solved = Quadratic.solveQuadratic(a, b, c);
        
        String expectedPrefix = "real solutions: ";
        assertEquals("Message prefix", expectedPrefix, solved.substring(0, expectedPrefix.length()));
        
        String[] solString = solved.substring(expectedPrefix.length()).split(",");
        double[] solDouble = new double[2];
        for (int i = 0; i < 2; i++)
        {
            solDouble[i] = Double.parseDouble(solString[i]);
        }
        assertEquals( message + "smaller solution", expect0, solDouble[0], 1e-8);
        assertEquals( message + "larger solution", expect1, solDouble[1], 1e-8);
        
    }
    
    @Test
    public void quadraticSolverTestTwoSolutions()
    {
        testSolutions(1, 0, -1, -1, 1);
        testSolutions(1, -3, 2, 1, 2);
        testSolutions(10, -30, 20, 1, 2);
        testSolutions(1, 0, -2, -1.4142135623730950488, 1.4142135623730950488);
    }
    
}
