/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

/** 
 * Computing statistical functions on a data series that is read from a file
 */
public class FileStats
{
    /**
     * Reading from a file and then working out the mean of the data.
     *
     * @param filename the name of the file where the data is stored
     * @return the mean of the data
     * 
     * @throws IOException
     */
        
    static double meanValueFromFile(String filename) throws IOException
    {
        File myFile = new File(filename);
        Scanner s = new Scanner(myFile);
        Scanner t = new Scanner(myFile);
        
        int lines = 0;
        do 
        {
            lines++;
            t.nextLine();
        }
        while (t.hasNextLine() == true);
        
        double[] x = new double[lines];
        for (int i = 0; i < lines; i++)
        {
            double y = s.nextDouble();
            x[i] = y;
        }
        
        //Mean Code
        if (x == null)
        {
            return Double.NaN;
        }
        
        double sum = 0;
        double n = x.length;
        
        for (int j = 0; j < n; j++)
        {
            sum = sum + x[j];
        }        
        
        return sum/n;
    }
    
    /**
     * Reading from a file and then working out the kth moment of the data.
     *
     * @param filename the name of the file where the data is stored
     * @param k the integer k for the kth moment
     * @return the kth moment 
     * 
     * @throws IOException
     */
    static double momentFromFile(String filename, int k) throws IOException
    {
        File myFile = new File(filename);
        Scanner s = new Scanner(myFile);
        Scanner t = new Scanner(myFile);
        
        int lines = 0;
        do 
        {
            lines++;
            t.nextLine();
        }
        while (t.hasNextLine() == true);
        
        double[] x = new double[lines];
        for (int i = 0; i < lines; i++)
        {
            double y = s.nextDouble();
            x[i] = y;
        }
        
        
        //Kth Moment Code
        if (x == null)
        {
            return Double.NaN;
        }
        
        double sum = 0;
        double n = x.length;
        
        for (int j = 0; j < n; j++)
        {
            sum = sum + pow(x[j], k);
        }  
        
        return sum/n;
    }

     /**
     * Reading from a file and then working out the kth moment of the data.
     *
     * @param filename the name of the file where the data is stored
     * @param k the integer k for the kth moment
     * @return the kth moment 
     * 
     * @throws IOException
     */
    static double standardDeviationFromFile(String filename) throws IOException
    {
        File myFile = new File(filename);
        Scanner s = new Scanner(myFile);
        Scanner t = new Scanner(myFile);
         
        int lines = 0;
        do 
        {
            lines++;
            t.nextLine();
        }
        while (t.hasNextLine() == true);
        
        double[] x = new double[lines];
        for (int i = 0; i < lines; i++)
        {
            double y = s.nextDouble();
            x[i] = y;
        }
        
        //Standard Deviation Code
        if (x == null)
        {
            return Double.NaN;
        }
                
        double sum = 0;
        double n = x.length;
        double mean = meanValueFromFile(filename);
        
        if (n == 0)
        {
            return Double.NaN;
        }
        
        for (int j = 0; j < n; j++)
        {
            sum = sum + pow(x[j] - mean, 2);
        }
        
        double ans = sqrt(1/(n-1) * sum);
        
        return ans;
    }
}
