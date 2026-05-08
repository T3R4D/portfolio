
import static org.junit.Assert.*;

/**
 * Mathematical Skills II, Programming
 * Practical 7
 * Helper class for unit tests in Exercise 3
 * 
 */
public class ComplexTestHelper
{
    private ComplexNumber[] saved = new ComplexNumber[10];
    
    public void save(ComplexNumber z, int i)
    {
        saved[i] = new ComplexNumber(z.realPart(), z.imaginaryPart());
    }

    public void verify(String msg, ComplexNumber z, int i)
    {
        assertComplexEquals(msg, saved[i], z);
    }
    
    public void assertComplexEquals(String msg, ComplexNumber expected, ComplexNumber actual)
    {
        assertEquals(msg+", real part", expected.realPart(), actual.realPart(), 1e-10);
        assertEquals(msg+", imaginary part", expected.imaginaryPart(), actual.imaginaryPart(), 1e-10);
    }

}
