
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the PlanarAngle class.
 */
public class PlanarAngleTest
{
    @Test
    public void radiansTest()
    {
        PlanarAngle a = new PlanarAngle(0.5);
        assertEquals("Testing angle 0.5", a.asRadians(), 0.5, 1e-10);
        
        PlanarAngle b = new PlanarAngle(Math.PI);
        assertEquals("Testing angle pi", b.asRadians(), Math.PI, 1e-10);

    }

    @Test
    public void degreeTest()
    {
        PlanarAngle a = new PlanarAngle(Math.PI/4);
        assertEquals("Testing angle pi/4", a.asDegrees(), 45, 1e-10);
        
        PlanarAngle b = new PlanarAngle(Math.PI);
        assertEquals("Testing angle pi", b.asDegrees(), 180, 1e-10);

    }

}
