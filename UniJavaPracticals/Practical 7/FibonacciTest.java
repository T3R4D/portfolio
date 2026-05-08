
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Unit test for Fibonacci numbers 
 */
public class FibonacciTest
{

    private void checkReturnType() {
        Object o = Fibonacci.fibonacci(1);
        assertFalse("Return type of fibonacci(...) must be a String, not a BigInteger", o instanceof java.math.BigInteger);
        assertTrue("Return type of fibonacci(...) must be a String", o instanceof String);        
    }
    
    @Test
    public void fibonacciTestLow()
    {
        checkReturnType();
        assertEquals("Testing n=1", "1", Fibonacci.fibonacci(1));
        assertEquals("Testing n=2", "1", Fibonacci.fibonacci(2));
        assertEquals("Testing n=3", "2", Fibonacci.fibonacci(3));
        assertEquals("Testing n=4", "3", Fibonacci.fibonacci(4));                
        assertEquals("Testing n=5", "5", Fibonacci.fibonacci(5));                
    }

    @Test
    public void fibonacciTestHigh()
    {
        checkReturnType();
        assertEquals("Testing n=200", "280571172992510140037611932413038677189525", Fibonacci.fibonacci(200));
    }

}
