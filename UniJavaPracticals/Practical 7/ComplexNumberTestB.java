

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * Mathematical Skills II, Programming
 */
 
/**
 * Unit tests for Complex Number exercise, part b
 * 
 */
public class ComplexNumberTestB
{
        
    @Test
    public void subtractTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z, w;
        
        z = new ComplexNumber(2,3);
        h.save(z, 0);
        h.assertComplexEquals("Subtracting z from itself", new ComplexNumber(0,0), z.subtract(z));
        h.verify("checking whether z has changed", z, 0);

        z = new ComplexNumber(2,3);
        w = new ComplexNumber(-1,4);
        h.save(z, 0);
        h.save(w, 1);
        h.assertComplexEquals("Subtracting "+w.toString()+" from "+z.toString(), new ComplexNumber(3,-1), z.subtract(w));
        h.verify("checking whether z has changed", z, 0);
        h.verify("checking whether w has changed", w, 1);

    }

  
    private void testDivision(double zr, double zi, double wr, double wi, double er, double ei)
    {
        ComplexNumber z = new ComplexNumber(zr,zi);
        ComplexNumber w = new ComplexNumber(wr,wi);
        ComplexNumber expected = new ComplexNumber(er,ei);
        
        ComplexTestHelper h = new ComplexTestHelper();
        String msg = "Division of "+z.toString()+" by "+w.toString();

        h.save(z, 0);
        h.save(w, 1);
        h.assertComplexEquals(msg, expected, z.divide(w));
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
