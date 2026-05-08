/*
 * Mathematical Skills II, Programming
 * Practical 4
 */

import static java.lang.Math.*;

/**
 * Some computations with complex numbers.
 */
class ComplexComputation
{

    /**
     * Returns the absolute value of a complex number.
     * (This is taken from the lectures.)
     *
     * @param z a complex number
     * @return |z|
     */
    static double abs(ComplexNumber z)
    {
        return Math.sqrt(z.real*z.real + z.imag*z.imag);
    }

    /**
     * Adds two complex numbers.
     * (This is taken from the lectures.)
     *
     * @param z the first summand
     * @param w the second summand
     * @return z+w
     */
    static ComplexNumber add(ComplexNumber z, ComplexNumber w)
    {
        ComplexNumber sum = new ComplexNumber();
        sum.real = z.real + w.real;
        sum.imag = z.imag + w.imag;
        return sum;
    }

    /**
     * Subtracts one complex numbers from the other.
     *
     * @param z the first complex number
     * @param w the second complex number
     * @return z-w
     */
    static ComplexNumber subtract(ComplexNumber z, ComplexNumber w)
    {
        ComplexNumber sum = new ComplexNumber();
        sum.real = z.real - w.real;
        sum.imag = z.imag - w.imag;
        return sum;
    }

    // Add further functions for part 4b) - 4d) here.
    
    /**
     * Returns the complex conjugate of a complex number.
     *
     * @param  z a complex number
     * @return the complex conjugate
     */
    static ComplexNumber conjugate(ComplexNumber z)
    {
        ComplexNumber ans = new ComplexNumber();
        ans.real = z.real;
        ans.imag = -1*z.imag;
        return ans;
    }
    
    /**
     * Multiplies two complex numbers together.
     * 
     * @param z the first complex number
     * @param w the second complex number
     * @return z*w
     */
    static ComplexNumber multiply(ComplexNumber z, ComplexNumber w)
    {
        ComplexNumber ans = new ComplexNumber();
        ans.real = z.real*w.real - z.imag*w.imag;
        ans.imag = z.real*w.imag + z.imag*w.real;        
        return ans;
    }
    
    /**
     * Divides two complex numbers.
     * 
     * @param z the first complex number
     * @ param w the second complex number
     * @return z/w
     */
    
    static ComplexNumber divide(ComplexNumber z, ComplexNumber w)
    {
        ComplexNumber ans = new ComplexNumber();
        ComplexNumber wconj = conjugate(w);
        
        ComplexNumber top = multiply(z, wconj);
        ComplexNumber bottom = multiply(w, wconj);
                        
        ans.real = top.real/bottom.real;
        ans.imag = top.imag/bottom.real;
        return ans;
    }

}
