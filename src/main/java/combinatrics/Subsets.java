package combinatrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbalasubramanian on 27/08/18.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        subsets(a, 3);
        List<List<Integer>> power = new ArrayList<>();
    }

    static void subsets(int[] arr, int n) {
        for (int i = 0; i < Math.pow(2, n); i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println(1<<j);
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
