package dynamicprogramming;

/**
 * Created by gbalasubramanian on 21/03/18.
 */
public class MinimumJumps {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 1, 0, 9};//{1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, 0, n));
    }

    private static int minJumps(int[] arr, int start, int length) {
        if (start == length)
            return 0;
        if (arr[start] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i <= length && i <= start + arr[start]; i++) {
            int jumps = minJumps(arr, i, length);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1;
            }
        }
        return min;
    }

    static int minJumps1(int arr[], int l, int h)
    {
        // Base case: when source
        // and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable
        // from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l+1; i <= h && i <= l + arr[l]; i++)
        {
            int jumps = minJumps1(arr, i, h);
            if(jumps != Integer.MAX_VALUE &&
                    jumps + 1 < min)
                min = jumps + 1;

        }
        return min;

    }
}
