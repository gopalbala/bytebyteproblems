package com.gb.bytebybyteproblems;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 28/09/17.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25};
        Arrays.sort(denominations);
        int min = change(32,denominations);
        System.out.println(min);
    }

    public static int change(int amount, int[] coins) {
        if (amount == 0)
            return 0;
        int min = amount;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int ch = change(amount - coin, coins);
                if (min > ch + 1)
                    min = ch + 1;
            }
        }
        return min;
    }
}
