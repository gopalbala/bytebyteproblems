package array;

/**
 * Created by gbalasubramanian on 16/01/19.
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int point =  equilibriumPoint(arr);
        System.out.println(point);
    }

    static int equilibriumPoint(int[] arr) {
        int leftsum = 0, sum = 0;
        for (int i = 0 ; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (leftsum == sum)
                return i;
            leftsum += arr[i];
        }
        return -1;
    }
}
