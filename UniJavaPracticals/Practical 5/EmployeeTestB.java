import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for employee record, part (b)
 */
public class EmployeeTestB
{    
    @Test
    public void testSampleEmployee() 
    {
        Employee e = EmployeeActions.sampleEmployee();
        assertEquals("first name", "Joe", e.firstName);
        assertEquals("last name", "Bloggs", e.lastName);
        assertEquals("salary", 1600, e.salary);
        
    }
         
}
