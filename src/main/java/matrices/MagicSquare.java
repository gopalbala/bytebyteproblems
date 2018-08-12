package matrices;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by gbalasubramanian on 08/08/18.
 */
public class MagicSquare {
    static int formingMagicSquare(int[][] s) {
        HashMap<Integer, Integer> rosum = new LinkedHashMap<>(s.length);
        HashMap<Integer, Integer> colsum = new LinkedHashMap<>(s[0].length);
        PriorityQueue<Integer> ar = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> ac = new PriorityQueue<>(Collections.reverseOrder());

        int diff = 0;
        for (int i = 0; i < s.length; i++) {
            int curRsum = 0;
            for (int j = 0; j < s[0].length; j++) {
                curRsum += s[i][j];

            }
            rosum.put(i, curRsum);
            ar.add(curRsum);
        }

        int i1 = 0, j1 = 0;
        while (i1 < s.length) {
            int curCsum = 0;
            for (j1 = 0; j1 < s.length; j1++) {
                curCsum += s[j1][i1];
            }
            colsum.put(i1, curCsum);
            ac.add(curCsum);
            i1++;
        }

        int rMax= ar.peek();
        int cMAx = ac.peek();

        j1=0;
        int count = 0;
        for (int i=0;i<s.length;i++) {
            int rodiff = rMax - rosum.get(i);
            if (rosum.get(i)+rodiff == colsum.get(i)+rodiff)
                count+=rodiff;
            else if(rosum.get(i)+rodiff == colsum.get(i))
                count+=rodiff;
        }

        for (int i=0;i<s[0].length;i++) {
            int colDiff = cMAx - colsum.get(i);
            if (colsum.get(i)+colDiff == rosum.get(i)+colDiff)
                count+=colDiff;
            else if(colsum.get(i)+colDiff == rosum.get(i))
                count+=colDiff;
        }

        System.out.println(count);

//        for (Map.Entry<Integer, Integer> entry : rosum.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//
//        for (Map.Entry<Integer, Integer> entry : colsum.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] s = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
        formingMagicSquare(s);
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int[][] s = new int[3][3];
//
//        for (int i = 0; i < 3; i++) {
//            String[] sRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 3; j++) {
//                int sItem = Integer.parseInt(sRowItems[j]);
//                s[i][j] = sItem;
//            }
//        }
//
//        int result = formingMagicSquare(s);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
