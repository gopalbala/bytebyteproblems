package strings;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class StringPattern {
    public static void main(String[] args) {
        String input = "aaabbdcccccf";
        System.out.println(compressString(input));
    }

    static String compressString(String input) {
        int i = 1;
        int count = 1;
        String output = "";
        for (int j = 0; j < input.length(); j++) {
            if (i< input.length() && input.charAt(j) == input.charAt(i)) {
                count++;
            } else {
                output += input.charAt(i -1) + Integer.toString(count);
                count = 1;
            }
            i++;
        }
        return output;
    }
}
