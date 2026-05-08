
/**
 * Some operations relating to the Employee class.
 */
class EmployeeActions
{
    /**
     * Returns a sample employee record for Joe Bloggs.
     * 
     * @return the employee record
     */
    
    
    static Employee sampleEmployee()    
    {
        Employee e = new Employee();
        e.firstName = "Joe";
        e.lastName = "Bloggs";
        e.salary = 1600;
        return e;
    }
        
    /* 
     * For part (c), add a procedure "increaseSalary" here, 
     * and think carefully what the parameters and their types need to be!
     */
    /**
     * Add an amount to the employee salary.
     *
     * @param e the employee to act on
     * @param p the amount to increase salary
     * 
     */
    static void increaseSalary(Employee e,int p)
    {
        e.salary = e.salary + p;
    }

}
