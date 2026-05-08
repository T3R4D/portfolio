
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for vector-related exercises, part (a)
 */
public class VectorsTestA
{
    private static double[] v0 = {};
    private static double[] v1 = {2};
    private static double[] v1p = {-3};
    private static double[] v2 = {1, 2};
    private static double[] v2p = {2, 3};
    private static double[] v5 = {-2, -1, 0, 1, 2};
    private static double[] v5p = {0, 5, 0, -6, 0.1};

    private void testOneScalarMult(double[] expected, double factor, double[] vector)
    {
        String msg = "Testing factor "+factor+", vector "+Arrays.toString(vector);
        double[] vector1 = Arrays.copyOf(vector, vector.length);
        
        assertArrayEquals(msg, expected, Vectors.scalarMult(factor, vector1), 1e-10);        

        msg = "Checking whether input vector "+Arrays.toString(vector)+" has been modified";
        assertArrayEquals(msg, vector, vector1, 1e-10);        

    }
    
    @Test
    public void scalarMultTest()
    {
        double[] s,t;

        testOneScalarMult(new double[]{10.0}, 5, v1);
        testOneScalarMult(new double[]{5.0, 10.0}, 5, v2);
        testOneScalarMult(new double[]{-5.0, -10.0}, -5, v2);
        testOneScalarMult(new double[]{0.0, 0.0}, 0, v2);
        testOneScalarMult(new double[]{2.2, 1.1, 0.0, -1.1, -2.2}, -1.1, v5);
    }
    
    @Test
    public void scalarMultExceptionalValueTest()
    {
        
        assertEquals("Testing null vector", null, Vectors.scalarMult(5, null));
        assertArrayEquals("Testing zero-length vector", v0, Vectors.scalarMult(5, v0), 1e-10);

    }

}
