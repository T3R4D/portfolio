/*
 * Mathematical Skills II, Programming
 * Project 3
 */

import static java.lang.Math.*;

/**
 * A class representing a complex number.
 * 
 * There is no need to change this file - it is taken from the Practicals.
 */
public class ComplexNumber
{

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
     * Computes the negative of this complex number.
     * 
     * @return -z where z is the current complex number.
     */
    public ComplexNumber negate()
    {
        return new ComplexNumber(-real, -imag);
    }

    /**
     * Computes the complex conjugate z* of this complex number.
     * 
     * @return z* where z is the current complex number.
     */
    public ComplexNumber conjugate()
    {
        return new ComplexNumber(real, -imag);
    }


    /**
     * Computes the inverse of this complex number.
     * The inverse can be computed as 1/z = z* / |z|^2, which is written out in 
     * real and imaginary part below.
     * 
     * @return 1/z where z is the current complex number.
     */
    public ComplexNumber invert()
    {
        double denom = real * real + imag * imag;
        double newR = real / denom;
        double newI = -imag / denom;
        return new ComplexNumber(newR, newI);
    }


    /**
     * Adds a complex number to this one.
     * 
     * @param w the complex number to add
     * @return z+w where z is the "present" number
     */
    public ComplexNumber add(ComplexNumber w)
    {
        ComplexNumber sum = new ComplexNumber( this.real + w.real, this.imag + w.imag );
        return sum;
    }

    /**
     * Subtracts a complex number from this one, and returns the resulting ComplexNumber.
     * 
     * @param w the complex number to subtract
     * @return z-w where z is the "present" number
     */
    public ComplexNumber subtract(ComplexNumber w)
    {
        ComplexNumber difference = new ComplexNumber( this.real - w.real, this.imag - w.imag );
        return difference;
    }

    
    /**
     * Multiplies a complex number with this one.
     * 
     * @param w the complex number to multiply with
     * @return z*w where z is the "present" number
     */
    public ComplexNumber multiply(ComplexNumber w)
    {
        double newR = this.real * w.real - this.imag * w.imag;
        double newI = this.real * w.imag + this.imag * w.real;
        ComplexNumber product = new ComplexNumber(newR, newI); 
        return product;
    }

    /**
     * Divides this complex number by another one.
     * 
     * @param w the complex number to divide by
     * @return z/w where z is the "present" number
     */
    public ComplexNumber divide(ComplexNumber w)
    {
        return this.multiply( w.invert() );
        /* alternative solution:
        double denom = w.real * w.real + w.imag * w.imag;
        double newR = (this.real * w.real + this.imag * w.imag) / denom;
        double newI = (-this.real * w.imag + this.imag * w.real) / denom;
        return new ComplexNumber(newR, newI);
        */
    }

    /**
     * Exponentiates this complex number.
     * 
     * @return exp(z) where z is the present complex number
     */
    public ComplexNumber exp()
    {
        double rexp = Math.exp(real);
        double newR = rexp * Math.cos(imag);
        double newI = rexp * Math.sin(imag);
        return new ComplexNumber(newR, newI);
    }


    /**
     * Takes the logarithm of this complex number.
     * 
     * @return log(z) where z is the present complex number
     */
    public ComplexNumber log()
    {
        double newR = Math.log(abs());
        double newI = arg();
        return new ComplexNumber(newR, newI);
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

}
