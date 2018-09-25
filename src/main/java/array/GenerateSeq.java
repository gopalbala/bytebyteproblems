package array;

/**
 * Created by gbalasubramanian on 27/08/18.
 */
public class GenerateSeq {
    public static void main(String[] args) {
        generate(0, 0, 2);
    }

    static void generate(int prefix, int start, int n) {
        if (n == 0) {
            System.out.print(prefix + " ");
            return;
        } else {
            for (int i = start; i < 10; i++) {
                generate(10 * prefix + i, i + 1, n - 1);
            }
        }
    }
}
