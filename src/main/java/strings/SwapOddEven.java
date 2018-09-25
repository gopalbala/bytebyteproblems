package strings;

/**
 * Created by gbalasubramanian on 27/08/18.
 */
public class SwapOddEven {
    public static void main(String[] args) {
//        String s = "ABC";
//        permutate(s, 0, s.length() - 1);
        String s1= "abcd";
        String s2="cdab";
        String s3 = encodeString(s1);
        String s4 = encodeString(s2);
        System.out.println(s3 + ":" + s4);
    }


    static String encodeString(String str) {
        int[] hashEven = new int[26];
        int[] hashOdd = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i % 2 == 1) {
                hashOdd[c - 'a']++;
            } else {
                hashEven[c - 'a']++;
            }
        }
        String encoding = "";
        for (int i = 0; i < 26; i++) {
            encoding += String.valueOf(hashEven[i]);
            encoding += "-";
            encoding += String.valueOf(hashOdd[i]);
            encoding += "-";
        }
        return encoding;
    }

    static void permutate(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permutate(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    static String swap(String s, int pos, int pos1) {
        char[] c = s.toCharArray();
        char temp = c[pos];
        c[pos] = c[pos1];
        c[pos1] = temp;
        return String.valueOf(c);
    }


}
