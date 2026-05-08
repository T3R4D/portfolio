/*
 * Mathematical Skills II, Programming
 */

/**
 * A demonstration of testing and debugging techniques (Part A)
 */
class BugsA
{
    /**
     * Computes the norm-squared of a vector (x,y,z) with integer components.
     */
    static int normSquared(int x, int y, int z)
    {
        int sum;

        sum = x*x;
        
        sum = sum + y*y;

        sum = sum + z*z;

        return sum;
    }
}
