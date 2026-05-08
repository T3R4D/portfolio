/*
 * Mathematical Skills II, Programming
 * Code for Practical 7, Exercise 3
 */

import static java.lang.Math.*;

/**
 * A class representing a complex number.
 */
public class ComplexNumber
{

    /*
     * Below you will find the fields and methods that were implemented during Lecture 12.
     * Add your own methods at the end, or anywhere in between.
     */
    
    /**
     * The real part of this complex number.
     */
    private double real;
    
    /**
     * The imaginary part of this complex number.
     */
    private double imag;
    
    /**
     * Constructor for objects of class ComplexNumber
     * 
     * @param x real part
     * @param y imaginary part
     */
    public ComplexNumber(double x, double y)
    {
        real = x;
        imag = y;
    }

    /**
     * Returns the real part of this complex number.
     * 
     * @return the real part of this number
     */
    public double realPart()
    {
        return real;
    }

    /**
     * Returns the imaginary part of this complex number.
     * 
     * @return the imaginary part of this number
     */
    public double imaginaryPart()
    {
        return imag;
    }
    
    /**
     * Computes the absolute value of this complex number.
     * 
     * @return |z| where z is the present complex number
     */
    public double abs()
    {
        return Math.sqrt(real*real + imag*imag);
    }
    

    /**
     * Computes the argument (polar angle) of this complex number.
     * 
     * @return arg(z) where z is the present complex number
     */
    public double arg()
    {
        return Math.atan2(imag, real);
    }


    /**
     * Adds a complex number to this one.
     * 
     * @param z the complex number to add
     * @return z+w where w is the "present" number
     */
    public ComplexNumber add(ComplexNumber z)
    {
        ComplexNumber sum = new ComplexNumber( this.real + z.real, this.imag + z.imag );
        return sum;
    }
    
    
    /**
     * Multiplies a complex number with this one.
     * 
     * @param z the complex number to multiply by
     * @return z*w where w is the "present" number
     */
    public ComplexNumber multiply(ComplexNumber z)
    {
        double newR = this.real * z.real - this.imag * z.imag;
        double newI = this.real * z.imag + this.imag * z.real;
        ComplexNumber product = new ComplexNumber(newR, newI); 
        return product;
    }
    
    /**
     * Returns a textual representation of this object.
     * This overrides the toString() method in java.lang.Object.
     * 
     * @return real and imaginary part of this number, as a string
     */
    public String toString()
    {
        return real + " + "+imag+" i";
    }
    
    /**
     * Returns the negate of an object
     * 
     * @return -z 
     */
    public ComplexNumber negate()
    {
        ComplexNumber z = new ComplexNumber( -this.real, -this.imag );
        return z;
    }

    /**
     * Returns the conjugate of an object
     * 
     * @return z with a squiggle
     */
    public ComplexNumber conjugate()
    {
        ComplexNumber z = new ComplexNumber( this.real, -this.imag );
        return z;
    }
    
    /**
     * Returns the invert of an object
     * 
     * @return 1/z
     */
    public ComplexNumber invert()
    {
        ComplexNumber z = new ComplexNumber( this.real, this.imag );
        ComplexNumber w = z.conjugate();
        ComplexNumber bottom = z.multiply(w);
        double x = bottom.real;
        z = new ComplexNumber( w.real/x, w.imag/x);
        
        return z;
    }
    
    /**
     * Subtracts w from z
     * 
     * @param w the complex number to subtract
     * @return z-w
     */
    public ComplexNumber subtract(ComplexNumber w)
    {
        ComplexNumber answer = new ComplexNumber( this.real - w.real, 
                                                  this.imag - w.imag );
        
        return answer;
    }
    
    /**
     * Divides z by w
     * 
     * @param w the complex number to divide by
     * @return z/w
     */
    public ComplexNumber divide(ComplexNumber w)
    {
        ComplexNumber v = w.conjugate();
        ComplexNumber bottom = v.multiply(w);
        ComplexNumber top = v.multiply(this);
        double x = bottom.real;
        double y = top.real;
        double z = top.imag;
        ComplexNumber answer = new ComplexNumber( y/x, z/x );
        
        return answer;
    }
    
    /**
     * Exp(z) 
     * 
     * @return exp(z) as a complex number
     */
    public ComplexNumber exp()
    {
        ComplexNumber z = new ComplexNumber( Math.exp(this.real), 
                                             Math.exp(this.imag) );
        
        return z;
    }
    
    /**
     * Log (z)
     * 
     * @return log(z) as a complex number
     */
    public ComplexNumber log()
    {
        ComplexNumber z = new ComplexNumber( 
    }
}

