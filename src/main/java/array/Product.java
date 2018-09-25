package array;

/**
 * Created by gbalasubramanian on 19/09/18.
 */
public class Product {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        for(int i=1;i<n;i++){
            left[i] = arr[i-1] * left[i-1];
        }

        for (int j=n-2;j>=0;j--){
            right[j] = arr[j+1] * right[j+1];
        }

        for (int i=0;i<n;i++){
            prod[i] = left[i] * right[i];
        }

        for (int i: prod){
            System.out.println(i);
        }
    }
}
