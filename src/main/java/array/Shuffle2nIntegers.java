package array;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class Shuffle2nIntegers {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        shuffleArray(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void shuffleArray(int[] arr, int f, int l) {
        if (l - f == 1)
            return;
        int mid = (f + l) / 2;
        //System.out.print(mid + " ");
        int temp = mid + 1;
        int mmid = (f + mid) / 2;
        System.out.print(mmid + "\n");
        for (int i = mmid + 1; i <= mid; i++) {
            int temp1 = arr[i];
            arr[i] = arr[temp];
            arr[temp++] = temp1;
            //temp++;
        }
        shuffleArray(arr, f, mid);
        shuffleArray(arr, mid + 1, l);
        System.out.println(Arrays.toString(arr));
    }
}
