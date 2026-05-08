/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Some functions on the real line
 */
class SomeFunctions
{
    /**
     * Evaluates the function f1 (as given on the exercise sheet)
     */
    static double f1(double x)
    {
        return 2*x - 4; // Change this 0.0 to something more meaningful.
    }

    /**
     * Evaluates the function f2 (as given on the exercise sheet)
     */
    static double f2(double x)
    {
        return pow(x,3) + 3*x - 7;
    }

    /**
     * Evaluates the function f3 (as given on the exercise sheet)
     */
    static double f3(double x)
    {
        return cos(x) + tan(x);
    }

    /**
     * Evaluates the function f4 (as given on the exercise sheet)
     */
    static double f4(double x)
    {
        return exp(2*x) + 5.7;
    }

    /**
     * Evaluates the function f5 (as given on the exercise sheet)
     */
    static double f5(double x)
    {
        return 7*sqrt(pow(x,4)+PI);
    }

    /**
     * Evaluates the function f6 (as given on the exercise sheet)
     */
    static double f6(double x)
    {
        double y = sqrt(pow(x,2) + 1);
        
        return pow(y,3) + 2*pow(y,4) + sin(PI * y);
    }

    /**
     * Evaluates the function f7 (as given on the exercise sheet)
     */
    static double f7(double x)
    {
        double top = log(cos(x) + 2);
        double bottom = pow(x,2) + 1;
        double other = pow(abs(x), 0.2);
        
        return (top/bottom) + other;
    }

    /**
     * Evaluates the function f8 (as given on the exercise sheet)
     */
    static double f8(double x)
    {
        double a = pow(x,2)/2 + 3;
        a = floor(a);
        
        return exp(a*x);
    }

    /**
     * Evaluates the function f9 (as given on the exercise sheet)
     */
    static double f9(double x)
    {
        double top = 12*exp(-x) - 15 - 2*x;
        double bottom = 9 + pow(x,2);
        
        return top/bottom;
    }

}
