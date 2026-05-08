
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for the Gram-Schmidt process
 */
public class GramSchmidtTest
{
    /**
     * Scalar product - for testing
     */
    private double sp(double[] a, double[] b)
    {
        assertNotNull("vector a in scalar product", a);
        assertNotNull("vector b in scalar product", b);
        assertSame("dimensions in scalar product", a.length, b.length);

        double prod = 0.0;
        for (int i = 0; i < a.length; i++)
        {
            prod = prod + a[i] * b[i];
        }
        
        return prod;
    }

    
    /**
     * Tests whether an already orthonormal basis isn't changed by the Gram-Schmidt process
     */
    @Test
    public void orthonormalizeTestNoChange()
    {
        double[][] base = { 
                {1,0,0},
                {0,1,0},
                {0,0,1},    
            };

        double[][] ortho = GramSchmidt.orthonormalize(base);

        assertEquals("Testing an already orthonormal base, length of output", 3, ortho.length);

        for (int i = 0; i < 3; i++) 
        {
            assertArrayEquals ("Testing an already orthonormal base, vector "+i, base[i], ortho[i], 1e-10);
        }
    }

    /**
     * Tests whether an already orthogonal basis is just normalized by the Gram-Schmidt process
     */
    @Test
    public void orthonormalizeTestJustScaled()
    {
        double[][] base = { 
                {4,0,0,0,0},
                {0,5,0,0,0},
                {0,0,6,0,0},    
                {0,0,0,-7,0}
            };

        double[][] expected = { 
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},    
                {0,0,0,-1,0}    
            };

        double[][] ortho = GramSchmidt.orthonormalize(base);

        assertEquals("Testing an already orthogonal base, length of output", 4, ortho.length);

        for (int i = 0; i < 4; i++) 
        {
            assertArrayEquals ("Testing an already orthogonal base, vector "+i, expected[i], ortho[i], 1e-10);
        }
    }

    /**
     * Testing a full orthonormalization
     * Test conditions: 
     *   a) Are the output vectors orthogonal to each other?
     *   b) Are they normalized?
     *   b) Are they orthogonal to one dimension that was orthogonal to the original hyperplane?
     */
    @Test
    public void orthonormalizeTestFull()
    {
        double[][] base = { 
                {4,0,0,0,-4},
                {1,5,1,0,-1},
                {0,2,6,10,0},    
                {-3,0,2,-7,3}
            };

        double[] nv = {1,0,0,0,1};

        double[][] ortho = GramSchmidt.orthonormalize(base);

        assertEquals("Testing a full orthonormalization, length of output", 4, ortho.length);

        for (int i = 0; i < base.length; i++)
        {
            assertEquals("Testing a full orthonormalization, checking norm of vector "+i, 
                         1.0, sp(ortho[i], ortho[i]), 1e-10);
                         
            for (int j = 0; j < base.length; j++)
            {
                if (i != j) 
                {
                    assertEquals("Testing a full orthonormalization, checking scalar product between vectors "+i+" and "+j, 
                         0.0, sp(ortho[i], ortho[j]), 1e-10);                    
                }                
            }
            
            assertEquals("Testing a full orthonormalization, checking whether vector "+i+" is in hyperplane", 
                         0.0, sp(ortho[i], nv), 1e-10);

        }
     
    }

}
