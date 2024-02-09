package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SortToolsTestmatt {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    SortTools s = new SortTools();
        // Write your JUnit tests here
        @Test
        public void isSorted1(){
            int[] x = new int [] {0,1,2,3,4};
            int[] old = new int [] {0,1,2,3,4};
            int n = x.length;
            assertTrue(SortTools.isSorted(x, n));
            assertArrayEquals(old,x);
        }

        @Test
        public void isSorted2(){
            int[] x = new int [] {};
            int[] old = new int [] {};
            assertTrue(SortTools.isSorted(x, 0));
            assertArrayEquals(x,old);
        }
        @Test
        public void isSorted3(){
            int[] x = new int [] {5,4,3,2,1};
            int[] old = new int [] {5,4,3,2,1};
            assertFalse(SortTools.isSorted(x, 5));
            assertArrayEquals(x,old);
        }
        @Test
        public void find1(){
            int[] x = new int [] {1,2,3,4,5};
            int[] old = new int [] {1,2,3,4,5};
            assertEquals(2,SortTools.find(x, 5,3));
            assertArrayEquals(x,old);
        }
        @Test
        public void find2(){
            int[] x = new int [] {1,2,3,4,5};
            int[] old = new int [] {1,2,3,4,5};
            assertEquals(-1,SortTools.find(x, 5,6));
            assertArrayEquals(x,old);
        }
        @Test
        public void find3(){
            int[] x = new int [] {1,2,3,4,5};
            int[] old = new int [] {1,2,3,4,5};
            assertEquals(-1,SortTools.find(x, 1,5));
            assertArrayEquals(x,old);
        }
        @Test
        public void copy1(){
            int[] x = new int [] {1,3,5,7};
            int[] old = new int [] {1,3,5,7};
            int[] y = new int [] {1,3,5,10};
            assertArrayEquals(y,SortTools.copyAndInsert(x, 3,10));
            assertArrayEquals(x,old);
        }
        @Test
        public void copy2(){
            int[] x = new int [] {1,3,5,7};
            int[] old = new int [] {1,3,5,7};
            int[] y = new int [] {1,3,4,5};
            assertArrayEquals(y,SortTools.copyAndInsert(x, 3,4));
            assertArrayEquals(x,old);
        }
        @Test
        public void copy3(){
            int[] x = new int [] {1,3,5,7};
            int[] old = new int [] {1,3,5,7};
            int[] y = new int [] {1,3,5,7,10};
            assertArrayEquals(y,SortTools.copyAndInsert(x, 4,10));
            assertArrayEquals(x,old);
        }
        @Test
        public void insertIn1(){
            int[] x = new int [] {1,3,5,7,9,11};
            assertEquals(5, SortTools.insertInPlace(x, 4, 2));
            assertTrue(SortTools.isSorted(x, 5));
        }
        @Test
        public void insertIn2(){
            int[] x = new int [] {1,3,5,7,9,11};
            assertEquals(4, SortTools.insertInPlace(x, 4, 3));
            assertTrue(SortTools.isSorted(x, 4));
        }
        @Test
        public void insertIn3(){
            int[] x = new int [] {1,3,5,7,9,11};
            assertEquals(5, SortTools.insertInPlace(x, 4, 13));
            assertTrue(SortTools.isSorted(x, 5));
        }
        @Test
        public void insertSort1(){
            int[] x = new int [] {7,3,1,3};
            SortTools.insertSort(x, 4);
            assertTrue(SortTools.isSorted(x,4));
        }
        @Test
        public void insertSort2(){
            int[] x = new int [] {1,3,3,7};
            SortTools.insertSort(x, 4);
            assertTrue(SortTools.isSorted(x,4));
        }
        @Test
        public void insertSort3(){
            int[] x = new int [] {7,3,1,3};
            SortTools.insertSort(x, 3);
            assertTrue(SortTools.isSorted(x,3));
        }


    }