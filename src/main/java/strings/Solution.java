package strings;

import java.util.*;

/**
 * Created by gbalasubramanian on 28/04/18.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> strings1 = s.groupStrings(strings);
        System.out.println(strings1);
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        Arrays.sort(strings, new LexComparator());

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String s : strings) {
            StringBuffer sb = new StringBuffer();
            int distance = Character.getNumericValue(s.charAt(0)) - 'a';
            for (int i = 0; i < s.length(); i++) {
                int val = Character.getNumericValue(s.charAt(i)) - distance;
                val = val < 'a' ? val + 26 : val;
                char ori = (char) val;
                sb.append(ori);
            }
            String original = sb.toString();
            if (map.containsKey(original)) {
                List<String> list = map.get(original);
                list.add(s);
                map.put(original, list);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(original, list);
            }
        }

        // Iterate the map
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            result.add((List<String>) pair.getValue());
        }

        return result;
    }

    private class LexComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }
            return 0;
        }
    }
}
