

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit tests for more matrix operations, part (a)
 */
public class MoreMatrixOpsTestA
{
    
    private void testTranspose(double[][] a, double[][] expected)
    {
        String msg = "Testing transpose of "+Arrays.deepToString(a);

        double[][] actual = MoreMatrixOps.transpose(a);
        
        TestHelper.assertMatrixEquals(msg, expected, actual);
        
    }
    
    @Test
    public void transposeNullTest()
    {
        testTranspose(null, null);
        
    }

    @Test
    public void transposeDiagonalTest()
    {
        double[][] a, t;
        
        a = new double[][] { {2} };
        t = new double[][] { {2} };
        testTranspose(a, t);
        
        a = new double[][] { {2, 0, 0}, {0, 4, 0}, {0, 0, 8} };
        t = new double[][] { {2, 0, 0}, {0, 4, 0}, {0, 0, 8} };
        testTranspose(a, t);
    }

    @Test
    public void transposeFullTest()
    {
        double[][] a, t;
        
        a = new double[][] { {0.1, 2, 3, 4}, {5, 6, 7, 8}, {-1, -2, -3, -4}, {-5, -6, -7, -8} };
        t = new double[][] { {0.1, 5, -1, -5}, {2, 6, -2, -6}, {3, 7, -3, -7}, {4, 8, -4, -8} };
        testTranspose(a, t);
        
    }

}
