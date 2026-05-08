import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

/**
 * A helper class for unit tests
 */
public class TestHelper
{
    /**
     * helper method to assert that a class is located in the default package
     */
    private static void assertDefaultPackage(Class<?> targetClass)
    {
        String msg = targetClass.getName()+" must be in default package";
        if (targetClass.getPackage() != null)
        {
            assertEquals(msg, "", targetClass.getPackage().getName());
        }
    }
    
    /**
     * helper method for testing whether a (static) function is declared
     */
    static void testFunctionDeclared(Class<?> targetClass, String methodName, Class returnType, Class... paramType)
    {
        assertDefaultPackage(targetClass);
        
        String fullname = targetClass.getName()+"."+methodName; 
        try
        {
            Method method = targetClass.getDeclaredMethod(methodName, paramType);

            assertEquals("Return type of "+fullname, returnType, method.getReturnType());

            assertTrue(fullname+" not declared static", Modifier.isStatic(method.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(method.getModifiers()) );
        }
        catch (NoSuchMethodException e)
        {
            fail("Function "+fullname+" does not exist or has incorrect signature");
        }                
        
    }

}
