/*
 * Mathematical Skills II, Programming
 * Project 3, 2020/21
 */

import static java.lang.Math.*;
import java.util.*;

/**
 * A class that aims to find the zeros of bicomplex functions using the 
 * secant method
 */
public class ZeroFinder
{
    /**
     * Finds the zero of a function using the secant method
     * 
     * @param f bicomplex number to find the zeros of
     * @param x0 a start value for the algorithm
     * @param x1 an end value for the algorithm
     * @returns Bicomplex Number where a zero occurs
     */  
    public static BicomplexNumber secantMethod(BicomplexFunction f, BicomplexNumber x0, 
        BicomplexNumber x1)
    {
        BicomplexNumber ans = new BicomplexNumber(0, 0, 0, 0);
        BicomplexNumber test = x1.subtract(x0);
        int n = 0;
        
        do
        {
            BicomplexNumber num = x1.subtract(x0);
            BicomplexNumber den = f.valueAt(x1).subtract(f.valueAt(x0));
            ans = x1.subtract(f.valueAt(x1).multiply(num.divide(den)));
            
            x1 = ans;
            x0 = x1;
            test = x1.subtract(x0);
            
            n++;
            if (n == 50)
            {
                throw new ArithmeticException("Sequence does not stabilize.");
            }
        }
        while (test.abs() > pow(10,-10));
        
        return ans;
    }
    
    /**
     * Finds all the zeros of a function in the region |z| < r 
     * using the secant method
     * 
     * @param f bicomplex number to find the zeros of
     * @param r double number (r>0) 
     * @returns List<BicomplexNumber> of all the zeros 
     */  
    public static List<BicomplexNumber> findAllZeros(BicomplexFunction f, double r)
    {
        BicomplexNumber a = new BicomplexNumber(0, 0, 0, 0);
        BicomplexNumber b = new BicomplexNumber(1, 1, 1, 1);
        secantMethod(f, a, b);
        int n = 5;
        BicomplexNumber[] boop = new BicomplexNumber[n];
        List<BicomplexNumber> funky = Arrays.asList(boop);
        return funky;
    }
    
    /**
     * Finds a solution z such that exp(z) = cz
     * 
     * @param c a bicomplex number 
     * @returns a bicomplex number that is a solution to exp(z) = cz 
     */  
    public static BicomplexNumber findSolution(BicomplexNumber c)
    {
        return null;
    }
}
