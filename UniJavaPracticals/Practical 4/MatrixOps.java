
/**
 * Matrix operations
 */
class MatrixOps
{

    /**
     * Returns a certain constant 3x4 matrix, see exercise sheet.
     * 
     * @return a 3x4 matrix
     */
    static double[][] constantMatrix()
    {  
        double[][] m = { {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 0.6}}; 
        return m;
    }

    /**
     * Computes the sum of two matrices a and b (which are assumed to be 
     * non-null and of equal dimension).
     * 
     * @param a the first summand
     * @param b the second summand
     * @return a+b as a new matrix (2-d array).
     */
    static double[][] matrixSum(double[][] a, double[][] b)
    {        
        int m = a.length;
        int n = a[0].length;

        double[][] c = new double[m][n];

        for (int row = 0; row < m; row++) 
        {
            for (int col = 0; col < n; col++) 
            {
                c[row][col] = a[row][col]+b[row][col];
            }
        }           

        return c;
    }

    /**
     * Computes the difference a-b of two matrices a and b 
     * (which are assumed to be non-null and of equal dimension).
     * 
     * @param a a matrix
     * @param b another matrix
     * @return a-b as a new matrix (2-d array).
     */
    static double[][] matrixDifference(double[][] a, double[][] b)
    {        
        int m = a.length;
        int n = a[0].length;
 
        
        double[][] c = new double[m][n];

        for (int row = 0; row < m; row++) 
        {
            for (int col = 0; col < n; col++) 
            {
                c[row][col] = a[row][col] - b[row][col];
            }
        }           

        return c;
    }

}
