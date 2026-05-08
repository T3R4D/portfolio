import static java.lang.Math.*;

/**
 * Planar Angle class
 */
public class PlanarAngle
{
    /**
     * An angle
     */
    
    double angle;
    
    /**
     * Constructor for the objects of class PlanarAngle
     * 
     * @param x, an integer between 0 and 2PI, the angle
     */
    public PlanarAngle(double x)
    {
        angle = x;
    }
    
    /**
     *  Returns the angle in Radians
     *  
     *  @return the angle in Radians
     */
    public double asRadians()
    {
        return angle;
    }
    
    /**
     * Returns the angle in Degrees
     * 
     * @return the angle in Degrees
     */
    public double asDegrees()
    {
        double x = angle*(180/PI);
        
        return x;
    }
}
