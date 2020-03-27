package array;

import java.util.ArrayList;

/**
 * Created by gbalasubramanian on 28/07/18.
 */
public class RemoveAdjacentCharacters {
    static String dedup(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                str = str.substring(0, i) + str.substring(i + 2);
                return dedup(str);
            }
        }
        return str;

    }

    public static void main(String[] args) {
        String str = "geeksforgeeg";
        str = dedup(str);
        System.out.println(str);

    }
}
