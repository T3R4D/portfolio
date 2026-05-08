
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for computations with complex numbers, part (a)
 */
public class ComplexTestA
{
    @Test
    public void subtractTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z, w;
        
        z = h.makeComplexNumber(2,3);
        h.save(z, 0);
        h.assertComplexEquals("Subtracting z from itself", h.makeComplexNumber(0,0), ComplexComputation.subtract(z,z));
        h.verify("checking whether z has changed", z, 0);

        z = h.makeComplexNumber(2,3);
        w = h.makeComplexNumber(-1,4);
        h.save(z, 0);
        h.save(w, 1);
        h.assertComplexEquals("Subtracting "+h.toString(w)+" from "+h.toString(z), h.makeComplexNumber(3,-1), ComplexComputation.subtract(z,w));
        h.verify("checking whether z has changed", z, 0);
        h.verify("checking whether w has changed", w, 1);

    }

}
