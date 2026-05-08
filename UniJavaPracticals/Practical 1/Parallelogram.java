
/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Computing the area of a parallelogram from the coordinates of its corners
 */
class Parallelogram
{
    /**
     * Compute the area of the parallelogram enclosed by the two vectors (x1, y1) and (x2, y2).
     */
    static double parallelogramArea(double x1, double y1, double x2, double y2)
    {
        double sum;
        
        sum = x1*y2;
        
        sum = sum - x2*y1;
        
        return sum;
    }
}
