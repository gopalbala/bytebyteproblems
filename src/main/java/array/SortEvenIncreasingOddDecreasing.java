package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by gbalasubramanian on 25/09/18.
 */
public class SortEvenIncreasingOddDecreasing {
    public static void main(String[] args) {
        Integer[] num = {3, 1, 2, 4, 5, 9, 13, 14, 12};
        int j = 1;
        int n = num.length;
        for (int i = 2; i < n; i += 2) {

            swap(num, i, j);
            j += 1;
        }
        System.out.println(j);

        for (int i : num) {
            System.out.print(i + " ");
        }
        Arrays.sort(num, 0, 5);
        Arrays.sort(num, j , n - 1,Collections.reverseOrder());
        System.out.println();
        for (int i : num) {
            System.out.print(i + " ");
        }
    }



    static Integer[] swap(Integer[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return arr;
    }
}
