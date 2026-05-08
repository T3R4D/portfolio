

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for GPA grade scale
 */
public class GPATest
{

    private void testDegree(double uoy, String gpa) 
    {
       assertEquals("Testing mark "+uoy, gpa, GPA.degreeClass(uoy));
    }
    
    @Test
    public void gpaDegreeClassTest()
    {
        testDegree(99.1, "A+");
        testDegree(90.1, "A+");
        testDegree(88.8, "A+");
        testDegree(82.8, "A+");
        testDegree(79.2, "A+");
        testDegree(71.2, "A");
        testDegree(69.0, "A-");
        testDegree(66.7, "A-");
        testDegree(65.7, "B+");
        testDegree(62.9, "B");
        testDegree(61.1, "B");
        testDegree(58.0, "B-");
        testDegree(55.5, "C+");
        testDegree(54.3, "C+");
        testDegree(53.0, "C");
        testDegree(52.0, "C");
        testDegree(48.9, "C-");
        testDegree(48.1, "C-");
        testDegree(47.9, "C-");
        testDegree(47.3, "D+");
        testDegree(46.6, "D+");
        testDegree(46.0, "D+");
        testDegree(43.1, "D+");
        testDegree(41.0, "D");
        testDegree(38.3, "D-");
        testDegree(36.1, "F+");
        testDegree(32.1, "F");
        testDegree(30.1, "F");
        testDegree(29.6, "F");
        testDegree(29.4, "F-");
        testDegree(25.1, "F-");
        testDegree(15.1, "F-");
        testDegree(0.1, "F-");
        testDegree(100.1, "undefined");
        testDegree(-0.1, "undefined");
        testDegree(-100, "undefined");

    }
}
