import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

/**
 * Unit test for employee record, part (a)
 */
public class EmployeeTestA
{
    /**
     * helper method for testing whether a field is declared
     */
    private void testFieldDeclared(Class<?> targetClass, String fieldName, Class type)
    {
        String fullname = targetClass.getName()+"."+fieldName; 
        try
        {
            Field field = targetClass.getDeclaredField(fieldName);
            
            assertEquals("Type of field "+fullname, type, field.getType());
            
            assertFalse(fullname+" must not be declared static", Modifier.isStatic(field.getModifiers()) );
            assertFalse(fullname+" must not be declared private", Modifier.isPrivate(field.getModifiers()) );
        }
        catch (NoSuchFieldException e)
        {
            fail("Field "+fullname+" does not exist");
        }      
    }
    
    @Test
    public void testCompositeType() 
    {
        testFieldDeclared(Employee.class, "firstName", String.class);
        testFieldDeclared(Employee.class, "lastName", String.class);
        testFieldDeclared(Employee.class, "salary", int.class);
        
    }
         
}
