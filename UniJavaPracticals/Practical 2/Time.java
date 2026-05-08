/*
 * Mathematical Skills II, Programming
 */
 
/**
 * A slightly improved class for converting the number of seconds after midnight to a readable string.
 */
public class Time
{
   /**
     * Converts time from "seconds-past-midnight" (integer) into an hours-minutes-seconds format (String).
     */
    public static String timeConversion(int time)
    {
        String message;    // this holds the output message
        int seconds, minutes, hours;
        String s, m ,h;
        
        seconds = time % 60;
        minutes = (time / 60) % 60;
        hours   = (time / 60) / 60;
        
        if ( seconds == 1 ) 
        {
           s = " second since midnight.";
        }
        else
        {
           s = " seconds since midnight.";
        }  
         
        if ( minutes == 1 ) 
        {
           m = " minute and " ;
        }
        else
        {
           m = " minutes and " ;
        }  
        
        if ( hours == 1 ) 
        {
           h = " hour, " ;
        }
        else
        {
           h = " hours, " ;
        }  
        
        message = "It is " + hours + h + minutes + m + seconds
                  + s;
        
        return message;
    }
}
