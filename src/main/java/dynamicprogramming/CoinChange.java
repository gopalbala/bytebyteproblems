package dynamicprogramming;

/**
 * Created by gbalasubramanian on 28/07/18.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25};
        System.out.println(change(denominations, 30));
    }

    static int change(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int min = amount;
        for (int i : coins) {
            if (amount - i >= 0) {
                int chg = change(coins, amount - i);
                if (min > chg + 1)
                    min = chg + 1;
            }
        }
        return min;
    }

    public static int changeDynamic(int x, int[] coins) {
        int[] cache = new int[x];
        for (int i = 1; i < x; i++) {
            cache[i] = -1;
        }
        return dpChange(coins, x, cache);
    }

    static int dpChange(int[] coins, int amount, int[] cache) {
        if (amount == 0)
            return 0;
        int min = amount;
        for (int i : coins) {
            if (amount - i > 0) {
                int c;
                if (cache[amount - i] >= 0 ){
                    //c =
                }
            }
        }
        return 0;
    }
}
