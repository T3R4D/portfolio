
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static java.lang.Math.*;

/**
 * Unit test for functions with conditionals
 *
 */
public class ConditionalFunctionsTest
{

    private void testFunction(String name, double x, double actual, double expected) {
       testFunction(name, x, actual, expected, 1e-10);
    }

    private void testFunction(String name, double x, 
                              double actual, double expected, double accuracy) {
        String comment = "Testing "+name+" at x="+x;
        assertEquals(comment, expected, actual, accuracy);
    }

    private void testFunctionNaN(String name, double x, double actual) {
        String comment = "Testing "+name+" at x="+x+" for NaN value";
        assertTrue(comment, Double.isNaN(actual));
    }
    
    
    @Test
    public void f1Test()
    {
        testFunction("f1", 3.0, ConditionalFunctions.f1(3.0), 13.0);
        testFunction("f1", 2.001, ConditionalFunctions.f1(2.001), 10.003);
        testFunction("f1", 10.0, ConditionalFunctions.f1(10.0), 34.0);
        testFunction("f1", 1.99, ConditionalFunctions.f1(1.99), 0.0);
        testFunction("f1", 1.0, ConditionalFunctions.f1(1.0), 0.0);
        testFunction("f1", -1.0, ConditionalFunctions.f1(-1.0), 0.0);
        testFunction("f1", -55.0, ConditionalFunctions.f1(-55.0), 0.0);
    }

    @Test
    public void f2Test()
    {
        testFunction("f2", 3.0, ConditionalFunctions.f2(3.0), 1.0);
        testFunction("f2", 1.001, ConditionalFunctions.f2(1.001), 1.001 / 3);
        testFunction("f2", 30.0, ConditionalFunctions.f2(30.0), 10.0);
        testFunction("f2", 0, ConditionalFunctions.f2(0.0), 0.0);
        testFunction("f2", 0.99, ConditionalFunctions.f2(0.99), 0.99 / 5);
        testFunction("f2", -1.0, ConditionalFunctions.f2(-1.0), -0.2);
        testFunction("f2", -55.0, ConditionalFunctions.f2(-55.0), -11.0);
    }

    @Test
    public void f3Test()
    {
        testFunction("f3", 6.0, ConditionalFunctions.f3(6.0), 36.0);
        testFunction("f3", 5.1, ConditionalFunctions.f3(5.1), 26.01);
        testFunction("f3", 4.0, ConditionalFunctions.f3(4.0), 128.0);
        testFunction("f3", 4.9, ConditionalFunctions.f3(4.9), 235.298, 1e-8);
        testFunction("f3", 2.0, ConditionalFunctions.f3(2.0), 16.0);
        testFunction("f3", 1.01, ConditionalFunctions.f3(1.01), 2.060602);
        testFunction("f3", 0.0, ConditionalFunctions.f3(0.0), 0.0);
        testFunction("f3", 0.99, ConditionalFunctions.f3(0.99), 2.88178803);
        testFunction("f3", -1, ConditionalFunctions.f3(-1.0), 3.0);
        testFunction("f3", -10, ConditionalFunctions.f3(-10.0), 30000.0, 1e-5);
    }
    
    @Test
    public void f4Test()
    {
        testFunction("f4", 0.0, ConditionalFunctions.f4(0.0), 1.0);
        testFunction("f4", 1.0, ConditionalFunctions.f4(1.0), sqrt(E));
        testFunction("f4", 2.99, ConditionalFunctions.f4(2.99), 4.459336552847825);
        testFunction("f4", -0.99, ConditionalFunctions.f4(-0.99), 0.6095709072963093);
        testFunction("f4", 3.01, ConditionalFunctions.f4(3.01), 0.2429669595024596e-2);
        testFunction("f4", -1.01, ConditionalFunctions.f4(-1.01), 7.538324933661922);
        testFunction("f4", 10.0, ConditionalFunctions.f4(10.0), 2.061153622438558e-9);
        testFunction("f4", -10.0, ConditionalFunctions.f4(-10.0), 4.851651954097903e8);
    }
    
    @Test
    public void f5Test()
    {
        testFunction("f5", 0.0, ConditionalFunctions.f5(0.0), 2.0);
        testFunction("f5", PI/2, ConditionalFunctions.f5(PI/2), 0.0);
        testFunction("f5", PI, ConditionalFunctions.f5(PI), 0.0);
        testFunction("f5", 3*PI/2, ConditionalFunctions.f5(3*PI/2), 0.0);
        testFunction("f5", 2*PI, ConditionalFunctions.f5(2*PI), 2.0);
        testFunction("f5", 0.1, ConditionalFunctions.f5(0.1), 1.990008330556052);
        testFunction("f5", -0.1, ConditionalFunctions.f5(-0.1), 1.990008330556052);
        testFunction("f5", 1.1, ConditionalFunctions.f5(1.1), -0.8084964038195902);
        testFunction("f5", -1.1, ConditionalFunctions.f5(-1.1), 0.8084964038195902);
    }
    
    @Test
    public void f6Test()
    {
        testFunction("f6", PI, ConditionalFunctions.f6(PI), 0.0);
        testFunction("f6", 2*PI, ConditionalFunctions.f6(2*PI), 0.0);
        testFunction("f6", PI/2, ConditionalFunctions.f6(PI/2), 2/PI);
        testFunction("f6", PI/6, ConditionalFunctions.f6(PI/6), 3/PI);
        testFunction("f6", 0.1, ConditionalFunctions.f6(0.1), 0.9983341665);
        testFunctionNaN("f6", -0.1, ConditionalFunctions.f6(-0.1));
        testFunctionNaN("f6", -4.1, ConditionalFunctions.f6(-4.1));
    }

    @Test
    public void f7Test()
    {
        testFunction("f7", 0.0, ConditionalFunctions.f7(0.0), 0.0);
        testFunction("f7", 1.0, ConditionalFunctions.f7(1.0), 804.247719318986, 1e-8);
        testFunction("f7", 0.5, ConditionalFunctions.f7(0.5), 237.387575808413, 1e-8);
        testFunction("f7", -1.0, ConditionalFunctions.f7(-1.0), -50.2654824574366, 1e-8);
        testFunctionNaN("f7", -3.1, ConditionalFunctions.f7(-3.1));
        testFunctionNaN("f7", 5.1, ConditionalFunctions.f7(5.1));
        testFunctionNaN("f7", 100.0, ConditionalFunctions.f7(100.0));
    }
    
    @Test
    public void f8Test()
    {
        testFunction("f8", 1.0, ConditionalFunctions.f8(1.0), 0.795365461223902);
        testFunction("f8", 1.1, ConditionalFunctions.f8(1.1), 0.829197888406670);
        testFunction("f8", 2.0, ConditionalFunctions.f8(2.0), 0.157949642555210);
        testFunction("f8", -1.0, ConditionalFunctions.f8(-1.0), 0.238480193435896);
        testFunction("f8", -3.0, ConditionalFunctions.f8(-3.0), 0.150455346305005e-1);
        testFunctionNaN("f8", 0.5, ConditionalFunctions.f8(0.5));
        testFunctionNaN("f8", 1.5, ConditionalFunctions.f8(1.5));
        testFunctionNaN("f8", 1.38, ConditionalFunctions.f8(1.38));
    }
}

