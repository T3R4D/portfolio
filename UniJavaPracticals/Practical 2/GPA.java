/*
 * Mathematical Skills II, Programming
 */
import static java.lang.Math.*;
/**
 * The grade point average system (GPA) as proposed by the Higher Education Academy.
 */
class GPA
{
    /**
     * Compute the GPA degree class, given a numerical mark out of 100
     */    
    static String degreeClass(double mark)
    {
        String message;
        if ( mark >= 0 && mark <= 100)
        {
            mark = round(mark);
        }
        else
        {
            mark = mark;
        }
  
        if (mark > 100)
        {
            message = "undefined";
        }
        else if ( mark >= 67)
        {
            if ( mark >= 75 )
            {
                message = "A+";
            }
        
            else if ( mark >= 71)
            {
                message = "A";
            }
            
            else
            {
                message = "A-";
            }
        }
        
        else if ( mark >= 57)
        {
            if ( mark >= 64 )
            {
                message = "B+";
            }
        
            else if ( mark >= 61 )
            {
                message = "B";
            }
            
            else
            {
                message = "B-";
            }
        }
        
        else if ( mark >= 48)
        {
            if ( mark >= 54 )
            {
                message = "C+";
            }
        
            else if ( mark >= 50)
            {
                message = "C";
            }
            
            else
            {
                message = "C-";
            }
        }
        
        else if ( mark >= 38)
        {
            if ( mark >= 43 )
            {
                message = "D+";
            }
        
            else if ( mark >= 40 )
            {
                message = "D";
            }
            
            else
            {
                message = "D-";
            }
        }
        
        else if ( mark >= 0)
        {
            if ( mark >= 35 )
            {
                message = "F+";
            }
        
            else if ( mark >= 30 )
            {
                message = "F";
            }
            
            else
            {
                message = "F-";
            }
        }
        
        else
        {
            message = "undefined";
        }
    
        return message;
    }

}
