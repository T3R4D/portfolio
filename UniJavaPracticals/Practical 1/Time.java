/*
 * Mathematical Skills II, Programming
 */

/**
 * Printing time as a text
 */
class Time
{
    /**
     * Converts time from "seconds-past-midnight" (integer) into an hours-minutes-seconds format (String).
     */
    static String timeConversion(int time)
    {
        // add your code here
        int hours = time/3600;
        int minutes = time/60 - hours*60;
        int seconds = time - hours*3600 - minutes*60;
        
        return "It is " + hours + " hours, " + minutes + 
        " minutes and " + seconds + " seconds since midnight.";
    }
}
