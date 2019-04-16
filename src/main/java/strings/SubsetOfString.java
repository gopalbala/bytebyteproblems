package strings;

/**
 * Created by fax6 on 05/12/17.
 */
public class SubsetOfString {
    public static void main(String[] args) {
        printSubsets("ABC");
    }
//1<<n is to raise to the power i<<3 = 8
// (1<<j) is a number with jth bit 1
    static void printSubsets(String s) {
        char[] chars = s.toCharArray();
        int n = s.length() ;
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println("1<<J:"+ (i& (1<<j)));
                if ((i & (1<<j)) > 0){

                    System.out.print(chars[j] +" ");
                }else {
                    System.out.print((i & (1<<j))+":");
                }
            }
            System.out.println();
        }
    }
}
