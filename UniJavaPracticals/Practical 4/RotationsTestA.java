
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for rotation matrices, part (a)
 */
public class RotationsTestA
{

    @Test
    public void rotationMatrixIdentityTest()
    {
        for (int axis = 1; axis <= 3; axis++) {
            String msg = "Testing angle zero rotation around axis "+axis;
            double[][] identity = {{1,0,0},{0,1,0},{0,0,1}};
            double[][] rm = Rotations.rotationMatrix(axis, 0);
            TestHelper.assertMatrixEquals (msg, identity, rm);
        }
    }

    @Test
    public void rotationMatrix90DegTest()
    {
        String msg;
        double[][] expected, rm;
        
        msg = "Testing 90 degrees rotation around axis 1";
        expected = new double[][] {{1,0,0},{0,0,-1},{0,1,0}};
        rm = Rotations.rotationMatrix(1, Math.PI/2);
        TestHelper.assertMatrixEquals (msg, expected, rm);

        msg = "Testing 90 degrees rotation around axis 2";
        expected = new double[][] {{0,0,1},{0,1,0},{-1,0,0}};
        rm = Rotations.rotationMatrix(2, Math.PI/2);
        TestHelper.assertMatrixEquals (msg, expected, rm);

        msg = "Testing 90 degrees rotation around axis 3";
        expected = new double[][] {{0,-1,0},{1,0,0},{0,0,1}};
        rm = Rotations.rotationMatrix(3, Math.PI/2);
        TestHelper.assertMatrixEquals (msg, expected, rm);
    }
    
    @Test
    public void rotationMatrix30DegTest()
    {
        String msg;
        double[][] expected, rm;
        
        double c = 0.8660254037844385;
        
        msg = "Testing 30 degrees rotation around axis 2";
        expected = new double[][] {{c,0,0.5},{0,1,0},{-0.5,0,c}};
        rm = Rotations.rotationMatrix(2, Math.PI/6);
        TestHelper.assertMatrixEquals (msg, expected, rm);

    }
}

    
    


