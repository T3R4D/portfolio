import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for computations with complex numbers, part (d)
 */
public class ComplexTestD
{
   
    private void testDivision(double zr, double zi, double wr, double wi, double er, double ei)
    {
        ComplexTestHelper h = new ComplexTestHelper();

        ComplexNumber z = h.makeComplexNumber(zr,zi);
        ComplexNumber w = h.makeComplexNumber(wr,wi);
        ComplexNumber expected = h.makeComplexNumber(er,ei);
        
        String msg = "Division of "+h.toString(z)+" by "+h.toString(w);

        h.save(z, 0);
        h.save(w, 1);
        h.assertComplexEquals(msg, expected, ComplexComputation.divide(z,w));
        h.verify(msg+", checking whether z has changed", z, 0);
        h.verify(msg+", checking whether w has changed", w, 1);

    }
    
    @Test
    public void divideTest()
    {
        testDivision(1, 0, 1, 0, 1, 0);
        testDivision(4, 0, 8, 0, 0.5, 0);
        testDivision(1, 0, 0, 1, 0, -1);
        testDivision(8, 0, 0, -2, 0, 4);
        testDivision(3, 4, 3, -4, -7.0/25.0, 24.0/25.0);
    }
}
