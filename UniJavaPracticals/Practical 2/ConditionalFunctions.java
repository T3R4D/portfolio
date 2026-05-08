
/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Some functions that involve conditionals
 */
class ConditionalFunctions
{

    /**
     * Evaluates the function f1 (as given on the exercise sheet)
     */
    static double f1(double x)
    {
        double f1;
        if ( x >= 2 ) 
        {
           f1 = 3*x + 4;
        }
        else
        {
           f1 = 0;
        }  
               
        return f1;
    }

    /**
     * Evaluates the function f2 (as given on the exercise sheet)
     */
    static double f2(double x)
    {
        double f2;
        if ( x >= 1 ) 
        {
           f2 = x/3;
        }
        else
        {
           f2 = x/5;
        }  
               
        return f2;
    }

    /**
     * Evaluates the function f3 (as given on the exercise sheet)
     */
    static double f3(double x)
    {
        double f3;
        if ( x >= 5 ) 
        {
           f3 = pow(x,2);
        }
        else if ( x >= 1 && x < 5)
        {
           f3 = 2*pow(x,3);
        }
        else
        {
           f3 = 3*pow(x,4);
        }  
               
        return f3;
    }

    /**
     * Evaluates the function f4 (as given on the exercise sheet)
     */
    static double f4(double x)
    {
        double f4;
        if ( x > -1 && x < 3 ) 
        {
           f4 = exp(x/2);
        }
        else
        {
           f4 = exp(-2*x);
        }  
               
        return f4;   
    }

    /**
     * Evaluates the function f5 (as given on the exercise sheet)
     */
    static double f5(double x)
    {
        double f5;
        if ( cos(x) > 0.5 )
        {
           f5 = 2*cos(x);
        }
        else
        {
           f5 = -1*sin(2*x);
        }  
               
        return f5;   
    }

    /**
     * Evaluates the function f6 (as given on the exercise sheet)
     */
    static double f6(double x)
    {
        double f6;
        if ( x > 0 ) 
        {
           f6 = sin(x)/x;
        }
        else
        {
           f6 = Double.NaN;
        }  
               
        return f6;   
    }

    /**
     * Evaluates the function f7 (as given on the exercise sheet)
     */
    static double f7(double x)
    {
        double f7;
        if ( x >= -3 && x <= 5 ) 
        {
           f7 = pow(4,x+4)*atan(x);
        }
        else
        {
           f7 = Double.NaN;
        }  
               
        return f7;
    }

    /**
     * Evaluates the function f8 (as given on the exercise sheet)
     */
    static double f8(double x)
    {
        double f8;
        double y = pow(x,4) - 4*x + 1;
        double z = pow(y,2) - 1;
        double a = pow(y,2)/z;
        
        if ( z > 0 ) 
        {
           f8 = log(a + sqrt(a*a-1));
        }
        else
        {
           f8 = Double.NaN;
        }  
               
        return f8;   
    }

}
