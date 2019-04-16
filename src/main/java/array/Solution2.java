package array;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by gbalasubramanian on 29/11/18.
 */
public class Solution2 {
    public static String solution(int A, int B) {
        // write your code in Java SE 8
        String maxString, minString;
        int maxCount, minCount;
        if (A > B) {
            maxString = "a";
            maxCount = A;
            minString = "b";
            minCount = B;
        } else {
            maxString = "b";
            maxCount = B;
            minString = "a";
            minCount = A;
        }
        String result = "";

        while (maxCount > 0) {
            if (maxCount == minCount +1 ){
                result += maxString;
                maxCount --;
            } else if(maxCount == minCount){
                result += maxString;
                maxCount--;
                result+= minString;
                minCount--;
            } else {
                result+=maxString + maxString;
                maxCount = maxCount -2;
                if (minCount > 0){
                    result += minString;
                    minCount--;
                }
            }
        }

       return result;

    }

    static List<String> getString(List<String> stringList){
        ListIterator<String> listIterator = stringList.listIterator();
        listIterator.add("new");
        listIterator.forEachRemaining(s-> System.out.println(s));
        return null;
    }
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("old");

        List<String> s1 = getString(stringList);

        stringList.forEach(s-> System.out.println(s));

        System.out.println(solution(1,4));
    }
}
