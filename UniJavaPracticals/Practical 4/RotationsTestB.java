

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for rotation matrices, part (b)
 */
public class RotationsTestB
{

    @Test
    public void rotateVectorZeroTest()
    {
        double[] v = {1, 2, -1};
        double[] w = v.clone();
        
        double[] res = Rotations.rotateVector(v, 0, 0, 0);
        assertArrayEquals("Rotating v = "+Arrays.toString(w)+" by 0 degrees", w, res, 1e-10);
        
    }

    @Test
    public void rotateVector45Test()
    {
        double[] v = {1, 2, -1};
        double[] expect = {-0.6464466094067262, 2.353553390593274, -0.2071067811865475};
        String msg = "Rotating v = "+Arrays.toString(v)+" by 45 degrees in each axis";
        
        double[] res = Rotations.rotateVector(v, Math.PI/4, Math.PI/4, Math.PI/4);
        assertArrayEquals(msg, expect, res, 1e-10);
        
    }

}
