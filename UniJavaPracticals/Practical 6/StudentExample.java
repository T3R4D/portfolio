/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */

/**
 * Operations on student records
 */
class StudentExample
{
    static Student testStudent()
    {
        Student StudentExample = new Student();
        StudentExample.firstName = "Joe";
        StudentExample.lastName = "Average";
        StudentExample.emailAddress = "joe.average@test.ac.uk";
        
        return StudentExample;        
    }
     
    static void sendWelcomeMessage(Student a)
    {
        String name = a.firstName + " " + a.lastName;
        String email = a.emailAddress;
        String subject = "Welcome";
        String message = "Dear " + name + ", welcome to the autumn term.";
        MockEmail.sendEmail(email, subject, message);
    }
    
}
