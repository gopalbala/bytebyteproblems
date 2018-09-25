package array;

/**
 * Created by gbalasubramanian on 24/09/18.
 */
public class FindLowestMissingNumber {
    public static void main(String[] args) {
        int[] arr ={3, 4, -1, 1};
        int a = getLowestMissingNumber(arr);
        System.out.println(a);
    }

    static int getLowestMissingNumber(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr.length > 0 && arr[i] <= n) {
                arr[arr[i]-1]=1;
            }
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=1){
                return i+1;
            }
        }
        return arr.length+1;
    }
}
