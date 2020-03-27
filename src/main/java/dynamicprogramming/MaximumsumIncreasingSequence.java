package dynamicprogramming;

/**
 * Created by gbalasubramanian on 19/06/18.
 */
public class MaximumsumIncreasingSequence {
    static int maxSumIS(int arr[], int n) {
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values for all indexes */
        for (i = 0; i < n; i++)
            msis[i] = arr[i];

        /* Compute maximum sum values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                        msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];

        /* Pick maximum of all msis values */
        for (i = 0; i < n; i++)
            if (max < msis[i])
                max = msis[i];

        for (i = 0; i < n; i++) {
            System.out.print(msis[i] + " ");
        }
        return max;

    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = new int[]{3, 10, -20, -5, 2};//{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing " +
                " subsequence is " +
                maxSumIS(arr, n));
    }
}
