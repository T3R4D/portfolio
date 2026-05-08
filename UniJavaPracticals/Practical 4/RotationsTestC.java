

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for rotation matrices, part (c)
 */
public class RotationsTestC
{


    @Test
    public void rotateThisVectorTest()
    {
        double[] v = {1,3,2};
        double[] expect = {0.7500000000000000, -0.700961894323342 , 3.598076211353316};
        String msg = "Testing rotated vector";
        
        double[] res = Rotations.rotateThisVector();
        assertArrayEquals(msg, expect, res, 1e-10);
        
    }

}
