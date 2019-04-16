package array;

/**
 * Created by gbalasubramanian on 18/10/18.
 */
public class StringZigZag {
    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 3);
        System.out.println(s);
        System.out.println(s.equals("PAHNAPLSIIGYIR"));
        //PPIINAASRGYLHI
        //PAHNAPLSIIGYIR
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder newChar = new StringBuilder(len);

        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < s.length(); i += (numRows + 1)) {

                if (i < s.length()) {
                    newChar.append(s.charAt(i));
                }
            }
        }
        return newChar.toString();
    }
}
