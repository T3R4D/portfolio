
import static org.junit.Assert.*;

/**
 * Mathematical Skills II, Programming
 * Practical 4
 * Helper class for unit tests in Exercise 4
 *
 */
public class ComplexTestHelper
{
    private ComplexNumber[] saved = new ComplexNumber[10];
 
    public ComplexNumber makeComplexNumber(double r, double i)
    {
        ComplexNumber z = new ComplexNumber();
        z.real = r;
        z.imag = i;
        return z;
    }
    
    public void save(ComplexNumber z, int i)
    {
        saved[i] = makeComplexNumber(z.real, z.imag);
    }

    public void verify(String msg, ComplexNumber z, int i)
    {
        assertComplexEquals(msg, saved[i], z);
    }
    
    public void assertComplexEquals(String msg, ComplexNumber expected, ComplexNumber actual)
    {
        assertEquals(msg+", real part", expected.real, actual.real, 1e-10);
        assertEquals(msg+", imaginary part", expected.imag, actual.imag, 1e-10);
    }

    public String toString(ComplexNumber z)
    {
        return String.format("%f + %f i", z.real, z.imag);
    }

}
