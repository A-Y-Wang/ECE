package assignment1;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.rules.Timeout;
import java.util.Arrays;

//hard coded cause i was lazy

public class SortToolsTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    // Write your JUnit tests here
    //isSorted JUnit Tests
    @Test
    public void test1_isSorted(){
        int[] a = {3,2,1};
        boolean answer = SortTools.isSorted(a, 3);
        assertFalse("Test 1 failed", answer);
    }
    @Test
    public void test2_isSorted(){
        int[] a = {1,2,4,5,6,7,21,19,4};
        boolean answer = SortTools.isSorted(a, 9);
        assertFalse("Test 2 failed", answer);
    }
    @Test
    public void test3_isSorted(){
        int[] a = {};
        boolean answer = SortTools.isSorted(a, 0);
        assertTrue("Test 3 failed",answer);
    }


    //find JUnit Tests

    @Test
    public void test1_find(){
        int[] a = {1,3,5,9,12,15,4,3};
        int answer = SortTools.find(a, 5,9);
        assertEquals("Test 1 Failed",3, answer);
    }

    @Test
    public void test2_find() {
        // index 0 or 1 both work
        int[] a = {14, 14, 17, 20, 20, 100, 101, 101};
        int answer = SortTools.find(a, 8, 20);
        assertEquals("Test 1 Failed", 3, answer);
    }

    @Test
    public void test3_find() {
        int[] a = {1,2,3,6,8,10,12};
        int answer = SortTools.find(a, 7, 14);
        assertEquals("Test 1 Failed", -1, answer);
    }
    @Test
    public void test4_find() {
        int[] a = {1,2,3,6,8,10,12};
        int answer = SortTools.find(a, 7, -3);
        assertEquals("Test 1 Failed", -1, answer);
    }
    @Test
    public void test5_find() {
        int[] a = {1,2,3,6,8,10,12,25,26,27,30,30,44,71,71,80};
        int answer = SortTools.find(a, a.length, 45);
        assertEquals("Test 1 Failed", -1, answer);
    }

// copy and insert tests
    @Test
    public void test1_copyAndInsert() {
        int[] a = {1,2,4,5,6,7,8,9,10,11,12,13};
        int[] check = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] answer = SortTools.copyAndInsert(a, 12, 3);
        assertArrayEquals("Test 1 Failed", check , answer);
    }

    @Test
    public void test2_copyAndInsert() {
        int[] a = {2,3,5,7,12,15};
        int[] check = {1,2};
        int[] answer = SortTools.copyAndInsert(a, 1, 1);
        assertArrayEquals("Test 1 Failed", check , answer);
    }

    @Test
    public void test3_copyAndInsert() {
        int[] a = {1,1,1,7,9,10,15,16};
        int[] check = {1,1,1,7};
        int[] answer = SortTools.copyAndInsert(a, 4, 1);
        assertArrayEquals("Test 1 Failed", check , answer);
    }
    @Test
    public void test4_copyAndInsert() {
        int[] a = {2, 3, 5, 7, 12, 15};
        int[] check = {2, 3, 5, 7, 12, 15, 16};
        int[] answer = SortTools.copyAndInsert(a, 6, 16);
        assertArrayEquals("Test 1 Failed", check, answer);
    }
// Insert in Place tests
    @Test
    public void test1_insertInPlace() {
        int[] a = {1,7,9,10,15,16};
        int answer = SortTools.insertInPlace(a, 4, 3);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {1, 3, 7, 9, 10} ");
        assertEquals("Test 1 Failed", 5 , answer);
    }
    @Test
    public void test2_insertInPlace() {
        int[] a = {1,7,9,10,14,16};
        int answer = SortTools.insertInPlace(a, 6, 14);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {1, 7, 9, 10, 14, 16} ");
        assertEquals("Test 1 Failed", 6 ,answer);
    }
    @Test
    public void test3_insertInPlace() {
        int[] a = {2,7,9,10,15,16};
        int answer = SortTools.insertInPlace(a, 5, 1);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {1, 2, 7, 9, 10, 15} ");
        assertEquals("Test 1 Failed", 6 ,answer);
    }

// insert sort tests
    @Test
    public void test1_insertSort() {
        int[] a = {30,25,14,6,9,4,3,2,1};
        int[] expected = {6, 9, 14, 25, 30, 4, 3, 2, 1};
        SortTools.insertSort(a, 5);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {6, 9, 14, 25, 30, 4, 3, 2, 1} ");
        assertArrayEquals("Test 1 Failed", expected , a );
    }
    @Test
    public void test2_insertSort() {
        int[] a = {30,25,14,6,9,4,3,2,1};
        int[] expected = {30,25,14,6,9,4,3,2,1};
        SortTools.insertSort(a, 1);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {30, 25, 14, 6, 9, 4, 3, 2, 1} ");
        assertArrayEquals("Test 1 Failed", expected , a );
    }
    @Test
    public void test3_insertSort() {
        int[] a = {12,14,15,19,6,2,100,19,12,7,55,81,90,22};
        int[] expected = {2, 6, 7, 12, 12, 14, 15, 19, 19, 22, 55, 81, 90, 100};
        SortTools.insertSort(a, a.length);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {2, 6, 7, 12, 12, 14, 15, 19, 19, 22, 55, 81, 90, 100} ");
        assertArrayEquals("Test 1 Failed", expected , a );
    }

    @Test
    public void test4_insertSort() {
        int[] a = {-1,-7, -5, -8, -10, -91, -100};
        int[] expected = {-7, -5, -1, -8, -10, -91, -100};
        SortTools.insertSort(a, 3);
        System.out.println("Your program array is: " + Arrays.toString(a));
        System.out.print("Your intended array is {-7, -5, -1, -8, -10, -91, -100} ");
        assertArrayEquals("Test 1 Failed", expected , a );
    }
}
