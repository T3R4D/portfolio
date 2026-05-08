

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Mathematical Skills II, Programming
 */
 
/**
 * Unit tests for Complex Number exercise, part c
 * 
 */
public class ComplexNumberTestC
{
        
    private void testOneExp(double zr, double zi, double er, double ei)
    {
        ComplexNumber z = new ComplexNumber(zr,zi);
        ComplexNumber expected = new ComplexNumber(er,ei);
        
        ComplexTestHelper h = new ComplexTestHelper();
        String msg = "Exponentiation of "+z.toString();

        h.save(z, 0);
        h.assertComplexEquals(msg, expected, z.exp());
        h.verify(msg+", checking whether z has changed", z, 0);

    }
    
    @Test
    public void expTest()
    {
        testOneExp(0, 0, 1, 0);
        testOneExp(3.5, 0, Math.exp(3.5), 0);
        testOneExp(0, Math.PI/2, 0, 1);
        testOneExp(0, Math.PI, -1, 0);
        double c = Math.E*Math.E/Math.sqrt(2.0);
        testOneExp(2, -Math.PI/4, c, -c);
    }
    
    private void testOneLog(double zr, double zi, double er, double ei)
    {
        ComplexNumber z = new ComplexNumber(zr,zi);
        ComplexNumber expected = new ComplexNumber(er,ei);
        
        ComplexTestHelper h = new ComplexTestHelper();
        String msg = "Logarithm of "+z.toString();

        h.save(z, 0);
        h.assertComplexEquals(msg, expected, z.log());
        h.verify(msg+", checking whether z has changed", z, 0);

    }
    
    @Test
    public void logTest()
    {
        testOneLog(1, 0, 0, 0);
        testOneLog(Math.exp(3.5), 0, 3.5, 0);
        testOneLog(0, 1, 0, Math.PI/2);
        testOneLog(0, -1, 0, -Math.PI/2);
        double c = Math.E*Math.E/Math.sqrt(2.0);
        testOneLog(c, -c, 2, -Math.PI/4);
        testOneLog(c, c, 2, Math.PI/4);
        testOneLog(-c, c, 2, 3*Math.PI/4);
        testOneLog(-c, -c, 2, -3*Math.PI/4);
    }
}
