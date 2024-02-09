package assignment1;

//how to submit

public class SortTools {
    /**
      * Return whether the first n elements of x are sorted in non-decreasing
      * order.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if first n elements of array is sorted
      */
    public static boolean isSorted(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
        int length = x.length;
        if (n==0 || length==0){
            return true;
        }
        for (int i = 0; i<n-1; i++){
            if (x[i] <= x[i+1]){
               //partayy
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * Return an index of value v within the first n elements of x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for
     * @return any index k such that k < n and x[k] == v, or -1 if no such k exists
     */
    public static int find(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        //it is sorted up to nth length
        //which index has the element that equates to
        int min = 0;
        int max = n-1;

        while (min<=max){
            /*if (max<min){
                return -1;
            }*/
            int mid = (max+min)/2;
            if (x[mid] == v){
                return mid;
            }
            else if (x[mid] < v){
                min = mid+1;
            }
            else if (x[mid] > v){
                max = mid-1;

            }
        }

        return -1;
    }

    /**
     * Return a sorted, newly created array containing the first n elements of x
     * and ensuring that v is in the new array.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array if necessary
     * @return a new array containing the first n elements of x as well as v
     */
    public static int[] copyAndInsert(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        int[] r_array;
        int array_length = n;
        int expand = 1;
        for (int i = 0; i<n; i++) {
            if (x[i] == v) {
                expand = 0;
                break;
            }
        }
        if (expand == 1){
            array_length++;
            r_array = new int[array_length];
        }
        else {
            r_array = new int[array_length];
        }
        int j = 0;
        int flag = 1;
        for (int i = 0; i<array_length; i++) {
            if (flag == 0 || array_length == n) {
                r_array[i] = x[j];
                j++;
            }
            else if (j == n){
                r_array [i] = v;
                break;
            }
            else if (x[j] < v ) {
                r_array[i] = x[j];
                j++;
            }
                /*else if (x[j] == v && flag == 1 ) {
                    flag = 0;
                    r_array[i] = x[j];
                    j++;
                }*/
            else if (v<x[j]){
                r_array[i] = v;
                flag = 0;
            }
        }
        return r_array;
    }

    /**
     * Insert the value v in the first n elements of x if it is not already
     * there, ensuring those elements are still sorted.
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v) {
        // stub only, you write this!
        // TODO: complete it
        // create mulitple for loops just not nested   {1,2,4,5} v=3
        int[] placeholder = new int[n];
        int index = 0;
        int flag = 1;
        int too_big = 1;
        for (int i = 0; i<n; i++){
            placeholder[i] = x[i];
            if (x[i] == v){
                return n;
            }
            if (x[i] > v && flag == 1){
                index = i;
                flag = 0;
                too_big = 0;
            }
        }
        if (too_big == 0){
            x[index] = v;
        }
        else if (too_big == 1) {
            x[n] = v;
            return n+1;
        }
        for (int j = index+1; j<n+1; j++){
            x[j] = placeholder[index];
            index++;
        }
        return n+1;
    }

    /**
     * Sort the first n elements of x in-place in non-decreasing order using
     * insertion sort.
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n) {
        // stub only, you write this!
        // TODO: complete it
        for (int i = 1; i<n; i++){
            int reference = x[i];
            int j = i - 1;

            while (j>=0 && x[j]>reference){
                x[j+1] = x[j];
                j--;
            }
            x[j+1] = reference;
        }
    }
}
