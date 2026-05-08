
/**
 * Some more matrix operations
 */
public class MoreMatrixOps
{
    // add your code here
    
    static double[][] transpose(double[][] a)
    {
        if (a == null)
        {
            return null;
        }
        
        int m = a.length;
        int n = a[0].length;
        
        double[][] at = new double[m][n];
        
        for (int row = 0; row < m; row++) 
        {
            for (int col = 0; col < n; col++) 
            {
                at[row][col] = a[col][row];
            }
        }      
        
        return at;
    }
    
    static double[][] matrixProduct(double[][] a, double[][] b)
    {
        if (a == null)
        {
            return null;
        }
        else if (b == null)
        {
            return null;
        }
        
        int m = a.length;
        int n = a[0].length;
        if(n != b.length)
        {
            return null;
        }
        int p = b[0].length;
        
        double[][] ans = new double [m][p];
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < p; j++)
            {
                ans[i][j] = 0.00000;
            }
        }
        
        for (int i = 0; i < m; i++) 
        { 
            for (int j = 0; j < p; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return ans;
    }
    
}
