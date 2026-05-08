import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


/**
 * Unit test for statistical quantities, part (c)
 */
public class StatsTestC
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
    
    private void checkOneStddev(double[] sample, double expected)
    {
        String msg = sampleDesc(sample);
        double[] input = Arrays.copyOf(sample, sample.length);
        double actual = Stats.standardDeviation(input);
                
        assertEquals(msg, expected, actual, 1e-10);
        
        assertArrayEquals("checking whether input array is modified", sample, input, 1e-10);
    }

    @Test
    public void standardDeviationTest()
    {
        checkOneStddev(sample2, 4.94974746830583);
        checkOneStddev(sample3, 3.0);
        checkOneStddev(sample10, 3.02765035409749);
        checkOneStddev(sampleC, 0.0);
    }

    @Test
    public void standardDeviationExceptionalInputTest()
    {
        assertEquals(sampleDesc(null), Double.NaN, Stats.standardDeviation(null), 1e-10);
        assertEquals(sampleDesc(sample0), Double.NaN, Stats.standardDeviation(sample0), 1e-10);
        assertEquals(sampleDesc(sample1), Double.NaN, Stats.standardDeviation(sample1), 1e-10);
    }

}
