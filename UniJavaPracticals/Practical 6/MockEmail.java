/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */
  
/**
 * "Mock e-mail" helper class.
 * 
 * This code is used as part of Exercise 4.
 * Please DO NOT modify it.
 * 
 * Your own code should go into the classes
 * "Student" and "StudentExample" instead.
 */
public class MockEmail
{
    
    static String storedRecipient;
    static String storedSubject;
    static String storedMessage;
    

    /**
     * Sends an "email" with given subject and message text to a recipient.
     * (This doesn't actually send an e-mail; instead it prints a message to the screen.)
     * 
     * @param recipient The recipient's e-mail address
     * @param subject The subject line of the message
     * @param message The message text
     */
    static void sendEmail(String recipient, String subject, String message)
    {
        storedRecipient = recipient;
        storedSubject = subject;
        storedMessage = message;
        
        String div = "---------------------------------------------------";
        System.out.println(div);
        System.out.println("New e-mail message");
        System.out.println(div);
        System.out.println("To     : "+recipient);
        System.out.println("Subject: "+subject);
        System.out.println();
        System.out.println(message);
        System.out.println(div);
        System.out.println("End of message");
        System.out.println(div);
    }
}
