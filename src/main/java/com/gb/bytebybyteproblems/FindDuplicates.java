package com.gb.bytebybyteproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gbalasubramanian on 22/08/17.
 */
public class FindDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 1, 2, 3, 3, 4, 5, 6, 7, 4, 5}; //{2,1,2,1,2}; //{1, 2, 1, 2, 3, 3, 4, 5, 6, 7, 4, 5};
        List<Integer> output = findDuplicates(numbers);
        output.forEach(System.out::println);
    }

    private static List<Integer> findDuplicates(int[] numbers) {
        Set<Integer> output = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int index = Math.abs(numbers[i]) - 1;
            if (numbers[index] >= 0) {
                numbers[index] = -numbers[index];
            } else {
                output.add(Math.abs(numbers[i]));
            }
            //numbers[index] = numbers[index] >= 0 ? numbers[index] *= -1 : numbers[index];
        }
        for (int i=0;i<numbers.length;i++){
            numbers[i] = Math.abs(numbers[i]);
        }
        return new ArrayList<>(output);
    }
}
