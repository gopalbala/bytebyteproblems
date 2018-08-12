package com.gb.bytebybyteproblems;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 28/09/17.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25};
        Arrays.sort(denominations);
        int min = change(32, denominations);
        System.out.println(min);
        min = changeDynamic(32, denominations);
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

    public static int changeDynamic(int x, int[] coins) {
        int[] cache = new int[x];
        for (int i = 1; i < x; i++) {
            cache[i] = -1;
        }
        return changeDynamic(x, coins, cache);
    }

    public static int changeDynamic(int x, int[] coins, int[] cache) {
        if (x == 0) return 0;

        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c;
                if (cache[x - coin] >= 0) c = cache[x - coin];
                else {
                    c = changeDynamic(x - coin, coins, cache);
                    cache[x - coin] = c;
                }
                if (min > c + 1) min = c + 1;
            }
        }
        return min;
    }
}
