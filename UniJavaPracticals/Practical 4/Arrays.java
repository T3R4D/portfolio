
/**
 * Some elementary operations with arrays.
 */
public class Arrays
{
    /**
     * Given an array of three integers, computes 
     * a0 + 2a1 + 3a2.
     */
    static int sumOfThree(int[] a)
    {
        return a[0]+ 2*a[1] + 3*a[2]; // Change this.
    }
    
    /**
     * Computes the sum of the first and the last element of an integer array.
     * It is assumed that the array has at least one element.
     */
    static int firstPlusLast(int[] a)
    {
        // add your code below
        // Hint: You will need to use a.length
        int n = a.length;
        int sum = 0;
        sum = a[0] + a[n-1];
                
        return sum;
    }
    
    /**
     * Returns an array containing the names of the day of the week, starting with Monday.
     */
    static String[] dayNames()
    {
        // Refer to code from Lecture 7 for examples
        String[] x = new String[7]; 
        x[0] = "Monday";
        x[1] = "Tuesday";
        x[2] = "Wednesday";
        x[3] = "Thursday";
        x[4] = "Friday";
        x[5] = "Saturday";
        x[6] = "Sunday";
        
        return x; // change this
    }
    
    /**
     * Returns the largest entry in an array of integers.
     * It is assumed that the array has at least one element.
     */
    static int max(int[] a)
    {
        int maximum = a[0];
        int n = a.length;
        
        for (int i = 0; i < n; i++)
        {
            if (a[i] > maximum)
            {
                maximum = a[i];
            }
        }
      
        return maximum;
    }
    
    /**
     * Returns the smallest entry in an array of integers.
     * It is assumed that the array has at least one element.
     */
    static int min(int[] a)
    {
        int minimum = a[0];
        int n = a.length;
        
        for (int i = 0; i < n; i++)
        {
            if (a[i] < minimum)
            {
                minimum = a[i];
            }
        }
      
        return minimum;
    }

    /**
     * Returns an array of integers in reversed order.
     * It is assumed that the array has at least one element.
     */
    static int[] reverse(int[] a)
    {
        int n = a.length;
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) 
        {
            b[i] = a[(n-1)-i];
        } 
        
        return b;
    }
    
}
