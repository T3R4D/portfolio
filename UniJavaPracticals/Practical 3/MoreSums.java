/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;


class MoreSums
{
    /* 
     * In this exercise, you need to write the function declarations on your own! 
     * The following template may be useful in particular for part (a). 
     */
    static int sumA(int n)
    {
        int sum = 0;
                
        for (int k = 1; k <= n; k++)
        {
            sum = sum + (k*k-1);
        }
        
        return sum;
    }
    
    static double sumB(int n)
    {
        double sum = 0;
        
        if (n >= 3)
        {
            for (int j = 3; j <= n; j++)
            {
                double a = j;
                double b = 2*j - 5;
                double frac = a/b;
                
                sum = sum + frac;
            }
        }
        else
        {
            sum = 0;
        }
        
        return sum;
    }
    
    static double sumC(int m, double x)
    {
        double sum = 0;
        
        if (m>=0)
        {
            for (int k = 0; k <= m; k++)
            {
                sum = sum + exp(k*x/2);
            }
        }
        else
        {
            sum = 0;
        }
        
        return sum;
    }
    
    static long productD(int n)
    {
        long sum = 0;   
        if (n >= 0)
        {
            sum = 1;
            for (int k = 1; k <= n; k++)
            {
                sum = sum*(k*k + 2);
            }
        }
        else 
        {
            sum = 0;
        }
        
        return sum;
    }
    
    static double sumE(int n, double a, double b)
    {
        double sum = 0;
        
        if(n >= 0)
        {
            for (int k = 0; k <= n; k++)
            {
                for (int j = 0; j <= k; j++)
                {
                    sum = sum + 1/(1 + a*j*j + b*k*k);
                }
            }
        }
        else
        {
            sum = 0;
        }
        
        return sum;
    }
    
    static double sumF(int n)
    {
        double sum = 0;
        
        for (int a = 1; a <= n; a++)
        {
            double even = sqrt(pow(2,a));
            double odd = sqrt(pow(2,a)+1);
            sum = sum + even + odd;
        }
        
        return sum;
    }
    
}
