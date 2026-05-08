/**
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * A problem related to trigonometric functions
 */
class TrigFunctions
{

    
    /**
     * Evaluates the function f, as given on the exercise sheet.
     */
    static double f(double x)
    {
        double a = ((1 - x)*PI)/4;
        double top = 1-tan(a);
        double bottom = cos(a) - sin(a);
        
        return top/bottom;
    }
    
}
