
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for basic exercises with arrays.
 */
public class ArraysTest
{
    
    @Test
    public void testSumOfThree() 
    {
        assertEquals("Testing [0,0,0]", 0, Arrays.sumOfThree(new int[] {0,0,0}) );
        assertEquals("Testing [1,0,0]", 1, Arrays.sumOfThree(new int[] {1,0,0}) );
        assertEquals("Testing [0,1,0]", 2, Arrays.sumOfThree(new int[] {0,1,0}) );
        assertEquals("Testing [0,0,1]", 3, Arrays.sumOfThree(new int[] {0,0,1}) );
        assertEquals("Testing [1,1,1]", 6, Arrays.sumOfThree(new int[] {1,1,1}) );
        assertEquals("Testing [10,-20,30]", 60, Arrays.sumOfThree(new int[] {10,-20,30}) );
    }
    
    private void testOneFirstPlusLast(int expected, int[] a) 
    {
        String msg = "Testing "+java.util.Arrays.toString(a);
        int actual = Arrays.firstPlusLast(a);
        assertEquals(msg, expected, actual);
    }
    
    @Test
    public void firstPlusLastTest()
    {
        testOneFirstPlusLast(3, new int[] {1, 2});
        testOneFirstPlusLast(-1, new int[] {1, -2});
        testOneFirstPlusLast(5, new int[] {1, 2, 3, 4});
        testOneFirstPlusLast(-8, new int[] {-2, -3, -4, -5, -6});
        testOneFirstPlusLast(4, new int[]{2});
    }

    private void testOneMax(int expected, int[] a) 
    {
        String msg = "Testing "+java.util.Arrays.toString(a);
        int actual = Arrays.max(a);
        assertEquals(msg, expected, actual);
    }
    
    @Test
    public void maxTest()
    {
        testOneMax(2, new int[] {1, 2});
        testOneMax(2, new int[] {2, 1});
        testOneMax(5, new int[] {1, 2, 3, 4, 5, 2, 1});
        testOneMax(-5, new int[] {-10, -12, -13, -5, -12, -10});
        testOneMax(8, new int[] {8});
    }

    private void testOneMin(int expected, int[] a) 
    {
        String msg = "Testing "+java.util.Arrays.toString(a);
        int actual = Arrays.min(a);
        assertEquals(msg, expected, actual);
    }
    
    @Test
    public void minTest()
    {
        testOneMin(1, new int[] {1, 2});
        testOneMin(1, new int[] {2, 1});
        testOneMin(2, new int[] {5, 2, 3, 4, 5, 2, 6});
        testOneMin(-13, new int[] {-10, -12, -13, -5, -12, -10});
        testOneMin(8, new int[] {8});
    }

    private void testOneReverse(int[] expected, int[] a) 
    {
        String msg = "Testing "+java.util.Arrays.toString(a);
        int[] input = java.util.Arrays.copyOf(a, a.length);
        int[] actual = Arrays.reverse(input);
        assertArrayEquals(msg, expected, actual);
        assertArrayEquals("Checking whether input array was modified", a, input);
    }
    
    @Test
    public void reverseTest()
    {
        testOneReverse(new int[] {2, 1}, new int[] {1, 2});
        testOneReverse(new int[] {1, 2}, new int[] {2, 1});
        testOneReverse(new int[] {5, 2, 3, 4, 5, 2, 6}, new int[] {6, 2, 5, 4, 3, 2, 5});
        testOneReverse(new int[] {3, 2, 1, 0, -1, -2}, new int[] {-2, -1, 0, 1, 2, 3});
        testOneReverse(new int[] {8}, new int[] {8});
    }

    @Test
    public void testDayNames()
    {
        String[] s = Arrays.dayNames();
        assertEquals("Checking array length", 7, s.length);
        assertEquals("Checking index 0", "Monday", s[0]);
        assertEquals("Checking index 1", "Tuesday", s[1]);
        assertEquals("Checking index 2", "Wednesday", s[2]);
        assertEquals("Checking index 3", "Thursday", s[3]);
        assertEquals("Checking index 4", "Friday", s[4]);
        assertEquals("Checking index 5", "Saturday", s[5]);
        assertEquals("Checking index 6", "Sunday", s[6]);
    }

}
