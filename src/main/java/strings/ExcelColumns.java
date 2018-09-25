package strings;

/**
 * Created by gbalasubramanian on 26/08/18.
 */
public class ExcelColumns {
    public static void main(String[] args) {

        String s = "";
        for (int i =0; i<= 1000; i++)
             s = s+ printColumn(i)+", ";
        System.out.println(s);
    }


    public static String printColumn(int column) {
        column--;
        if (column >= 0 && column < 26) {
            return String.valueOf((char) ('A' + column));
        } else if (column > 25)
            return printColumn(column / 26) + printColumn(column % 26 + 1);
        else
            return "";
    }
}
