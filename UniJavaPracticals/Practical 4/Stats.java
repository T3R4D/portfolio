import static java.lang.Math.*;

/**
 * Computing some statistical quantities.
 */
class Stats
{
    static double meanValue (double[] x)
    {
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
    
    static double moment(double[] x, int k)
    {
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
    
    static double standardDeviation (double[] x)
    {
        if (x == null)
        {
            return Double.NaN;
        }
                
        double sum = 0;
        double n = x.length;
        double mean = meanValue(x);
        
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
