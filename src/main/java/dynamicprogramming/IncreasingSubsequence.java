package dynamicprogramming;

/**
 * @author gbalasubramanian
 */
public class IncreasingSubsequence {
    public static void main(String[] args) {
        int input[] = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        System.out.println(lis(input, input.length));
        System.out.println();

    }

    static int ceilIndex(int[] a, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (a[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    static int lis(int[] a, int size) {
        int[] t = new int[size];
        t[0] = a[0];
        int len = 1;

        for (int i = 1; i < size; i++) {
            if (a[i] < t[0])
                t[0] = a[i];
            else if (a[i] > t[len - 1])
                t[len++] = a[i];
            else
                t[ceilIndex(t, -1, len - 1, a[i])] = a[i];
        }
        return len;
    }
}
