package array;

/**
 * Created by gbalasubramanian on 21/04/18.
 */
public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
        int maxSoFar = arr[0];
        int maxEndingHere = 0;
        int start = 0, end = 0, s = 0;
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

        System.out.println();
        int[] arr1 = {1, 0, 1, 0, 0, 1};

        //swap01(arr1);

        countSteopsTo1();
    }

    private static void swap01(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] == 1) {
                int t = arr[low];
                arr[low] = arr[high];
                arr[high] = t;
                //low++;
                high--;
            } else {
                low++;
            }

        }
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void countSteopsTo1() {
        int n = 10;
        int[] steps = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int count1 = steps[i - 1];
            int count2 = Integer.MAX_VALUE;
            int count3 = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                count2 = steps[i / 3];
            } else if (i % 2 == 0) {
                count3 = steps[i / 2];
            }

            steps[i] = 1 + Math.min(count1, Math.min(count2, count3));

        }

        System.out.println(steps[n]);
    }
}
