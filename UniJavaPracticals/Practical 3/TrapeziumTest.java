import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for Trapezium rule
 *
 */
public class TrapeziumTest
{
    @Test
    public void fTest()
    {
        assertEquals("Testing at x=0", 1.0, Trapezium.f(0.0), 1e-12);
        assertEquals("Testing at x=1", 0.0497870683678639, Trapezium.f(1.0), 1e-12);
        assertEquals("Testing at x=-1", 0.0497870683678639, Trapezium.f(-1.0), 1e-12);
        assertEquals("Testing at x=2", 0.00000614421235332821, Trapezium.f(2.0), 1e-12);
        assertEquals("Testing at x=-2", 0.00000614421235332821, Trapezium.f(-2.0), 1e-12);
    }

    @Test
    public void trapeziumIntTest()
    {
        assertEquals("Testing a=0, b=1", (1+Math.exp(-3))/2, Trapezium.trapeziumInt(0, 1), 1e-12);
        assertEquals("Testing a=-1, b=0", (1+Math.exp(-3))/2, Trapezium.trapeziumInt(-1, 0), 1e-12);
        assertEquals("Testing a=-1, b=1", 2.0*Math.exp(-3), Trapezium.trapeziumInt(-1, 1), 1e-12);
        assertEquals("Testing a=0.5, b=1.2", 0.169983252699210, Trapezium.trapeziumInt(0.5, 1.2), 1e-12);
    }

    @Test
    public void compositeTrapeziumIntTest()
    {
        assertEquals("Testing a=0, b=1, n=1", (1+Math.exp(-3))/2, Trapezium.compositeTrapeziumInt(0, 1, 1), 1e-12);
        assertEquals("Testing a=0.5, b=1.2, n=1", 0.169983252699210, Trapezium.compositeTrapeziumInt(0.5, 1.2, 1), 1e-12);
        assertEquals("Testing a=-1, b=1, n=2", (1+Math.exp(-3)), Trapezium.compositeTrapeziumInt(-1, 1, 2), 1e-12);
        assertEquals("Testing a=0.5, b=1.1, n=3", 0.113480737268810, Trapezium.compositeTrapeziumInt(0.5, 1.1, 3), 1e-12);
        assertEquals("Testing a=-2, b=3, n=10000", 1.02332621503191, Trapezium.compositeTrapeziumInt(-2, 3, 10000), 1e-5);

    }

}
