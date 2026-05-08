import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for computations with complex numbers, part (a)
 */
public class ComplexTestB
{
    @Test
    public void conjugateTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z;
        
        z = h.makeComplexNumber(2,3);
        h.save(z, 0);
        h.assertComplexEquals("Conjugating 2+3i", h.makeComplexNumber(2,-3), ComplexComputation.conjugate(z));
        h.verify("checking whether z has changed", z, 0);
        
    }
}
