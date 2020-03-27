package dynamicprogramming;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by fax6 on 06/12/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is "
                + lis(arr, n) + "n");

        System.out.println(l);

        //int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};

        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = a.length - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            System.out.print(a[i] + ", ");
            //System.out.println(index + ", ");
        }
        //{23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};
         printLcs(arr);
    }

    static int max_ref;
    static HashSet<Integer> l = new HashSet<>();

    static int _lis(int arr[], int n)
    {
        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively search all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
        for (int i = 1; i < n; i++)
        {
            res = _lis(arr, i);
            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here) {
                max_ending_here = res + 1;
                l.add(arr[n-1]);
                //System.out.print(arr[n-1] + ", ");
            }
        }

        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }

    // The wrapper function for _lis()
    static int lis(int arr[], int n)
    {
        // The max variable holds the result
        max_ref = 1;

        // The function _lis() stores its result in max
        _lis( arr, n);

        // returns max
        return max_ref;
    }

    static void printLcs(int[] arr) {
        int[] temp = new int[arr.length];
        int actualSolution[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = 1;
            actualSolution[i] = i;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (temp[j] + 1 > temp[i]) {
                        temp[i] = temp[j] + 1;//Math.max(arr[i], temp[i] + 1);
                        actualSolution[i] = j;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > temp[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + " " + temp[maxIndex]);

        int t = maxIndex;
        int newT = maxIndex;
        do {
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        } while (t != newT);
        System.out.println();

    }
}
