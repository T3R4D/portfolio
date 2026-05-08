import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

/**
 * Unit test for student records, part (c)
 */
public class StudentTestC
{
   
    @Test
    public void sendWelcomeMessageTest()
    {
        Student s = new Student();
        s.firstName = "John";
        s.lastName = "Doe";
        s.emailAddress = "john.doe@sample.ac.uk";

        StudentExample.sendWelcomeMessage(s);

        assertEquals("Checking recipient", "john.doe@sample.ac.uk", MockEmail.storedRecipient);
        assertEquals("Checking subject", "Welcome", MockEmail.storedSubject);
        assertEquals("Checking message text", "Dear John Doe, welcome to the autumn term.", MockEmail.storedMessage);
    }

}
