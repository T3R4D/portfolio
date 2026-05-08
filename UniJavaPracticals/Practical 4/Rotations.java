import static java.lang.Math.*;

/**
 * Rotation matrices
 */
class Rotations
{

    /**
     * From Lesson 15:
     * 
     * Computes the product ax, where a is an m x n matrix and x is an n-dimensional vector.
     * 
     * It is assumed that the parameters are non-null and that the dimensions of the matrix and
     * the vector are consistent to make the product work.
     * 
     * @param a the matrix a as a two-dimensional array
     * @param x the vector x as a one-dimensional array
     * @return the vector a.x as a one-dimensional array
     */
    static double[] matrixTimesVector(double[][] a, double[] x)
    {        
        int n = x.length;
        int m = a.length;

        double[] y = new double[m];

        for (int row = 0; row < m; row++) 
        {
            double sum = 0;
            for (int col = 0; col < n; col++) 
            {
                sum = sum + a[row][col] * x[col];
            }
            y[row] = sum;
        }           

        return y;

    }
   
    // add your code here
      
    
    static double[][] rotationMatrix(int axis, double theta)
    {
        if (axis == 1)
        {
            double[][] Rx = 
            {{1, 0, 0,},
            {0, cos(theta), -sin(theta)},
            {0, sin(theta), cos(theta)}};
            
            return Rx;
        }
        else if (axis == 2)
        {
            double[][] Ry =
            {{cos(theta), 0, sin(theta)},
            {0, 1, 0},
            {-sin(theta), 0, cos(theta)}};
            
            return Ry;
        }
        else if (axis == 3)
        {
            double[][] Rz =
            {{cos(theta), -sin(theta), 0},
            {sin(theta), cos(theta), 0},
            {0, 0, 1}};
            
            return Rz;
        }
        
        return null;
    }
    
    static double[] rotateVector(double[] v, double x, double y, double z)
    {
        double[][] Rx = rotationMatrix(1, x);
        v = matrixTimesVector(Rx, v);
        
        double[][] Ry = rotationMatrix(2, y);
        v = matrixTimesVector(Ry, v);
        
        double[][] Rz = rotationMatrix(3, z);
        v = matrixTimesVector(Rz, v);
        
        
        return v;
    }
    
    static double[] rotateThisVector()
    {
        double[] v = {1, 3, 2};
                
        double x = PI/3;
        double y = 0;
        double z = -PI/6;
        
        v = rotateVector(v, x, y, z);
        
        return v;
    }
}
