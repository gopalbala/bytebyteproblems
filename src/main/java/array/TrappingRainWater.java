package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gbalasubramanian on 23/09/18.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 3, 0, 5};//{0, 1, 0, 2, 1, 0, 1,
        //3, 2, 1, 2, 1};
        int low = 0, high = arr.length - 1;
        int leftmax = 0, rightMax = 0;
        int result = 0;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > leftmax) {
                    leftmax = arr[low];
                } else
                    result = result + leftmax - arr[low];
                low++;
            } else {
                if (arr[high] > rightMax) {
                    rightMax = arr[high];
                } else
                    result = result + rightMax - arr[high];
                high--;

            }
        }
        System.out.println(result);
        int[] inp = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : inp) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        LinkedHashMap<Integer, Integer> linkedHashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((e1, e2) -> e2 - e1)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}
