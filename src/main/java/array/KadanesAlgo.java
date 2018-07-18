package array;

/**
 * Created by gbalasubramanian on 21/04/18.
 */
public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
        int maxSoFar = arr[0];
        int maxEndingHere = 0;
        int start = 0, end = 0, s =0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
                start = s;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            }
        }
        System.out.println(maxSoFar);
        System.out.println("Start " + start + " End " + end);
    }
}
