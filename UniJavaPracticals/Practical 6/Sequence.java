/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 

import java.io.*;

// After you're finished, don't forget to add Javadoc comments!

class Sequence
{
    /**
     * This procedure writes the sequence of a_(n+1)=7-2n from a_0 = 3, 
     * to a_n.
     * 
     * @param filename, the name of the file, a String
     * @param n, integer, assumed to be greater than or equal to 0
     * 
     * @throws IOException
     */
    
    static void writeToFile(String filename, int n) throws IOException 
    {
        File myFile = new File(filename);
        PrintStream p = new PrintStream(myFile);
                     
        if ( n >= 0)
        {
            long f = 3;
            p.println(f);
            for(int i = 1; i<=n; i++)
            {
                f = 7 - 2*f;
                p.println(f);
            }
        }
        else
        {
            p.println("This was not a valid number.");
        }
        p.close();
    }
}
