package com.gb.bytebybyteproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gbalasubramanian on 30/08/17.
 */
public class ConsecutiveNumbers {
    public static void main(String[] args) {
        int[] inp = new int[]{5, 5, 3, 1};//{4, 2, 1, 6, 5};
        Set<Integer> inpSet = new HashSet<>();
        for (int i : inp) {
            inpSet.add(i);
        }
        int maxcount = 1;
        for (int i = 0; i < inp.length; i++) {
            int count = 1;
            int num = inp[i];
            num++;
            if (!inpSet.contains(num)) {
                continue;
            }

            while (inpSet.contains(num)) {
                count++;
                num++;
            }
            maxcount = Math.max(maxcount, count);
        }
        System.out.println(maxcount);
    }
}
