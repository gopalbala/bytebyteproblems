package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gbalasubramanian on 23/10/17.
 */
public class ArrayDivisiblePair {
    public static void main(String[] args) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;
        System.out.println(checkPairs(arr, k));
    }

    static boolean checkPairs(int[] arr, int k) {
        if (arr.length % 2 == 1)
            return false;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % k;
            if (!hashMap.containsKey(remainder)) {
                hashMap.put(remainder, 1);
            } else {
                hashMap.put(remainder, hashMap.get(remainder) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }

        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % k;
            if (remainder * 2 == k) {
                //check in the has map for even occurances of such remainder
                if (hashMap.get(remainder) % 2 == 1) {
                    return false;
                } else if (remainder == 0) {
                    if (hashMap.get(remainder) % 2 == 1) {
                        return false;
                    }
                } else {
                    if (hashMap.get(k - remainder) != hashMap.get(remainder))
                        return false;
                }
            }
        }
        return true;
    }
}
