import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for employee record, part (c)
 */
public class EmployeeTestC
{
    @Test
    public void testSalaryIncrease() 
    {
        Employee e = new Employee();
        e.firstName = "John";
        e.lastName = "Doe";
        e.salary = 1500;
        
        EmployeeActions.increaseSalary(e, 150);
        
        assertEquals("first name", "John", e.firstName);
        assertEquals("last name", "Doe", e.lastName);
        assertEquals("salary", 1650, e.salary);
        
    }
         
}
