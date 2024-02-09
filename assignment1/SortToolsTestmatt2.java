package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortToolsTestmatt2 {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    SortTools s = new SortTools();
    // Write your JUnit tests here

    // sorted tests
    @Test
    public void isSortedTest() {
        int[] x = {1, 2, 3, 4};
        int n = x.length;
        assertEquals(true, s.isSorted(x, n));
        assertTrue(s.isSorted(x, n));
    }

    @Test
    public void isSortedEmpty() {
        int[] x = {};
        assertTrue(s.isSorted(x, 0));
    }

    @Test
    public void isNotSorted() {
        int[] x = {1, 4, 2, 5};
        assertFalse(s.isSorted(x, x.length));
    }

    @Test
    public void isSortedSingleElement() {
        int[] x = {1};
        assertTrue(s.isSorted(x, 1));
    }

    // Binary Search tests
    @Test
    public void findSingleElement() {
        int[] arr = {0, 2, 9, 13, 15, 16, 17, 17, 18, 19};
        assertEquals(Arrays.binarySearch(arr, 9), s.find(arr, arr.length, 9));
    }

    @Test
    public void findElement() {
        int[] arr = {1, 4, 6, 8, 9, 14, 17, 34, 67};
        for (int i : arr) {
            assertEquals(Arrays.binarySearch(arr, i), s.find(arr, arr.length, i));
        }
    }

    @Test
    public void findMissingElements() {
        int[] arr = {1, 3, 4, 6, 7, 8, 9};
        assertEquals(-1, s.find(arr, arr.length, 2));
        assertEquals(-1, s.find(arr, arr.length, -1));
        assertEquals(-1, s.find(arr, arr.length, 5));
        assertEquals(-1, s.find(arr, arr.length, 100));
    }

    @Test
    public void findInIncreasinglyLargeRandomArrayManyTimes() {
        for (int q = 0; q < 2000; q++){
            Random r = new Random();
            int[] arr = new int[q + 2];
            int randInd = r.nextInt(arr.length - 1);
            int randInt = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(500);
                if (randInd == i) {
                    randInt = arr[i];
                }
            }

            // this part basically checks the isSorted, insertSort, and binary search functions at once
            s.insertSort(arr, arr.length);
//            System.out.println(Arrays.toString(arr));
            randInd = Arrays.binarySearch(arr, randInt);

            System.out.println(Arrays.toString(arr));
            assertTrue(s.isSorted(arr, arr.length));
            assertEquals(arr[randInd], arr[s.find(arr, arr.length, randInt)]);
        }
    }

    // copyAndInsert tests
    @Test
    public void testCopyInsert() {
        int[] arr = {4, 5, 6, 6, 9};
        int[] expected = {3, 4, 5, 6, 6, 9};
        assertArrayEquals(expected, s.copyAndInsert(arr, 5, 3));
    }

    @Test
    public void testEndCopyInsert() {
        int[] arr = {2};
        int[] expected = {1, 2};
        assertArrayEquals(expected, s.copyAndInsert(arr, 1, 1));
    }

    @Test
    public void testStartCopyInsert() {
        int[] arr = {4, 5, 12, 63};
        int[] expected = {-4, 4, 5, 12, 63};
        assertArrayEquals(expected, s.copyAndInsert(arr, 4, -4));
    }

    @Test
    public void testManyCopyInserts() {
        for (int j = 0; j < 50; j++) {
            Random r = new Random();
            int len = r.nextInt(15) + 1;
            System.out.println("Array length is: " + len);
            int[] arr = new int[len];

            int rand = r.nextInt(len * 2);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(arr.length * 2);
            }

            int[] arr_copy = Arrays.copyOf(arr, len);
            s.insertSort(arr_copy, len);
            System.out.print("Insert the number " + rand + " into: ");
            System.out.println(Arrays.toString(arr_copy));
            Arrays.sort(arr);
            // we now have a random unsorted array of length len
            // if rand is in the array, then we don't need to do anything
            if (s.find(arr_copy, arr_copy.length, rand) >= 0) {
                System.out.println("Since " + rand + " is already contained in the array, we just return the first n elements.");
                int[] a = s.copyAndInsert(arr_copy, len, rand);
                System.out.println("The new array length is: " + a.length);
                System.out.println("Inserted array: " + Arrays.toString(a) + "\n");
                assertArrayEquals(a, arr_copy);
            } else {
                int[] a = s.copyAndInsert(arr_copy, len, rand);
                System.out.println("The new array length is: " + a.length);
                System.out.println("Inserted array: " + Arrays.toString(a) + "\n");

                if (arr_copy[len - 1] > rand) {
                    arr_copy = Arrays.copyOf(arr_copy, len);
                    arr_copy[len - 1] = rand;
                    Arrays.sort(arr_copy);
                }
                assertArrayEquals(a, arr_copy);
            }
        }
    }

    // insert in place tests
    @Test
    public void testInsertInPlace() {
        int[] arr = {1, 4, 6, 7, 9, 10};
        s.insertInPlace(arr, 4, 8);
        int[] v = Arrays.copyOf(arr, 5);
        int[] expected = {1, 4, 6, 7, 8};
        assertArrayEquals(expected, v);
    }

    // insertSort Tests
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {5}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 5, 8};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {1, 2, 3, 5, 8}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {8, 5, 3, 2, 1};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {1, 2, 3, 5, 8}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testRandomArray() {
        int[] arr = new int[] {4, 1, 7, 3, 9, 2};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {1, 2, 3, 4, 7, 9}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {2, 5, 1, 5, 3, 2};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {1, 2, 2, 3, 5, 5}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {-3, 0, -1, 5, 2};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {-3, -1, 0, 2, 5}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }


    // more complex tests
    @Test
    public void testLongRandomArray() {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        s.insertSort(arr, arr.length);

        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testArrayWithSpecificPattern() {
        int[] arr = new int[200];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i % 2 == 0) ? i : -i; // Alternating positive and negative
        }

        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        s.insertSort(arr, arr.length);

        assertArrayEquals(expected, arr); // Helper function to generate expected array
        assertTrue(s.isSorted(arr, arr.length));
    }

    @Test
    public void testLargeRandomArray() {
        int[] arr = generateRandomArray(5000); // Generate an array of size 1000
        int[] expected = Arrays.copyOf(arr, arr.length); // Create a copy for comparison
        Arrays.sort(expected); // Sort the copy using a trusted sorting method

        s.insertSort(arr, arr.length); // Sort the test array
        assertArrayEquals(expected, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    // --- Tests for specific edge cases ---

    @Test
    public void testArrayWithAllEqualElements() {
        int[] arr = {7, 7, 7, 7, 7};
        s.insertSort(arr, arr.length);
        assertArrayEquals(new int[] {7, 7, 7, 7, 7}, arr);
        assertTrue(s.isSorted(arr, arr.length));
    }

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // You can set a range for random numbers if needed
        }
        return arr;
    }
}