import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for matrix operations
 */
public class MatrixOpsTest
{
    @Test
    public void constantMatrixTest()
    {
        double[][] m = MatrixOps.constantMatrix();
        assertEquals("Checking number of rows", 3, m.length);
        for (int i = 0; i < 3; i++) {
            assertEquals("Checking row "+i+", number of columns", 4, m[i].length);
        }
        assertArrayEquals("Checking values in row 0", new double[]{1, 2, 3, 4},   m[0], 1e-10);
        assertArrayEquals("Checking values in row 1", new double[]{2, 3, 4, 5},   m[1], 1e-10);
        assertArrayEquals("Checking values in row 1", new double[]{3, 4, 5, 0.6}, m[2], 1e-10);
    }

    @Test
    public void matrixSumTest()
    {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{0.1, 0.2},{0.3, 0.4}};
        double[][] c = {{1.1, 2.2},{3.3, 4.4}};
        String msg = "Adding "+Arrays.deepToString(a)+" and "+Arrays.deepToString(b);
        TestHelper.assertMatrixEquals(msg, c, MatrixOps.matrixSum(a, b));

        a = new double[][]{{1, 2, -1, -2}, {3, 4, -3, -4}, {5, 6, -5, -6}};
        b = new double[][]{{0.1, 0.2, -0.1, -0.2}, {0.3, 0.4, -0.3, -0.4}, {0.5, 0.6, -0.5, -0.6}};
        c = new double[][]{{1.1, 2.2, -1.1, -2.2}, {3.3, 4.4, -3.3, -4.4}, {5.5, 6.6, -5.5, -6.6}};
        msg = "Adding "+Arrays.deepToString(a)+" and "+Arrays.deepToString(b);
        TestHelper.assertMatrixEquals(msg, c, MatrixOps.matrixSum(a, b));
    }

    @Test
    public void matrixDifferenceTest()
    {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{0.1, 0.2},{0.3, 0.4}};
        double[][] c = {{0.9, 1.8},{2.7, 3.6}};
        String msg = "Subtracting "+Arrays.deepToString(b)+" from "+Arrays.deepToString(a);
        TestHelper.assertMatrixEquals(msg, c, MatrixOps.matrixDifference(a, b));

        a = new double[][]{{1, 2, -1, -2}, {3, 4, -3, -4}, {5, 6, -5, -6}};
        b = new double[][]{{0.1, 0.2, -0.1, -0.2}, {0.3, 0.4, -0.3, -0.4}, {0.5, 0.6, -0.5, -0.6}};
        c = new double[][]{{0.9, 1.8, -0.9, -1.8}, {2.7, 3.6, -2.7, -3.6}, {4.5, 5.4, -4.5, -5.4}};
        msg = "Subtracting "+Arrays.deepToString(a)+" from "+Arrays.deepToString(a);
        TestHelper.assertMatrixEquals(msg, c, MatrixOps.matrixDifference(a, b));
    }
    
}
