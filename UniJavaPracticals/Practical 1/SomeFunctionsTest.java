
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static java.lang.Math.*;

/**
 * Unit test for Practical 1, Exercise 5
 *
 */
public class SomeFunctionsTest
{

    private void testFunction(String name, double x, double actual, double expected) {
        String comment = "Testing "+name+" at x="+x;
        double eps = 1e-10 * (1 + abs(expected));
        assertEquals(comment, expected, actual, eps);
    }

    private void testFunctionNaN(String name, double x, double actual) {
        String comment = "Testing "+name+" at x="+x+" for NaN value";
        assertTrue(comment, Double.isNaN(actual));
    }

    @Test
    public void f1Test()
    {
        testFunction("f1", 0.0, SomeFunctions.f1(0.0), -4.0);
        testFunction("f1", 0.1, SomeFunctions.f1(0.1), -3.8);
        testFunction("f1", 1.0, SomeFunctions.f1(1.0), -2.0);
        testFunction("f1", 2.0, SomeFunctions.f1(2.0), 0.0);
        testFunction("f1", 5.0, SomeFunctions.f1(5.0), 6.0);
        testFunction("f1", -2.0, SomeFunctions.f1(-2.0), -8.0);
        testFunction("f1", -10.0, SomeFunctions.f1(-10.0), -24.0);
    }

    @Test
    public void f2Test()
    {
        testFunction("f2", 0.0, SomeFunctions.f2(0.0), -7.0);
        testFunction("f2", 0.1, SomeFunctions.f2(0.1), -7.0 + 0.301);
        testFunction("f2", 1.0, SomeFunctions.f2(1.0), -3.0);
        testFunction("f2", -1.0, SomeFunctions.f2(-1.0), -11.0);
        testFunction("f2", 2.0, SomeFunctions.f2(2.0), 7.0);
        testFunction("f2", 3.0, SomeFunctions.f2(3.0), 29.0);
        testFunction("f2", 0.5, SomeFunctions.f2(0.5), -5.375);
    }

    @Test
    public void f3Test()
    {
        testFunction("f3", 0.0, SomeFunctions.f3(0.0), 1.0);
        testFunction("f3", PI, SomeFunctions.f3(PI), -1.0);
        testFunction("f3", -PI, SomeFunctions.f3(-PI), -1.0);
        testFunction("f3", PI/4, SomeFunctions.f3(PI/4), 1+1/sqrt(2.0));
        testFunction("f3", -PI/4, SomeFunctions.f3(-PI/4), -1+1/sqrt(2.0));
        testFunction("f3", 1, SomeFunctions.f3(1), 2.097710030523042);
    }
    
    @Test
    public void f4Test()
    {
        testFunction("f4", 0.0, SomeFunctions.f4(0.0), 6.7);
        testFunction("f4", 1.0, SomeFunctions.f4(1.0), 13.0890560989306);
        testFunction("f4", 2.5, SomeFunctions.f4(2.5), 154.113159102577);
        testFunction("f4", -1.0, SomeFunctions.f4(-1.0), 5.83533528323661);
    }

    @Test
    public void f5Test()
    {
        testFunction("f5", 0.0, SomeFunctions.f5(0.0), 12.4071769563386);
        testFunction("f5", 1.0, SomeFunctions.f5(1.0), 14.2456323140077);
        testFunction("f5", 2.5, SomeFunctions.f5(2.5), 45.4752739411859);
        testFunction("f5", -1.0, SomeFunctions.f5(-1.0), 14.2456323140077);
        testFunction("f5", -2.5, SomeFunctions.f5(-2.5), 45.4752739411859);
    }

    @Test
    public void f6Test()
    {
        testFunction("f6", 0.0, SomeFunctions.f6(0.0), 3.0);
        testFunction("f6", sqrt(3), SomeFunctions.f6(sqrt(3)), 40.0);
        testFunction("f6", 1, SomeFunctions.f6(1.0), 9.864524591896313);
        testFunction("f6", -1, SomeFunctions.f6(-1.0), 9.864524591896313);
        testFunction("f6", 2.5, SomeFunctions.f6(2.5), 125.4687157279134);
        testFunction("f6", 10, SomeFunctions.f6(10), 21417.19348624930);
    }

    @Test
    public void f7Test()
    {
        testFunction("f7", 0.0, SomeFunctions.f7(0.0), 1.09861228866811);
        testFunction("f7", 1.0, SomeFunctions.f7(1.0), 1.46614154600334);
        testFunction("f7", 2.5, SomeFunctions.f7(2.5), 1.22614072217903);
        testFunction("f7", -1.0, SomeFunctions.f7(-1.0), 1.46614154600334);
        testFunction("f7", -10.0, SomeFunctions.f7(-10.0), 1.58637061910401);
    }

    @Test
    public void f8Test()
    {
        testFunction("f8", 0.0, SomeFunctions.f8(0.0), 1.0);
        testFunction("f8", 0.1, SomeFunctions.f8(0.1), exp(0.3));
        testFunction("f8", -0.1, SomeFunctions.f8(-0.1), exp(-0.3));
        testFunction("f8", 1.0, SomeFunctions.f8(1.0), exp(3));
        testFunction("f8", -1.0, SomeFunctions.f8(-1.0), exp(-3));
        testFunction("f8", 3.0, SomeFunctions.f8(3.0), exp(21));
        testFunction("f8", -3.0, SomeFunctions.f8(-3.0), exp(-21));
    }

    @Test
    public void f9Test()
    {
        testFunction("f9", 0.0, SomeFunctions.f9(0.0), -1.0/3.0);
        testFunction("f9", 0.1, SomeFunctions.f9(0.1), -.4819035497856255);
        testFunction("f9", -0.1, SomeFunctions.f9(-0.1), -.1706935608315454);
        testFunction("f9", 1.0, SomeFunctions.f9(1.0), -1.258544670594269);
        testFunction("f9", -1.0, SomeFunctions.f9(-1.0), 1.961938194150854);
        testFunction("f9", 3.0, SomeFunctions.f9(3.0), -1.133475287754758);
    }

}

