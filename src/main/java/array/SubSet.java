package array;

/**
 * Created by gbalasubramanian on 27/08/18.
 */
public class SubSet {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(a[i] + " " + a[j]);
            }
        }
    }
}
