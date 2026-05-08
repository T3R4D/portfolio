import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for computations with complex numbers, part (c)
 */
public class ComplexTestC
{
    private void testMultiplication(double zr, double zi, double wr, double wi, double er, double ei)
    {
        ComplexTestHelper h = new ComplexTestHelper();

        ComplexNumber z = h.makeComplexNumber(zr,zi);
        ComplexNumber w = h.makeComplexNumber(wr,wi);
        ComplexNumber expected = h.makeComplexNumber(er,ei);
        
        String msg = "Multiplication of "+h.toString(z)+" with "+h.toString(w);

        h.save(z, 0);
        h.save(w, 1);
        h.assertComplexEquals(msg, expected, ComplexComputation.multiply(z,w));
        h.verify(msg+", checking whether z has changed", z, 0);
        h.verify(msg+", checking whether w has changed", w, 1);

    }
    
    @Test
    public void multiplyTest()
    {
        testMultiplication(1, 0, 1, 0, 1, 0);
        testMultiplication(1, 0, -1, 0, -1, 0);
        testMultiplication(-1, 0, 1, 0, -1, 0);
        testMultiplication(1, 0, 0, 1, 0, 1);
        testMultiplication(0, 1, -1, 0, 0, -1);
        testMultiplication(3, 5, 1, 0, 3, 5);
        testMultiplication(1, 0, 4, 7, 4, 7);
        testMultiplication(2, 3, 4, -5, 23, 2);
        testMultiplication(0.5, -2, -3, 4, 6.5, 8);
    }

}
