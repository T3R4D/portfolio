/*
 * Mathematical Skills II, Programming
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for time conversion
 */
public class TimeTest
{
    
    @Test
    public void timeConversionTest()
    {
        assertEquals("Testing time 0. ",      "It is 0 hours, 0 minutes and 0 seconds since midnight.",    Time.timeConversion(0));
        assertEquals("Testing time 1. ",      "It is 0 hours, 0 minutes and 1 second since midnight.",     Time.timeConversion(1));
        assertEquals("Testing time 100. ",    "It is 0 hours, 1 minute and 40 seconds since midnight.",    Time.timeConversion(100));
        assertEquals("Testing time 1001. ",   "It is 0 hours, 16 minutes and 41 seconds since midnight.",  Time.timeConversion(1001));
        assertEquals("Testing time 3600. ",   "It is 1 hour, 0 minutes and 0 seconds since midnight.",     Time.timeConversion(3600));
        assertEquals("Testing time 3601. ",   "It is 1 hour, 0 minutes and 1 second since midnight.",      Time.timeConversion(3601));
        assertEquals("Testing time 3602. ",   "It is 1 hour, 0 minutes and 2 seconds since midnight.",     Time.timeConversion(3602));
        assertEquals("Testing time 3661. ",   "It is 1 hour, 1 minute and 1 second since midnight.",       Time.timeConversion(3661));
        assertEquals("Testing time 7987. ",   "It is 2 hours, 13 minutes and 7 seconds since midnight.",   Time.timeConversion(7987));
        assertEquals("Testing time 10001. ",  "It is 2 hours, 46 minutes and 41 seconds since midnight.",  Time.timeConversion(10001));
        assertEquals("Testing time 86399. ",  "It is 23 hours, 59 minutes and 59 seconds since midnight.", Time.timeConversion(86399));
    }
}
