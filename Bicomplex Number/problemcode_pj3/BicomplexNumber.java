/*
 * Mathematical Skills II, Programming
 * Project 3, 2020/21
 */

import static java.lang.Math.*;


/**
 *  A class representing a bicomplex number.
 */
public class BicomplexNumber
{
    /**
     * The real part of this bicomplex number.
     */
    private double r;
    
    /**
     * The i part of this bicomplex number.
     */
    private double i;
    
    /**
     * The j part of this bicomplex number.
     */
    private double j;
    
    /**
     * The k part of this bicomplex number.
     */
    private double k;
    
    /**
     * Constructor for objects of class BicomplexNumber
     * 
     * @param a r part
     * @param b i part
     * @param c j part
     * @param d k part
     */
    public BicomplexNumber(double a, double b, double c, double d)
    {
        r = a;
        i = b;
        j = c;
        k = d;
    }
    
    /**
     * Constructs a Bicomplex number z from two complex numbers (z1 + z2j)
     * 
     * @param z1 the first complex number
     * @param z2 the second complex number
     */
    public BicomplexNumber(ComplexNumber z1, ComplexNumber z2)
    {
        r = z1.realPart();
        i = z1.imaginaryPart();
        j = z2.realPart();
        k = z2.imaginaryPart();
    }
    
    /**
     * Returns the r part of this bicomplex number.
     * 
     * @return the r part of this number
     */
    public double getA()
    {
        return r;
    }

    /**
     * Returns the i part of this bicomplex number.
     * 
     * @return the i part of this number
     */
    public double getB()
    {
        return i;
    }
    
    /**
     * Returns the j part of this bicomplex number.
     * 
     * @return the j part of this number
     */
    public double getC()
    {
        return j;
    }
    
    /**
     * Returns the k part of this bicomplex number.
     * 
     * @return the k part of this number
     */
    public double getD()
    {
        return k;
    }
    
    /**
     * Computes the absolute value of this bicomplex number.
     * 
     * @return |z| where z is the present bicomplex number
     */
    public double abs()
    {
        return Math.sqrt(r*r + i*i + j*j + k*k);
    }
    
    /**
     * Computes the square complex norm of this bicomplex number.
     * 
     * @return v(z) where z is the present bicomplex number
     */
    public ComplexNumber squareComplexNorm()
    {
        ComplexNumber norm = new ComplexNumber(r*r - i*i + j*j - k*k, 
                    2*r*i + 2*j*k);
        return norm;
    }
    
    /**
     * Computes the negative of this bicomplex number.
     * 
     * @return -z where z is the current bicomplex number.
     */
    public BicomplexNumber negate()
    {
        return new BicomplexNumber(-r, -i, -j, -k);
    }
    
    /**
     * Computes the bicomplex conjugate z(dagger) of this complex number.
     * 
     * @return z(dagger) where z is the current bicomplex number.
     */
    public BicomplexNumber conjugate()
    {
        return new BicomplexNumber(r, i, -j, -k);
    }
    
    /**
     * Adds a bicomplex number to this one.
     * 
     * @param w the bicomplex number to add
     * @return z+w where z is the "present" number
     */
    public BicomplexNumber add(BicomplexNumber w)
    {
        BicomplexNumber sum = new BicomplexNumber( this.r + w.r, 
                    this.i + w.i, this.j + w.j, this.k + w.k );
        return sum;
    }
    
    /**
     * Subtracts a bicomplex number from this one, and returns the resulting 
     * bicomplexNumber.
     * 
     * @param w the bicomplex number to subtract
     * @return z-w where z is the "present" number
     */
    public BicomplexNumber subtract(BicomplexNumber w)
    {
        BicomplexNumber difference = new BicomplexNumber( this.r - w.r, 
                    this.i - w.i, this.j - w.j, this.k - w.k);
        return difference;
    }

    
    /**
     * Multiplies a bicomplex number with this one.
     * 
     * @param w the bicomplex number to multiply with
     * @return z*w where z is the "present" number
     */
    public BicomplexNumber multiply(BicomplexNumber w)
    {
        double newR = this.r*w.r - this.i*w.i - this.j*w.j + this.k*w.k;
        double newI = this.r*w.i + this.i*w.r - this.j*w.k - this.k*w.j;
        double newJ = this.r*w.j - this.i*w.k + this.j*w.r - this.k*w.i;
        double newK = this.r*w.k + this.i*w.j + this.j*w.i + this.k*w.r;
        BicomplexNumber product = new BicomplexNumber(newR, newI, newJ, newK); 
        return product;
    }
    
    /**
     * Computes the inverse of this bicomplex number.
     * The inverse can be computed as 1/z = v(z)^-1 * z(dagger)
     * 
     * @return 1/z where z is the current bicomplex number.
     * @throws ArithmeticException
     */
    public BicomplexNumber invert() 
    {
        BicomplexNumber answer = new BicomplexNumber(0,0,0,0);
        ComplexNumber a = new ComplexNumber(0,0);
        
        ComplexNumber norm = squareComplexNorm();
        BicomplexNumber conjugate = conjugate();
        ComplexNumber norminverse = norm.invert();
        double number1 = norm.abs();
        double number2 = pow(10,-10)*pow(this.abs(),2);
        
        if(norm.abs() == 0)
        {
            throw new ArithmeticException("Bicomplex number is not invertible!");
        }
        else if(norm.abs() >= pow(10,-10)*pow(abs(),2))
        {
            BicomplexNumber boop = new BicomplexNumber
                (norminverse.realPart(), norminverse.imaginaryPart(), 0, 0);
            answer = boop.multiply(conjugate);
            
            return answer;
        }
             
        throw new ArithmeticException("Bicomplex number is not invertible!");
        
    }
    
    /**
     * Divides this bicomplex number by another one.
     * 
     * @param w the bicomplex number to divide by
     * @return z/w where z is the "present" number
     */
    public BicomplexNumber divide(BicomplexNumber w)
    {
        return this.multiply( w.invert() );
    }
    
    /**
     * Returns a textual representation of this object.
     * This overrides the toString() method in java.lang.Object.
     * 
     * @return real and imaginary parts of this number, as a string
     */
    public String toString()
    {
        String isign = " + ";
        if( i < 0 )
        {
            isign = " ";
        }
        String jsign = " + ";
        if( j < 0 )
        {
            jsign = " ";
        }
        String ksign = " + ";
        if( k < 0 )
        {
            ksign = " ";
        }
        
        return r + isign + i + " i" + jsign + j + " j" + ksign + k + " k";
    }
    
    /**
     * Computes the exp of this bicomplex number.
     * 
     * @return exp(z) where z is the "present" number
     */
    public BicomplexNumber exp()
    {
        ComplexNumber z1 = new ComplexNumber( this.r, this.i );
        ComplexNumber z2 = new ComplexNumber( this.j, this.k );
        
        z1 = z1.exp();
        BicomplexNumber boop = new BicomplexNumber(z1.realPart(), 
                z1.imaginaryPart(), 0, 0);
        
        double areal = cos(z2.realPart())*cosh(z2.imaginaryPart());
        double aimag = sin(z2.realPart())*sinh(z2.imaginaryPart());
        double breal = sin(z2.realPart())*cosh(z2.imaginaryPart());
        double bimag = cos(z2.realPart())*sinh(z2.imaginaryPart());
        
        ComplexNumber a = new ComplexNumber(areal, aimag);
        ComplexNumber b = new ComplexNumber(breal, bimag);
        
        BicomplexNumber c = new BicomplexNumber(a, b);
        
        BicomplexNumber answer = boop.multiply(c);
        
        return answer;
    }
}
