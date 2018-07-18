package dynamicprogramming;

/**
 * Created by gbalasubramanian on 30/04/18.
 */
public class Lis {
    public static void main(String[] args) {
        int input[] = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        //{3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        Lis lis = new Lis();
        System.out.println("Maximum length " + lis.lis(input));
    }

    private int ceilIndex(int[] input, int[] t, int end, int s) {
        int start = 0;
        int middle;
        int len = end;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle < len && input[t[middle]] < s && s <= input[t[middle + 1]]) {
                return middle + 1;
            } else if (input[t[middle]] < s) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public int lis(int[] input) {
        int t[] = new int[input.length];
        int r[] = new int[input.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = -1;
        }
        t[0] = 0;
        int len = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[t[0]] > input[i]) {
                t[0] = i;
            } else if (input[t[len]] < input[i]) {
                len++;
                t[len] = i;
                r[t[len]] = t[len - 1];
            } else {
                int index = ceilIndex(input, t, len, input[i]);
                t[index] = i;
                r[t[index]] = t[index - 1];
            }
        }
        System.out.println("Longest increasing subsequence");
        int index = t[len];
        while (index != -1) {
            System.out.print(input[index] + " ");
            index = r[index];
        }
        System.out.println();
        return len + 1;
    }
}
