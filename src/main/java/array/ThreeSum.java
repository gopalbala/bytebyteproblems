package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by gbalasubramanian on 19/09/18.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        HashSet<Integer> integerHashSet= new HashSet<>();
        for (int i: arr){
            integerHashSet.add(i);
        }
        int n = arr.length;
        for (int i =0; i< n-2;i++){
            int currSum = sum - arr[i];
            for (int j=i+1;j<n-1;j++){
                if (integerHashSet.contains(currSum - arr[j])){
                    System.out.println(arr[i] +":" +arr[j] + ":" + (currSum - arr[j]));
                }
            }
        }
    }
}
