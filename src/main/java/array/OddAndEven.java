package array;

import java.util.Arrays;

/**
 * Created by fax6 on 03/12/17.
 */
public class OddAndEven {
    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 4, 6, 8, 7, 12};
        System.out.println("Rearranging arrays using left and right indexes");
        arrA = arrange(arrA);
        System.out.println(Arrays.toString(arrA));
    }

    public static int[] arrange(int[] arrA) {
        int left = 0;
        int right = arrA.length - 1;

        while (left < right) {
            if (arrA[left] % 2 == 0)
                left++;
            else if (arrA[right] % 2 == 1)
                right--;
            else {
                //swap left and right elements
                int temp = arrA[left];
                arrA[left] = arrA[right];
                arrA[right] = temp;
                left++;
                right--;
            }
        }
        return arrA;
    }


}
