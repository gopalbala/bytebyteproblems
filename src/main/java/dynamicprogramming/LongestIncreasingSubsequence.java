package dynamicprogramming;

/**
 * Created by fax6 on 06/12/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
                //{23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};
        printLcs(arr);
    }

    static void printLcs(int[] arr) {
        int[] temp = new int[arr.length];
        int actualSolution[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = 1;
            actualSolution[i] = i;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (temp[j] + 1 > temp[i]) {
                        temp[i] = temp[j] + 1;//Math.max(arr[i], temp[i] + 1);
                        actualSolution[i] = j;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > temp[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println(maxIndex +" " +temp[maxIndex]);

        int t = maxIndex;
        int newT = maxIndex;
        do {
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        } while (t != newT);
        System.out.println();

    }
}
