import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.assertArrayEquals

public class ArrayStuffTest {
    @Test
    public void test(){
        int[] a = new int[0];
        int[] b = new int[0];
        assertTrue(ArraryStuff.equals(a, b));
    }

    @Test
    public void test_twoRegularArrayAreDifferent(){
        int[] a = new int[] {1,3,5,7};
        int[] b = new int[] {1,3,5,};
        assertFalse(ArrayStuff.equals(a,b));
    }

    @Test
    public void test_oneArrayEmptyOtherArrayNot(){
        int[] a = new int[] {1,2,3,4,5};
        int[] a = new int[0];
        assertFalse(ArrayStuff.equals(a,b));
    }
}
