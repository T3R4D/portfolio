
/*
 * Mathematical Skills II, Programming
 */
 
import static java.lang.Math.*;

/**
 * Verifying Euler's summation result
 */
class EulerSum
{
    /**
     * Computes the sum over k^{-2} for k from 1 to N.
     * The sum is then multiplied with 6/Pi^2,
     * so that the result is expected to be near 1 for large N.
     */
    static double eulerSum(int n)
    {
        double sum = 0.0;
        
        for (int k = 1; k <= n; k++)
        {
            sum = 1/pow(k,2) + sum;
        }
        
        return 6/pow(PI,2)*sum;
        
    }
}
