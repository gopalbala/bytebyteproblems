package array;

/**
 * Created by gbalasubramanian on 21/09/18.
 */
public class ElementLeftLessRightGreater {
    public static void main(String[] args) {
        int[] num = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int n = num.length;
        int[] leftMmax = new int[n];
        int[] rightMin = new int[n];
        leftMmax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMmax[i] = Math.max(num[i - 1], leftMmax[i - 1]);
        }
        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], num[i + 1]);
        }
        for (int i = n - 1; i > 0; i--) {
            if (leftMmax[i] < num[i] && rightMin[i] > num[i]) {
                System.out.println(i);
                break;
            }
        }

    }
}
