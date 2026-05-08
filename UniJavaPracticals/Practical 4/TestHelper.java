import static org.junit.Assert.*;
/**
 * Some auxiliary routines used in the unit tests.
 * Please do not modify this file.
 * 
 */
public class TestHelper
{
    public static double[][] copyMatrix (double[][] a)
    {
        if (a == null)
        {
            return null;
        }
        
        double[][] b = new double[a.length][];
        for (int i = 0; i < a.length; i++)
        {
            b[i] = a[i].clone();            
        }        
        return b;
    }

    public static void assertMatrixEquals(String msg, double[][] expected, double[][] actual)
    {
        if (expected == null )
        {
            assertNull(msg, actual);
        }
        else 
        {
            assertNotNull(msg, actual);
            
            assertEquals(msg+" - comparing length", expected.length, actual.length);
            
            for (int i = 0; i < expected.length; i++)
            {
                assertArrayEquals(msg+" - row "+i, expected[i], actual[i], 1e-10);
            }
        }
    }
}
