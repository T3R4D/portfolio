import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for sine approximation, part (a)
 *
 */
public class SineApproxTestA
{
    @Test
    public void factorialTest()
    {
        assertEquals("Testing n=1", 1.0, SineApprox.factorial(1), 1e-12);
        assertEquals("Testing n=2", 2.0, SineApprox.factorial(2), 1e-12);
        assertEquals("Testing n=3", 6.0, SineApprox.factorial(3), 1e-12);
        assertEquals("Testing n=10", 3628800.0, SineApprox.factorial(10), 1e-3);
        assertEquals("Testing n=20", 2432902008176640000.0, SineApprox.factorial(20), 1e5);
    }

}
