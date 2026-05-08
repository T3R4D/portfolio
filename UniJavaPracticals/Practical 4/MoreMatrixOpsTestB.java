

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit tests for more matrix operations, part (b)
 */
public class MoreMatrixOpsTestB
{
    
    private void testProduct(double[][] a, double[][] b, double[][] expected)
    {
        String msg = "Testing product of "+Arrays.deepToString(a)+" with "+Arrays.deepToString(b);

        double[][] acopy = TestHelper.copyMatrix(a);
        double[][] bcopy = TestHelper.copyMatrix(b);
        
        double[][] actual = MoreMatrixOps.matrixProduct(a,b);
        
        TestHelper.assertMatrixEquals(msg, expected, actual);
        
        TestHelper.assertMatrixEquals(msg + "; was A modified?", acopy, a);
        TestHelper.assertMatrixEquals(msg + "; was B modified?", bcopy, b);
        
    }
    
    @Test
    public void matrixProductNullTest()
    {
        double[][] a = {  {1,2,3}, {4,5,6}, {7,8,9} };
        testProduct(null, a, null);
        testProduct(a, null, null);
        testProduct(null, null, null);        
    }

    @Test
    public void matrixProductDimensionTest()
    {
        double[][] a, b;        
        
        a = new double[][] { {1,2,3}, {4,5,6}, {7,8,9} };
        b = new double[][] { {1,2}, {4,5}, {7,8}, {9,10} };
        testProduct(a, b, null);

        a = new double[][] {  {1} };
        b = new double[][] {  {1,2}, {4,5}, {7,8} };
        testProduct(a, b, null);
    }

    @Test
    public void matrixProductFullTest()
    {
        double[][] a, b, c;

        a = new double[][]{  {0.1,0.2}, {0.3,0.4}, {0.5,0.6}, {0.7,0.8} };
        b = new double[][]{  {1,2, 3, 4}, {5,6,7,8} };
        c = new double[][]{ {1.1, 1.4, 1.7, 2},
                            {2.3, 3, 3.7, 4.4},
                            {3.5, 4.6, 5.7, 6.8},
                            {4.7, 6.2, 7.7, 9.2} };
        
        testProduct(a, b, c);

    }

    @Test
    public void matrixProductIdentityTest()
    {
        double[][] a, b, c;

        a = new double[][]{  {0.1, 0.2, 0.3}, {0.3, 0.4, 0.5}, {0.6,0.7, 0.8}};
        b = new double[][]{  {1,0,0}, {0,1,0}, {0,0,1} };
        
        testProduct(a, b, a);
        testProduct(b, a, a);

    }
}
