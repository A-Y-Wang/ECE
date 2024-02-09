
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SelectionSortTest {

    @Test
    public void test1(){
        int[] a = {1, 4, 3, 5};
        int[] b = {1, 3, 4, 5};
        SelectionSort.sort(a);
        assertArrayEquals(b, a);

    }

    @Test
    public void test2(){
        int[] a = {1, 6, 3, 9, 7};
        int[] b = {1, 3, 6, 7, 9};
        SelectionSort.sort(a);
        assertArrayEquals(b, a);

    }

}
