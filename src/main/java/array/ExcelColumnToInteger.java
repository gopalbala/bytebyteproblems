package array;

/**
 * Created by gbalasubramanian on 18/10/18.
 */
public class ExcelColumnToInteger {

    public static void main(String[] args) {
        System.out.println(colToInt("BA"));
        String cols = "BA";
        int iter = 0;
        int result = 0;
        char[] c = cols.toCharArray();
        for (int i = 0;i<cols.length();i++){
            result =  (26 * result) + (c[i] - 'A' + 1);
            iter++;
        }

        System.out.println(result);

        int idx = 0;
        String col = "BA";
        int target = 0;
        for (int i = 0; i < col.length(); i++) {
            target = (26 * target) + (col.charAt(i) - 'A' + 1);
//            idx++;
        }
//        for (char c : col.toCharArray()) {
//            target += (26*idx) + c - 'A';
//            idx++;
//        }
        System.out.println(target);
    }

    public static int colToInt(String col) {
        int res = 0;
        for (int i = 0; i < col.length(); i++) {
            res = (26 * res) + (col.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
