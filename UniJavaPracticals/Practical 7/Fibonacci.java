/*
 * Mathematical Skills II, Programming
 * Code for Practical 7
 */
import java.math.BigInteger;

/**
 * Exercise 1 - Fibonacci numbers
 */
class Fibonacci
{
    
    public static String fibonacci(int n)
    {
        BigInteger Fi = new BigInteger("0");
        BigInteger Fj = new BigInteger("1");
        BigInteger Fn = new BigInteger("0");
        String answer = null;
        
        if(n == 0)
        {
            answer = Fi.toString();
            return answer;
        }
        
        if(n == 1)
        {
            answer = Fj.toString();
            return answer;
        }
        
        int i = 2;
        while(i <= n)
        {
            Fn = Fi.add(Fj);
            Fi = Fj;
            Fj = Fn;
            i++;
        }
        
        answer = Fn.toString();
        
        return answer;
    }
    
}
