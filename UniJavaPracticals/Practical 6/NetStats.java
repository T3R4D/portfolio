/*
 * Mathematical Skills II, Programming;
 * Code for Practical 6
 */ 

import java.net.*;
import java.util.*;
import java.io.*;

/**
 * Computing statistical quantities from a data series
 * read from a web address.
 */
public class NetStats
{
    /**
     * Reads data from a url and then working out the mean of the data.
     *
     * @param filename the name of the file where the data is stored
     * @return the mean of the data
     * 
     * @throws IOException
     */
        
    static double meanValueFromNet() throws IOException
    {
        String data = 
        "http://maths.york.ac.uk/static/progscicomp/dataseries-p6.txt";
        URL myUrl = new URL(data);
        Scanner s = new Scanner(myUrl.openStream());
        Scanner t = new Scanner(myUrl.openStream());
        
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
     * Reads data from a url and then puts the data into an array.
     * 
     * @return the data in an array
     * 
     * @throws IOException
     */
    static double[] readDataSeries() throws IOException
    {
        String data = 
        "http://maths.york.ac.uk/static/progscicomp/dataseries-p6.txt";
        URL myUrl = new URL(data);
        Scanner s = new Scanner(myUrl.openStream());
        Scanner t = new Scanner(myUrl.openStream());
        
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
        
        return x;
    }
    
    static double medianFromNet() throws IOException
    {
        double[] x = readDataSeries();
        
        Arrays.sort(x);
        
        int n = x.length;
        double median = 0.0;
        
        if(n%2 == 0)
        {
            double half = (n-1)/2.0;
            double upper = Math.ceil(half);
            double lower = Math.floor(half);
            int U = (int)upper;
            int L = (int)lower;
        
            median = (x[U]+x[L])/2;
        }
        else
        {
            double half = (n-1)/2.0;
            int H = (int)half;
            
            median = x[H];
        }
                
        return median;
    }
}
