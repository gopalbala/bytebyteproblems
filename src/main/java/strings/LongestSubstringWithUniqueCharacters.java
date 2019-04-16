package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gbalasubramanian on 31/12/18.
 */
public class LongestSubstringWithUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(longestString("CODINGISAWESOME"));
    }

    static String longestString(String input) {
        int start = 0;
        String output = "";
        Map<Character, Integer> visited = new HashMap<>();
        for (int end = 0; end < input.length(); end++) {
            if (visited.containsKey(input.charAt(end))) {
                start = Math.max(visited.get(input.charAt(end)) + 1, end);
            }
            if (output.length() < end - start + 1)
                output = input.substring(start, end + 1);
            visited.put(input.charAt(end), end);
        }
        return output;
    }
}
