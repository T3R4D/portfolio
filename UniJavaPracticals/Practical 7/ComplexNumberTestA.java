

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * Mathematical Skills II, Programming
 */
 
/**
 * Unit tests for Complex Number exercise, part a
 * 
 */
public class ComplexNumberTestA
{
    
    @Test
    public void negateTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z;
        
        z = new ComplexNumber(2,3);
        h.save(z, 0);
        h.assertComplexEquals("Negating 2+3i", new ComplexNumber(-2,-3), z.negate());
        h.verify("checking whether z has changed", z, 0);
        
    }

    @Test
    public void conjugateTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z;
        
        z = new ComplexNumber(2,3);
        h.save(z, 0);
        h.assertComplexEquals("Conjugating 2+3i", new ComplexNumber(2,-3), z.conjugate());
        h.verify("checking whether z has changed", z, 0);
        
    }
    
    @Test
    public void invertTest()
    {
        ComplexTestHelper h = new ComplexTestHelper();
        ComplexNumber z;
        
        z = new ComplexNumber(1, 0);
        h.save(z, 0);
        h.assertComplexEquals("Inverting 1", new ComplexNumber(1, 0), z.invert());
        h.verify("checking whether z has changed", z, 0);

        z = new ComplexNumber(0, 1);
        h.save(z, 0);
        h.assertComplexEquals("Inverting i", new ComplexNumber(0, -1), z.invert());
        h.verify("checking whether z has changed", z, 0);

        z = new ComplexNumber(3, 4);
        h.save(z, 0);
        h.assertComplexEquals("Inverting 3+4i", new ComplexNumber(3.0/25.0, -4.0/25.0), z.invert());
        h.verify("checking whether z has changed", z, 0);

    }

}
