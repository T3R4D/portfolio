import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

/**
 * Unit test for statistical quantities, part (a)
 */
public class StatsTestA
{

    private static double[] sample0 = {};
    private static double[] sample1 = {3};
    private static double[] sample2 = {-1, 6};
    private static double[] sample3 = {-1, 5, 2};
    private static double[] sample10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static double[] sampleC = {1, 1, 1, 1, 1, 1, 1};

    private String sampleDesc(double[] sample)
    {
        if (sample == null)
        {
            return "Using null sample";
        }
        else
        {
            String res = "Using sample "+Arrays.toString(sample);
            return res;
        }
    }

    private void checkOneMeanValue(double[] sample, double expected)
    {
        String msg = sampleDesc(sample);
        double[] input = Arrays.copyOf(sample, sample.length);
        double actual = Stats.meanValue(input);
                
        assertEquals(msg, expected, actual, 1e-10);
        
        assertArrayEquals("checking whether input array is modified", sample, input, 1e-10);
    }

    @Test
    public void meanValueTest()
    {
        checkOneMeanValue(sample1, 3.0);
        checkOneMeanValue(sample2, 2.5);
        checkOneMeanValue(sample3, 2.0);
        checkOneMeanValue(sample10, 5.5);
        checkOneMeanValue(sampleC, 1.0);
    }

    @Test
    public void meanValueExceptionalInputTest()
    {
        assertEquals(sampleDesc(sample0), Double.NaN, Stats.meanValue(sample0), 1e-10);

        try 
        {
            assertEquals(sampleDesc(null), Double.NaN, Stats.meanValue(null), 1e-10);
        } 
        catch (NullPointerException e)
        {
            fail("You accessed the input array before checking whether is is null");
        }

    }

}
