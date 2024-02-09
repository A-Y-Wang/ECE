package assignment1;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] array = {1, 7, 3, 4};
        boolean test = SortTools.isSorted(array, 2);
        if (test) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

        int[] poop = {1, 1, 3, 4};
        int answer = SortTools.insertInPlace(poop,2, 2 );
        System.out.println(poop);

    }

}
