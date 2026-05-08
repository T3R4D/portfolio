
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for vector-related exercises, part (b)
 */
public class VectorsTestB
{
    private static double[] v0 = {};
    private static double[] v1 = {2};
    private static double[] v1p = {-3};
    private static double[] v2 = {1, 2};
    private static double[] v2p = {2, 3};
    private static double[] v5 = {-2, -1, 0, 1, 2};
    private static double[] v5p = {0, 5, 0, -6, 0.1};

    @Test
    public void scalarProductTest()
    {

        assertEquals("Testing vectors "+Arrays.toString(v1)+" and "+Arrays.toString(v1p),
                     -6.0, Vectors.scalarProduct(v1, v1p), 1e-10);
                     
        assertEquals("Testing vectors "+Arrays.toString(v2)+" and "+Arrays.toString(v2p),
                     8.0, Vectors.scalarProduct(v2, v2p), 1e-10);
                     
        assertEquals("Testing vectors "+Arrays.toString(v5)+" and "+Arrays.toString(v5p),
                     -10.8, Vectors.scalarProduct(v5, v5p), 1e-10);

    }

    
    @Test
    public void scalarProductExceptionalValueTest()
    {
        assertEquals("Testing null vector (1st argument)", Double.NaN, Vectors.scalarProduct(null, v1), 1e-10);
        assertEquals("Testing null vector (2nd argument)", Double.NaN, Vectors.scalarProduct(v1, null), 1e-10);
        assertEquals("Testing zero-length vector", 0.0, Vectors.scalarProduct(v0, v0), 1e-10);
        assertEquals("Testing vectors of different length", Double.NaN, Vectors.scalarProduct(v2, v5), 1e-10);
    }
}
