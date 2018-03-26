package com.gb.bytebybyteproblems;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 02/09/17.
 */
public class TwoMissingNumbers {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 3, 1};
        int size = numbers.length + 2;

        long totalSum = size * (size + 1) / 2;

        System.out.println();
        long arraySum = 0;

        for (int i = 0; i < numbers.length; i++) {
            arraySum += numbers[i];
        }

        System.out.println();

        long diff = totalSum - arraySum;
        System.out.println("Diff: " + diff);
        long avg = diff / 2;
        System.out.println("Avg: " + avg);

        int leftXor = 0;
        int rightXor = 0;
        for (int i = 1; i <= avg; i++) {
            leftXor ^= i;
        }

        for (int i = (int) (avg + 1); i <= size; i++) {
            rightXor ^= i;
        }
        System.out.println("left xor: " + leftXor);
        System.out.println("right xor: " + rightXor);

        int arrLeftXor = 0, arrRightXor = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= avg)
                arrLeftXor ^= numbers[i];
            else
                arrRightXor ^= numbers[i];
        }

        int firstMissing = leftXor ^ arrLeftXor;
        int secondMissing = rightXor ^ arrRightXor;

        System.out.println("FistMissing: " + firstMissing + " SecondMissing: " + secondMissing);


    }
}
