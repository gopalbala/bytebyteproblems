package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 26/03/18.
 */
public class EggDropping {
    public static void main(String[] args) {
        System.out.println("Eggs required for 8 floors and 4 eggs is:"+numberOdEggsRequired(8,4));
    }

    static int numberOdEggsRequired(int n, int k) {
        int result[][] = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i][1] = i;
        }
        for (int i = 0; i < k + 1; i++) {
            result[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
                result[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x < i; x++) {
                    int brokenEgg = result[x - 1][j - 1];
                    int unBrokenEgg = result[i - x][j];
                    int maxEggRequiredAtThisPlace = Math.max(brokenEgg, unBrokenEgg) + 1;
                    if (maxEggRequiredAtThisPlace < result[i][j]){
                        result[i][j] = maxEggRequiredAtThisPlace;
                    }
                }
            }
        }
        for (int[] a: result){
            System.out.println(Arrays.toString(a));
        }
        return result[n][k];
    }
}
