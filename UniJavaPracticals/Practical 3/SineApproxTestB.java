import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for sine approximation, part (b)
 *
 */
public class SineApproxTestB
{
    @Test
    public void sineTest()
    {
        assertEquals("Testing x=0", 0.0, SineApprox.sine(0.0, 1e-10), 1e-12);
        assertEquals("Testing x=Pi, e=0.1", 0.00692527, SineApprox.sine(Math.PI, 0.1), 1e-5);
        assertEquals("Testing x=Pi, e=1e-10", 0.0, SineApprox.sine(Math.PI, 1e-10), 1e-9);
        assertEquals("Testing x=Pi/2, e=1e-10", 1.0, SineApprox.sine(Math.PI/2.0, 1e-10), 1e-9);
    }

}
