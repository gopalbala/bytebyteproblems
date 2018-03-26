package array;

/**
 * Created by fax6 on 08/12/17.
 */
public class MaximumSum {
    public static void main(String[] args) {
        int arr[] = new int[]{6, 5, 10, 100, 11, 9};
        System.out.println(FindMaxSum(arr, arr.length));

    }

    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
