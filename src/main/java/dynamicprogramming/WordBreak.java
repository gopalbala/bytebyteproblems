package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gbalasubramanian on 18/10/18.
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("I");
        stringList.add("love");
        stringList.add("loveIndia");
        boolean b = wordBreak("IloveIndia", stringList);
        System.out.println(b);
    }

    public static boolean wordBreak(String input, List<String> dict) {
        Set<String> wordDict = new HashSet<>(dict);
        int len = input.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j]) {
                    if (wordDict.contains(input.substring(j, i + 1)))
                        dp[i + 1] = true;
                }
            }
        }
        return dp[len];
    }
}
