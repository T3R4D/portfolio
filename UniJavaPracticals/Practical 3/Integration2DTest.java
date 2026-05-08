import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for 2-dimensional numerical integration
 */
public class Integration2DTest
{
    @Test
    public void trapeziumTest()
    {
        assertEquals("Testing a=1, n=3", 0.12081934670815049, Integration2D.trapeziumInt2d(1, 3), 1e-10);
        assertEquals("Testing a=5, large n", 0.5022118956 , Integration2D.trapeziumInt2d(5, 1000), 1e-5);
    }


}
