/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Approximation of the sine function "from first principles" 
 */
class SineApprox
{

    static double factorial(int n)
    {
        double ans = 1;
        
        for (int i = 1; i <= n; i++)
        {
            ans = ans*i;
        }
        
        return ans;
    }
    
    static double sine(double x, double e)
    {
        int k = 1;
        double v;
        double sum = 0.0;
                
        do
        {
            v = (pow(-1, k) * pow(x,2*k + 1))/factorial(2*k+1);
            sum = sum + v;
            k++;
           
        }
        while (abs(v) > e);
        
        return sum;
        
    }
}
