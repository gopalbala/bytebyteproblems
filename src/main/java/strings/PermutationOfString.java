package strings;

/**
 * Created by fax6 on 05/12/17.
 */
public class PermutationOfString {
    public static void main(String[] args) {
        String s = "[][]";//"ABC";
        permutate(s, 0, s.length() - 1);
    }

    static void permutate(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l , i);
                permutate(s, l+1, r);
                s = swap(s, l , i);
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
