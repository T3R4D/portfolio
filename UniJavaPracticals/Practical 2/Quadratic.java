/*
 * Mathematical Skills II, Programming
 */

import static java.lang.Math.*;

/**
 * Finding the solutions of quadratics
 */
class Quadratic
{
    /**
     * Quadratic equation solver for the equation ax² + bx + c = 0.
     * Checks whether real solutions of the equation exist, 
     * and if so, computes them.
     */
    static String solveQuadratic(double a, double b, double c)
    {
        String message;
        double discriminant = b * b - 4.0 * a * c;
        
        if (discriminant <= 0) // complete this line
        {
            message = "no real solutions";
        }
        else 
        {
            double root1 = (-b - sqrt(discriminant))/(2*a);
            double root2 = (-b + sqrt(discriminant))/(2*a);
            message = "real solutions: " + root1 + ", " + root2;
        }
        
        return message;
    }
}
