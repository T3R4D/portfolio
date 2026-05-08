import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Mathematical Skills II, Programming
 */
 
/**
 * Unit tests for Complex Number exercise, part d
 * 
 */
public class ComplexNumberTestD
{
        
    @Test
    public void computationDTest()
    {
        double res = ComplexComputation.computationD();        
        assertEquals("Checking computation result", 0.120902941132989, res, 1e-10);

    }
    
}
