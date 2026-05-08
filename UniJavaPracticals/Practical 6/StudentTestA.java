import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

/**
 * Unit test for student records, part (a)
 */
public class StudentTestA
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

            assertFalse(fullname+" declared static", Modifier.isStatic(field.getModifiers()) );
        }
        catch (NoSuchFieldException e)
        {
            fail("Field "+fullname+" does not exist");
        }                

    }

    @Test 
    public void studentTypeTest()
    {
        testFieldDeclared(Student.class, "firstName", String.class);        
        testFieldDeclared(Student.class, "lastName", String.class);        
        testFieldDeclared(Student.class, "emailAddress", String.class);        
    }

}
