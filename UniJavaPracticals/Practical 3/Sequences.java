
/*
 * Mathematical Skills II, Programming
 */

/** 
 * Computing integer sequences using loops
 */
class Sequences
{
    
    static long sequenceA(int n)
    {
        long a = 2;
        
        for (int i = 1; i < n ; i ++)
        {
            a = (-2)*a + 7;
        }
        
        return a;
    }
        
         
    static long sequenceB(int n)
    {
        long b = 1;
        
        for (int i = 0; i < n; i ++)
        {
            b = b*b - 6*i*b;
        }
        
        return b;
    }
    
    static long sequenceC(int n, long alpha, long beta)
    {
        long c_0 = alpha;
        long c_1 = beta;
        long c_2 = 2*c_1 - 3*c_0;
        
        if (n == 0)
        {
            c_2 = c_0;
        }
        else if (n == 1)
        {
            c_2 = c_1;
        }
        else
        {
            for (int i = 2; i < n; i ++)
            {
                c_0 = c_1;
                c_1 = c_2;
                c_2 = 2*c_1 - 3*c_0;
            }
        }
                
        return c_2;
    }
    
    static long sequenceD(int n, long gamma, long k)
    {
        long d_1 = gamma;
        long d_2 = d_1;
        
        for (int i = 1; i < n; i++)
        {
            if ( i % 2 == 0 )
            {
                d_2 = (d_1*d_1 + 2)%k;
                d_1 = d_2;
            }
            else
            {
                d_2 = Math.floorMod((d_1*d_1*d_1 - 3),k);
                d_1 = d_2;
            }
        }
        
        return d_2;
    }
    
    static long sequenceE(int n)
    {
        long e = 1;
        
        for (int i = 1; i <= n; i++)
        {
            e = ((2*(2*i-1))*e)/(i+1);
        }
        
        return e;
    }
}
