/*
 * Mathematical Skills II, Programming
 */

/**
 * A demonstration of testing and debugging techniques (Part B)
 */
class BugsB
{
    /**
     * Computes the scalar product of two vectors (a,b,c), (x,y,z) with integer components.
     */
    static int scalarProduct(int a, int b, int c, int x, int y, int z)
    {
        int sum;

        sum = a*x;
        
        sum = sum + b*y;

        sum = sum + c*z;

        return sum;
    }
}
