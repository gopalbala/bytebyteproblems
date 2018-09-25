package array;

import java.util.*;

/**
 * Created by gbalasubramanian on 23/09/18.
 */
public class LargestNumberFormedFromArray {
    public static void main(String[] args) {
        int[] inp = {1, 34, 3, 98, 9, 76, 45, 4};
        List<String> stringList = new ArrayList<>(inp.length);
        for (int i:inp){
            stringList.add(String.valueOf(i));
        }
        printLargest(stringList);
    }

    static void printLargest(List<String> inp) {
        Collections.sort(inp, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String o3 = o1 + o2;
                String o4 = o2 + o1;
                return o4.compareTo(o3);
            }
        });

        for (String str : inp) {
            System.out.print(str);
        }
    }
}
