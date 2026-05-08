import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

/**
 * Unit test for student records, part (b)
 */
public class StudentTestB
{


    @Test
    public void testStudentTest() 
    {
        Student s = StudentExample.testStudent();
        assertEquals("Checking first name", "Joe", s.firstName);
        assertEquals("Checking last name", "Average", s.lastName);
        assertEquals("Checking email address", "joe.average@test.ac.uk", s.emailAddress);        
    }

 
}
