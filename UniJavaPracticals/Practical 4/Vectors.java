import static java.lang.Math.*;

/**
 * Some exercises related to vectors.
 */
class Vectors
{

    // The following code was taken from the examples in Lecture 6 and 7.
    
    /**
     * Returns the k-th standard unit vector in n-dimensional space.
     * It is assumed that n > 0 and 0 <= k < n.
     */
    static double[] unitVector(int k, int n)
    {
        double[] result = new double[n];
        result[k] = 1.0;
        return result;
    }

    /**
     * Computes the sum of two vectors a and b.
     * If the vectors are not of equal dimension, 
     * or if any of them is null, the function will return null.
     * If the vectors are of length zero, then so will the output vector be.
     */
    static double[] sum(double[] a, double[] b)
    {
        if (a == null || b == null)
        {
            return null;
        }

        int n = a.length;
        if (n != b.length)
        {
            return null;
        }

        double[] c = new double[n];
        for (int i = 0; i < n; i++) 
        {
            c[i] = a[i] + b[i];
        }

        return c;
    }

    // Add any code developed in Practical 4 here.
    
    static double[] scalarMult(double c, double[] x)
    {
        if (x == null)
        {
            return null;
        }
        
        int n = x.length;
        if (n == 0)
        {
            return x;
        }
        
        double[] y = new double[n];
        for (int i = 0; i <n; i++)
        {
            y[i] = c*x[i];
        }
        
        return y;
    }
    
    static double scalarProduct(double[] x, double[] y)
    {
        double sum = 0;
        
        if (x == null || y == null)
        {
            return Double.NaN;
        }

        int n = x.length;
        if (n != y.length)
        {
            return Double.NaN;
        }
        
        for (int i = 0; i < n; i++)
        {
            sum = sum + x[i]*y[i];
        }
        
        return sum;
    }
    
    static double vectorComputation()
    {
        double ans = 0;
        
        double[] a = new double[4];
        a[0] = 1; a[1] = 2; 
        a[2] = 3; a[3] = 4;
        
        double [] b = new double[4];
        b[0] = 0.4; b[1] = 0.3; 
        b[2] = 0.2; b[3] = 0.1;
        
        double [] c = new double[4];
        c[0] = -1; c[1] = 0; 
        c[2] =  3; c[3] = 2;
        
        double m = 2.9;
        b = scalarMult(m,b);
        a = sum(a,b);
        
        ans = scalarProduct(c,a);
        
        return ans;
    }
}
