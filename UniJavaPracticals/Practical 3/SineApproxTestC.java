import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for sine approximation, part (c)
 *
 */
public class SineApproxTestC
{
    @Test
    public void sineLargeDomainTest()
    {
        assertEquals("Testing x=0", 0.0, SineApprox.sineLargeDomain(0.0, 1e-10), 1e-12);
        assertEquals("Testing x=Pi, e=0.1", 0.00692527, SineApprox.sineLargeDomain(Math.PI, 0.1), 1e-5);
        assertEquals("Testing x=Pi, e=1e-10", 0.0, SineApprox.sineLargeDomain(Math.PI, 1e-10), 1e-9);
        assertEquals("Testing x=5*Pi/2, e=1e-10", 1.0, SineApprox.sineLargeDomain(5.0*Math.PI/2.0, 1e-10), 1e-9);
        assertEquals("Testing x=100*Pi, e=1e-10", 0.0, SineApprox.sineLargeDomain(100.0*Math.PI, 1e-10), 1e-9);
        assertEquals("Testing x=100.5*Pi, e=1e-10", 1.0, SineApprox.sineLargeDomain(100.5*Math.PI, 1e-10), 1e-9);
    }

}
