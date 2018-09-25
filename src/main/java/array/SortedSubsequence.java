package array;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbalasubramanian on 12/08/18.
 */
public class SortedSubsequence {
    static void findThreeNumbers(int[] arr) {
        int n = arr.length;
        int max = n - 1;
        int min = 0;
        int i;
        int[] smaller = new int[n];
        smaller[0] = -1;
        for (i = 0; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }
        int[] greater = new int[n];
        greater[n - 1] = -1;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }
        for (i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.println(arr[smaller[i]] + " " + arr[i] + " " + arr[greater[i]]);
                return;
            }
        }
    }

    public static void main(String[] args) {

        List<TreeNode> treeNodes = new ArrayList<>();

       // System.out.println(treeNodes.remove());

        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        findThreeNumbers(arr);
    }
}
