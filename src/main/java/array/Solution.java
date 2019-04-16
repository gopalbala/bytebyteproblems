package array;

import dynamicprogramming.Lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gbalasubramanian on 29/11/18.
 */
class Solution1 {
    public static String solution(int[] T) {
        // write your code in Java SE 8
        if (T.length == 0)
            return "";
        final int numSeasons = 4;
        int tempRecordedPerSeason = T.length / numSeasons;
        List<Integer> season = new ArrayList<>();
        int currentMin = T[0];
        int currentMax = T[0];
        for (int i = 0; i < T.length; i++) {
            if (T[i] < currentMin)
                currentMin = T[i];
            if (T[i] > currentMax)
                currentMax = T[i];
            if ((i + 1) % tempRecordedPerSeason == 0) {
                season.add(currentMax - currentMin);
            }
        }

        int max = season.get(0);
        int maxIndex = 0;
        for (int i = 1; i < season.size(); i++) {
            if (season.get(i) > season.get(maxIndex))
                maxIndex = i;
        }

        switch (maxIndex) {
            case 0:
                return "WINTER";
            case 1:
                return "SPRING";
            case 2:
                return "SUMMER";
            case 3:
                return "AUTUMN";
        }
        return null;
    }

    public static void main(String[] args) {
        //int[] arr = {2, 1, 1, 10, 2, 13, 3, -18};
        int[] arr = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(solution(arr));


    }

}