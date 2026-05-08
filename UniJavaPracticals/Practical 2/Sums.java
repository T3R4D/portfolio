/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Computing sums with the help of loops
 */
class Sums
{
    /**
     * Computes the sum in part a) of the exercise
     */
    static double sumPartA()
    {
        int n = 1;
        double sum = 0.0;

        while (n <= 20 )
        {
            sum = pow(n,3) - 2 + sum;
            n= n + 1;
        }
        
        return sum;
    }

    /**
     * Computes the sum in part b) of the exercise.
     */
    static double sumPartB()
    {
        double sum = 0.0;

        for (int j = 2; j <= 100 ; j++)
        {
            sum = log(pow(j,3) - 2) + sum;
        }
        
        return sum;
    }

    /**
     * Computes the sum in part c) of the exercise.
     * The upper limit n of the sum is given as a parameter. n >= 1 is assumed.
     */
    static double sumPartC(int n)
    {
        double sum = 0.0;
        
        for (int j = 1; j<= n; j++)
        {
            sum = sin(4*j) + sum;
        }
        
        return sum;
    }

}
