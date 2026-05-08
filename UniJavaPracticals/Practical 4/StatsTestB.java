import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


/**
 * Unit test for statistical quantities, part (b)
 */
public class StatsTestB
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

    private void checkOneMoment(double[] sample, int k, double expected)
    {
        String msg = sampleDesc(sample);
        double[] input = Arrays.copyOf(sample, sample.length);
        double actual = Stats.moment(input, k);
                
        assertEquals(msg, expected, actual, 1e-10);
        
        assertArrayEquals("checking whether input array is modified", sample, input, 1e-10);
    }

    @Test
    public void momentTest()
    {
        checkOneMoment(sample1, 1, 3.0);
        checkOneMoment(sample1, 2, 9.0);
        checkOneMoment(sample2, 1, 2.5);
        checkOneMoment(sample2, 2, 18.5);
        checkOneMoment(sample2, 3, 107.5);
        checkOneMoment(sample2, 4, 648.5);
        checkOneMoment(sample3, 1, 2.0);
        checkOneMoment(sample3, 2, 10.0);
        checkOneMoment(sample10, 2, 38.5);
        checkOneMoment(sampleC, 1, 1.0);
        checkOneMoment(sampleC, 10, 1.0);
    }
    
    @Test
    public void momentExceptionalInputTest()
    {
        assertEquals(sampleDesc(null)+ ", k=2", Double.NaN, Stats.moment(null, 2), 1e-10);
        assertEquals(sampleDesc(sample0)+ ", k=2", Double.NaN, Stats.moment(sample0, 2), 1e-10);
    }


}
