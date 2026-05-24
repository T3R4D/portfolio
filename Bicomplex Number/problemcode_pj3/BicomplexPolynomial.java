/*
 * Mathematical Skills II, Programming
 * Project 3, 2020/21
 */

import static java.lang.Math.*;

/**
 * A class representing the bicomplex function that creates polynomials 
 * P(z) = sum_(j<n) c_j*z^j
 * with coefficients c_j an array of bicomplex numbers
 */ 
public class BicomplexPolynomial extends BicomplexFunction
{
     /**
     * this is c
     */
     private BicomplexNumber[] c;
     
     /**
     * Constructor for the class. The value of c is passed as a parameter,
     * then stored in a respective field.
     * 
     * @param cValue value of c
     */   
     public BicomplexPolynomial(BicomplexNumber[] cValue)
     {
         int n = cValue.length;
         BicomplexNumber[] v = new BicomplexNumber[n];
         for(int i = 0; i < n; i++)
         {
             v[i] = cValue[i];
         }
         this.c = v;
     }
     
     /**
     * Evaluates the function bicomplex polynomial at a specfic point.
     * 
     * @param z the point to evaluate at
     * @return P(z) where P is a polynomial
     */
     public BicomplexNumber valueAt(BicomplexNumber z)
     {
         BicomplexNumber pow = z;
         BicomplexNumber ans = new BicomplexNumber(0, 0, 0, 0);
         int n = c.length;
         
         for(int j = 0; j < n; j++)
         {
             pow = z;
             
             for(int i = 1; i <= j+1; i++)
             {
                 pow = pow.multiply(z);
             }
             
             ans = ans.add(c[j].multiply(pow));
         }
         
         return ans;
     }
}
